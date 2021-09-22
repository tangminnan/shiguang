package com.shiguang.stock.service;

import com.shiguang.product.domain.*;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.TuihuoDO;

import java.util.List;
import java.util.Map;

/**
 * 退货表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
public interface TuihuoService {
	
	TuihuoDO get(Long id);
	
	List<TuihuoDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

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

	List<TuihuoDO> orderList(Map<String, Object> map);
	int orderCount(Map<String, Object> map);
	//查订单
	List<TuihuoDO> selectOrder(Map<String, Object> map);

	//打印
	TuihuoDO getDanju(String tuihuoNum);
	List<TuihuoDO> getDanjuList(Map<String, Object> map);


}
