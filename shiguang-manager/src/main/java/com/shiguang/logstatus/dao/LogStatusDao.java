package com.shiguang.logstatus.dao;

import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
@Mapper
public interface LogStatusDao {
    LogStatusDO get(Long id);

    List<LogStatusDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(LogStatusDO status);

    int update(LogStatusDO status);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<SalesDO> findSaleAll(Map<String,Object> map);

    int findSaleCount(Map<String,Object> map);

    int editFaliao(LogStatusDO logStatusDO);

    SalesDO getLogSaleNumber(String saleNumber);

    int editJianyan(LogStatusDO logStatusDO);

    List<SalesDO> findSalePeijingAll(Map<String,Object> map);

    int findSalePeijingCount(Map<String,Object> map);
}
