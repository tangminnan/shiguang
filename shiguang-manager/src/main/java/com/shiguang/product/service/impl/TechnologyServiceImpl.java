package com.shiguang.product.service.impl;

import com.shiguang.product.dao.TechnologyDao;
import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public TechnologyDO get(Long technologyId) {
        return technologyDao.get(technologyId);
    }

    @Override
    public List<TechnologyDO> list(Map<String, Object> map) {
        return technologyDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return technologyDao.count(map);
    }

    @Override
    public int save(TechnologyDO technology) {
        return technologyDao.save(technology);
    }

    @Override
    public int update(TechnologyDO technology) {
        return technologyDao.update(technology);
    }

    @Override
    public int remove(Long technologyId) {
        return technologyDao.remove(technologyId);
    }

    @Override
    public int batchRemove(Long[] technologyIds) {
        return technologyDao.batchRemove(technologyIds);
    }
    //删除修改状态


    @Override
    public int updateState(TechnologyDO technologyDO) {
        return technologyDao.updateState(technologyDO);
    }
}
