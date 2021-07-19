package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.MfrsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<MfrsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    //	//-----商品查询-------
    List<MfrsDO> mglist(Map<String, Object> map);

    int mgcount(Map<String, Object> map);

    //选择制造商
    List<MfrsDO> findmfrs(Map<String, Object> map);

    //选择制造商
    int countmfrs(Map<String, Object> map);

    int save(MfrsDO mfrs);

    int update(MfrsDO mfrs);

    int remove(Integer mfrsid);

    int batchRemove(Integer[] mfrsids);

    //停用启动
    int stop(@Param("id") Integer[] ids, @Param("status") Long status);

    int updateStatus(MfrsDO mfrsDO);

}
