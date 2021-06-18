package com.shiguang.optometry.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.shiguang.common.utils.Intrinsics;
import com.shiguang.common.utils.SpringUtil;
import com.shiguang.optometry.domain.*;
import org.apache.commons.io.Charsets;


public class SerialDataUtils {


//    private BloodPressureService bloodPressureService = (BloodPressureService) SpringUtil.getBean("bloodPressureServiceImpl");
//
//    private HeightweightDao heightweightDao = (HeightweightDao) SpringUtil.getBean("heightweightDao");
//
//    private EyePressureDao eyePressureDao = (EyePressureDao) SpringUtil.getBean("eyePressureDao");

    public static SerialDataUtils serialDataUtils = null;

    private SerialDataUtils() {
    }

    public static SerialDataUtils getSerialPortUtils() {
        if (serialDataUtils == null) {
            serialDataUtils = new SerialDataUtils();
        }
        return serialDataUtils;
    }

    /**
     * 控制字符
     */
    private static int SOH = 0x01;//报头开始
    private static int STX = 0x02;//正文开始

    /**
     * 验光设备三种报头
     */
    private static byte[] drm = new byte[]{100, 114, 109};//drm
    private static byte[] Drm = new byte[]{68, 114, 109};//drm
    private static byte[] DRM = new byte[]{68, 82, 77};//DRM
    private static byte[] DKM = new byte[]{68, 75, 77};//DKM
    private static byte[] OL = new byte[]{79, 76};
    private static byte[] OR = new byte[]{79, 82};
    private static byte[] PL = new byte[]{80, 76};
    private static byte[] PR = new byte[]{80, 82};
    private static byte[] DL = new byte[]{68, 76};
    private static byte[] DR = new byte[]{68, 82};
    private static byte[] L = new byte[]{32, 76};
    private static byte[] R = new byte[]{32, 82};
    private static byte[] SL = new byte[]{83, 76};
    private static byte[] SR = new byte[]{83, 82};
    private static byte[] VD = new byte[]{86, 68};
    private static byte[] PD = new byte[]{80, 68};
    private static byte[] DNT = new byte[]{0x44, 0x4E, 0x54};//DNT
    private static byte[] AV = new byte[]{0x41, 0x56};//AV


    /**
     * 验光
     */
    private static boolean isdrm = false; //drm协议 验光
    private static boolean isDRM = false; //DRM协议 验光
    private static boolean isDKM = false; //DKM协议 验光
    /**
     * 判断是否为包头
     */
    private static boolean isBT = false;
    private static String type = "";

    /**
     * 判断是那种条件类型
     *
     * @param data
     * @return
     */
//    public void toData(String data) {
//        if (!isBT) {
//            if (data.contains("53204E6F3D303030303020")) {
//                isBT = true;
//                type = "isOptometry";
//                return;
//            }
//            if (data.length() == 9) {
//                String isHW = CodeUtil.ascii2String(ByteUtils.hexStr2Byte(data));
//                GetCheckBean.HeightAndWeight tohw = tohw(isHW);
//                heightweightDao.lsSave(tohw);
//                return;
//            }
//            String s = CodeUtil.ascii2String(ByteUtils.hexStr2Byte(data));
//            if (s.contains("bp")) {
//                isBT = true;
//                type = "isBlood";
//                return;
//            }
//            byte[] bytes = data.getBytes();//获得byte数组
////        byte[] bytes = ByteUtils.hexStr2Byte(data);//获得byte数组
//            for (int i = 0; i < bytes.length; i++) {
//                if (i < bytes.length - 3) {
//                    byte[] btByte = new byte[]{bytes[i], bytes[i + 1], bytes[i + 2]};
//                    if (Arrays.equals(btByte, DNT)) {
//                        isBT = true;
//                        type = "isPressure";
//                        return;
//                    }
//                    if (Arrays.equals(btByte, Drm) || Arrays.equals(btByte, drm) || Arrays.equals(btByte, DRM) || Arrays.equals(btByte, DKM)) {
//                        isBT = true;
//                        type = "isOptometry";
//                        return;
//                    }
//                }
//            }
//        } else {
//            switch (type) {
//                case "isBlood":
//                    String isBlood = CodeUtil.ascii2String(ByteUtils.hexStr2Byte(data));
//                    GetCheckBean.BloodPressure toBlood = toBlood(isBlood);
//                    bloodPressureService.lsSave(toBlood);
//                    isBT = false;
//                    type = "";
//                    break;
//                case "isPressure":
//                    String isPressure = CodeUtil.ascii2String(ByteUtils.hexStr2Byte(data));
//                    GetCheckBean.ResultEyepressureDOBean eyepressureDOBean = toIOP(isPressure);
//                    eyePressureDao.lsSave(eyepressureDOBean);
//                    isBT = false;
//                    type = "";
//                    break;
//                case "isOptometry":
//                    String isOptometry = CodeUtil.ascii2String(ByteUtils.hexStr2Byte(data));
//                    linShiData linShiData = new linShiData();
//                    linShiData.setData(isOptometry);
//                    linShiData.setAddDate(new Date());
//                    heightweightDao.dataSave(linShiData);
//                    isBT = false;
//                    type = "";
//                    break;
//            }
//        }
//
//
//    }

