package com.shiguang.stock.dao;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.WeiwaiDO;

import java.util.List;
import java.util.Map;

import com.shiguang.storeSales.domain.SalesDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 委外表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */
@Mapper
public interface WeiwaiDao {
	WeiwaiDO get(Long id);
	WeiwaiDO weiwaiOrder(WeiwaiDO weiwai);

	List<WeiwaiDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(WeiwaiDO weiwai);

	int update(WeiwaiDO weiwai);

	int remove(Long id);
	int removes(WeiwaiDO weiwaiDO);

	int removeSale(String saleNumber);

	int batchRemove(Long[] ids);


	DepartmentDO phoneOrAddres(Map<String,Object> map);
	List<SalesDO> selectOrder(Map<String, Object> map);
	int selectOrderCount(Map<String, Object> map);
	JpdzDO getBrandJp(String  num);
	YxdzDO getBrandYx(String  num);
	List<WeiwaiDO> selectWeiwaiOrder(Map<String, Object> map);

	int updateStatus(WeiwaiDO weiwaiDO);

	WeiwaiDO getCode(String  danjuNumber);


	List<WeiwaiDO>  weiwaiOrderOut(@Param("arrys") String[] arrys );



}
