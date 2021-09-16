package com.shiguang.line.service.impl;

import com.shiguang.line.dao.LineMemberDao;
import com.shiguang.line.domain.LineMemberDO;
import com.shiguang.line.service.LineMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LineMemberServiceImpl implements LineMemberService {
    @Autowired
    private LineMemberDao lineMemberDao;

    @Override
    public LineMemberDO get(Long id){
        return lineMemberDao.get(id);
    }

    @Override
    public List<LineMemberDO> list(Map<String, Object> map){
        return lineMemberDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return lineMemberDao.count(map);
    }

    @Override
    public int save(LineMemberDO member){
        return lineMemberDao.save(member);
    }

    @Override
    public int update(LineMemberDO member){
        return lineMemberDao.update(member);
    }

    @Override
    public int remove(Long id){
        return lineMemberDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return lineMemberDao.batchRemove(ids);
    }
}
