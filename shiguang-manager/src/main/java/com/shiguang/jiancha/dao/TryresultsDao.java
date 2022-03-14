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
    //    <!--//判断是否存在验光号-->
    List<TryresultsDO> haveYanguangNum(Map<String, Object> map);
    int update(TryresultsDO tryresults);

    int remove(Long id);

    int batchRemove(Long[] ids);
    //根据人查相对应的验光号医生时间等信息
    List<TryresultsDO> listUser(Map<String, Object> map);

    //    查询医生
    List<TryresultsDO> listDoctor(Map<String, Object> map);
    List<TryresultsDO> listYanguang(Map<String, Object> map);
    TryresultsDO  getTryresult(Map<String, Object> map);



    //所有-验光数据
    List<TryresultsDO> yanguangListShuju(Map<String, Object> map);
    int yanguangListShujuCount(Map<String, Object> map);
    //下处方后修改数据的状态为0--不能修改了没有修改按钮
    int updateStatus(TryresultsDO tryresultsDO );
    //修改检查结论数据
    int updateTry(TryresultsDO tryresults);
}
