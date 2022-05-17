package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.MfrsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 制造商维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 11:33:55
 */
@Mapper
public interface MfrsDao {

    MfrsDO get(Integer mfrsid);

    List<MfrsDO> haveNum(Map<String, Object> map);

    List<MfrsDO> list(Map<String, Object> map);
    int count(Map<String, Object> map);
    List<MfrsDO> findMfrs(Map<String, Object> map);
    int findMfrscount(Map<String, Object> map);

    int save(MfrsDO mfrs);

    int update(MfrsDO mfrs);

    int remove(Integer mfrsid);

    int batchRemove(Integer[] mfrsids);

    int updateState(MfrsDO mfrs);

    List<MfrsDO> getweiwailist(Map<String, Object> map);


}
