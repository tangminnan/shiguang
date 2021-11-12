package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.CrtDO;
import com.shiguang.jiancha.domain.ResultDO;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜CRT
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:00:46
 */
public interface CrtService {

    CrtDO get(Long crtId);

    List<CrtDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CrtDO crt);

    int saveCrt(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long crtId);
    int upremove(CrtDO crtDO );
    int updatecrt(CrtDO crtDO);
    int batchRemove(Long[] crtIds);
    CrtDO chufangall(String ptometryNumber,String status);

}
