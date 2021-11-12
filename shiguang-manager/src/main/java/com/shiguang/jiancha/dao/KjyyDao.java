package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.KjyyDO;
import com.shiguang.jiancha.domain.ResultDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 框架远用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 17:28:13
 */
@Mapper
public interface KjyyDao {

    KjyyDO get(Long kjyyId);

    List<KjyyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(KjyyDO kjyy);

    int savekjyy(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO resultDO);

    int remove(Long kjyy_id);
    int upremove(KjyyDO kjyyDO);

    int updatekjyy(KjyyDO kjyyDO);

    int batchRemove(Long[] kjyyIds);

    KjyyDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);
//List<KjyyDO> chufangall(Map<String, Object> map);
}
