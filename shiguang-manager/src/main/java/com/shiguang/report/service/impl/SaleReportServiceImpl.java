package com.shiguang.report.service.impl;

import com.shiguang.report.dao.SaleReportDao;
import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.report.service.SaleReportService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.storeSales.domain.SalesDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SaleReportServiceImpl implements SaleReportService {
    @Autowired
    private SaleReportDao saleReportDao;
    @Override
    public List<SalesDO> findSaleReport(Map<String, Object> map){
        return saleReportDao.findSaleReport(map);
    }

    @Override
    public int findSaleReportCount(Map<String, Object> map){
        return saleReportDao.findSaleReportCount(map);
    }

    @Override
    public SaleReportDO findCostList(Map<String,Object> map){
        return saleReportDao.findCostList(map);
    }

    @Override
    public List<SettlementDO> findSaleReportForms(Map<String, Object> map){
        return saleReportDao.findSaleReportForms(map);
    }

    @Override
    public int findSaleReportFormsCount(Map<String, Object> map){
        return saleReportDao.findSaleReportFormsCount(map);
    }

    @Override
    public List<SalesDO> findGoodsList(Map<String, Object> map){
        return saleReportDao.findGoodsList(map);
    }

    @Override
    public List<SalesDO> findSaleNameList(Map<String, Object> map){
        return saleReportDao.findSaleNameList(map);
    }
}
