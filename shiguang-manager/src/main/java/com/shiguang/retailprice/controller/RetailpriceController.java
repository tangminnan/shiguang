package com.shiguang.retailprice.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.retailprice.domain.RetailpriceDO;
import com.shiguang.retailprice.service.RetailpriceService;

/**
 * 零售价价格调整表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
 
@Controller
@RequestMapping("/retailprice/retailprice")
public class RetailpriceController {
	@Autowired
	private RetailpriceService retailpriceService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ProducaService producaService;
	@Autowired
	private PartsService partsService;
	@Autowired
	private JpcpService jpcpService;
	@Autowired
	private JpdzService jpdzService;
	@Autowired
	private YxcpService yxcpService;
	@Autowired
	private YxdzService yxdzService;
	@Autowired
	private HlyService hlyService;
	@Autowired
	private TyjService tyjService;
	@Autowired
	private OldlensService oldlensService;
	@Autowired
	private HcService hcService;
	@Autowired
	private ShiguangService shiguangService;
	@Autowired
	private StockService stockService;

	@GetMapping()
	@RequiresPermissions("retailprice:retailprice:retailprice")
	String Retailprice(){
	    return "retailprice/retailprice/retailprice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("retailprice:retailprice:retailprice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RetailpriceDO> retailpriceList = retailpriceService.list(query);
		int total = retailpriceService.count(query);
		PageUtils pageUtils = new PageUtils(retailpriceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("retailprice:retailprice:add")
	String add(Model model){

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createTime=df.format(new Date());// new Date()为获取当前系统时间
//		Calendar cal = Calendar.getInstance();
//		int year = cal.get(Calendar.YEAR);//获取年份
//		int month=(cal.get(Calendar.MONTH))+1;//获取月份
//		int day=cal.get(Calendar.DATE);//获取日
//		int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
//		int minute=cal.get(Calendar.MINUTE);//分
//		int second=cal.get(Calendar.SECOND);//秒
//		String number="PC"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
		Long uuid = GuuidUtil.getUUID();
		String uuidstr = "PC" + uuid.toString();
		model.addAttribute("createTime",createTime);
		model.addAttribute("number",uuidstr);
		model.addAttribute("people", ShiroUtils.getUser().getName());
	    return "retailprice/retailprice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("retailprice:retailprice:edit")
	String edit(@PathVariable("id") Long id,Model model){
		RetailpriceDO retailprice = retailpriceService.get(id);
		model.addAttribute("retailprice", retailprice);
	    return "retailprice/retailprice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("retailprice:retailprice:add")
	public R save( RetailpriceDO retailprice){
		String number=retailprice.getNumber();
		String day=retailprice.getDay();
		String people=retailprice.getPeople();
		String remarks=retailprice.getRemarks();

		String[] goodsids =retailprice.getGoodsid().split(",");
		String[] classtypes =retailprice.getClasstype().split(",");
		String[] nums =retailprice.getNum().split(",");
		String[] names =retailprice.getName().split(",");

		String[] mfrsnums =retailprice.getMfrsnum().split(",");
		String[] mfrsnames =retailprice.getMfrsname().split(",");

		String[] brandnums =retailprice.getBrandnum().split(",");
		String[] brandnames =retailprice.getBrandname().split(",");

		String[] oldMoneys =retailprice.getOldPrice().split(",");
		String[] newMoneys =retailprice.getNewPrice().split(",");

		String newmoney;
		for (int i=0; i<goodsids.length;i++){
			try {
				newmoney = newMoneys[i];
			}catch (ArrayIndexOutOfBoundsException e){
				newmoney="";
			}
			if ("".equals(newmoney)){
				return R.error("调整价格不能为空！");
			}
		}
		for (int i = 0; i < goodsids.length; i++) {
			String goodsid = goodsids[i];
			String classtype = classtypes[i];

			String num = nums[i];
			String name = names[i];

			String mfrsnum = mfrsnums[i];
			String mfrsname = mfrsnames[i];

			String brandnum = brandnums[i];
			String brandname = brandnames[i];

			String oldMoney = oldMoneys[i];
			String newMoney = newMoneys[i];

			Map<String, Object> map = new HashMap<>();
			map.put("num", num);
			map.put("oldMoney", oldMoney);
			if ("1".equals(goodsid)) {
				List<ProducaDO> jjs = producaService.list(map);
				String producName = null;
				for (ProducaDO jj : jjs) {
					String producNum = jj.getProducNum();
					producName = jj.getBrandname() + "-型号:" + jj.getFactory() + "-色号:" + jj.getProducColor() + "-标价:" + newMoney;
					ProducaDO ProducaDO = new ProducaDO();
					ProducaDO.setProducNum(producNum);
					ProducaDO.setProducName(producName);
					ProducaDO.setRetailPrice(newMoney);
					producaService.update(ProducaDO);
				}
				List<StockDO> jjStocks = stockService.list(map);
				for (StockDO jjStock : jjStocks) {
					String goodsNum = jjStock.getGoodsNum();
					StockDO stockDO = new StockDO();
					stockDO.setGoodsNum(goodsNum);
					stockDO.setProducName(producName);
					stockDO.setRetailPrice(newMoney);
					stockService.update(stockDO);
				}
			} else if ("2".equals(goodsid)) {
				List<PartsDO> pjs = partsService.list(map);
			} else if ("3".equals(goodsid) && "1".equals(classtype)) {
				List<JpcpDO> jpcps = jpcpService.list(map);
			} else if ("3".equals(goodsid) && "2".equals(classtype)) {
				List<JpdzDO> jpdzs = jpdzService.list(map);
			} else if ("4".equals(goodsid) && "1".equals(classtype)) {
				List<YxcpDO> yxcps = yxcpService.list(map);
			} else if ("4".equals(goodsid) && "2".equals(classtype)) {
				List<YxdzDO> yxdzs = yxdzService.list(map);
			} else if ("5".equals(goodsid)) {
				List<HlyDO> hlys = hlyService.list(map);
			} else if ("6".equals(goodsid)) {
				List<TyjDO> tyjs = tyjService.list(map);
			} else if ("7".equals(goodsid)) {
				List<OldlensDO> lhjs = oldlensService.list(map);
			} else if ("8".equals(goodsid)) {
				List<HcDO> hcs = hcService.list(map);
			} else if ("9".equals(goodsid)) {
				List<ShiguangDO> sgs = shiguangService.list(map);
			}

			RetailpriceDO retailpriceDO = new RetailpriceDO();
			retailpriceDO.setNumber(number);
			retailpriceDO.setDay(day);
			retailpriceDO.setPeople(people);
			retailpriceDO.setRemarks(remarks);
			retailpriceDO.setNum(num);
			retailpriceDO.setName(name);
			retailpriceDO.setMfrsnum(mfrsnum);
			retailpriceDO.setMfrsname(mfrsname);
			retailpriceDO.setBrandnum(brandnum);
			retailpriceDO.setBrandname(brandname);
			retailpriceDO.setOldPrice(oldMoney);
			retailpriceDO.setNewPrice(newMoney);
			retailpriceService.save(retailprice);
		}
//		if(retailpriceService.save(retailprice)>0){
//			return R.ok();
//		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("retailprice:retailprice:edit")
	public R update( RetailpriceDO retailprice){
		retailpriceService.update(retailprice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("retailprice:retailprice:remove")
	public R remove( Long id){
		if(retailpriceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("retailprice:retailprice:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		retailpriceService.batchRemove(ids);
		return R.ok();
	}

	//品种选择
	@GetMapping("/getbrand")
	String findmfrs( Model model) {
		Map<String, Object> map = new HashMap<>();
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		return "/retailprice/retailprice/getBrand";
	}
	//镜架List
	@ResponseBody
	@RequestMapping("/brandslist")
	public PageUtils brandslist(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		Object goods=query.get("goodsid");
		Object classtype=query.get("classtype");
		PageUtils pageUtils=null;
		if ("1".equals(goods)){
			List<ProducaDO> jjlist = retailpriceService.jjlist(query);
			int total = retailpriceService.jjlistCount(query);
			pageUtils= new PageUtils(jjlist, total);
		}else if ("2".equals(goods)){
			List<PartsDO> pjlist = retailpriceService.pjlist(query);
			int total = retailpriceService.pjlistCount(query);
			pageUtils= new PageUtils(pjlist, total);
		}else if ("3".equals(goods) && "1".equals(classtype)){
			List<JpcpDO> jpcplist = retailpriceService.jpcplist(query);
			int total = retailpriceService.jpcplistCount(query);
			pageUtils= new PageUtils(jpcplist, total);
		}else if ("3".equals(goods) && "2".equals(classtype)){
			List<JpdzDO> jpdzlist = retailpriceService.jpdzlist(query);
			int total = retailpriceService.jpcplistCount(query);
			pageUtils= new PageUtils(jpdzlist, total);
		}else if ("4".equals(goods) && "1".equals(classtype)){
			List<YxcpDO> yxcplist = retailpriceService.yxcplist(query);
			int total = retailpriceService.yxcplistCount(query);
			pageUtils= new PageUtils(yxcplist, total);
		}else if ("5".equals(goods)){
			List<HlyDO> hlylist = retailpriceService.hlylist(query);
			int total = retailpriceService.hlylistCount(query);
			pageUtils= new PageUtils(hlylist, total);
		}else if ("6".equals(goods)){
			List<TyjDO> tyjlist = retailpriceService.tyjlist(query);
			int total = retailpriceService.tyjlistCount(query);
			pageUtils= new PageUtils(tyjlist, total);
		}else if ("7".equals(goods)){
			List<OldlensDO> lhjlist = retailpriceService.lhjlist(query);
			int total = retailpriceService.lhjlistCount(query);
			pageUtils= new PageUtils(lhjlist, total);
		}else if ("8".equals(goods)){
			List<HcDO> hclist = retailpriceService.hclist(query);
			int total = retailpriceService.hclistCount(query);
			pageUtils= new PageUtils(hclist, total);
		}else if ("9".equals(goods)){
			List<ShiguangDO>  sglist= retailpriceService.sglist(query);
			int total = retailpriceService.sglistCount(query);
			pageUtils= new PageUtils(sglist, total);
		}


		return pageUtils;
	}
}
