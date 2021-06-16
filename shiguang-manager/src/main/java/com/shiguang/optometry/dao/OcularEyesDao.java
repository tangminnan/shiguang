package com.shiguang.optometry.dao;

import com.shiguang.optometry.domain.OcularEyesDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("OcularEyesDao")
public interface OcularEyesDao {
    OcularEyesDO get(Long id);

    List<OcularEyesDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(OcularEyesDO eyes);

    int update(OcularEyesDO eyes);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
