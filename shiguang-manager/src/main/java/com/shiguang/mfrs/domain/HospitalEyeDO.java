package com.shiguang.mfrs.domain;

import java.io.Serializable;

public class HospitalEyeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long companyId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
