package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.RefractivityDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 折射率维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 18:30:49
 */
@Mapper
public interface RefractivityDao {

    RefractivityDO get(Integer refractivityid);

    List<RefractivityDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RefractivityDO refractivity);

    int update(RefractivityDO refractivity);

    int remove(Integer refractivityid);

    int batchRemove(Integer[] refractivityids);

    //删除修改状态
    int updateState(RefractivityDO refractivityDO);
}
