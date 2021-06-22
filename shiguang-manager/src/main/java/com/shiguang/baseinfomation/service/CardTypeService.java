package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.CardTypeDO;

import java.util.List;
import java.util.Map;

public interface CardTypeService {
    CardTypeDO get(Long id);

    List<CardTypeDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CardTypeDO type);

    int update(CardTypeDO type);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(CardTypeDO cardTypeDO);
}
