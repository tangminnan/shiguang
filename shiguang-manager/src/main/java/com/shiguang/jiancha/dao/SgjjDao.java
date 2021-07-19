package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SgjjDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 框架双光/渐进表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 10:03:39
 */
@Mapper
public interface SgjjDao {

    SgjjDO get(Long sgjjId);

    List<SgjjDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SgjjDO sgjj);

    int savesgjj(ResultDO result);

    int update(SgjjDO sgjj);

    int remove(Long sgjj_id);

    int batchRemove(Long[] sgjjIds);
}
