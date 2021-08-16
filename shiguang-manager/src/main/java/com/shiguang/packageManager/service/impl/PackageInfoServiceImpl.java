package com.shiguang.packageManager.service.impl;

import com.shiguang.packageManager.dao.PackageInfoDao;
import com.shiguang.packageManager.domain.PackageInfoDO;
import com.shiguang.packageManager.service.PackageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PackageInfoServiceImpl implements PackageInfoService {

    @Autowired
    private PackageInfoDao infoDao;

    @Override
    public PackageInfoDO get(Long id){
        return infoDao.get(id);
    }

    @Override
    public List<PackageInfoDO> list(Map<String, Object> map){
        return infoDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return infoDao.count(map);
    }

    @Override
    public int save(PackageInfoDO info){
        return infoDao.save(info);
    }

    @Override
    public int update(PackageInfoDO info){
        return infoDao.update(info);
    }

    @Override
    public int remove(Long id){
        return infoDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return infoDao.batchRemove(ids);
    }

    @Override
    public PackageInfoDO findSelectPackId(Long packageId){
        return infoDao.findSelectPackId(packageId);
    }
}
