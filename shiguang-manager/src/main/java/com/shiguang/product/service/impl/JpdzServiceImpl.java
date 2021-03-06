package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.JpdzDao;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.service.JpdzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class JpdzServiceImpl implements JpdzService {
    @Autowired
    private JpdzDao jpdzDao;

    @Override
    public JpdzDO get(Long id) {
        return jpdzDao.get(id);
    }

    @Override
    public List<JpdzDO> list(Map<String, Object> map) {
        return jpdzDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return jpdzDao.count(map);
    }

    @Override
    public List<JpdzDO> listDz(Map<String, Object> map) {
        return jpdzDao.listDz(map);
    }

    @Override
    public int countDz(Map<String, Object> map) {
        return jpdzDao.countDz(map);
    }

    @Override
    public int save(JpdzDO jpdz) {
        return jpdzDao.save(jpdz);
    }

    @Override
    public int update(JpdzDO jpdz) {
        return jpdzDao.update(jpdz);
    }

    @Override
    public int remove(Long id) {
        return jpdzDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return jpdzDao.batchRemove(ids);
    }




    //删除修改状态
    @Override
    public int updateState(JpdzDO jpdz) {
        return jpdzDao.updateState(jpdz);
    }

    //判断是否存在商品代码
    @Override
    public List<JpdzDO> haveNum(Map<String, Object> map) {
        return jpdzDao.haveNum(map);
    }

    @Override
    public JpdzDO getJpdzInfomation(String goodNum) {
        return jpdzDao.getJpdzInfomation(goodNum);
    }
}
