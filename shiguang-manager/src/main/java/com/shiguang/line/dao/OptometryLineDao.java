package com.shiguang.line.dao;

import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.domain.YgLineMemberDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OptometryLineDao {
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

    int remove(Long id);
}
