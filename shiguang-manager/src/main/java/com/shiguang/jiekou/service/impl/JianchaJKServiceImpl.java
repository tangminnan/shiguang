package com.shiguang.jiekou.service.impl;

import com.shiguang.jiekou.dao.JianchaJKDao;
import com.shiguang.jiekou.domain.*;
import com.shiguang.jiekou.service.JianchaJKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class JianchaJKServiceImpl implements JianchaJKService {
    @Autowired
    private JianchaJKDao jianchaJKDao;

    @Override
    public List<TryresultJKDO> yanguangListShuju(Map<String, Object> map) {
        return jianchaJKDao.yanguangListShuju(map);
    }

    @Override
    public List<KjyyJKDO> KjyyListShuju(Map<String, Object> map1) {
        return jianchaJKDao.KjyyListShuju(map1);
    }

    @Override
    public List<KjjyJKDO> KjjyListShuju(Map<String, Object> map1) {
        return jianchaJKDao.KjjyListShuju(map1);

    }

    @Override
    public List<SgjjJKDO> SgjjListShuju(Map<String, Object> map1) {
        return jianchaJKDao.SgjjListShuju(map1);
    }

    @Override
    public List<RxjmjcjJKDO> RxjmjcjListShuju(Map<String, Object> map1) {
        return jianchaJKDao.RxjmjcjListShuju(map1);
    }

    @Override
    public List<ZyJKDO> ZyListShuju(Map<String, Object> map1) {
        return jianchaJKDao.ZyListShuju(map1);
    }

    @Override
    public List<SjxlJKDO> SjxlListShuju(Map<String, Object> map1) {
        return jianchaJKDao.SjxlListShuju(map1);
    }

    @Override
    public List<VstJKDO> VstListShuju(Map<String, Object> map1) {
        return jianchaJKDao.VstListShuju(map1);
    }

    @Override
    public List<CrtJKDO> CrtListShuju(Map<String, Object> map1) {
        return jianchaJKDao.CrtListShuju(map1);
    }

    @Override
    public List<RgpJKDO> RgpListShuju(Map<String, Object> map1) {
        return jianchaJKDao.RgpListShuju(map1);
    }

    @Override
    public int lineJKSave(YgLineJKDO ygLineJKDO) {
        return jianchaJKDao.lineJKSave(ygLineJKDO);
    }

    @Override
    public List<lastResultJKDO> getYanguangLast(String cardNumber) {
        return jianchaJKDao.getYanguangLast(cardNumber);
    }

    @Override
    public int lineJKSaveOld(YgLineJKDO ygLineJKDO) {
        return jianchaJKDao.lineJKSaveOld(ygLineJKDO);
    }

    @Override
    public List<String> getygRoom(String format) {
        return jianchaJKDao.getygRoom(format);
    }

    @Override
    public int getRoomNUM(Map<String, Object> tiaojian) {
        return jianchaJKDao.getRoomNUM(tiaojian);
    }

}
