package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.ProducaDO;

import java.util.List;
import java.util.Map;

/**
 * 计量单位表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 15:13:48
 */
public interface UnitService {

	UnitDO get(Integer unitid);

	List<UnitDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UnitDO unit);

	int update(UnitDO unit);

	int remove(Integer unitid);

	int batchRemove(Integer[] unitids);
}
