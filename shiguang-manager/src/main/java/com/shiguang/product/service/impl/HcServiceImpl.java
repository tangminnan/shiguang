package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.HcDao;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.service.HcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class HcServiceImpl implements HcService {
    @Autowired
    private HcDao hcDao;

    @Override
    public HcDO get(Long id) {
        return hcDao.get(id);
    }

    @Override
    public List<HcDO> list(Map<String, Object> map) {
        return hcDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return hcDao.count(map);
    }

    @Override
    public int save(HcDO hc) {
        return hcDao.save(hc);
    }

    @Override
    public int update(HcDO hc) {
        return hcDao.update(hc);
    }

    @Override
    public int remove(Long id) {
        return hcDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return hcDao.batchRemove(ids);
    }

    //查询耗材制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return hcDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return hcDao.choice(mfrsid);
    }
    //删除修改状态

    @Override
    public int updateState(HcDO hc) {
        return hcDao.updateState(hc);
    }
}
