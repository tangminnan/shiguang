package com.shiguang.logstatus.service;

import com.shiguang.logstatus.domain.LensMeterDO;

import java.util.List;
import java.util.Map;

public interface LensMeterService {
    LensMeterDO get(Long id);

    List<LensMeterDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LensMeterDO meter);

    int update(LensMeterDO meter);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
