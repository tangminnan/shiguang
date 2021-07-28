package com.shiguang.packageManager.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.packageManager.domain.PackageDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 套餐表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-13 13:48:48
 */
@Mapper
public interface PackageDao {

	PackageDO get(Long id);
	
	List<PackageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	int save(PackageDO packages);
	
	int update(PackageDO packages);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
