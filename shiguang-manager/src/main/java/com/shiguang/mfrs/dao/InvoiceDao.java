package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.InvoiceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 开票状态表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
@Mapper
public interface InvoiceDao {

    InvoiceDO get(Integer invoiceid);

    List<InvoiceDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(InvoiceDO invoice);

    int update(InvoiceDO invoice);

    int remove(Integer invoiceid);

    int batchRemove(Integer[] invoiceids);
}
