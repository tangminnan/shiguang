package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.OldlensDao;
import com.shiguang.product.domain.OldlensDO;
import com.shiguang.product.service.OldlensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OldlensServiceImpl implements OldlensService {
    @Autowired
    private OldlensDao oldlensDao;

    @Override
    public OldlensDO get(Long id) {
        return oldlensDao.get(id);
    }

    @Override
    public List<OldlensDO> list(Map<String, Object> map) {
        return oldlensDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return oldlensDao.count(map);
    }

    @Override
    public int save(OldlensDO oldlens) {
        return oldlensDao.save(oldlens);
    }

    @Override
    public int update(OldlensDO oldlens) {
        return oldlensDao.update(oldlens);
    }

    @Override
    public int remove(Long id) {
        return oldlensDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return oldlensDao.batchRemove(ids);
    }


    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return oldlensDao.choice(mfrsid);
    }


    //删除修改状态
    @Override
    public int updateState(OldlensDO oldlens) {
        return oldlensDao.updateState(oldlens);
    }

    //判断是否存在商品代码
    @Override
    public List<OldlensDO> haveNum(Map<String, Object> map) {
        return oldlensDao.haveNum(map);
    }
}
