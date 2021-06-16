package com.shiguang.optometry.dao;

import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ResultDiopterDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResultDiopterDao {
    ResultDiopterDO get(Long id);

    List<ResultDiopterDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ResultDiopterDO resultDiopter);

    int update(ResultDiopterDO resultDiopter);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
