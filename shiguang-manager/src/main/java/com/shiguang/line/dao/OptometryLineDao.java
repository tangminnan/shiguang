package com.shiguang.line.dao;

import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.domain.YgLineMemberDO;
import com.shiguang.line.domain.YgLineMemberoldDO;
import com.shiguang.line.domain.YgLineoldDO;
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

    List<YgLineoldDO> listold(Map<String, Object> map);

    int countold(Map<String, Object> map);


    int updateold(YgLineoldDO line);


    YgLineoldDO getold(Long id);

    List<YgLineoldDO> linesListold(Map<String,Object> map);

    List<YgLineMemberoldDO> listMemberold(Map<String,Object> map);

    List<YgLineoldDO> lineListold(Map<String,Object> map);

    int removeold(Long id);
    int saveLineMemberold(YgLineMemberoldDO ygLineMemberoldDO);

}
