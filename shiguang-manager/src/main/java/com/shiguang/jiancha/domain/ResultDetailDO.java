package com.shiguang.jiancha.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 检查结论表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-16 15:03:42
 */
public class ResultDetailDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //检查结论id
    private Long id;
    //卡号
    private String cardNumber;
    //验光号
    private String ptometryNumber;
    //验光师
    private String optometryName;
    //创建时间
    private Date createTime;
    //正规
    private String cbzdZg;
    //远视眼
    private String cbzdYsy;
    //近视眼
    private String cbzdJsy;
    //散光
    private String cbzdSg;
    //屈光参差
    private String cbzdQgcc;
    //弱视
    private String cbzdRs;
    //斜视
    private String cbzdXs;
    //老视
    private String cbzdLs;
    //眼球震颤
    private String cbzdYqzc;
    //低视力
    private String cbzdDsl;
    //备注
    private String cbzdBz;
    //双眼视功能评估
    private String cbzdSypg;
    //框架眼镜
    private String kjyj;
    //非球面
    private String kjyjFqm;
    //球面
    private String kjyjQm;
    //渐进多焦点
    private String kjyjJjdjd;
    //变色片
    private String kjyjBsp;
    //防蓝光
    private String kjyjFlg;
    //周边离焦(框架眼镜)
    private String kjyjZblj;
    //角膜接触镜
    private String jmjcj;
    //OK
    private String jmjcjOk;
    //RGB
    private String jmjcjRgb;
    //散光
    private String jmjcjSg;
    //传统型
    private String jmjcjCtx;
    //抛弃型
    private String jmjcjPqx;
    //周边离焦(角膜接触镜)
    private String jmjcjZblj;
    //视觉训练
    private String sjxl;
    //调节训练
    private String sjxlTjxl;
    //融像训练
    private String sjxlRxxl;
    //精细训练
    private String sjxlJxxl;
    //视认知训练
    private String sjxlSrzxl;
    //加强散开训练
    private String sjxlJqskxl;
    //加强集合训练
    private String sjxlJqjhxl;
    //加强调节放松训练
    private String sjxlJqtjfsxl;
    //云夹监控用眼行为
    private String yjjkyyxw;
    //低视力助视器验配
    private String dslzsqjp;
    //弱视遮盖方式
    private String rszgfs;
    //用眼卫生
    private String yyws;
    //医嘱
    private String yizhu;
    //戴镜方式
    private String way;
    //复诊时间
    private String followTime;
    //复诊类型
    private String visitType;
    //删除状态0删除1未删除
    private String status;
    //是否结算
    private String haveid;

    private String newOld;
    public String getNewOld() {
        return newOld;
    }

    public void setNewOld(String newOld) {
        this.newOld = newOld;
    }
    public String getHaveid() {
        return haveid;
    }

    public void setHaveid(String haveid) {
        this.haveid = haveid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    /**
     * 设置：检查结论id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：检查结论id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 获取：卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置：验光号
     */
    public void setPtometryNumber(String ptometryNumber) {
        this.ptometryNumber = ptometryNumber;
    }

    /**
     * 获取：验光号
     */
    public String getPtometryNumber() {
        return ptometryNumber;
    }

    /**
     * 设置：验光师
     */
    public void setOptometryName(String optometryName) {
        this.optometryName = optometryName;
    }

    /**
     * 获取：验光师
     */
    public String getOptometryName() {
        return optometryName;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：正规
     */
    public void setCbzdZg(String cbzdZg) {
        this.cbzdZg = cbzdZg;
    }

    /**
     * 获取：正规
     */
    public String getCbzdZg() {
        return cbzdZg;
    }

    /**
     * 设置：远视眼
     */
    public void setCbzdYsy(String cbzdYsy) {
        this.cbzdYsy = cbzdYsy;
    }

    /**
     * 获取：远视眼
     */
    public String getCbzdYsy() {
        return cbzdYsy;
    }

    /**
     * 设置：近视眼
     */
    public void setCbzdJsy(String cbzdJsy) {
        this.cbzdJsy = cbzdJsy;
    }

    /**
     * 获取：近视眼
     */
    public String getCbzdJsy() {
        return cbzdJsy;
    }

    /**
     * 设置：散光
     */
    public void setCbzdSg(String cbzdSg) {
        this.cbzdSg = cbzdSg;
    }

    /**
     * 获取：散光
     */
    public String getCbzdSg() {
        return cbzdSg;
    }

    /**
     * 设置：屈光参差
     */
    public void setCbzdQgcc(String cbzdQgcc) {
        this.cbzdQgcc = cbzdQgcc;
    }

    /**
     * 获取：屈光参差
     */
    public String getCbzdQgcc() {
        return cbzdQgcc;
    }

    /**
     * 设置：弱视
     */
    public void setCbzdRs(String cbzdRs) {
        this.cbzdRs = cbzdRs;
    }

    /**
     * 获取：弱视
     */
    public String getCbzdRs() {
        return cbzdRs;
    }

    /**
     * 设置：斜视
     */
    public void setCbzdXs(String cbzdXs) {
        this.cbzdXs = cbzdXs;
    }

    /**
     * 获取：斜视
     */
    public String getCbzdXs() {
        return cbzdXs;
    }

    /**
     * 设置：老视
     */
    public void setCbzdLs(String cbzdLs) {
        this.cbzdLs = cbzdLs;
    }

    /**
     * 获取：老视
     */
    public String getCbzdLs() {
        return cbzdLs;
    }

    /**
     * 设置：眼球震颤
     */
    public void setCbzdYqzc(String cbzdYqzc) {
        this.cbzdYqzc = cbzdYqzc;
    }

    /**
     * 获取：眼球震颤
     */
    public String getCbzdYqzc() {
        return cbzdYqzc;
    }

    /**
     * 设置：低视力
     */
    public void setCbzdDsl(String cbzdDsl) {
        this.cbzdDsl = cbzdDsl;
    }

    /**
     * 获取：低视力
     */
    public String getCbzdDsl() {
        return cbzdDsl;
    }

    /**
     * 设置：备注
     */
    public void setCbzdBz(String cbzdBz) {
        this.cbzdBz = cbzdBz;
    }

    /**
     * 获取：备注
     */
    public String getCbzdBz() {
        return cbzdBz;
    }

    /**
     * 设置：双眼视功能评估
     */
    public void setCbzdSypg(String cbzdSypg) {
        this.cbzdSypg = cbzdSypg;
    }

    /**
     * 获取：双眼视功能评估
     */
    public String getCbzdSypg() {
        return cbzdSypg;
    }

    /**
     * 设置：框架眼镜
     */
    public void setKjyj(String kjyj) {
        this.kjyj = kjyj;
    }

    /**
     * 获取：框架眼镜
     */
    public String getKjyj() {
        return kjyj;
    }

    /**
     * 设置：非球面
     */
    public void setKjyjFqm(String kjyjFqm) {
        this.kjyjFqm = kjyjFqm;
    }

    /**
     * 获取：非球面
     */
    public String getKjyjFqm() {
        return kjyjFqm;
    }

    /**
     * 设置：球面
     */
    public void setKjyjQm(String kjyjQm) {
        this.kjyjQm = kjyjQm;
    }

    /**
     * 获取：球面
     */
    public String getKjyjQm() {
        return kjyjQm;
    }

    /**
     * 设置：渐进多焦点
     */
    public void setKjyjJjdjd(String kjyjJjdjd) {
        this.kjyjJjdjd = kjyjJjdjd;
    }

    /**
     * 获取：渐进多焦点
     */
    public String getKjyjJjdjd() {
        return kjyjJjdjd;
    }

    /**
     * 设置：变色片
     */
    public void setKjyjBsp(String kjyjBsp) {
        this.kjyjBsp = kjyjBsp;
    }

    /**
     * 获取：变色片
     */
    public String getKjyjBsp() {
        return kjyjBsp;
    }

    /**
     * 设置：防蓝光
     */
    public void setKjyjFlg(String kjyjFlg) {
        this.kjyjFlg = kjyjFlg;
    }

    /**
     * 获取：防蓝光
     */
    public String getKjyjFlg() {
        return kjyjFlg;
    }

    /**
     * 设置：周边离焦(框架眼镜)
     */
    public void setKjyjZblj(String kjyjZblj) {
        this.kjyjZblj = kjyjZblj;
    }

    /**
     * 获取：周边离焦(框架眼镜)
     */
    public String getKjyjZblj() {
        return kjyjZblj;
    }

    /**
     * 设置：角膜接触镜
     */
    public void setJmjcj(String jmjcj) {
        this.jmjcj = jmjcj;
    }

    /**
     * 获取：角膜接触镜
     */
    public String getJmjcj() {
        return jmjcj;
    }

    /**
     * 设置：OK
     */
    public void setJmjcjOk(String jmjcjOk) {
        this.jmjcjOk = jmjcjOk;
    }

    /**
     * 获取：OK
     */
    public String getJmjcjOk() {
        return jmjcjOk;
    }

    /**
     * 设置：RGB
     */
    public void setJmjcjRgb(String jmjcjRgb) {
        this.jmjcjRgb = jmjcjRgb;
    }

    /**
     * 获取：RGB
     */
    public String getJmjcjRgb() {
        return jmjcjRgb;
    }

    /**
     * 设置：散光
     */
    public void setJmjcjSg(String jmjcjSg) {
        this.jmjcjSg = jmjcjSg;
    }

    /**
     * 获取：散光
     */
    public String getJmjcjSg() {
        return jmjcjSg;
    }

    /**
     * 设置：传统型
     */
    public void setJmjcjCtx(String jmjcjCtx) {
        this.jmjcjCtx = jmjcjCtx;
    }

    /**
     * 获取：传统型
     */
    public String getJmjcjCtx() {
        return jmjcjCtx;
    }

    /**
     * 设置：抛弃型
     */
    public void setJmjcjPqx(String jmjcjPqx) {
        this.jmjcjPqx = jmjcjPqx;
    }

    /**
     * 获取：抛弃型
     */
    public String getJmjcjPqx() {
        return jmjcjPqx;
    }

    /**
     * 设置：周边离焦(角膜接触镜)
     */
    public void setJmjcjZblj(String jmjcjZblj) {
        this.jmjcjZblj = jmjcjZblj;
    }

    /**
     * 获取：周边离焦(角膜接触镜)
     */
    public String getJmjcjZblj() {
        return jmjcjZblj;
    }

    /**
     * 设置：视觉训练
     */
    public void setSjxl(String sjxl) {
        this.sjxl = sjxl;
    }

    /**
     * 获取：视觉训练
     */
    public String getSjxl() {
        return sjxl;
    }

    /**
     * 设置：调节训练
     */
    public void setSjxlTjxl(String sjxlTjxl) {
        this.sjxlTjxl = sjxlTjxl;
    }

    /**
     * 获取：调节训练
     */
    public String getSjxlTjxl() {
        return sjxlTjxl;
    }

    /**
     * 设置：融像训练
     */
    public void setSjxlRxxl(String sjxlRxxl) {
        this.sjxlRxxl = sjxlRxxl;
    }

    /**
     * 获取：融像训练
     */
    public String getSjxlRxxl() {
        return sjxlRxxl;
    }

    /**
     * 设置：精细训练
     */
    public void setSjxlJxxl(String sjxlJxxl) {
        this.sjxlJxxl = sjxlJxxl;
    }

    /**
     * 获取：精细训练
     */
    public String getSjxlJxxl() {
        return sjxlJxxl;
    }

    /**
     * 设置：视认知训练
     */
    public void setSjxlSrzxl(String sjxlSrzxl) {
        this.sjxlSrzxl = sjxlSrzxl;
    }

    /**
     * 获取：视认知训练
     */
    public String getSjxlSrzxl() {
        return sjxlSrzxl;
    }

    /**
     * 设置：加强散开训练
     */
    public void setSjxlJqskxl(String sjxlJqskxl) {
        this.sjxlJqskxl = sjxlJqskxl;
    }

    /**
     * 获取：加强散开训练
     */
    public String getSjxlJqskxl() {
        return sjxlJqskxl;
    }

    /**
     * 设置：加强集合训练
     */
    public void setSjxlJqjhxl(String sjxlJqjhxl) {
        this.sjxlJqjhxl = sjxlJqjhxl;
    }

    /**
     * 获取：加强集合训练
     */
    public String getSjxlJqjhxl() {
        return sjxlJqjhxl;
    }

    /**
     * 设置：加强调节放松训练
     */
    public void setSjxlJqtjfsxl(String sjxlJqtjfsxl) {
        this.sjxlJqtjfsxl = sjxlJqtjfsxl;
    }

    /**
     * 获取：加强调节放松训练
     */
    public String getSjxlJqtjfsxl() {
        return sjxlJqtjfsxl;
    }

    /**
     * 设置：云夹监控用眼行为
     */
    public void setYjjkyyxw(String yjjkyyxw) {
        this.yjjkyyxw = yjjkyyxw;
    }

    /**
     * 获取：云夹监控用眼行为
     */
    public String getYjjkyyxw() {
        return yjjkyyxw;
    }

    /**
     * 设置：低视力助视器验配
     */
    public void setDslzsqjp(String dslzsqjp) {
        this.dslzsqjp = dslzsqjp;
    }

    /**
     * 获取：低视力助视器验配
     */
    public String getDslzsqjp() {
        return dslzsqjp;
    }

    /**
     * 设置：弱视遮盖方式
     */
    public void setRszgfs(String rszgfs) {
        this.rszgfs = rszgfs;
    }

    /**
     * 获取：弱视遮盖方式
     */
    public String getRszgfs() {
        return rszgfs;
    }

    /**
     * 设置：用眼卫生
     */
    public void setYyws(String yyws) {
        this.yyws = yyws;
    }

    /**
     * 获取：用眼卫生
     */
    public String getYyws() {
        return yyws;
    }

    /**
     * 设置：医嘱
     */
    public void setYizhu(String yizhu) {
        this.yizhu = yizhu;
    }

    /**
     * 获取：医嘱
     */
    public String getYizhu() {
        return yizhu;
    }

    /**
     * 设置：戴镜方式
     */
    public void setWay(String way) {
        this.way = way;
    }

    /**
     * 获取：戴镜方式
     */
    public String getWay() {
        return way;
    }

    /**
     * 设置：复诊时间
     */
    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    /**
     * 获取：复诊时间
     */
    public String getFollowTime() {
        return followTime;
    }

    /**
     * 设置：复诊类型
     */
    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    /**
     * 获取：复诊类型
     */
    public String getVisitType() {
        return visitType;
    }

    //角膜接触镜CRTid
    private Long crtId;
    //处方类型
    private String crtPrescriptionType;
    //医生
    private String crtDoctor;
    //验光师
    private String crtOptometryName;
    //试戴片编号OD
    private String crtSdbhod;
    //试戴片编号OS
    private String crtSdbhos;
    //BC(OD)
    private String ctrBcod;
    //BC(OS)
    private String crtBcos;
    //RZD(OD)
    private String crtRzdod;
    //RZD(OS)
    private String crtRzdos;
    //LZA(OD)
    private String crtLzaod;
    //LZA(OS)
    private String crtLzaos;
    //RZD2OD
    private String crtRzd2od;
    //RZD2OS
    private String crtRzd2os;
    //LZA2(OD)
    private String crtLza2od;
    //LZA2(OS)
    private String crtLza2os;
    //降幅(OD)
    private String crtJfod;
    //降幅(OS)
    private String crtJfos;
    //DIA(OD)
    private String crtDiaod;
    //DIA(OS)
    private String crtDiaos;
    //VA(OD)
    private String crtVaod;
    //VA(OS)
    private String crtVaos;
    //镜片颜色OD
    private String crtJpysod;
    //镜片颜色OS
    private String crtJpysos;
    //适用镜片OD
    private String crtSyjpod;
    //适用镜片OS
    private String crtSyjpos;
    //备注
    private String crtBeizhu;

    //球镜OD右
    private String crtSphod;
    //球镜OS左
    private String crtSphos;
    //柱镜OD
    private String crtCylod;
    //柱镜OS
    private String crtCylos;
    //轴向OD
    private String crtAxialod;
    //轴向OS
    private String crtAxialos;

    /**
     * 设置：角膜接触镜CRTid
     */
    public void setCrtId(Long crtId) {
        this.crtId = crtId;
    }

    /**
     * 获取：角膜接触镜CRTid
     */
    public Long getCrtId() {
        return crtId;
    }


    /**
     * 设置：处方类型
     */
    public void setCrtPrescriptionType(String crtPrescriptionType) {
        this.crtPrescriptionType = crtPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getCrtPrescriptionType() {
        return crtPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setCrtDoctor(String crtDoctor) {
        this.crtDoctor = crtDoctor;
    }

    /**
     * 获取：医生
     */
    public String getCrtDoctor() {
        return crtDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setCrtOptometryName(String crtOptometryName) {
        this.crtOptometryName = crtOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getCrtOptometryName() {
        return crtOptometryName;
    }

    /**
     * 设置：试戴片编号OD
     */
    public void setCrtSdbhod(String crtSdbhod) {
        this.crtSdbhod = crtSdbhod;
    }

    /**
     * 获取：试戴片编号OD
     */
    public String getCrtSdbhod() {
        return crtSdbhod;
    }

    /**
     * 设置：试戴片编号OS
     */
    public void setCrtSdbhos(String crtSdbhos) {
        this.crtSdbhos = crtSdbhos;
    }

    /**
     * 获取：试戴片编号OS
     */
    public String getCrtSdbhos() {
        return crtSdbhos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setCtrBcod(String ctrBcod) {
        this.ctrBcod = ctrBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public String getCtrBcod() {
        return ctrBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setCrtBcos(String crtBcos) {
        this.crtBcos = crtBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public String getCrtBcos() {
        return crtBcos;
    }

    /**
     * 设置：RZD(OD)
     */
    public void setCrtRzdod(String crtRzdod) {
        this.crtRzdod = crtRzdod;
    }

    /**
     * 获取：RZD(OD)
     */
    public String getCrtRzdod() {
        return crtRzdod;
    }

    /**
     * 设置：RZD(OS)
     */
    public void setCrtRzdos(String crtRzdos) {
        this.crtRzdos = crtRzdos;
    }

    /**
     * 获取：RZD(OS)
     */
    public String getCrtRzdos() {
        return crtRzdos;
    }

    /**
     * 设置：LZA(OD)
     */
    public void setCrtLzaod(String crtLzaod) {
        this.crtLzaod = crtLzaod;
    }

    /**
     * 获取：LZA(OD)
     */
    public String getCrtLzaod() {
        return crtLzaod;
    }

    /**
     * 设置：LZA(OS)
     */
    public void setCrtLzaos(String crtLzaos) {
        this.crtLzaos = crtLzaos;
    }

    /**
     * 获取：LZA(OS)
     */
    public String getCrtLzaos() {
        return crtLzaos;
    }

    /**
     * 设置：RZD2OD
     */
    public void setCrtRzd2od(String crtRzd2od) {
        this.crtRzd2od = crtRzd2od;
    }

    /**
     * 获取：RZD2OD
     */
    public String getCrtRzd2od() {
        return crtRzd2od;
    }

    /**
     * 设置：RZD2OS
     */
    public void setCrtRzd2os(String crtRzd2os) {
        this.crtRzd2os = crtRzd2os;
    }

    /**
     * 获取：RZD2OS
     */
    public String getCrtRzd2os() {
        return crtRzd2os;
    }

    /**
     * 设置：LZA2(OD)
     */
    public void setCrtLza2od(String crtLza2od) {
        this.crtLza2od = crtLza2od;
    }

    /**
     * 获取：LZA2(OD)
     */
    public String getCrtLza2od() {
        return crtLza2od;
    }

    /**
     * 设置：LZA2(OS)
     */
    public void setCrtLza2os(String crtLza2os) {
        this.crtLza2os = crtLza2os;
    }

    /**
     * 获取：LZA2(OS)
     */
    public String getCrtLza2os() {
        return crtLza2os;
    }

    /**
     * 设置：降幅(OD)
     */
    public void setCrtJfod(String crtJfod) {
        this.crtJfod = crtJfod;
    }

    /**
     * 获取：降幅(OD)
     */
    public String getCrtJfod() {
        return crtJfod;
    }

    /**
     * 设置：降幅(OS)
     */
    public void setCrtJfos(String crtJfos) {
        this.crtJfos = crtJfos;
    }

    /**
     * 获取：降幅(OS)
     */
    public String getCrtJfos() {
        return crtJfos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setCrtDiaod(String crtDiaod) {
        this.crtDiaod = crtDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public String getCrtDiaod() {
        return crtDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setCrtDiaos(String crtDiaos) {
        this.crtDiaos = crtDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public String getCrtDiaos() {
        return crtDiaos;
    }

    /**
     * 设置：VA(OD)
     */
    public void setCrtVaod(String crtVaod) {
        this.crtVaod = crtVaod;
    }

    /**
     * 获取：VA(OD)
     */
    public String getCrtVaod() {
        return crtVaod;
    }

    /**
     * 设置：VA(OS)
     */
    public void setCrtVaos(String crtVaos) {
        this.crtVaos = crtVaos;
    }

    /**
     * 获取：VA(OS)
     */
    public String getCrtVaos() {
        return crtVaos;
    }

    /**
     * 设置：镜片颜色OD
     */
    public void setCrtJpysod(String crtJpysod) {
        this.crtJpysod = crtJpysod;
    }

    /**
     * 获取：镜片颜色OD
     */
    public String getCrtJpysod() {
        return crtJpysod;
    }

    /**
     * 设置：镜片颜色OS
     */
    public void setCrtJpysos(String crtJpysos) {
        this.crtJpysos = crtJpysos;
    }

    /**
     * 获取：镜片颜色OS
     */
    public String getCrtJpysos() {
        return crtJpysos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setCrtSyjpod(String crtSyjpod) {
        this.crtSyjpod = crtSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getCrtSyjpod() {
        return crtSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setCrtSyjpos(String crtSyjpos) {
        this.crtSyjpos = crtSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getCrtSyjpos() {
        return crtSyjpos;
    }

    /**
     * 设置：备注
     */
    public void setCrtBeizhu(String crtBeizhu) {
        this.crtBeizhu = crtBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getCrtBeizhu() {
        return crtBeizhu;
    }
    /**
     * 设置：球镜OD右
     */
    public void setCrtSphod(String crtSphod) {
        this.crtSphod = crtSphod;
    }
    /**
     * 获取：球镜OD右
     */
    public String getCrtSphod() {
        return crtSphod;
    }
    /**
     * 设置：球镜OS左
     */
    public void setCrtSphos(String crtSphos) {
        this.crtSphos = crtSphos;
    }
    /**
     * 获取：球镜OS左
     */
    public String getCrtSphos() {
        return crtSphos;
    }
    /**
     * 设置：柱镜OD
     */
    public void setCrtCylod(String crtCylod) {
        this.crtCylod = crtCylod;
    }
    /**
     * 获取：柱镜OD
     */
    public String getCrtCylod() {
        return crtCylod;
    }
    /**
     * 设置：柱镜OS
     */
    public void setCrtCylos(String crtCylos) {
        this.crtCylos = crtCylos;
    }
    /**
     * 获取：柱镜OS
     */
    public String getCrtCylos() {
        return crtCylos;
    }
    /**
     * 设置：轴向OD
     */
    public void setCrtAxialod(String crtAxialod) {
        this.crtAxialod = crtAxialod;
    }
    /**
     * 获取：轴向OD
     */
    public String getCrtAxialod() {
        return crtAxialod;
    }
    /**
     * 设置：轴向OS
     */
    public void setCrtAxialos(String crtAxialos) {
        this.crtAxialos = crtAxialos;
    }
    /**
     * 获取：轴向OS
     */
    public String getCrtAxialos() {
        return crtAxialos;
    }
    //框架近用id
    private Long kjjyId;

    //处方类型
    private String kjjyPrescriptionType;
    //医生
    private String kjjyDoctor;
    //验光师
    private String kjjyOptometryName;
    //球镜OD
    private String kjjySphod;
    //球镜OS
    private String kjjySphos;
    //柱镜OD
    private String kjjyCylod;
    //柱镜OS
    private String kjjyCylos;
    //轴向OD
    private String kjjyAxialod;
    //轴向OS
    private String kjjyAxialos;
    //三棱镜(OD)
    private String kjjyPrismod;
    //三棱镜(OS)
    private String kjjyPrismos;
    //基底(OD)
    private String kjjyJdod;
    //基底(OS)
    private String kjjyJdos;
    //远用瞳距(mm)(OD)
    private String kjjyYytjod;
    //远用瞳距(mm)(OS)
    private String kjjyYytjos;
    //瞳高(mm)(OD)
    private String kjjyTgod;
    //瞳高(mm)(OS)
    private String kjjyTgos;
    //远用va(OD)
    private String kjjyVaod;
    //远用va(OS)
    private String kjjyVaos;
    //建议镜片材质
    private String kjjyJpcz;
    //处理方式
    private String kjjyClfs;
    //建议框架
    private String kjjyJykj;
    //框架类型
    private String kjjyKjlx;
    //文本
    private String kjjyText;
    //备注
    private String kjjyBeizhu;

    /**
     * 设置：框架近用id
     */
    public void setKjjyId(Long kjjyId) {
        this.kjjyId = kjjyId;
    }

    /**
     * 获取：框架近用id
     */
    public Long getKjjyId() {
        return kjjyId;
    }

    /**
     * 设置：处方类型
     */
    public void setKjjyPrescriptionType(String kjjyPrescriptionType) {
        this.kjjyPrescriptionType = kjjyPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getKjjyPrescriptionType() {
        return kjjyPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setKjjyDoctor(String kjjyDoctor) {
        this.kjjyDoctor = kjjyDoctor;
    }

    /**
     * 获取：医生
     */
    public String getKjjyDoctor() {
        return kjjyDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setKjjyOptometryName(String kjjyOptometryName) {
        this.kjjyOptometryName = kjjyOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getKjjyOptometryName() {
        return kjjyOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setKjjySphod(String kjjySphod) {
        this.kjjySphod = kjjySphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getKjjySphod() {
        return kjjySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjjySphos(String kjjySphos) {
        this.kjjySphos = kjjySphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getKjjySphos() {
        return kjjySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjjyCylod(String kjjyCylod) {
        this.kjjyCylod = kjjyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getKjjyCylod() {
        return kjjyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjjyCylos(String kjjyCylos) {
        this.kjjyCylos = kjjyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getKjjyCylos() {
        return kjjyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjjyAxialod(String kjjyAxialod) {
        this.kjjyAxialod = kjjyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getKjjyAxialod() {
        return kjjyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjjyAxialos(String kjjyAxialos) {
        this.kjjyAxialos = kjjyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getKjjyAxialos() {
        return kjjyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjjyPrismod(String kjjyPrismod) {
        this.kjjyPrismod = kjjyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getKjjyPrismod() {
        return kjjyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjjyPrismos(String kjjyPrismos) {
        this.kjjyPrismos = kjjyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getKjjyPrismos() {
        return kjjyPrismos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setKjjyJdod(String kjjyJdod) {
        this.kjjyJdod = kjjyJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getKjjyJdod() {
        return kjjyJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setKjjyJdos(String kjjyJdos) {
        this.kjjyJdos = kjjyJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getKjjyJdos() {
        return kjjyJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setKjjyYytjod(String kjjyYytjod) {
        this.kjjyYytjod = kjjyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getKjjyYytjod() {
        return kjjyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjjyYytjos(String kjjyYytjos) {
        this.kjjyYytjos = kjjyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getKjjyYytjos() {
        return kjjyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjjyTgod(String kjjyTgod) {
        this.kjjyTgod = kjjyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getKjjyTgod() {
        return kjjyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjjyTgos(String kjjyTgos) {
        this.kjjyTgos = kjjyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getKjjyTgos() {
        return kjjyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjjyVaod(String kjjyVaod) {
        this.kjjyVaod = kjjyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getKjjyVaod() {
        return kjjyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjjyVaos(String kjjyVaos) {
        this.kjjyVaos = kjjyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getKjjyVaos() {
        return kjjyVaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setKjjyJpcz(String kjjyJpcz) {
        this.kjjyJpcz = kjjyJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getKjjyJpcz() {
        return kjjyJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setKjjyClfs(String kjjyClfs) {
        this.kjjyClfs = kjjyClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getKjjyClfs() {
        return kjjyClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setKjjyJykj(String kjjyJykj) {
        this.kjjyJykj = kjjyJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getKjjyJykj() {
        return kjjyJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setKjjyKjlx(String kjjyKjlx) {
        this.kjjyKjlx = kjjyKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getKjjyKjlx() {
        return kjjyKjlx;
    }

    /**
     * 设置：文本
     */
    public void setKjjyText(String kjjyText) {
        this.kjjyText = kjjyText;
    }

    /**
     * 获取：文本
     */
    public String getKjjyText() {
        return kjjyText;
    }

    /**
     * 设置：备注
     */
    public void setKjjyBeizhu(String kjjyBeizhu) {
        this.kjjyBeizhu = kjjyBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getKjjyBeizhu() {
        return kjjyBeizhu;
    }
    //框架远用id
    private Long kjyyId;
    //处方类型
    private String kjyyPrescriptionType;
    //kjyy医生
    private String kjyyDoctor;
    //kjyy验光师
    private String kjyyOptometryName;
    //球镜OD
    private String kjyySphod;
    //球镜OS
    private String kjyySphos;
    //柱镜OD
    private String kjyyCylod;
    //柱镜OS
    private String kjyyCylos;
    //轴向OD
    private String kjyyAxialod;
    //轴向OS
    private String kjyyAxialos;
    //三棱镜(OD)
    private String kjyyPrismod;
    //三棱镜(OS)
    private String kjyyPrismos;
    //基底(OD)
    private String kjyyJdod;
    //基底(OS)
    private String kjyyJdos;
    //远用瞳距(mm)(OD)
    private String kjyyYytjod;
    //远用瞳距(mm)(OS)
    private String kjyyYytjos;
    //瞳高(mm)(OD)
    private String kjyyTgod;
    //瞳高(mm)(OS)
    private String kjyyTgos;
    //远用va(OD)
    private String kjyyVaod;
    //远用va(OS)
    private String kjyyVaos;
    //建议镜片材质
    private String kjyyJpcz;
    //处理方式
    private String kjyyClfs;
    //建议框架
    private String kjyyJykj;
    //框架类型
    private String kjyyKjlx;
    //文本
    private String kjyyText;
    //备注
    private String kjyyBeizhu;

    /**
     * 设置：框架远用id
     */
    public void setKjyyId(Long kjyyId) {
        this.kjyyId = kjyyId;
    }

    /**
     * 获取：框架远用id
     */
    public Long getKjyyId() {
        return kjyyId;
    }


    /**
     * 设置：处方类型
     */
    public void setKjyyPrescriptionType(String kjyyPrescriptionType) {
        this.kjyyPrescriptionType = kjyyPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getKjyyPrescriptionType() {
        return kjyyPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setKjyyDoctor(String kjyyDoctor) {
        this.kjyyDoctor = kjyyDoctor;
    }

    /**
     * 获取：医生
     */
    public String getKjyyDoctor() {
        return kjyyDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setKjyyOptometryName(String kjyyOptometryName) {
        this.kjyyOptometryName = kjyyOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getKjyyOptometryName() {
        return kjyyOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setKjyySphod(String kjyySphod) {
        this.kjyySphod = kjyySphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getKjyySphod() {
        return kjyySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjyySphos(String kjyySphos) {
        this.kjyySphos = kjyySphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getKjyySphos() {
        return kjyySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjyyCylod(String kjyyCylod) {
        this.kjyyCylod = kjyyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getKjyyCylod() {
        return kjyyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjyyCylos(String kjyyCylos) {
        this.kjyyCylos = kjyyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getKjyyCylos() {
        return kjyyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjyyAxialod(String kjyyAxialod) {
        this.kjyyAxialod = kjyyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getKjyyAxialod() {
        return kjyyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjyyAxialos(String kjyyAxialos) {
        this.kjyyAxialos = kjyyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getKjyyAxialos() {
        return kjyyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjyyPrismod(String kjyyPrismod) {
        this.kjyyPrismod = kjyyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getKjyyPrismod() {
        return kjyyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjyyPrismos(String kjyyPrismos) {
        this.kjyyPrismos = kjyyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getKjyyPrismos() {
        return kjyyPrismos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setKjyyJdod(String kjyyJdod) {
        this.kjyyJdod = kjyyJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getKjyyJdod() {
        return kjyyJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setKjyyJdos(String kjyyJdos) {
        this.kjyyJdos = kjyyJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getKjyyJdos() {
        return kjyyJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setKjyyYytjod(String kjyyYytjod) {
        this.kjyyYytjod = kjyyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getKjyyYytjod() {
        return kjyyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjyyYytjos(String kjyyYytjos) {
        this.kjyyYytjos = kjyyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getKjyyYytjos() {
        return kjyyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjyyTgod(String kjyyTgod) {
        this.kjyyTgod = kjyyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getKjyyTgod() {
        return kjyyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjyyTgos(String kjyyTgos) {
        this.kjyyTgos = kjyyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getKjyyTgos() {
        return kjyyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjyyVaod(String kjyyVaod) {
        this.kjyyVaod = kjyyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getKjyyVaod() {
        return kjyyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjyyVaos(String kjyyVaos) {
        this.kjyyVaos = kjyyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getKjyyVaos() {
        return kjyyVaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setKjyyJpcz(String kjyyJpcz) {
        this.kjyyJpcz = kjyyJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getKjyyJpcz() {
        return kjyyJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setKjyyClfs(String kjyyClfs) {
        this.kjyyClfs = kjyyClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getKjyyClfs() {
        return kjyyClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setKjyyJykj(String kjyyJykj) {
        this.kjyyJykj = kjyyJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getKjyyJykj() {
        return kjyyJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setKjyyKjlx(String kjyyKjlx) {
        this.kjyyKjlx = kjyyKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getKjyyKjlx() {
        return kjyyKjlx;
    }

    /**
     * 设置：文本
     */
    public void setKjyyText(String kjyyText) {
        this.kjyyText = kjyyText;
    }

    /**
     * 获取：文本
     */
    public String getKjyyText() {
        return kjyyText;
    }

    /**
     * 设置：备注
     */
    public void setKjyyBeizhu(String kjyyBeizhu) {
        this.kjyyBeizhu = kjyyBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getKjyyBeizhu() {
        return kjyyBeizhu;
    }

    private Long rgpId;

    //处方类型
    private String rgpPrescriptionType;
    //医生
    private String rgpDoctor;
    //验光师
    private String rgpOptometryName;
    //屈光度OD
    private String rgpQgdod;
    //屈光度OS
    private String rgpQgdos;
    //BC(OD)
    private String rgpBcod;
    //BC(OS)
    private String rgpBcos;
    //DIA(OD)
    private String rgpDiaod;
    //DIA(OS)
    private String rgpDiaos;
    //散光(OD)
    private String rgpSgod;
    //散光(OS)
    private String rgpSgos;
    //镜片颜色OD
    private String rgpJpysod;
    //镜片颜色OS
    private String rgpJpysos;
    //特殊设计OD
    private String rgpTssjod;
    //特殊设计OS
    private String rgpTssjos;
    //适用镜片OD
    private String rgpSyjpod;
    //适用镜片OS
    private String rgpSyjpos;
    //备注
    private String rgpBeizhu;
    //球镜OD右
    private String rgpSphod;
    //球镜OS左
    private String rgpSphos;
    //柱镜OD
    private String rgpCylod;
    //柱镜OS
    private String rgpCylos;
    //轴向OD
    private String rgpAxialod;
    //轴向OS
    private String rgpAxialos;

    /**
     * 设置：角膜接触镜CRTid
     */
    public void setRgpId(Long rgpId) {
        this.rgpId = rgpId;
    }

    /**
     * 获取：角膜接触镜CRTid
     */
    public Long getRgpId() {
        return rgpId;
    }


    /**
     * 设置：处方类型
     */
    public void setRgpPrescriptionType(String rgpPrescriptionType) {
        this.rgpPrescriptionType = rgpPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getRgpPrescriptionType() {
        return rgpPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setRgpDoctor(String rgpDoctor) {
        this.rgpDoctor = rgpDoctor;
    }

    /**
     * 获取：医生
     */
    public String getRgpDoctor() {
        return rgpDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setRgpOptometryName(String rgpOptometryName) {
        this.rgpOptometryName = rgpOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getRgpOptometryName() {
        return rgpOptometryName;
    }

    /**
     * 设置：屈光度OD
     */
    public void setRgpQgdod(String rgpQgdod) {
        this.rgpQgdod = rgpQgdod;
    }

    /**
     * 获取：屈光度OD
     */
    public String getRgpQgdod() {
        return rgpQgdod;
    }

    /**
     * 设置：屈光度OS
     */
    public void setRgpQgdos(String rgpQgdos) {
        this.rgpQgdos = rgpQgdos;
    }

    /**
     * 获取：屈光度OS
     */
    public String getRgpQgdos() {
        return rgpQgdos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setRgpBcod(String rgpBcod) {
        this.rgpBcod = rgpBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public String getRgpBcod() {
        return rgpBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setRgpBcos(String rgpBcos) {
        this.rgpBcos = rgpBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public String getRgpBcos() {
        return rgpBcos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setRgpDiaod(String rgpDiaod) {
        this.rgpDiaod = rgpDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public String getRgpDiaod() {
        return rgpDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setRgpDiaos(String rgpDiaos) {
        this.rgpDiaos = rgpDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public String getRgpDiaos() {
        return rgpDiaos;
    }

    /**
     * 设置：散光(OD)
     */
    public void setRgpSgod(String rgpSgod) {
        this.rgpSgod = rgpSgod;
    }

    /**
     * 获取：散光(OD)
     */
    public String getRgpSgod() {
        return rgpSgod;
    }

    /**
     * 设置：散光(OS)
     */
    public void setRgpSgos(String rgpSgos) {
        this.rgpSgos = rgpSgos;
    }

    /**
     * 获取：散光(OS)
     */
    public String getRgpSgos() {
        return rgpSgos;
    }

    /**
     * 设置：镜片颜色OD
     */
    public void setRgpJpysod(String rgpJpysod) {
        this.rgpJpysod = rgpJpysod;
    }

    /**
     * 获取：镜片颜色OD
     */
    public String getRgpJpysod() {
        return rgpJpysod;
    }

    /**
     * 设置：镜片颜色OS
     */
    public void setRgpJpysos(String rgpJpysos) {
        this.rgpJpysos = rgpJpysos;
    }

    /**
     * 获取：镜片颜色OS
     */
    public String getRgpJpysos() {
        return rgpJpysos;
    }

    /**
     * 设置：特殊设计OD
     */
    public void setRgpTssjod(String rgpTssjod) {
        this.rgpTssjod = rgpTssjod;
    }

    /**
     * 获取：特殊设计OD
     */
    public String getRgpTssjod() {
        return rgpTssjod;
    }

    /**
     * 设置：特殊设计OS
     */
    public void setRgpTssjos(String rgpTssjos) {
        this.rgpTssjos = rgpTssjos;
    }

    /**
     * 获取：特殊设计OS
     */
    public String getRgpTssjos() {
        return rgpTssjos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setRgpSyjpod(String rgpSyjpod) {
        this.rgpSyjpod = rgpSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getRgpSyjpod() {
        return rgpSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setRgpSyjpos(String rgpSyjpos) {
        this.rgpSyjpos = rgpSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getRgpSyjpos() {
        return rgpSyjpos;
    }

    /**
     * 设置：备注
     */
    public void setRgpBeizhu(String rgpBeizhu) {
        this.rgpBeizhu = rgpBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getRgpBeizhu() {
        return rgpBeizhu;
    }

    /**
     * 设置：球镜OD右
     */
    public void setRgpSphod(String rgpSphod) {
        this.rgpSphod = rgpSphod;
    }
    /**
     * 获取：球镜OD右
     */
    public String getRgpSphod() {
        return rgpSphod;
    }
    /**
     * 设置：球镜OS左
     */
    public void setRgpSphos(String rgpSphos) {
        this.rgpSphos = rgpSphos;
    }
    /**
     * 获取：球镜OS左
     */
    public String getRgpSphos() {
        return rgpSphos;
    }
    /**
     * 设置：柱镜OD
     */
    public void setRgpCylod(String rgpCylod) {
        this.rgpCylod = rgpCylod;
    }
    /**
     * 获取：柱镜OD
     */
    public String getRgpCylod() {
        return rgpCylod;
    }
    /**
     * 设置：柱镜OS
     */
    public void setRgpCylos(String rgpCylos) {
        this.rgpCylos = rgpCylos;
    }
    /**
     * 获取：柱镜OS
     */
    public String getRgpCylos() {
        return rgpCylos;
    }
    /**
     * 设置：轴向OD
     */
    public void setRgpAxialod(String rgpAxialod) {
        this.rgpAxialod = rgpAxialod;
    }
    /**
     * 获取：轴向OD
     */
    public String getRgpAxialod() {
        return rgpAxialod;
    }
    /**
     * 设置：轴向OS
     */
    public void setRgpAxialos(String rgpAxialos) {
        this.rgpAxialos = rgpAxialos;
    }
    /**
     * 获取：轴向OS
     */
    public String getRgpAxialos() {
        return rgpAxialos;
    }
    //软性角膜接触镜id
    private Long rxId;

    //处方类型
    private String rxPrescriptionType;
    //医生
    private String rxDoctor;
    //验光师
    private String rxOptometryName;
    //BC(OD)
    private String rxBcod;
    //BC(OS)
    private String rxBcos;
    //球镜OD
    private String rxSphod;
    //球镜OS
    private String rxSphos;
    //柱镜OD
    private String rxCylod;
    //柱镜OS
    private String rxCylos;
    //轴向OD
    private String rxAxialod;
    //轴向OS
    private String rxAxialos;
    //直径(OD)
    private String rxZjod;
    //直径(OS)
    private String rxZjos;
    //va(OD)
    private String rxVaod;
    //va(OS)
    private String rxVaos;
    //适用镜片OD
    private String rxSyjpod;
    //适用镜片OS
    private String rxSyjpos;
    //片/盒OD
    private String rxUnitod;
    //片/盒OS
    private String rxUnitos;
    //软性角膜接触镜处理方式
    private String rxClfs;
    //护理液品种
    private String rxHlypz;
    //备注
    private String rxBeizhu;

    /**
     * 设置：软性角膜接触镜id
     */
    public void setRxId(Long rxId) {
        this.rxId = rxId;
    }

    /**
     * 获取：软性角膜接触镜id
     */
    public Long getRxId() {
        return rxId;
    }


    /**
     * 设置：处方类型
     */
    public void setRxPrescriptionType(String rxPrescriptionType) {
        this.rxPrescriptionType = rxPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getRxPrescriptionType() {
        return rxPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setRxDoctor(String rxDoctor) {
        this.rxDoctor = rxDoctor;
    }

    /**
     * 获取：医生
     */
    public String getRxDoctor() {
        return rxDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setRxOptometryName(String rxOptometryName) {
        this.rxOptometryName = rxOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getRxOptometryName() {
        return rxOptometryName;
    }

    /**
     * 设置：BC(OD)
     */
    public void setRxBcod(String rxBcod) {
        this.rxBcod = rxBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public String getRxBcod() {
        return rxBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setRxBcos(String rxBcos) {
        this.rxBcos = rxBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public String getRxBcos() {
        return rxBcos;
    }

    /**
     * 设置：球镜OD
     */
    public void setRxSphod(String rxSphod) {
        this.rxSphod = rxSphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getRxSphod() {
        return rxSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setRxSphos(String rxSphos) {
        this.rxSphos = rxSphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getRxSphos() {
        return rxSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setRxCylod(String rxCylod) {
        this.rxCylod = rxCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getRxCylod() {
        return rxCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setRxCylos(String rxCylos) {
        this.rxCylos = rxCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getRxCylos() {
        return rxCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setRxAxialod(String rxAxialod) {
        this.rxAxialod = rxAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getRxAxialod() {
        return rxAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setRxAxialos(String rxAxialos) {
        this.rxAxialos = rxAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getRxAxialos() {
        return rxAxialos;
    }

    /**
     * 设置：直径(OD)
     */
    public void setRxZjod(String rxZjod) {
        this.rxZjod = rxZjod;
    }

    /**
     * 获取：直径(OD)
     */
    public String getRxZjod() {
        return rxZjod;
    }

    /**
     * 设置：直径(OS)
     */
    public void setRxZjos(String rxZjos) {
        this.rxZjos = rxZjos;
    }

    /**
     * 获取：直径(OS)
     */
    public String getRxZjos() {
        return rxZjos;
    }

    /**
     * 设置：va(OD)
     */
    public void setRxVaod(String rxVaod) {
        this.rxVaod = rxVaod;
    }

    /**
     * 获取：va(OD)
     */
    public String getRxVaod() {
        return rxVaod;
    }

    /**
     * 设置：va(OS)
     */
    public void setRxVaos(String rxVaos) {
        this.rxVaos = rxVaos;
    }

    /**
     * 获取：va(OS)
     */
    public String getRxVaos() {
        return rxVaos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setRxSyjpod(String rxSyjpod) {
        this.rxSyjpod = rxSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getRxSyjpod() {
        return rxSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setRxSyjpos(String rxSyjpos) {
        this.rxSyjpos = rxSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getRxSyjpos() {
        return rxSyjpos;
    }

    /**
     * 设置：片/盒OD
     */
    public void setRxUnitod(String rxUnitod) {
        this.rxUnitod = rxUnitod;
    }

    /**
     * 获取：片/盒OD
     */
    public String getRxUnitod() {
        return rxUnitod;
    }

    /**
     * 设置：片/盒OS
     */
    public void setRxUnitos(String rxUnitos) {
        this.rxUnitos = rxUnitos;
    }

    /**
     * 获取：片/盒OS
     */
    public String getRxUnitos() {
        return rxUnitos;
    }

    /**
     * 设置：软性角膜接触镜处理方式
     */
    public void setRxClfs(String rxClfs) {
        this.rxClfs = rxClfs;
    }

    /**
     * 获取：软性角膜接触镜处理方式
     */
    public String getRxClfs() {
        return rxClfs;
    }

    /**
     * 设置：护理液品种
     */
    public void setRxHlypz(String rxHlypz) {
        this.rxHlypz = rxHlypz;
    }

    /**
     * 获取：护理液品种
     */
    public String getRxHlypz() {
        return rxHlypz;
    }

    /**
     * 设置：备注
     */
    public void setRxBeizhu(String rxBeizhu) {
        this.rxBeizhu = rxBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getRxBeizhu() {
        return rxBeizhu;
    }
    //双光渐进id
    private Long sgjjId;

    //处方类型
    private String sgjjPrescriptionType;
    //医生
    private String sgjjDoctor;
    //验光师
    private String sgjjOptometryName;
    //球镜OD
    private String sgjjSphod;
    //球镜OS
    private String sgjjSphos;
    //柱镜OD
    private String sgjjCylod;
    //柱镜OS
    private String sgjjCylos;
    //轴向OD
    private String sgjjAxialod;
    //轴向OS
    private String sgjjAxialos;
    //Add(OD)
    private String sgjjAddod;
    //Add(OS)
    private String sgjjAddos;
    //远用瞳距(mm)(OD)
    private String sgjjYytjod;
    //远用瞳距(mm)(OS)
    private String sgjjYytjos;
    //近用瞳距(mm)(OD)
    private String sgjjJytjod;
    //近用瞳距(mm)(OS)
    private String sgjjJytjos;
    //瞳高(mm)(OD)
    private String sgjjTgod;
    //瞳高(mm)(OS)
    private String sgjjTgos;
    //远用va(OD)
    private String sgjjYyvaod;
    //远用va(OS)
    private String sgjjYyvaos;
    //近用va(OD)
    private String sgjjJyvaod;
    //近用va(OS)
    private String sgjjJyvaos;
    //建议镜片材质
    private String sgjjJpcz;
    //处理方式
    private String sgjjClfs;
    //建议框架
    private String sgjjJykj;
    //框架类型
    private String sgjjKjlx;
    //文本
    private String sgjjText;
    //备注
    private String sgjjBeizhu;

    /**
     * 设置：双光渐进id
     */
    public void setSgjjId(Long sgjjId) {
        this.sgjjId = sgjjId;
    }

    /**
     * 获取：双光渐进id
     */
    public Long getSgjjId() {
        return sgjjId;
    }



    /**
     * 设置：处方类型
     */
    public void setSgjjPrescriptionType(String sgjjPrescriptionType) {
        this.sgjjPrescriptionType = sgjjPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getSgjjPrescriptionType() {
        return sgjjPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setSgjjDoctor(String sgjjDoctor) {
        this.sgjjDoctor = sgjjDoctor;
    }

    /**
     * 获取：医生
     */
    public String getSgjjDoctor() {
        return sgjjDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setSgjjOptometryName(String sgjjOptometryName) {
        this.sgjjOptometryName = sgjjOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getSgjjOptometryName() {
        return sgjjOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setSgjjSphod(String sgjjSphod) {
        this.sgjjSphod = sgjjSphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getSgjjSphod() {
        return sgjjSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSgjjSphos(String sgjjSphos) {
        this.sgjjSphos = sgjjSphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getSgjjSphos() {
        return sgjjSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSgjjCylod(String sgjjCylod) {
        this.sgjjCylod = sgjjCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getSgjjCylod() {
        return sgjjCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSgjjCylos(String sgjjCylos) {
        this.sgjjCylos = sgjjCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getSgjjCylos() {
        return sgjjCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSgjjAxialod(String sgjjAxialod) {
        this.sgjjAxialod = sgjjAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getSgjjAxialod() {
        return sgjjAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSgjjAxialos(String sgjjAxialos) {
        this.sgjjAxialos = sgjjAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getSgjjAxialos() {
        return sgjjAxialos;
    }

    /**
     * 设置：Add(OD)
     */
    public void setSgjjAddod(String sgjjAddod) {
        this.sgjjAddod = sgjjAddod;
    }

    /**
     * 获取：Add(OD)
     */
    public String getSgjjAddod() {
        return sgjjAddod;
    }

    /**
     * 设置：Add(OS)
     */
    public void setSgjjAddos(String sgjjAddos) {
        this.sgjjAddos = sgjjAddos;
    }

    /**
     * 获取：Add(OS)
     */
    public String getSgjjAddos() {
        return sgjjAddos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSgjjYytjod(String sgjjYytjod) {
        this.sgjjYytjod = sgjjYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getSgjjYytjod() {
        return sgjjYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSgjjYytjos(String sgjjYytjos) {
        this.sgjjYytjos = sgjjYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getSgjjYytjos() {
        return sgjjYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSgjjJytjod(String sgjjJytjod) {
        this.sgjjJytjod = sgjjJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public String getSgjjJytjod() {
        return sgjjJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSgjjJytjos(String sgjjJytjos) {
        this.sgjjJytjos = sgjjJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public String getSgjjJytjos() {
        return sgjjJytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setSgjjTgod(String sgjjTgod) {
        this.sgjjTgod = sgjjTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getSgjjTgod() {
        return sgjjTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setSgjjTgos(String sgjjTgos) {
        this.sgjjTgos = sgjjTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getSgjjTgos() {
        return sgjjTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSgjjYyvaod(String sgjjYyvaod) {
        this.sgjjYyvaod = sgjjYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getSgjjYyvaod() {
        return sgjjYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSgjjYyvaos(String sgjjYyvaos) {
        this.sgjjYyvaos = sgjjYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getSgjjYyvaos() {
        return sgjjYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSgjjJyvaod(String sgjjJyvaod) {
        this.sgjjJyvaod = sgjjJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public String getSgjjJyvaod() {
        return sgjjJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSgjjJyvaos(String sgjjJyvaos) {
        this.sgjjJyvaos = sgjjJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public String getSgjjJyvaos() {
        return sgjjJyvaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setSgjjJpcz(String sgjjJpcz) {
        this.sgjjJpcz = sgjjJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getSgjjJpcz() {
        return sgjjJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setSgjjClfs(String sgjjClfs) {
        this.sgjjClfs = sgjjClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getSgjjClfs() {
        return sgjjClfs;
    }

    /**
     * 设置：建议框架
     */
    public void setSgjjJykj(String sgjjJykj) {
        this.sgjjJykj = sgjjJykj;
    }

    /**
     * 获取：建议框架
     */
    public String getSgjjJykj() {
        return sgjjJykj;
    }

    /**
     * 设置：框架类型
     */
    public void setSgjjKjlx(String sgjjKjlx) {
        this.sgjjKjlx = sgjjKjlx;
    }

    /**
     * 获取：框架类型
     */
    public String getSgjjKjlx() {
        return sgjjKjlx;
    }

    /**
     * 设置：文本
     */
    public void setSgjjText(String sgjjText) {
        this.sgjjText = sgjjText;
    }

    /**
     * 获取：文本
     */
    public String getSgjjText() {
        return sgjjText;
    }

    /**
     * 设置：备注
     */
    public void setSgjjBeizhu(String sgjjBeizhu) {
        this.sgjjBeizhu = sgjjBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getSgjjBeizhu() {
        return sgjjBeizhu;
    }

    //裸眼视力远OU
    private String farLyou;
    //裸眼视力远OD
    private String farLyod;
    //裸眼视力远OS
    private String farLyos;
    //裸眼视力近OU
    private String nearLyou;
    //裸眼视力近OD
    private String nearLyod;
    //裸眼视力近OS
    private String nearLyos;
    //原镜视力远OU
    private String farYjou;
    //原镜视力远OD
    private String farYjod;
    //原镜视力远OS
    private String farYjos;
    //原镜视力近OU
    private String nearYjou;
    //原镜视力近OD
    private String nearYjod;
    //原镜视力近OS
    private String nearYjos;
    //小孔视力远OU
    private String farXkou;
    //小孔视力远OD
    private String farXkod;
    //小孔视力远OS
    private String farXkos;
    //小孔视力近OU
    private String nearXkou;
    //小孔视力近OD
    private String nearXkod;
    //小孔视力近OS
    private String nearXkos;
    //主导眼
    private String dominantEye;


    /**
     * 设置：裸眼视力远OU
     */
    public void setFarLyou(String farLyou) {
        this.farLyou = farLyou;
    }

    /**
     * 获取：裸眼视力远OU
     */
    public String getFarLyou() {
        return farLyou;
    }

    /**
     * 设置：裸眼视力远OD
     */
    public void setFarLyod(String farLyod) {
        this.farLyod = farLyod;
    }

    /**
     * 获取：裸眼视力远OD
     */
    public String getFarLyod() {
        return farLyod;
    }

    /**
     * 设置：裸眼视力远OS
     */
    public void setFarLyos(String farLyos) {
        this.farLyos = farLyos;
    }

    /**
     * 获取：裸眼视力远OS
     */
    public String getFarLyos() {
        return farLyos;
    }

    /**
     * 设置：裸眼视力近OU
     */
    public void setNearLyou(String nearLyou) {
        this.nearLyou = nearLyou;
    }

    /**
     * 获取：裸眼视力近OU
     */
    public String getNearLyou() {
        return nearLyou;
    }

    /**
     * 设置：裸眼视力近OD
     */
    public void setNearLyod(String nearLyod) {
        this.nearLyod = nearLyod;
    }

    /**
     * 获取：裸眼视力近OD
     */
    public String getNearLyod() {
        return nearLyod;
    }

    /**
     * 设置：裸眼视力近OS
     */
    public void setNearLyos(String nearLyos) {
        this.nearLyos = nearLyos;
    }

    /**
     * 获取：裸眼视力近OS
     */
    public String getNearLyos() {
        return nearLyos;
    }

    /**
     * 设置：原镜视力远OU
     */
    public void setFarYjou(String farYjou) {
        this.farYjou = farYjou;
    }

    /**
     * 获取：原镜视力远OU
     */
    public String getFarYjou() {
        return farYjou;
    }

    /**
     * 设置：原镜视力远OD
     */
    public void setFarYjod(String farYjod) {
        this.farYjod = farYjod;
    }

    /**
     * 获取：原镜视力远OD
     */
    public String getFarYjod() {
        return farYjod;
    }

    /**
     * 设置：原镜视力远OS
     */
    public void setFarYjos(String farYjos) {
        this.farYjos = farYjos;
    }

    /**
     * 获取：原镜视力远OS
     */
    public String getFarYjos() {
        return farYjos;
    }

    /**
     * 设置：原镜视力近OU
     */
    public void setNearYjou(String nearYjou) {
        this.nearYjou = nearYjou;
    }

    /**
     * 获取：原镜视力近OU
     */
    public String getNearYjou() {
        return nearYjou;
    }

    /**
     * 设置：原镜视力近OD
     */
    public void setNearYjod(String nearYjod) {
        this.nearYjod = nearYjod;
    }

    /**
     * 获取：原镜视力近OD
     */
    public String getNearYjod() {
        return nearYjod;
    }

    /**
     * 设置：原镜视力近OS
     */
    public void setNearYjos(String nearYjos) {
        this.nearYjos = nearYjos;
    }

    /**
     * 获取：原镜视力近OS
     */
    public String getNearYjos() {
        return nearYjos;
    }

    /**
     * 设置：小孔视力远OU
     */
    public void setFarXkou(String farXkou) {
        this.farXkou = farXkou;
    }

    /**
     * 获取：小孔视力远OU
     */
    public String getFarXkou() {
        return farXkou;
    }

    /**
     * 设置：小孔视力远OD
     */
    public void setFarXkod(String farXkod) {
        this.farXkod = farXkod;
    }

    /**
     * 获取：小孔视力远OD
     */
    public String getFarXkod() {
        return farXkod;
    }

    /**
     * 设置：小孔视力远OS
     */
    public void setFarXkos(String farXkos) {
        this.farXkos = farXkos;
    }

    /**
     * 获取：小孔视力远OS
     */
    public String getFarXkos() {
        return farXkos;
    }

    /**
     * 设置：小孔视力近OU
     */
    public void setNearXkou(String nearXkou) {
        this.nearXkou = nearXkou;
    }

    /**
     * 获取：小孔视力近OU
     */
    public String getNearXkou() {
        return nearXkou;
    }

    /**
     * 设置：小孔视力近OD
     */
    public void setNearXkod(String nearXkod) {
        this.nearXkod = nearXkod;
    }

    /**
     * 获取：小孔视力近OD
     */
    public String getNearXkod() {
        return nearXkod;
    }

    /**
     * 设置：小孔视力近OS
     */
    public void setNearXkos(String nearXkos) {
        this.nearXkos = nearXkos;
    }

    /**
     * 获取：小孔视力近OS
     */
    public String getNearXkos() {
        return nearXkos;
    }

    /**
     * 设置：主导眼
     */
    public void setDominantEye(String dominantEye) {
        this.dominantEye = dominantEye;
    }

    /**
     * 获取：主导眼
     */
    public String getDominantEye() {
        return dominantEye;
    }
    //视觉训练id
    private Long sjxlId;
    //处方类型
    private String sjxlPrescriptionType;
    //医生
    private String sjxlDoctor;
    //验光师
    private String sjxlOptometryName;
    //球镜OD
    private String sjxlSphod;
    //球镜OS
    private String sjxlSphos;
    //柱镜OD
    private String sjxlCylod;
    //柱镜OS
    private String sjxlCylos;
    //轴向OD
    private String sjxlAxialod;
    //轴向OS
    private String sjxlAxialos;
    //三棱镜(OD)
    private String sjxlSljod;
    //三棱镜(OS)
    private String sjxlSljos;
    //基底(OD)
    private String sjxlJdod;
    //基底(OS)
    private String sjxlJdos;
    //远用瞳距(mm)(OD)
    private String sjxlYytjod;
    //远用瞳距(mm)(OS)
    private String sjxlYytjos;
    //近用瞳距(mm)(OD)
    private String sjxlJytjod;
    //近用瞳距(mm)(OS)
    private String sjxlJytjos;
//    瞳高(mm)(OD)
    private String sjxlTgod;
//    瞳高(mm)(OS)
    private String sjxlTgos;
    //远用va(OD)
    private String sjxlYyvaod;
    //远用va(OS)
    private String sjxlYyvaos;
    //近用va(OD)
    private String sjxlJyvaod;
    //近用va(OS)
    private String sjxlJyvaos;
    //家庭训练
    private String sjxlJtxl;
    //训练室训练
    private String sjxlXlsxl;
    //备注
    private String sjxlBeizhu;

    /**
     * 设置：视觉训练id
     */
    public void setSjxlId(Long sjxlId) {
        this.sjxlId = sjxlId;
    }

    /**
     * 获取：视觉训练id
     */
    public Long getSjxlId() {
        return sjxlId;
    }

    /**
     * 设置：处方类型
     */
    public void setSjxlPrescriptionType(String sjxlPrescriptionType) {
        this.sjxlPrescriptionType = sjxlPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getSjxlPrescriptionType() {
        return sjxlPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setSjxlDoctor(String sjxlDoctor) {
        this.sjxlDoctor = sjxlDoctor;
    }

    /**
     * 获取：医生
     */
    public String getSjxlDoctor() {
        return sjxlDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setSjxlOptometryName(String sjxlOptometryName) {
        this.sjxlOptometryName = sjxlOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getSjxlOptometryName() {
        return sjxlOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setSjxlSphod(String sjxlSphod) {
        this.sjxlSphod = sjxlSphod;
    }

    /**
     * 获取：球镜OD
     */
    public String getSjxlSphod() {
        return sjxlSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSjxlSphos(String sjxlSphos) {
        this.sjxlSphos = sjxlSphos;
    }

    /**
     * 获取：球镜OS
     */
    public String getSjxlSphos() {
        return sjxlSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSjxlCylod(String sjxlCylod) {
        this.sjxlCylod = sjxlCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public String getSjxlCylod() {
        return sjxlCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSjxlCylos(String sjxlCylos) {
        this.sjxlCylos = sjxlCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public String getSjxlCylos() {
        return sjxlCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSjxlAxialod(String sjxlAxialod) {
        this.sjxlAxialod = sjxlAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public String getSjxlAxialod() {
        return sjxlAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSjxlAxialos(String sjxlAxialos) {
        this.sjxlAxialos = sjxlAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public String getSjxlAxialos() {
        return sjxlAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setSjxlSljod(String sjxlSljod) {
        this.sjxlSljod = sjxlSljod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getSjxlSljod() {
        return sjxlSljod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setSjxlSljos(String sjxlSljos) {
        this.sjxlSljos = sjxlSljos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getSjxlSljos() {
        return sjxlSljos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setSjxlJdod(String sjxlJdod) {
        this.sjxlJdod = sjxlJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getSjxlJdod() {
        return sjxlJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setSjxlJdos(String sjxlJdos) {
        this.sjxlJdos = sjxlJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getSjxlJdos() {
        return sjxlJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSjxlYytjod(String sjxlYytjod) {
        this.sjxlYytjod = sjxlYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public String getSjxlYytjod() {
        return sjxlYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSjxlYytjos(String sjxlYytjos) {
        this.sjxlYytjos = sjxlYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public String getSjxlYytjos() {
        return sjxlYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSjxlJytjod(String sjxlJytjod) {
        this.sjxlJytjod = sjxlJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public String getSjxlJytjod() {
        return sjxlJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSjxlJytjos(String sjxlJytjos) {
        this.sjxlJytjos = sjxlJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public String getSjxlJytjos() {
        return sjxlJytjos;
    }

    public String getSjxlTgod() {
        return sjxlTgod;
    }

    public void setSjxlTgod(String sjxlTgod) {
        this.sjxlTgod = sjxlTgod;
    }

    public String getSjxlTgos() {
        return sjxlTgos;
    }

    public void setSjxlTgos(String sjxlTgos) {
        this.sjxlTgos = sjxlTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSjxlYyvaod(String sjxlYyvaod) {
        this.sjxlYyvaod = sjxlYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public String getSjxlYyvaod() {
        return sjxlYyvaod;
    }


    /**
     * 设置：远用va(OS)
     */
    public void setSjxlYyvaos(String sjxlYyvaos) {
        this.sjxlYyvaos = sjxlYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public String getSjxlYyvaos() {
        return sjxlYyvaos;
    }


    /**
     * 设置：近用va(OD)
     */
    public void setSjxlJyvaod(String sjxlJyvaod) {
        this.sjxlJyvaod = sjxlJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public String getSjxlJyvaod() {
        return sjxlJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSjxlJyvaos(String sjxlJyvaos) {
        this.sjxlJyvaos = sjxlJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public String getSjxlJyvaos() {
        return sjxlJyvaos;
    }

    /**
     * 设置：家庭训练
     */
    public void setSjxlJtxl(String sjxlJtxl) {
        this.sjxlJtxl = sjxlJtxl;
    }

    /**
     * 获取：家庭训练
     */
    public String getSjxlJtxl() {
        return sjxlJtxl;
    }

    /**
     * 设置：训练室训练
     */
    public void setSjxlXlsxl(String sjxlXlsxl) {
        this.sjxlXlsxl = sjxlXlsxl;
    }

    /**
     * 获取：训练室训练
     */
    public String getSjxlXlsxl() {
        return sjxlXlsxl;
    }

    /**
     * 设置：备注
     */
    public void setSjxlBeizhu(String sjxlBeizhu) {
        this.sjxlBeizhu = sjxlBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getSjxlBeizhu() {
        return sjxlBeizhu;
    }
    //球镜(右眼OD)
    private String sphereRightz;
    //球镜(左眼OS)
    private String sphereLeftz;
    //柱镜(右眼OD)
    private String cylinderRightz;
    //柱镜(左眼OS)
    private String cylinderLeftz;
    //轴向(右眼-OD)
    private String axialRightz;
    //轴向(左眼OS)
    private String axialLeftz;
    //DVA(右眼OD)
    private String dvaRightz;
    //DVA(左眼OS)
    private String dvaLeftz;
    //NVA(OD)
    private String nvaRightz;
    //NVA(OS)
    private String nvaLeftz;
    //三棱镜(OD)
    private String prismRightz;
    //三棱镜(OS)
    private String prismLeftz;
    //基底(OD)
    private String jdrZ;
    //基底(OS)
    private String jdlZ;
    //Add(OD)
    private String addRightz;
    //Add(OS)
    private String addLeftz;
    //远用瞳孔距(mm)(OD)
    private String yuanRz;
    //远用瞳孔距(mm)(OS)
    private String yuanLz;
    //近用瞳孔距(mm)(OD)
    private String nearRightz;
    //近用瞳孔距(mm)(OS)
    private String nearLeftz;

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRightz(String sphereRightz) {
        this.sphereRightz = sphereRightz;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRightz() {
        return sphereRightz;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeftz(String sphereLeftz) {
        this.sphereLeftz = sphereLeftz;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLeftz() {
        return sphereLeftz;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRightz(String cylinderRightz) {
        this.cylinderRightz = cylinderRightz;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRightz() {
        return cylinderRightz;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeftz(String cylinderLeftz) {
        this.cylinderLeftz = cylinderLeftz;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLeftz() {
        return cylinderLeftz;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRightz(String axialRightz) {
        this.axialRightz = axialRightz;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRightz() {
        return axialRightz;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeftz(String axialLeftz) {
        this.axialLeftz = axialLeftz;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLeftz() {
        return axialLeftz;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRightz(String dvaRightz) {
        this.dvaRightz = dvaRightz;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public String getDvaRightz() {
        return dvaRightz;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLeftz(String dvaLeftz) {
        this.dvaLeftz = dvaLeftz;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public String getDvaLeftz() {
        return dvaLeftz;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRightz(String nvaRightz) {
        this.nvaRightz = nvaRightz;
    }

    /**
     * 获取：NVA(OD)
     */
    public String getNvaRightz() {
        return nvaRightz;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLeftz(String nvaLeftz) {
        this.nvaLeftz = nvaLeftz;
    }

    /**
     * 获取：NVA(OS)
     */
    public String getNvaLeftz() {
        return nvaLeftz;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRightz(String prismRightz) {
        this.prismRightz = prismRightz;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getPrismRightz() {
        return prismRightz;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLeftz(String prismLeftz) {
        this.prismLeftz = prismLeftz;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getPrismLeftz() {
        return prismLeftz;
    }

    /**
     * 设置：基底(OD)
     */
    public void setJdrZ(String jdrZ) {
        this.jdrZ = jdrZ;
    }

    /**
     * 获取：基底(OD)
     */
    public String getJdrZ() {
        return jdrZ;
    }

    /**
     * 设置：基底(OS)
     */
    public void setJdlZ(String jdlZ) {
        this.jdlZ = jdlZ;
    }

    /**
     * 获取：基底(OS)
     */
    public String getJdlZ() {
        return jdlZ;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRightz(String addRightz) {
        this.addRightz = addRightz;
    }

    /**
     * 获取：Add(OD)
     */
    public String getAddRightz() {
        return addRightz;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLeftz(String addLeftz) {
        this.addLeftz = addLeftz;
    }

    /**
     * 获取：Add(OS)
     */
    public String getAddLeftz() {
        return addLeftz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRz(String yuanRz) {
        this.yuanRz = yuanRz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public String getYuanRz() {
        return yuanRz;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLz(String yuanLz) {
        this.yuanLz = yuanLz;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public String getYuanLz() {
        return yuanLz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRightz(String nearRightz) {
        this.nearRightz = nearRightz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public String getNearRightz() {
        return nearRightz;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLeftz(String nearLeftz) {
        this.nearLeftz = nearLeftz;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public String getNearLeftz() {
        return nearLeftz;
    }
    //角膜接触镜VSTid
    private Long vstId;
    //处方类型
    private String vstPrescriptionType;
    //医生
    private String vstDoctor;
    //验光师
    private String vstOptometryName;
    //试戴片编号OD
    private String vstSdbhod;
    //试戴片编号OS
    private String vstSdbhos;
    //FK(OD)
    private String vstFkod;
    //FK(OS)
    private String vstFkos;
    //曲率半径(OD)
    private String vstQlbjod;
    //曲率半径(OS)
    private String vstQlbjos;
    //AC(OD)
    private String vstAcod;
    //AC(OS)
    private String vstAcos;
    //降幅OD
    private String vstJfod;
    //降幅OS
    private String vstJfos;
    //DIA(OD)
    private String vstDiaod;
    //DIA(OS)
    private String vstDiaos;
    //BC(OD)
    private String vstBcod;
    //BC(OS)
    private String vstBcos;
    //CP/CLY(OD)
    private String vstCpclyod;
    //CP/CLY(OS)
    private String vstCpclyos;
    //E值(OD)
    private String vstEod;
    //E值(OS)
    private String vstEos;
    //VA(OD)
    private String vstVaod;
    //VA(OS)
    private String vstVaos;
    //镜片颜色OD
    private String vstJpysod;
    //镜片颜色OS
    private String vstJpysos;
    //适用镜片OD
    private String vstSyjpod;
    //适用镜片OS
    private String vstSyjpos;
    //备注
    private String vstBeizhu;
    //球镜OD右
    private String vstSphod;
    //球镜OS左
    private String vstSphos;
    //柱镜OD
    private String vstCylod;
    //柱镜OS
    private String vstCylos;
    //轴向OD
    private String vstAxialod;
    //轴向OS
    private String vstAxialos;

    /**
     * 设置：角膜接触镜VSTid
     */
    public void setVstId(Long vstId) {
        this.vstId = vstId;
    }

    /**
     * 获取：角膜接触镜VSTid
     */
    public Long getVstId() {
        return vstId;
    }


    /**
     * 设置：处方类型
     */
    public void setVstPrescriptionType(String vstPrescriptionType) {
        this.vstPrescriptionType = vstPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getVstPrescriptionType() {
        return vstPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setVstDoctor(String vstDoctor) {
        this.vstDoctor = vstDoctor;
    }

    /**
     * 获取：医生
     */
    public String getVstDoctor() {
        return vstDoctor;
    }

    public String getVstOptometryName() {
        return vstOptometryName;
    }

    public void setVstOptometryName(String vstOptometryName) {
        this.vstOptometryName = vstOptometryName;
    }

    /**
     * 设置：试戴片编号OD
     */
    public void setVstSdbhod(String vstSdbhod) {
        this.vstSdbhod = vstSdbhod;
    }

    /**
     * 获取：试戴片编号OD
     */
    public String getVstSdbhod() {
        return vstSdbhod;
    }

    /**
     * 设置：试戴片编号OS
     */
    public void setVstSdbhos(String vstSdbhos) {
        this.vstSdbhos = vstSdbhos;
    }

    /**
     * 获取：试戴片编号OS
     */
    public String getVstSdbhos() {
        return vstSdbhos;
    }

    /**
     * 设置：FK(OD)
     */
    public void setVstFkod(String vstFkod) {
        this.vstFkod = vstFkod;
    }

    /**
     * 获取：FK(OD)
     */
    public String getVstFkod() {
        return vstFkod;
    }

    /**
     * 设置：FK(OS)
     */
    public void setVstFkos(String vstFkos) {
        this.vstFkos = vstFkos;
    }

    /**
     * 获取：FK(OS)
     */
    public String getVstFkos() {
        return vstFkos;
    }

    /**
     * 设置：曲率半径(OD)
     */
    public void setVstQlbjod(String vstQlbjod) {
        this.vstQlbjod = vstQlbjod;
    }

    /**
     * 获取：曲率半径(OD)
     */
    public String getVstQlbjod() {
        return vstQlbjod;
    }

    /**
     * 设置：曲率半径(OS)
     */
    public void setVstQlbjos(String vstQlbjos) {
        this.vstQlbjos = vstQlbjos;
    }

    /**
     * 获取：曲率半径(OS)
     */
    public String getVstQlbjos() {
        return vstQlbjos;
    }

    /**
     * 设置：AC(OD)
     */
    public void setVstAcod(String vstAcod) {
        this.vstAcod = vstAcod;
    }

    /**
     * 获取：AC(OD)
     */
    public String getVstAcod() {
        return vstAcod;
    }

    /**
     * 设置：AC(OS)
     */
    public void setVstAcos(String vstAcos) {
        this.vstAcos = vstAcos;
    }

    /**
     * 获取：AC(OS)
     */
    public String getVstAcos() {
        return vstAcos;
    }

    /**
     * 设置：降幅OD
     */
    public void setVstJfod(String vstJfod) {
        this.vstJfod = vstJfod;
    }

    /**
     * 获取：降幅OD
     */
    public String getVstJfod() {
        return vstJfod;
    }

    /**
     * 设置：降幅OS
     */
    public void setVstJfos(String vstJfos) {
        this.vstJfos = vstJfos;
    }

    /**
     * 获取：降幅OS
     */
    public String getVstJfos() {
        return vstJfos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setVstDiaod(String vstDiaod) {
        this.vstDiaod = vstDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public String getVstDiaod() {
        return vstDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setVstDiaos(String vstDiaos) {
        this.vstDiaos = vstDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public String getVstDiaos() {
        return vstDiaos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setVstBcod(String vstBcod) {
        this.vstBcod = vstBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public String getVstBcod() {
        return vstBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setVstBcos(String vstBcos) {
        this.vstBcos = vstBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public String getVstBcos() {
        return vstBcos;
    }

    /**
     * 设置：CP/CLY(OD)
     */
    public void setVstCpclyod(String vstCpclyod) {
        this.vstCpclyod = vstCpclyod;
    }

    /**
     * 获取：CP/CLY(OD)
     */
    public String getVstCpclyod() {
        return vstCpclyod;
    }

    /**
     * 设置：CP/CLY(OS)
     */
    public void setVstCpclyos(String vstCpclyos) {
        this.vstCpclyos = vstCpclyos;
    }

    /**
     * 获取：CP/CLY(OS)
     */
    public String getVstCpclyos() {
        return vstCpclyos;
    }

    /**
     * 设置：E值(OD)
     */
    public void setVstEod(String vstEod) {
        this.vstEod = vstEod;
    }

    /**
     * 获取：E值(OD)
     */
    public String getVstEod() {
        return vstEod;
    }

    /**
     * 设置：E值(OS)
     */
    public void setVstEos(String vstEos) {
        this.vstEos = vstEos;
    }

    /**
     * 获取：E值(OS)
     */
    public String getVstEos() {
        return vstEos;
    }

    /**
     * 设置：VA(OD)
     */
    public void setVstVaod(String vstVaod) {
        this.vstVaod = vstVaod;
    }

    /**
     * 获取：VA(OD)
     */
    public String getVstVaod() {
        return vstVaod;
    }

    /**
     * 设置：VA(OS)
     */
    public void setVstVaos(String vstVaos) {
        this.vstVaos = vstVaos;
    }

    /**
     * 获取：VA(OS)
     */
    public String getVstVaos() {
        return vstVaos;
    }

    /**
     * 设置：镜片颜色OD
     */
    public void setVstJpysod(String vstJpysod) {
        this.vstJpysod = vstJpysod;
    }

    /**
     * 获取：镜片颜色OD
     */
    public String getVstJpysod() {
        return vstJpysod;
    }

    /**
     * 设置：镜片颜色OS
     */
    public void setVstJpysos(String vstJpysos) {
        this.vstJpysos = vstJpysos;
    }

    /**
     * 获取：镜片颜色OS
     */
    public String getVstJpysos() {
        return vstJpysos;
    }

    /**
     * 设置：适用镜片OD
     */
    public void setVstSyjpod(String vstSyjpod) {
        this.vstSyjpod = vstSyjpod;
    }

    /**
     * 获取：适用镜片OD
     */
    public String getVstSyjpod() {
        return vstSyjpod;
    }

    /**
     * 设置：适用镜片OS
     */
    public void setVstSyjpos(String vstSyjpos) {
        this.vstSyjpos = vstSyjpos;
    }

    /**
     * 获取：适用镜片OS
     */
    public String getVstSyjpos() {
        return vstSyjpos;
    }

    /**
     * 设置：备注
     */
    public void setVstBeizhu(String vstBeizhu) {
        this.vstBeizhu = vstBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getVstBeizhu() {
        return vstBeizhu;
    }
    /**
     * 设置：球镜OD右
     */
    public void setVstSphod(String vstSphod) {
        this.vstSphod = vstSphod;
    }
    /**
     * 获取：球镜OD右
     */
    public String getVstSphod() {
        return vstSphod;
    }
    /**
     * 设置：球镜OS左
     */
    public void setVstSphos(String vstSphos) {
        this.vstSphos = vstSphos;
    }
    /**
     * 获取：球镜OS左
     */
    public String getVstSphos() {
        return vstSphos;
    }
    /**
     * 设置：柱镜OD
     */
    public void setVstCylod(String vstCylod) {
        this.vstCylod = vstCylod;
    }
    /**
     * 获取：柱镜OD
     */
    public String getVstCylod() {
        return vstCylod;
    }
    /**
     * 设置：柱镜OS
     */
    public void setVstCylos(String vstCylos) {
        this.vstCylos = vstCylos;
    }
    /**
     * 获取：柱镜OS
     */
    public String getVstCylos() {
        return vstCylos;
    }
    /**
     * 设置：轴向OD
     */
    public void setVstAxialod(String vstAxialod) {
        this.vstAxialod = vstAxialod;
    }
    /**
     * 获取：轴向OD
     */
    public String getVstAxialod() {
        return vstAxialod;
    }
    /**
     * 设置：轴向OS
     */
    public void setVstAxialos(String vstAxialos) {
        this.vstAxialos = vstAxialos;
    }
    /**
     * 获取：轴向OS
     */
    public String getVstAxialos() {
        return vstAxialos;
    }
    private Long ypId;
    //处方类型
    private String ypPrescriptionType;
    //医生
    private String ypDoctor;
    //验光师
    private String ypOptometryName;
    //内容
    private String ypNr;
    //药名
    private String ypYm;

    /**
     * 设置：角膜接触镜CRTid
     */
    public void setYpId(Long ypId) {
        this.ypId = ypId;
    }

    /**
     * 获取：角膜接触镜CRTid
     */
    public Long getYpId() {
        return ypId;
    }
    /**
     * 设置：处方类型
     */
    public void setYpPrescriptionType(String ypPrescriptionType) {
        this.ypPrescriptionType = ypPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getYpPrescriptionType() {
        return ypPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setYpDoctor(String ypDoctor) {
        this.ypDoctor = ypDoctor;
    }

    /**
     * 获取：医生
     */
    public String getYpDoctor() {
        return ypDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setYpOptometryName(String ypOptometryName) {
        this.ypOptometryName = ypOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getYpOptometryName() {
        return ypOptometryName;
    }

    /**
     * 设置：内容
     */
    public void setYpNr(String ypNr) {
        this.ypNr = ypNr;
    }

    /**
     * 获取：内容
     */
    public String getYpNr() {
        return ypNr;
    }

    /**
     * 设置：药名
     */
    public void setYpYm(String ypYm) {
        this.ypYm = ypYm;
    }

    /**
     * 获取：药名
     */
    public String getYpYm() {
        return ypYm;
    }
    //医嘱id
    private Long yizhuId;
    //类型
    private String yizhuType;

    /**
     * 设置：医嘱id
     */
    public void setYizhuId(Long yizhuId) {
        this.yizhuId = yizhuId;
    }
    /**
     * 获取：医嘱id
     */
    public Long getYizhuId() {
        return yizhuId;
    }
    /**
     * 设置：类型
     */
    public void setYizhuType(String yizhuType) {
        this.yizhuType = yizhuType;
    }
    /**
     * 获取：类型
     */
    public String getYizhuType() {
        return yizhuType;
    }

    //中用id
    private Long zyId;
    //处方类型
    private String zyPrescriptionType;
    //医生
    private String zyDoctor;
    //验光师
    private String zyOptometryName;
    //球镜OD
    private String zySphod;
    //球镜OS
    private String zySphos;
    //柱镜OD
    private String zyCylod;
    //柱镜OS
    private String zyCylos;
    //轴向OD
    private String zyAxialod;
    //轴向OS
    private String zyAxialos;
    //三棱镜(OD)
    private String zyPrismod;
    //三棱镜(OS)
    private String zyPrismos;
    //基底(OD)
    private String zyJdod;
    //基底(OS)
    private String zyJdos;
    //中用瞳距(mm)(OD)
    private String zyZytjod;
    //中用瞳距(mm)(OS)
    private String zyZytjos;
    //瞳高(mm)(OD)
    private String zyTgod;
    //瞳高(mm)(OS)
    private String zyTgos;
    //中用va(OD)
    private String zyVaod;
    //中用va(OS)
    private String zyVaos;
    //建议镜片材质
    private String zyJpcz;
    //处理方式
    private String zyClfs;
    //建议镜框
    private String zyJyjk;
    //镜框类型
    private String zyJklx;
    //文本
    private String zyText;
    //备注
    private String zyBeizhu;

    public Long getZyId() {
        return zyId;
    }

    public void setZyId(Long zyId) {
        this.zyId = zyId;
    }

    public String getZyPrescriptionType() {
        return zyPrescriptionType;
    }

    public void setZyPrescriptionType(String zyPrescriptionType) {
        this.zyPrescriptionType = zyPrescriptionType;
    }

    public String getZyDoctor() {
        return zyDoctor;
    }

    public void setZyDoctor(String zyDoctor) {
        this.zyDoctor = zyDoctor;
    }

    public String getZyOptometryName() {
        return zyOptometryName;
    }

    public void setZyOptometryName(String zyOptometryName) {
        this.zyOptometryName = zyOptometryName;
    }

    public String getZySphod() {
        return zySphod;
    }

    public void setZySphod(String zySphod) {
        this.zySphod = zySphod;
    }

    public String getZySphos() {
        return zySphos;
    }

    public void setZySphos(String zySphos) {
        this.zySphos = zySphos;
    }

    public String getZyCylod() {
        return zyCylod;
    }

    public void setZyCylod(String zyCylod) {
        this.zyCylod = zyCylod;
    }

    public String getZyCylos() {
        return zyCylos;
    }

    public void setZyCylos(String zyCylos) {
        this.zyCylos = zyCylos;
    }

    public String getZyAxialod() {
        return zyAxialod;
    }

    public void setZyAxialod(String zyAxialod) {
        this.zyAxialod = zyAxialod;
    }

    public String getZyAxialos() {
        return zyAxialos;
    }

    public void setZyAxialos(String zyAxialos) {
        this.zyAxialos = zyAxialos;
    }

    public String getZyPrismod() {
        return zyPrismod;
    }

    public void setZyPrismod(String zyPrismod) {
        this.zyPrismod = zyPrismod;
    }

    public String getZyPrismos() {
        return zyPrismos;
    }

    public void setZyPrismos(String zyPrismos) {
        this.zyPrismos = zyPrismos;
    }

    public String getZyJdod() {
        return zyJdod;
    }

    public void setZyJdod(String zyJdod) {
        this.zyJdod = zyJdod;
    }

    public String getZyJdos() {
        return zyJdos;
    }

    public void setZyJdos(String zyJdos) {
        this.zyJdos = zyJdos;
    }

    public String getZyZytjod() {
        return zyZytjod;
    }

    public void setZyZytjod(String zyZytjod) {
        this.zyZytjod = zyZytjod;
    }

    public String getZyZytjos() {
        return zyZytjos;
    }

    public void setZyZytjos(String zyZytjos) {
        this.zyZytjos = zyZytjos;
    }

    public String getZyTgod() {
        return zyTgod;
    }

    public void setZyTgod(String zyTgod) {
        this.zyTgod = zyTgod;
    }

    public String getZyTgos() {
        return zyTgos;
    }

    public void setZyTgos(String zyTgos) {
        this.zyTgos = zyTgos;
    }

    public String getZyVaod() {
        return zyVaod;
    }

    public void setZyVaod(String zyVaod) {
        this.zyVaod = zyVaod;
    }

    public String getZyVaos() {
        return zyVaos;
    }

    public void setZyVaos(String zyVaos) {
        this.zyVaos = zyVaos;
    }

    public String getZyJpcz() {
        return zyJpcz;
    }

    public void setZyJpcz(String zyJpcz) {
        this.zyJpcz = zyJpcz;
    }

    public String getZyClfs() {
        return zyClfs;
    }

    public void setZyClfs(String zyClfs) {
        this.zyClfs = zyClfs;
    }

    public String getZyJyjk() {
        return zyJyjk;
    }

    public void setZyJyjk(String zyJyjk) {
        this.zyJyjk = zyJyjk;
    }

    public String getZyJklx() {
        return zyJklx;
    }

    public void setZyJklx(String zyJklx) {
        this.zyJklx = zyJklx;
    }

    public String getZyText() {
        return zyText;
    }

    public void setZyText(String zyText) {
        this.zyText = zyText;
    }

    public String getZyBeizhu() {
        return zyBeizhu;
    }

    public void setZyBeizhu(String zyBeizhu) {
        this.zyBeizhu = zyBeizhu;
    }
    private String chufangType;

    public String getChufangType() {
        return chufangType;
    }

    public void setChufangType(String chufangType) {
        this.chufangType = chufangType;
    }



    //姓名
    private String name;
    //性别
    private Long sex;
    private String sexx;
    //年龄
    private Long age;
    //联系电话1
    private String phone1;

    //转诊医生
    private String referralDoctor;
    //转诊
    private String referral;
    //主诉
    private String chiefComplaint;
    //球镜(右眼OD)
    private String sphereRighttry;
    //球镜(左眼OS)
    private String sphereLefttry;
    //柱镜(右眼OD)
    private String cylinderRighttry;
    //柱镜(左眼OS)
    private String cylinderLefttry;
    //轴向(右眼-OD)
    private String axialRighttry;
    //轴向(左眼OS)
    private String axialLefttry;
    //DVA(右眼OD)
    private String dvaRighttry;
    //DVA(左眼OS)
    private String dvaLefttry;
    //NVA(OD)
    private String nvaRighttry;
    //NVA(OS)
    private String nvaLefttry;
    //三棱镜(OD)
    private String prismRighttry;
    //三棱镜(OS)
    private String prismLefttry;
    //基底(OD)
    private String jdrTry;
    //基底(OS)
    private String jdlTry;
    //瞳高(mm)(OD)
    private String heightRighttry;
    //瞳高(mm)(OS)
    private String heightLefttry;
    //Add(OD)
    private String addRighttry;
    //Add(OS)
    private String addLefttry;
    //远用瞳孔距(mm)(OD)
    private String yuanRrty;
    //远用瞳孔距(mm)(OS)
    private String yuanLrty;
    //近用瞳孔距(mm)(OD)
    private String nearRighttry;
    //近用瞳孔距(mm)(OS)
    private String nearLefttry;
    //备注
    private String remarks;
    //眼轴
    private String axis;
    //眼轴(OS)
    private String axisLeft;
    //角膜K1值(右眼)
    private String cornealFirstK1Right;
    //角膜K1值@A(右眼)
    private String cornealLastK1Right;
    //角膜K1值(左眼)
    private String cornealFirstK1Left;
    //角膜K1值@A(左眼)
    private String cornealLastK1Left;
    //角膜K2值(右眼)
    private String cornealFirstK2Right;
    //角膜K2值@A(右眼)
    private String cornealLastK2Right;
    //角膜K2值(左眼)
    private String cornealFirstK2Left;
    //角膜K2值@A(左眼)
    private String cornealLastK2Left;
    //平Kod
    private String pkod;
    //平Kos
    private String pkos;
    //平K1od
    private String pk1od;
    //平K1os
    private String pk1os;
    //陡K1od
    private String dkod;
    //陡K1os
    private String dkos;
    //陡K1os
    private String dk1os;
    //陡K1od
    private String dk1od;
    //平均k2OD
    private String pjkOd;
    //平均k2OS
    private String pjkOs;
    //平均k2OD
    private String pjkOd2;
    //平均k2OS
    private String pjkOs2;
    //眼压(OD)
    private String intraocularOd;
    //眼压(OS)
    private String intraocularOs;
    //是否散瞳(0:散瞳前1:散瞳后)
    private Long mydriasis;
    //散瞳用药id
    private Long pharmacyId;
    //散瞳用药
    private String pharmacy;
    //球镜(右眼OD)
    private String sphereRight;
    //球镜(左眼OS)
    private String sphereLeft;
    //柱镜(右眼OD)
    private String cylinderRight;
    //柱镜(左眼OS)
    private String cylinderLeft;
    //轴向(右眼-OD)
    private String axialRight;
    //轴向(左眼OS)
    private String axialLeft;
    //角膜散光(OD)
    private String cornealAstigmatismOd;
    //角膜散光(OS)
    private String cornealAstigmatismOs;
    //    测量瞳距od
    private String  tjod;
    //    测量瞳距os
    private String  tjos;

    public String getTjod() {
        return tjod;
    }

    public void setTjod(String tjod) {
        this.tjod = tjod;
    }

    public String getTjos() {
        return tjos;
    }

    public void setTjos(String tjos) {
        this.tjos = tjos;
    }

    //检影球镜(OD)
    private String sphJyod;
    //检影球镜(OS)
    private String sphJyos;
    //检影柱镜(OD)
    private String cylJyod;
    //检影柱镜(OS)
    private String cylJyos;
    //检影轴向(OD)
    private String axialJyod;
    //检影轴向(OS)
    private String axialJyos;
    //检影VA(OD)
    private String vaJyod;
    //检影VA(OS)
    private String vaJyos;
    //检影瞳距(mm)(OD)
    private String pdJyod;
    //检影瞳距(mm)(OS)
    private String pdJyos;
    //插片球镜(OD)
    private String sphCpod;
    //插片球镜(OS)
    private String sphCpos;
    //插片柱镜(OD)
    private String cylCpod;
    //插片柱镜(OS)
    private String cylCpos;
    //插片轴向(OD)
    private String axialCpod;
    //插片轴向(OS)
    private String axialCpos;
    //插片DVA(OD)
    private String dvaCpod;
    //插片DVA(OS)
    private String dvaCpos;
    //插片NVA(OD)
    private String nvaCpod;
    //插片NVA(OS)
    private String nvaCpos;
    //插片add(OD)
    private String addCpod;
    //插片add(OS)
    private String addCpos;
    //插片测量距离(OD)
    private String distanceOd;
    //插片测量距离(OS)
    private String distanceOs;

    //球镜(右眼OD)后
    private String sphereRight2;
    //球镜(左眼OS)后
    private String sphereLeft2;
    //柱镜(右眼OD)后
    private String cylinderRight2;
    //柱镜(左眼OS)后
    private String cylinderLeft2;
    //轴向(右眼-OD)后
    private String axialRight2;
    //轴向(左眼OS)后
    private String axialLeft2;

    /**
     * 设置：转诊医生
     */
    public void setReferralDoctor(String referralDoctor) {
        this.referralDoctor = referralDoctor;
    }

    /**
     * 获取：转诊医生
     */
    public String getReferralDoctor() {
        return referralDoctor;
    }

    /**
     * 设置：转诊
     */
    public void setReferral(String referral) {
        this.referral = referral;
    }

    /**
     * 获取：转诊
     */
    public String getReferral() {
        return referral;
    }

    /**
     * 设置：主诉
     */
    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    /**
     * 获取：主诉
     */
    public String getChiefComplaint() {
        return chiefComplaint;
    }

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRighttry(String sphereRighttry) {
        this.sphereRighttry = sphereRighttry;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRighttry() {
        return sphereRighttry;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLefttry(String sphereLefttry) {
        this.sphereLefttry = sphereLefttry;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLefttry() {
        return sphereLefttry;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRighttry(String cylinderRighttry) {
        this.cylinderRighttry = cylinderRighttry;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRighttry() {
        return cylinderRighttry;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLefttry(String cylinderLefttry) {
        this.cylinderLefttry = cylinderLefttry;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLefttry() {
        return cylinderLefttry;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRighttry(String axialRighttry) {
        this.axialRighttry = axialRighttry;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRighttry() {
        return axialRighttry;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLefttry(String axialLefttry) {
        this.axialLefttry = axialLefttry;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLefttry() {
        return axialLefttry;
    }

    /**
     * 设置：DVA(右眼OD)
     */
    public void setDvaRighttry(String dvaRighttry) {
        this.dvaRighttry = dvaRighttry;
    }

    /**
     * 获取：DVA(右眼OD)
     */
    public String getDvaRighttry() {
        return dvaRighttry;
    }

    /**
     * 设置：DVA(左眼OS)
     */
    public void setDvaLefttry(String dvaLefttry) {
        this.dvaLefttry = dvaLefttry;
    }

    /**
     * 获取：DVA(左眼OS)
     */
    public String getDvaLefttry() {
        return dvaLefttry;
    }

    /**
     * 设置：NVA(OD)
     */
    public void setNvaRighttry(String nvaRighttry) {
        this.nvaRighttry = nvaRighttry;
    }

    /**
     * 获取：NVA(OD)
     */
    public String getNvaRighttry() {
        return nvaRighttry;
    }

    /**
     * 设置：NVA(OS)
     */
    public void setNvaLefttry(String nvaLefttry) {
        this.nvaLefttry = nvaLefttry;
    }

    /**
     * 获取：NVA(OS)
     */
    public String getNvaLefttry() {
        return nvaLefttry;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setPrismRighttry(String prismRighttry) {
        this.prismRighttry = prismRighttry;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public String getPrismRighttry() {
        return prismRighttry;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setPrismLefttry(String prismLefttry) {
        this.prismLefttry = prismLefttry;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public String getPrismLefttry() {
        return prismLefttry;
    }

    /**
     * 设置：基底(OD)
     */
    public void setJdrTry(String jdrTry) {
        this.jdrTry = jdrTry;
    }

    /**
     * 获取：基底(OD)
     */
    public String getJdrTry() {
        return jdrTry;
    }

    /**
     * 设置：基底(OS)
     */
    public void setJdlTry(String jdlTry) {
        this.jdlTry = jdlTry;
    }

    /**
     * 获取：基底(OS)
     */
    public String getJdlTry() {
        return jdlTry;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setHeightRighttry(String heightRighttry) {
        this.heightRighttry = heightRighttry;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public String getHeightRighttry() {
        return heightRighttry;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setHeightLefttry(String heightLefttry) {
        this.heightLefttry = heightLefttry;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public String getHeightLefttry() {
        return heightLefttry;
    }

    /**
     * 设置：Add(OD)
     */
    public void setAddRighttry(String addRighttry) {
        this.addRighttry = addRighttry;
    }

    /**
     * 获取：Add(OD)
     */
    public String getAddRighttry() {
        return addRighttry;
    }

    /**
     * 设置：Add(OS)
     */
    public void setAddLefttry(String addLefttry) {
        this.addLefttry = addLefttry;
    }

    /**
     * 获取：Add(OS)
     */
    public String getAddLefttry() {
        return addLefttry;
    }

    /**
     * 设置：远用瞳孔距(mm)(OD)
     */
    public void setYuanRrty(String yuanRrty) {
        this.yuanRrty = yuanRrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OD)
     */
    public String getYuanRrty() {
        return yuanRrty;
    }

    /**
     * 设置：远用瞳孔距(mm)(OS)
     */
    public void setYuanLrty(String yuanLrty) {
        this.yuanLrty = yuanLrty;
    }

    /**
     * 获取：远用瞳孔距(mm)(OS)
     */
    public String getYuanLrty() {
        return yuanLrty;
    }

    /**
     * 设置：近用瞳孔距(mm)(OD)
     */
    public void setNearRighttry(String nearRighttry) {
        this.nearRighttry = nearRighttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OD)
     */
    public String getNearRighttry() {
        return nearRighttry;
    }

    /**
     * 设置：近用瞳孔距(mm)(OS)
     */
    public void setNearLefttry(String nearLefttry) {
        this.nearLefttry = nearLefttry;
    }

    /**
     * 获取：近用瞳孔距(mm)(OS)
     */
    public String getNearLefttry() {
        return nearLefttry;
    }

    /**
     * 设置：备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置：眼轴
     */
    public void setAxis(String axis) {
        this.axis = axis;
    }

    /**
     * 获取：眼轴
     */
    public String getAxis() {
        return axis;
    }

    /**
     * 设置：眼轴(OS)
     */
    public void setAxisLeft(String axisLeft) {
        this.axisLeft = axisLeft;
    }

    /**
     * 获取：眼轴(OS)
     */
    public String getAxisLeft() {
        return axisLeft;
    }

    /**
     * 设置：角膜K1值(右眼)
     */
    public void setCornealFirstK1Right(String cornealFirstK1Right) {
        this.cornealFirstK1Right = cornealFirstK1Right;
    }

    /**
     * 获取：角膜K1值(右眼)
     */
    public String getCornealFirstK1Right() {
        return cornealFirstK1Right;
    }

    /**
     * 设置：角膜K1值@A(右眼)
     */
    public void setCornealLastK1Right(String cornealLastK1Right) {
        this.cornealLastK1Right = cornealLastK1Right;
    }

    /**
     * 获取：角膜K1值@A(右眼)
     */
    public String getCornealLastK1Right() {
        return cornealLastK1Right;
    }

    /**
     * 设置：角膜K1值(左眼)
     */
    public void setCornealFirstK1Left(String cornealFirstK1Left) {
        this.cornealFirstK1Left = cornealFirstK1Left;
    }

    /**
     * 获取：角膜K1值(左眼)
     */
    public String getCornealFirstK1Left() {
        return cornealFirstK1Left;
    }

    /**
     * 设置：角膜K1值@A(左眼)
     */
    public void setCornealLastK1Left(String cornealLastK1Left) {
        this.cornealLastK1Left = cornealLastK1Left;
    }

    /**
     * 获取：角膜K1值@A(左眼)
     */
    public String getCornealLastK1Left() {
        return cornealLastK1Left;
    }

    /**
     * 设置：角膜K2值(右眼)
     */
    public void setCornealFirstK2Right(String cornealFirstK2Right) {
        this.cornealFirstK2Right = cornealFirstK2Right;
    }

    /**
     * 获取：角膜K2值(右眼)
     */
    public String getCornealFirstK2Right() {
        return cornealFirstK2Right;
    }

    /**
     * 设置：角膜K2值@A(右眼)
     */
    public void setCornealLastK2Right(String cornealLastK2Right) {
        this.cornealLastK2Right = cornealLastK2Right;
    }

    /**
     * 获取：角膜K2值@A(右眼)
     */
    public String getCornealLastK2Right() {
        return cornealLastK2Right;
    }

    /**
     * 设置：角膜K2值(左眼)
     */
    public void setCornealFirstK2Left(String cornealFirstK2Left) {
        this.cornealFirstK2Left = cornealFirstK2Left;
    }

    /**
     * 获取：角膜K2值(左眼)
     */
    public String getCornealFirstK2Left() {
        return cornealFirstK2Left;
    }

    /**
     * 设置：角膜K2值@A(左眼)
     */
    public void setCornealLastK2Left(String cornealLastK2Left) {
        this.cornealLastK2Left = cornealLastK2Left;
    }

    /**
     * 获取：角膜K2值@A(左眼)
     */
    public String getCornealLastK2Left() {
        return cornealLastK2Left;
    }

    /**
     * 设置：平Kos
     */
    public void setPkod(String pkod) {
        this.pkod = pkod;
    }
    /**
     * 获取：平Kos
     */
    public String getPkod() {
        return pkod;
    }
    /**
     * 设置：平Kos
     */
    public void setPkos(String pkos) {
        this.pkos = pkos;
    }
    /**
     * 获取：平Kos
     */
    public String getPkos() {
        return pkos;
    }
    /**
     * 设置：平K1od
     */
    public void setPk1od(String pk1od) {
        this.pk1od = pk1od;
    }
    /**
     * 获取：平K1od
     */
    public String getPk1od() {
        return pk1od;
    }
    /**
     * 设置：平K1os
     */
    public void setPk1os(String pk1os) {
        this.pk1os = pk1os;
    }
    /**
     * 获取：平K1os
     */
    public String getPk1os() {
        return pk1os;
    }
    /**
     * 设置：陡K1
     */
    public void setDkod(String dkod) {
        this.dkod = dkod;
    }
    /**
     * 获取：陡K1
     */
    public String getDkod() {
        return dkod;
    }
    /**
     * 设置：陡K1
     */
    public void setDkos(String dkos) {
        this.dkos = dkos;
    }
    /**
     * 获取：陡K1
     */
    public String getDkos() {
        return dkos;
    }
    /**
     * 设置：陡K1
     */
    public void setDk1os(String dk1os) {
        this.dk1os = dk1os;
    }
    /**
     * 获取：陡K1
     */
    public String getDk1os() {
        return dk1os;
    }
    /**
     * 设置：陡K1
     */
    public void setDk1od(String dk1od) {
        this.dk1od = dk1od;
    }
    /**
     * 获取：陡K1
     */
    public String getDk1od() {
        return dk1od;
    }
    /**
     * 设置：平均k2OD
     */
    public void setPjkOd(String pjkOd) {
        this.pjkOd = pjkOd;
    }
    /**
     * 获取：平均k2OD
     */
    public String getPjkOd() {
        return pjkOd;
    }
    /**
     * 设置：平均k2OS
     */
    public void setPjkOs(String pjkOs) {
        this.pjkOs = pjkOs;
    }
    /**
     * 获取：平均k2OS
     */
    public String getPjkOs() {
        return pjkOs;
    }
    /**
     * 设置：平均k2OD
     */
    public void setPjkOd2(String pjkOd2) {
        this.pjkOd2 = pjkOd2;
    }
    /**
     * 获取：平均k2OD
     */
    public String getPjkOd2() {
        return pjkOd2;
    }
    /**
     * 设置：平均k2OS
     */
    public void setPjkOs2(String pjkOs2) {
        this.pjkOs2 = pjkOs2;
    }
    /**
     * 获取：平均k2OS
     */
    public String getPjkOs2() {
        return pjkOs2;
    }
    /**
     * 设置：眼压(OD)
     */
    public void setIntraocularOd(String intraocularOd) {
        this.intraocularOd = intraocularOd;
    }

    /**
     * 获取：眼压(OD)
     */
    public String getIntraocularOd() {
        return intraocularOd;
    }

    /**
     * 设置：眼压(OS)
     */
    public void setIntraocularOs(String intraocularOs) {
        this.intraocularOs = intraocularOs;
    }

    /**
     * 获取：眼压(OS)
     */
    public String getIntraocularOs() {
        return intraocularOs;
    }

    /**
     * 设置：是否散瞳(0:散瞳前1:散瞳后)
     */
    public void setMydriasis(Long mydriasis) {
        this.mydriasis = mydriasis;
    }

    /**
     * 获取：是否散瞳(0:散瞳前1:散瞳后)
     */
    public Long getMydriasis() {
        return mydriasis;
    }

    /**
     * 设置：散瞳用药id
     */
    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    /**
     * 获取：散瞳用药id
     */
    public Long getPharmacyId() {
        return pharmacyId;
    }

    /**
     * 设置：散瞳用药
     */
    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    /**
     * 获取：散瞳用药
     */
    public String getPharmacy() {
        return pharmacy;
    }

    /**
     * 设置：球镜(右眼OD)
     */
    public void setSphereRight(String sphereRight) {
        this.sphereRight = sphereRight;
    }

    /**
     * 获取：球镜(右眼OD)
     */
    public String getSphereRight() {
        return sphereRight;
    }

    /**
     * 设置：球镜(左眼OS)
     */
    public void setSphereLeft(String sphereLeft) {
        this.sphereLeft = sphereLeft;
    }

    /**
     * 获取：球镜(左眼OS)
     */
    public String getSphereLeft() {
        return sphereLeft;
    }

    /**
     * 设置：柱镜(右眼OD)
     */
    public void setCylinderRight(String cylinderRight) {
        this.cylinderRight = cylinderRight;
    }

    /**
     * 获取：柱镜(右眼OD)
     */
    public String getCylinderRight() {
        return cylinderRight;
    }

    /**
     * 设置：柱镜(左眼OS)
     */
    public void setCylinderLeft(String cylinderLeft) {
        this.cylinderLeft = cylinderLeft;
    }

    /**
     * 获取：柱镜(左眼OS)
     */
    public String getCylinderLeft() {
        return cylinderLeft;
    }

    /**
     * 设置：轴向(右眼-OD)
     */
    public void setAxialRight(String axialRight) {
        this.axialRight = axialRight;
    }

    /**
     * 获取：轴向(右眼-OD)
     */
    public String getAxialRight() {
        return axialRight;
    }

    /**
     * 设置：轴向(左眼OS)
     */
    public void setAxialLeft(String axialLeft) {
        this.axialLeft = axialLeft;
    }

    /**
     * 获取：轴向(左眼OS)
     */
    public String getAxialLeft() {
        return axialLeft;
    }

    /**
     * 设置：角膜散光(OD)
     */
    public void setCornealAstigmatismOd(String cornealAstigmatismOd) {
        this.cornealAstigmatismOd = cornealAstigmatismOd;
    }

    /**
     * 获取：角膜散光(OD)
     */
    public String getCornealAstigmatismOd() {
        return cornealAstigmatismOd;
    }

    /**
     * 设置：角膜散光(OS)
     */
    public void setCornealAstigmatismOs(String cornealAstigmatismOs) {
        this.cornealAstigmatismOs = cornealAstigmatismOs;
    }

    /**
     * 获取：角膜散光(OS)
     */
    public String getCornealAstigmatismOs() {
        return cornealAstigmatismOs;
    }

    /**
     * 设置：检影球镜(OD)
     */
    public void setSphJyod(String sphJyod) {
        this.sphJyod = sphJyod;
    }

    /**
     * 获取：检影球镜(OD)
     */
    public String getSphJyod() {
        return sphJyod;
    }

    /**
     * 设置：检影球镜(OS)
     */
    public void setSphJyos(String sphJyos) {
        this.sphJyos = sphJyos;
    }

    /**
     * 获取：检影球镜(OS)
     */
    public String getSphJyos() {
        return sphJyos;
    }

    /**
     * 设置：检影柱镜(OD)
     */
    public void setCylJyod(String cylJyod) {
        this.cylJyod = cylJyod;
    }

    /**
     * 获取：检影柱镜(OD)
     */
    public String getCylJyod() {
        return cylJyod;
    }

    /**
     * 设置：检影柱镜(OS)
     */
    public void setCylJyos(String cylJyos) {
        this.cylJyos = cylJyos;
    }

    /**
     * 获取：检影柱镜(OS)
     */
    public String getCylJyos() {
        return cylJyos;
    }

    /**
     * 设置：检影轴向(OD)
     */
    public void setAxialJyod(String axialJyod) {
        this.axialJyod = axialJyod;
    }

    /**
     * 获取：检影轴向(OD)
     */
    public String getAxialJyod() {
        return axialJyod;
    }

    /**
     * 设置：检影轴向(OS)
     */
    public void setAxialJyos(String axialJyos) {
        this.axialJyos = axialJyos;
    }

    /**
     * 获取：检影轴向(OS)
     */
    public String getAxialJyos() {
        return axialJyos;
    }

    /**
     * 设置：检影VA(OD)
     */
    public void setVaJyod(String vaJyod) {
        this.vaJyod = vaJyod;
    }

    /**
     * 获取：检影VA(OD)
     */
    public String getVaJyod() {
        return vaJyod;
    }

    /**
     * 设置：检影VA(OS)
     */
    public void setVaJyos(String vaJyos) {
        this.vaJyos = vaJyos;
    }

    /**
     * 获取：检影VA(OS)
     */
    public String getVaJyos() {
        return vaJyos;
    }

    /**
     * 设置：检影瞳距(mm)(OD)
     */
    public void setPdJyod(String pdJyod) {
        this.pdJyod = pdJyod;
    }

    /**
     * 获取：检影瞳距(mm)(OD)
     */
    public String getPdJyod() {
        return pdJyod;
    }

    /**
     * 设置：检影瞳距(mm)(OS)
     */
    public void setPdJyos(String pdJyos) {
        this.pdJyos = pdJyos;
    }

    /**
     * 获取：检影瞳距(mm)(OS)
     */
    public String getPdJyos() {
        return pdJyos;
    }

    /**
     * 设置：插片球镜(OD)
     */
    public void setSphCpod(String sphCpod) {
        this.sphCpod = sphCpod;
    }

    /**
     * 获取：插片球镜(OD)
     */
    public String getSphCpod() {
        return sphCpod;
    }

    /**
     * 设置：插片球镜(OS)
     */
    public void setSphCpos(String sphCpos) {
        this.sphCpos = sphCpos;
    }

    /**
     * 获取：插片球镜(OS)
     */
    public String getSphCpos() {
        return sphCpos;
    }

    /**
     * 设置：插片柱镜(OD)
     */
    public void setCylCpod(String cylCpod) {
        this.cylCpod = cylCpod;
    }

    /**
     * 获取：插片柱镜(OD)
     */
    public String getCylCpod() {
        return cylCpod;
    }

    /**
     * 设置：插片柱镜(OS)
     */
    public void setCylCpos(String cylCpos) {
        this.cylCpos = cylCpos;
    }

    /**
     * 获取：插片柱镜(OS)
     */
    public String getCylCpos() {
        return cylCpos;
    }

    /**
     * 设置：插片轴向(OD)
     */
    public void setAxialCpod(String axialCpod) {
        this.axialCpod = axialCpod;
    }

    /**
     * 获取：插片轴向(OD)
     */
    public String getAxialCpod() {
        return axialCpod;
    }

    /**
     * 设置：插片轴向(OS)
     */
    public void setAxialCpos(String axialCpos) {
        this.axialCpos = axialCpos;
    }

    /**
     * 获取：插片轴向(OS)
     */
    public String getAxialCpos() {
        return axialCpos;
    }

    /**
     * 设置：插片DVA(OD)
     */
    public void setDvaCpod(String dvaCpod) {
        this.dvaCpod = dvaCpod;
    }

    /**
     * 获取：插片DVA(OD)
     */
    public String getDvaCpod() {
        return dvaCpod;
    }

    /**
     * 设置：插片DVA(OS)
     */
    public void setDvaCpos(String dvaCpos) {
        this.dvaCpos = dvaCpos;
    }

    /**
     * 获取：插片DVA(OS)
     */
    public String getDvaCpos() {
        return dvaCpos;
    }

    /**
     * 设置：插片NVA(OD)
     */
    public void setNvaCpod(String nvaCpod) {
        this.nvaCpod = nvaCpod;
    }

    /**
     * 获取：插片NVA(OD)
     */
    public String getNvaCpod() {
        return nvaCpod;
    }

    /**
     * 设置：插片NVA(OS)
     */
    public void setNvaCpos(String nvaCpos) {
        this.nvaCpos = nvaCpos;
    }

    /**
     * 获取：插片NVA(OS)
     */
    public String getNvaCpos() {
        return nvaCpos;
    }

    /**
     * 设置：插片add(OD)
     */
    public void setAddCpod(String addCpod) {
        this.addCpod = addCpod;
    }

    /**
     * 获取：插片add(OD)
     */
    public String getAddCpod() {
        return addCpod;
    }

    /**
     * 设置：插片add(OS)
     */
    public void setAddCpos(String addCpos) {
        this.addCpos = addCpos;
    }

    /**
     * 获取：插片add(OS)
     */
    public String getAddCpos() {
        return addCpos;
    }

    /**
     * 设置：插片测量距离(OD)
     */
    public void setDistanceOd(String distanceOd) {
        this.distanceOd = distanceOd;
    }

    /**
     * 获取：插片测量距离(OD)
     */
    public String getDistanceOd() {
        return distanceOd;
    }

    /**
     * 设置：插片测量距离(OS)
     */
    public void setDistanceOs(String distanceOs) {
        this.distanceOs = distanceOs;
    }

    /**
     * 获取：插片测量距离(OS)
     */
    public String getDistanceOs() {
        return distanceOs;
    }


    //双眼视功能检查（1是,2否）
    private String sgnSf;
    //原因
    private String sgnReason;
    //CISS得分
    private String sgnCiss;
    //WORTH 4 DOT 远
    private String sgnFardot;
    //WORTH 4 DOT 近
    private String sgnNeardot;
    //眼位远：水平1
    private String sgnFarsp1;
    //眼位远：水平下拉框2
    private String sgnFarsp2;
    //眼位远：垂直1
    private String sgnFarcz1;
    //眼位远：垂直下拉2
    private String sgnFarcz2;
    //眼位近：水平1
    private String sgnNearsp1;
    //眼位近：水平下拉框2
    private String sgnNearsp2;
    //眼位近：垂直1
    private String sgnNearcz1;
    //眼位近：垂直下拉2
    private String sgnNearcz2;
    //远距水平隐斜视1
    private String sgnVgfarsp1;
    //远距水平隐斜视2
    private String sgnVgfarsp2;
    //近距水平隐斜视1
    private String sgnVgnearsp1;
    //近距水平隐斜视2
    private String sgnVgnearsp2;
    //远距垂直隐斜视1
    private String sgnVgfarcz1;
    //远距垂直隐斜视2
    private String sgnVgfarcz2;
    //近距垂直隐斜视1
    private String sgnVgnearcz1;
    //近距垂直隐斜视2
    private String sgnVgnearcz2;
    //综合验光仪瞳距1
    private String sgnAllygytj1;
    //综合验光仪瞳距2
    private String sgnAllygytj2;
    //AC/A
    private String sgnAc;
    //立体式
    private String litishi;
    //1梯度法/2计算法
    private String sgnAcway;
    //调节反应1BBC/2MEM
    private String sgnTjfy;
    //调节反应OU
    private String sgnTjfyou;
    //调节反应OD
    private String sgnTjfyod;
    //调节反应OS
    private String sgnTjfyos;
    //正/负相对调节PRA
    private String sgnPra;
    //正/负相对调节NRA
    private String sgnNra;
    //遮盖单眼是否变清晰1是2否
    private String sgnZfsf;

    /**
     * 设置：双眼视功能检查（是否）
     */
    public void setSgnSf(String sgnSf) {
        this.sgnSf = sgnSf;
    }
    /**
     * 获取：双眼视功能检查（是否）
     */
    public String getSgnSf() {
        return sgnSf;
    }
    /**
     * 设置：原因
     */
    public void setSgnReason(String sgnReason) {
        this.sgnReason = sgnReason;
    }
    /**
     * 获取：原因
     */
    public String getSgnReason() {
        return sgnReason;
    }
    /**
     * 设置：CISS得分
     */
    public void setSgnCiss(String sgnCiss) {
        this.sgnCiss = sgnCiss;
    }
    /**
     * 获取：CISS得分
     */
    public String getSgnCiss() {
        return sgnCiss;
    }
    /**
     * 设置：WORTH 4 DOT 远
     */
    public void setSgnFardot(String sgnFardot) {
        this.sgnFardot = sgnFardot;
    }
    /**
     * 获取：WORTH 4 DOT 远
     */
    public String getSgnFardot() {
        return sgnFardot;
    }
    /**
     * 设置：WORTH 4 DOT 近
     */
    public void setSgnNeardot(String sgnNeardot) {
        this.sgnNeardot = sgnNeardot;
    }
    /**
     * 获取：WORTH 4 DOT 近
     */
    public String getSgnNeardot() {
        return sgnNeardot;
    }
    /**
     * 设置：眼位远：水平1
     */
    public void setSgnFarsp1(String sgnFarsp1) {
        this.sgnFarsp1 = sgnFarsp1;
    }
    /**
     * 获取：眼位远：水平1
     */
    public String getSgnFarsp1() {
        return sgnFarsp1;
    }
    /**
     * 设置：眼位远：水平下拉框2
     */
    public void setSgnFarsp2(String sgnFarsp2) {
        this.sgnFarsp2 = sgnFarsp2;
    }
    /**
     * 获取：眼位远：水平下拉框2
     */
    public String getSgnFarsp2() {
        return sgnFarsp2;
    }
    /**
     * 设置：眼位远：垂直1
     */
    public void setSgnFarcz1(String sgnFarcz1) {
        this.sgnFarcz1 = sgnFarcz1;
    }
    /**
     * 获取：眼位远：垂直1
     */
    public String getSgnFarcz1() {
        return sgnFarcz1;
    }
    /**
     * 设置：眼位远：垂直下拉2
     */
    public void setSgnFarcz2(String sgnFarcz2) {
        this.sgnFarcz2 = sgnFarcz2;
    }
    /**
     * 获取：眼位远：垂直下拉2
     */
    public String getSgnFarcz2() {
        return sgnFarcz2;
    }
    /**
     * 设置：眼位近：水平1
     */
    public void setSgnNearsp1(String sgnNearsp1) {
        this.sgnNearsp1 = sgnNearsp1;
    }
    /**
     * 获取：眼位近：水平1
     */
    public String getSgnNearsp1() {
        return sgnNearsp1;
    }
    /**
     * 设置：眼位近：水平下拉框2
     */
    public void setSgnNearsp2(String sgnNearsp2) {
        this.sgnNearsp2 = sgnNearsp2;
    }
    /**
     * 获取：眼位近：水平下拉框2
     */
    public String getSgnNearsp2() {
        return sgnNearsp2;
    }
    /**
     * 设置：眼位近：垂直1
     */
    public void setSgnNearcz1(String sgnNearcz1) {
        this.sgnNearcz1 = sgnNearcz1;
    }
    /**
     * 获取：眼位近：垂直1
     */
    public String getSgnNearcz1() {
        return sgnNearcz1;
    }
    /**
     * 设置：眼位近：垂直下拉2
     */
    public void setSgnNearcz2(String sgnNearcz2) {
        this.sgnNearcz2 = sgnNearcz2;
    }
    /**
     * 获取：眼位近：垂直下拉2
     */
    public String getSgnNearcz2() {
        return sgnNearcz2;
    }
    /**
     * 设置：远距水平隐斜视1
     */
    public void setSgnVgfarsp1(String sgnVgfarsp1) {
        this.sgnVgfarsp1 = sgnVgfarsp1;
    }
    /**
     * 获取：远距水平隐斜视1
     */
    public String getSgnVgfarsp1() {
        return sgnVgfarsp1;
    }
    /**
     * 设置：远距水平隐斜视2
     */
    public void setSgnVgfarsp2(String sgnVgfarsp2) {
        this.sgnVgfarsp2 = sgnVgfarsp2;
    }
    /**
     * 获取：远距水平隐斜视2
     */
    public String getSgnVgfarsp2() {
        return sgnVgfarsp2;
    }
    /**
     * 设置：近距水平隐斜视1
     */
    public void setSgnVgnearsp1(String sgnVgnearsp1) {
        this.sgnVgnearsp1 = sgnVgnearsp1;
    }
    /**
     * 获取：近距水平隐斜视1
     */
    public String getSgnVgnearsp1() {
        return sgnVgnearsp1;
    }
    /**
     * 设置：近距水平隐斜视2
     */
    public void setSgnVgnearsp2(String sgnVgnearsp2) {
        this.sgnVgnearsp2 = sgnVgnearsp2;
    }
    /**
     * 获取：近距水平隐斜视2
     */
    public String getSgnVgnearsp2() {
        return sgnVgnearsp2;
    }
    /**
     * 设置：远距垂直隐斜视1
     */
    public void setSgnVgfarcz1(String sgnVgfarcz1) {
        this.sgnVgfarcz1 = sgnVgfarcz1;
    }
    /**
     * 获取：远距垂直隐斜视1
     */
    public String getSgnVgfarcz1() {
        return sgnVgfarcz1;
    }
    /**
     * 设置：远距垂直隐斜视2
     */
    public void setSgnVgfarcz2(String sgnVgfarcz2) {
        this.sgnVgfarcz2 = sgnVgfarcz2;
    }
    /**
     * 获取：远距垂直隐斜视2
     */
    public String getSgnVgfarcz2() {
        return sgnVgfarcz2;
    }
    /**
     * 设置：近距垂直隐斜视1
     */
    public void setSgnVgnearcz1(String sgnVgnearcz1) {
        this.sgnVgnearcz1 = sgnVgnearcz1;
    }
    /**
     * 获取：近距垂直隐斜视1
     */
    public String getSgnVgnearcz1() {
        return sgnVgnearcz1;
    }
    /**
     * 设置：近距垂直隐斜视2
     */
    public void setSgnVgnearcz2(String sgnVgnearcz2) {
        this.sgnVgnearcz2 = sgnVgnearcz2;
    }
    /**
     * 获取：近距垂直隐斜视2
     */
    public String getSgnVgnearcz2() {
        return sgnVgnearcz2;
    }
    /**
     * 设置：综合验光仪瞳距1
     */
    public void setSgnAllygytj1(String sgnAllygytj1) {
        this.sgnAllygytj1 = sgnAllygytj1;
    }
    /**
     * 获取：综合验光仪瞳距1
     */
    public String getSgnAllygytj1() {
        return sgnAllygytj1;
    }
    /**
     * 设置：综合验光仪瞳距2
     */
    public void setSgnAllygytj2(String sgnAllygytj2) {
        this.sgnAllygytj2 = sgnAllygytj2;
    }
    /**
     * 获取：综合验光仪瞳距2
     */
    public String getSgnAllygytj2() {
        return sgnAllygytj2;
    }
    /**
     * 设置：AC/A
     */
    public void setSgnAc(String sgnAc) {
        this.sgnAc = sgnAc;
    }
    /**
     * 获取：AC/A
     */
    public String getSgnAc() {
        return sgnAc;
    }
    //立体式

    public String getLitishi() {
        return litishi;
    }

    public void setLitishi(String litishi) {
        this.litishi = litishi;
    }

    /**
     * 设置：梯度法/计算法
     */
    public void setSgnAcway(String sgnAcway) {
        this.sgnAcway = sgnAcway;
    }
    /**
     * 获取：梯度法/计算法
     */
    public String getSgnAcway() {
        return sgnAcway;
    }
    /**
     * 设置：调节反应BBC/MEM
     */
    public void setSgnTjfy(String sgnTjfy) {
        this.sgnTjfy = sgnTjfy;
    }
    /**
     * 获取：调节反应BBC/MEM
     */
    public String getSgnTjfy() {
        return sgnTjfy;
    }
    /**
     * 设置：调节反应OU
     */
    public void setSgnTjfyou(String sgnTjfyou) {
        this.sgnTjfyou = sgnTjfyou;
    }
    /**
     * 获取：调节反应OU
     */
    public String getSgnTjfyou() {
        return sgnTjfyou;
    }
    /**
     * 设置：调节反应OD
     */
    public void setSgnTjfyod(String sgnTjfyod) {
        this.sgnTjfyod = sgnTjfyod;
    }
    /**
     * 获取：调节反应OD
     */
    public String getSgnTjfyod() {
        return sgnTjfyod;
    }
    /**
     * 设置：调节反应OS
     */
    public void setSgnTjfyos(String sgnTjfyos) {
        this.sgnTjfyos = sgnTjfyos;
    }
    /**
     * 获取：调节反应OS
     */
    public String getSgnTjfyos() {
        return sgnTjfyos;
    }
    /**
     * 设置：正/负相对调节PRA
     */
    public void setSgnPra(String sgnPra) {
        this.sgnPra = sgnPra;
    }
    /**
     * 获取：正/负相对调节PRA
     */
    public String getSgnPra() {
        return sgnPra;
    }
    /**
     * 设置：正/负相对调节NRA
     */
    public void setSgnNra(String sgnNra) {
        this.sgnNra = sgnNra;
    }
    /**
     * 获取：正/负相对调节NRA
     */
    public String getSgnNra() {
        return sgnNra;
    }
    /**
     * 设置：遮盖单眼是否变清晰是否
     */
    public void setSgnZfsf(String sgnZfsf) {
        this.sgnZfsf = sgnZfsf;
    }
    /**
     * 获取：遮盖单眼是否变清晰是否
     */
    public String getSgnZfsf() {
        return sgnZfsf;
    }
    /**
     * 设置：球镜(右眼OD)后
     */
    public void setSphereRight2(String sphereRight2) {
        this.sphereRight2 = sphereRight2;
    }
    /**
     * 获取：球镜(右眼OD)后
     */
    public String getSphereRight2() {
        return sphereRight2;
    }
    /**
     * 设置：球镜(左眼OS)后
     */
    public void setSphereLeft2(String sphereLeft2) {
        this.sphereLeft2 = sphereLeft2;
    }
    /**
     * 获取：球镜(左眼OS)后
     */
    public String getSphereLeft2() {
        return sphereLeft2;
    }
    /**
     * 设置：柱镜(右眼OD)后
     */
    public void setCylinderRight2(String cylinderRight2) {
        this.cylinderRight2 = cylinderRight2;
    }
    /**
     * 获取：柱镜(右眼OD)后
     */
    public String getCylinderRight2() {
        return cylinderRight2;
    }
    /**
     * 设置：柱镜(左眼OS)后
     */
    public void setCylinderLeft2(String cylinderLeft2) {
        this.cylinderLeft2 = cylinderLeft2;
    }
    /**
     * 获取：柱镜(左眼OS)后
     */
    public String getCylinderLeft2() {
        return cylinderLeft2;
    }
    /**
     * 设置：轴向(右眼-OD)后
     */
    public void setAxialRight2(String axialRight2) {
        this.axialRight2 = axialRight2;
    }
    /**
     * 获取：轴向(右眼-OD)后
     */
    public String getAxialRight2() {
        return axialRight2;
    }
    /**
     * 设置：轴向(左眼OS)后
     */
    public void setAxialLeft2(String axialLeft2) {
        this.axialLeft2 = axialLeft2;
    }
    /**
     * 获取：轴向(左眼OS)后
     */
    public String getAxialLeft2() {
        return axialLeft2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getSexx() {
        return sexx;
    }

    public void setSexx(String sexx) {
        this.sexx = sexx;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    private String trystatus;
    private String rstatus;

    public String getTrystatus() {
        return trystatus;
    }

    public void setTrystatus(String trystatus) {
        this.trystatus = trystatus;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

}


