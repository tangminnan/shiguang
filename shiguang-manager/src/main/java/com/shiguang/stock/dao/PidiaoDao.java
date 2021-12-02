package com.shiguang.stock.dao;

import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.stock.domain.PidiaoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 批调表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */
@Mapper
public interface PidiaoDao {

	PidiaoDO get(Long id);

	List<PidiaoDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(PidiaoDO pidiao);

	int update(PidiaoDO pidiao);

	int remove(Long id);

	int batchRemove(Long[] ids);

	//发出接收仓位
	List<PidiaoDO> outPosition(Map<String, Object> map);

	//发出接收部门
	List<PidiaoDO> indepartment(Map<String, Object> map);

	List<PidiaoDO> selectPidiao(Map<String, Object> map);

	PidiaoDO getpidiao(String pidiaoNumber);

	List<PidiaoDO> getpidiaoList(Map<String, Object> map);
	//确认收货
	int updateStatus(PidiaoDO pidiaoDO);


	//退回查询
	List<PidiaoDO> returnList(Map<String, Object> map);
	//退回修改状态
	int updatereturnzt(PidiaoDO pidiaoDO);
	//根据采购订单号查询库存有没有
	List<PidiaoDO> pidiaodan(Map<String,Object>map);

	int countall(Map<String, Object> map);

	List<PidiaoDO> getCode(Map<String, Object> map);

	//是否有这个单号
	List<PidiaoDO> haveOrderNum(Map<String, Object> map);
}
