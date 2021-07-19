package com.shiguang.mfrs.domain;

import java.io.Serializable;


/**
 * 开票状态表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public class InvoiceDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //开票状态id
    private Integer invoiceid;
    //开票状态
    private String invoicestate;

    /**
     * 设置：开票状态id
     */
    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    /**
     * 获取：开票状态id
     */
    public Integer getInvoiceid() {
        return invoiceid;
    }

    /**
     * 设置：开票状态
     */
    public void setInvoicestate(String invoicestate) {
        this.invoicestate = invoicestate;
    }

    /**
     * 获取：开票状态
     */
    public String getInvoicestate() {
        return invoicestate;
    }
}
