package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.PersonSortDO;

import java.util.List;
import java.util.Map;

public interface PersonSortService {
    PersonSortDO get(Long id);

    List<PersonSortDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PersonSortDO sort);

    int update(PersonSortDO sort);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
