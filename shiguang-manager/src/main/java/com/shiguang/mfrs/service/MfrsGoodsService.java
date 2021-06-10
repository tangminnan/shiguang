package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.MfrsGoodsDO;

import java.util.List;
import java.util.Map;

/**
 * 制造商与商品类别关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */
public interface MfrsGoodsService {
	
	MfrsGoodsDO get(Integer id);
	
	List<MfrsGoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MfrsGoodsDO mfrsGoods);
	
	int update(MfrsGoodsDO mfrsGoods);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
