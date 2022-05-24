package com.shiguang.stock.service.impl;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.common.config.BootdoConfig;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.storeSales.domain.SalesDO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.stock.dao.WeiwaiDao;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.WeiwaiService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class WeiwaiServiceImpl implements WeiwaiService {
	@Autowired
	private WeiwaiDao weiwaiDao;
	@Autowired
	private BootdoConfig bootdoConfig;



	@Override
	public WeiwaiDO get(Long id) {
		return weiwaiDao.get(id);
	}

	@Override
	public WeiwaiDO weiwaiOrder(WeiwaiDO weiwai) {
		return weiwaiDao.weiwaiOrder(weiwai);
	}

	@Override
	public List<WeiwaiDO> list(Map<String, Object> map) {
		return weiwaiDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return weiwaiDao.count(map);
	}

	@Override
	public int save(WeiwaiDO weiwai) {
		return weiwaiDao.save(weiwai);
	}

	@Override
	public int update(WeiwaiDO weiwai) {
		return weiwaiDao.update(weiwai);
	}

	@Override
	public int remove(Long id) {
		return weiwaiDao.remove(id);
	}

	@Override
	public int removeSale(String saleNumber) {
		return weiwaiDao.removeSale(saleNumber);
	}

	@Override
	public int removes(WeiwaiDO weiwaiDO) {
		return weiwaiDao.removes(weiwaiDO);
	}

	@Override
	public int batchRemove(Long[] ids) {
		return weiwaiDao.batchRemove(ids);
	}

	@Override
	public DepartmentDO phoneOrAddres(Map<String, Object> map) {
		return weiwaiDao.phoneOrAddres(map);
	}

	@Override
	public List<SalesDO> selectOrder(Map<String, Object> map) {
		return weiwaiDao.selectOrder(map);
	}

	@Override
	public int selectOrderCount(Map<String, Object> map) {
		return weiwaiDao.selectOrderCount(map);
	}

	@Override
	public JpdzDO getBrandJp(String num) {
		return weiwaiDao.getBrandJp(num);
	}

	@Override
	public YxdzDO getBrandYx(String num) {
		return weiwaiDao.getBrandYx(num);
	}

	@Override
	public List<WeiwaiDO> selectWeiwaiOrder(Map<String, Object> map) {
		return weiwaiDao.selectWeiwaiOrder(map);
	}


	@Override
	public int updateStatus(WeiwaiDO weiwaiDO) {
		return weiwaiDao.updateStatus(weiwaiDO);
	}

	@Override
	public WeiwaiDO getCode(String danjuNumber) {
		return weiwaiDao.getCode(danjuNumber);
	}

	@Override
	public List<WeiwaiDO> weiwaiOrderOut(String[] arrys) {
		return weiwaiDao.weiwaiOrderOut(arrys);
	}


	public Map<String, Object>  weiwaiOutList(@Param("arrys") String[] arrys, HttpServletRequest request, HttpServletResponse response) {
		List<WeiwaiDO> weiwaiDOList = weiwaiOrderOut(arrys);
		List<Map<String, Object>> allList = new ArrayList<>();
		int a=0;
		for (WeiwaiDO weiwaiDO:weiwaiDOList){
			Map<String, Object> params = new HashMap();
			String danjuNumber=weiwaiDO.getDanjuNumber();
			String danjuDay=weiwaiDO.getDanjuDay();
			String eyeStyle=weiwaiDO.getEyeStyle();
			String zhidanPeople=weiwaiDO.getZhidanPeople();
			String mfrsid=weiwaiDO.getMfrsid();
			String mfrsname=weiwaiDO.getMfrsname();
			String brandnum=weiwaiDO.getBrandnum();
			String viewGoodName=weiwaiDO.getViewGoodName();
			Long positionId=weiwaiDO.getPositionId();
			String positionName=weiwaiDO.getPositionName();
			String shouhuoPeople=weiwaiDO.getShouhuoPeople();
			String shouhuoPhone=weiwaiDO.getShouhuoPhone();
			String shouhuoAddress=weiwaiDO.getShouhuoAddress();
			String changjiaNumber=weiwaiDO.getChangjiaNumber();
			String beizhu=weiwaiDO.getBeizhu();
			String weiwaisaleNumber=weiwaiDO.getWeiwaisaleNumber();
			String mirrorTime=weiwaiDO.getMirrorTime();
			String num=weiwaiDO.getNum();
			String code=weiwaiDO.getCode();
			String name=weiwaiDO.getName();
			String style=weiwaiDO.getStyle();
			String rl=weiwaiDO.getRl();
			String count=weiwaiDO.getCount();
			String sph=weiwaiDO.getSph();
			String cyl=weiwaiDO.getCyl();
			String zx=weiwaiDO.getZx();
			String add=weiwaiDO.getAdd();
			String slj=weiwaiDO.getSlj();
			String zj=weiwaiDO.getZj();
			String fartj=weiwaiDO.getFartj();
			String neartj=weiwaiDO.getNeartj();
			String tg=weiwaiDO.getTg();
			String yaoqiu=weiwaiDO.getYaoqiu();
			String jd=weiwaiDO.getJd();
			String qulv=weiwaiDO.getQulv();
			String gkname=weiwaiDO.getGkname();
			String hyknum=weiwaiDO.getHyknum();
			String phone=weiwaiDO.getPhone();
			String saleNumber=weiwaiDO.getSaleNumber();
			String companyName=weiwaiDO.getCompanyName();
			String departname=weiwaiDO.getDepartname();
			params.put("danjuNumber",danjuNumber);
			params.put("danjuDay",danjuDay);
			params.put("eyeStyle",eyeStyle);
			params.put("zhidanPeople",zhidanPeople);
			params.put("mfrsid",mfrsid);
			params.put("mfrsname",mfrsname);
			params.put("brandnum",brandnum);
			params.put("viewGoodName",viewGoodName);
			params.put("positionId",positionId);
			params.put("positionName",positionName);
			params.put("shouhuoPeople",shouhuoPeople);
			params.put("shouhuoPhone",shouhuoPhone);
			params.put("shouhuoAddress",shouhuoAddress);
			params.put("changjiaNumber",changjiaNumber);
			params.put("beizhu",beizhu);
			params.put("weiwaisaleNumber",weiwaisaleNumber);
			params.put("mirrorTime",mirrorTime);
			params.put("num",num);
			params.put("code",code);
			params.put("name",name);
			params.put("style",style);
			params.put("rl",rl);
			params.put("count",count);
			params.put("sph",sph);
			params.put("cyl",cyl);
			params.put("zx",zx);
			params.put("add",add);
			params.put("slj",slj);
			params.put("zj",zj);
			params.put("fartj",fartj);
			params.put("neartj",neartj);
			params.put("tg",tg);
			params.put("yaoqiu",yaoqiu);
			params.put("jd",jd);
			params.put("qulv",qulv);
			params.put("gkname",gkname);
			params.put("hyknum",hyknum);
			params.put("phone",phone);
			params.put("saleNumber",saleNumber);
			params.put("companyName",companyName);
			params.put("departname",departname);
			allList.add(a,params);
			a=a+1;
		}
		List<Map<String, Object>> arry = new ArrayList<>();
		for (int i=0;i<allList.size();i++){
			Map<String,Object> map=new HashMap<>();
			int count1=0;
			int count2=0;
			for (int j=0;j<allList.size();j++){
				if (allList.get(i).get("danjuNumber").equals(allList.get(j).get("danjuNumber"))
						&& allList.get(i).get("saleNumber").equals(allList.get(j).get("saleNumber")) ){
					if ("右".equals(allList.get(j).get("rl"))){
						String saleNumberR= (String) allList.get(j).get("saleNumber");
						String viewGoodNameR= (String) allList.get(j).get("viewGoodName");
						String styleR= (String) allList.get(j).get("style");
						String rlR= "R";
						String sphR=(String) allList.get(j).get("sph");
						String cylR=(String) allList.get(j).get("cyl");
						String zxR=(String) allList.get(j).get("zx");
						String fartjR=(String) allList.get(j).get("fartj");
						String neartjR=(String) allList.get(j).get("neartj");
						String tgR=(String) allList.get(j).get("tg");
						String addR=(String) allList.get(j).get("add");
						String sljR=(String) allList.get(j).get("slj");
						String jdR=(String) allList.get(j).get("jd");
						String zjR=(String) allList.get(j).get("zj");
						String qlR=(String) allList.get(j).get("qulv");
						String countR=(String) allList.get(j).get("count");
						count1=Integer.valueOf(countR);
						String tiimeR=(String) allList.get(j).get("mirrorTime");
						String beizhuR=(String) allList.get(j).get("beizhu");
						String gkname=(String) allList.get(j).get("gkname");
						String departname=(String) allList.get(j).get("departname");
						String companyName= (String) allList.get(j).get("companyName");
						String mfrsname= (String) allList.get(j).get("mfrsname");
						String danjuDay= (String) allList.get(j).get("danjuDay");
						map.put("saleNumberR",saleNumberR);
						map.put("viewGoodNameR",viewGoodNameR);
						map.put("styleR",styleR);
						map.put("rlR",rlR);
						map.put("sphR",sphR);
						map.put("cylR",cylR);
						map.put("zxR",zxR);
						map.put("fartjR",fartjR);
						map.put("neartjR",neartjR);
						map.put("tgR",tgR);
						map.put("addR",addR);
						map.put("sljR",sljR);
						map.put("jdR",jdR);
						map.put("zjR",zjR);
						map.put("qlR",qlR);
						map.put("countR",countR);
						map.put("tiimeR",tiimeR);
						map.put("departname",departname);
						map.put("beizhuR",beizhuR);
						map.put("gkname",gkname);
						map.put("companyName",companyName);
						map.put("mfrsname",mfrsname);
						map.put("danjuDay",danjuDay);
					}else {
						String saleNumberL= (String) allList.get(j).get("saleNumber");
						String viewGoodNameL= (String) allList.get(j).get("viewGoodName");
						String styleL= (String) allList.get(j).get("style");
						String rlL= "L";
						String sphL=(String) allList.get(j).get("sph");
						String cylL=(String) allList.get(j).get("cyl");
						String zxL=(String) allList.get(j).get("zx");
						String fartjL=(String) allList.get(j).get("fartj");
						String neartjL=(String) allList.get(j).get("neartj");
						String tgL=(String) allList.get(j).get("tg");
						String addL=(String) allList.get(j).get("add");
						String sljL=(String) allList.get(j).get("slj");
						String jdL=(String) allList.get(j).get("jd");
						String zjL=(String) allList.get(j).get("zj");
						String qlL=(String) allList.get(j).get("qulv");
						String countL=(String) allList.get(j).get("count");
						count2=Integer.valueOf(countL);
						String tiimeL=(String) allList.get(j).get("mirrorTime");
						String beizhuL=(String) allList.get(j).get("beizhu");
						map.put("saleNumberL",saleNumberL);
						map.put("viewGoodNameL",viewGoodNameL);
						map.put("styleL",styleL);
						map.put("rlL",rlL);
						map.put("sphL",sphL);
						map.put("cylL",cylL);
						map.put("zxL",zxL);
						map.put("fartjL",fartjL);
						map.put("neartjL",neartjL);
						map.put("tgL",tgL);
						map.put("addL",addL);
						map.put("sljL",sljL);
						map.put("jdL",jdL);
						map.put("zjL",zjL);
						map.put("qlL",qlL);
						map.put("countL",countL);
						map.put("tiimeL",tiimeL);
						map.put("beizhuL",beizhuL);
					}
				}
				Integer allcount= count1+count2;
				map.put("allcount",allcount);
			}
			arry.add(i,map);
		}


		HashSet h = new HashSet(arry);
		arry.clear();
		arry.addAll(h);
		List<Map<String, Object>> arryOne = new ArrayList<>();
		List<Map<String, Object>> countOne = new ArrayList<>();
		Integer countNew=0;
		for (int i=0;i<arry.size();i++){
			if (i==0){
				String companyName= (String) arry.get(i).get("companyName");
				String mfrsname= (String) arry.get(i).get("mfrsname");
				Integer countNews = (Integer) arry.get(i).get("allcount");
				countNew=countNew+countNews;
				Map<String,Object> map=new HashMap<>();
				map.put("companyName",companyName);
				map.put("mfrsname",mfrsname);
				arryOne.add(i,map);
			}else {
				Integer countNews = (Integer) arry.get(i).get("allcount");
				countNew=countNew+countNews;
			}
		}
		Map<String,Object> mapNew=new HashMap<>();
		mapNew.put("countNew",countNew);
		countOne.add(mapNew);

		Map<String, Object> outList = new HashMap();
		outList.put("arry",arry);
		outList.put("arryOne",arryOne);
		outList.put("countOne",countOne);
		String companyIdNow=ShiroUtils.getUser().getCompanyId();
		Map<String,Object> mapxinxi=new HashMap<>();
		mapxinxi.put("companyid",companyIdNow);
		mapxinxi.put("positionOrder", 2);
		if(companyIdNow.equals(3)||companyIdNow.equals("3")){
			mapxinxi.put("positionId", 7);
		}
		DepartmentDO departmentDO = phoneOrAddres(mapxinxi);
		List<Map<String, Object>> xinxi = new ArrayList<>();
		Map<String,Object> xinximap=new HashMap<>();
		String zhidanPeople=ShiroUtils.getUser().getName();
		String shouhuoAddress=departmentDO.getDepartAddress();
		String shouhuoPhone=departmentDO.getDepartTel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String day = sdf.format(date);
		xinximap.put("day",day);
		xinximap.put("zhidanPeople",zhidanPeople);
		xinximap.put("shouhuoPhone",shouhuoPhone);
		xinximap.put("shouhuoAddress",shouhuoAddress);
		xinxi.add(0,xinximap);
		outList.put("xinxi",xinxi);
		return outList;
	}
	public void createDoc(HttpServletResponse response, Map<String, Object>  dataMap, String fileName, String template) {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(WeiwaiServiceImpl.class, "/");
		Template t = null;
		try {
			t = configuration.getTemplate(template,"utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes(), "iso-8859-1")+".xlsx");
			Cookie status = new Cookie("status","success");
			status.setMaxAge(600);
			response.addCookie(status);
			Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			t.process(dataMap, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void weiwaiOut(@Param("arrys") String[] arrys, HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object>  outList = weiwaiOutList(arrys,request, response);
			createDoc(response,outList, "委外订单"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), "weiwaiOut.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			File file=new File(bootdoConfig.getPoiword());
			if(file.exists()) {
				File[] files = file.listFiles();
				for(File f :files)
					f.delete();
			}

		}
	}

	public Map<String, Object>  weiwaiOutdzList(@Param("arrys") String[] arrys, HttpServletRequest request, HttpServletResponse response) {
		List<WeiwaiDO> weiwaiDOList = weiwaiOrderOut(arrys);
		List<Map<String, Object>> arry = new ArrayList<>();
		int a=0;
		for (WeiwaiDO weiwaiDO:weiwaiDOList){
			Map<String, Object> params = new HashMap();
			String danjuNumber=weiwaiDO.getDanjuNumber();
			String danjuDay=weiwaiDO.getDanjuDay();
			String eyeStyle=weiwaiDO.getEyeStyle();
			String zhidanPeople=weiwaiDO.getZhidanPeople();
			String mfrsid=weiwaiDO.getMfrsid();
			String mfrsname=weiwaiDO.getMfrsname();
			String brandnum=weiwaiDO.getBrandnum();
			String viewGoodName=weiwaiDO.getViewGoodName();
			Long positionId=weiwaiDO.getPositionId();
			String positionName=weiwaiDO.getPositionName();
			String shouhuoPeople=weiwaiDO.getShouhuoPeople();
			String shouhuoPhone=weiwaiDO.getShouhuoPhone();
			String shouhuoAddress=weiwaiDO.getShouhuoAddress();
			String changjiaNumber=weiwaiDO.getChangjiaNumber();
			String beizhu=weiwaiDO.getBeizhu();
			String weiwaisaleNumber=weiwaiDO.getWeiwaisaleNumber();
			String mirrorTime=weiwaiDO.getMirrorTime();
			String num=weiwaiDO.getNum();
			String code=weiwaiDO.getCode();
			String name=weiwaiDO.getName();
			String style=weiwaiDO.getStyle();
			String count=weiwaiDO.getCount();
			String gkname=weiwaiDO.getGkname();
			String hyknum=weiwaiDO.getHyknum();
			String phone=weiwaiDO.getPhone();
			String saleNumber=weiwaiDO.getSaleNumber();
			String companyName=weiwaiDO.getCompanyName();
			String departname=weiwaiDO.getDepartname();
			params.put("danjuNumber",danjuNumber);
			params.put("danjuDay",danjuDay);
			params.put("eyeStyle",eyeStyle);
			params.put("zhidanPeople",zhidanPeople);
			params.put("mfrsid",mfrsid);
			params.put("mfrsname",mfrsname);
			params.put("brandnum",brandnum);
			params.put("viewGoodName",viewGoodName);
			params.put("positionId",positionId);
			params.put("positionName",positionName);
			params.put("shouhuoPeople",shouhuoPeople);
			params.put("shouhuoPhone",shouhuoPhone);
			params.put("shouhuoAddress",shouhuoAddress);
			params.put("changjiaNumber",changjiaNumber);
			params.put("beizhu",beizhu);
			params.put("weiwaisaleNumber",weiwaisaleNumber);
			params.put("mirrorTime",mirrorTime);
			params.put("num",num);
			params.put("code",code);
			params.put("name",name);
			params.put("style",style);
			params.put("rl","");
			params.put("count",count);
			params.put("sph","");
			params.put("cyl","");
			params.put("zx","");
			params.put("add","");
			params.put("slj","");
			params.put("zj","");
			params.put("fartj","");
			params.put("neartj","");
			params.put("tg","");
			params.put("yaoqiu","");
			params.put("jd","");
			params.put("qulv","");
			params.put("gkname",gkname);
			params.put("hyknum",hyknum);
			params.put("phone",phone);
			params.put("saleNumber",saleNumber);
			params.put("companyName",companyName);
			params.put("departname",departname);
			a=a+Integer.parseInt(count);
			arry.add(params);
		}

		HashSet h = new HashSet(arry);
		arry.clear();
		arry.addAll(h);
		Map<String, Object> outList = new HashMap();
		outList.put("arry",arry);
		String companyIdNow=ShiroUtils.getUser().getCompanyId();
		Map<String,Object> mapxinxi=new HashMap<>();
		mapxinxi.put("companyid",companyIdNow);
		mapxinxi.put("positionOrder", 2);
		if(companyIdNow.equals(3)||companyIdNow.equals("3")){
			mapxinxi.put("positionId", 7);
		}
		DepartmentDO departmentDO = phoneOrAddres(mapxinxi);
		List<Map<String, Object>> xinxi = new ArrayList<>();
		Map<String,Object> xinximap=new HashMap<>();
		String zhidanPeople=ShiroUtils.getUser().getName();
		String shouhuoAddress=departmentDO.getDepartAddress();
		String shouhuoPhone=departmentDO.getDepartTel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String day = sdf.format(date);
		xinximap.put("day",day);
		xinximap.put("zhidanPeople",zhidanPeople);
		xinximap.put("shouhuoPhone",shouhuoPhone);
		xinximap.put("shouhuoAddress",shouhuoAddress);
		xinxi.add(0,xinximap);
		outList.put("xinxi",xinxi);
		outList.put("companyName",ShiroUtils.getUser().getCompany());
		outList.put("danjuDay",weiwaiDOList.get(0).getDanjuDay());
		outList.put("danjuNumber",weiwaiDOList.get(0).getDanjuNumber());
		outList.put("mfrsname",weiwaiDOList.get(0).getMfrsname());
		outList.put("hejisum",a);
		return outList;
	}

	@Override
	public void weiwaiOutdz(@Param("arrys") String[] arrys, HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object>  outList = weiwaiOutdzList(arrys,request, response);
			createDoc(response,outList, "视光委外订单"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), "shiguangdz.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			File file=new File(bootdoConfig.getPoiword());
			if(file.exists()) {
				File[] files = file.listFiles();
				for(File f :files)
					f.delete();
			}

		}
	}

}
