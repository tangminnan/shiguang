package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.ReadDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("ReadDao")
public interface ReadDao {
    ReadDO get(Long id);

    List<ReadDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(ReadDO read);

    int update(ReadDO read);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
