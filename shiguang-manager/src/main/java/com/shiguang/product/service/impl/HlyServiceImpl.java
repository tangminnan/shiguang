package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
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
    public int gethlycount(Map<String, Object> map) {
        return hlyDao.gethlycount(map);
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


    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return hlyDao.choice(mfrsid);
    }


    //删除修改状态
    @Override
    public int updateState(HlyDO hly) {
        return hlyDao.updateState(hly);
    }

    //判断是否存在商品代码
    @Override
    public List<HlyDO> haveNum(Map<String, Object> map) {
        return hlyDao.haveNum(map);
    }

    @Override
    public HlyDO getHlyInfomation(String goodNum) {
        return hlyDao.getHlyInfomation(goodNum);
    }
}
