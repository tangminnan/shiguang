package com.shiguang.stock.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.domain.WeiwaikcDO;
import com.shiguang.stock.service.WeiwaiService;
import com.shiguang.stock.service.WeiwaikcService;
import com.shiguang.storeSales.domain.SalesDO;
import com.sun.tools.javac.code.Attribute;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 委外表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */

@Controller
@RequestMapping("/stock/weiwai")
public class WeiwaiController{
	@Autowired
	private WeiwaiService weiwaiService;
	@Autowired
	private DepartmentService departmentService;
	//配送
	@Autowired
	private LogStatusService statusService;
	//委外库存
	@Autowired
	private WeiwaikcService weiwaikcService;
	//仓位
	@Autowired
	private PositionService positionService;
	//商品类别
	@Autowired
	private GoodsService goodsService;


	@GetMapping()
	@RequiresPermissions("stock:weiwai:weiwai")
	String Weiwai() {
		return "stock/weiwai/weiwai";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwai:weiwai")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<WeiwaiDO> weiwaiList = weiwaiService.list(query);
		int total = weiwaiService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaiList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("stock:weiwai:add")
	String add(Model model) {
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
		String companyId = ShiroUtils.getUser().getCompanyId();
		if (companyId != null) {
			Integer companyid = Integer.valueOf(companyId);
//			String departNumber=ShiroUtils.getUser().getStoreNum();
			Map<String, Object> map = new HashMap<>();
			map.put("companyid", companyid);
			map.put("positionOrder", 2);
			DepartmentDO departmentDO = weiwaiService.phoneOrAddres(map);

			String departTel = departmentDO.getDepartTel();
			String departAddress = departmentDO.getDepartAddress();
			Long positionId = departmentDO.getPositionId();
			String positionName = departmentDO.getPositionName();
			model.addAttribute("departTel", departTel);
			model.addAttribute("departAddress", departAddress);
			model.addAttribute("positionId", positionId);
			model.addAttribute("positionName", positionName);
		} else if (companyId == null) {
			model.addAttribute("departTel", "");
			model.addAttribute("departAddress", "");
		}

		return "stock/weiwai/add";
	}

//	@GetMapping("/edit/{id}")
//	@RequiresPermissions("stock:weiwai:edit")
//	String edit(@PathVariable("id") Long id, Model model) {
//		WeiwaiDO weiwai = weiwaiService.get(id);
//		String time = weiwai.getDanjuDay();
//		model.addAttribute("weiwai", weiwai);
//		String eyeStyle = weiwai.getEyeStyle();
//		if (eyeStyle.equals("3")) {
//			model.addAttribute("eyeStyle", "框镜订做");
//		} else if (eyeStyle.equals("4")) {
//			model.addAttribute("eyeStyle", "隐形订做");
//		}
//		return "stock/weiwai/detial";
//	}
	//委外详情按钮跳转页面
	@GetMapping("/detial/{id}")
	@RequiresPermissions("stock:weiwai:detial")
	String detial(@PathVariable("id") Long id, Model model) {
		WeiwaiDO weiwai = weiwaiService.get(id);
		model.addAttribute("weiwai", weiwai);
		String eyeStyle = weiwai.getEyeStyle();
		if (eyeStyle.equals("3")) {
			model.addAttribute("eyeStyle", "框镜订做");
		} else if (eyeStyle.equals("4")) {
			model.addAttribute("eyeStyle", "隐形订做");
		}
		return "stock/weiwai/detial";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:weiwai:add")
	public R save(WeiwaiDO weiwai, WeiwaikcDO weiwaikcDO) {
		String danjuNumber = weiwai.getDanjuNumber();
		String danjuDay = weiwai.getDanjuDay();
		String eyeStyle = weiwai.getEyeStyle();
		String zhidanPeople = weiwai.getZhidanPeople();
		String mfrsid = weiwai.getMfrsid();
		String mfrsname = weiwai.getMfrsname();
		Long positionId = weiwai.getPositionId();
		String positionName = weiwai.getPositionName();
		String shouhuoPeople = weiwai.getShouhuoPeople();
		String shouhuoPhone = weiwai.getShouhuoPhone();
		String shouhuoAddress = weiwai.getShouhuoAddress();
		String beizhu = weiwai.getBeizhu();
		String status = weiwai.getStatus();
		String username = weiwai.getUsername();


		String gkname = weiwai.getGkname();
		String hyknum = weiwai.getHyknum();
		String phone = weiwai.getPhone();
		String salenumbery = weiwai.getSalenumbery();

		String  saleNumber1="";
		String  mirrorTime1 ="";
		String  goodsName1 ="";
		String  style1 ="";
		String  rl1 ="";
		String  count1 ="";
		String  sph1 ="";
		String  cyl1 ="";
		String  axial1 ="";
		String  diameter1 ="";
		String  jd1 ="";
		String  curvature1 ="";
		String  lightbelow1 ="";
		String  lengjing1 ="";
		String  yaoqiu1 ="";
		String fristgoodsname=weiwai.getGoodsName();
		String secendgoodsname=weiwai.getGoodsName2();
		if (null==fristgoodsname){

		}else {
			saleNumber1 = weiwai.getSaleNumber() ;
			mirrorTime1 = weiwai.getMirrorTime() ;
			goodsName1 = weiwai.getGoodsName() ;
			style1 = weiwai.getStyle() ;
			rl1 = weiwai.getRl() ;
			count1 = weiwai.getCount() ;
			sph1 = weiwai.getSph() ;
			cyl1 = weiwai.getCyl() ;
			axial1 = weiwai.getAxial() ;
			diameter1 = weiwai.getDiameter() ;
			if (weiwai.getJd() != null) {
				jd1 = weiwai.getJd() ;
			}
			if (weiwai.getCurvature() != null) {
				curvature1 = weiwai.getCurvature() ;
			}
			if (weiwai.getLightbelow() != null) {
				lightbelow1 = weiwai.getLightbelow() ;
			}
			if (weiwai.getLengjing() != null) {
				lengjing1 = weiwai.getLengjing() ;
			}
			if (weiwai.getYaoqiu() != null) {
				yaoqiu1 = weiwai.getYaoqiu() ;
			}
		}
		String saleNumber2 ="";
		String mirrorTime2 ="";
		String goodsName2 ="";
		String style2 ="";
		String rl2 ="";
		String count2 ="";
		String sph2 ="";
		String cyl2 ="";
		String axial2 ="";
		String diameter2 ="";
		String jd2 ="";
		String curvature2 ="";
		String lightbelow2 ="";
		String lengjing2 ="";
		String yaoqiu2 ="";
		if (null==secendgoodsname){

		}else {
			saleNumber2 = weiwai.getSaleNumber2() ;
			mirrorTime2 = weiwai.getMirrorTime2() ;
			goodsName2 = weiwai.getGoodsName2() ;
			style2 = weiwai.getStyle2() ;
			rl2 = weiwai.getRl2() ;
			count2 = weiwai.getCount2() ;
			sph2 = weiwai.getSph2() ;
			cyl2 = weiwai.getCyl2() ;
			axial2 = weiwai.getAxial2() ;
			diameter2 = weiwai.getDiameter2() ;
			if (weiwai.getJd2() != null) {
				jd2 = weiwai.getJd2() ;
			}
			if (weiwai.getCurvature2() != null) {
				curvature2 = weiwai.getCurvature2() ;
			}

			if (weiwai.getLightbelow2() != null) {
				lightbelow2 = weiwai.getLightbelow2() ;
			}

			if (weiwai.getLengjing2() != null) {
				lengjing2 = weiwai.getLengjing2() ;
			}
			if (weiwai.getYaoqiu2() != null) {
				yaoqiu2 = weiwai.getYaoqiu2() ;
			}
		}

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
			weiwaiDO.setPsname("");

			weiwaiDO.setSalenumbery(salenumbery);
			weiwaiDO.setPstime("");


			weiwaiDO.setGkname(gkname);
			weiwaiDO.setHyknum(hyknum);
			weiwaiDO.setPhone(phone);

			try {
				weiwaiDO.setSaleNumber(saleNumber1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSaleNumber("");
			}
			try {
				weiwaiDO.setMirrorTime(mirrorTime1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setMirrorTime("");
			}
			try {
				weiwaiDO.setGoodsName(goodsName1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setGoodsName("");
			}
			try {
				weiwaiDO.setStyle(style1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setStyle("");
			}
			try {
				weiwaiDO.setRl(rl1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setRl("");
			}

			try {
				weiwaiDO.setCount(count1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCount("");
			}
			try {
				weiwaiDO.setSph(sph1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSph("");
			}
			try {
				weiwaiDO.setCyl(cyl1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCyl("");
			}
			try {
				weiwaiDO.setAxial(axial1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setAxial("");
			}
			try {
				weiwaiDO.setJd(jd1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setJd("");
			}
			try {
				weiwaiDO.setCurvature(curvature1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCurvature("");
			}
			try {
				weiwaiDO.setDiameter(diameter1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setDiameter("");
			}
			try {
				weiwaiDO.setLightbelow(lightbelow1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLightbelow("");
			}
			try {
				weiwaiDO.setLengjing(lengjing1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLengjing("");
			}
			try {
				weiwaiDO.setYaoqiu(yaoqiu1);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setYaoqiu("");
			}
			////第2个

			try {
				weiwaiDO.setSaleNumber2(saleNumber2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSaleNumber2("");
			}
			try {
				weiwaiDO.setMirrorTime2(mirrorTime2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setMirrorTime2("");
			}
			try {
				weiwaiDO.setGoodsName2(goodsName2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setGoodsName2("");
			}
			try {
				weiwaiDO.setStyle2(style2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setStyle2("");
			}
			try {
				weiwaiDO.setRl2(rl2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setRl2("");
			}

			try {
				weiwaiDO.setCount2(count2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCount2("");
			}
			try {
				weiwaiDO.setSph2(sph2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setSph2("");
			}
			try {
				weiwaiDO.setCyl2(cyl2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCyl2("");
			}
			try {
				weiwaiDO.setAxial2(axial2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setAxial2("");
			}
			try {
				weiwaiDO.setJd2(jd2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setJd2("");
			}
			try {
				weiwaiDO.setCurvature2(curvature2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setCurvature2("");
			}
			try {
				weiwaiDO.setDiameter2(diameter2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setDiameter2("");
			}
			try {
				weiwaiDO.setLightbelow2(lightbelow2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLightbelow2("");
			}
			try {
				weiwaiDO.setLengjing2(lengjing2);
			} catch (ArrayIndexOutOfBoundsException e) {
				weiwaiDO.setLengjing2("");
			}
			try {
				weiwaiDO.setYaoqiu2(yaoqiu2);
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

			weiwaikcDO.setShTime("");
			weiwaikcDO.setShstatus("");
			weiwaikcDO.setPsname("");
			weiwaikcDO.setSalenumbery(salenumbery);
			weiwaikcDO.setPstime("");


			if (weiwaikcService.save(weiwaikcDO) > 0) {
				return R.ok();
			}
			return R.error();

	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwai:edit")
	public R update(WeiwaiDO weiwai) {
		weiwaiService.update(weiwai);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:remove")
	public R remove(Long id) {
		if (weiwaiService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		weiwaiService.batchRemove(ids);
		return R.ok();
	}

	//外部配镜单查询
	@GetMapping("/getGoods/{eyeStyle}/{mfrsid}/{mfrsname}/{zhidanPeople}")
	String getGoods(@PathVariable("eyeStyle") Integer eyeStyle, @PathVariable("mfrsid") String mfrsid,
					@PathVariable("mfrsname") String mfrsname, @PathVariable("zhidanPeople") String zhidanPeople, Model model) {
		//商品类别
		if (eyeStyle == 3) {
			model.addAttribute("eyeStyles", "框镜订做");
			model.addAttribute("eyeStyle", eyeStyle);
		} else if (eyeStyle == 4) {
			model.addAttribute("eyeStyles", "隐形订做");
			model.addAttribute("eyeStyle", eyeStyle);
		}
		model.addAttribute("mfrsid", mfrsid);
		model.addAttribute("zhidanPeople", zhidanPeople);
		model.addAttribute("mfrsname", mfrsname);
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
		if (null != ShiroUtils.getUser().getStoreNum()) {
			map.put("departNumber", ShiroUtils.getUser().getStoreNum());
		} else {
			map.put("departNumber", "");
		}
		model.addAttribute("departmentName", ShiroUtils.getUser().getStore());
//	return "/stock/weiwai/getGoods";
		return "/stock/weiwaishuju/add";
	}


	@GetMapping("/PeiJing/{eyeStyle}")
	String PeiJing(@PathVariable("eyeStyle") Integer eyeStyle, Model model) {
		model.addAttribute("eyeStyle", eyeStyle);
		return "/stock/weiwai/yuanPeiJing";
	}

	//销售单
	@ResponseBody
	@RequestMapping("/selectOrder")
	public PageUtils selectOrder(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		if ("3".equals(params.get("eyeStyle"))) {
			query.put("classtype", "2");
			query.put("eyeStyles", "框镜");
		} else if ("4".equals(params.get("eyeStyle"))) {
			query.put("classtype", "2");
			query.put("eyeStyles", "隐形");
		}
//		【只能查当前公司的】
		//———获取当前登录用户的公司id————
		String companyId = ShiroUtils.getUser().getCompanyId();
		if (companyId == null) {
			query.put("departNumber", "");
		} else if (companyId != null) {
			query.put("companyId", companyId);
		}

		query.put("saleType", 1);
		List<SalesDO> selectOrder = weiwaiService.selectOrder(query);
//		int total = weiwaiService.selectOrderCount(query);
		int total = 1000000;
		PageUtils pageUtils = new PageUtils(selectOrder, total);
		return pageUtils;
	}

	/**
	 * 输入工号
	 */
	@GetMapping("/userNum/{danjuNumber}")
	String userNum(@PathVariable("danjuNumber") String danjuNumber, Model model) {
		model.addAttribute("danjuNumber", danjuNumber);
		return "/stock/weiwai/userNum";
	}

	/**
	 * 收货状态
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus")
	public R updateEnable(String danjuNumber, String status, String username) {
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
		weiwaikcDO.setShTime(shTime);
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


	/**
	 * 配送输入工号
	 */
	@GetMapping("/userNumps/{salenumbery}/{danjuNumber}/{eyeStyle}/{yaoqiu}/{yaoqiu2}")
	String userNumps(@PathVariable("salenumbery") String salenumbery,
					 @PathVariable("danjuNumber") String danjuNumber,
					 @PathVariable("eyeStyle") String eyeStyle,
					 @PathVariable("yaoqiu") String yaoqiu,
					 @PathVariable("yaoqiu2") String yaoqiu2,Model model) {
		model.addAttribute("danjuNumber", danjuNumber);
		model.addAttribute("salenumbery", salenumbery);
		model.addAttribute("eyeStyle", eyeStyle);
		model.addAttribute("yaoqiu", yaoqiu);
		model.addAttribute("yaoqiu2", yaoqiu2);
		return "/stock/weiwai/userNumps";
	}

	/**
	 * 取镜处收货或者加工检验
	 */
	@PostMapping("/editShouhuo")
	@ResponseBody
	public R editShouhuo(String danjuNumber, String salenumbery, String shstatus, String psname,String eyeStyle,
						 String yaoqiu,String yaoqiu2) {
		LogStatusDO logStatusDO = new LogStatusDO();
		String [] array=yaoqiu.split(",");
		String [] array2=yaoqiu2.split(",");
		boolean flag=false;
		boolean flag2=false;
		flag = Arrays.asList(array).contains("委外代加工");
		flag2 = Arrays.asList(array2).contains("委外代加工");
		if ("3".equals(eyeStyle.trim())){//去除空格
			if(flag == true || flag2 == true){
				logStatusDO.setSaleNumber(salenumbery);
				logStatusDO.setLogisticStatus("配送");
				WorkRecoedDO workRecoedDO = new WorkRecoedDO();
				workRecoedDO.setUserName(psname);
				workRecoedDO.setType("配送");
				workRecoedDO.setDateTime(new Date());
				statusService.saveRecord(workRecoedDO);
			}else {
				logStatusDO.setSaleNumber(salenumbery);
				logStatusDO.setLogisticStatus("委外完成");
				WorkRecoedDO workRecoedDO = new WorkRecoedDO();
				workRecoedDO.setUserName(psname);
				workRecoedDO.setType("委外完成");
				workRecoedDO.setDateTime(new Date());
				statusService.saveRecord(workRecoedDO);
			}

		}else if ("4".equals(eyeStyle.trim())) {//去除空格
			logStatusDO.setSaleNumber(salenumbery);
			logStatusDO.setLogisticStatus("配送");
			WorkRecoedDO workRecoedDO = new WorkRecoedDO();
			workRecoedDO.setUserName(psname);
			workRecoedDO.setType("配送");
			workRecoedDO.setDateTime(new Date());
			statusService.saveRecord(workRecoedDO);
		}
		if (statusService.save(logStatusDO) > 0) {
			WeiwaiDO weiwaiDO = new WeiwaiDO();
			weiwaiDO.setDanjuNumber(danjuNumber);
			weiwaiDO.setShstatus(shstatus);
			weiwaiDO.setPsname(psname);
			//———获取当前系统时间—————
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
			Date date = new Date();
			String newDate = sdf.format(date);
			weiwaiDO.setPstime(newDate);
			weiwaiService.updateStatus(weiwaiDO);


			WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
			weiwaikcDO.setDanjuNumber(danjuNumber);
			weiwaikcDO.setShstatus(shstatus);
			weiwaikcDO.setPsname(psname);
			//———获取当前系统时间—————
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
			Date date1 = new Date();
			String newDate1 = sdf.format(date1);
			weiwaiDO.setPstime(newDate1);
			weiwaikcService.updateStatus(weiwaikcDO);
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 退货输入工号
	 */
	@GetMapping("/userNumth/{salenumbery}/{danjuNumber}")
	String userNumth(@PathVariable("salenumbery") String salenumbery,
					 @PathVariable("danjuNumber") String danjuNumber, Model model) {
		model.addAttribute("danjuNumber", danjuNumber);
		model.addAttribute("salenumbery", salenumbery);
		return "/stock/weiwai/userNumth";
	}

	/**
	 * 取镜处收货
	 */
	@PostMapping("/editTuihuo")
	@ResponseBody
	public R editTuihuo(String danjuNumber, String shstatus, String psname) {

		WeiwaiDO weiwaiDO = new WeiwaiDO();
		weiwaiDO.setDanjuNumber(danjuNumber);
		weiwaiDO.setShstatus(shstatus);
		weiwaiDO.setPsname(psname);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String newDate = sdf.format(date);
		weiwaiDO.setPstime(newDate);

		WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
		weiwaikcDO.setDanjuNumber(danjuNumber);
		weiwaikcDO.setShstatus(shstatus);
		weiwaikcDO.setPsname(psname);
		//———获取当前系统时间—————
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date1 = new Date();
		String newDate1 = sdf.format(date1);
		weiwaiDO.setPstime(newDate1);
		if (weiwaiService.updateStatus(weiwaiDO) > 0) {
			weiwaikcService.updateStatus(weiwaikcDO);
			return R.ok();
		}
		return R.error();
	}

}