package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.TryresultsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
@Mapper
public interface TryresultsDao {

    TryresultsDO get(Long id);

    List<TryresultsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TryresultsDO tryresults);
    List<TryresultsDO> haveYanguangNum(Map<String, Object> map);
    int update(TryresultsDO tryresults);

    int remove(String ptometryNumber);

    int batchRemove(Long[] ids);
    List<TryresultsDO> listUser(Map<String, Object> map);

    List<TryresultsDO> listDoctor(Map<String, Object> map);
    List<TryresultsDO> listYanguang(Map<String, Object> map);
    TryresultsDO  getTryresult(Map<String, Object> map);


    List<TryresultsDO> yanguangListShuju(Map<String, Object> map);
    int yanguangListShujuCount(Map<String, Object> map);
    int updateStatus(TryresultsDO tryresultsDO );
    int updateTry(TryresultsDO tryresults);
}
