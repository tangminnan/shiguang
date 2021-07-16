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

    //双光渐进id
    private Long sgjjId;
    //处方类型
    private String sgjjPrescriptionType;
    //医生
    private String sgjjDoctor;
    //验光师
    private String sgjjOptometryName;
    //球镜OD
    private Double sgjjSphod;
    //球镜OS
    private Double sgjjSphos;
    //柱镜OD
    private Double sgjjCylod;
    //柱镜OS
    private Double sgjjCylos;
    //轴向OD
    private Double sgjjAxialod;
    //轴向OS
    private Double sgjjAxialos;
    //Add(OD)
    private Double sgjjAddod;
    //Add(OS)
    private Double sgjjAddos;
    //远用瞳距(mm)(OD)
    private Double sgjjYytjod;
    //远用瞳距(mm)(OS)
    private Double sgjjYytjos;
    //近用瞳距(mm)(OD)
    private Double sgjjJytjod;
    //近用瞳距(mm)(OS)
    private Double sgjjJytjos;
    //瞳高(mm)(OD)
    private Double sgjjTgod;
    //瞳高(mm)(OS)
    private Double sgjjTgos;
    //远用va(OD)
    private Double sgjjYyvaod;
    //远用va(OS)
    private Double sgjjYyvaos;
    //近用va(OD)
    private Double sgjjJyvaod;
    //近用va(OS)
    private Double sgjjJyvaos;
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
    public void setSgjjSphod(Double sgjjSphod) {
        this.sgjjSphod = sgjjSphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getSgjjSphod() {
        return sgjjSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSgjjSphos(Double sgjjSphos) {
        this.sgjjSphos = sgjjSphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getSgjjSphos() {
        return sgjjSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSgjjCylod(Double sgjjCylod) {
        this.sgjjCylod = sgjjCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getSgjjCylod() {
        return sgjjCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSgjjCylos(Double sgjjCylos) {
        this.sgjjCylos = sgjjCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getSgjjCylos() {
        return sgjjCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSgjjAxialod(Double sgjjAxialod) {
        this.sgjjAxialod = sgjjAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getSgjjAxialod() {
        return sgjjAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSgjjAxialos(Double sgjjAxialos) {
        this.sgjjAxialos = sgjjAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getSgjjAxialos() {
        return sgjjAxialos;
    }

    /**
     * 设置：Add(OD)
     */
    public void setSgjjAddod(Double sgjjAddod) {
        this.sgjjAddod = sgjjAddod;
    }

    /**
     * 获取：Add(OD)
     */
    public Double getSgjjAddod() {
        return sgjjAddod;
    }

    /**
     * 设置：Add(OS)
     */
    public void setSgjjAddos(Double sgjjAddos) {
        this.sgjjAddos = sgjjAddos;
    }

    /**
     * 获取：Add(OS)
     */
    public Double getSgjjAddos() {
        return sgjjAddos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSgjjYytjod(Double sgjjYytjod) {
        this.sgjjYytjod = sgjjYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getSgjjYytjod() {
        return sgjjYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSgjjYytjos(Double sgjjYytjos) {
        this.sgjjYytjos = sgjjYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getSgjjYytjos() {
        return sgjjYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSgjjJytjod(Double sgjjJytjod) {
        this.sgjjJytjod = sgjjJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public Double getSgjjJytjod() {
        return sgjjJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSgjjJytjos(Double sgjjJytjos) {
        this.sgjjJytjos = sgjjJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public Double getSgjjJytjos() {
        return sgjjJytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setSgjjTgod(Double sgjjTgod) {
        this.sgjjTgod = sgjjTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getSgjjTgod() {
        return sgjjTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setSgjjTgos(Double sgjjTgos) {
        this.sgjjTgos = sgjjTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getSgjjTgos() {
        return sgjjTgos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSgjjYyvaod(Double sgjjYyvaod) {
        this.sgjjYyvaod = sgjjYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getSgjjYyvaod() {
        return sgjjYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSgjjYyvaos(Double sgjjYyvaos) {
        this.sgjjYyvaos = sgjjYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getSgjjYyvaos() {
        return sgjjYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSgjjJyvaod(Double sgjjJyvaod) {
        this.sgjjJyvaod = sgjjJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public Double getSgjjJyvaod() {
        return sgjjJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSgjjJyvaos(Double sgjjJyvaos) {
        this.sgjjJyvaos = sgjjJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public Double getSgjjJyvaos() {
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


    //软性角膜接触镜id
    private Long rxId;
    //处方类型
    private String rxPrescriptionType;
    //医生
    private String rxDoctor;
    //验光师
    private String rxOptometryName;
    //BC(OD)
    private Double rxBcod;
    //BC(OS)
    private Double rxBcos;
    //球镜OD
    private Double rxSphod;
    //球镜OS
    private Double rxSphos;
    //柱镜OD
    private Double rxCylod;
    //柱镜OS
    private Double rxCylos;
    //轴向OD
    private Double rxAxialod;
    //轴向OS
    private Double rxAxialos;
    //直径(OD)
    private Double rxZjod;
    //直径(OS)
    private Double rxZjos;
    //va(OD)
    private Double rxVaod;
    //va(OS)
    private Double rxVaos;
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
    public void setRxBcod(Double rxBcod) {
        this.rxBcod = rxBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public Double getRxBcod() {
        return rxBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setRxBcos(Double rxBcos) {
        this.rxBcos = rxBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public Double getRxBcos() {
        return rxBcos;
    }

    /**
     * 设置：球镜OD
     */
    public void setRxSphod(Double rxSphod) {
        this.rxSphod = rxSphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getRxSphod() {
        return rxSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setRxSphos(Double rxSphos) {
        this.rxSphos = rxSphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getRxSphos() {
        return rxSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setRxCylod(Double rxCylod) {
        this.rxCylod = rxCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getRxCylod() {
        return rxCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setRxCylos(Double rxCylos) {
        this.rxCylos = rxCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getRxCylos() {
        return rxCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setRxAxialod(Double rxAxialod) {
        this.rxAxialod = rxAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getRxAxialod() {
        return rxAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setRxAxialos(Double rxAxialos) {
        this.rxAxialos = rxAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getRxAxialos() {
        return rxAxialos;
    }

    /**
     * 设置：直径(OD)
     */
    public void setRxZjod(Double rxZjod) {
        this.rxZjod = rxZjod;
    }

    /**
     * 获取：直径(OD)
     */
    public Double getRxZjod() {
        return rxZjod;
    }

    /**
     * 设置：直径(OS)
     */
    public void setRxZjos(Double rxZjos) {
        this.rxZjos = rxZjos;
    }

    /**
     * 获取：直径(OS)
     */
    public Double getRxZjos() {
        return rxZjos;
    }

    /**
     * 设置：va(OD)
     */
    public void setRxVaod(Double rxVaod) {
        this.rxVaod = rxVaod;
    }

    /**
     * 获取：va(OD)
     */
    public Double getRxVaod() {
        return rxVaod;
    }

    /**
     * 设置：va(OS)
     */
    public void setRxVaos(Double rxVaos) {
        this.rxVaos = rxVaos;
    }

    /**
     * 获取：va(OS)
     */
    public Double getRxVaos() {
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


    //中用id
    private Long zyId;
    //处方类型
    private String zyPrescriptionType;
    //医生
    private String zyDoctor;
    //验光师
    private String zyOptometryName;
    //球镜OD
    private Double zySphod;
    //球镜OS
    private Double zySphos;
    //柱镜OD
    private Double zyCylod;
    //柱镜OS
    private Double zyCylos;
    //轴向OD
    private Double zyAxialod;
    //轴向OS
    private Double zyAxialos;
    //三棱镜(OD)
    private Double zyPrismod;
    //三棱镜(OS)
    private Double zyPrismos;
    //基底(OD)
    private String zyJdod;
    //基底(OS)
    private String zyJdos;
    //中用瞳距(mm)(OD)
    private Double zyZytjod;
    //中用瞳距(mm)(OS)
    private Double zyZytjos;
    //瞳高(mm)(OD)
    private Double zyTgod;
    //瞳高(mm)(OS)
    private Double zyTgos;
    //中用va(OD)
    private Double zyVaod;
    //中用va(OS)
    private Double zyVaos;
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

    /**
     * 设置：中用id
     */
    public void setZyId(Long zyId) {
        this.zyId = zyId;
    }

    /**
     * 获取：中用id
     */
    public Long getZyId() {
        return zyId;
    }

    /**
     * 设置：处方类型
     */
    public void setZyPrescriptionType(String zyPrescriptionType) {
        this.zyPrescriptionType = zyPrescriptionType;
    }

    /**
     * 获取：处方类型
     */
    public String getZyPrescriptionType() {
        return zyPrescriptionType;
    }

    /**
     * 设置：医生
     */
    public void setZyDoctor(String zyDoctor) {
        this.zyDoctor = zyDoctor;
    }

    /**
     * 获取：医生
     */
    public String getZyDoctor() {
        return zyDoctor;
    }

    /**
     * 设置：验光师
     */
    public void setZyOptometryName(String zyOptometryName) {
        this.zyOptometryName = zyOptometryName;
    }

    /**
     * 获取：验光师
     */
    public String getZyOptometryName() {
        return zyOptometryName;
    }

    /**
     * 设置：球镜OD
     */
    public void setZySphod(Double zySphod) {
        this.zySphod = zySphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getZySphod() {
        return zySphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setZySphos(Double zySphos) {
        this.zySphos = zySphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getZySphos() {
        return zySphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setZyCylod(Double zyCylod) {
        this.zyCylod = zyCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getZyCylod() {
        return zyCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setZyCylos(Double zyCylos) {
        this.zyCylos = zyCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getZyCylos() {
        return zyCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setZyAxialod(Double zyAxialod) {
        this.zyAxialod = zyAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getZyAxialod() {
        return zyAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setZyAxialos(Double zyAxialos) {
        this.zyAxialos = zyAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getZyAxialos() {
        return zyAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setZyPrismod(Double zyPrismod) {
        this.zyPrismod = zyPrismod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getZyPrismod() {
        return zyPrismod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setZyPrismos(Double zyPrismos) {
        this.zyPrismos = zyPrismos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getZyPrismos() {
        return zyPrismos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setZyJdod(String zyJdod) {
        this.zyJdod = zyJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public String getZyJdod() {
        return zyJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setZyJdos(String zyJdos) {
        this.zyJdos = zyJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public String getZyJdos() {
        return zyJdos;
    }

    /**
     * 设置：中用瞳距(mm)(OD)
     */
    public void setZyZytjod(Double zyZytjod) {
        this.zyZytjod = zyZytjod;
    }

    /**
     * 获取：中用瞳距(mm)(OD)
     */
    public Double getZyZytjod() {
        return zyZytjod;
    }

    /**
     * 设置：中用瞳距(mm)(OS)
     */
    public void setZyZytjos(Double zyZytjos) {
        this.zyZytjos = zyZytjos;
    }

    /**
     * 获取：中用瞳距(mm)(OS)
     */
    public Double getZyZytjos() {
        return zyZytjos;
    }

    /**
     * 设置：瞳高(mm)(OD)
     */
    public void setZyTgod(Double zyTgod) {
        this.zyTgod = zyTgod;
    }

    /**
     * 获取：瞳高(mm)(OD)
     */
    public Double getZyTgod() {
        return zyTgod;
    }

    /**
     * 设置：瞳高(mm)(OS)
     */
    public void setZyTgos(Double zyTgos) {
        this.zyTgos = zyTgos;
    }

    /**
     * 获取：瞳高(mm)(OS)
     */
    public Double getZyTgos() {
        return zyTgos;
    }

    /**
     * 设置：中用va(OD)
     */
    public void setZyVaod(Double zyVaod) {
        this.zyVaod = zyVaod;
    }

    /**
     * 获取：中用va(OD)
     */
    public Double getZyVaod() {
        return zyVaod;
    }

    /**
     * 设置：中用va(OS)
     */
    public void setZyVaos(Double zyVaos) {
        this.zyVaos = zyVaos;
    }

    /**
     * 获取：中用va(OS)
     */
    public Double getZyVaos() {
        return zyVaos;
    }

    /**
     * 设置：建议镜片材质
     */
    public void setZyJpcz(String zyJpcz) {
        this.zyJpcz = zyJpcz;
    }

    /**
     * 获取：建议镜片材质
     */
    public String getZyJpcz() {
        return zyJpcz;
    }

    /**
     * 设置：处理方式
     */
    public void setZyClfs(String zyClfs) {
        this.zyClfs = zyClfs;
    }

    /**
     * 获取：处理方式
     */
    public String getZyClfs() {
        return zyClfs;
    }

    /**
     * 设置：建议镜框
     */
    public void setZyJyjk(String zyJyjk) {
        this.zyJyjk = zyJyjk;
    }

    /**
     * 获取：建议镜框
     */
    public String getZyJyjk() {
        return zyJyjk;
    }

    /**
     * 设置：镜框类型
     */
    public void setZyJklx(String zyJklx) {
        this.zyJklx = zyJklx;
    }

    /**
     * 获取：镜框类型
     */
    public String getZyJklx() {
        return zyJklx;
    }

    /**
     * 设置：文本
     */
    public void setZyText(String zyText) {
        this.zyText = zyText;
    }

    /**
     * 获取：文本
     */
    public String getZyText() {
        return zyText;
    }

    /**
     * 设置：备注
     */
    public void setZyBeizhu(String zyBeizhu) {
        this.zyBeizhu = zyBeizhu;
    }

    /**
     * 获取：备注
     */
    public String getZyBeizhu() {
        return zyBeizhu;
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
    private Double sjxlSphod;
    //球镜OS
    private Double sjxlSphos;
    //柱镜OD
    private Double sjxlCylod;
    //柱镜OS
    private Double sjxlCylos;
    //轴向OD
    private Double sjxlAxialod;
    //轴向OS
    private Double sjxlAxialos;
    //三棱镜(OD)
    private Double sjxlSljod;
    //三棱镜(OS)
    private Double sjxlSljos;
    //基底(OD)
    private Double sjxlJdod;
    //基底(OS)
    private Double sjxlJdos;
    //远用瞳距(mm)(OD)
    private Double sjxlYytjod;
    //远用瞳距(mm)(OS)
    private Double sjxlYytjos;
    //近用瞳距(mm)(OD)
    private Double sjxlJytjod;
    //近用瞳距(mm)(OS)
    private Double sjxlJytjos;
    //远用va(OD)
    private Double sjxlYyvaod;
    //远用va(OS)
    private Double sjxlYyvaos;
    //近用va(OD)
    private Double sjxlJyvaod;
    //近用va(OS)
    private Double sjxlJyvaos;
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
    public void setSjxlSphod(Double sjxlSphod) {
        this.sjxlSphod = sjxlSphod;
    }

    /**
     * 获取：球镜OD
     */
    public Double getSjxlSphod() {
        return sjxlSphod;
    }

    /**
     * 设置：球镜OS
     */
    public void setSjxlSphos(Double sjxlSphos) {
        this.sjxlSphos = sjxlSphos;
    }

    /**
     * 获取：球镜OS
     */
    public Double getSjxlSphos() {
        return sjxlSphos;
    }

    /**
     * 设置：柱镜OD
     */
    public void setSjxlCylod(Double sjxlCylod) {
        this.sjxlCylod = sjxlCylod;
    }

    /**
     * 获取：柱镜OD
     */
    public Double getSjxlCylod() {
        return sjxlCylod;
    }

    /**
     * 设置：柱镜OS
     */
    public void setSjxlCylos(Double sjxlCylos) {
        this.sjxlCylos = sjxlCylos;
    }

    /**
     * 获取：柱镜OS
     */
    public Double getSjxlCylos() {
        return sjxlCylos;
    }

    /**
     * 设置：轴向OD
     */
    public void setSjxlAxialod(Double sjxlAxialod) {
        this.sjxlAxialod = sjxlAxialod;
    }

    /**
     * 获取：轴向OD
     */
    public Double getSjxlAxialod() {
        return sjxlAxialod;
    }

    /**
     * 设置：轴向OS
     */
    public void setSjxlAxialos(Double sjxlAxialos) {
        this.sjxlAxialos = sjxlAxialos;
    }

    /**
     * 获取：轴向OS
     */
    public Double getSjxlAxialos() {
        return sjxlAxialos;
    }

    /**
     * 设置：三棱镜(OD)
     */
    public void setSjxlSljod(Double sjxlSljod) {
        this.sjxlSljod = sjxlSljod;
    }

    /**
     * 获取：三棱镜(OD)
     */
    public Double getSjxlSljod() {
        return sjxlSljod;
    }

    /**
     * 设置：三棱镜(OS)
     */
    public void setSjxlSljos(Double sjxlSljos) {
        this.sjxlSljos = sjxlSljos;
    }

    /**
     * 获取：三棱镜(OS)
     */
    public Double getSjxlSljos() {
        return sjxlSljos;
    }

    /**
     * 设置：基底(OD)
     */
    public void setSjxlJdod(Double sjxlJdod) {
        this.sjxlJdod = sjxlJdod;
    }

    /**
     * 获取：基底(OD)
     */
    public Double getSjxlJdod() {
        return sjxlJdod;
    }

    /**
     * 设置：基底(OS)
     */
    public void setSjxlJdos(Double sjxlJdos) {
        this.sjxlJdos = sjxlJdos;
    }

    /**
     * 获取：基底(OS)
     */
    public Double getSjxlJdos() {
        return sjxlJdos;
    }

    /**
     * 设置：远用瞳距(mm)(OD)
     */
    public void setSjxlYytjod(Double sjxlYytjod) {
        this.sjxlYytjod = sjxlYytjod;
    }

    /**
     * 获取：远用瞳距(mm)(OD)
     */
    public Double getSjxlYytjod() {
        return sjxlYytjod;
    }

    /**
     * 设置：远用瞳距(mm)(OS)
     */
    public void setSjxlYytjos(Double sjxlYytjos) {
        this.sjxlYytjos = sjxlYytjos;
    }

    /**
     * 获取：远用瞳距(mm)(OS)
     */
    public Double getSjxlYytjos() {
        return sjxlYytjos;
    }

    /**
     * 设置：近用瞳距(mm)(OD)
     */
    public void setSjxlJytjod(Double sjxlJytjod) {
        this.sjxlJytjod = sjxlJytjod;
    }

    /**
     * 获取：近用瞳距(mm)(OD)
     */
    public Double getSjxlJytjod() {
        return sjxlJytjod;
    }

    /**
     * 设置：近用瞳距(mm)(OS)
     */
    public void setSjxlJytjos(Double sjxlJytjos) {
        this.sjxlJytjos = sjxlJytjos;
    }

    /**
     * 获取：近用瞳距(mm)(OS)
     */
    public Double getSjxlJytjos() {
        return sjxlJytjos;
    }

    /**
     * 设置：远用va(OD)
     */
    public void setSjxlYyvaod(Double sjxlYyvaod) {
        this.sjxlYyvaod = sjxlYyvaod;
    }

    /**
     * 获取：远用va(OD)
     */
    public Double getSjxlYyvaod() {
        return sjxlYyvaod;
    }

    /**
     * 设置：远用va(OS)
     */
    public void setSjxlYyvaos(Double sjxlYyvaos) {
        this.sjxlYyvaos = sjxlYyvaos;
    }

    /**
     * 获取：远用va(OS)
     */
    public Double getSjxlYyvaos() {
        return sjxlYyvaos;
    }

    /**
     * 设置：近用va(OD)
     */
    public void setSjxlJyvaod(Double sjxlJyvaod) {
        this.sjxlJyvaod = sjxlJyvaod;
    }

    /**
     * 获取：近用va(OD)
     */
    public Double getSjxlJyvaod() {
        return sjxlJyvaod;
    }

    /**
     * 设置：近用va(OS)
     */
    public void setSjxlJyvaos(Double sjxlJyvaos) {
        this.sjxlJyvaos = sjxlJyvaos;
    }

    /**
     * 获取：近用va(OS)
     */
    public Double getSjxlJyvaos() {
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

    //角膜接触镜VSTid
    private Long vstId;
    //处方类型
    private String vstPrescriptionType;
    //医生
    private String vstDoctor;
    //试戴片编号OD
    private String vstSdbhod;
    //试戴片编号OS
    private String vstSdbhos;
    //FK(OD)
    private Double vstFkod;
    //FK(OS)
    private Double vstFkos;
    //曲率半径(OD)
    private Double vstQlbjod;
    //曲率半径(OS)
    private Double vstQlbjos;
    //AC(OD)
    private Double vstAcod;
    //AC(OS)
    private Double vstAcos;
    //降幅OD
    private Double vstJfod;
    //降幅OS
    private Double vstJfos;
    //DIA(OD)
    private Double vstDiaod;
    //DIA(OS)
    private Double vstDiaos;
    //BC(OD)
    private Double vstBcod;
    //BC(OS)
    private Double vstBcos;
    //CP/CLY(OD)
    private Double vstCpclyod;
    //CP/CLY(OS)
    private Double vstCpclyos;
    //E值(OD)
    private Double vstEod;
    //E值(OS)
    private Double vstEos;
    //VA(OD)
    private Double vstVaod;
    //VA(OS)
    private Double vstVaos;
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
    public void setVstFkod(Double vstFkod) {
        this.vstFkod = vstFkod;
    }

    /**
     * 获取：FK(OD)
     */
    public Double getVstFkod() {
        return vstFkod;
    }

    /**
     * 设置：FK(OS)
     */
    public void setVstFkos(Double vstFkos) {
        this.vstFkos = vstFkos;
    }

    /**
     * 获取：FK(OS)
     */
    public Double getVstFkos() {
        return vstFkos;
    }

    /**
     * 设置：曲率半径(OD)
     */
    public void setVstQlbjod(Double vstQlbjod) {
        this.vstQlbjod = vstQlbjod;
    }

    /**
     * 获取：曲率半径(OD)
     */
    public Double getVstQlbjod() {
        return vstQlbjod;
    }

    /**
     * 设置：曲率半径(OS)
     */
    public void setVstQlbjos(Double vstQlbjos) {
        this.vstQlbjos = vstQlbjos;
    }

    /**
     * 获取：曲率半径(OS)
     */
    public Double getVstQlbjos() {
        return vstQlbjos;
    }

    /**
     * 设置：AC(OD)
     */
    public void setVstAcod(Double vstAcod) {
        this.vstAcod = vstAcod;
    }

    /**
     * 获取：AC(OD)
     */
    public Double getVstAcod() {
        return vstAcod;
    }

    /**
     * 设置：AC(OS)
     */
    public void setVstAcos(Double vstAcos) {
        this.vstAcos = vstAcos;
    }

    /**
     * 获取：AC(OS)
     */
    public Double getVstAcos() {
        return vstAcos;
    }

    /**
     * 设置：降幅OD
     */
    public void setVstJfod(Double vstJfod) {
        this.vstJfod = vstJfod;
    }

    /**
     * 获取：降幅OD
     */
    public Double getVstJfod() {
        return vstJfod;
    }

    /**
     * 设置：降幅OS
     */
    public void setVstJfos(Double vstJfos) {
        this.vstJfos = vstJfos;
    }

    /**
     * 获取：降幅OS
     */
    public Double getVstJfos() {
        return vstJfos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setVstDiaod(Double vstDiaod) {
        this.vstDiaod = vstDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public Double getVstDiaod() {
        return vstDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setVstDiaos(Double vstDiaos) {
        this.vstDiaos = vstDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public Double getVstDiaos() {
        return vstDiaos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setVstBcod(Double vstBcod) {
        this.vstBcod = vstBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public Double getVstBcod() {
        return vstBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setVstBcos(Double vstBcos) {
        this.vstBcos = vstBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public Double getVstBcos() {
        return vstBcos;
    }

    /**
     * 设置：CP/CLY(OD)
     */
    public void setVstCpclyod(Double vstCpclyod) {
        this.vstCpclyod = vstCpclyod;
    }

    /**
     * 获取：CP/CLY(OD)
     */
    public Double getVstCpclyod() {
        return vstCpclyod;
    }

    /**
     * 设置：CP/CLY(OS)
     */
    public void setVstCpclyos(Double vstCpclyos) {
        this.vstCpclyos = vstCpclyos;
    }

    /**
     * 获取：CP/CLY(OS)
     */
    public Double getVstCpclyos() {
        return vstCpclyos;
    }

    /**
     * 设置：E值(OD)
     */
    public void setVstEod(Double vstEod) {
        this.vstEod = vstEod;
    }

    /**
     * 获取：E值(OD)
     */
    public Double getVstEod() {
        return vstEod;
    }

    /**
     * 设置：E值(OS)
     */
    public void setVstEos(Double vstEos) {
        this.vstEos = vstEos;
    }

    /**
     * 获取：E值(OS)
     */
    public Double getVstEos() {
        return vstEos;
    }

    /**
     * 设置：VA(OD)
     */
    public void setVstVaod(Double vstVaod) {
        this.vstVaod = vstVaod;
    }

    /**
     * 获取：VA(OD)
     */
    public Double getVstVaod() {
        return vstVaod;
    }

    /**
     * 设置：VA(OS)
     */
    public void setVstVaos(Double vstVaos) {
        this.vstVaos = vstVaos;
    }

    /**
     * 获取：VA(OS)
     */
    public Double getVstVaos() {
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
    private Double ctrBcod;
    //BC(OS)
    private Double crtBcos;
    //RZD(OD)
    private Double crtRzdod;
    //RZD(OS)
    private Double crtRzdos;
    //LZA(OD)
    private Double crtLzaod;
    //LZA(OS)
    private Double crtLzaos;
    //RZD2OD
    private Double crtRzd2od;
    //RZD2OS
    private Double crtRzd2os;
    //LZA2(OD)
    private Double crtLza2od;
    //LZA2(OS)
    private Double crtLza2os;
    //降幅(OD)
    private Double crtJfod;
    //降幅(OS)
    private Double crtJfos;
    //DIA(OD)
    private Double crtDiaod;
    //DIA(OS)
    private Double crtDiaos;
    //VA(OD)
    private Double crtVaod;
    //VA(OS)
    private Double crtVaos;
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
    public void setCtrBcod(Double ctrBcod) {
        this.ctrBcod = ctrBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public Double getCtrBcod() {
        return ctrBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setCrtBcos(Double crtBcos) {
        this.crtBcos = crtBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public Double getCrtBcos() {
        return crtBcos;
    }

    /**
     * 设置：RZD(OD)
     */
    public void setCrtRzdod(Double crtRzdod) {
        this.crtRzdod = crtRzdod;
    }

    /**
     * 获取：RZD(OD)
     */
    public Double getCrtRzdod() {
        return crtRzdod;
    }

    /**
     * 设置：RZD(OS)
     */
    public void setCrtRzdos(Double crtRzdos) {
        this.crtRzdos = crtRzdos;
    }

    /**
     * 获取：RZD(OS)
     */
    public Double getCrtRzdos() {
        return crtRzdos;
    }

    /**
     * 设置：LZA(OD)
     */
    public void setCrtLzaod(Double crtLzaod) {
        this.crtLzaod = crtLzaod;
    }

    /**
     * 获取：LZA(OD)
     */
    public Double getCrtLzaod() {
        return crtLzaod;
    }

    /**
     * 设置：LZA(OS)
     */
    public void setCrtLzaos(Double crtLzaos) {
        this.crtLzaos = crtLzaos;
    }

    /**
     * 获取：LZA(OS)
     */
    public Double getCrtLzaos() {
        return crtLzaos;
    }

    /**
     * 设置：RZD2OD
     */
    public void setCrtRzd2od(Double crtRzd2od) {
        this.crtRzd2od = crtRzd2od;
    }

    /**
     * 获取：RZD2OD
     */
    public Double getCrtRzd2od() {
        return crtRzd2od;
    }

    /**
     * 设置：RZD2OS
     */
    public void setCrtRzd2os(Double crtRzd2os) {
        this.crtRzd2os = crtRzd2os;
    }

    /**
     * 获取：RZD2OS
     */
    public Double getCrtRzd2os() {
        return crtRzd2os;
    }

    /**
     * 设置：LZA2(OD)
     */
    public void setCrtLza2od(Double crtLza2od) {
        this.crtLza2od = crtLza2od;
    }

    /**
     * 获取：LZA2(OD)
     */
    public Double getCrtLza2od() {
        return crtLza2od;
    }

    /**
     * 设置：LZA2(OS)
     */
    public void setCrtLza2os(Double crtLza2os) {
        this.crtLza2os = crtLza2os;
    }

    /**
     * 获取：LZA2(OS)
     */
    public Double getCrtLza2os() {
        return crtLza2os;
    }

    /**
     * 设置：降幅(OD)
     */
    public void setCrtJfod(Double crtJfod) {
        this.crtJfod = crtJfod;
    }

    /**
     * 获取：降幅(OD)
     */
    public Double getCrtJfod() {
        return crtJfod;
    }

    /**
     * 设置：降幅(OS)
     */
    public void setCrtJfos(Double crtJfos) {
        this.crtJfos = crtJfos;
    }

    /**
     * 获取：降幅(OS)
     */
    public Double getCrtJfos() {
        return crtJfos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setCrtDiaod(Double crtDiaod) {
        this.crtDiaod = crtDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public Double getCrtDiaod() {
        return crtDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setCrtDiaos(Double crtDiaos) {
        this.crtDiaos = crtDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public Double getCrtDiaos() {
        return crtDiaos;
    }

    /**
     * 设置：VA(OD)
     */
    public void setCrtVaod(Double crtVaod) {
        this.crtVaod = crtVaod;
    }

    /**
     * 获取：VA(OD)
     */
    public Double getCrtVaod() {
        return crtVaod;
    }

    /**
     * 设置：VA(OS)
     */
    public void setCrtVaos(Double crtVaos) {
        this.crtVaos = crtVaos;
    }

    /**
     * 获取：VA(OS)
     */
    public Double getCrtVaos() {
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

    private Long rgpId;

    //处方类型
    private String rgpPrescriptionType;
    //医生
    private String rgpDoctor;
    //验光师
    private String rgpOptometryName;
    //屈光度OD
    private Double rgpQgdod;
    //屈光度OS
    private Double rgpQgdos;
    //BC(OD)
    private Double rgpBcod;
    //BC(OS)
    private Double rgpBcos;
    //DIA(OD)
    private Double rgpDiaod;
    //DIA(OS)
    private Double rgpDiaos;
    //散光(OD)
    private Double rgpSgod;
    //散光(OS)
    private Double rgpSgos;
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
    public void setRgpQgdod(Double rgpQgdod) {
        this.rgpQgdod = rgpQgdod;
    }

    /**
     * 获取：屈光度OD
     */
    public Double getRgpQgdod() {
        return rgpQgdod;
    }

    /**
     * 设置：屈光度OS
     */
    public void setRgpQgdos(Double rgpQgdos) {
        this.rgpQgdos = rgpQgdos;
    }

    /**
     * 获取：屈光度OS
     */
    public Double getRgpQgdos() {
        return rgpQgdos;
    }

    /**
     * 设置：BC(OD)
     */
    public void setRgpBcod(Double rgpBcod) {
        this.rgpBcod = rgpBcod;
    }

    /**
     * 获取：BC(OD)
     */
    public Double getRgpBcod() {
        return rgpBcod;
    }

    /**
     * 设置：BC(OS)
     */
    public void setRgpBcos(Double rgpBcos) {
        this.rgpBcos = rgpBcos;
    }

    /**
     * 获取：BC(OS)
     */
    public Double getRgpBcos() {
        return rgpBcos;
    }

    /**
     * 设置：DIA(OD)
     */
    public void setRgpDiaod(Double rgpDiaod) {
        this.rgpDiaod = rgpDiaod;
    }

    /**
     * 获取：DIA(OD)
     */
    public Double getRgpDiaod() {
        return rgpDiaod;
    }

    /**
     * 设置：DIA(OS)
     */
    public void setRgpDiaos(Double rgpDiaos) {
        this.rgpDiaos = rgpDiaos;
    }

    /**
     * 获取：DIA(OS)
     */
    public Double getRgpDiaos() {
        return rgpDiaos;
    }

    /**
     * 设置：散光(OD)
     */
    public void setRgpSgod(Double rgpSgod) {
        this.rgpSgod = rgpSgod;
    }

    /**
     * 获取：散光(OD)
     */
    public Double getRgpSgod() {
        return rgpSgod;
    }

    /**
     * 设置：散光(OS)
     */
    public void setRgpSgos(Double rgpSgos) {
        this.rgpSgos = rgpSgos;
    }

    /**
     * 获取：散光(OS)
     */
    public Double getRgpSgos() {
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
}


