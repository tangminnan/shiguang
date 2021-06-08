package com.shiguang.member.service.impl;

import com.shiguang.member.dao.MemberDao;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberDO get(Long id){
        return memberDao.get(id);
    }

    @Override
    public List<MemberDO> list(Map<String, Object> map){
        return memberDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return memberDao.count(map);
    }

    @Override
    public int save(MemberDO member){
        return memberDao.save(member);
    }

    @Override
    public int update(MemberDO member){
        return memberDao.update(member);
    }

    @Override
    public int remove(Long id){
        return memberDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids,Long status){
        return memberDao.batchRemove(ids,status);
    }

    @Override
    public int updateStatus(MemberDO memberDO){
        return memberDao.update(memberDO);
    }
}
