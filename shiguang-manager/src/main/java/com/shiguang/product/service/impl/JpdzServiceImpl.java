package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
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

    //查询镜片定做制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return jpdzDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return jpdzDao.choice(mfrsid);
    }

}
