package com.shiguang.stock.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.stock.domain.*;
import com.shiguang.stock.service.*;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Array;
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
public class WeiwaiController {
    @Autowired
    private WeiwaiService weiwaiService;
    @Autowired
    private WeiwaishujuService weiwaishujuService;
    @Autowired
    private DepartmentService departmentService;
    //配送
    @Autowired
    private LogStatusService statusService;

    //仓位
    @Autowired
    private PositionService positionService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //库存
    @Autowired
    private StockService stockService;
    @Autowired
    UserService userService;

    @Autowired
    private StocklogService stocklogService;
    @Autowired
    private MfrsService mfrsService;

    @GetMapping()
    @RequiresPermissions("stock:weiwai:weiwai")
    String Weiwai(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.getweiwailist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        map.put("state",1);
        List<DepartmentDO> departmentList = departmentService.list(map);
        model.addAttribute("departmentList",departmentList);
        return "stock/weiwai/weiwai";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("stock:weiwai:weiwai")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        if (null != ShiroUtils.getUser().getCompanyId()) {
            if(ShiroUtils.getUser().getCompanyId().equals("3")){
                query.put("companyId","");
            }else {
                query.put("companyId",ShiroUtils.getUser().getCompanyId());
            }
        }
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
            Map<String, Object> map = new HashMap<>();
            map.put("companyid", companyid);
            map.put("positionOrder", 2);
            if (companyId.equals("3")||companyId.equals(3)){
                map.put("positionId", 7);
            }
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

    //委外详情按钮跳转页面
    @GetMapping("/detial/{saleNumber}/{danjuNumber}")
    @RequiresPermissions("stock:weiwai:detial")
    String detial(@PathVariable("saleNumber") String saleNumber, @PathVariable("danjuNumber") String danjuNumber, Model model) {
        WeiwaiDO weiwaiDO = new WeiwaiDO();
        weiwaiDO.setDanjuNumber(danjuNumber);
        weiwaiDO.setSaleNumber(saleNumber);
        WeiwaiDO weiwai = weiwaiService.weiwaiOrder(weiwaiDO);
        model.addAttribute("weiwai", weiwai);
        String eyeStyle = weiwai.getEyeStyle();
        if (eyeStyle.equals("3")) {
            model.addAttribute("eyeStyle", "框镜订做");
        } else if (eyeStyle.equals("4")) {
            model.addAttribute("eyeStyle", "隐形订做");
        }
        return "stock/weiwai/detial";
    }

    ///委外采购详情列表
    @ResponseBody
    @RequestMapping(value = "/selectWeiwaiOrder")
    public List<WeiwaiDO> selectWeiwaiOrder(String danjuNumber, String saleNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("saleNumber", saleNumber);
        List<WeiwaiDO> weiwaiOrder = weiwaiService.selectWeiwaiOrder(map);
        model.addAttribute("weiwaiOrder", weiwaiOrder);
        return weiwaiOrder;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:weiwai:add")
    public R save(WeiwaiDO weiwai) {
        String companyName = ShiroUtils.getUser().getCompany();
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
        String status = weiwai.getStatus();//1未收货
        String username = weiwai.getUsername();//工号
        if ("3".equals(eyeStyle)) {
            String[] weiwaisaleNumbers = weiwai.getWeiwaisaleNumber().split(",");
            String[] mirrortimes = weiwai.getMirrorTime().split(",");
            String[] nums = weiwai.getNum().split(",");
            String[] codes = weiwai.getCode().split(",");
            String[] names = weiwai.getName().split(",");
            String[] styles = weiwai.getStyle().split(",");
            String[] rls = weiwai.getRl().split(",");
            String[] counts = weiwai.getCount().split(",");
            String[] sphs = weiwai.getSph().split(",");
            String[] cyls = weiwai.getCyl().split(",");
            String[] zxs = weiwai.getZx().split(",");
            String[] adds = weiwai.getAdd().split(",");
            String[] sljs = weiwai.getSlj().split(",");
            String[] zjs = weiwai.getZj().split(",");
//            String[] jds = weiwai.getJd().split(",");
//            String[] qulvs = weiwai.getQulv().split(",");


            String[] yaoqius = weiwai.getYaoqiu().split(",");
            String[] gknames = weiwai.getGkname().split(",");
            String[] hyknums = weiwai.getHyknum().split(",");
            String[] phones = weiwai.getPhone().split(",");
            String[] saleNumbers = weiwai.getSaleNumber().split(",");
            String[] departnames = weiwai.getDepartname().split(",");
            String[] fartjs = weiwai.getFartj().split(",");
            String[] neartjs = weiwai.getNeartj().split(",");
            String[] tgs = weiwai.getTg().split(",");
            for (int a = 0; a < weiwaisaleNumbers.length; a++) {
                WeiwaiDO weiwaiDO = new WeiwaiDO();
                weiwaiDO.setCompanyName(companyName);
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
                try {
                    String weiwaisaleNumber = weiwaisaleNumbers[a];
                    weiwaiDO.setWeiwaisaleNumber(weiwaisaleNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setWeiwaisaleNumber("");
                }
                try {
                    String mirrortime = mirrortimes[a];
                    weiwaiDO.setMirrorTime(mirrortime);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setMirrorTime("");
                }
                try {
                    String num = nums[a];
                    //商品品牌信息
                    JpdzDO jpdzDO = weiwaiService.getBrandJp(num);
                    String brandnum = jpdzDO.getBrandnum();
                    String brandname = jpdzDO.getBrandname();
                    String viewGoodName = jpdzDO.getViewGoodName();
                    weiwaiDO.setNum(num);
                    weiwaiDO.setBrandnum(brandnum);
                    weiwaiDO.setBrandname(brandname);
                    weiwaiDO.setViewGoodName(viewGoodName);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setNum("");
                    weiwaiDO.setBrandnum("");
                    weiwaiDO.setBrandname("");
                }
                try {
                    String code = codes[a];
                    weiwaiDO.setCode(code);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCode("");
                }
                try {
                    String name = names[a];
                    weiwaiDO.setName(name);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setName("");
                }
                try {
                    String style = styles[a];
                    weiwaiDO.setStyle(style);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setStyle("");
                }
                try {
                    String rl = rls[a];
                    weiwaiDO.setRl(rl);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setRl("");
                }
                try {
                    String count = counts[a];
                    weiwaiDO.setCount(count);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCount("");
                }
                try {
                    String sph = sphs[a];
                    weiwaiDO.setSph(sph);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSph("");
                }
                try {
                    String cyl = cyls[a];
                    weiwaiDO.setCyl(cyl);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCyl("");
                }
                try {
                    String zx = zxs[a];
                    weiwaiDO.setZx(zx);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setZx("");
                }
                try {
                    String add = adds[a];
                    weiwaiDO.setAdd(add);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setAdd("");
                }
                try {
                    String slj = sljs[a];
                    weiwaiDO.setSlj(slj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSlj("");
                }
                try {
                    String zj =zjs[a];
                    weiwaiDO.setZj(zj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setZj("");
                }

                try {
                    String jd = "";
                    weiwaiDO.setJd(jd);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setJd("");
                }

                try {
                    String qulv = "";
                    weiwaiDO.setQulv(qulv);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setQulv("");
                }


                try {
                    String yaoqiu = yaoqius[a];
                    weiwaiDO.setYaoqiu(yaoqiu);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setYaoqiu("");
                }
                try {
                    String gkname = gknames[a];
                    weiwaiDO.setGkname(gkname);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setGkname("");
                }
                try {
                    String hyknum = hyknums[a];
                    weiwaiDO.setHyknum(hyknum);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setHyknum("");
                }
                try {
                    String phone = phones[a];
                    weiwaiDO.setPhone(phone);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setPhone("");
                }
                weiwaiDO.setStatus(status);
                weiwaiDO.setUsername(username);
                weiwaiDO.setShTime("");
                weiwaiDO.setShstatus("");
                weiwaiDO.setPstime("");
                weiwaiDO.setPsname("");
                try {
                    String saleNumber = saleNumbers[a];
                    weiwaiDO.setSaleNumber(saleNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSaleNumber("");
                }
                try {
                    String departname = departnames[a];
                    weiwaiDO.setDepartname(departname);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setDepartname("");
                }
                try {
                    String fartj = fartjs[a];
                    weiwaiDO.setFartj(fartj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setFartj("");
                }
                try {
                    String neartj = neartjs[a];
                    weiwaiDO.setNeartj(neartj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setNeartj("");
                }
                try {
                    String tg = tgs[a];
                    weiwaiDO.setTg(tg);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setTg("");
                }
                weiwaiService.save(weiwaiDO);
            }
        }



     else    if ("4".equals(eyeStyle)) {
            String[] weiwaisaleNumbers = weiwai.getWeiwaisaleNumber().split(",");
            String[] mirrortimes = weiwai.getMirrorTime().split(",");
            String[] nums = weiwai.getNum().split(",");
            String[] codes = weiwai.getCode().split(",");
            String[] names = weiwai.getName().split(",");
            String[] styles = weiwai.getStyle().split(",");
            String[] rls = weiwai.getRl().split(",");
            String[] counts = weiwai.getCount().split(",");
            String[] sphs = weiwai.getSph().split(",");
            String[] cyls = weiwai.getCyl().split(",");
            String[] zxs = weiwai.getZx().split(",");
            String[] adds = weiwai.getAdd().split(",");
//            String[] sljs = weiwai.getSlj().split(",");
            String[] zjs = weiwai.getZj().split(",");
            String[] jds = weiwai.getJd().split(",");
            String[] qulvs = weiwai.getQulv().split(",");
            String[] yaoqius = weiwai.getYaoqiu().split(",");
            String[] gknames = weiwai.getGkname().split(",");
            String[] hyknums = weiwai.getHyknum().split(",");
            String[] phones = weiwai.getPhone().split(",");
            String[] saleNumbers = weiwai.getSaleNumber().split(",");
            String[] departnames = weiwai.getDepartname().split(",");
            String[] fartjs = weiwai.getFartj().split(",");
            String[] neartjs = weiwai.getNeartj().split(",");
            String[] tgs = weiwai.getTg().split(",");
            for (int a = 0; a < weiwaisaleNumbers.length; a++) {
                WeiwaiDO weiwaiDO = new WeiwaiDO();
                weiwaiDO.setCompanyName(companyName);
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
                try {
                    String weiwaisaleNumber = weiwaisaleNumbers[a];
                    weiwaiDO.setWeiwaisaleNumber(weiwaisaleNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setWeiwaisaleNumber("");
                }
                try {
                    String mirrortime = mirrortimes[a];
                    weiwaiDO.setMirrorTime(mirrortime);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setMirrorTime("");
                }
                try {
                    String num = nums[a];
                    //商品品牌信息
                    YxdzDO yxdzDO = weiwaiService.getBrandYx(num);
                    String brandnum = yxdzDO.getBrandnum();
                    String brandname = yxdzDO.getBrandname();
                    String viewGoodName = yxdzDO.getViewGoodName();
                    weiwaiDO.setNum(num);
                    weiwaiDO.setBrandnum(brandnum);
                    weiwaiDO.setBrandname(brandname);
                    weiwaiDO.setViewGoodName(viewGoodName);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setNum("");
                    weiwaiDO.setBrandnum("");
                    weiwaiDO.setBrandname("");
                }
                try {
                    String code = codes[a];
                    weiwaiDO.setCode(code);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCode("");
                }
                try {
                    String name = names[a];
                    weiwaiDO.setName(name);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setName("");
                }
                try {
                    String style = styles[a];
                    weiwaiDO.setStyle(style);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setStyle("");
                }
                try {
                    String rl = rls[a];
                    weiwaiDO.setRl(rl);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setRl("");
                }
                try {
                    String count = counts[a];
                    weiwaiDO.setCount(count);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCount("");
                }
                try {
                    String sph = sphs[a];
                    weiwaiDO.setSph(sph);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSph("");
                }
                try {
                    String cyl = cyls[a];
                    weiwaiDO.setCyl(cyl);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setCyl("");
                }
                try {
                    String zx = zxs[a];
                    weiwaiDO.setZx(zx);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setZx("");
                }
                try {
                    String add = adds[a];
                    weiwaiDO.setAdd(add);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setAdd("");
                }
                try {
                    String slj = "";
                    weiwaiDO.setSlj(slj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSlj("");
                }
                try {
                    String zj = zjs[a];
                    weiwaiDO.setZj(zj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setZj("");
                }
                try {
                    String jd = jds[a];
                    weiwaiDO.setJd(jd);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setJd("");
                }

                try {
                    String qulv = qulvs[a];
                    weiwaiDO.setQulv(qulv);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setQulv("");
                }
                try {
                    String yaoqiu = yaoqius[a];
                    weiwaiDO.setYaoqiu(yaoqiu);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setYaoqiu("");
                }
                try {
                    String gkname = gknames[a];
                    weiwaiDO.setGkname(gkname);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setGkname("");
                }
                try {
                    String hyknum = hyknums[a];
                    weiwaiDO.setHyknum(hyknum);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setHyknum("");
                }
                try {
                    String phone = phones[a];
                    weiwaiDO.setPhone(phone);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setPhone("");
                }
                weiwaiDO.setStatus(status);
                weiwaiDO.setUsername(username);
                weiwaiDO.setShTime("");
                weiwaiDO.setShstatus("");
                weiwaiDO.setPstime("");
                weiwaiDO.setPsname("");
                try {
                    String saleNumber = saleNumbers[a];
                    weiwaiDO.setSaleNumber(saleNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setSaleNumber("");
                }
                try {
                    String departname = departnames[a];
                    weiwaiDO.setDepartname(departname);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setDepartname("");
                }
                try {
                    String fartj = fartjs[a];
                    weiwaiDO.setFartj(fartj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setFartj("");
                }
                try {
                    String neartj = neartjs[a];
                    weiwaiDO.setNeartj(neartj);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setNeartj("");
                }
                try {
                    String tg = tgs[a];
                    weiwaiDO.setTg(tg);
                } catch (ArrayIndexOutOfBoundsException e) {
                    weiwaiDO.setTg("");
                }
                weiwaiService.save(weiwaiDO);
            }
        }
        return R.ok();

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
    public R remove(String saleNumber, String danjuNumber) {
        WeiwaiDO weiwaiDO = new WeiwaiDO();
        weiwaiDO.setSaleNumber(saleNumber);
        weiwaiDO.setDanjuNumber(danjuNumber);
        if (weiwaiService.removes(weiwaiDO) > 0) {
            weiwaishujuService.removes(saleNumber);
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
        //部门selectOrder
        Map<String, Object> map = new HashMap<>();
        //———获取当前登录用户————
        if (null != ShiroUtils.getUser().getStoreNum()) {
            map.put("departNumber", ShiroUtils.getUser().getStoreNum());
        } else {
            map.put("departNumber", "");
        }
        model.addAttribute("departmentName", ShiroUtils.getUser().getStore());
        if (eyeStyle == 3) {
            return "/stock/weiwaishuju/jpadd";
        } else  {
            return "/stock/weiwaishuju/yxadd";
        }


    }


    @GetMapping("/PeiJing/{eyeStyle}/{mfrsid}/{mfrsname}")
    String PeiJing(@PathVariable("eyeStyle") Integer eyeStyle, @PathVariable("mfrsid") String mfrsid,
                   @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("eyeStyle", eyeStyle);
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
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
        int total = weiwaiService.selectOrderCount(query);
        PageUtils pageUtils = new PageUtils(selectOrder, total);
        return pageUtils;
    }

    /**
     * 收货输入工号
     */
    @GetMapping("/userNum/{saleNumber}/{danjuNumber}")
    @RequiresPermissions("stock:weiwai:userNum")
    String userNum(@PathVariable("saleNumber") String saleNumber, @PathVariable("danjuNumber") String danjuNumber, Model model) {
        model.addAttribute("saleNumber", saleNumber);
        model.addAttribute("danjuNumber", danjuNumber);
        return "/stock/weiwai/userNum";
    }


    /**
     * 收货状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public R updateEnable(String danjuNumber, String saleNumber, String status, String username) {
        //———获取当前登录用户的公司id————
        Map<String, Object> map = new HashMap<>();
        String conpanyId = ShiroUtils.getUser().getCompanyId();
        map.put("conpanyId", conpanyId);
        map.put("userName", username);
        UserDO userDO = userService.getUserName(map);
        if (null == userDO) {
            return R.error("该工号不存在");
        } else {
            Map<String, Object> weiwaimap = new HashMap<>();
            weiwaimap.put("danjuNumber", danjuNumber);
            weiwaimap.put("saleNumber", saleNumber);
            List<WeiwaiDO> weiwaiOrder = weiwaiService.selectWeiwaiOrder(weiwaimap);
            for (WeiwaiDO weiwai : weiwaiOrder) {
                Long positionId = weiwai.getPositionId();
                String num = weiwai.getNum();//代码
                String code = weiwai.getCode();//条码
                String goodsType = weiwai.getEyeStyle();//镜片、隐形
                String name = weiwai.getName();//名称
                String count = weiwai.getCount();
                String mfrsid = weiwai.getMfrsid();
                String brandname = weiwai.getBrandname();

                StockDO stockDO = new StockDO();
                stockDO.setGoodsNum(num);
                stockDO.setGoodsCode(code);
                stockDO.setPositionId(positionId.toString());
                StockDO goodsNumList = stockService.haveNum(stockDO);
                if (null != goodsNumList) {
                    StockDO stockOld = new StockDO();
                    Integer countOld = Integer.valueOf(goodsNumList.getGoodsCount());
                    Integer countNew = Integer.valueOf(count);
                    Integer countNews = countOld + countNew;
                    stockOld.setGoodsCount(countNews.toString());
                    stockOld.setGoodsNum(num);
                    stockOld.setGoodsCode(code);
                    stockOld.setPositionId(positionId.toString());
                    stockService.updateGoodsCount(stockOld);//修改数量

                    WeiwaiDO weiwaiDO = new WeiwaiDO();
                    weiwaiDO.setDanjuNumber(danjuNumber);
                    weiwaiDO.setSaleNumber(saleNumber);
                    weiwaiDO.setStatus(status);
                    weiwaiDO.setUsername(username);
                    //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                    Date dates = new Date();
                    String shTime = sdf.format(dates);
                    weiwaiDO.setShTime(shTime);
                    String danjuNumbers = weiwai.getDanjuNumber();
                    weiwaiDO.setStockorder(danjuNumbers);
                    weiwaiService.updateStatus(weiwaiDO);


                    StockDO stockDOs = new StockDO();
                    stockDOs.setDanjuNumber(danjuNumber);
                    stockDOs.setStatus(status);
                    stockDOs.setUsername(username);
                    stockService.updateStatus(stockDOs);


                    ///log
                    StocklogDO stocklogDO = new StocklogDO();
                    stocklogDO.setDanjunum(danjuNumber);
                    stocklogDO.setNum(goodsNumList.getGoodsNum());
                    stocklogDO.setCode(goodsNumList.getGoodsCode());
                    stocklogDO.setName(goodsNumList.getGoodsName());
                    stocklogDO.setGoodsid(Integer.valueOf(goodsNumList.getGoodsType()));
                    stocklogDO.setMfrsnum(goodsNumList.getMfrsid());
                    stocklogDO.setBrandname(goodsNumList.getBrandname());
                    stocklogDO.setMoney(goodsNumList.getRetailPrice());
                    stocklogDO.setUseday(goodsNumList.getUseday());
                    stocklogDO.setBacth(goodsNumList.getBatch());
                    stocklogDO.setCounts(String.valueOf(countNew));
                    stocklogDO.setInpositionId(positionId);
                    stocklogDO.setOutpositionId(null);
                    stocklogDO.setZhidanPeople(goodsNumList.getZhidanPeople());
                    stocklogDO.setDay(shTime);
                    stocklogDO.setWay("委外入库");
                    //———获取当前登录用户的工号————
                    stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                    stocklogService.save(stocklogDO);
                } else {

                    if ("3".equals(goodsType)) {
                        StockDO stockDO2 = new StockDO();
                        stockDO2.setGoodsNum(num);
                        StockDO jingpians = stockService.jingpiandzs(stockDO2);
                        // 代码 条码 名称 数量 类别 制造商 品牌 单位 价钱 仓位 classtype ..型号
                        String goodsNums = num;
                        String goodsCodes = code;
                        String goodsNames = name;
                        String counts = count;
                        String goodsTypes = goodsType;//类别
                        String mfrsids = mfrsid;
                        String brandnames = brandname;
                        String unitnames = jingpians.getUnitname();
                        String retailPrices = jingpians.getRetailPrice();
                        stockDO.setPositionId(positionId.toString());
                        String classtypes = jingpians.getClasstype();
                        String factorys = jingpians.getProducFactory();

                        stockDO.setGoodsNum(goodsNums);
                        stockDO.setGoodsCode(goodsCodes);
                        stockDO.setGoodsName(goodsNames);
                        stockDO.setGoodsCount(counts);
                        stockDO.setGoodsType(Integer.valueOf(goodsTypes));
                        stockDO.setMfrsid(mfrsids);
                        stockDO.setBrandname(brandnames);
                        stockDO.setUnit(unitnames);
                        stockDO.setRetailPrice(retailPrices);
                        stockDO.setClasstype(classtypes);
                        stockDO.setFactory(factorys);
                        //收货状态
                        //———生成单据编号————
                        String danjuNumbers = weiwai.getDanjuNumber();
                        //———入库时间—————
                        SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String createTimes = createTimenew.format(date);
                        stockDO.setCreateTime(createTimes);
                        stockDO.setDanjuNumber(danjuNumbers);
                        //------制单人------
                        String zhidanPeoples = ShiroUtils.getUser().getName();
                        stockDO.setZhidanPeople(zhidanPeoples);
                        //---单据日期--
                        stockDO.setDanjuDay(createTimes);
                        stockDO.setStatus("1");
                        stockDO.setUsername("未收货");
                        stockDO.setReturnzt("1");


                        ///log
                        StocklogDO stocklogDO = new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsNums);
                        stocklogDO.setCode(goodsCodes);
                        stocklogDO.setName(goodsNames);
                        stocklogDO.setGoodsid(Integer.valueOf(goodsTypes));
                        stocklogDO.setMfrsnum(mfrsids);
                        stocklogDO.setBrandname(brandnames);
                        stocklogDO.setMoney(retailPrices);
                        stocklogDO.setUseday("");
                        stocklogDO.setBacth("");
                        stocklogDO.setCounts(counts);
                        stocklogDO.setInpositionId(positionId);
                        stocklogDO.setOutpositionId(null);
                        stocklogDO.setZhidanPeople(zhidanPeoples);
                        stocklogDO.setDay(createTimes);
                        stocklogDO.setWay("委外入库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);

                        if (stockService.save(stockDO) > 0) {
                            WeiwaiDO weiwaiDO = new WeiwaiDO();
                            weiwaiDO.setDanjuNumber(danjuNumber);
                            weiwaiDO.setSaleNumber(saleNumber);
                            weiwaiDO.setStatus(status);
                            weiwaiDO.setUsername(username);
                            //———获取当前系统时间—————
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date dates = new Date();
                            String shTime = sdf.format(dates);
                            weiwaiDO.setShTime(shTime);
                            weiwaiDO.setStockorder(danjuNumbers);
                            weiwaiService.updateStatus(weiwaiDO);
                            StockDO stockDOs = new StockDO();
                            stockDOs.setDanjuNumber(danjuNumber);
                            stockDOs.setStatus(status);
                            stockDOs.setUsername(username);
                            stockService.updateStatus(stockDOs);

                        }
                    }


                    else   if ("4".equals(goodsType)) {
                        StockDO stockDO2 = new StockDO();
                        stockDO2.setGoodsNum(num);
                        StockDO yinxingdzs = stockService.yinxingdzs(stockDO2);
                        // 代码 条码 名称 数量 类别 制造商 品牌 单位 价钱 仓位 classtype ..型号
                        String goodsNums = num;
                        String goodsCodes = code;
                        String goodsNames = name;
                        String counts = count;
                        String goodsTypes = goodsType;//类别
                        String mfrsids = mfrsid;
                        String brandnames = brandname;
                        String unitnames = yinxingdzs.getUnitname();
                        String retailPrices = yinxingdzs.getRetailPrice();
                        stockDO.setPositionId(positionId.toString());
                        String classtypes = yinxingdzs.getClasstype();
                        String factorys = yinxingdzs.getProducFactory();

                        stockDO.setGoodsNum(goodsNums);
                        stockDO.setGoodsCode(goodsCodes);
                        stockDO.setGoodsName(goodsNames);
                        stockDO.setGoodsCount(counts);
                        stockDO.setGoodsType(Integer.valueOf(goodsTypes));
                        stockDO.setMfrsid(mfrsids);
                        stockDO.setBrandname(brandnames);
                        stockDO.setUnit(unitnames);
                        stockDO.setRetailPrice(retailPrices);
                        stockDO.setClasstype(classtypes);
                        stockDO.setFactory(factorys);
                        //收货状态
                        //———生成单据编号————
                        String danjuNumbers = weiwai.getDanjuNumber();
                        //———入库时间—————
                        SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String createTimes = createTimenew.format(date);
                        stockDO.setCreateTime(createTimes);
                        stockDO.setDanjuNumber(danjuNumbers);
                        //------制单人------
                        String zhidanPeoples = ShiroUtils.getUser().getName();
                        stockDO.setZhidanPeople(zhidanPeoples);
                        //---单据日期--
                        stockDO.setDanjuDay(createTimes);
                        stockDO.setStatus("1");
                        stockDO.setUsername("未收货");
                        stockDO.setReturnzt("1");


                        ///log
                        StocklogDO stocklogDO = new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsNums);
                        stocklogDO.setCode(goodsCodes);
                        stocklogDO.setName(goodsNames);
                        stocklogDO.setGoodsid(Integer.valueOf(goodsTypes));
                        stocklogDO.setMfrsnum(mfrsids);
                        stocklogDO.setBrandname(brandnames);
                        stocklogDO.setMoney(retailPrices);
                        stocklogDO.setUseday("");
                        stocklogDO.setBacth("");
                        stocklogDO.setCounts(counts);
                        stocklogDO.setInpositionId(positionId);
                        stocklogDO.setOutpositionId(null);
                        stocklogDO.setZhidanPeople(zhidanPeoples);
                        stocklogDO.setDay(createTimes);
                        stocklogDO.setWay("委外入库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);

                        if (stockService.save(stockDO) > 0) {
                            WeiwaiDO weiwaiDO = new WeiwaiDO();
                            weiwaiDO.setDanjuNumber(danjuNumber);
                            weiwaiDO.setSaleNumber(saleNumber);
                            weiwaiDO.setStatus(status);
                            weiwaiDO.setUsername(username);
                            //———获取当前系统时间—————
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date dates = new Date();
                            String shTime = sdf.format(dates);
                            weiwaiDO.setShTime(shTime);
                            weiwaiDO.setStockorder(danjuNumbers);
                            weiwaiService.updateStatus(weiwaiDO);
                            StockDO stockDOs = new StockDO();
                            stockDOs.setDanjuNumber(danjuNumber);
                            stockDOs.setStatus(status);
                            stockDOs.setUsername(username);
                            stockService.updateStatus(stockDOs);

                        }
                    }






                }
            }
        }
        return R.ok();
    }

    /**
     * 配送输入工号
     */
    @RequiresPermissions("stock:weiwai:psNum")
    @GetMapping("/psNum/{saleNumber}/{danjuNumber}")
    String psNum(@PathVariable("saleNumber") String saleNumber, @PathVariable("danjuNumber") String danjuNumber,
                 Model model) {
        model.addAttribute("saleNumber", saleNumber);
        model.addAttribute("danjuNumber", danjuNumber);
        return "/stock/weiwai/userNumps";
    }


    /**
     * 取镜处收货或者加工检验----配送减库存
     */
    @PostMapping("/editShouhuo")
    @ResponseBody
    public R editShouhuo(String danjuNumber, String saleNumber, String shstatus, String psname) {
        Map<String, Object> map = new HashMap<>();
        String conpanyId = ShiroUtils.getUser().getCompanyId();
        map.put("conpanyId", conpanyId);
        map.put("userName", psname);
        UserDO userDO = userService.getUserName(map);
        if (null == userDO) {
            return R.error("该工号不存在");
        } else {
            map.put("danjuNumber", danjuNumber);
            map.put("saleNumber", saleNumber);
            List<WeiwaiDO> weiwaiOrders = weiwaiService.selectWeiwaiOrder(map);
            for (WeiwaiDO weiwaiDO : weiwaiOrders) {
                String eyeStyle = weiwaiDO.getEyeStyle();
                LogStatusDO logStatusDO = new LogStatusDO();
                List<LogStatusDO> statusDOList=new ArrayList<>();
                if ("3".equals(eyeStyle)) {
//                    String yaoqiu = weiwaiDO.getYaoqiu();
//                    Integer flag = yaoqiu.indexOf("委外代加工");
//                    if (flag != -1) {
//                        logStatusDO.setSaleNumber(saleNumber);
//                        logStatusDO.setLogisticStatus("配送");
//                        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
//                        workRecoedDO.setUserName(psname);
//                        workRecoedDO.setType("配送");
//                        workRecoedDO.setDateTime(new Date());
//
//                        Map<String,Object> statusmap=new HashMap<>();
//                        statusmap.put("saleNumber",saleNumber);
//                        statusmap.put("logisticStatus","配送");
//                         statusDOList=statusService.list(statusmap);
//                        if (statusDOList.size()==0){
//                            statusService.saveRecord(workRecoedDO);
//                        }
//                        //减库存
//                        String num = weiwaiDO.getNum();
//                        String code = weiwaiDO.getCode();
//                        Long positionId = weiwaiDO.getPositionId();
//                        String count = weiwaiDO.getCount();
//                        StockDO stock = new StockDO();
//                        stock.setGoodsNum(num);
//                        stock.setGoodsCode(code);
//                        stock.setPositionId(positionId.toString());
//                        StockDO goodsList = stockService.haveNum(stock);
//                        if (null != goodsList) {
//                            Integer kcCount = Integer.valueOf(goodsList.getGoodsCount());
//                            Integer psCount = Integer.valueOf(count);
//                            Integer countNews = kcCount - psCount;
//                            stock.setGoodsCount(countNews.toString());
//                            stockService.updateGoodsCount(stock);//修改数量
//
//                            ///log
//                            StocklogDO stocklogDO = new StocklogDO();
//                            stocklogDO.setDanjunum(danjuNumber);
//                            stocklogDO.setNum(goodsList.getGoodsNum());
//                            stocklogDO.setCode(goodsList.getGoodsCode());
//                            stocklogDO.setName(goodsList.getGoodsName());
//                            stocklogDO.setGoodsid(goodsList.getGoodsType());
//                            stocklogDO.setMfrsnum(goodsList.getMfrsid());
//                            stocklogDO.setBrandname(goodsList.getBrandname());
//                            stocklogDO.setMoney(goodsList.getRetailPrice());
//                            stocklogDO.setUseday(goodsList.getUseday());
//                            stocklogDO.setBacth(goodsList.getBatch());
//                            stocklogDO.setCounts(String.valueOf(countNews));
//                            stocklogDO.setInpositionId(null);
//                            stocklogDO.setOutpositionId(positionId);
//                            stocklogDO.setZhidanPeople(psname);
//                            //———获取当前系统时间—————
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                            Date date = new Date();
//                            String newDate = sdf.format(date);
//                            stocklogDO.setDay(newDate);
//                            stocklogDO.setWay("委外出库");
//                            //———获取当前登录用户的工号————
//                            stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
//                            stocklogService.save(stocklogDO);
//                        }
//                    } else {
                        logStatusDO.setSaleNumber(saleNumber);
                        logStatusDO.setLogisticStatus("委外完成");
                        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
                        workRecoedDO.setUserName(psname);
                        workRecoedDO.setType("委外完成");
                        workRecoedDO.setDateTime(new Date());

                        Map<String,Object> statusmap=new HashMap<>();
                        statusmap.put("saleNumber",saleNumber);
                        statusmap.put("logisticStatus","委外完成");
                          statusDOList=statusService.list(statusmap);
                        if (statusDOList.size()==0) {
                            statusService.saveRecord(workRecoedDO);
                        }
//                    }
                }else if("4".equals(eyeStyle)){
                    logStatusDO.setSaleNumber(saleNumber);
                    logStatusDO.setLogisticStatus("配送");
                    WorkRecoedDO workRecoedDO = new WorkRecoedDO();
                    workRecoedDO.setUserName(psname);
                    workRecoedDO.setType("配送");
                    workRecoedDO.setDateTime(new Date());

                    Map<String,Object> statusmap=new HashMap<>();
                    statusmap.put("saleNumber",saleNumber);
                    statusmap.put("logisticStatus","配送");
                    statusDOList=statusService.list(statusmap);
                    if (statusDOList.size()==0){
                        statusService.saveRecord(workRecoedDO);
                    }
                    //减库存
                    String num = weiwaiDO.getNum();
                    String code = weiwaiDO.getCode();
                    Long positionId = weiwaiDO.getPositionId();
                    String count = weiwaiDO.getCount();
                    StockDO stock = new StockDO();
                    stock.setGoodsNum(num);
                    stock.setGoodsCode(code);
                    stock.setPositionId(positionId.toString());
                    StockDO goodsList = stockService.haveNum(stock);
                    if (null != goodsList) {
                        Integer kcCount = Integer.valueOf(goodsList.getGoodsCount());
                        Integer psCount = Integer.valueOf(count);
                        Integer countNews = kcCount - psCount;
                        stock.setGoodsCount(countNews.toString());
                        stockService.updateGoodsCount(stock);//修改数量

                        ///log
                        StocklogDO stocklogDO = new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsList.getGoodsNum());
                        stocklogDO.setCode(goodsList.getGoodsCode());
                        stocklogDO.setName(goodsList.getGoodsName());
                        stocklogDO.setGoodsid(goodsList.getGoodsType());
                        stocklogDO.setMfrsnum(goodsList.getMfrsid());
                        stocklogDO.setBrandname(goodsList.getBrandname());
                        stocklogDO.setMoney(goodsList.getRetailPrice());
                        stocklogDO.setUseday(goodsList.getUseday());
                        stocklogDO.setBacth(goodsList.getBatch());
                        stocklogDO.setCounts(String.valueOf(countNews));
                        stocklogDO.setInpositionId(null);
                        stocklogDO.setOutpositionId(positionId);
                        stocklogDO.setZhidanPeople(psname);
                        //———获取当前系统时间—————
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String newDate = sdf.format(date);
                        stocklogDO.setDay(newDate);
                        stocklogDO.setWay("委外出库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);
                    }
                }
                if (statusDOList.size()==0){
                    if (statusService.save(logStatusDO) > 0) {
                        WeiwaiDO weiwaiDO1 = new WeiwaiDO();
                        weiwaiDO1.setDanjuNumber(danjuNumber);
                        weiwaiDO1.setSaleNumber(saleNumber);
                        weiwaiDO1.setShstatus(shstatus);
                        weiwaiDO1.setPsname(psname);
                        //———获取当前系统时间—————
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String newDate = sdf.format(date);
                        weiwaiDO1.setPstime(newDate);
                        weiwaiService.updateStatus(weiwaiDO1);
                    }
                }

            }
        }
        return R.ok();
    }

    /**
     * 浏览器打印二维码
     */
    @GetMapping("/code")
    public String code(String saleNumber, String danjuNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("saleNumber", saleNumber);
        map.put("danjuNumber", danjuNumber);
        List<WeiwaiDO> weiwaiDOS = weiwaiService.selectWeiwaiOrder(map);
        model.addAttribute("weiwaiDOS", weiwaiDOS);
        for (WeiwaiDO weiwaiDO : weiwaiDOS) {
            String code = QRCodeUtil.creatRrCode(weiwaiDO.getCode(), 200, 200);
            code = "data:image/png;base64," + code;
            weiwaiDO.setQRCode(code);
        }

        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if (companyId==null){
            companyId="";
        }
        if (companyId.equals(3)||companyId.equals("3")){
            return "/stock/weiwai/codeJN";
        }else {
            return "/stock/weiwai/code";

        }

    }

    /**
     * 浏览器打印二维码一个
     */
    @GetMapping("/codeOne")
    public String codeOne(String danjuNumber, String codeOne, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("codeOne", codeOne);
        List<WeiwaiDO> weiwaiDOS = weiwaiService.selectWeiwaiOrder(map);
        model.addAttribute("weiwaiDOS", weiwaiDOS);
        for (WeiwaiDO weiwaiDO : weiwaiDOS) {
            String code = QRCodeUtil.creatRrCode(weiwaiDO.getCode(), 200, 200);
            code = "data:image/png;base64," + code;
            weiwaiDO.setQRCode(code);
        }
        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if (companyId==null){
            companyId="";
        }
        if (companyId.equals(3)||companyId.equals("3")){
            return "/stock/weiwai/codeOneJN";
        }else {
            return "/stock/weiwai/codeOne";

        }
    }

    //打印委外框镜配镜单
    @GetMapping("/jkPeijingdan")
    String jkPeijingdan(String danjuNumber, String saleNumber, Model model) {
        WeiwaiDO weiwaiDO1 = new WeiwaiDO();
        weiwaiDO1.setDanjuNumber(danjuNumber);
        weiwaiDO1.setSaleNumber(saleNumber);
        WeiwaiDO weiwaiDO = weiwaiService.weiwaiOrder(weiwaiDO1);
        model.addAttribute("weiwaiDO", weiwaiDO);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String dayinDay = sdf.format(date);
        model.addAttribute("dayinDay", dayinDay);
        return "/stock/weiwai/jkPeijingdan";
    }

    ///打印委外框镜配镜单列表
    @ResponseBody
    @RequestMapping(value = "/jkPeijingdanList")
    public List<WeiwaiDO> selectJKList(String danjuNumber, String saleNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("saleNumber", saleNumber);
        List<WeiwaiDO> weiwaiDan = weiwaiService.selectWeiwaiOrder(map);
        return weiwaiDan;
    }


//    /**
//     * 退货输入工号
//     */
//    @GetMapping("/userNumth/{salenumbery}/{danjuNumber}")
//    String userNumth(@PathVariable("salenumbery") String salenumbery,
//                     @PathVariable("danjuNumber") String danjuNumber, Model model) {
//        model.addAttribute("danjuNumber", danjuNumber);
//        model.addAttribute("salenumbery", salenumbery);
//        return "/stock/weiwai/userNumth";
//    }
//
//    /**
//     * 退货
//     */
//    @PostMapping("/editTuihuo")
//    @ResponseBody
//    public R editTuihuo(String danjuNumber, String shstatus, String psname) {
//
//        WeiwaiDO weiwaiDO = new WeiwaiDO();
//        weiwaiDO.setDanjuNumber(danjuNumber);
//        weiwaiDO.setShstatus(shstatus);
//        weiwaiDO.setPsname(psname);
//        //———获取当前系统时间—————
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//        Date date = new Date();
//        String newDate = sdf.format(date);
//        weiwaiDO.setPstime(newDate);
//
//        WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
//        weiwaikcDO.setDanjuNumber(danjuNumber);
//        weiwaikcDO.setShstatus(shstatus);
//        weiwaikcDO.setPsname(psname);
//        //———获取当前系统时间—————
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//        Date date1 = new Date();
//        String newDate1 = sdf.format(date1);
//        weiwaiDO.setPstime(newDate1);
//        if (weiwaiService.updateStatus(weiwaiDO) > 0) {
//            weiwaikcService.updateStatus(weiwaikcDO);
//            return R.ok();
//        }
//        return R.error();
//    }
//


//    /**
//     * 浏览器打印二维码
//     */
//    @GetMapping("/code")
//    @RequiresPermissions("stock:weiwai:code")
//    public String code(String danjuNumber, Model model) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("danjuNumber",danjuNumber);
//        List<WeiwaiDO> weiwaiDO = weiwaiService.selectWeiwaiOrder(map);
//        String[] goodsCodes= weiwaiDO.getCode().split(",");
//        String[] goodsCounts= weiwaiDO.getCount().split(",");
//        String [] codeAndCounts = new String[goodsCodes.length];
//        String codes="";
//        String counts="";
//        for (int i=0;i<goodsCodes.length;i++) {
//            codes = goodsCodes[i];
//            counts = goodsCounts[i];
//            codeAndCounts[i] = codes + "," + counts;
//        }
//        model.addAttribute("codeAndCounts",codeAndCounts);
//
//        List<Map<String ,Object>> weiwaiDOList=new ArrayList<>();
//        for (int i=0;i<codeAndCounts.length;i++) {
//            Map<String,Object> map=new HashMap<>();
//            String[] countcode=codeAndCounts[i].split(",");
//            map.put("goodsCodes",countcode[0]);
//            map.put("goodsCounts",countcode[1]);
//            weiwaiDOList.add(map);
//        }
////       model.addAttribute("weiwaiDOList", weiwaiDOList);
//
//        List<Map<String ,Object>> weiwaiCode=new ArrayList<>();
//        for (int a=0;a<weiwaiDOList.size();a++){
//            Map<String,Object> map=new HashMap<>();
//            String goodsCode=String.valueOf(weiwaiDOList.get(a).get("goodsCodes"));
//            String goodsCount=String.valueOf(weiwaiDOList.get(a).get("goodsCounts"));
//            String code = QRCodeUtil.creatRrCode(String.valueOf(goodsCode), 200,200);
//            code = "data:image/png;base64," + code;
//            map.put("goodsCode",goodsCode);
//            map.put("goodsCount",goodsCount);
//            map.put("QRCode",code);
//            weiwaiCode.add(map);
//        }
//        model.addAttribute("weiwaiCode", weiwaiCode);
//        model.addAttribute("goodsCounts",goodsCounts);
//        return "/stock/weiwai/code";
//    }

//


//
//
//    //打印委外隐形配镜单
//    @GetMapping("/yxPeijingdan")
//    String yxPeijingdan(String danjuNumber, Model model) {
//        WeiwaiDO weiwaiDO = weiwaiService.yxPeijingdan(danjuNumber);
//        model.addAttribute("weiwaiDO", weiwaiDO);
//        //———获取当前系统时间—————
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//        Date date = new Date();
//        String dayinDay = sdf.format(date);
//        model.addAttribute("dayinDay", dayinDay);
//        return "/stock/weiwai/yxPeijingdan";
//    }
//    ///打印委外隐形配镜单列表
//    @ResponseBody
//    @RequestMapping(value = "/yxPeijingdanList")
//    public List<WeiwaiDO> yxPeijingdanList(String danjuNumber ,Model model ) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("danjuNumber", danjuNumber);
//        List<WeiwaiDO> weiwaiDOList = weiwaiService.yxPeijingdanList(map);
//        model.addAttribute("weiwaiDOList", weiwaiDOList);
//        return weiwaiDOList;
//    }

    /**
     * 批量打印
     */
    @GetMapping("/dayinList")
    @RequiresPermissions("stock:weiwai:danyiinList")
    String dayinList(String[] ids, String[] danjuNumbers, String[] mfrsid, String mfrsnames, Model model) {
        model.addAttribute("ids", ids);
        String danjuNumber = "";
        for (int i = 0; i < danjuNumbers.length; i++) {
            danjuNumber += danjuNumbers[i] + ",";
        }
        model.addAttribute("danjuNumber", danjuNumber);
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsnames", mfrsnames);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String dayinDay = sdf.format(date);
        model.addAttribute("dayinDay", dayinDay);
        //------制单人------
        String zhidanPeoples = ShiroUtils.getUser().getName();
        model.addAttribute("zhidanPeoples", zhidanPeoples);
        return "/stock/weiwai/dayinList";
    }

    /**
     * 导出
     *
     * @throws IOException
     */
    @GetMapping("/out")
    @RequiresPermissions("stock:weiwai:out")
    public void out(String[] arrys, HttpServletRequest request, HttpServletResponse response) throws IOException{
        weiwaiService.weiwaiOut(arrys,request, response);
    }


}