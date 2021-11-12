package com.shiguang.jiancha.service.impl;

import com.shiguang.jiancha.dao.VstDao;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.VstDO;
import com.shiguang.jiancha.service.VstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class VstServiceImpl implements VstService {
    @Autowired
    private VstDao vstDao;

    @Override
    public VstDO get(Long vstId) {
        return vstDao.get(vstId);
    }

    @Override
    public List<VstDO> list(Map<String, Object> map) {
        return vstDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return vstDao.count(map);
    }

    @Override
    public int save(VstDO vst) {
        return vstDao.save(vst);
    }

    @Override
    public int saveVst(ResultDO result) {
        return vstDao.saveVst(result);
    }

    @Override
    public List<ResultDO> haveYanguangNum(Map<String, Object> map) {
        return vstDao.haveYanguangNum(map);
    }

    @Override
    public int update(ResultDO result) {
        return vstDao.update(result);
    }

    @Override
    public int remove(Long vstId) {
        return vstDao.remove(vstId);
    }

    @Override
    public int upremove(VstDO vstDO) {
        return vstDao.upremove(vstDO);
    }

    @Override
    public int updatevst(VstDO vstDO) {
        return vstDao.updatevst(vstDO);
    }

    @Override
    public int batchRemove(Long[] vstIds) {
        return vstDao.batchRemove(vstIds);
    }

    @Override
    public VstDO chufangall(String ptometryNumber, String status) {
        return vstDao.chufangall(ptometryNumber,status);
    }
}