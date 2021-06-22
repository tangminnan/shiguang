package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.ReadDO;
import com.shiguang.baseinfomation.domain.SourceDO;

import java.util.List;
import java.util.Map;

public interface ReadService {
    ReadDO get(Long id);

    List<ReadDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ReadDO read);

    int update(ReadDO read);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(ReadDO readDO);
}
