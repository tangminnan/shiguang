package com.shiguang.storeSales.controller;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("StoreSalesController")
@RequestMapping("/information/store")
public class StoreSalesController {
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private ResultDiopterService resultDiopterService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdditionalService additionalService;
    @Autowired
    private ProducaService producaService;
    @Autowired
    private JpcpService jpcpService;
    @Autowired
    private JpdzService jpdzService;
    @Autowired
    private TyjService tyjService;
    @Autowired
    private PartsService partsService;

    @GetMapping()
    @RequiresPermissions("information:store:storeSales")
    String Optometry(){
        return "storeSales/storeSales";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:store:storeSales")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state",1);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:store:add")
    String add(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("roleType",1);
        List<UserDO> userDOList = userService.getRoleList(map);
        model.addAttribute("userDOList",userDOList);
        return "storeSales/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:store:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,Model model){
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0){
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO",memberDO);
        //通过验光师手动输入数据
        Map<String,Object> maps = new HashMap<>();
        maps.put("memberInumber",cardNumber);
        List<OptometryDO> list = optometryService.optoList(maps);
        OptometryDO optometryDO = new OptometryDO();
        if (null != list && list.size() > 0){
            optometryDO.setCylinderRight(list.get(0).getCylinderRight());
            optometryDO.setCylinderLeft(list.get(0).getCylinderLeft());
            optometryDO.setAxialRight(list.get(0).getAxialRight());
            optometryDO.setAxialLeft(list.get(0).getAxialLeft());
            optometryDO.setSphereRight(list.get(0).getSphereRight());
            optometryDO.setSphereLeft(list.get(0).getSphereLeft());
            optometryDO.setOptometryName(list.get(0).getOptometryName());
            optometryDO.setCreateTime(list.get(0).getCreateTime());
        }
        model.addAttribute("optometryDO",optometryDO);
        Map<String, Object> map = new HashMap<>();
        map.put("roleType",1);
        List<UserDO> userDOList = userService.getRoleList(map);
        model.addAttribute("userDOList",userDOList);
        List<ProcessAskDO> proList = optometryService.processlist(map);
        model.addAttribute("proList",proList);
        List<AdditionalDO> addlist =additionalService.list(map);
        model.addAttribute("addlist",addlist);
        UserDO userDO = ShiroUtils.getUser();
        String storeName = userDO.getStore();
        model.addAttribute("storeName",storeName);
        return "storeSales/edit";
    }

    /**
     * 镜架
     */
    @GetMapping("/jingjia")
    @RequiresPermissions("information:store:jingjia")
    String jingjia(Model model){
        return "storeSales/jingjia";
    }

    /**
     * 查询镜架
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjialist")
    @RequiresPermissions("information:store:jingjia")
    public PageUtils jingjialist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ProducaDO> producaDOList = producaService.listmateria(query);
        int total = producaService.countmateria(query);
        PageUtils pageUtils = new PageUtils(producaDOList, total);
        return pageUtils;
    }

    /**
     * 镜片
     */
    @GetMapping("/jingpian")
    @RequiresPermissions("information:store:jingpian")
    String jingpian(Model model){
        return "storeSales/jingpian";
    }

    /**
     * 查询镜片
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingpianlist")
    @RequiresPermissions("information:store:jingpian")
    public PageUtils jingpianlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        PageUtils pageUtils = null;
        if (null != params.get("dzType")){
            String dzType = params.get("dzType").toString();
            if ("0".equals(dzType)){
                List<JpcpDO> jpcpDOList = jpcpService.listCp(query);
                int total = jpcpService.countCp(query);
                 pageUtils = new PageUtils(jpcpDOList, total);
            } else if ("1".equals(dzType)){
                List<JpdzDO> jpdzDOList = jpdzService.listDz(query);
                int total = jpdzService.countDz(query);
                pageUtils = new PageUtils(jpdzDOList, total);
            }
        } else {
            List<JpcpDO> jpcpDOList = jpcpService.listCp(query);
            int total = jpcpService.countCp(query);
            pageUtils = new PageUtils(jpcpDOList, total);
        }
        return pageUtils;

    }

    /**
     * 镜架配件
     */
    @GetMapping("/jingjiapj")
    @RequiresPermissions("information:store:jingjiapj")
    String jingjiapj(Model model){
        return "storeSales/jingjiapj";
    }

    /**
     * 查询镜架配件
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjiapjlist")
    @RequiresPermissions("information:store:jingjiapj")
    public PageUtils jingjiapjlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("partsStyle","框镜");
        List<PartsDO> partsDOList = partsService.list(query);
        int total = partsService.count(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 太阳镜
     */
    @GetMapping("/taiyangjing")
    @RequiresPermissions("information:store:taiyangjing")
    String taiyangjing(Model model){
        return "storeSales/taiyangjing";
    }

    /**
     * 查询太阳镜
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taiyangjinglist")
    @RequiresPermissions("information:store:taiyangjing")
    public PageUtils taiyangjinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<TyjDO> tyjDOList = tyjService.list(query);
        int total = tyjService.count(query);
        PageUtils pageUtils = new PageUtils(tyjDOList, total);
        return pageUtils;
    }

    /**
     * 耗材
     */
    @GetMapping("/haocai")
    @RequiresPermissions("information:store:haocai")
    String haocai(Model model){
        return "storeSales/haocai";
    }

    /**
     * 查询耗材
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/haocailist")
    @RequiresPermissions("information:store:haocai")
    public PageUtils haocailist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<TyjDO> tyjDOList = tyjService.list(query);
        int total = tyjService.count(query);
        PageUtils pageUtils = new PageUtils(tyjDOList, total);
        return pageUtils;
    }

    /**
     * 查询会员
     */
    @ResponseBody
    @RequestMapping(value = "/select")
    public MemberDO remove(String cardMember){
        MemberDO memberDO = memberService.getCardNumber(cardMember);
        if (null != memberDO){
            if (memberDO.getSex() == 0){
                memberDO.setSexx("男");
            } else {
                memberDO.setSexx("女");
            }
        }

        //model.addAttribute("memberDO",memberDO);
        return memberDO;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:store:add")
    public R save( OptometryDO optometry){
        if(optometryService.save(optometry)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:store:edit")
    public R update( OptometryDO optometry){
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:store:remove")
    public R remove(Long id){
        if(optometryService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:store:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
