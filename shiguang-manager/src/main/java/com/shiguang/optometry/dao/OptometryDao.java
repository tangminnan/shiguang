package com.shiguang.optometry.dao;

import com.shiguang.optometry.domain.OptometryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("OptometryDao")
public interface OptometryDao {
    OptometryDO get(Long id);

    List<OptometryDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(OptometryDO optometry);

    int update(OptometryDO optometry);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
