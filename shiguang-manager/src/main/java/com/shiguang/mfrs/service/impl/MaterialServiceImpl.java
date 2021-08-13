package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.MaterialDao;
import com.shiguang.mfrs.domain.MaterialDO;
import com.shiguang.mfrs.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialDao materialDao;

    @Override
    public MaterialDO get(Integer materialid) {
        return materialDao.get(materialid);
    }

    @Override
    public List<MaterialDO> list(Map<String, Object> map) {
        return materialDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return materialDao.count(map);
    }

    @Override
    public int save(MaterialDO material) {
        return materialDao.save(material);
    }

    @Override
    public int update(MaterialDO material) {
        return materialDao.update(material);
    }

    @Override
    public int remove(Integer materialid) {
        return materialDao.remove(materialid);
    }

    @Override
    public int batchRemove(Integer[] materialids) {
        return materialDao.batchRemove(materialids);
    }
    //删除修改状态

    @Override
    public int updateState(MaterialDO materialDO) {
        return materialDao.updateState(materialDO);
    }
}
