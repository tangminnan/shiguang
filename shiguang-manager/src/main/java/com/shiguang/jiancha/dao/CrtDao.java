package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.CrtDO;
import com.shiguang.jiancha.domain.ResultDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜CRT
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:00:46
 */
@Mapper
public interface CrtDao {

    CrtDO get(Long crtId);

    List<CrtDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CrtDO crt);

    int saveCrt(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);

    int remove(Long crt_id);
    int upremove(CrtDO crtDO);

    int batchRemove(Long[] crtIds);
}
