package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RgpDO;

import java.util.List;
import java.util.Map;

/**
 * RGP表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
public interface RgpService {

    RgpDO get(Long rgpId);

    List<RgpDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RgpDO rgp);

    int saveRgp(ResultDO result);

    int update(RgpDO rgp);

    int remove(Long rgpId);

    int batchRemove(Long[] rgpIds);
}
