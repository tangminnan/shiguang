package com.shiguang.logstatus.service.impl;

import com.shiguang.common.service.LogService;
import com.shiguang.logstatus.dao.LogStatusDao;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.SalesDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class LogStatusServiceImpl implements LogStatusService {
    @Autowired
    private LogStatusDao statusDao;

    @Override
    public LogStatusDO get(Long id){
        return statusDao.get(id);
    }

    @Override
    public List<LogStatusDO> list(Map<String, Object> map){
        return statusDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return statusDao.count(map);
    }

    @Override
    public int save(LogStatusDO status){
        return statusDao.save(status);
    }

    @Override
    public int update(LogStatusDO status){
        return statusDao.update(status);
    }

    @Override
    public int remove(Long id){
        return statusDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return statusDao.batchRemove(ids);
    }

    @Override
    public List<SalesDO> findSaleAll(Map<String, Object> map){
        return statusDao.findSaleAll(map);
    }

    @Override
    public int findSaleCount(Map<String, Object> map){
        return statusDao.findSaleCount(map);
    }

    @Override
    public int editFaliao(LogStatusDO logStatusDO){
        return statusDao.editFaliao(logStatusDO);
    }

    @Override
    public SalesDO getLogSaleNumber(String saleNumber){
        return statusDao.getLogSaleNumber(saleNumber);
    }

    @Override
    public int editJianyan(LogStatusDO status){
        return statusDao.editJianyan(status);
    }

    @Override
    public List<SalesDO> findSalePeijingAll(Map<String, Object> map){
        return statusDao.findSalePeijingAll(map);
    }

    @Override
    public int findSalePeijingCount(Map<String, Object> map){
        return statusDao.findSalePeijingCount(map);
    }

    @Override
    public int saveRecord(WorkRecoedDO workRecoedDO){
        return statusDao.saveRecord(workRecoedDO);
    }

    @Override
    public LogStatusDO getLogStatusBySaleNum(String saleNumber){
        return statusDao.getLogStatusBySaleNum(saleNumber);
    }

}
