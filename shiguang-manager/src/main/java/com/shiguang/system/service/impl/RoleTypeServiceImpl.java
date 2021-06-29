package com.shiguang.system.service.impl;

import com.shiguang.mfrs.dao.TypeDao;
import com.shiguang.mfrs.domain.TypeDO;
import com.shiguang.system.dao.RoleTypeDao;
import com.shiguang.system.domain.RoleTypeDO;
import com.shiguang.system.service.RoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Map;

@Service
public class RoleTypeServiceImpl implements RoleTypeService {
    @Autowired
    private RoleTypeDao typeDao;

    @Override
    public RoleTypeDO get(Long id){
        return typeDao.get(id);
    }

    @Override
    public RoleTypeDO getNum(Long roleNum){
        return typeDao.getNum(roleNum);
    }

    @Override
    public List<RoleTypeDO> list(Map<String, Object> map){
        return typeDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return typeDao.count(map);
    }

    @Override
    public int save(RoleTypeDO type){
        return typeDao.save(type);
    }

    @Override
    public int update(RoleTypeDO type){
        return typeDao.update(type);
    }

    @Override
    public int remove(Long id){
        return typeDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return typeDao.batchRemove(ids);
    }
}
