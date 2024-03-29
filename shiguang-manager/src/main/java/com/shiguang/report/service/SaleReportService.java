package com.shiguang.report.service;

import com.shiguang.member.domain.MemberDO;
import com.shiguang.product.domain.*;
import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.storeSales.domain.SalesDO;

import java.util.List;
import java.util.Map;

public interface SaleReportService {
    List<SalesDO> findSaleReport(Map<String, Object> map);

    int findSaleReportCount(Map<String, Object> map);

    SaleReportDO findCostList(Map<String,Object> map);

    List<SettlementDO> findSaleReportForms(Map<String,Object> map);

    List<SettlementDO> drawckMoney(Map<String,Object> map);

    int findSaleReportFormsCount(Map<String, Object> map);

    List<SalesDO> findGoodsList(Map<String,Object> map);

    List<SalesDO> findSaleNameList(Map<String,Object> map);

    List<SalesDO> findSaleReportDetailForms(Map<String,Object> map);

    List<SettlementDO> findSaleNameSettleList(Map<String,Object> map);

    List<SalesDO> findSaleList(Map<String,Object> map);

    List<SalesDO> findYanguangPeople(Map<String,Object> map);
    int findYanguangCount(Map<String,Object> map);
    int findUseCount(Map<String,Object> map);
    int findamountMoney(Map<String,Object> map);

    List<SalesDO> findGoods(Map<String,Object> map);

    ProducaDO findJj(String goodNum);
    PartsDO findpj(String goodNum);
    JpcpDO findjp(String goodNum);
    JpdzDO findjpdz(String goodNum);
    YxcpDO findyx(String goodNum);
    YxdzDO findyxdz(String goodNum);
    HlyDO findhly(String goodNum);
    TyjDO findtyj(String goodNum);
    OldlensDO findlhj(String goodNum);
    HcDO findhc(String goodNum);
    ShiguangDO findsg(String goodNum);



    List<SalesDO> ygDoctorUse(Map<String,Object> map);
    List<SalesDO> ygDoctor(Map<String,Object> map);





    List<SalesDO> findDoctorPeople(Map<String,Object> map);
    int findCfCount(Map<String,Object> map);
    int findCfUseCount(Map<String,Object> map);
    int findCfamountMoney(Map<String,Object> map);
    List<SalesDO> findDoctorGoods(Map<String,Object> map);



    List<SalesDO> Yg(Map<String,Object> map);

    List<SalesDO> YgUse(Map<String,Object> map);

    List<Map> vistList(Map<String,Object> map);

    List<Map> followList(Map<String,Object> map);

    List<MemberDO> visitDetailList(Map<String,Object> map);

    List<MemberDO> followDetailList(Map<String,Object> map);

}
