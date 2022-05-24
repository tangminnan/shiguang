package com.shiguang.product.service.impl;

import com.shiguang.product.dao.ShiguangDao;
import com.shiguang.product.dao.ShiguangdzDao;
import com.shiguang.product.domain.ShiguangdzDO;
import com.shiguang.product.service.ShiguangService;
import com.shiguang.product.service.ShiguangdzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ShiguangdzServiceImpl implements ShiguangdzService {
    @Autowired
    private ShiguangdzDao shiguangdzDao;

    @Override
    public ShiguangdzDO get(Long id) {
        return shiguangdzDao.get(id);
    }

    @Override
    public List<ShiguangdzDO> list(Map<String, Object> map) {
        return shiguangdzDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return shiguangdzDao.count(map);
    }

    @Override
    public List<ShiguangdzDO> getshiguang(Map<String, Object> map) {
        return shiguangdzDao.getshiguang(map);
    }

    @Override
    public int getshiguangcount(Map<String, Object> map) {
        return shiguangdzDao.getshiguangcount(map);
    }

    @Override
    public int save(ShiguangdzDO shiguang) {
        return shiguangdzDao.save(shiguang);
    }

    @Override
    public int update(ShiguangdzDO shiguang) {
        return shiguangdzDao.update(shiguang);
    }

    @Override
    public int remove(Long id) {
        return shiguangdzDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return shiguangdzDao.batchRemove(ids);
    }



    //删除修改状态
    @Override
    public int updateState(ShiguangdzDO shiguang) {
        return shiguangdzDao.updateState(shiguang);
    }

    //判断是否存在商品代码
    @Override
    public List<ShiguangdzDO> haveNum(Map<String, Object> map) {
        return shiguangdzDao.haveNum(map);
    }

    @Override
    public ShiguangdzDO getShiguangInfomation(String goodNum) {
        return shiguangdzDao.getShiguangInfomation(goodNum);
    }
}
