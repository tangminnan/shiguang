package com.shiguang.jiekou.dao;


import com.shiguang.jiekou.domain.SettlementJKDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 结款管理
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
@Mapper
@Repository("SettlementJKDao")
public interface SettlementJKDao {
	
	List<SettlementJKDO> list(Map<String, Object> map);

}
