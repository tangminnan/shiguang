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

	int batchRemove(Long[] ids);


	//电话地址仓位
	DepartmentDO phoneOrAddres(Map<String,Object> map);
	//查询配镜单
	List<SalesDO> selectOrder(Map<String, Object> map);
	int selectOrderCount(Map<String, Object> map);
	//	商品品牌信息
	JpdzDO getBrand(String  num);
	//委外详情列表
	List<WeiwaiDO> selectWeiwaiOrder(Map<String, Object> map);

	//<!--确认收货   [配送][][退回][][][]-->
	int updateStatus(WeiwaiDO weiwaiDO);

	//	//条码
	WeiwaiDO getCode(String  danjuNumber);


	//信息导出
	List<WeiwaiDO>  weiwaiOrderOut(@Param("arrys") String[] arrys );


//	//配镜单
//	List<WeiwaiDO> weiwailist(Map<String, Object> map);
//	int countList(Map<String, Object> map);
//
//	//部门
//	List<DepartmentDO> selectDepartment(Map<String,Object> map);
////<!--确认收货   [配送][][退回][][][]-->
//	int updateStatus(WeiwaiDO weiwaiDO);
//
//	//委外镜框配镜单
//	WeiwaiDO jkPeijingdan(String danjuNumber);
//	//委外框镜配镜单List
//	List<WeiwaiDO> jkPeijingdanList(Map<String, Object> map);
//
//	//委外隐形配镜单
//	WeiwaiDO yxPeijingdan(String danjuNumber);
//	//委外隐形配镜单List
//	List<WeiwaiDO> yxPeijingdanList(Map<String, Object> map);
//	//确认收获库存偶没有
//	WeiwaiDO weiwaiOrder(String  danjuNumber);
//
//
//	//打印单查询品牌名称
//	BrandDO jkbrandname(Map<String, Object> maps);

}
