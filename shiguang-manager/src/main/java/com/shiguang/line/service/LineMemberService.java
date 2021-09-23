package com.shiguang.line.service;

import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.LineMemberDO;
import java.util.List;
import java.util.Map;

public interface LineMemberService {
    LineMemberDO get(Long id);

    List<LineMemberDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LineMemberDO member);

    int update(LineMemberDO member);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<LineDO> listMember(Map<String,Object> map);

}
