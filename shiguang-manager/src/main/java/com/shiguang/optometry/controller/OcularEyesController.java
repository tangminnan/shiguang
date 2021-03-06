package com.shiguang.optometry.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OcularEyesDO;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.service.OcularEyesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller("OcularEyesController")
@RequestMapping("/information/ocular")
public class OcularEyesController {
    @Autowired
    private OcularEyesService eyesService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CostService costService;
    @Autowired
    private LineService lineService;

    @GetMapping()
    @RequiresPermissions("information:ocular:ocular")
    String Eyes(){
        return "ocular/ocular";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:ocular:ocular")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateNow = simpleDateFormat.format(new Date());
//        query.put("dateNow",dateNow);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        List<MemberDO> memberDOList = eyesService.findOptoEyesList(query);
        int total = eyesService.findOptoEyesCount(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
//        List<OcularEyesDO> eyesList = eyesService.list(query);
//        int total = eyesService.count(query);
//        PageUtils pageUtils = new PageUtils(eyesList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:ocular:add")
    String add(){
        return "ocular/add";
    }

    @GetMapping("/edit/{cardNumber}/{saleNumber}")
    @RequiresPermissions("information:ocular:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber,Model model){
//        OcularEyesDO eyes = eyesService.get(id);
//        model.addAttribute("eyes", eyes);
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0){
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO",memberDO);
        model.addAttribute("saleNumber",saleNumber);
        return "ocular/edit";
    }

    /**
     * 读取数据
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOcular")
    OcularEyesDO getOcular(Model model) {
        OcularEyesDO ocularEyesDO = new OcularEyesDO();
//        IOMASTERUtil iomasterUtil = new IOMASTERUtil();
//        iomasterUtil.readFile1();
        return ocularEyesDO;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:ocular:add")
    public R save( OcularEyesDO eyes){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        LineDO lineDO = new LineDO();
//        lineDO.setMemberNumber(eyes.getMemberNumber());
//        lineDO.setLineDate(simpleDateFormat.format(new Date()));
//        lineDO.setCallStatus("4");
//        lineService.updateByMember(lineDO);
        if(eyesService.save(eyes)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:ocular:edit")
    public R update( OcularEyesDO eyes){
        eyesService.update(eyes);
        return R.ok();
    }

    /**
     * 查询会员是否开单或者缴费
     */
    @ResponseBody
    @PostMapping("/getMember")
    @RequiresPermissions("information:ocular:ocular")
    public R getMember( String cardMember){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<CostDO> costDOList = costService.getMemberNum(cardMember);
        if (null != costDOList && costDOList.size() > 0){
            String createDate = simpleDateFormat.format(costDOList.get(0).getCreateTime());
            String datenow = simpleDateFormat.format(new Date());
            if (!createDate.equals(datenow)){
                return R.ok("该会员还未开检查单");
            }
            if (costDOList.get(0).getIsSale() == 0){
                return R.ok("该会员还未缴费");
            }
        } else {
            return R.ok("该会员还未开检查单");
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:ocular:remove")
    public R remove(Long id){
        if(eyesService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:ocular:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        eyesService.batchRemove(ids);
        return R.ok();
    }
}
