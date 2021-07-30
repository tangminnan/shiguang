package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.TyjDao;
import com.shiguang.product.domain.TyjDO;
import com.shiguang.product.service.TyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TyjServiceImpl implements TyjService {
    @Autowired
    private TyjDao tyjDao;

    @Override
    public TyjDO get(Long id) {
        return tyjDao.get(id);
    }

    @Override
    public List<TyjDO> list(Map<String, Object> map) {
        return tyjDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return tyjDao.count(map);
    }

    @Override
    public int save(TyjDO tyj) {
        return tyjDao.save(tyj);
    }

    @Override
    public int update(TyjDO tyj) {
        return tyjDao.update(tyj);
    }

    @Override
    public int remove(Long id) {
        return tyjDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return tyjDao.batchRemove(ids);
    }

    //查询太阳镜制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return tyjDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return tyjDao.choice(mfrsid);
    }
    //删除修改状态

    @Override
    public int updateState(TyjDO tyj) {
        return tyjDao.updateState(tyj);
    }
}
