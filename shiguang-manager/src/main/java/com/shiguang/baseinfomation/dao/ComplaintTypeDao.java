package com.shiguang.baseinfomation.dao;

import com.shiguang.baseinfomation.domain.ComplaintTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ComplaintTypeDao {
    ComplaintTypeDO get(Long id);

    List<ComplaintTypeDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(ComplaintTypeDO type);

    int update(ComplaintTypeDO type);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(ComplaintTypeDO complaintTypeDO);
}
