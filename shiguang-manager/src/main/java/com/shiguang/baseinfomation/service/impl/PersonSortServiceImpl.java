package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.PersonSortDao;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.service.PersonSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonSortServiceImpl implements PersonSortService {
    @Autowired
    private PersonSortDao sortDao;

    @Override
    public PersonSortDO get(Long id){
        return sortDao.get(id);
    }

    @Override
    public List<PersonSortDO> list(Map<String, Object> map){
        return sortDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return sortDao.count(map);
    }

    @Override
    public int save(PersonSortDO sort){
        return sortDao.save(sort);
    }

    @Override
    public int update(PersonSortDO sort){
        return sortDao.update(sort);
    }

    @Override
    public int remove(Long id){
        return sortDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return sortDao.batchRemove(ids);
    }

    @Override
    public int updateStatus(PersonSortDO personSortDO) {
        return sortDao.updateStatus(personSortDO);
    }
}
