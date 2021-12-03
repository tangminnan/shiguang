package com.shiguang.common.utils;

public class Chuank {
    public static void main(String[] args) {
//        System.out.println("启动了！！！");
//        System.out.println("长度!!!"+args.length);
        // 实例化串口操作类对象
        SerialPortUtils serialPort = SerialPortUtils.getSerialPortUtils();
        // 关闭串口
        if (args.length == 4){
//            System.out.println("到这了");
            serialPort.closeSerialPort();
            return;
        }
        // 创建串口必要参数接收类并赋值，赋值串口号，波特率，校验位，数据位，停止位
        ParamConfig paramConfig = new ParamConfig("COM3", 9600, 0, 8, 1);
        // 初始化设置,打开串口，开始监听读取串口数据
        serialPort.init(paramConfig);
        // 调用串口操作类的sendComm方法发送数据到串口
        //serialPort.sendComm("FEF10A000000000000000AFF");
    }
}
