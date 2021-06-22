package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.PersonSortDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("PersonSortDao")
public interface PersonSortDao {
    PersonSortDO get(Long id);

    List<PersonSortDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(PersonSortDO sort);

    int update(PersonSortDO sort);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(PersonSortDO personSortDO);
}
