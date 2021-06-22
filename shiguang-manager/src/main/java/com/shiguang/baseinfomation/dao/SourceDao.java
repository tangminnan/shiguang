package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.SourceDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("SourceDao")
public interface SourceDao {
    SourceDO get(Long id);

    List<SourceDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(SourceDO source);

    int update(SourceDO source);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(SourceDO sourceDO);
}
