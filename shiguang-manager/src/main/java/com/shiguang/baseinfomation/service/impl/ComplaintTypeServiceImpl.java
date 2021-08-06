package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.ComplaintTypeDao;
import com.shiguang.baseinfomation.domain.ComplaintTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.service.ComplaintTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComplaintTypeServiceImpl implements ComplaintTypeService {
    @Autowired
    private ComplaintTypeDao typeDao;

    @Override
    public ComplaintTypeDO get(Long id){
        return typeDao.get(id);
    }

    @Override
    public List<ComplaintTypeDO> list(Map<String, Object> map){
        return typeDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return typeDao.count(map);
    }

    @Override
    public int save(ComplaintTypeDO type){
        return typeDao.save(type);
    }

    @Override
    public int update(ComplaintTypeDO type){
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

    @Override
    public int updateStatus(ComplaintTypeDO complaintTypeDO) {
        return typeDao.updateStatus(complaintTypeDO);
    }
}
