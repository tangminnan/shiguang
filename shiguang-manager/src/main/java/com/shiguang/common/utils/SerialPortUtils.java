package com.shiguang.common.utils;

import com.shiguang.logstatus.domain.JDJInfoDO;
import com.shiguang.logstatus.domain.JdjInfomationDO;
import com.shiguang.logstatus.domain.LensMeterDO;
import com.shiguang.logstatus.service.LensMeterService;
import com.shiguang.optometry.controller.SerialDataUtils;
import com.shiguang.optometry.service.OptometryService;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;


/**
 * 串口参数的配置 串口一般有如下参数可以在该串口打开以前进行配置： 包括串口号，波特率，输入/输出流控制，数据位数，停止位和奇偶校验。
 */
// 注：串口操作类一定要继承SerialPortEventListener
public class SerialPortUtils implements SerialPortEventListener {
    // 检测系统中可用的通讯端口类
    private CommPortIdentifier commPortId;
    private LensMeterService lensMeterService = (LensMeterService) SpringUtil.getBean("lensMeterServiceImpl");
    // 枚举类型
    private Enumeration<CommPortIdentifier> portList;
    @Autowired
    private OptometryService optometryService;
    // RS232串口
    private SerialPort serialPort;
    public static SerialPortUtils serialPort1 = null;

    private SerialPortUtils() {
    }

    public static SerialPortUtils getSerialPortUtils() {
        if (serialPort1 == null) {
            serialPort1 = new SerialPortUtils();
        }
        return serialPort1;
    }
    // 输入流
    private InputStream inputStream;
    // 输出流
    private OutputStream outputStream;
    // 保存串口返回信息
    private String data;
    // 保存串口返回信息十六进制
    private String dataHex;
    private SerialDataUtils serialDataUtils = SerialDataUtils.getSerialPortUtils();
    private byte[] byteArray = null;
    int a=1;
    String id;

    /**
     * 初始化串口
     *
     * @throws
     * @param: paramConfig  存放串口连接必要参数的对象（会在下方给出类代码）
     * @return: void
     */
    @SuppressWarnings("unchecked")
    public void init(ParamConfig paramConfig) {
        a=1;
        id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUserId();
        // 获取系统中所有的通讯端口
        portList = CommPortIdentifier.getPortIdentifiers();
        // 记录是否含有指定串口
        boolean isExsist = false;
        // 循环通讯端口
        while (portList.hasMoreElements()) {
            commPortId = portList.nextElement();
            // 判断是否是串口
            if (commPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                // 比较串口名称是否是指定串口
//                if (paramConfig.getSerialNumber().equals(commPortId.getName())) {
                // 串口存在
                isExsist = true;
                // 打开串口
                try {
                    // open:（应用程序名【随意命名】，阻塞时等待的毫秒数）
                    serialPort = (SerialPort) commPortId.open(Object.class.getSimpleName(), 2000);
                    // 设置串口监听
                    serialPort.addEventListener(this);
                    // 设置串口数据时间有效(可监听)
                    serialPort.notifyOnDataAvailable(true);
                    // 设置串口通讯参数:波特率，数据位，停止位,校验方式
                    serialPort.setSerialPortParams(paramConfig.getBaudRate(), paramConfig.getDataBit(),
                            paramConfig.getStopBit(), paramConfig.getCheckoutBit());
                } catch (Exception e) {
                    System.out.println("端口被占用");
                }
                // 结束循环
                break;
//                }
            }
        }
        // 若不存在该串口则抛出异常
        if (!isExsist) {
            System.out.println("不存在该串口！");
        }
    }

