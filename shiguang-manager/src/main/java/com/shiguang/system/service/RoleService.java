package com.shiguang.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shiguang.system.domain.RoleDO;

@Service
public interface RoleService {

	RoleDO get(Long id);

	List<RoleDO> list(Map<String,Object> maps);

	int save(RoleDO role);

	int update(RoleDO role);
	
	int updateStatus(RoleDO role);

	int remove(Long id);

	List<RoleDO> list(Long userId,Map<String,Object> map);
	
	List<RoleDO> listbyid(Long userId,Map<String,Object> map);

	int batchremove(Long[] ids);
}
