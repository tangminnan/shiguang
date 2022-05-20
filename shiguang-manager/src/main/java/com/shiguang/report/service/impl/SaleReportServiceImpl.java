package com.shiguang.report.service.impl;

import com.shiguang.product.domain.*;
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
    public List<SalesDO> findSaleReport(Map<String, Object> map) {
        return saleReportDao.findSaleReport(map);
    }

    @Override
    public int findSaleReportCount(Map<String, Object> map) {
        return saleReportDao.findSaleReportCount(map);
    }

    @Override
    public SaleReportDO findCostList(Map<String, Object> map) {
        return saleReportDao.findCostList(map);
    }

    @Override
    public List<SettlementDO> findSaleReportForms(Map<String, Object> map) {
        return saleReportDao.findSaleReportForms(map);
    }

    @Override
    public List<SettlementDO> drawckMoney(Map<String, Object> map) {
        return saleReportDao.drawckMoney(map);
    }

    @Override
    public int findSaleReportFormsCount(Map<String, Object> map) {
        return saleReportDao.findSaleReportFormsCount(map);
    }

    @Override
    public List<SalesDO> findGoodsList(Map<String, Object> map) {
        return saleReportDao.findGoodsList(map);
    }

    @Override
    public List<SalesDO> findSaleNameList(Map<String, Object> map) {
        return saleReportDao.findSaleNameList(map);
    }

    @Override
    public List<SalesDO> findSaleReportDetailForms(Map<String, Object> map) {
        return saleReportDao.findSaleReportDetailForms(map);
    }

    @Override
    public List<SettlementDO> findSaleNameSettleList(Map<String, Object> map) {
        return saleReportDao.findSaleNameSettleList(map);
    }

    @Override
    public List<SalesDO> findYanguangPeople(Map<String, Object> map) {
        return saleReportDao.findYanguangPeople(map);
    }

    @Override
    public int findYanguangCount(Map<String, Object> map) {
        return saleReportDao.findYanguangCount(map);
    }

    @Override
    public int findUseCount(Map<String, Object> map) {
        return saleReportDao.findUseCount(map);
    }

    @Override
    public int findamountMoney(Map<String, Object> map) {
        return saleReportDao.findamountMoney(map);
    }


    @Override
    public List<SalesDO> findGoods(Map<String, Object> map) {
        return saleReportDao.findGoods(map);
    }

    @Override
    public ProducaDO findJj(String goodNum) {
        return saleReportDao.findJj(goodNum);
    }

    @Override
    public PartsDO findpj(String goodNum) {
        return saleReportDao.findpj(goodNum);
    }

    @Override
    public JpcpDO findjp(String goodNum) {
        return saleReportDao.findjp(goodNum);
    }

    @Override
    public JpdzDO findjpdz(String goodNum) {
        return saleReportDao.findjpdz(goodNum);
    }

    @Override
    public YxcpDO findyx(String goodNum) {
        return saleReportDao.findyx(goodNum);
    }

    @Override
    public YxdzDO findyxdz(String goodNum) {
        return saleReportDao.findyxdz(goodNum);
    }

    @Override
    public HlyDO findhly(String goodNum) {
        return saleReportDao.findhly(goodNum);
    }

    @Override
    public TyjDO findtyj(String goodNum) {
        return saleReportDao.findtyj(goodNum);
    }

    @Override
    public OldlensDO findlhj(String goodNum) {
        return saleReportDao.findlhj(goodNum);
    }

    @Override
    public HcDO findhc(String goodNum) {
        return saleReportDao.findhc(goodNum);
    }

    @Override
    public ShiguangDO findsg(String goodNum) {
        return saleReportDao.findsg(goodNum);
    }

    @Override
    public List<SalesDO> ygDoctorUse(Map<String, Object> map) {
        return saleReportDao.ygDoctorUse(map);
    }

    @Override
    public List<SalesDO> ygDoctor(Map<String, Object> map) {
        return saleReportDao.ygDoctor(map);
    }


    @Override
    public List<SalesDO> findDoctorPeople(Map<String, Object> map) {
        return saleReportDao.findDoctorPeople(map);
    }

    @Override
    public int findCfCount(Map<String, Object> map) {
        return saleReportDao.findCfCount(map);
    }

    @Override
    public int findCfUseCount(Map<String, Object> map) {
        return saleReportDao.findCfUseCount(map);
    }

    @Override
    public int findCfamountMoney(Map<String, Object> map) {
        return saleReportDao.findCfamountMoney(map);
    }

    @Override
    public List<SalesDO> findDoctorGoods(Map<String, Object> map) {
        return saleReportDao.findDoctorGoods(map);
    }



    @Override
    public List<SalesDO> Yg(Map<String, Object> map) {
        return saleReportDao.Yg(map);
    }


    @Override
    public List<SalesDO> YgUse(Map<String, Object> map) {
        return saleReportDao.YgUse(map);
    }
}
