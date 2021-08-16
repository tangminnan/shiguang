package com.shiguang.packageManager.dao;

import com.shiguang.packageManager.domain.PackageInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PackageInfoDao {
    PackageInfoDO get(Long id);

    List<PackageInfoDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(PackageInfoDO info);

    int update(PackageInfoDO info);

    int remove(Long id);

    int batchRemove(Long[] ids);

    PackageInfoDO findSelectPackId(String packageId);
}
