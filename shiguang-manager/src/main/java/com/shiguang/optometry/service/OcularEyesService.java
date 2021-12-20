package com.shiguang.optometry.service;

import com.shiguang.member.domain.MemberDO;
import com.shiguang.optometry.domain.OcularEyesDO;

import java.util.List;
import java.util.Map;

public interface OcularEyesService {
    OcularEyesDO get(Long id);

    List<OcularEyesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OcularEyesDO eyes);

    int update(OcularEyesDO eyes);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<MemberDO> findOptoEyesList(Map<String,Object> map);

    int findOptoEyesCount(Map<String,Object> map);
}
