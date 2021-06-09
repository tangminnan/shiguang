package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.InterestDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("InterestDao")
public interface InterestDao {
    InterestDO get(Long id);

    List<InterestDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(InterestDO interest);

    int update(InterestDO interest);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
