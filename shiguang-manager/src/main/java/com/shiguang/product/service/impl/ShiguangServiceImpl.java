package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.ShiguangDao;
import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.service.ShiguangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ShiguangServiceImpl implements ShiguangService {
    @Autowired
    private ShiguangDao shiguangDao;

    @Override
    public ShiguangDO get(Long id) {
        return shiguangDao.get(id);
    }

    @Override
    public List<ShiguangDO> list(Map<String, Object> map) {
        return shiguangDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return shiguangDao.count(map);
    }

    @Override
    public List<ShiguangDO> getshiguang(Map<String, Object> map) {
        return shiguangDao.getshiguang(map);
    }

    @Override
    public int save(ShiguangDO shiguang) {
        return shiguangDao.save(shiguang);
    }

    @Override
    public int update(ShiguangDO shiguang) {
        return shiguangDao.update(shiguang);
    }

    @Override
    public int remove(Long id) {
        return shiguangDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return shiguangDao.batchRemove(ids);
    }

    //查询视光制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return shiguangDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return shiguangDao.choice(mfrsid);
    }
    //删除修改状态

    @Override
    public int updateState(ShiguangDO shiguang) {
        return shiguangDao.updateState(shiguang);
    }
}
