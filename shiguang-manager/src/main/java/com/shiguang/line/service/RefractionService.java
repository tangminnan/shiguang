package com.shiguang.line.service;

import com.shiguang.line.domain.RefractionDO;
import com.shiguang.line.domain.RefractionLineDO;
import com.shiguang.line.domain.RefractionLineMemberDO;

import java.util.List;
import java.util.Map;

public interface RefractionService {
    RefractionLineDO get(Long id);

    RefractionDO getRefraction(String name);

    List<RefractionLineDO> list(Map<String, Object> map);

    List<RefractionLineDO> refrationlineList(Map<String,Object> map);

    List<RefractionLineMemberDO> listMember(Map<String,Object> map);

    int count(Map<String, Object> map);

    int save(RefractionDO line);

    int saveLine(RefractionLineDO refractionLineDO);

    int saveLineMember(RefractionLineMemberDO refractionLineMemberDO);

    int update(RefractionDO line);

    int updateLine(RefractionLineDO refractionLineDO);

    int remove(String name);

    int batchRemove(Long[] ids);

    int updateByMember(RefractionDO lineDO);

    List<RefractionDO> lineList(Map<String,Object> map);

    int removeMember(Long id);
}
