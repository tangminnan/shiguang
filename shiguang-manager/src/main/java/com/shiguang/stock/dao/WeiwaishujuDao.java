package com.shiguang.stock.dao;

import com.shiguang.stock.domain.WeiwaishujuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2022-01-22 15:26:34
 */
@Mapper
public interface WeiwaishujuDao {

	WeiwaishujuDO get(Long id);

	List<WeiwaishujuDO> list(Map<String,Object> map);

	int count(Map<String,Object> map);

	int save(WeiwaishujuDO weiwaishuju);

	int update(WeiwaishujuDO weiwaishuju);

	int remove(Long id);
	int removes(String saleNumber);
	int batchRemove(Long[] ids);
	List<WeiwaishujuDO> getWeiwaiShuju(Map<String, Object> map);
}
