package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.MfrsDO;

import java.util.List;
import java.util.Map;

/**
 * 制造商维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 11:33:55
 */
public interface MfrsService {

    MfrsDO get(Integer mfrsid);

    List<MfrsDO> haveNum(Map<String, Object> map);

    List<MfrsDO> list(Map<String, Object> map);
    int count(Map<String, Object> map);

    List<MfrsDO> findMfrs(Map<String, Object> map);
    int findMfrscount(Map<String, Object> map);

    int save(MfrsDO mfrs);

    //修改停用启用
    int update(MfrsDO mfrs);

    int remove(Integer mfrsid);

    int batchRemove(Integer[] mfrsids);

    //删除修改状态
    int updateState(MfrsDO mfrs);

    List<MfrsDO> getweiwailist(Map<String, Object> map);

}
