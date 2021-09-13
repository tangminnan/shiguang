package com.shiguang.stock.dao;

import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.TuihuoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 退货表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
@Mapper
public interface TuihuoDao {

	TuihuoDO get(Long id);
	
	List<TuihuoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TuihuoDO tuihuo);
	
	int update(TuihuoDO tuihuo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<StockDO> selectJingjia(Map<String, Object> map);

	List<StockDO> selectPeijian(Map<String, Object> map);

	List<StockDO> selectJpdz(Map<String, Object> map);

	List<StockDO> selectJpcp(Map<String, Object> map);

	List<StockDO> selectYxdz(Map<String, Object> map);

	List<StockDO> selectYxcp(Map<String, Object> map);

	List<StockDO> selectHly(Map<String, Object> map);

	List<StockDO> selectTyj(Map<String, Object> map);

	List<StockDO> selectLhj(Map<String, Object> map);

	List<StockDO> selectHc(Map<String, Object> map);

	List<StockDO> selectSg(Map<String, Object> map);
}
