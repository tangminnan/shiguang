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
    //处方类型
    private String chufangType;
    //处方
    private String chufang;
    //验光师
    private String yangsName;
    //球镜OD
    private Double rightsph;
    //球镜OS
    private Double leftsph;
    //柱镜OD
    private Double rightcyl;
    //柱镜OS
    private Double leftcyl;
    //轴向OD
    private Double rightzx;
    //轴向OS
    private Double leftzx;
    //三棱镜(OD)
    private Double rightprism;
    //三棱镜(OS)
    private Double leftprism;
    //基地OD
    private String rightjd;
    //基地OS
    private String leftjd;
    //远/中用瞳距OD
    private Double rightyytj;
    //远/中用瞳距OS
    private Double leftyytj;
    //瞳高OD
    private Double righttg;
    //瞳高OS
    private Double lefttg;
    //远用VA(OD)
    private Double rightva;
    //远用VA(OS)
    private Double leftva;
    //适用镜片OD
    private Double rightsyjp;
    //适用镜片OS
    private Double leftsyjp;
    //片/盒OD
    private Double rightunit;
    //片/盒OS
    private Double leftunit;
    //近用瞳距OD
    private Double rightjytj;
    //近用瞳距OS
    private Double leftjytj;
    //近用VA(OD)
    private Double rightjyva;
    //近用VA(OS)
    private Double leftjyva;
    //屈光度OD
    private Double rightqgd;
    //屈光度OS
    private Double leftqgd;
    //BC(OD)
    private Double rightbc;
    //BC(OS)
    private Double leftbc;
    //DIA(OD)
    private Double rightdia;
    //DIA(OS)
    private Double leftdia;
    //散光(OD)
    private Double rightsg;
    //散光(OS)
    private Double leftsg;
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

    public void setChufangType(String chufangType) {this.chufangType = chufangType;}

    public String getChufangType(){return chufangType;}

    public void setChufang(String chufang) {this.chufang = chufang;}

    public String getChufang() {return chufang;}

    public void setYangsName(String yangsName){this.yangsName = yangsName;}

    public String getYangsName() {return yangsName;}

    public void setRightsph(Double rightsph) {this.rightsph = rightsph;}

    public Double getRightsph() {return rightsph;}

    public void setLeftsph(Double leftsph) {this.leftsph = leftsph;}

    public Double getLeftsph() {return leftsph;}

    public void setRightcyl(Double rightcyl) {this.rightcyl = rightcyl;}

    public Double getRightcyl() {return rightcyl;}

    public void setLeftcyl(Double leftcyl) {this.leftcyl = leftcyl;}

    public Double getLeftcyl() {return leftcyl;}

    public void setRightzx(Double rightzx) {this.rightzx = rightzx;}

    public Double getRightzx() {return rightzx;}

    public void setLeftzx(Double leftzx) {this.leftzx = leftzx;}

    public Double getLeftzx() {return leftzx;}

    public void setRightprism(Double rightprism) {this.rightprism = rightprism;}

    public Double getRightprism() {return rightprism;}

    public void setLeftprism(Double leftprism) {this.leftprism = leftprism;}

    public Double getLeftprism() {return leftprism;}

    public void setRightjd(String rightjd) {this.rightjd = rightjd;}

    public String getRightjd() {return rightjd;}

    public void setLeftjd(String leftjd) {this.leftjd = leftjd;}

    public String getLeftjd(){return leftjd;}

    public void setRightyytj(Double rightyytj) {this.rightyytj = rightyytj;}

    public Double getRightyytj() {return rightyytj;}

    public void setLeftyytj(Double leftyytj) {this.leftyytj = leftyytj;}

    public Double getLeftyytj(){return leftyytj;}

    public void setRighttg(Double righttg) {this.righttg = righttg;}

    public Double getRighttg() {return righttg;}

    public void setLefttg(Double lefttg) {this.lefttg = lefttg;}

    public Double getLefttg() {return lefttg;}

    public void setRightva(Double rightva) {this.rightva = rightva;}

    public Double getRightva(){return rightva;}

    public void setLeftva(Double leftva) {this.leftva = leftva;}

    public Double getLeftva(){return leftva;}

    public void setRightsyjp(Double rightsyjp) {this.rightsyjp = rightsyjp;}

    public Double getRightsyjp(){return rightsyjp;}

    public void setLeftsyjp(Double leftsyjp) {this.leftsyjp = leftsyjp;}

    public Double getLeftsyjp() {return leftsyjp;}

    public void setRightunit(Double rightunit) {this.rightunit = rightunit;}

    public Double getRightunit() {return rightunit;}

    public void setLeftunit(Double leftunit) {this.leftunit = leftunit;}

    public Double getLeftunit(){return leftunit;}

    public void setRightjytj(Double rightjytj) {this.rightjytj = rightjytj;}

    public Double getRightjytj() {return rightjytj;}

    public void setLeftjytj(Double leftjytj) {this.leftjytj = leftjytj;}

    public Double getLeftjytj(){return leftjytj;}

    public void setRightjyva(Double rightjyva) {this.rightjyva = rightjyva;}

    public Double getRightjyva() {return rightjyva;}

    public void setLeftjyva(Double leftjyva) {this.leftjyva = leftjyva;}

    public Double getLeftjyva(){return leftjyva;}

    public void setRightqgd(Double rightqgd){this.rightqgd = rightqgd;}

    public Double getRightqgd(){return  rightqgd;}

    public void setLeftqgd(Double leftqgd){this.leftqgd = leftqgd;}

    public Double getLeftqgd(){return leftqgd;}

    public void setRightbc(Double rightbc) {this.rightbc = rightbc;}

    public Double getRightbc(){return rightbc;}

    public void setLeftbc(Double leftbc) {this.leftbc = leftbc;}

    public Double getLeftbc(){return leftbc;}

    public void setRightdia(Double rightdia) {this.rightdia = rightdia;}

    public Double getRightdia() {return rightdia;}

    public void setLeftdia(Double leftdia) {this.leftdia = leftdia;}

    public Double getLeftdia(){return leftdia;}

    public void setRightsg(Double rightsg) {this.rightsg = rightsg;}

    public Double getRightsg() {return rightsg;}

    public void setLeftsg(Double leftsg) {this.leftsg = leftsg;}

    public Double getLeftsg(){return leftsg;}

    public void setRighttssj(String righttssj) {this.righttssj = righttssj;}

    public String getRighttssj() {return righttssj;}

    public void setLefttssj(String lefttssj){this.lefttssj = lefttssj;}

    public String getLefttssj() {return lefttssj;}

    public void setRightrgpsyjp(String rightrgpsyjp) {this.rightrgpsyjp = rightrgpsyjp;}

    public String getRightrgpsyjp() {return rightrgpsyjp;}

    public void setLeftrgpsyjp(String leftrgpsyjp) {this.leftrgpsyjp = leftrgpsyjp;}

    public String getLeftrgpsyjp() {return leftrgpsyjp;}

}
