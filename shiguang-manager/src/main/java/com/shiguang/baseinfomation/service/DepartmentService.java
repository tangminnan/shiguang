package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.DepartmentDO;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    DepartmentDO get(Long id);

    List<DepartmentDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DepartmentDO department);

    int update(DepartmentDO department);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(DepartmentDO departmentDO);
}
