package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.VocationDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("VocationDao")
public interface VocationDao {
    VocationDO get(Long id);

    List<VocationDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(VocationDO vocation);

    int update(VocationDO vocation);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
