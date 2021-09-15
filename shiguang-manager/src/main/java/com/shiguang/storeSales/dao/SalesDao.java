package com.shiguang.storeSales.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.storeSales.domain.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店销售
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-06 15:09:24
 */
@Mapper
public interface SalesDao {

	SalesDO get(Long id);
	
	List<SalesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SalesDO sales);
	
	int update(SalesDO sales);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<EyesWay> findWay(Map<String,Object> map);

	SalesDO findDataByNumber(Map<String,Object> map);

	List<ZipianDO> findZpian(Map<String,Object> map);

	List<ZijiaDO> findZjia(Map<String,Object> map);

	int countZpian(Map<String, Object> map);

	int countZjia(Map<String, Object> map);

	List<Conclusion> findAll(Map<String,Object> map);

	List<SalesDO> peijinglist(Map<String,Object> map);

	int peijingcount(Map<String,Object> map);

	SalesDO getSaleNumber(String saleNumber);

	List<SalesDO> salelist(Map<String, Object> map);

	int salecount(Map<String, Object> map);

}
