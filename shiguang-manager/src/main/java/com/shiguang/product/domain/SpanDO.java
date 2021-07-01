package com.shiguang.product.domain;

import java.io.Serializable;


/**
 * 跨度表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 10:48:53
 */

public class SpanDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //柱镜id
    private Long spanId;
    //柱镜
    private String span;


    public Long getSpanId() {
        return spanId;
    }

    public void setSpanId(Long spanId) {
        this.spanId = spanId;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }
}

