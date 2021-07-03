package com.shiguang.optometry.service.impl;

import com.shiguang.optometry.dao.OptometryDao;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OptometryServiceImpl implements OptometryService {
    @Autowired
    private OptometryDao optometryDao;

    @Override
    public OptometryDO get(Long id) {
        return optometryDao.get(id);
    }

    @Override
    public List<OptometryDO> list(Map<String, Object> map) {
        return optometryDao.list(map);
    }

    @Override
    public List<OptometryDO> optoList(Map<String, Object> map) {
        return optometryDao.optoFrontList(map);
    }

    //散瞳前
    @Override
    public List<OptometryDO> optoFrontList(Map<String, Object> map) {
        return optometryDao.optoFrontList(map);
    }

    //散瞳后
    @Override
    public List<OptometryDO> optoAfterList(Map<String, Object> map) {
        return optometryDao.optoAfterList(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return optometryDao.count(map);
    }

    @Override
    public int save(OptometryDO optometry) {
        return optometryDao.save(optometry);
    }

    @Override
    public int update(OptometryDO optometry) {
        return optometryDao.update(optometry);
    }

    @Override
    public int remove(Long id) {
        return optometryDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return optometryDao.batchRemove(ids);
    }

    @Override
    public List<ProcessAskDO> processlist(Map<String, Object> map) {
        return optometryDao.processlist(map);
    }
}
