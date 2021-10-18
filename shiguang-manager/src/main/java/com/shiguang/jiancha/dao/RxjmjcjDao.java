package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RxjmjcjDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 框架近用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:18:47
 */
@Mapper
public interface RxjmjcjDao {

    RxjmjcjDO get(Long rxId);

    List<RxjmjcjDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RxjmjcjDO rxjmjcj);

    int saveRxjmjcj(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long rx_id);
    int upremove(RxjmjcjDO rxjmjcjDO);

    int batchRemove(Long[] rxIds);
}
