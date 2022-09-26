package com.shiguang.line.dao;

import com.shiguang.line.domain.OpticianDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OpticianDao {
    OpticianDO get(Long id);

    List<OpticianDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OpticianDO line);

    int update(OpticianDO line);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int removeQueue();
}
