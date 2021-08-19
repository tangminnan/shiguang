package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.JpcpDO;

import java.util.List;
import java.util.Map;

/**
 * 镜片成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
public interface JpcpService {

    JpcpDO get(Long id);

    List<JpcpDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(JpcpDO jpcp);

    //修改停用启用
    int update(JpcpDO jpcp);

    int remove(Long id);

    int batchRemove(Long[] ids);


    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);

    //删除修改状态
    int updateState(JpcpDO jpcp);
    //判断是否存在商品代码
    List<JpcpDO> haveNum(Map<String, Object> map);
}
