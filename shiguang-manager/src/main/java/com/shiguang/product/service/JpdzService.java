package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.JpcpDO;
import com.shiguang.product.domain.JpdzDO;

import java.util.List;
import java.util.Map;

/**
 * 镜片定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
public interface JpdzService {

    JpdzDO get(Long id);

    List<JpdzDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    List<JpdzDO> listDz(Map<String, Object> map);

    int countDz(Map<String, Object> map);

    int save(JpdzDO jpdz);

    int update(JpdzDO jpdz);

    int remove(Long id);

    int batchRemove(Long[] ids);



    //删除修改状态
    int updateState(JpdzDO jpdz);

    //判断是否存在商品代码
    List<JpdzDO> haveNum(Map<String, Object> map);

    JpdzDO getJpdzInfomation(String goodNum);
}
