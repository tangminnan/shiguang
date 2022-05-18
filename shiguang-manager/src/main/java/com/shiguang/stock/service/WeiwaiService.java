package com.shiguang.stock.service;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.InterestService;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.stock.dao.WeiwaiDao;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */
public interface WeiwaiService {
	
	WeiwaiDO get(Long id);
	WeiwaiDO weiwaiOrder(WeiwaiDO weiwai);


	List<WeiwaiDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(WeiwaiDO weiwai);
	
	int update(WeiwaiDO weiwai);
	
	int remove(Long id);
	int removes(WeiwaiDO weiwaiDO);

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

	void weiwaiOut(@Param("arrys") String[] arrys,HttpServletRequest request, HttpServletResponse response);


























//	//配镜单
//	List<WeiwaiDO> weiwailist(Map<String, Object> map);
//	int countList(Map<String, Object> map);
//	//部门
//	List<DepartmentDO> selectDepartment(Map<String,Object> map);
//	//委外框镜配镜单List
//	List<WeiwaiDO> jkPeijingdanList(Map<String, Object> map);
//	//委外隐形配镜单
//	WeiwaiDO yxPeijingdan(String danjuNumber);
//	//委外隐形配镜单List
//	List<WeiwaiDO> yxPeijingdanList(Map<String, Object> map);

//	//打印单查询品牌名称
//	BrandDO jkbrandname(Map<String, Object> maps);
}
