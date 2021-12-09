package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.PartsDao;
import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PartsServiceImpl implements PartsService {
    @Autowired
    private PartsDao partsDao;

    @Override
    public PartsDO get(Long id) {
        return partsDao.get(id);
    }

    @Override
    public List<PartsDO> list(Map<String, Object> map) {
        return partsDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return partsDao.count(map);
    }

    @Override
    public int save(PartsDO parts) {
        return partsDao.save(parts);
    }

    @Override
    public int update(PartsDO parts) {
        return partsDao.update(parts);
    }

    @Override
    public int remove(Long id) {
        return partsDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return partsDao.batchRemove(ids);
    }

    //查询配件制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return partsDao.mglist(map);
    }


    //删除修改状态
    @Override
    public int updateState(PartsDO parts) {
        return partsDao.updateState(parts);
    }

    //判断是否存在商品代码
    @Override
    public List<PartsDO> haveNum(Map<String, Object> map) {
        return partsDao.haveNum(map);
    }

    @Override
    public PartsDO getPartInfomation(String goodNum) {
        return partsDao.getPartInfomation(goodNum);
    }
}
