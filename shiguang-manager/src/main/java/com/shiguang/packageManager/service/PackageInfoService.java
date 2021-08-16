package com.shiguang.packageManager.service;

import com.shiguang.packageManager.domain.PackageInfoDO;

import java.util.List;
import java.util.Map;

public interface PackageInfoService {
    PackageInfoDO get(Long id);

    List<PackageInfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PackageInfoDO info);

    int update(PackageInfoDO info);

    int remove(Long id);

    int batchRemove(Long[] ids);

    PackageInfoDO findSelectPackId(Long packageId);
}
