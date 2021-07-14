package com.shiguang.jiancha.domain;

import java.io.Serializable;


/**
 * 检查结论表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 18:36:09
 */
public class ResultDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //检查结论id
    private Long id;
    //卡号
    private String cardNumber;
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


    //框架远用id
    private Long kjyyId;

    //处方类型
    private String kjyyPrescriptionType;
    //医生
    private String kjyyDoctor;
    //验光师
    private String kjyyOptometryName;
    //球镜OD
    private Double kjyySphod;
    //球镜OS
    private Double kjyySphos;
    //柱镜OD
    private Double kjyyCylod;
    //柱镜OS
    private Double kjyyCylos;
    //轴向OD
    private Double kjyyAxialod;
    //轴向OS
    private Double kjyyAxialos;
    //三棱镜(OD)
    private Double kjyyPrismod;
    //三棱镜(OS)
    private Double kjyyPrismos;
    //基底(OD)
    private String kjyyJdod;
    //基底(OS)
    private String kjyyJdos;
    //远用瞳距(mm)(OD)
    private Double kjyyYytjod;
    //远用瞳距(mm)(OS)
    private Double kjyyYytjos;
    //瞳高(mm)(OD)
    private Double kjyyTgod;
    //瞳高(mm)(OS)
    private Double kjyyTgos;
    //远用va(OD)
    private Double kjyyVaod;
    //远用va(OS)
    private Double kjyyVaos;
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
    public void setKjyySphod(Double kjyySphod) {
        this.kjyySphod = kjyySphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getKjyySphod() {
        return kjyySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjyySphos(Double kjyySphos) {
        this.kjyySphos = kjyySphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getKjyySphos() {
        return kjyySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjyyCylod(Double kjyyCylod) {
        this.kjyyCylod = kjyyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getKjyyCylod() {
        return kjyyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjyyCylos(Double kjyyCylos) {
        this.kjyyCylos = kjyyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getKjyyCylos() {
        return kjyyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjyyAxialod(Double kjyyAxialod) {
        this.kjyyAxialod = kjyyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getKjyyAxialod() {
        return kjyyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjyyAxialos(Double kjyyAxialos) {
        this.kjyyAxialos = kjyyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getKjyyAxialos() {
        return kjyyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjyyPrismod(Double kjyyPrismod) {
        this.kjyyPrismod = kjyyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getKjyyPrismod() {
        return kjyyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjyyPrismos(Double kjyyPrismos) {
        this.kjyyPrismos = kjyyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getKjyyPrismos() {
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
    public void setKjyyYytjod(Double kjyyYytjod) {
        this.kjyyYytjod = kjyyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getKjyyYytjod() {
        return kjyyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjyyYytjos(Double kjyyYytjos) {
        this.kjyyYytjos = kjyyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getKjyyYytjos() {
        return kjyyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjyyTgod(Double kjyyTgod) {
        this.kjyyTgod = kjyyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getKjyyTgod() {
        return kjyyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjyyTgos(Double kjyyTgos) {
        this.kjyyTgos = kjyyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getKjyyTgos() {
        return kjyyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjyyVaod(Double kjyyVaod) {
        this.kjyyVaod = kjyyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getKjyyVaod() {
        return kjyyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjyyVaos(Double kjyyVaos) {
        this.kjyyVaos = kjyyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getKjyyVaos() {
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


    //框架近用id
    private Long kjjyId;

    //处方类型
    private String kjjyPrescriptionType;
    //医生
    private String kjjyDoctor;
    //验光师
    private String kjjyOptometryName;
    //球镜OD
    private Double kjjySphod;
    //球镜OS
    private Double kjjySphos;
    //柱镜OD
    private Double kjjyCylod;
    //柱镜OS
    private Double kjjyCylos;
    //轴向OD
    private Double kjjyAxialod;
    //轴向OS
    private Double kjjyAxialos;
    //三棱镜(OD)
    private Double kjjyPrismod;
    //三棱镜(OS)
    private Double kjjyPrismos;
    //基底(OD)
    private String kjjyJdod;
    //基底(OS)
    private String kjjyJdos;
    //远用瞳距(mm)(OD)
    private Double kjjyYytjod;
    //远用瞳距(mm)(OS)
    private Double kjjyYytjos;
    //瞳高(mm)(OD)
    private Double kjjyTgod;
    //瞳高(mm)(OS)
    private Double kjjyTgos;
    //远用va(OD)
    private Double kjjyVaod;
    //远用va(OS)
    private Double kjjyVaos;
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
    public void setKjjySphod(Double kjjySphod) {
        this.kjjySphod = kjjySphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getKjjySphod() {
        return kjjySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setKjjySphos(Double kjjySphos) {
        this.kjjySphos = kjjySphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getKjjySphos() {
        return kjjySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setKjjyCylod(Double kjjyCylod) {
        this.kjjyCylod = kjjyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getKjjyCylod() {
        return kjjyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setKjjyCylos(Double kjjyCylos) {
        this.kjjyCylos = kjjyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getKjjyCylos() {
        return kjjyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setKjjyAxialod(Double kjjyAxialod) {
        this.kjjyAxialod = kjjyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getKjjyAxialod() {
        return kjjyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setKjjyAxialos(Double kjjyAxialos) {
        this.kjjyAxialos = kjjyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getKjjyAxialos() {
        return kjjyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setKjjyPrismod(Double kjjyPrismod) {
        this.kjjyPrismod = kjjyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getKjjyPrismod() {
        return kjjyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setKjjyPrismos(Double kjjyPrismos) {
        this.kjjyPrismos = kjjyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getKjjyPrismos() {
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
    public void setKjjyYytjod(Double kjjyYytjod) {
        this.kjjyYytjod = kjjyYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getKjjyYytjod() {
        return kjjyYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setKjjyYytjos(Double kjjyYytjos) {
        this.kjjyYytjos = kjjyYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getKjjyYytjos() {
        return kjjyYytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setKjjyTgod(Double kjjyTgod) {
        this.kjjyTgod = kjjyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getKjjyTgod() {
        return kjjyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setKjjyTgos(Double kjjyTgos) {
        this.kjjyTgos = kjjyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getKjjyTgos() {
        return kjjyTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setKjjyVaod(Double kjjyVaod) {
        this.kjjyVaod = kjjyVaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getKjjyVaod() {
        return kjjyVaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setKjjyVaos(Double kjjyVaos) {
        this.kjjyVaos = kjjyVaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getKjjyVaos() {
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
}

