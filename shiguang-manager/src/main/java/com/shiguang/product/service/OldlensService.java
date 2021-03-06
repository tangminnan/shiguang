package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.OldlensDO;

import java.util.List;
import java.util.Map;

/**
 * 老花镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */
public interface OldlensService {

    OldlensDO get(Long id);

    List<OldlensDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OldlensDO oldlens);

    int update(OldlensDO oldlens);

    int remove(Long id);

    int batchRemove(Long[] ids);



    //删除修改状态
    int updateState(OldlensDO oldlens);

    //判断是否存在商品代码
    List<OldlensDO> haveNum(Map<String, Object> map);

    OldlensDO getOldlenInfomation(String goodNum);
}
