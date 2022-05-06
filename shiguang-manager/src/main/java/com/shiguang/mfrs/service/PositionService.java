package com.shiguang.mfrs.service;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.mfrs.domain.PositionDO;

import java.util.List;
import java.util.Map;

/**
 * 仓位维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */
public interface PositionService {

    PositionDO get(Long positionId);

    //判断是否存在
    List<PositionDO> haveNum(Map<String, Object> map);


    List<PositionDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PositionDO position);

    //修改停用启用
    int update(PositionDO position);

    int remove(Long positionId);

    int batchRemove(Long[] positionIds);

    //删除修改状态
    int updateState(PositionDO position);

    PositionDO getPositionNum(String positionNum);

    // <!--库存查询相对应的仓库-->
    List<PositionDO> positionList(Map<String, Object> map);

    DepartmentDO getComponid(String departNumber);

}
