package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.VstDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜VST
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 16:38:36
 */
@Mapper
public interface VstDao {

    VstDO get(Long vstId);

    List<VstDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(VstDO vst);

    int saveVst(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long vst_id);
    int upremove(VstDO vstDO);
    int updatevst(VstDO vstDO);
    int batchRemove(Long[] vstIds);
    VstDO chufangall(@Param("ptometryNumber") String ptometryNumber, @Param("status") String status);


}
