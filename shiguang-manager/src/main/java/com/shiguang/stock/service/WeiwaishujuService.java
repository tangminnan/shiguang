package com.shiguang.stock.service;

import com.shiguang.stock.domain.WeiwaishujuDO;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2022-01-22 15:26:34
 */
public interface WeiwaishujuService {

	WeiwaishujuDO get(Long id);

	List<WeiwaishujuDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(WeiwaishujuDO weiwaishuju);

	int update(WeiwaishujuDO weiwaishuju);

	int remove(Long id);
	int removes(String saleNumber);

	int batchRemove(Long[] ids);

	List<WeiwaishujuDO> getWeiwaiShuju(Map<String, Object> map);

}
