package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.product.domain.HcDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.WeiwaikcDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.WeiwaikcService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.WeiwaiService;

/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */
 
@Controller
@RequestMapping("/stock/weiwai")
public class WeiwaiController {
	@Autowired
	private WeiwaiService weiwaiService;
	@Autowired
	private DepartmentService departmentService;

	//委外库存
	@Autowired
	private WeiwaikcService weiwaikcService;

	@GetMapping()
	@RequiresPermissions("stock:weiwai:weiwai")
	String Weiwai(){
	    return "stock/weiwai/weiwai";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwai:weiwai")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WeiwaiDO> weiwaiList = weiwaiService.list(query);
		int total = weiwaiService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwai:add")
	String add(Model model){
		//———生成单据编号————
		Long uuid = GuuidUtil.getUUID();
		String danjuNumber = "OUT" + uuid.toString();
		model.addAttribute("danjuNumber", danjuNumber);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String danjuDay = sdf.format(date);
		model.addAttribute("danjuDay", danjuDay);
		//———获取当前登录用户的名称————
		model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId != null){
			Integer companyid=Integer.valueOf(companyId);
//			String departNumber=ShiroUtils.getUser().getStoreNum();
			Map<String, Object> map = new HashMap<>();
			map.put("companyid",companyid);
			map.put("positionOrder",2);
			DepartmentDO departmentDO= weiwaiService.phoneOrAddres(map);

			String departTel=departmentDO.getDepartTel();
			String departAddress=departmentDO.getDepartAddress();
			Long positionId=departmentDO.getPositionId();
			String positionName=departmentDO.getPositionName();
			model.addAttribute("departTel",departTel);
			model.addAttribute("departAddress",departAddress);
			model.addAttribute("positionId",positionId);
			model.addAttribute("positionName",positionName);
		}else if (companyId == null){
			model.addAttribute("departTel","");
			model.addAttribute("departAddress","");
		}

		return "stock/weiwai/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:weiwai:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WeiwaiDO weiwai = weiwaiService.get(id);
		String time = weiwai.getDanjuDay();
		model.addAttribute("weiwai", weiwai);
		String eyeStyle=weiwai.getEyeStyle();
		if (eyeStyle.equals("3")){
			model.addAttribute("eyeStyle","框镜订做");
		}else if (eyeStyle.equals("4")){
			model.addAttribute("eyeStyle","隐形订做");
		}
	    return "stock/weiwai/detial";
	}
	@GetMapping("/detial/{id}")
	@RequiresPermissions("stock:weiwai:detial")
	String detial(@PathVariable("id") Long id,Model model){
		WeiwaiDO weiwai = weiwaiService.get(id);
		model.addAttribute("weiwai", weiwai);
		String eyeStyle=weiwai.getEyeStyle();
		if (eyeStyle.equals("3")){
			model.addAttribute("eyeStyle","框镜订做");
		}else if (eyeStyle.equals("4")){
			model.addAttribute("eyeStyle","隐形订做");
		}
	    return "stock/weiwai/detial";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:weiwai:add")
	public R save(WeiwaiDO weiwai , WeiwaikcDO weiwaikcDO){
		String danjuNumber=weiwai.getDanjuNumber();
		String danjuDay=weiwai.getDanjuDay();
		String eyeStyle=weiwai.getEyeStyle();
		String zhidanPeople=weiwai.getZhidanPeople();
		String mfrsid=weiwai.getMfrsid();
		String mfrsname=weiwai.getMfrsname();
		Long positionId=weiwai.getPositionId();
		String positionName=weiwai.getPositionName();
		String shouhuoPeople=weiwai.getShouhuoPeople();
		String shouhuoPhone=weiwai.getShouhuoPhone();
		String shouhuoAddress=weiwai.getShouhuoAddress();
		String beizhu=weiwai.getBeizhu();
		String status=weiwai.getStatus();
		String username=weiwai.getUsername();


		String gkname=weiwai.getGkname();
		String hyknum=weiwai.getHyknum();
		String phone=weiwai.getPhone();


		String[] saleNumber1=weiwai.getSaleNumber().split(",");


		String[] mirrorTime1=weiwai.getMirrorTime().split(",");
		String[] goodsName1=weiwai.getGoodsName().split(",");
		String[] style1=weiwai.getStyle().split(",");
		String[] rl1=weiwai.getRl().split(",");
		String[] count1=weiwai.getCount().split(",");
		String[] sph1=weiwai.getSph().split(",");
		String[] cyl1=weiwai.getCyl().split(",");
		String[] axial1=weiwai.getAxial().split(",");

		String[] diameter1=weiwai.getDiameter().split(",");


		String[] jd1 = new String[0];
		if (weiwai.getJd() !=null){
			jd1=weiwai.getJd().split(",");
		}
		String[] curvature1 = new String[0];
		if (weiwai.getCurvature()!=null){
			curvature1=weiwai.getCurvature().split(",");
		}
		String[] lightbelow1 = new String[0];
		if (weiwai.getLightbelow()!=null){
			lightbelow1=weiwai.getLightbelow().split(",");
		}
		String[] lengjing1 = new String[0];
		if (weiwai.getLengjing()!=null){
			lengjing1=weiwai.getLengjing().split(",");
		}
		String[] yaoqiu1 = new String[0];
		if (weiwai.getYaoqiu()!=null){
			yaoqiu1=weiwai.getYaoqiu().split(",");
		}



		String[] saleNumber2=weiwai.getSaleNumber2().split(",");
		String[] mirrorTime2=weiwai.getMirrorTime2().split(",");
		String[] goodsName2=weiwai.getGoodsName2().split(",");
		String[] style2=weiwai.getStyle2().split(",");
		String[] rl2=weiwai.getRl2().split(",");
		String[] count2=weiwai.getCount2().split(",");
		String[] sph2=weiwai.getSph2().split(",");
		String[] cyl2=weiwai.getCyl2().split(",");
		String[] axial2=weiwai.getAxial2().split(",");
		String[] diameter2=weiwai.getDiameter2().split(",");
		String[] jd2 = new String[0];
		if (weiwai.getJd2() !=null){
			jd2=weiwai.getJd2().split(",");
		}
		String[] curvature2 = new String[0];
		if (weiwai.getCurvature2()!=null){
			curvature2=weiwai.getCurvature2().split(",");
		}
		String[] lightbelow2 = new String[0];
		if (weiwai.getLightbelow2()!=null){
			lightbelow2=weiwai.getLightbelow2().split(",");
		}
		String[] lengjing2 = new String[0];
		if (weiwai.getLengjing2()!=null){
			lengjing2=weiwai.getLengjing2().split(",");
		}
		String[] yaoqiu2 = new String[0];
		if (weiwai.getYaoqiu2()!=null){
			yaoqiu2=weiwai.getYaoqiu2().split(",");
		}

		for (int i = 0; i < saleNumber1.length; i++) {
			WeiwaiDO weiwaiDO = new WeiwaiDO();
			weiwaiDO.setDanjuNumber(danjuNumber);
			weiwaiDO.setDanjuDay(danjuDay);
			weiwaiDO.setEyeStyle(eyeStyle);
			weiwaiDO.setZhidanPeople(zhidanPeople);
			weiwaiDO.setMfrsid(mfrsid);
			weiwaiDO.setMfrsname(mfrsname);
			weiwaiDO.setPositionId(positionId);
			weiwaiDO.setPositionName(positionName);
			weiwaiDO.setShouhuoPeople(shouhuoPeople);
			weiwaiDO.setShouhuoPhone(shouhuoPhone);
			weiwaiDO.setShouhuoAddress(shouhuoAddress);
			weiwaiDO.setBeizhu(beizhu);
			weiwaiDO.setStatus(status);
			weiwaiDO.setUsername(username);
			weiwaiDO.setShTime("");
			weiwaiDO.setShstatus("");

			weiwaiDO.setGkname(gkname);
			weiwaiDO.setHyknum(hyknum);
			weiwaiDO.setPhone(phone);

			try {
				String saleNumber = saleNumber1[i];
				weiwaiDO.setSaleNumber(saleNumber);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSaleNumber("");
			}
			try {
				String mirrorTime = mirrorTime1[i];
				weiwaiDO.setMirrorTime(mirrorTime);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setMirrorTime("");
			}
			try {
				String goodsName = goodsName1[i];
				weiwaiDO.setGoodsName(goodsName);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setGoodsName("");
			}
			try {
				String style = style1[i];
				weiwaiDO.setStyle(style);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setStyle("");
			}
			try {
				String rl = rl1[i];
				weiwaiDO.setRl(rl);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setRl("");
			}

			try {
				String count = count1[i];
				weiwaiDO.setCount(count);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCount("");
			}
			try {
				String sph = sph1[i];
				weiwaiDO.setSph(sph);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSph("");
			}
			try {
				String cyl = cyl1[i];
				weiwaiDO.setCyl(cyl);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCyl("");
			}
			try {
				String axial = axial1[i];
				weiwaiDO.setAxial(axial);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setAxial("");
			}
			try {
				String jd = jd1[i];
				weiwaiDO.setJd(jd);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setJd("");
			}
			try {
				String curvature = curvature1[i];
				weiwaiDO.setCurvature(curvature);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCurvature("");
			}
			try {
				String diameter = diameter1[i];
				weiwaiDO.setDiameter(diameter);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setDiameter("");
			}
			try {
				String lightbelow = lightbelow1[i];
				weiwaiDO.setLightbelow(lightbelow);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLightbelow("");
			}
			try {
				String lengjing = lengjing1[i];
				weiwaiDO.setLengjing(lengjing);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLengjing("");
			}
			try {
				String yaoqiu = yaoqiu1[i];
				weiwaiDO.setYaoqiu(yaoqiu);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setYaoqiu("");
			}
			////第2个

			try {
				String saleNumber = saleNumber2[i];
				weiwaiDO.setSaleNumber2(saleNumber);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSaleNumber2("");
			}
			try {
				String mirrorTime = mirrorTime2[i];
				weiwaiDO.setMirrorTime2(mirrorTime);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setMirrorTime2("");
			}
			try {
				String goodsName = goodsName2[i];
				weiwaiDO.setGoodsName2(goodsName);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setGoodsName2("");
			}
			try {
				String style = style2[i];
				weiwaiDO.setStyle2(style);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setStyle2("");
			}
			try {
				String rl = rl2[i];
				weiwaiDO.setRl2(rl);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setRl2("");
			}

			try {
				String count = count2[i];
				weiwaiDO.setCount2(count);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCount2("");
			}
			try {
				String sph = sph2[i];
				weiwaiDO.setSph2(sph);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSph2("");
			}
			try {
				String cyl = cyl2[i];
				weiwaiDO.setCyl2(cyl);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCyl2("");
			}
			try {
				String axial = axial2[i];
				weiwaiDO.setAxial2(axial);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setAxial2("");
			}
			try {
				String jd = jd2[i];
				weiwaiDO.setJd2(jd);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setJd2("");
			}
			try {
				String curvature = curvature2[i];
				weiwaiDO.setCurvature2(curvature);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCurvature2("");
			}
			try {
				String diameter = diameter2[i];
				weiwaiDO.setDiameter2(diameter);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setDiameter2("");
			}
			try {
				String lightbelow = lightbelow2[i];
				weiwaiDO.setLightbelow2(lightbelow);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLightbelow2("");
			}
			try {
				String lengjing = lengjing2[i];
				weiwaiDO.setLengjing2(lengjing);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLengjing2("");
			}
			try {
				String yaoqiu = yaoqiu2[i];
				weiwaiDO.setYaoqiu2(yaoqiu);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setYaoqiu2("");
			}

			weiwaiService.save(weiwaiDO);


				weiwaikcDO.setPositionId(weiwai.getPositionId().toString());
				weiwaikcDO.setGkname(weiwai.getGkname());
				weiwaikcDO.setHyknum(weiwai.getHyknum());
				weiwaikcDO.setPhone(weiwai.getPhone());
				weiwaikcDO.setDanjuNumber(weiwai.getDanjuNumber());
				weiwaikcDO.setSaleNumber(weiwai.getSaleNumber());
				weiwaikcDO.setMirrorTime(weiwai.getMirrorTime());
				weiwaikcDO.getGoodsName(weiwai.getGoodsName());
				weiwaikcDO.getCount(weiwai.getCount());


				weiwaikcDO.setSaleNumber2(weiwai.getSaleNumber2());
				weiwaikcDO.setMirrorTime2(weiwai.getMirrorTime2());
				weiwaikcDO.setGoodsName2(weiwai.getGoodsName2());
				weiwaikcDO.getCount2(weiwai.getCount2());
				weiwaikcDO.getStatus(weiwai.getStatus());
				weiwaikcDO.getShTime();
				weiwaikcDO.getShstatus();



			if(weiwaikcService.save(weiwaikcDO)>0){
				return R.ok();
			}
			return R.error();
			}

		return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwai:edit")
	public R update( WeiwaiDO weiwai){
		weiwaiService.update(weiwai);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:remove")
	public R remove( Long id){
		if(weiwaiService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		weiwaiService.batchRemove(ids);
		return R.ok();
	}

//外部配镜单查询
@GetMapping("/getGoods/{eyeStyle}/{mfrsid}/{mfrsname}/{zhidanPeople}")
String getGoods(@PathVariable("eyeStyle") Integer eyeStyle,@PathVariable("mfrsid") String  mfrsid,
				@PathVariable("mfrsname") String mfrsname, @PathVariable("zhidanPeople") String zhidanPeople, Model model) {
	//商品类别
	if (eyeStyle == 3){
		model.addAttribute("eyeStyles", "框镜订做");
		model.addAttribute("eyeStyle", eyeStyle);
	}else if (eyeStyle == 4){
		model.addAttribute("eyeStyles", "隐形订做");
		model.addAttribute("eyeStyle", eyeStyle);
	}
	model.addAttribute("mfrsid",mfrsid);
	model.addAttribute("zhidanPeople",zhidanPeople);
	model.addAttribute("mfrsname",mfrsname);
	//———生成单据编号————
	Long uuid = GuuidUtil.getUUID();
	String danjunum = "W" + uuid.toString();
	model.addAttribute("danjunum", danjunum);

	//———获取当前系统时间—————
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
	Date date = new Date();
	String newDate = sdf.format(date);
	model.addAttribute("danjuDay", newDate);
	//部门
	Map<String, Object> map = new HashMap<>();
	//———获取当前登录用户的公司id————
	//String departNumber=ShiroUtils.getUser().getStoreNum();
	if(null != ShiroUtils.getUser().getStoreNum()){
		map.put("departNumber",ShiroUtils.getUser().getStoreNum());
	}else {
		map.put("departNumber","");
	}
	model.addAttribute("departmentName",ShiroUtils.getUser().getStore());
//	return "/stock/weiwai/getGoods";
	return "/stock/weiwaishuju/add";
}



	@GetMapping("/PeiJing/{eyeStyle}")
	String PeiJing(@PathVariable("eyeStyle") Integer eyeStyle, Model model) {
		model.addAttribute("eyeStyle",eyeStyle);
		return "/stock/weiwai/yuanPeiJing";
	}
	//销售单
	@ResponseBody
	@RequestMapping(value = "/selectOrder")
	public List<SalesDO> orderList(Integer eyeStyle, Model model) {
		Map<String, Object> map = new HashMap<>();
		if (eyeStyle == 3){
			map.put("classtype", "2");
			map.put("eyeStyles", "框镜");
		}else if (eyeStyle == 4){
			map.put("classtype", "2");
			map.put("eyeStyles", "隐形");
		}
//		【只能查当前公司的】
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			map.put("departNumber","");
		}else if (companyId != null){
			map.put("companyId",companyId);
		}
		map.put("isSale",1);
		List<SalesDO> selectOrder = weiwaiService.selectOrder(map);
		model.addAttribute("selectOrder", selectOrder);
		return selectOrder;
	}

	/**
	 * 输入工号
	 */
	@GetMapping("/userNum/{danjuNumber}")
	String userNum(@PathVariable("danjuNumber") String danjuNumber ,Model model) {
		model.addAttribute("danjuNumber",danjuNumber);
		return "/stock/weiwai/userNum";
	}

	/**
	 * 收货状态
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus")
	public R updateEnable(String danjuNumber, String status ,String username) {
		WeiwaiDO weiwaiDO = new WeiwaiDO();
		weiwaiDO.setDanjuNumber(danjuNumber);
		weiwaiDO.setStatus(status);
		weiwaiDO.setUsername(username);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String shTime = sdf.format(date);
		weiwaiDO.setShTime(shTime);
		weiwaiService.updateStatus(weiwaiDO);

		WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
		weiwaikcDO.setDanjuNumber(danjuNumber);
		weiwaikcDO.setStatus(status);
		weiwaikcDO.setUsername(username);
		weiwaikcService.updateStatus(weiwaikcDO);

		return R.ok();
	}

	//打印镜框
	@GetMapping("/jkPeijingdan")
	String jkPeijingdan(String danjuNumber, Model model) {
		WeiwaiDO weiwaiDO = weiwaiService.jkPeijingdan(danjuNumber);
		model.addAttribute("weiwaiDO", weiwaiDO);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String dayinDay = sdf.format(date);
		model.addAttribute("dayinDay", dayinDay);
		return "/stock/weiwai/jkPeijingdan";
	}
	//打印隐形src/main/resources/templates/stock/weiwai/.html:84
	@GetMapping("/yxPeijingdan")
	String yxPeijingdan(String danjuNumber, Model model) {
		WeiwaiDO weiwaiDO = weiwaiService.yxPeijingdan(danjuNumber);
		model.addAttribute("weiwaiDO", weiwaiDO);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String dayinDay = sdf.format(date);
		model.addAttribute("dayinDay", dayinDay);
		return "/stock/weiwai/yxPeijingdan";
	}
}
