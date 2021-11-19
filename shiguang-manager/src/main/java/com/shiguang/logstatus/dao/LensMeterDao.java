package com.shiguang.logstatus.dao;

import com.shiguang.logstatus.domain.JDJInfoDO;
import com.shiguang.logstatus.domain.LensMeterDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LensMeterDao {
    LensMeterDO get(Long id);

    List<LensMeterDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(LensMeterDO meter);

    int update(LensMeterDO meter);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int saveJdj(JDJInfoDO jdjInfoDO);

    List<JDJInfoDO> jdjList(Map<String,Object> map);

    int deleteJdj(Long id);
}
