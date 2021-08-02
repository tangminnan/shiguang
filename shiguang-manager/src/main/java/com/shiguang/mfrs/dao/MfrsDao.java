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

    //判断是否存在制造商代码
    List<MfrsDO> haveNum(Map<String, Object> map);

    //	//-----商品查询-------
    List<MfrsDO> list(Map<String, Object> map);

    //    <!--查询制造商-->
    List<MfrsDO> findMfrs(Map<String, Object> map);

    //    <!--查询镜架制造商-->
    List<MfrsDO> producaList(Map<String, Object> map);

    //    <!--查询配件制造商-->
    List<MfrsDO> partsList(Map<String, Object> map);

    //    <!--查询镜片成片制造商-->
    List<MfrsDO> jpcpList(Map<String, Object> map);

    //    <!--查询隐形成片制造商-->
    List<MfrsDO> yxcpList(Map<String, Object> map);

    //    <!--查询护理液制造商-->
    List<MfrsDO> hlyList(Map<String, Object> map);

    // <!--查询太阳镜制造商-->
    List<MfrsDO> tyjList(Map<String, Object> map);

    //    <!--查询老花镜制造商-->
    List<MfrsDO> oldlensList(Map<String, Object> map);

    //    <!--查询耗材制造商-->
    List<MfrsDO> hcList(Map<String, Object> map);

    //    <!--查询视光制造商-->
    List<MfrsDO> shiguangList(Map<String, Object> map);

    int mgcount(Map<String, Object> map);

    int save(MfrsDO mfrs);

    //修改停用启用
    int update(MfrsDO mfrs);

    int remove(Integer mfrsid);

    int batchRemove(Integer[] mfrsids);

    //删除修改状态
    int updateState(MfrsDO mfrs);

}
