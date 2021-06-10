package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.InvoiceDao;
import com.shiguang.mfrs.domain.InvoiceDO;
import com.shiguang.mfrs.service.InvoiceService;



@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao invoiceDao;
	
	@Override
	public InvoiceDO get(Integer invoiceid){
		return invoiceDao.get(invoiceid);
	}
	
	@Override
	public List<InvoiceDO> list(Map<String, Object> map){
		return invoiceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return invoiceDao.count(map);
	}
	
	@Override
	public int save(InvoiceDO invoice){
		return invoiceDao.save(invoice);
	}
	
	@Override
	public int update(InvoiceDO invoice){
		return invoiceDao.update(invoice);
	}
	
	@Override
	public int remove(Integer invoiceid){
		return invoiceDao.remove(invoiceid);
	}
	
	@Override
	public int batchRemove(Integer[] invoiceids){
		return invoiceDao.batchRemove(invoiceids);
	}
	
}
