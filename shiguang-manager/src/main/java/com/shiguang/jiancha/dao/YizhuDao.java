package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.YizhuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 18:47:47
 */
@Mapper
public interface YizhuDao {

    YizhuDO get(Long yizhuId);

    //医嘱
    List<YizhuDO> findYizhu(Map<String, Object> map);

    int countYizhu(Map<String, Object> map);

    int save(YizhuDO yizhu);

    int update(YizhuDO yizhu);

    int remove(Long yizhu_id);

    int batchRemove(Long[] yizhuIds);


}
