package com.shiguang.system.dao;

import java.util.List;
import java.util.Map;

import com.shiguang.system.domain.RoleTypeDO;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface RoleTypeDao {
    RoleTypeDO get(Long id);

    RoleTypeDO getNum(Long roleNum);

    List<RoleTypeDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(RoleTypeDO type);

    int update(RoleTypeDO type);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
