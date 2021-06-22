package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.CardTypeDao;
import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardTypeServiceImpl implements CardTypeService {
    @Autowired
    private CardTypeDao typeDao;

    @Override
    public CardTypeDO get(Long id){
        return typeDao.get(id);
    }

    @Override
    public List<CardTypeDO> list(Map<String, Object> map){
        return typeDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return typeDao.count(map);
    }

    @Override
    public int save(CardTypeDO type){
        return typeDao.save(type);
    }

    @Override
    public int update(CardTypeDO type){
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
    public int updateStatus(CardTypeDO cardTypeDO){
        return typeDao.updateStatus(cardTypeDO);
    }
}
