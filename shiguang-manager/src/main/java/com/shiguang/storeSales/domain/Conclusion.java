package com.shiguang.storeSales.domain;

import java.io.Serializable;
import java.util.Date;

public class Conclusion implements Serializable {
    private static final long serialVersionUID = 1L;

    //验光号
    private String ptometryNum;
    //验光时间
    private Date createTime;
    //验光时间
    private String yanguangTime;
    //验光时间
    private String ygTime;
    //处方类型
    private String chufangType;
    //处方
    private String chufang;
    //验光师
    private String yangsName;
    //验光师
    private String yanguangName;
    //球镜OD
    private String rightsph;
    //球镜OS
    private String leftsph;
    //柱镜OD
    private String rightcyl;
    //柱镜OS
    private String leftcyl;
    //轴向OD
    private String rightzx;
    //轴向OS
    private String leftzx;
    //三棱镜(OD)
    private String rightprism;
    //三棱镜(OS)
    private String leftprism;
    //ADD
    private String rightAdd;
    //ADD
    private String leftAdd;
    //基地OD
    private String rightjd;
    //基地OS
    private String leftjd;
    //远/中用瞳距OD
    private String rightyytj;
    //远/中用瞳距OS
    private String leftyytj;
    //近/中用瞳距OD
    private String rightjytj;
    //近/中用瞳距OS
    private String leftjytj;
    //瞳高OD
    private String righttg;
    //瞳高OS
    private String lefttg;
    //远用VA(OD)
    private String rightva;
    //远用VA(OS)
    private String leftva;
    //适用镜片OD
    private String rightsyjp;
    //适用镜片OS
    private String leftsyjp;
    //片/盒OD
    private String rightunit;
    //片/盒OS
    private String leftunit;
    //近用VA(OD)
    private String rightjyva;
    //近用VA(OS)
    private String leftjyva;
    //屈光度OD
    private String rightqgd;
    //屈光度OS
    private String leftqgd;
    //BC(OD)
    private String rightbc;
    //BC(OS)
    private String leftbc;
    //DIA(OD)
    private String rightdia;
    //DIA(OS)
    private String leftdia;
    //散光(OD)
    private String rightsg;
    //散光(OS)
    private String leftsg;
    //特殊设计OD
    private String righttssj;
    //特殊设计OS
    private String lefttssj;
    //rgp适用镜片OD
    private String rightrgpsyjp;
    //rgp适用镜片OS
    private String leftrgpsyjp;

    public void setPtometryNum(String ptometryNum){this.ptometryNum = ptometryNum;}

    public String getPtometryNum(){return ptometryNum;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}

    public Date getCreateTime(){return createTime;}

    public void setYanguangTime(String yanguangTime) {this.yanguangTime = yanguangTime;}

    public String getYanguangTime() {return yanguangTime;}

    public String getYgTime() {
        return ygTime;
    }

    public void setYgTime(String ygTime) {
        this.ygTime = ygTime;
    }

    public void setChufangType(String chufangType) {this.chufangType = chufangType;}

    public String getChufangType(){return chufangType;}

    public void setChufang(String chufang) {this.chufang = chufang;}

    public String getChufang() {return chufang;}

    public void setYangsName(String yangsName){this.yangsName = yangsName;}

    public String getYangsName() {return yangsName;}

    public void setYanguangName(String yanguangName){this.yanguangName = yanguangName;}

    public String getYanguangName() {return yanguangName;}

    public void setRightsph(String rightsph) {this.rightsph = rightsph;}

    public String getRightsph() {return rightsph;}

    public void setLeftsph(String leftsph) {this.leftsph = leftsph;}

    public String getLeftsph() {return leftsph;}

    public void setRightcyl(String rightcyl) {this.rightcyl = rightcyl;}

    public String getRightcyl() {return rightcyl;}

    public void setLeftcyl(String leftcyl) {this.leftcyl = leftcyl;}

    public String getLeftcyl() {return leftcyl;}

    public void setRightzx(String rightzx) {this.rightzx = rightzx;}

    public String getRightzx() {return rightzx;}

    public void setLeftzx(String leftzx) {this.leftzx = leftzx;}

    public String getLeftzx() {return leftzx;}

    public void setRightprism(String rightprism) {this.rightprism = rightprism;}

