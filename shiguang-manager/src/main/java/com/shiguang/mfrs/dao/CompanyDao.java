package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.CompanyDO;

import java.util.List;
import java.util.Map;

import com.shiguang.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公司维护表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-16 09:59:28
 */
@Mapper
public interface CompanyDao {

	CompanyDO get(Integer id);
	
	List<CompanyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CompanyDO company);
	
	int update(CompanyDO company);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	//删除修改状态
	int updateState(CompanyDO companyDO);

	int newOlds(UserDO userDO);
}
