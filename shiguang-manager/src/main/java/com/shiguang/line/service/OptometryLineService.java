package com.shiguang.line.service;

import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.domain.YgLineMemberDO;

import java.util.List;
import java.util.Map;

public interface OptometryLineService {
    YgLineDO get(Long id);

    List<YgLineDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int update(YgLineDO line);

    int updateStatus(YgLineDO ygLineDO);

    List<YgLineDO> lineList(Map<String,Object> map);

    List<YgLineDO> linesList(Map<String,Object> map);

    List<YgLineMemberDO> linememberList(Map<String,Object> map);

    List<YgLineMemberDO> listMember(Map<String,Object> map);

    int saveLineMember(YgLineMemberDO ygLineMemberDO);

    int removeMember(Long id);
}
