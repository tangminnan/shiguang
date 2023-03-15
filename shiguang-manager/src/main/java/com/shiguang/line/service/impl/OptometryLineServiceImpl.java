package com.shiguang.line.service.impl;

import com.shiguang.line.dao.OptometryLineDao;
import com.shiguang.line.domain.*;
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
    public List<YgLineDO> overList(Map<String, Object> map) {
        return optometryLineDao.overList(map);
    }

    @Override
    public int overCount(Map<String, Object> map) {
        return optometryLineDao.overCount(map);
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

    @Override
    public YgLineJinanDO getJinan(Long id) {
        return optometryLineDao.getJinan(id);
    }

    @Override
    public List<YgLineJinanDO> listJinan(Map<String, Object> map) {
        return optometryLineDao.listJinan(map);
    }

    @Override
    public int saveYgLineJinan(YgLineJinanDO ygLineJinanDO) {
        return optometryLineDao.saveYgLineJinan(ygLineJinanDO);
    }

    @Override
    public int countJinan(Map<String, Object> map) {
        return optometryLineDao.countJinan(map);
    }

    @Override
    public int updateJinan(YgLineJinanDO line) {
        return optometryLineDao.updateJinan(line);
    }

    @Override
    public int updateJinanStatus(YgLineJinanDO line) {
        return optometryLineDao.updateJinanStatus(line);
    }

    @Override
    public List<YgLineJinanDO> lineJinanList(Map<String, Object> map) {
        return optometryLineDao.lineJinanList(map);
    }

    @Override
    public List<YgLineJinanDO> linesJinanList(Map<String, Object> map) {
        return optometryLineDao.linesJinanList(map);
    }

    @Override
    public List<YgLineMemberJinanDO> linememberJinanList(Map<String, Object> map) {
        return optometryLineDao.linememberJinanList(map);
    }

    @Override
    public List<YgLineMemberJinanDO> listMemberJinan(Map<String, Object> map) {
        return optometryLineDao.listMemberJinan(map);
    }

    @Override
    public int saveLineMemberJinan(YgLineMemberJinanDO ygLineMemberDO) {
        return optometryLineDao.saveLineMemberJinan(ygLineMemberDO);
    }

    @Override
    public YgLineMemberJinanDO getMemberNumber(Map<String,Object> map) {
        return optometryLineDao.getMemberNumber(map);
    }

    @Override
    public int removeMemberjinan(String id) {
        return optometryLineDao.removeMemberjinan(id);
    }

    @Override
    public int removejinan(Long id) {
        return optometryLineDao.remove(id);
    }

    @Override
    public List<YgLineoldDO> listold(Map<String, Object> map) {
        return optometryLineDao.listold(map);
    }

    @Override
    public int countold(Map<String, Object> map) {
        return optometryLineDao.countold(map);
    }

    @Override
    public int updateold(YgLineoldDO line) {
        return optometryLineDao.updateold(line);
    }

    @Override
    public YgLineoldDO getold(Long id) {
        return optometryLineDao.getold(id);
    }

    @Override
    public List<YgLineoldDO> linesListold(Map<String, Object> map) {
        return optometryLineDao.linesListold(map);
    }

    @Override
    public List<YgLineMemberoldDO> listMemberold(Map<String, Object> map) {
        return optometryLineDao.listMemberold(map);
    }

    @Override
    public List<YgLineoldDO> lineListold(Map<String, Object> map) {
        return optometryLineDao.lineListold(map);
    }

    @Override
    public int removeold(Long id) {
        return optometryLineDao.removeold(id);
    }


    @Override
    public int saveLineMemberold(YgLineMemberoldDO ygLineMemberoldDO) {
        return optometryLineDao.saveLineMemberold(ygLineMemberoldDO);
    }

    @Override
    public List<YgLinenewDO> listnew(Map<String, Object> map) {
        return optometryLineDao.listnew(map);
    }

    @Override
    public int countnew(Map<String, Object> map) {
        return optometryLineDao.countnew(map);
    }

    @Override
    public int updatenew(YgLinenewDO line) {
        return optometryLineDao.updatenew(line);
    }

    @Override
    public YgLinenewDO getnew(Long id) {
        return optometryLineDao.getnew(id);
    }

    @Override
    public List<YgLinenewDO> linesListnew(Map<String, Object> map) {
        return optometryLineDao.linesListnew(map);
    }

    @Override
    public List<YgLineMembernewDO> listMembernew(Map<String, Object> map) {
        return optometryLineDao.listMembernew(map);
    }

    @Override
    public List<YgLinenewDO> lineListnew(Map<String, Object> map) {
        return optometryLineDao.lineListnew(map);
    }

    @Override
    public int removenew(Long id) {
        return optometryLineDao.removenew(id);
    }


    @Override
    public int saveLineMembernew(YgLineMembernewDO ygLineMembernewDO) {
        return optometryLineDao.saveLineMembernew(ygLineMembernewDO);
    }
}