    /**
     * 实现接口SerialPortEventListener中的方法 读取从串口中接收的数据
     */
    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI: // 通讯中断
            case SerialPortEvent.OE: // 溢位错误
            case SerialPortEvent.FE: // 帧错误
            case SerialPortEvent.PE: // 奇偶校验错误
            case SerialPortEvent.CD: // 载波检测
            case SerialPortEvent.CTS: // 清除发送
            case SerialPortEvent.DSR: // 数据设备准备好
            case SerialPortEvent.RI: // 响铃侦测
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 输出缓冲区已清空
                break;
            case SerialPortEvent.DATA_AVAILABLE: // 有数据到达
                // 调用读取数据的方法
                readComm();
                break;
            default:
                break;
        }
    }

    /**
     * 读取串口返回信息
     *
     * @return: void
     */
    public void readComm() {
        try {
            JdjInfomationDO jdjInfomationDO = new JdjInfomationDO();
            StringBuilder builder = new StringBuilder();
            inputStream = serialPort.getInputStream();
            // 通过输入流对象的available方法获取数组字节长度
            byte[] readBuffer = new byte[inputStream.available()];
            byteArray = SpringUtil.decode2(readBuffer,byteArray);
//            System.out.println(bytesToHexString(readBuffer));
            int len = 0;
            while ((len = inputStream.read(readBuffer)) != -1) {
                dataHex = bytesToHexString(readBuffer);
                builder.append(dataHex);
                //System.out.println("dataHex结果:" + dataHex);// 读取后置空流对象
                inputStream.close();
                inputStream = null;
                break;
            }
//            System.out.println("当前a="+a);
//            System.out.println("当前登录账号："+id);
            if (a==1){
                a=a+1;
                jdjInfomationDO.setId(Long.valueOf(id));
                jdjInfomationDO.setCompanyId(ShiroUtils.getUser().getCompanyId());
                jdjInfomationDO.setRemark1(dataHex);
                lensMeterService.saveJdjInfomation(jdjInfomationDO);
            } else if(a==2){
                a=a+1;
                jdjInfomationDO.setRemark2(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 3){
                a=a+1;
                jdjInfomationDO.setRemark3(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 4){
                a=a+1;
                jdjInfomationDO.setRemark4(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 5){
                a=a+1;
                jdjInfomationDO.setRemark5(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 6){
                a=a+1;
                jdjInfomationDO.setRemark6(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 7){
                a=a+1;
                jdjInfomationDO.setRemark7(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 8){
                a=a+1;
                jdjInfomationDO.setRemark8(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 9){
                a=a+1;
                jdjInfomationDO.setRemark9(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 10){
                a=a+1;
                jdjInfomationDO.setRemark10(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            } else if (a == 11){
                a=a+1;
                jdjInfomationDO.setRemark11(dataHex);
                //String id = ShiroUtils.getUser().getCompanyId()+ShiroUtils.getUser().getUsername();
                jdjInfomationDO.setId(Long.valueOf(id));
                lensMeterService.updateJdjInfomation(jdjInfomationDO);
            }

//            System.out.println("结果:="+builder);
//            byteArray = SpringUtil.decode2(readBuffer,byteArray);
//            int len = 0;
//            while ((len = inputStream.read(readBuffer)) != -1) {
//                byteArray = SpringUtil.decode2(readBuffer,byteArray);
//                System.out.println(byteArray);
//            }
//            System.out.println(bytesToHexString(readBuffer));
            //Message message = Message.obtain();
            //message.what = 1;
            //handler.removeMessages(1);
            //handler.sendMessageDelayed(message,1000);
        } catch (IOException e) {
            serialPort1.closeSerialPort();
            System.out.println("读取串口数据时发生IO异常");
        }
    }

//    public Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case 1:
//                    String ss =bytesToHexString(byteArray);
//                    JDJInfoDO jdjInfoDO = new JDJInfoDO();
//                    jdjInfoDO.setJdjInfo(ss);
//                   //lensMeterService.saveJdj(jdjInfoDO);
//                    byteArray = null;
//                    break;
//            }
//        }
//    };


    /**
     * 读取串口返回的信息
     */
    public void sendToData(){
        String ss =bytesToHexString(byteArray);
        System.out.println("解析完="+ss);
        //String lizi = "01444C4D0249444E4944454B2F4C4D2D363030501720522D30322E32352B30302E303030303017505230302E30304917505230302E30305517204C2D30312E37352B30302E303030303017504C30302E30304F17504C30302E303055170431333441";
//        dataSerial = hexStringToString(dataSerial);
//        serialDataUtils.todataJdj(dataSerial);
        //serialDataUtils.todataJdj(lizi);
    }

    /**
     * 发送信息到串口
     *
     * @throws
     * @param: data
     * @return: void
     */
    public void sendComm(String data) {
        byte[] writerBuffer = null;
        try {
            writerBuffer = hexToByteArray(data);
        } catch (NumberFormatException e) {
            System.out.println("命令格式错误！");
        }
        try {
            outputStream = serialPort.getOutputStream();
            outputStream.write(writerBuffer);
            outputStream.flush();
        } catch (NullPointerException e) {
            System.out.println("找不到串口。");
        } catch (IOException e) {
            System.out.println("发送信息到串口时发生IO异常");
        }
    }

    /**
     * 关闭串口
     *
     * @throws
     * @Description: 关闭串口
     * @param:
     * @return: void
     */
    public void closeSerialPort() {
        if (serialPort != null) {
            serialPort.notifyOnDataAvailable(false);
            serialPort.removeEventListener();
            if (inputStream != null) {
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    System.out.println("关闭输入流时发生IO异常");
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    outputStream = null;
                } catch (IOException e) {
                    System.out.println("关闭输出流时发生IO异常");
                }
            }
            serialPort.close();
            serialPort = null;
        }
    }

    /**
     * 十六进制串口返回值获取
     */
    public String getDataHex() {
        String result = dataHex;
        // 置空执行结果
        dataHex = null;
        // 返回执行结果
        return result;
    }

    /**
     * 串口返回值获取
     */
    public String getData() {
        String result = data;
        // 置空执行结果
        data = null;
        // 返回执行结果
        return result;
    }

    /**
     * Hex字符串转byte
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * hex字符串转byte数组
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            // 奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            // 偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    /**
     * 数组转换成十六进制字符串
     *
     * @param
     * @return HexString
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {
//        String aa = "01444C4D0249444E49";
//        String bb = "44454B2F4C4D2D3630";
//        String cc = "30501720522D30322E";
//        String dd = "32352B30302E303030303017505230302E";
//        String ee = "30304917505230302E";
//        String ff = "30305517204C2D3031";
//        String gg = "2E37352B30302E3030";
//        String hh = "30303017504C30302E";
//        String ii = "30304F17504C3030";
//        String kk = "2E303055170431333441";
//        StringBuffer ss = new StringBuffer();
//            ss.append(aa);
//            ss.append(bb);
//            ss.append(cc);
//            ss.append(dd);
//            ss.append(ee);
//            ss.append(ff);
//            ss.append(gg);
//            ss.append(hh);
//            ss.append(ii);
//            ss.append(kk);
//        lizi=  aa +bb +cc+dd +ee +ff+gg+hh+ii+kk;
//        System.out.println(SerialPortUtils.lizi);
        //this.readComms(SerialPortUtils.lizi);
        //System.out.println(SerialPortUtils.dataBuffer);
//        String string ="DLM\u0002IDNIDEK/LM-7P\u0017DA2021.10.20.16:45\u0017 R+03.78-00.52118\u0017PR00.02O\u0017PR00.09U\u0017 L+03.77-00.51118\u0017PL00.02I\u0017PL00.09U\u0017\u000416E7";
//        System.out.println(string.substring(39, 40));
//        System.out.println(string.substring(41, 45));
//        System.out.println(string.substring(45, 46));
//        System.out.println(string.substring(47, 51));
//        System.out.println(string.substring(51, 54));
//        System.out.println(string.substring(36, 38));
//        System.out.println(string.substring(75, 76));
//        System.out.println(string.substring(77, 81));
//        System.out.println(string.substring(81, 82));
//        System.out.println(string.substring(83, 87));
//        System.out.println(string.substring(87, 90));
    }

//    public static void main(String[] args) {
//        String aa = "01444C4D0249444E49";
//        String bb = "44454B2F4C4D2D3630";
//        String cc = "30501720522D30322E";
//        String dd = "32352B30302E303030303017505230302E";
//        String ee = "30304917505230302E";
//        String ff = "30305517204C2D3031";
//        String gg = "2E37352B30302E3030";
//        String hh = "30303017504C30302E";
//        String ii = "30304F17504C3030";
//        String kk = "2E303055170431333441";
//        StringBuffer ss = new StringBuffer();
//        for (int i=0;i<2;i++){
//            ss.append(aa);
//            ss.append(bb);
//            ss.append(cc);
//            ss.append(dd);
//            ss.append(ee);
//            ss.append(ff);
//            ss.append(gg);
//            ss.append(hh);
//            ss.append(ii);
//            ss.append(kk);
//            dataBuffer.append(aa);
//        }
//        System.out.println(dataBuffer);
//        System.out.println(ss);
//        String string = "\u0001DLM\u0002IDNIDEK/LM-600P\u0017 R-06.50-01.50010\u0017PR00.00I\u0017PR00.00U\u0017 L-05.75-01.50179\u0017PL00.00O\u0017PL00.00U\u0017\u00041372";
        //System.out.println(string);
//    String string ="DLM\u0002IDNIDEK/LM-7P\u0017DA2021.10.20.16:45\u0017 R+03.78-00.52118\u0017PR00.02O\u0017PR00.09U\u0017 L+03.77-00.51118\u0017PL00.02I\u0017PL00.09U\u0017\u000416E7";
//        System.out.println(string.substring(22, 23));
//        System.out.println(string.substring(25, 29));
//        System.out.println(string.substring(31, 35));
//        System.out.println(string.substring(36, 38));
//        System.out.println(string.substring(58, 59));
//        System.out.println(string.substring(61, 65));
//        System.out.println(string.substring(67, 71));
//        System.out.println(string.substring(71, 75));
//    }
        //BleDataBean bleDataBean = SerialDataUtils.toOptometry(string);
        //System.out.println(bleDataBean.toString());

//        String str ="吉林省,山东省,北京市";
//        String str1=str.substring(0, str.indexOf(","));
////        //获得第一个点的位置
////        int index=str.indexOf(",");
////        System.out.println(index);
//////        //根据第一个点的位置 获得第二个点的位置
//////        index=str.indexOf(".", index+1);
////        //根据第二个点的位置，截取 字符串。得到结果 result
////        String result=str.substring(index);
//        //输出结果
//        System.out.println(str1);

//    }

}
