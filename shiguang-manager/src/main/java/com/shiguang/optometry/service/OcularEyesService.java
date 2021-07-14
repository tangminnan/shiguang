package com.shiguang.optometry.service;

import com.shiguang.optometry.domain.OcularEyesDO;

import java.util.List;
import java.util.Map;

public interface OcularEyesService {
    OcularEyesDO get(Long id);

    List<OcularEyesDO> list(String cardNumber);

    int count(Map<String, Object> map);

    int save(OcularEyesDO eyes);

    int update(OcularEyesDO eyes);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
