package com.shiguang.jiekou.dao;

import com.shiguang.jiekou.domain.*;
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
public interface JianchaJKDao {
    List<TryresultJKDO> yanguangListShuju(Map<String, Object> map);

    List<KjyyJKDO> KjyyListShuju(Map<String, Object> map1);

    List<KjjyJKDO> KjjyListShuju(Map<String, Object> map1);

    List<SgjjJKDO> SgjjListShuju(Map<String, Object> map1);

    List<RxjmjcjJKDO> RxjmjcjListShuju(Map<String, Object> map1);

    List<ZyJKDO> ZyListShuju(Map<String, Object> map1);

    List<SjxlJKDO> SjxlListShuju(Map<String, Object> map1);

    List<VstJKDO> VstListShuju(Map<String, Object> map1);

    List<CrtJKDO> CrtListShuju(Map<String, Object> map1);

    List<RgpJKDO> RgpListShuju(Map<String, Object> map1);

    int lineJKSave(YgLineJKDO ygLineJKDO);

    List<lastResultJKDO> getYanguangLast(String cardNumber);
}
