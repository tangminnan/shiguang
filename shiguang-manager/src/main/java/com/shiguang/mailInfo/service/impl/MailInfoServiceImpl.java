package com.shiguang.mailInfo.service.impl;

import com.shiguang.mailInfo.dao.MailInfoDao;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MailInfoServiceImpl implements MailInfoService {
    @Autowired
    private MailInfoDao mailInfoDao;

    @Override
    public MailInfoDO get(Long id){
        return mailInfoDao.get(id);
    }

    @Override
    public List<MailInfoDO> list(Map<String, Object> map){
        return mailInfoDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return mailInfoDao.count(map);
    }

    @Override
    public int save(MailInfoDO info){
        return mailInfoDao.save(info);
    }

    @Override
    public int update(MailInfoDO info){
        return mailInfoDao.update(info);
    }

    @Override
    public int remove(Long id){
        return mailInfoDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return mailInfoDao.batchRemove(ids);
    }
}
