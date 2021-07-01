package com.shiguang.optometry.service;

import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;

import java.util.List;
import java.util.Map;

public interface OptometryService {
    OptometryDO get(Long id);

    List<OptometryDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OptometryDO optometry);

    int update(OptometryDO optometry);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<OptometryDO> optoList(Map<String, Object> map);

    List<ProcessAskDO> processlist(Map<String,Object> map);
}
