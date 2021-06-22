package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("CardTypeDao")
public interface CardTypeDao {
    CardTypeDO get(Long id);

    List<CardTypeDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(CardTypeDO type);

    int update(CardTypeDO type);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(CardTypeDO cardTypeDO);
}
