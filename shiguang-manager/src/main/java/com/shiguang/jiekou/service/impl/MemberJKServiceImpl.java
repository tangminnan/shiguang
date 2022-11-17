package com.shiguang.jiekou.service.impl;

import com.shiguang.jiekou.dao.MemberJKDao;
import com.shiguang.jiekou.domain.MemberJKDO;
import com.shiguang.jiekou.service.MemberJKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberJKServiceImpl implements MemberJKService {

    @Autowired
    private MemberJKDao memberJKDao;

    @Override
    public List<MemberJKDO> getCardNumber(Map<String,Object> map1){
        return memberJKDao.getCardNumber(map1);
    }

    @Override
    public List<MemberJKDO> list(Map<String, Object> map){
        return memberJKDao.list(map);
    }

    @Override
    public int save(MemberJKDO member){
        return memberJKDao.save(member);
    }

    @Override
    public int update(MemberJKDO member){
        return memberJKDao.update(member);
    }

    @Override
    public List<Map> getLine(String now) {
        return memberJKDao.getLine(now);
    }

    @Override
    public void updateLine(String liner) {
        memberJKDao.updateLine(liner);
    }


}
