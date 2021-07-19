package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.SjxlDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SjxlDO;
import com.shiguang.jiancha.service.SjxlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SjxlServiceImpl implements SjxlService {
    @Autowired
    private SjxlDao sjxlDao;

    @Override
    public SjxlDO get(Long sjxlId) {
        return sjxlDao.get(sjxlId);
    }

    @Override
    public List<SjxlDO> list(Map<String, Object> map) {
        return sjxlDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return sjxlDao.count(map);
    }

    @Override
    public int save(SjxlDO sjxl) {
        return sjxlDao.save(sjxl);
    }

    @Override
    public int saveSjxl(ResultDO result) {
        return sjxlDao.saveSjxl(result);
    }

    @Override
    public int update(SjxlDO sjxl) {
        return sjxlDao.update(sjxl);
    }

    @Override
    public int remove(Long sjxlId) {
        return sjxlDao.remove(sjxlId);
    }

    @Override
    public int batchRemove(Long[] sjxlIds) {
        return sjxlDao.batchRemove(sjxlIds);
    }

}
