package com.shiguang.stock.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.product.domain.HcDO;
import com.shiguang.stock.domain.OrderDO;
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

import com.shiguang.stock.domain.WeiwaishujuDO;
import com.shiguang.stock.service.WeiwaishujuService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-18 18:14:35
 */
 
@Controller
@RequestMapping("/stock/weiwaishuju")
public class WeiwaishujuController {
	@Autowired
	private WeiwaishujuService weiwaishujuService;
	
	@GetMapping()
	@RequiresPermissions("stock:weiwaishuju:weiwaishuju")
	String Weiwaishuju(){
	    return "stock/weiwaishuju/weiwaishuju";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwaishuju:weiwaishuju")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WeiwaishujuDO> weiwaishujuList = weiwaishujuService.list(query);
		int total = weiwaishujuService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaishujuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwaishuju:add")
	String add(){
	    return "stock/weiwaishuju/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:weiwaishuju:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WeiwaishujuDO weiwaishuju = weiwaishujuService.get(id);
		model.addAttribute("weiwaishuju", weiwaishuju);
	    return "stock/weiwaishuju/edit";
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( WeiwaishujuDO weiwaishuju){

		String qjtime=weiwaishuju.getTimetime();
		if ("".equals(qjtime)){
				return R.error("取镜时间不能为空！");
		}
		String number= weiwaishuju.getNumber();
		String danjuDay= weiwaishuju.getDanjuDay();
		String zhidanPeople= weiwaishuju.getZhidanPeople();
		String jpStyle= weiwaishuju.getJcStyle();
		String timetime= weiwaishuju.getTimetime();
		String danjuStyle= weiwaishuju.getDanjuStyle();
		String weiwaiStyle= weiwaishuju.getWeiwaiStyle();
		String beizhu= weiwaishuju.getBeizhu();

		if("框镜订做".equals(jpStyle)){
			String[] saleNumbers =weiwaishuju.getSaleNumber().split(",");
			String[] nums =weiwaishuju.getNum().split(",");
			String[] codes =weiwaishuju.getCode().split(",");
			String[] names =weiwaishuju.getName().split(",");
			String[] leftRights =weiwaishuju.getLeftRight().split(",");
			String[] counts =weiwaishuju.getCount().split(",");
			String[] yaoqius =weiwaishuju.getYaoqiu().split(",");
			String[] sphs =weiwaishuju.getSph().split(",");
			String[] cyls =weiwaishuju.getCyl().split(",");
			String[] zxs =weiwaishuju.getZx().split(",");
			String[] adds =weiwaishuju.getAdd().split(",");
			String[] sljs =weiwaishuju.getSlj().split(",");
			String[] jds =weiwaishuju.getJd().split(",");
			String[] fartjs =weiwaishuju.getFartj().split(",");
			String[] neartjs =weiwaishuju.getNeartj().split(",");
			String[] tgs =weiwaishuju.getTg().split(",");
			String[] gknames =weiwaishuju.getGkname().split(",");
			String[] hyknums =weiwaishuju.getHyknum().split(",");
			String[] phones =weiwaishuju.getPhone().split(",");
			String[] departnames =weiwaishuju.getDepartname().split(",");
			for(int a=0;a<nums.length;a++){
				WeiwaishujuDO weiwaishujuDO=new WeiwaishujuDO();
				weiwaishujuDO.setNumber(number);
				weiwaishujuDO.setDanjuDay(danjuDay);
				weiwaishujuDO.setZhidanPeople(zhidanPeople);
				weiwaishujuDO.setJcStyle(jpStyle);
				weiwaishujuDO.setTimetime(timetime);
				weiwaishujuDO.setDanjuStyle(danjuStyle);
				try {
					String saleNumber = saleNumbers[a];
					weiwaishujuDO.setSaleNumber(saleNumber);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setSaleNumber("");
				}
				weiwaishujuDO.setWeiwaiStyle(weiwaiStyle);
				weiwaishujuDO.setBeizhu(beizhu);
				try {
					String sph = sphs[a];
					weiwaishujuDO.setSph(sph);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setSph("");
				}
				try {
					String cyl = cyls[a];
					weiwaishujuDO.setCyl(cyl);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCyl("");
				}
				try {
					String zx = zxs[a];
					weiwaishujuDO.setZx(zx);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setZx("");
				}
				try {
					String add = adds[a];
					weiwaishujuDO.setAdd(add);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setAdd("");
				}
				try {
					String slj = sljs[a];
					weiwaishujuDO.setSlj(slj);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setSlj("");
				}
				try {
					String jd = jds[a];
					weiwaishujuDO.setJd(jd);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setJd("");
				}
				try {
					String fartj = fartjs[a];
					weiwaishujuDO.setFartj(fartj);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setFartj("");
				}
				try {
					String neartj = neartjs[a];
					weiwaishujuDO.setNeartj(neartj);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setNeartj("");
				}
				try {
					String tg = tgs[a];
					weiwaishujuDO.setTg(tg);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setTg("");
				}
				try {
					String num = nums[a];
					weiwaishujuDO.setNum(num);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setNum("");
				}
				try {
					String code = codes[a];
					weiwaishujuDO.setCode(code+"00000000");
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCode("");
				}
				try {
					String name = names[a];
					weiwaishujuDO.setName(name);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setName("");
				}
				try {
					String leftRight = leftRights[a];
					weiwaishujuDO.setLeftRight(leftRight);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setLeftRight("");
				}
				try {
					String count = counts[a];
					weiwaishujuDO.setCount(count);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCount("");
				}
				try {
					String yaoqiu = yaoqius[a];
					weiwaishujuDO.setYaoqiu(yaoqiu);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setYaoqiu("");
				}
				try {
					String gkname = gknames[a];
					weiwaishujuDO.setGkname(gkname);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setGkname("");
				}
				try {
					String hyknum = hyknums[a];
					weiwaishujuDO.setHyknum(hyknum);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setHyknum("");
				}
				try {
					String phone = phones[a];
					weiwaishujuDO.setPhone(phone);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setPhone("");
				}
				try {
					String departname = departnames[a];
					weiwaishujuDO.setDepartname(departname);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setDepartname("");
				}
				weiwaishujuService.save(weiwaishujuDO);
			}
		}else if ("隐形订做".equals(jpStyle)){
			String[] saleNumbers =weiwaishuju.getSaleNumber().split(",");
			String[] numyxs =weiwaishuju.getNumyx().split(",");
			String[] codeyxs =weiwaishuju.getCodeyx().split(",");
			String[] nameyxs =weiwaishuju.getNameyx().split(",");
			String[] leftRightyxs =weiwaishuju.getLeftRightYx().split(",");
			String[] countyxs =weiwaishuju.getCountyx().split(",");
			String[] yaoqiuyxs =weiwaishuju.getYaoqiuyx().split(",");
			String[] sphyxs =weiwaishuju.getSphyx().split(",");
			String[] cylyxs =weiwaishuju.getCylyx().split(",");
			String[] zxyxs =weiwaishuju.getZxyx().split(",");
			String[] qulvs =weiwaishuju.getQulv().split(",");
			String[] zjs =weiwaishuju.getZj().split(",");
			String[] jds =weiwaishuju.getJdyx().split(",");

			String[] gknames =weiwaishuju.getGkname().split(",");
			String[] hyknums =weiwaishuju.getHyknum().split(",");
			String[] phones =weiwaishuju.getPhone().split(",");
			String[] departnames =weiwaishuju.getDepartname().split(",");

			for(int a=0;a<numyxs.length;a++){
				WeiwaishujuDO weiwaishujuDO=new WeiwaishujuDO();
				weiwaishujuDO.setNumber(number);
				weiwaishujuDO.setDanjuDay(danjuDay);
				weiwaishujuDO.setZhidanPeople(zhidanPeople);
				weiwaishujuDO.setJcStyle(jpStyle);
				weiwaishujuDO.setTimetime(timetime);
				weiwaishujuDO.setDanjuStyle(danjuStyle);
				try {
					String saleNumber = saleNumbers[a];
					weiwaishujuDO.setSaleNumber(saleNumber);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setSaleNumber("");
				}
				weiwaishujuDO.setWeiwaiStyle(weiwaiStyle);
				weiwaishujuDO.setBeizhu(beizhu);
				try {
					String sph = sphyxs[a];
					weiwaishujuDO.setSphyx(sph);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setSphyx("");
				}
				try {
					String cyl = cylyxs[a];
					weiwaishujuDO.setCylyx(cyl);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCylyx("");
				}
				try {
					String zx = zxyxs[a];
					weiwaishujuDO.setZxyx(zx);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setZxyx("");
				}try {
					String ql = qulvs[a];
					weiwaishujuDO.setQulv(ql);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setQulv("");
				}try {
					String zj = zjs[a];
					weiwaishujuDO.setZj(zj);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setZj("");
				}

				try {
					String jd = jds[a];
					weiwaishujuDO.setJdyx(jd);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setJdyx("");
				}

				try {
					String num = numyxs[a];
					weiwaishujuDO.setNumyx(num);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setNumyx("");
				}
				try {
					String code = codeyxs[a];
					weiwaishujuDO.setCodeyx(code+"00000000");
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCodeyx("");
				}
				try {
					String name = nameyxs[a];
					weiwaishujuDO.setNameyx(name);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setNameyx("");
				}
				try {
					String leftRight = leftRightyxs[a];
					weiwaishujuDO.setLeftRightYx(leftRight);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setLeftRightYx("");
				}
				try {
					String count = countyxs[a];
					weiwaishujuDO.setCountyx(count);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setCountyx("");
				}
				try {
					String yaoqiu = yaoqiuyxs[a];
					weiwaishujuDO.setYaoqiuyx(yaoqiu);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setYaoqiuyx("");
				}
				try {
					String gkname = gknames[a];
					weiwaishujuDO.setGkname(gkname);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setGkname("");
				}
				try {
					String hyknum = hyknums[a];
					weiwaishujuDO.setHyknum(hyknum);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setHyknum("");
				}
				try {
					String phone = phones[a];
					weiwaishujuDO.setPhone(phone);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setPhone("");
				}
				try {
					String departname = departnames[a];
					weiwaishujuDO.setDepartname(departname);
				}catch (ArrayIndexOutOfBoundsException e){
					weiwaishujuDO.setDepartname("");
				}
				weiwaishujuService.save(weiwaishujuDO);
			}


		}

		return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwaishuju:edit")
	public R update( WeiwaishujuDO weiwaishuju){
		weiwaishujuService.update(weiwaishuju);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaishuju:remove")
	public R remove( Long id){
		if(weiwaishujuService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaishuju:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		weiwaishujuService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@RequestMapping(value = "/getWeiwaiShuju")
	public List<WeiwaishujuDO> getWeiwaiShuju(String number, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("number", number);
		List<WeiwaishujuDO> weiwaiShuju = weiwaishujuService.getWeiwaiShuju(map);
		model.addAttribute("weiwaiShuju", weiwaiShuju);
		return weiwaiShuju;
	}

}
