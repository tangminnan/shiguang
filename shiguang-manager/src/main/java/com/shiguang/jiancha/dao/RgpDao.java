package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RgpDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * RGP表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
@Mapper
public interface RgpDao {

    RgpDO get(Long rgpId);

    List<RgpDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RgpDO rgp);

    int saveRgp(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);


    int remove(Long rgp_id);
    int upremove(RgpDO rgpDO);


    int batchRemove(Long[] rgpIds);
    RgpDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);
}
