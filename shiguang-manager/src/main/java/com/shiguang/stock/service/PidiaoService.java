package com.shiguang.stock.service;

import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.StockDO;

import java.util.List;
import java.util.Map;

/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */
public interface PidiaoService {
	
	PidiaoDO get(Long id);


	List<PidiaoDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(PidiaoDO pidiao);
	
	int update(PidiaoDO pidiao);
	
	int remove(Long id);

	int batchRemove(Long[] ids);


	PidiaoDO getOut(Long id);
	PidiaoDO getIn(Long id);

	List<PidiaoDO> outPosition(Map<String, Object> map);
	List<PidiaoDO> indepartment(Map<String, Object> map);

	List<PidiaoDO> selectPidiao(Map<String, Object> map);

	PidiaoDO getpidiao(String pidiaoNumber);

	List<PidiaoDO> getpidiaoList(Map<String, Object> map);

	int updateStatus(PidiaoDO pidiaoDO);

	List<PidiaoDO> returnList(Map<String, Object> map);
	int updatereturnzt(PidiaoDO pidiaoDO);
	List<PidiaoDO> pidiaodan(Map<String,Object>map);
	int countall(Map<String, Object> map);

	List<PidiaoDO> getCode(Map<String, Object> map);

	List<PidiaoDO> haveOrderNum(Map<String, Object> map);


	List<PidiaoDO> jingjiaSummary(Map<String, Object> map);
	List<PidiaoDO> peijianSummary(Map<String, Object> map);
	List<PidiaoDO> jpcpSummary(Map<String, Object> map);
	List<PidiaoDO> jpdzSummary(Map<String, Object> map);
	List<PidiaoDO> yxcpSummary(Map<String, Object> map);
	List<PidiaoDO> yxdzSummary(Map<String, Object> map);
	List<PidiaoDO> hlySummary(Map<String, Object> map);
	List<PidiaoDO> tyjSummary(Map<String, Object> map);
	List<PidiaoDO> lhjSummary(Map<String, Object> map);
	List<PidiaoDO> hcSummary(Map<String, Object> map);
	List<PidiaoDO> sgSummary(Map<String, Object> map);
}
