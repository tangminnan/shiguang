package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.domain.SourceDO;

import java.util.List;
import java.util.Map;

public interface SourceService {
    SourceDO get(Long id);

    List<SourceDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SourceDO source);

    int update(SourceDO source);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(SourceDO sourceDO);

}
