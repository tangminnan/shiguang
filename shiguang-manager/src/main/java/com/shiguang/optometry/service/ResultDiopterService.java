package com.shiguang.optometry.service;

import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ResultDiopterDO;

import java.util.List;
import java.util.Map;

public interface ResultDiopterService {
    ResultDiopterDO get(Long id);

    List<ResultDiopterDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ResultDiopterDO resultDiopter);

    int update(ResultDiopterDO resultDiopter);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
