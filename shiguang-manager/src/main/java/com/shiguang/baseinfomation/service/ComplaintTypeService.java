package com.shiguang.baseinfomation.service;

import com.shiguang.baseinfomation.domain.ComplaintTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;

import java.util.List;
import java.util.Map;

public interface ComplaintTypeService {
    ComplaintTypeDO get(Long id);

    List<ComplaintTypeDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ComplaintTypeDO type);

    int update(ComplaintTypeDO type);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int updateStatus(ComplaintTypeDO complaintTypeDO);
}
