package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("DepartmentDao")
public interface DepartmentDao {
    DepartmentDO get(Long id);

    List<DepartmentDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(DepartmentDO department);

    int update(DepartmentDO department);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
