package com.shiguang.optometry.domain;

import java.util.List;

public final class BleDataBean {

    private List sca;

    private List rdDeg;

    private ResultOptometryDO resultOptometryDO;


    public List getSca() {
        return this.sca;
    }

    public void setSca(List sca) {
        this.sca = sca;
    }


    public List getRdDeg() {
        return this.rdDeg;
    }

    public void setRdDeg(List rdDeg) {
        this.rdDeg = rdDeg;
    }


    public ResultOptometryDO getResultOptometryDO() {
        return this.resultOptometryDO;
    }

    public void setResultOptometryDO(ResultOptometryDO resultOptometryDO) {
        this.resultOptometryDO = resultOptometryDO;
    }
}
