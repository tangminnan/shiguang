package com.shiguang.report.service;

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

    int findSaleReportFormsCount(Map<String, Object> map);

    List<SalesDO> findGoodsList(Map<String,Object> map);
}
