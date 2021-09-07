package com.shiguang.report.domain;

import com.shiguang.common.annotation.Log;

public class SaleReportDO {
    private Long checkCount;
    private Long checkMoney;
    private Long isSale;

    public void setCheckCount(Long checkCount) {this.checkCount = checkCount;}
    public Long getCheckCount() {return checkCount;}
    public void setCheckMoney(Long checkMoney) {this.checkMoney = checkMoney;}
    public Long getCheckMoney() {return checkMoney;}
    public void setIsSale(Long isSale){this.isSale = isSale;}
    public Long getIsSale() {return isSale;}
}
