package com.shiguang.report.dao;

import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.storeSales.domain.SalesDO;

import java.util.List;
import java.util.Map;

public interface SaleReportDao {
    List<SalesDO> findSaleReport(Map<String, Object> map);

    int findSaleReportCount(Map<String, Object> map);

    SaleReportDO findCostList(Map<String,Object> map);
}
