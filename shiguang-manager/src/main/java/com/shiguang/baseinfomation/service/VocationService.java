package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.VocationDO;

import java.util.List;
import java.util.Map;

public interface VocationService {
    VocationDO get(Long id);

    List<VocationDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(VocationDO vocation);

    int update(VocationDO vocation);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