    /**
     * 验光
     */
    public static BleDataBean toOptometry(String data) {
        try {
            byte[] bytes = data.getBytes();
//            byte[] bytes = ByteUtils.hexStr2Byte(data);
            BleDataBean bleDataBean = new BleDataBean();
            ResultOptometryDO resultOptometryDO = new ResultOptometryDO();
            ArrayList diopterDOs = new ArrayList();
            ArrayList data23s = new ArrayList();
            int i = 0;
            Intrinsics.checkExpressionValueIsNotNull(bytes, "bytes");
            int index;
            for (index = bytes.length; i < index; ++i) {
                byte[] btByte;
                byte[] R2;
                if (bytes[i] == SOH) {
                    btByte = new byte[]{bytes[i + 1], bytes[i + 2], bytes[i + 3]};
                    if (Arrays.equals(btByte, Drm) || Arrays.equals(btByte, drm)) {
                        isdrm = true;
                        isDRM = false;
                        isDKM = false;
                    }
                    if (Arrays.equals(btByte, DRM)) {
                        isdrm = false;
                        isDRM = true;
                        isDKM = false;
                    }
                    if (Arrays.equals(btByte, DKM)) {
                        isdrm = false;
                        isDRM = false;
                        isDKM = true;
                    }
                }

                if (i < bytes.length - 2) {
                    btByte = new byte[]{bytes[i + 1], bytes[i + 2]};
                    byte[] PD1;
                    String var19;
                    double var38;
                    if (Arrays.equals(btByte, VD) && isdrm) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4]};
                        resultOptometryDO.setFirstCheckVd(Double.parseDouble(new String(PD1, Charsets.UTF_8)));
                    }

                    byte[] AVE;
                    byte[] AXIS;
                    ResultDiopterDO diopterDoBean;
                    int var45;
                    if (Arrays.equals(btByte, OL)) {
                        if (isdrm) {
                            PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7], bytes[i + 8]};
                            R2 = new byte[]{bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12], bytes[i + 13], bytes[i + 14]};
                            AXIS = new byte[]{bytes[i + 15], bytes[i + 16], bytes[i + 17]};
                            diopterDoBean = new ResultDiopterDO();
                            diopterDoBean.setIfrl("L");
                            diopterDoBean.setType("L_DATA");
                            var19 = new String(PD1, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterS(var38);
                            var19 = new String(R2, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterC(var38);
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterA(var38);
                            diopterDOs.add(diopterDoBean);
                        } else if (isDRM && !Byte.valueOf(bytes[i + 1]).equals("E")) {
                            PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7], bytes[i + 8]};
                            R2 = new byte[]{bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12], bytes[i + 13], bytes[i + 14]};
                            AXIS = new byte[]{bytes[i + 15], bytes[i + 16], bytes[i + 17]};
                            AVE = new byte[]{bytes[i + 18]};
                            diopterDoBean = new ResultDiopterDO();
                            diopterDoBean.setIfrl("L");
                            diopterDoBean.setType("PU_TONG");
                            var19 = new String(PD1, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterS(var38);
                            var19 = new String(R2, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterC(var38);
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterA(var38);
                            if (Intrinsics.areEqual(new String(AVE, Charsets.UTF_8), "\u0017")) {
                                diopterDoBean.setBelieve(0);
                                diopterDoBean.setType("AVG");
                            } else {
                                var19 = new String(AVE, Charsets.UTF_8);
                                var45 = Integer.parseInt(var19);
                                diopterDoBean.setBelieve(var45);
                            }

                            diopterDOs.add(diopterDoBean);
                        }
                    }

                    if (Arrays.equals(btByte, OR)) {
                        if (isdrm) {
                            PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7], bytes[i + 8]};
                            R2 = new byte[]{bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12], bytes[i + 13], bytes[i + 14]};
                            AXIS = new byte[]{bytes[i + 15], bytes[i + 16], bytes[i + 17]};
                            diopterDoBean = new ResultDiopterDO();
                            diopterDoBean.setIfrl("R");
                            diopterDoBean.setType("L_DATA");
                            var19 = new String(PD1, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterS(var38);
                            var19 = new String(R2, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterC(var38);
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterA(var38);
                            diopterDOs.add(diopterDoBean);
                        } else if (isDRM && !Byte.valueOf(bytes[i + 1]).equals("E")) {
                            PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7], bytes[i + 8]};
                            R2 = new byte[]{bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12], bytes[i + 13], bytes[i + 14]};
                            AXIS = new byte[]{bytes[i + 15], bytes[i + 16], bytes[i + 17]};
                            AVE = new byte[]{bytes[i + 18]};
                            diopterDoBean = new ResultDiopterDO();
                            diopterDoBean.setIfrl("R");
                            diopterDoBean.setType("PU_TONG");
                            var19 = new String(PD1, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterS(var38);
                            var19 = new String(R2, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterC(var38);
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var38 = Double.parseDouble(var19);
                            diopterDoBean.setDiopterA(var38);
                            if (Intrinsics.areEqual(new String(AVE, Charsets.UTF_8), "\u0017")) {
                                diopterDoBean.setBelieve(0);
                                diopterDoBean.setType("AVG");
                            } else {
                                var19 = new String(AVE, Charsets.UTF_8);
                                var45 = Integer.parseInt(var19);
                                diopterDoBean.setBelieve(var45);
                            }

                            diopterDOs.add(diopterDoBean);
                        }
                    }

                    if (Arrays.equals(btByte, PL) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6]};
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        resultOptometryDO.setFirstCheckLps(var38);
                    }

                    if (Arrays.equals(btByte, PR) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6]};
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        resultOptometryDO.setFirstCheckRps(var38);
                    }

                    byte[] CYL;
                    String var41;
                    DATA23 datA23;
                    if (Arrays.equals(btByte, DL) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7]};
                        R2 = new byte[]{bytes[i + 8], bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12]};
                        AXIS = new byte[]{bytes[i + 13], bytes[i + 14], bytes[i + 15]};
                        AVE = new byte[]{bytes[i + 16], bytes[i + 17], bytes[i + 18], bytes[i + 19], bytes[i + 20]};
                        CYL = new byte[]{bytes[i + 21], bytes[i + 22], bytes[i + 23], bytes[i + 24], bytes[i + 25], bytes[i + 26]};
                        datA23 = new DATA23();
                        datA23.setLorR("L");
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDr1(var38);
                        var19 = new String(R2, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDr2(var38);
                        var19 = new String(AVE, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDave(var38);
                        var19 = new String(CYL, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDcyl(var38);
                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegcyl(var45);
                        data23s.add(datA23);
                    }

                    if (Arrays.equals(btByte, DR) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7]};
                        R2 = new byte[]{bytes[i + 8], bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12]};
                        AXIS = new byte[]{bytes[i + 13], bytes[i + 14], bytes[i + 15]};
                        AVE = new byte[]{bytes[i + 16], bytes[i + 17], bytes[i + 18], bytes[i + 19], bytes[i + 20]};
                        CYL = new byte[]{bytes[i + 21], bytes[i + 22], bytes[i + 23], bytes[i + 24], bytes[i + 25], bytes[i + 26]};
                        datA23 = new DATA23();
                        datA23.setLorR("R");
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDr1(var38);
                        var19 = new String(R2, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDr2(var38);
                        var19 = new String(AVE, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDave(var38);
                        var19 = new String(CYL, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setDcyl(var38);
                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegcyl(var45);
                        data23s.add(datA23);
                    }

                    if (Arrays.equals(btByte, L) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7]};
                        R2 = new byte[]{bytes[i + 8], bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12]};
                        AXIS = new byte[]{bytes[i + 13], bytes[i + 14], bytes[i + 15]};
                        AVE = new byte[]{bytes[i + 16], bytes[i + 17], bytes[i + 18], bytes[i + 19], bytes[i + 20]};
                        datA23 = new DATA23();
                        datA23.setLorR("L");
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setR1(var38);
                        var19 = new String(R2, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setR2(var38);
                        var19 = new String(AVE, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setAve(var38);
                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegr1(var45);
                        var41 = new String(AXIS, Charsets.UTF_8);
                        if (Integer.parseInt(var41) > 100) {
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var45 = Integer.parseInt(var19);
                            datA23.setDegr2(var45 - 90);
                        } else {
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var45 = Integer.parseInt(var19);
                            datA23.setDegr2(var45 + 90);
                        }

                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegcyl(var45);
                        data23s.add(datA23);
                    }

                    if (Arrays.equals(btByte, R) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7]};
                        R2 = new byte[]{bytes[i + 8], bytes[i + 9], bytes[i + 10], bytes[i + 11], bytes[i + 12]};
                        AXIS = new byte[]{bytes[i + 13], bytes[i + 14], bytes[i + 15]};
                        AVE = new byte[]{bytes[i + 16], bytes[i + 17], bytes[i + 18], bytes[i + 19], bytes[i + 20]};
                        datA23 = new DATA23();
                        datA23.setLorR("R");
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setR1(var38);
                        var19 = new String(R2, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setR2(var38);
                        var19 = new String(AVE, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        datA23.setAve(var38);
                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegr1(var45);
                        var41 = new String(AXIS, Charsets.UTF_8);
                        if (Integer.parseInt(var41) > 100) {
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var45 = Integer.parseInt(var19);
                            datA23.setDegr2(var45 - 90);
                        } else {
                            var19 = new String(AXIS, Charsets.UTF_8);
                            var45 = Integer.parseInt(var19);
                            datA23.setDegr2(var45 + 90);
                        }

                        var19 = new String(AXIS, Charsets.UTF_8);
                        var45 = Integer.parseInt(var19);
                        datA23.setDegcyl(var45);
                        data23s.add(datA23);
                    }

                    if (Arrays.equals(btByte, SL) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6]};
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        resultOptometryDO.setFirstCheckLcs(var38);
                    }

                    if (Arrays.equals(btByte, SR) && isDKM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6]};
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        resultOptometryDO.setFirstCheckRcs(var38);
                    }

                    if (Arrays.equals(btByte, PD) && isDRM) {
                        PD1 = new byte[]{bytes[i + 3], bytes[i + 4]};
                        var19 = new String(PD1, Charsets.UTF_8);
                        var38 = Double.parseDouble(var19);
                        resultOptometryDO.setFirstCheckPd(var38);
                    }
                }
            }

            ArrayList corneals = new ArrayList();
            index = 0;

            for (i = data23s.size() - 1; index < i; ++index) {
                if (index % 8 == 0) {
                    ResultCornealDO corneal1 = new ResultCornealDO();
                    corneal1.setIfrl(((DATA23) data23s.get(index)).getLorR());
                    corneal1.setType("R1");
                    corneal1.setCornealMm(((DATA23) data23s.get(index)).getR1());
                    corneal1.setCornealD(((DATA23) data23s.get(index + 1)).getDr1());
                    corneal1.setCornealDeg(((DATA23) data23s.get(index)).getDegr1());
                    corneals.add(corneal1);
                    GetCheckBean.CornealDOsBean corneal2 = new GetCheckBean.CornealDOsBean();
                    corneal2.setIfrl(((DATA23) data23s.get(index)).getLorR());
                    corneal2.setType("R2");
                    corneal2.setCornealMm(((DATA23) data23s.get(index)).getR2());
                    corneal2.setCornealD(((DATA23) data23s.get(index + 1)).getDr2());
                    corneal2.setCornealDeg(((DATA23) data23s.get(index)).getDegr2());
                    corneals.add(corneal2);
                    GetCheckBean.CornealDOsBean corneal3 = new GetCheckBean.CornealDOsBean();
                    corneal3.setIfrl(((DATA23) data23s.get(index)).getLorR());
                    corneal3.setType("AVG");
                    corneal3.setCornealMm(((DATA23) data23s.get(index)).getAve());
                    corneal3.setCornealD(((DATA23) data23s.get(index + 1)).getDave());
                    corneal3.setCornealDeg(((DATA23) data23s.get(index + 1)).getDegave());
                    corneals.add(corneal3);
                    GetCheckBean.CornealDOsBean corneal4 = new GetCheckBean.CornealDOsBean();
                    corneal4.setIfrl(((DATA23) data23s.get(index)).getLorR());
                    corneal4.setType("CYL");
                    corneal4.setCornealMm(((DATA23) data23s.get(index)).getCyl());
                    corneal4.setCornealD(((DATA23) data23s.get(index + 1)).getDcyl());
                    corneal4.setCornealDeg(((DATA23) data23s.get(index + 1)).getDegcyl());
                    corneals.add(corneal4);
                }
            }

            bleDataBean.setResultOptometryDO(resultOptometryDO);
            ArrayList diopters = new ArrayList();
            i = diopterDOs.size() - 1;

            for (boolean var33 = false; i >= 0; --i) {
                diopters.add(diopterDOs.get(i));
            }

            bleDataBean.setSca((List) diopters);
            bleDataBean.setRdDeg((List) corneals);
            return bleDataBean;
        } catch (Exception var21) {
            var21.printStackTrace();
            String var3 = "数据解析错误";
            System.out.println(var3);
            return null;
        }
    }

    /**
     * 眼内压
     */
    public static GetCheckBean.ResultEyepressureDOBean toIOP(String data) {
//        byte[] bytes = ByteUtils.hexStr2Byte(data);//获得byte数组
        byte[] bytes = data.getBytes();
        GetCheckBean.ResultEyepressureDOBean yny = new GetCheckBean.ResultEyepressureDOBean();
        for (int i = 0; i < bytes.length; i++) {
            if (i < bytes.length - 2) {
                byte[] btByte = new byte[]{bytes[i + 1], bytes[i + 2]};
                if (Arrays.equals(btByte, AV)) {
                    byte[] OD = new byte[]{bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6]};
                    if (yny.getEyePressureOs() == null) {
                        yny.setEyePressureOs(Double.parseDouble(new String(OD)));
                    } else {
                        yny.setEyePressureOd(Double.parseDouble(new String(OD)));
                    }
                }
            }

        }
        return yny;
    }

    /**
     * 血压计
     */
    public static GetCheckBean.BloodPressure toBlood(String dataStr) {

        GetCheckBean.BloodPressure bloodPressure = new GetCheckBean.BloodPressure();

        String[] strings = dataStr.split(",");
        String bloodHigh = strings[4];
        String bloodAVG = strings[5];
        String bloodLow = strings[6];
        String pulse = strings[7];
        bloodPressure.setBloodHigh(Integer.parseInt(bloodHigh));
        bloodPressure.setBloodLow(Integer.parseInt(bloodAVG));
        bloodPressure.setBloodAvg(Integer.parseInt(bloodLow));
        bloodPressure.setPulse(Integer.parseInt(pulse));
        return bloodPressure;
    }


    /**
     * 身高体重
     */
    public static GetCheckBean.HeightAndWeight tohw(String data) {
//        byte[] bytes = ByteUtils.hexStr2Byte(data);
        byte[] bytes = data.getBytes();
        String w = "" + bytes[3] + bytes[4] + bytes[5] + bytes[6];
        double weight = (double) Integer.parseInt(w) / 10.0D;
        String h = "" + bytes[7] + bytes[8] + bytes[9] + bytes[10];
        double height = (double) Integer.parseInt(h) / 10.0D;
        GetCheckBean.HeightAndWeight heightAndWeight = new GetCheckBean.HeightAndWeight();
        heightAndWeight.setHeight(height);
        heightAndWeight.setWeight(weight);
        heightAndWeight.setBim(weight / (height * height));
        return heightAndWeight;
    }


    public static class DATA23 {
        private String LorR = "";

        private Double r1;
        private Double dr1;
        private Integer degr1;

        private Double r2;
        private Double dr2;
        private Integer degr2;

        private Double ave;
        private Double dave;
        private Integer degave;

        private Double cyl;
        private Double dcyl;
        private Integer degcyl;

        public String getLorR() {
            return LorR;
        }

        public void setLorR(String lorR) {
            LorR = lorR;
        }

        public Double getR1() {
            return r1;
        }

        public void setR1(Double r1) {
            this.r1 = r1;
        }

        public Double getDr1() {
            return dr1;
        }

        public void setDr1(Double dr1) {
            this.dr1 = dr1;
        }

        public Integer getDegr1() {
            return degr1;
        }

        public void setDegr1(Integer degr1) {
            this.degr1 = degr1;
        }

        public Double getR2() {
            return r2;
        }

        public void setR2(Double r2) {
            this.r2 = r2;
        }

        public Double getDr2() {
            return dr2;
        }

        public void setDr2(Double dr2) {
            this.dr2 = dr2;
        }

        public Integer getDegr2() {
            return degr2;
        }

        public void setDegr2(Integer degr2) {
            this.degr2 = degr2;
        }

        public Double getAve() {
            return ave;
        }

        public void setAve(Double ave) {
            this.ave = ave;
        }

        public Double getDave() {
            return dave;
        }

        public void setDave(Double dave) {
            this.dave = dave;
        }

        public Integer getDegave() {
            return degave;
        }

        public void setDegave(Integer degave) {
            this.degave = degave;
        }

        public Double getCyl() {
            return cyl;
        }

        public void setCyl(Double cyl) {
            this.cyl = cyl;
        }

        public Double getDcyl() {
            return dcyl;
        }

        public void setDcyl(Double dcyl) {
            this.dcyl = dcyl;
        }

        public Integer getDegcyl() {
            return degcyl;
        }

        public void setDegcyl(Integer degcyl) {
            this.degcyl = degcyl;
        }
    }

}
