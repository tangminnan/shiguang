package com.shiguang.storeCard.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.storeCard.domain.CardDO;
import com.shiguang.storeCard.service.CardService;
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


/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-20 16:22:19
 */
 
@Controller
@RequestMapping("/information/card")
public class CardController {
	@Autowired
	private CardService cardService;
	
	@GetMapping()
	@RequiresPermissions("information:card:card")
	String Card(){
	    return "storeCard/card";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:card:card")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CardDO> cardList = cardService.list(query);
		int total = cardService.count(query);
		PageUtils pageUtils = new PageUtils(cardList, total);
		return pageUtils;
	}

	/**
	 * 会员信息
	 */
	@GetMapping("/memeberInfo")
	@RequiresPermissions("information:card:memeberInfo")
	String memeberInfo(Model model){
		return "storeCard/memberInfo";
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:card:add")
	String add(){
	    return "storeCard/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:card:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CardDO card = cardService.get(id);
		model.addAttribute("card", card);
	    return "storeCard/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:card:add")
	public R save(CardDO card){
		if(cardService.save(card)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:card:edit")
	public R update( CardDO card){
		cardService.update(card);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:card:remove")
	public R remove( Long id){
		if(cardService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:card:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		cardService.batchRemove(ids);
		return R.ok();
	}
	
}
