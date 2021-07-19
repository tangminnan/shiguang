package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.InvoiceDO;

import java.util.List;
import java.util.Map;

/**
 * 开票状态表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
public interface InvoiceService {

    InvoiceDO get(Integer invoiceid);

    List<InvoiceDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(InvoiceDO invoice);

    int update(InvoiceDO invoice);

    int remove(Integer invoiceid);

    int batchRemove(Integer[] invoiceids);
}
