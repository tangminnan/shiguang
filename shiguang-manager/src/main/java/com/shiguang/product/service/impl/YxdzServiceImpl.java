package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.YxdzDao;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.product.service.YxdzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class YxdzServiceImpl implements YxdzService {
    @Autowired
    private YxdzDao yxdzDao;

    @Override
    public YxdzDO get(Long id) {
        return yxdzDao.get(id);
    }

    @Override
    public List<YxdzDO> list(Map<String, Object> map) {
        return yxdzDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return yxdzDao.count(map);
    }

    @Override
    public int save(YxdzDO yxdz) {
        return yxdzDao.save(yxdz);
    }

    @Override
    public int update(YxdzDO yxdz) {
        return yxdzDao.update(yxdz);
    }

    @Override
    public int remove(Long id) {
        return yxdzDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return yxdzDao.batchRemove(ids);
    }




    //删除修改状态
    @Override
    public int updateState(YxdzDO yxdz) {
        return yxdzDao.updateState(yxdz);
    }

    //判断是否存在商品代码
    @Override
    public List<YxdzDO> haveNum(Map<String, Object> map) {
        return yxdzDao.haveNum(map);
    }

    @Override
    public YxdzDO getYxdzInfomation(String goodNum) {
        return yxdzDao.getYxdzInfomation(goodNum);
    }
}
