package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.InterestDO;

import java.util.List;
import java.util.Map;

public interface InterestService {
    InterestDO get(Long id);

    List<InterestDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(InterestDO interest);

    int update(InterestDO interest);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(InterestDO interestDO);
}
