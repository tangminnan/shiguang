package com.shiguang.optometry.service.impl;

import com.shiguang.member.domain.MemberDO;
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
        return optometryDao.optoList(map);
    }

    //散瞳前

    @Override
    public List<OptometryDO> optoFrontList(String cardNumber) {
        return optometryDao.optoFrontList(cardNumber);
    }

    //散瞳后
    @Override
    public List<OptometryDO> optoAfterList(String cardNumber) {
        return optometryDao.optoAfterList(cardNumber);
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

    @Override
    public List<MemberDO> findOptoList(Map<String, Object> map) {return optometryDao.findOptoList(map);}

    @Override
    public int findOptoCount(Map<String, Object> map) {
        return optometryDao.findOptoCount(map);
    }
}
