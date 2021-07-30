package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.dao.JpcpDao;
import com.shiguang.product.domain.JpcpDO;
import com.shiguang.product.service.JpcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class JpcpServiceImpl implements JpcpService {
    @Autowired
    private JpcpDao jpcpDao;

    @Override
    public JpcpDO get(Long id) {
        return jpcpDao.get(id);
    }

    @Override
    public List<JpcpDO> list(Map<String, Object> map) {
        return jpcpDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return jpcpDao.count(map);
    }

    @Override
    public int save(JpcpDO jpcp) {
        return jpcpDao.save(jpcp);
    }

    //修改停用启用
    @Override
    public int update(JpcpDO jpcp) {
        return jpcpDao.update(jpcp);
    }

    @Override
    public int remove(Long id) {
        return jpcpDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return jpcpDao.batchRemove(ids);
    }

    //查询镜片成品制造商
    @Override
    public List<MgDO> mglist(Map<String, Object> map) {
        return jpcpDao.mglist(map);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Integer mfrsid) {
        return jpcpDao.choice(mfrsid);
    }

    //删除修改状态
    @Override
    public int updateState(JpcpDO jpcp) {
        return jpcpDao.updateState(jpcp);
    }
}
