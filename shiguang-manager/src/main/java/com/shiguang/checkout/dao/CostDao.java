package com.shiguang.checkout.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.checkout.domain.CostDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 费用提交
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-16 10:48:13
 */
@Mapper
@Repository("CostDao")
public interface CostDao {

	CostDO get(Long id);

	List<CostDO> getMemberNum(String cardNumber);
	
	List<CostDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	List<CostDO> getSaleNumber(String saleNumber);

	List<CostDO> costlist(Map<String, Object> map);

	int costcount(Map<String, Object> map);
	
	int save(CostDO cost);
	
	int update(CostDO cost);

	int updateMember(CostDO costDO);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	CostDO getSaleNumByMemNum(String cardMember);
}
