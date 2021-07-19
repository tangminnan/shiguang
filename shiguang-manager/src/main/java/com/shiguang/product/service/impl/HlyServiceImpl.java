package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.HlyDao;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.service.HlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class HlyServiceImpl implements HlyService {
    @Autowired
    private HlyDao hlyDao;

    @Override
    public HlyDO get(Long id) {
        return hlyDao.get(id);
    }

    @Override
    public List<HlyDO> list(Map<String, Object> map) {
        return hlyDao.list(map);
    }

    //选择护理液
    @Override
    public List<HlyDO> gethly(Map<String, Object> map) {
        return hlyDao.gethly(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return hlyDao.count(map);
    }

    @Override
    public int save(HlyDO hly) {
        return hlyDao.save(hly);
    }

    @Override
    public int update(HlyDO hly) {
        return hlyDao.update(hly);
    }

    @Override
    public int remove(Long id) {
        return hlyDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return hlyDao.batchRemove(ids);
    }

    //查询护理液制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return hlyDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return hlyDao.choice(mfrsid);
    }

}
