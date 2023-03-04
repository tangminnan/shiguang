package com.shiguang.line.dao;

import com.shiguang.line.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OptometryLineDao {
    YgLineDO get(Long id);

    List<YgLineDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    List<YgLineDO> overList(Map<String,Object> map);

    int overCount(Map<String,Object> map);

    int update(YgLineDO line);

    int updateStatus(YgLineDO ygLineDO);

    List<YgLineDO> lineList(Map<String,Object> map);

    List<YgLineDO> linesList(Map<String,Object> map);

    List<YgLineMemberDO> linememberList(Map<String,Object> map);

    List<YgLineMemberDO> listMember(Map<String,Object> map);

    int saveLineMember(YgLineMemberDO ygLineMemberDO);

    int removeMember(Long id);

    int remove(Long id);

    YgLineJinanDO getJinan(Long id);

    List<YgLineJinanDO> listJinan(Map<String, Object> map);

   int  saveYgLineJinan(YgLineJinanDO ygLineJinanDO);

    int countJinan(Map<String, Object> map);

    int updateJinan(YgLineJinanDO line);

    int updateJinanStatus(YgLineJinanDO ygLineDO);

    List<YgLineJinanDO> lineJinanList(Map<String,Object> map);

    List<YgLineJinanDO> linesJinanList(Map<String,Object> map);

    List<YgLineMemberJinanDO> linememberJinanList(Map<String,Object> map);

    List<YgLineMemberJinanDO> listMemberJinan(Map<String,Object> map);

    int saveLineMemberJinan(YgLineMemberJinanDO ygLineMemberDO);

    YgLineMemberJinanDO getMemberNumber(Map<String,Object> map);

    int removeMemberjinan(String id);

    int removejinan(Long id);


    List<YgLineoldDO> listold(Map<String, Object> map);

    int countold(Map<String, Object> map);


    int updateold(YgLineoldDO line);


    YgLineoldDO getold(Long id);

    List<YgLineoldDO> linesListold(Map<String,Object> map);

    List<YgLineMemberoldDO> listMemberold(Map<String,Object> map);

    List<YgLineoldDO> lineListold(Map<String,Object> map);

    int removeold(Long id);
    int saveLineMemberold(YgLineMemberoldDO ygLineMemberoldDO);

    List<YgLinenewDO> listnew(Map<String, Object> map);

    int countnew(Map<String, Object> map);


    int updatenew(YgLinenewDO line);


    YgLinenewDO getnew(Long id);

    List<YgLinenewDO> linesListnew(Map<String,Object> map);

    List<YgLineMembernewDO> listMembernew(Map<String,Object> map);

    List<YgLinenewDO> lineListnew(Map<String,Object> map);

    int removenew(Long id);
    int saveLineMembernew(YgLineMembernewDO ygLineMembernewDO);



}