    public String getRightprism() {return rightprism;}

    public void setLeftprism(String leftprism) {this.leftprism = leftprism;}

    public String getLeftprism() {return leftprism;}

    public void setRightjd(String rightjd) {this.rightjd = rightjd;}

    public String getRightjd() {return rightjd;}

    public void setLeftjd(String leftjd) {this.leftjd = leftjd;}

    public String getLeftjd(){return leftjd;}

    public void setRightyytj(String rightyytj) {this.rightyytj = rightyytj;}

    public String getRightyytj() {return rightyytj;}

    public void setLeftyytj(String leftyytj) {this.leftyytj = leftyytj;}

    public String getLeftyytj(){return leftyytj;}

    public void setRighttg(String righttg) {this.righttg = righttg;}

    public String getRighttg() {return righttg;}

    public void setLefttg(String lefttg) {this.lefttg = lefttg;}

    public String getLefttg() {return lefttg;}

    public void setRightva(String rightva) {this.rightva = rightva;}

    public String getRightva(){return rightva;}

    public void setLeftva(String leftva) {this.leftva = leftva;}

    public String getLeftva(){return leftva;}

    public void setRightsyjp(String rightsyjp) {this.rightsyjp = rightsyjp;}

    public String getRightsyjp(){return rightsyjp;}

    public void setLeftsyjp(String leftsyjp) {this.leftsyjp = leftsyjp;}

    public String getLeftsyjp() {return leftsyjp;}

    public void setRightunit(String rightunit) {this.rightunit = rightunit;}

    public String getRightunit() {return rightunit;}

    public void setLeftunit(String leftunit) {this.leftunit = leftunit;}

    public String getLeftunit(){return leftunit;}

    public void setRightjytj(String rightjytj) {this.rightjytj = rightjytj;}

    public String getRightjytj() {return rightjytj;}

    public void setLeftjytj(String leftjytj) {this.leftjytj = leftjytj;}

    public String getLeftjytj(){return leftjytj;}

    public void setRightjyva(String rightjyva) {this.rightjyva = rightjyva;}

    public String getRightjyva() {return rightjyva;}

    public void setLeftjyva(String leftjyva) {this.leftjyva = leftjyva;}

    public String getLeftjyva(){return leftjyva;}

    public void setRightqgd(String rightqgd){this.rightqgd = rightqgd;}

    public String getRightqgd(){return  rightqgd;}

    public void setLeftqgd(String leftqgd){this.leftqgd = leftqgd;}

    public String getLeftqgd(){return leftqgd;}

    public void setRightbc(String rightbc) {this.rightbc = rightbc;}

    public String getRightbc(){return rightbc;}

    public void setLeftbc(String leftbc) {this.leftbc = leftbc;}

    public String getLeftbc(){return leftbc;}

    public void setRightdia(String rightdia) {this.rightdia = rightdia;}

    public String getRightdia() {return rightdia;}

    public void setLeftdia(String leftdia) {this.leftdia = leftdia;}

    public String getLeftdia(){return leftdia;}

    public void setRightsg(String rightsg) {this.rightsg = rightsg;}

    public String getRightsg() {return rightsg;}

    public void setLeftsg(String leftsg) {this.leftsg = leftsg;}

    public String getLeftsg(){return leftsg;}

    public void setRighttssj(String righttssj) {this.righttssj = righttssj;}

    public String getRighttssj() {return righttssj;}

    public void setLefttssj(String lefttssj){this.lefttssj = lefttssj;}

    public String getLefttssj() {return lefttssj;}

    public void setRightrgpsyjp(String rightrgpsyjp) {this.rightrgpsyjp = rightrgpsyjp;}

    public String getRightrgpsyjp() {return rightrgpsyjp;}

    public void setLeftrgpsyjp(String leftrgpsyjp) {this.leftrgpsyjp = leftrgpsyjp;}

    public String getLeftrgpsyjp() {return leftrgpsyjp;}

    public void setRightAdd(String rightAdd) {this.rightAdd = rightAdd;}

    public String getRightAdd() {return rightAdd;}

    public void setLeftAdd(String leftAdd) {this.leftAdd = leftAdd;}

    public String getLeftAdd() {return leftAdd;}

}
