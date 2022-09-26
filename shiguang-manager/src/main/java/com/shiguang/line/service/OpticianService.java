package com.shiguang.line.service;


import com.shiguang.line.domain.OpticianDO;

import java.util.List;
import java.util.Map;

public interface OpticianService {
    OpticianDO get(Long id);

    List<OpticianDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OpticianDO line);

    int update(OpticianDO line);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int removeQueue();
}
