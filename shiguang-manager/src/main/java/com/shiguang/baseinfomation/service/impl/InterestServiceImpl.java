package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.InterestDao;
import com.shiguang.baseinfomation.domain.InterestDO;
import com.shiguang.baseinfomation.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InterestServiceImpl implements InterestService {
    @Autowired
    private InterestDao interestDao;

    @Override
    public InterestDO get(Long id){
        return interestDao.get(id);
    }

    @Override
    public List<InterestDO> list(Map<String, Object> map){
        return interestDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return interestDao.count(map);
    }

    @Override
    public int save(InterestDO interest){
        return interestDao.save(interest);
    }

    @Override
    public int update(InterestDO interest){
        return interestDao.update(interest);
    }

    @Override
    public int remove(Long id){
        return interestDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return interestDao.batchRemove(ids);
    }

    @Override
    public int updateStatus(InterestDO interestDO) {
        return interestDao.updateStatus(interestDO);
    }
}
