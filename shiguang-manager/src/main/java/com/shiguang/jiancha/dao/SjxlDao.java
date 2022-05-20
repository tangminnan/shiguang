package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SjxlDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 视觉训练表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 14:02:19
 */
@Mapper
public interface SjxlDao {

    SjxlDO get(Long sjxlId);

    List<SjxlDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SjxlDO sjxl);

    int saveSjxl(ResultDO result);
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long sjxl_id);
    int upremove(SjxlDO sjxlDO);

    int batchRemove(Long[] sjxlIds);
    SjxlDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);
}
