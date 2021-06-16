package com.shiguang.optometry.domain;

import java.util.List;

public class GetCheckBean {
    private String msg;
    private ResultOptometryDOBean resultOptometryDO;//验光
    private Integer code;
    private ResultEyepressureDOBean resultEyepressureDO;//眼压
    private BloodPressure bloodPressure;//血压
    private HeightAndWeight heightAndWeight;//身高体重
    private List<CornealDOsBean> cornealDOs;//验光-角膜
    private List<DiopterDOsBean> diopterDOs;//验光-SCA

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultOptometryDOBean getResultOptometryDO() {
        return resultOptometryDO;
    }

    public void setResultOptometryDO(ResultOptometryDOBean resultOptometryDO) {
        this.resultOptometryDO = resultOptometryDO;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResultEyepressureDOBean getResultEyepressureDO() {
        return resultEyepressureDO;
    }

    public void setResultEyepressureDO(ResultEyepressureDOBean resultEyepressureDO) {
        this.resultEyepressureDO = resultEyepressureDO;
    }

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public HeightAndWeight getHeightAndWeight() {
        return heightAndWeight;
    }

    public void setHeightAndWeight(HeightAndWeight heightAndWeight) {
        this.heightAndWeight = heightAndWeight;
    }

    public List<CornealDOsBean> getCornealDOs() {
        return cornealDOs;
    }

    public void setCornealDOs(List<CornealDOsBean> cornealDOs) {
        this.cornealDOs = cornealDOs;
    }

    public List<DiopterDOsBean> getDiopterDOs() {
        return diopterDOs;
    }

    public void setDiopterDOs(List<DiopterDOsBean> diopterDOs) {
        this.diopterDOs = diopterDOs;
    }

    public static class ResultOptometryDOBean {
        private Integer studentId;
        private Integer checkorId;
        private Double firstCheckVd;
        private Double firstCheckPd;
        private Double secondCheckPd;
        private Double firstCheckRps;
        private Double firstCheckLps;
        private Double firstCheckRcs;
        private Double firstCheckLcs;
        private String checkDate;
        private Double secondCheckVd;
        private Double secondCheckRps;
        private Double secondCheckLps;
        private Double secondCheckRcs;
        private Double secondCheckLcs;
        private Integer deleteFlag;
        private Integer toptometryId;

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCheckorId() {
            return checkorId;
        }

        public void setCheckorId(Integer checkorId) {
            this.checkorId = checkorId;
        }

        public Double getFirstCheckVd() {
            return firstCheckVd;
        }

        public void setFirstCheckVd(Double firstCheckVd) {
            this.firstCheckVd = firstCheckVd;
        }

        public Double getFirstCheckPd() {
            return firstCheckPd;
        }

        public void setFirstCheckPd(Double firstCheckPd) {
            this.firstCheckPd = firstCheckPd;
        }

        public Double getSecondCheckPd() {
            return secondCheckPd;
        }

        public void setSecondCheckPd(Double secondCheckPd) {
            this.secondCheckPd = secondCheckPd;
        }

        public Double getFirstCheckRps() {
            return firstCheckRps;
        }

        public void setFirstCheckRps(Double firstCheckRps) {
            this.firstCheckRps = firstCheckRps;
        }

        public Double getFirstCheckLps() {
            return firstCheckLps;
        }

        public void setFirstCheckLps(Double firstCheckLps) {
            this.firstCheckLps = firstCheckLps;
        }

        public Double getFirstCheckRcs() {
            return firstCheckRcs;
        }

        public void setFirstCheckRcs(Double firstCheckRcs) {
            this.firstCheckRcs = firstCheckRcs;
        }

        public Double getFirstCheckLcs() {
            return firstCheckLcs;
        }

        public void setFirstCheckLcs(Double firstCheckLcs) {
            this.firstCheckLcs = firstCheckLcs;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(String checkDate) {
            this.checkDate = checkDate;
        }

        public Double getSecondCheckVd() {
            return secondCheckVd;
        }

        public void setSecondCheckVd(Double secondCheckVd) {
            this.secondCheckVd = secondCheckVd;
        }

        public Double getSecondCheckRps() {
            return secondCheckRps;
        }

        public void setSecondCheckRps(Double secondCheckRps) {
            this.secondCheckRps = secondCheckRps;
        }

        public Double getSecondCheckLps() {
            return secondCheckLps;
        }

        public void setSecondCheckLps(Double secondCheckLps) {
            this.secondCheckLps = secondCheckLps;
        }

        public Double getSecondCheckRcs() {
            return secondCheckRcs;
        }

        public void setSecondCheckRcs(Double secondCheckRcs) {
            this.secondCheckRcs = secondCheckRcs;
        }

        public Double getSecondCheckLcs() {
            return secondCheckLcs;
        }

        public void setSecondCheckLcs(Double secondCheckLcs) {
            this.secondCheckLcs = secondCheckLcs;
        }

        public Integer getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(Integer deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Integer getToptometryId() {
            return toptometryId;
        }

        public void setToptometryId(Integer toptometryId) {
            this.toptometryId = toptometryId;
        }
    }

    public class ResultVisibilityDOBean {
        private Integer studentId;
        private Integer checkorId;
        private Integer stereoscopicViewingValue;
        private Integer stereoscopicViewingDis;
        private Double adjustmentRangeOd;
        private Double adjustmentRangeOc;
        private Double adjustmentRangeOu;
        private Double gatherNearOd;
        private Double gatherNearOc;
        private Double gatherNearOu;
        private String obliqueValue;
        private Double obliqueDis;
        private Integer beforeAfterOdValue;
        private Integer beforeAfterOdDis;
        private Integer beforeAfterOsValue;
        private String beforeAfterOsDis;
        private String checkDate;
        private Integer deleteFlag;
        private Integer tvisibilityId;

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCheckorId() {
            return checkorId;
        }

        public void setCheckorId(Integer checkorId) {
            this.checkorId = checkorId;
        }

        public Integer getStereoscopicViewingValue() {
            return stereoscopicViewingValue;
        }

        public void setStereoscopicViewingValue(Integer stereoscopicViewingValue) {
            this.stereoscopicViewingValue = stereoscopicViewingValue;
        }

        public Integer getStereoscopicViewingDis() {
            return stereoscopicViewingDis;
        }

        public void setStereoscopicViewingDis(Integer stereoscopicViewingDis) {
            this.stereoscopicViewingDis = stereoscopicViewingDis;
        }

        public Double getAdjustmentRangeOd() {
            return adjustmentRangeOd;
        }

        public void setAdjustmentRangeOd(Double adjustmentRangeOd) {
            this.adjustmentRangeOd = adjustmentRangeOd;
        }

        public Double getAdjustmentRangeOc() {
            return adjustmentRangeOc;
        }

        public void setAdjustmentRangeOc(Double adjustmentRangeOc) {
            this.adjustmentRangeOc = adjustmentRangeOc;
        }

        public Double getAdjustmentRangeOu() {
            return adjustmentRangeOu;
        }

        public void setAdjustmentRangeOu(Double adjustmentRangeOu) {
            this.adjustmentRangeOu = adjustmentRangeOu;
        }

        public Double getGatherNearOd() {
            return gatherNearOd;
        }

        public void setGatherNearOd(Double gatherNearOd) {
            this.gatherNearOd = gatherNearOd;
        }

        public Double getGatherNearOc() {
            return gatherNearOc;
        }

        public void setGatherNearOc(Double gatherNearOc) {
            this.gatherNearOc = gatherNearOc;
        }

        public Double getGatherNearOu() {
            return gatherNearOu;
        }

        public void setGatherNearOu(Double gatherNearOu) {
            this.gatherNearOu = gatherNearOu;
        }

        public String getObliqueValue() {
            return obliqueValue;
        }

        public void setObliqueValue(String obliqueValue) {
            this.obliqueValue = obliqueValue;
        }

        public Double getObliqueDis() {
            return obliqueDis;
        }

        public void setObliqueDis(Double obliqueDis) {
            this.obliqueDis = obliqueDis;
        }

        public Integer getBeforeAfterOdValue() {
            return beforeAfterOdValue;
        }

        public void setBeforeAfterOdValue(Integer beforeAfterOdValue) {
            this.beforeAfterOdValue = beforeAfterOdValue;
        }

        public Integer getBeforeAfterOdDis() {
            return beforeAfterOdDis;
        }

        public void setBeforeAfterOdDis(Integer beforeAfterOdDis) {
            this.beforeAfterOdDis = beforeAfterOdDis;
        }

        public Integer getBeforeAfterOsValue() {
            return beforeAfterOsValue;
        }

        public void setBeforeAfterOsValue(Integer beforeAfterOsValue) {
            this.beforeAfterOsValue = beforeAfterOsValue;
        }

        public String getBeforeAfterOsDis() {
            return beforeAfterOsDis;
        }

        public void setBeforeAfterOsDis(String beforeAfterOsDis) {
            this.beforeAfterOsDis = beforeAfterOsDis;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(String checkDate) {
            this.checkDate = checkDate;
        }

        public Integer getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(Integer deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Integer getTvisibilityId() {
            return tvisibilityId;
        }

        public void setTvisibilityId(Integer tvisibilityId) {
            this.tvisibilityId = tvisibilityId;
        }
    }

    public class ResultEyesightDOBean {
        //视力
        private Integer studentId;
        private Integer checkorId;
        private String lifeFarvisionOd;
        private String lifeFarvisionOs;
        private String nakedFarvisionOd;
        private String nakedFarvisionOs;
        private String correctionFarvisionOd;
        private String correctionFarvisionOs;
        private String lifeNearvisionOd;
        private String lifeNearvisionOs;
        private String nakedNearvisionOd;
        private String nakedNearvisionOs;
        private String checkDate;
        private Integer deleteFlag;
        private Integer teyesightId;

        public Integer getStudentId() {
            return studentId;
        }

        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }

        public Integer getCheckorId() {
            return checkorId;
        }

        public void setCheckorId(Integer checkorId) {
            this.checkorId = checkorId;
        }

        public String getLifeFarvisionOd() {
            return lifeFarvisionOd;
        }

        public void setLifeFarvisionOd(String lifeFarvisionOd) {
            this.lifeFarvisionOd = lifeFarvisionOd;
        }

        public String getLifeFarvisionOs() {
            return lifeFarvisionOs;
        }

        public void setLifeFarvisionOs(String lifeFarvisionOs) {
            this.lifeFarvisionOs = lifeFarvisionOs;
        }

        public String getNakedFarvisionOd() {
            return nakedFarvisionOd;
        }

        public void setNakedFarvisionOd(String nakedFarvisionOd) {
            this.nakedFarvisionOd = nakedFarvisionOd;
        }

        public String getNakedFarvisionOs() {
            return nakedFarvisionOs;
        }

        public void setNakedFarvisionOs(String nakedFarvisionOs) {
            this.nakedFarvisionOs = nakedFarvisionOs;
        }

        public String getCorrectionFarvisionOd() {
            return correctionFarvisionOd;
        }

        public void setCorrectionFarvisionOd(String correctionFarvisionOd) {
            this.correctionFarvisionOd = correctionFarvisionOd;
        }

        public String getCorrectionFarvisionOs() {
            return correctionFarvisionOs;
        }

        public void setCorrectionFarvisionOs(String correctionFarvisionOs) {
            this.correctionFarvisionOs = correctionFarvisionOs;
        }

        public String getLifeNearvisionOd() {
            return lifeNearvisionOd;
        }

        public void setLifeNearvisionOd(String lifeNearvisionOd) {
            this.lifeNearvisionOd = lifeNearvisionOd;
        }

        public String getLifeNearvisionOs() {
            return lifeNearvisionOs;
        }

        public void setLifeNearvisionOs(String lifeNearvisionOs) {
            this.lifeNearvisionOs = lifeNearvisionOs;
        }

        public String getNakedNearvisionOd() {
            return nakedNearvisionOd;
        }

        public void setNakedNearvisionOd(String nakedNearvisionOd) {
            this.nakedNearvisionOd = nakedNearvisionOd;
        }

        public String getNakedNearvisionOs() {
            return nakedNearvisionOs;
        }

        public void setNakedNearvisionOs(String nakedNearvisionOs) {
            this.nakedNearvisionOs = nakedNearvisionOs;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(String checkDate) {
            this.checkDate = checkDate;
        }

        public Integer getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(Integer deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Integer getTeyesightId() {
            return teyesightId;
        }

        public void setTeyesightId(Integer teyesightId) {
            this.teyesightId = teyesightId;
        }
    }

    public static class ResultEyepressureDOBean {
        /**
         * eyePressureOd : 10
         * eyePressureOs : 20
         */

        private Double eyePressureOd;
        private Double eyePressureOs;

        public Double getEyePressureOd() {
            return eyePressureOd;
        }

        public void setEyePressureOd(Double eyePressureOd) {
            this.eyePressureOd = eyePressureOd;
        }

        public Double getEyePressureOs() {
            return eyePressureOs;
        }

        public void setEyePressureOs(Double eyePressureOs) {
            this.eyePressureOs = eyePressureOs;
        }

    }

    public static class CornealDOsBean {
        /**
         * cornealMm : 12.0
         * cornealD : 12.0
         * cornealDeg : 12
         * type : R1
         * ifrl : R
         * firstSecond : null
         * toptometryId : 12
         * tcornealId : 19
         */
        private Double cornealMm;
        private Double cornealD;
        private Integer cornealDeg;
        private String type;
        private String ifrl;
        private String firstSecond;
        private Integer toptometryId;
        private Integer tcornealId;

        public Double getCornealMm() {
            return cornealMm;
        }

        public void setCornealMm(Double cornealMm) {
            this.cornealMm = cornealMm;
        }

        public Double getCornealD() {
            return cornealD;
        }

        public void setCornealD(Double cornealD) {
            this.cornealD = cornealD;
        }

        public Integer getCornealDeg() {
            return cornealDeg;
        }

        public void setCornealDeg(Integer cornealDeg) {
            this.cornealDeg = cornealDeg;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIfrl() {
            return ifrl;
        }

        public void setIfrl(String ifrl) {
            this.ifrl = ifrl;
        }

        public String getFirstSecond() {
            return firstSecond;
        }

        public void setFirstSecond(String firstSecond) {
            this.firstSecond = firstSecond;
        }

        public Integer getToptometryId() {
            return toptometryId;
        }

        public void setToptometryId(Integer toptometryId) {
            this.toptometryId = toptometryId;
        }

        public Integer getTcornealId() {
            return tcornealId;
        }

        public void setTcornealId(Integer tcornealId) {
            this.tcornealId = tcornealId;
        }
    }

    public static class DiopterDOsBean {
        /**
         * diopterS : 1.0
         * diopterC : 12.0
         * diopterA : 12.0
         * believe : 9
         * num : 1
         * type : PU_TONG
         * ifrl : L
         * firstSecond : null
         * toptometryId : 12
         * tdiopterId : 15
         */
        private Double diopterS;
        private Double diopterC;
        private Double diopterA;
        private Integer believe;
        private Integer num;
        private String type;
        private String ifrl;
        private String firstSecond;
        private Integer toptometryId;
        private Integer tdiopterId;

        public Double getDiopterS() {
            return diopterS;
        }

        public void setDiopterS(Double diopterS) {
            this.diopterS = diopterS;
        }

        public Double getDiopterC() {
            return diopterC;
        }

        public void setDiopterC(Double diopterC) {
            this.diopterC = diopterC;
        }

        public Double getDiopterA() {
            return diopterA;
        }

        public void setDiopterA(Double diopterA) {
            this.diopterA = diopterA;
        }

        public Integer getBelieve() {
            return believe;
        }

        public void setBelieve(Integer believe) {
            this.believe = believe;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIfrl() {
            return ifrl;
        }

        public void setIfrl(String ifrl) {
            this.ifrl = ifrl;
        }

        public String getFirstSecond() {
            return firstSecond;
        }

        public void setFirstSecond(String firstSecond) {
            this.firstSecond = firstSecond;
        }

        public Integer getToptometryId() {
            return toptometryId;
        }

        public void setToptometryId(Integer toptometryId) {
            this.toptometryId = toptometryId;
        }

        public Integer getTdiopterId() {
            return tdiopterId;
        }

        public void setTdiopterId(Integer tdiopterId) {
            this.tdiopterId = tdiopterId;
        }
    }

    public static class BloodPressure {
        private Integer bloodHigh;
        private Integer bloodLow;
        private Integer bloodAvg;
        private Integer pulse;

        public Integer getBloodHigh() {
            return bloodHigh;
        }

        public void setBloodHigh(Integer bloodHigh) {
            this.bloodHigh = bloodHigh;
        }

        public Integer getBloodLow() {
            return bloodLow;
        }

        public void setBloodLow(Integer bloodLow) {
            this.bloodLow = bloodLow;
        }

        public Integer getBloodAvg() {
            return bloodAvg;
        }

        public void setBloodAvg(Integer bloodAvg) {
            this.bloodAvg = bloodAvg;
        }

        public Integer getPulse() {
            return pulse;
        }

        public void setPulse(Integer pulse) {
            this.pulse = pulse;
        }
    }

    public static class HeightAndWeight {
        private double height;
        private double weight;
        private double bim;

        public final double getHeight() {
            return this.height;
        }

        public final void setHeight(double var1) {
            this.height = var1;
        }

        public final double getWeight() {
            return this.weight;
        }

        public final void setWeight(double var1) {
            this.weight = var1;
        }

        public final double getBim() {
            return this.bim;
        }

        public final void setBim(double var1) {
            this.bim = var1;
        }
    }

}
