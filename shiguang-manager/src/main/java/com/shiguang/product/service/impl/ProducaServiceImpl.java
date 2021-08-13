package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.ProducaDao;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ProducaServiceImpl implements ProducaService {
    @Autowired
    private ProducaDao producaDao;

    @Override
    public ProducaDO get(Long id) {
        return producaDao.get(id);
    }

    //修改时显示制造商和商品品种名称
    @Override
    public List<ProducaDO> list(Map<String, Object> map) {
        return producaDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return producaDao.count(map);
    }

    @Override
    public int save(ProducaDO produca) {
        return producaDao.save(produca);
    }

    //修改停用启用
    @Override
    public int update(ProducaDO produca) {
        return producaDao.update(produca);
    }

    @Override
    public int remove(Long id) {
        return producaDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return producaDao.batchRemove(ids);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Map<String, Object> map) {
        return producaDao.choice(map);
    }

    //删除修改状态
    @Override
    public int updateState(ProducaDO produca) {
        return producaDao.updateState(produca);
    }
}
