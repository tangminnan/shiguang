package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.YaopinDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * jc药品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
@Mapper
public interface YaopinDao {

    YaopinDO get(Long ypId);

    List<YaopinDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(YaopinDO yaopin);

    int saveYaopin(ResultDO result);
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long yp_id);
    int upremove(YaopinDO yaopinDO);

    int batchRemove(Long[] ypIds);
    YaopinDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);

}
