package com.shiguang.storeSales.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.storeSales.domain.InfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在途信息
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-05-19 16:09:53
 */
@Mapper
public interface InfoDao {

	InfoDO get(Long id);
	
	List<InfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InfoDO info);
	
	int update(InfoDO info);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
