package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.GoodsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 商品类别表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */
@Mapper
public interface GoodsDao {

	GoodsDO get(Integer goodsid);
	
	List<GoodsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsDO goods);
	
	int update(GoodsDO goods);
	
	int remove(Integer goodsid);
	
	int batchRemove(Integer[] goodsids);
}
