package com.shiguang.line.service.impl;

import com.shiguang.line.dao.OptometryLineDao;
import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.domain.YgLineMemberDO;
import com.shiguang.line.service.OptometryLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OptometryLineServiceImpl implements OptometryLineService {
    @Autowired
    private OptometryLineDao optometryLineDao;
    @Override
    public YgLineDO get(Long id) {
        return optometryLineDao.get(id);
    }

    @Override
    public List<YgLineDO> list(Map<String, Object> map) {
        return optometryLineDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return optometryLineDao.count(map);
    }

    @Override
    public int update(YgLineDO line) {
        return optometryLineDao.update(line);
    }

    @Override
    public int updateStatus(YgLineDO line) {
        return optometryLineDao.updateStatus(line);
    }

    @Override
    public List<YgLineDO> lineList(Map<String, Object> map) {
        return optometryLineDao.lineList(map);
    }

    @Override
    public List<YgLineDO> linesList(Map<String, Object> map) {
        return optometryLineDao.linesList(map);
    }

    @Override
    public List<YgLineMemberDO> linememberList(Map<String, Object> map) {
        return optometryLineDao.linememberList(map);
    }

    @Override
    public List<YgLineMemberDO> listMember(Map<String, Object> map) {
        return optometryLineDao.listMember(map);
    }

    @Override
    public int saveLineMember(YgLineMemberDO ygLineMemberDO) {
        return optometryLineDao.saveLineMember(ygLineMemberDO);
    }

    @Override
    public int removeMember(Long id) {
        return optometryLineDao.removeMember(id);
    }

    @Override
    public int remove(Long id) {
        return optometryLineDao.remove(id);
    }
}
