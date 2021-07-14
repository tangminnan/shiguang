package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.DepartmentDao;
import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public DepartmentDO get(Long id){
        return departmentDao.get(id);
    }

    @Override
    public List<DepartmentDO> list(Map<String, Object> map){
        return departmentDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return departmentDao.count(map);
    }

    @Override
    public int save(DepartmentDO department){
        return departmentDao.save(department);
    }

    @Override
    public int update(DepartmentDO department){
        return departmentDao.update(department);
    }

    @Override
    public int remove(Long id){
        return departmentDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return departmentDao.batchRemove(ids);
    }

    @Override
    public int updateStatus(DepartmentDO departmentDO) {
        return departmentDao.updateStatus(departmentDO);
    }

    @Override
    public DepartmentDO getDepartName(String departNumber){
        return departmentDao.getDepartName(departNumber);
    }
}
