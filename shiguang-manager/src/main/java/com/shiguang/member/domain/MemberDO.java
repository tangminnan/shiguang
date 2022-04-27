package com.shiguang.member.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String name;
    //会员选项(0:普通会员1:自动生成)
    private Long memberOption;
    //会员卡号
    private String cardNumber;
    //检查项目id
    private Long costId;
    //是否缴费
    private Long isSale;
    //顾客性别(0:男1:女)
    private Long sex;
    private String sexx;
    //部门编码
    private String departNumber;
    //公司id
    private String companyId;
    //出生日期-年
    private Long birthdayYear;
    //出生日期-月
    private Long birthdayMonth;
    //出生日期-日
    private Long birthdayDay;
    //年龄
    private Long age;
    //联系电话1
    private String phone1;
    //联系电话2
    private String phone2;
    //联系电话3
    private String phone3;
    //省编号
    private String provinceCode;
    //省名称
    private String provinceName;
    //市编号
    private String cityCode;
    //市名称
    private String cityName;
    //区编号
    private String areaCode;
    //区名称
    private String areaName;
    //会员卡类型(1:会员卡2:普通卡3:金卡4:铂金卡5:钻石卡6:公共卡)
    private String cardType;
    //主卡
    private String masterCard;
    //姓名(副卡姓名 )
    private String minorName;
    //人群分类(1:青少年)
    private String crowdType;
    //专属客服
    private String exclusiveCustomer;
    //专属客服id
    private Long exclusiveCustomerId;
    //证件类型(1:居民身份证2:机动车驾驶证3:台湾居民来往大陆通行证4:中国人民解放军军人证5:中国人民武装警察身份证6:护照7:户口本)
    private String identityType;
    //联系人证件号码
    private String identityId;
    //职业(1:工人2:学生3:农民4:教师5:军人6:管理者7:工程师)
    private String vocation;
    //学校
    private String school;
    //QQ号码
    private Long qqNumber;
    //E-Mail
    private String email;
    //地址
    private String address;
    //邮编
    private Long postalCode;
    //兴趣爱好
    private String interest;
    //来源
    private String source;
    //积分密码
    private Long integralPasd;
    //备注
    private String remark;
    //注册时间
    private Date registerTime;
    //状态(0:启用1:禁用)
    private Long status;
    //注册时间
    private String createTime;
    //状态(0:删除1:未删除)
    private Long state;
    //检查类型
    private String type;
    //销售单号
    private String saleNumber;
    //付款方式
    private String payWay;
    //公众号
    private String openId;
    //积分
    private String integral;
    //储值卡号
    private String storeCardNum;
    //储值余额
    private String cardMoney;
    //验光师
    private String optometryName;


    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：会员选项(0:普通会员1:自动生成)
     */
    public void setMemberOption(Long memberOption) {
        this.memberOption = memberOption;
    }
    /**
     * 获取：会员选项(0:普通会员1:自动生成)
     */
    public Long getMemberOption() {
        return memberOption;
    }
    /**
     * 设置：会员卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    /**
     * 获取：会员卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCostId(Long costId) {this.costId = costId;}

    public Long getCostId() {return costId;}

    /**
     * 设置：是否缴费
     */
    public void seIsSale(Long isSale) {
        this.isSale = isSale;
    }
    /**
     * 获取：是否缴费
     */
    public Long getIsSale() {
        return isSale;
    }

    /**
     * 设置：顾客性别(0:男1:女)
     */
    public void setSex(Long sex) {
        this.sex = sex;
    }
    /**
     * 获取：顾客性别(0:男1:女)
     */
    public Long getSex() {
        return sex;
    }

    /**
     * 设置：顾客性别
     */
    public void setSexx(String sexx) {
        this.sexx = sexx;
    }
    /**
     * 获取：顾客性别
     */
    public String getSexx() {
        return sexx;
    }

    /**
     * 设置：部门编码
     */
    public void setDepartNumber(String departNumber) {
        this.departNumber = departNumber;
    }
    /**
     * 获取：部门编码
     */
    public String getDepartNumber() {
        return departNumber;
    }

    /**
     * 公司id
     */
    public void setCompanyId(String companyId){this.companyId = companyId;}

    /**
     * 公司id
     */
    public String getCompanyId(){return companyId;}

    /**
     * 设置：出生日期-年
     */
    public void setBirthdayYear(Long birthdayYear) {
        this.birthdayYear = birthdayYear;
    }
    /**
     * 获取：出生日期-年
     */
    public Long getBirthdayYear() {
        return birthdayYear;
    }
    /**
     * 设置：出生日期-月
     */
    public void setBirthdayMonth(Long birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }
    /**
     * 获取：出生日期-月
     */
    public Long getBirthdayMonth() {
        return birthdayMonth;
    }
    /**
     * 设置：出生日期-日
     */
    public void setBirthdayDay(Long birthdayDay) {
        this.birthdayDay = birthdayDay;
    }
    /**
     * 获取：出生日期-日
     */
    public Long getBirthdayDay() {
        return birthdayDay;
    }
    /**
     * 设置：年龄
     */
    public void setAge(Long age) {
        this.age = age;
    }
    /**
     * 获取：年龄
     */
    public Long getAge() {
        return age;
    }
    /**
     * 设置：联系电话1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    /**
     * 获取：联系电话1
     */
    public String getPhone1() {
        return phone1;
    }
    /**
     * 设置：联系电话2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    /**
     * 获取：联系电话2
     */
    public String getPhone2() {
        return phone2;
    }
    /**
     * 设置：联系电话3
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }
    /**
     * 获取：联系电话3
     */
    public String getPhone3() {
        return phone3;
    }
    /**
     * 设置：省编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    /**
     * 获取：省编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }
    /**
     * 设置：省名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
     * 获取：省名称
     */
    public String getProvinceName() {
        return provinceName;
    }
    /**
     * 设置：市编号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
     * 获取：市编号
     */
    public String getCityCode() {
        return cityCode;
    }
    /**
     * 设置：市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
     * 获取：市名称
     */
    public String getCityName() {
        return cityName;
    }
    /**
     * 设置：区编号
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    /**
     * 获取：区编号
     */
    public String getAreaCode() {
        return areaCode;
    }
    /**
     * 设置：区名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    /**
     * 获取：区名称
     */
    public String getAreaName() {
        return areaName;
    }
    /**
     * 设置：会员卡类型(1:会员卡2:普通卡3:金卡4:铂金卡5:钻石卡6:公共卡)
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    /**
     * 获取：会员卡类型(1:会员卡2:普通卡3:金卡4:铂金卡5:钻石卡6:公共卡)
     */
    public String getCardType() {
        return cardType;
    }
    /**
     * 设置：主卡
     */
    public void setMasterCard(String masterCard) {
        this.masterCard = masterCard;
    }
    /**
     * 获取：主卡
     */
    public String getMasterCard() {
        return masterCard;
    }
    /**
     * 设置：姓名(副卡姓名 )
     */
    public void setMinorName(String minorName) {
        this.minorName = minorName;
    }
    /**
     * 获取：姓名(副卡姓名 )
     */
    public String getMinorName() {
        return minorName;
    }
    /**
     * 设置：人群分类(1:青少年)
     */
    public void setCrowdType(String crowdType) {
        this.crowdType = crowdType;
    }
    /**
     * 获取：人群分类(1:青少年)
     */
    public String getCrowdType() {
        return crowdType;
    }
    /**
     * 设置：专属客服
     */
    public void setExclusiveCustomer(String exclusiveCustomer) {
        this.exclusiveCustomer = exclusiveCustomer;
    }
    /**
     * 获取：专属客服
     */
    public String getExclusiveCustomer() {
        return exclusiveCustomer;
    }
    /**
     * 设置：专属客服id
     */
    public void setExclusiveCustomerId(Long exclusiveCustomerId) {
        this.exclusiveCustomerId = exclusiveCustomerId;
    }
    /**
     * 获取：专属客服id
     */
    public Long getExclusiveCustomerId() {
        return exclusiveCustomerId;
    }
    /**
     * 设置：证件类型(1:居民身份证2:机动车驾驶证3:台湾居民来往大陆通行证4:中国人民解放军军人证5:中国人民武装警察身份证6:护照7:户口本)
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }
    /**
     * 获取：证件类型(1:居民身份证2:机动车驾驶证3:台湾居民来往大陆通行证4:中国人民解放军军人证5:中国人民武装警察身份证6:护照7:户口本)
     */
    public String getIdentityType() {
        return identityType;
    }
    /**
     * 设置：联系人证件号码
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
    /**
     * 获取：联系人证件号码
     */
    public String getIdentityId() {
        return identityId;
    }
    /**
     * 设置：职业(1:工人2:学生3:农民4:教师5:军人6:管理者7:工程师)
     */
    public void setVocation(String vocation) {
        this.vocation = vocation;
    }
    /**
     * 获取：职业(1:工人2:学生3:农民4:教师5:军人6:管理者7:工程师)
     */
    public String getVocation() {
        return vocation;
    }
    /**
     * 设置：学校
     */
    public void setSchool(String school) {
        this.school = school;
    }
    /**
     * 获取：学校
     */
    public String getSchool() {
        return school;
    }
    /**
     * 设置：QQ号码
     */
    public void setQqNumber(Long qqNumber) {
        this.qqNumber = qqNumber;
    }
    /**
     * 获取：QQ号码
     */
    public Long getQqNumber() {
        return qqNumber;
    }
    /**
     * 设置：E-Mail
     */
    public void setEmail(String eMail) {
        this.email = email;
    }
    /**
     * 获取：E-Mail
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * 设置：邮编
     */
    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * 获取：邮编
     */
    public Long getPostalCode() {
        return postalCode;
    }
    /**
     * 设置：兴趣爱好
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }
    /**
     * 获取：兴趣爱好
     */
    public String getInterest() {
        return interest;
    }
    /**
     * 设置：来源
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * 获取：来源
     */
    public String getSource() {
        return source;
    }
    /**
     * 设置：积分密码
     */
    public void setIntegralPasd(Long integralPasd) {
        this.integralPasd = integralPasd;
    }
    /**
     * 获取：积分密码
     */
    public Long getIntegralPasd() {
        return integralPasd;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    /**
     * 获取：注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }
    /**
     * 设置：状态
     */
    public void setStatus(Long status) {
        this.status = status;
    }
    /**
     * 获取：状态
     */
    public Long getStatus() {
        return status;
    }
    /**
     * 设置：注册时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：注册时间
     */
    public String getCreateTime() {
        return createTime;
    }
    /**
     * 设置：状态(0:删除1:未删除)
     */
    public void setState(Long state) {
        this.state = state;
    }
    /**
     * 获取：状态(0:删除1:未删除)
     */
    public Long getState() {
        return state;
    }

    public void setType(String type){this.type = type;}

    public String getType(){return type;}

    public void setSaleNumber(String saleNumber) {this.saleNumber = saleNumber;}

    public String getSaleNumber() {return saleNumber;}

    public void setPayWay(String payWay) {this.payWay=payWay;}

    public String getPayWay() {return payWay;}

    public void setOpenId(String openId) {this.openId = openId;}

    public String getOpenId() {return openId;}

    public String getOptometryName() {
        return optometryName;
    }

    public void setOptometryName(String optometryName) {
        this.optometryName = optometryName;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getStoreCardNum() {
        return storeCardNum;
    }

    public void setStoreCardNum(String storeCardNum) {
        this.storeCardNum = storeCardNum;
    }

    public String getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(String cardMoney) {
        this.cardMoney = cardMoney;
    }
}
