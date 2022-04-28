package com.shiguang.storeSales.service.impl;

import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.integral.domain.IntegralDO;
import com.shiguang.integral.service.IntegralService;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.packageManager.service.PackageInfoService;
import com.shiguang.packageManager.service.PackageService;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.domain.WeiwaishujuDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.WeiwaiService;
import com.shiguang.stock.service.WeiwaishujuService;
import com.shiguang.storeCard.service.CardService;
import com.shiguang.storeSales.dao.SalesDao;
import com.shiguang.storeSales.domain.*;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	private SalesDao salesDao;
	@Autowired
	private OptometryService optometryService;
	@Autowired
	private ResultDiopterService resultDiopterService;
	@Autowired
	private SalesService salesService;
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
	@Autowired
	private HcService hcService;
	@Autowired
	private OldlensService oldlensService;
	@Autowired
	private ShiguangService shiguangService;
	@Autowired
	private HlyService hlyService;
	@Autowired
	private YxcpService yxcpService;
	@Autowired
	private YxdzService yxdzService;
	@Autowired
	private GiveawayService giveawayService;
	@Autowired
	private StockService stockService;
	@Autowired
	private CostService costService;
	@Autowired
	private PackageService packageService;
	@Autowired
	private ResultService resultService;
	@Autowired
	private KjjyService kjjyService;
	@Autowired
	private KjyyService kjyyService;
	@Autowired
	private SgjjService sgjjService;
	@Autowired
	private ZyService zyService;
	@Autowired
	private RxjmjcjService rxjmjcjService;
	@Autowired
	private SjxlService sjxlService;
	@Autowired
	private VstService vstService;
	@Autowired
	private CrtService crtService;
	@Autowired
	private RgpService rgpService;
	@Autowired
	private YaopinService yaopinService;
	@Autowired
	private PackageInfoService packageInfoService;
	@Autowired
	private LogStatusService logStatusService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private WeiwaishujuService weiwaishujuService;
	@Autowired
	private WeiwaiService weiwaiService;
	@Autowired
	private MfrsService mfrsService;
	@Autowired
	private CardService cardService;
	@Autowired
	private IntegralService integralService;
	
	@Override
	public SalesDO get(Long id){
		return salesDao.get(id);
	}
	
	@Override
	public List<SalesDO> list(Map<String, Object> map){
		return salesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return salesDao.count(map);
	}
	
	@Override
	public int save(SalesDO sales){
		return salesDao.save(sales);
	}

	@Override
	public int updateSale(SalesDO sales){
		return salesDao.updateSale(sales);
	}
	
	@Override
	public int update(SalesDO sales){
		return salesDao.update(sales);
	}
	
	@Override
	public int remove(Long id){
		return salesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return salesDao.batchRemove(ids);
	}

	@Override
	public List<EyesWay> findWay(Map<String, Object> map){
		return salesDao.findWay(map);
	}

	@Override
	public SalesDO findDataByNumber(Map<String,Object> map){
		return salesDao.findDataByNumber(map);
	}

	@Override
	public List<ZipianDO> findZpian(Map<String, Object> map){
		return salesDao.findZpian(map);
	}

	@Override
	public List<ZijiaDO> findZjia(Map<String, Object> map){
		return salesDao.findZjia(map);
	}

	@Override
	public int countZpian(Map<String, Object> map){
		return salesDao.countZpian(map);
	}

	@Override
	public int countZjia(Map<String, Object> map){
		return salesDao.count(map);
	}

	@Override
	public List<Conclusion> conclusionList(Map<String, Object> map){
		return salesDao.findAll(map);
	}

	@Override
	public List<SalesDO> peijinglist(Map<String, Object> map){
		return salesDao.peijinglist(map);
	}

	@Override
	public int peijingcount(Map<String, Object> map){
		return salesDao.peijingcount(map);
	}

	@Override
	public SalesDO getSaleNumber(String saleNumber){
		return salesDao.getSaleNumber(saleNumber);
	}

	@Override
	public List<SalesDO> salelist(Map<String, Object> map){
		return salesDao.salelist(map);
	}

	@Override
	public int salecount(Map<String, Object> map){
		return salesDao.salecount(map);
	}

	@Override
	public int removeSaleNum(String saleNumber){
		return salesDao.removeSaleNum(saleNumber);
	}

	@Override
	@Transactional
	public R saleSave(SalesDO salesDO){
		if (!"辅料".equals(salesDO.getEyeType())){
			if (null == salesDO.getIsJp() || null == salesDO.getIsJj()) {
				salesDO.setIsJp(0L);
				salesDO.setIsJj("无");
			}
			if (null !=salesDO.getStoreDescribe()){
				if (!salesDO.getStoreDescribe().contains("隐形")){
					if ("镜架".equals(salesDO.getStoreDescribe())
							|| "镜片".equals(salesDO.getStoreDescribe())) {
						if (salesDO.getIsJp() < 2 && "无".equals(salesDO.getIsJj())) {
							return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
						}
					}
					if (salesDO.getIsJp() < 2 ) {
						return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
					}
				}
			}
			String[] leftRight = salesDO.getLeftRight().split(",");
			String[] storeDescribe = salesDO.getStoreDescribe().split(",");
			boolean resultRight = false;
			boolean resultLeft = false;
			boolean zipian = false;
			resultRight = Arrays.asList(leftRight).contains("右");
			resultLeft = Arrays.asList(leftRight).contains("左");
			zipian = Arrays.asList(storeDescribe).contains("自片");
			if (!"隐形".equals(salesDO.getEyeType()) && zipian == false){
				if (resultRight == false || resultLeft == false){
					return R.error("镜片选择左右眼重复，请重新选择！");
				}
			}

		}
		Long saleNumber = GuuidUtil.getUUID();
		salesDO.setSaleNumber("X" + saleNumber);
		if (null != salesDO) {
			if (null != salesDO.getAdditionalCost()) {
				salesDO.setAdditionalCost(salesDO.getAdditionalCost());
			}
			if (null != salesDO.getGiveName()) {
				salesDO.setGiveName(salesDO.getGiveName().substring(0, salesDO.getGiveName().length() - 1));
			}
			if (null != salesDO.getProcessAsk()) {
				salesDO.setProcessAsk(salesDO.getProcessAsk());
			}
			if (null != salesDO.getPtometryNumber() && !"".equals(salesDO.getPtometryNumber())){
				try {
					String[] pto = salesDO.getPtometryNumber().split(",");
					if (pto.length > 0){
						salesDO.setPtometryNumber(pto[0]);
					} else {
						salesDO.setPtometryNumber("Y"+GuuidUtil.getUUID());
					}
				}catch (ArrayIndexOutOfBoundsException e) {
					salesDO.setPtometryNumber("Y"+GuuidUtil.getUUID());
				}
			} else {
				salesDO.setPtometryNumber("Y"+GuuidUtil.getUUID());
			}
			if ("2".equals(salesDO.getChufang())) {
				salesDO.setPtometryNumber("Y"+GuuidUtil.getUUID());
			}
//            if (null != salesDO.getStoreName()){
//                salesDO.setStoreName(salesDO.getStoreName().substring(0,salesDO.getStoreName().length()-3));
//            }
//            if (null != salesDO.getStoreUnit()){
//                salesDO.setStoreUnit(salesDO.getStoreUnit().substring(0,salesDO.getStoreUnit().length()-3));
//            }
//            if (null != salesDO.getStoreCount()){
//                salesDO.setStoreCount(salesDO.getStoreCount().substring(0,salesDO.getStoreCount().length()-2));
//            }
		}
		//Model model=null;
		//保存瞳高
		if (!"".equals(salesDO.getRecipelType()) && null != salesDO.getRecipelType()){
			if ("远用".equals(salesDO.getRecipelType())){
				salesDO.setRighttg(salesDO.getRighttonggaoyy());
				salesDO.setLefttg(salesDO.getLefttonggaoyy());
			} else if ("近用".equals(salesDO.getRecipelType())){
				salesDO.setRighttg(salesDO.getRighttonggaojy());
				salesDO.setLefttg(salesDO.getLefttonggaojy());
			} else if ("渐进/双光".equals(salesDO.getRecipelType())){
				salesDO.setRighttg(salesDO.getRighttonggaosg());
				salesDO.setLefttg(salesDO.getLefttonggaosg());
			} else if ("中用".equals(salesDO.getRecipelType())){
				salesDO.setRighttg(salesDO.getRighttonggaozy());
				salesDO.setLefttg(salesDO.getLefttonggaozy());
			}
		} else if (null != salesDO.getRecipelwlType() && !"".equals(salesDO.getRecipelwlType())){
			if (salesDO.getRecipelwlType() == 2){
				salesDO.setRighttg(salesDO.getRighttonggaoyy());
				salesDO.setLefttg(salesDO.getLefttonggaoyy());
			} else if (salesDO.getRecipelwlType() == 1){
				salesDO.setRighttg(salesDO.getRighttonggaojy());
				salesDO.setLefttg(salesDO.getLefttonggaojy());
			} else if (salesDO.getRecipelwlType() == 3){
				salesDO.setRighttg(salesDO.getRighttonggaosg());
				salesDO.setLefttg(salesDO.getLefttonggaosg());
			} else if (salesDO.getRecipelwlType() == 4){
				salesDO.setRighttg(salesDO.getRighttonggaozy());
				salesDO.setLefttg(salesDO.getLefttonggaozy());
			}
		}


		if ("2".equals(salesDO.getChufang())) {
			if (salesDO.getRecipelwlType() == 1) {
				KjjyDO kjjyDO = new KjjyDO();
				kjjyDO.setNewOld(salesDO.getNewOld());
				kjjyDO.setPtometryNumber(salesDO.getPtometryNumber());
				kjjyDO.setCardNumber(salesDO.getMemberNumber());
				kjjyDO.setSaleNumber(salesDO.getSaleNumber());
				kjjyDO.setKjjyDoctor("无");
				kjjyDO.setCreateTime(new Date());
				kjjyDO.setKjjyPrescriptionType(salesDO.getRecipelwlType().toString());
				kjjyDO.setKjjyOptometryName(salesDO.getOptometrywlName());
				kjjyDO.setKjjySphod(salesDO.getRightQJjy());
				kjjyDO.setKjjySphos(salesDO.getLeftQJjy());
				if ("".equals(salesDO.getRightZJjy()) || null == salesDO.getRightZJjy()){
					kjjyDO.setKjjyCylod("0.00");
				}else {
					kjjyDO.setKjjyCylod(salesDO.getRightZJjy());
				}
				if ("".equals(salesDO.getLeftZJjy()) || null == salesDO.getLeftZJjy()){
					kjjyDO.setKjjyCylos("0.00");
				}else {
					kjjyDO.setKjjyCylos(salesDO.getLeftZJjy());
				}
				kjjyDO.setKjjyAxialod(salesDO.getRightzhouxiangjy());
				kjjyDO.setKjjyAxialos(salesDO.getLeftzhouxiangjy());
				kjjyDO.setKjjyPrismod(salesDO.getRightsanlingjingjy());
				kjjyDO.setKjjyPrismos(salesDO.getLeftsanlingjingjy());
				kjjyDO.setKjjyJdod(salesDO.getRightjidijy());
				kjjyDO.setKjjyJdos(salesDO.getLeftjidijy());
				kjjyDO.setKjjyYytjod(salesDO.getRightyuanyongtjjy());
				kjjyDO.setKjjyYytjos(salesDO.getLeftyuanyongtjjy());
				kjjyDO.setKjjyTgod(salesDO.getRighttonggaojy());
				kjjyDO.setKjjyTgos(salesDO.getLefttonggaojy());
				kjjyDO.setKjjyVaod(salesDO.getRightyuanyongVAjy());
				kjjyDO.setKjjyVaos(salesDO.getLeftyuanyongVAjy());
				kjjyDO.setStatus("1");
				kjjyService.save(kjjyDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 2) {
				KjyyDO kjyyDO = new KjyyDO();
				kjyyDO.setNewOld(salesDO.getNewOld());
				kjyyDO.setPtometryNumber(salesDO.getPtometryNumber());
				kjyyDO.setCardNumber(salesDO.getMemberNumber());
				kjyyDO.setKjyyDoctor("无");
				kjyyDO.setCreateTime(new Date());
				kjyyDO.setSaleNumber(salesDO.getSaleNumber());
				kjyyDO.setKjyyPrescriptionType(salesDO.getRecipelwlType().toString());
				kjyyDO.setKjyyOptometryName(salesDO.getOptometrywlName());
				kjyyDO.setKjyySphod(salesDO.getRightQJyy());
				kjyyDO.setKjyySphos(salesDO.getLeftQJyy());
				if ("".equals(salesDO.getRightZJyy()) || null == salesDO.getRightZJyy()){
					kjyyDO.setKjyyCylod("0.00");
				} else {
					kjyyDO.setKjyyCylod(salesDO.getRightZJyy());
				}
				if ("".equals(salesDO.getLeftZJyy()) || null == salesDO.getLeftZJyy()){
					kjyyDO.setKjyyCylos("0.00");
				} else {
					kjyyDO.setKjyyCylos(salesDO.getLeftZJyy());
				}

				kjyyDO.setKjyyAxialod(salesDO.getRightzhouxiangyy());
				kjyyDO.setKjyyAxialos(salesDO.getLeftzhouxiangyy());
				kjyyDO.setKjyyPrismod(salesDO.getRightsanlingjingyy());
				kjyyDO.setKjyyPrismos(salesDO.getLeftsanlingjingyy());
				kjyyDO.setKjyyJdod(salesDO.getRightjidiyy());
				kjyyDO.setKjyyJdos(salesDO.getLeftjidiyy());
				kjyyDO.setKjyyYytjod(salesDO.getRightyuanyongtjyy());
				kjyyDO.setKjyyYytjos(salesDO.getLeftyuanyongtjyy());
				kjyyDO.setKjyyTgod(salesDO.getRighttonggaoyy());
				kjyyDO.setKjyyTgos(salesDO.getLefttonggaoyy());
				kjyyDO.setKjyyVaod(salesDO.getRightyuanyongVAyy());
				kjyyDO.setKjyyVaos(salesDO.getLeftyuanyongVAyy());
				kjyyDO.setStatus("1");
				kjyyService.save(kjyyDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 3) {
				SgjjDO sgjjDO = new SgjjDO();
				sgjjDO.setNewOld(salesDO.getNewOld());
				sgjjDO.setPtometryNumber(salesDO.getPtometryNumber());
				sgjjDO.setCardNumber(salesDO.getMemberNumber());
				sgjjDO.setSaleNumber(salesDO.getSaleNumber());
				sgjjDO.setSgjjDoctor("无");
				sgjjDO.setCreateTime(new Date());
				sgjjDO.setSgjjPrescriptionType(salesDO.getRecipelwlType().toString());
				sgjjDO.setSgjjOptometryName(salesDO.getOptometrywlName());
				sgjjDO.setSgjjSphod(salesDO.getRightQJsg());
				sgjjDO.setSgjjSphos(salesDO.getLeftQJsg());
				if ("".equals(salesDO.getRightZJsg()) || null == salesDO.getRightZJsg()){
					sgjjDO.setSgjjCylod("0.00");
				}else {
					sgjjDO.setSgjjCylod(salesDO.getRightZJsg());
				}
				if ("".equals(salesDO.getLeftZJsg()) || null == salesDO.getLeftZJsg()){
					sgjjDO.setSgjjCylos("0.00");
				}else {
					sgjjDO.setSgjjCylos(salesDO.getLeftZJsg());
				}

				sgjjDO.setSgjjAxialod(salesDO.getRightzhouxiangsg());
				sgjjDO.setSgjjAxialos(salesDO.getLeftzhouxiangsg());
				sgjjDO.setSgjjYytjod(salesDO.getRightyuanyongtjsg());
				sgjjDO.setSgjjYytjos(salesDO.getLeftyuanyongtjsg());
				sgjjDO.setSgjjJytjod(salesDO.getRightjinyongtjsg());
				sgjjDO.setSgjjJytjos(salesDO.getLeftjinyongtjsg());
				sgjjDO.setSgjjTgod(salesDO.getRighttonggaosg());
				sgjjDO.setSgjjTgos(salesDO.getLefttonggaosg());
				sgjjDO.setSgjjYyvaod(salesDO.getRightyuanyongVAsg());
				sgjjDO.setSgjjYyvaos(salesDO.getLeftyuanyongVAsg());
				sgjjDO.setSgjjJyvaod(salesDO.getRightjinyongVAsg());
				sgjjDO.setSgjjJyvaos(salesDO.getLeftjinyongVAsg());
				sgjjDO.setStatus("1");
				sgjjService.save(sgjjDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 4) {
				ZyDO zyDO = new ZyDO();
				zyDO.setNewOld(salesDO.getNewOld());
				zyDO.setPtometryNumber(salesDO.getPtometryNumber());
				zyDO.setCardNumber(salesDO.getMemberNumber());
				zyDO.setSaleNumber(salesDO.getSaleNumber());
				zyDO.setZyDoctor("无");
				zyDO.setCreateTime(new Date());
				zyDO.setZyPrescriptionType(salesDO.getRecipelwlType().toString());
				zyDO.setZyOptometryName(salesDO.getOptometrywlName());
				zyDO.setZySphod(salesDO.getRightQJzy());
				zyDO.setZySphos(salesDO.getLeftQJzy());
				if ("".equals(salesDO.getRightZJzy()) || null == salesDO.getRightZJzy()){
					zyDO.setZyCylod("0.00");
				} else {
					zyDO.setZyCylod(salesDO.getRightZJzy());
				}
				if ("".equals(salesDO.getLeftZJzy()) || null == salesDO.getLeftZJzy()){
					zyDO.setZyCylos("0.00");
				} else {
					zyDO.setZyCylos(salesDO.getLeftZJzy());
				}
				zyDO.setZyAxialod(salesDO.getRightzhouxiangzy());
				zyDO.setZyAxialos(salesDO.getLeftzhouxiangzy());
				zyDO.setZyPrismod(salesDO.getRightsanlingjingzy());
				zyDO.setZyPrismos(salesDO.getLeftsanlingjingzy());
				zyDO.setZyJdod(salesDO.getRightjidizy());
				zyDO.setZyJdos(salesDO.getLeftjidizy());
				zyDO.setZyZytjod(salesDO.getRightyuanyongtjzy());
				zyDO.setZyZytjos(salesDO.getLeftyuanyongtjzy());
				zyDO.setZyTgod(salesDO.getRighttonggaozy());
				zyDO.setZyTgos(salesDO.getLefttonggaozy());
				zyDO.setZyVaod(salesDO.getRightyuanyongVAzy());
				zyDO.setZyVaos(salesDO.getLeftyuanyongVAzy());
				zyDO.setStatus("1");
				zyService.save(zyDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 5) {
				RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
				rxjmjcjDO.setNewOld(salesDO.getNewOld());
				rxjmjcjDO.setPtometryNumber(salesDO.getPtometryNumber());
				rxjmjcjDO.setCardNumber(salesDO.getMemberNumber());
				rxjmjcjDO.setRxDoctor("无");
				rxjmjcjDO.setCreateTime(new Date());
				rxjmjcjDO.setSaleNumber(salesDO.getSaleNumber());
				rxjmjcjDO.setRxPrescriptionType(salesDO.getRecipelwlType().toString());
				rxjmjcjDO.setRxOptometryName(salesDO.getOptometrywlName());
				rxjmjcjDO.setRxSphod(salesDO.getRightQJyx());
				rxjmjcjDO.setRxSphos(salesDO.getLeftQJyx());
				if ("".equals(salesDO.getRightZJyx()) || null == salesDO.getRightZJyx()){
					rxjmjcjDO.setRxCylod("0.00");
				} else {
					rxjmjcjDO.setRxCylod(salesDO.getRightZJyx());
				}
				if ("".equals(salesDO.getLeftZJyx()) || null == salesDO.getLeftZJyx()){
					rxjmjcjDO.setRxCylos("0.00");
				} else {
					rxjmjcjDO.setRxCylos(salesDO.getLeftZJyx());
				}
				rxjmjcjDO.setRxAxialod(salesDO.getRightzhouxiangyx());
				rxjmjcjDO.setRxAxialos(salesDO.getLeftzhouxiangyx());
				rxjmjcjDO.setRxZjod(salesDO.getRightzhijingyx());
				rxjmjcjDO.setRxZjos(salesDO.getLeftzhijingyx());
				rxjmjcjDO.setRxVaod(salesDO.getRightYingXingVAyx());
				rxjmjcjDO.setRxVaos(salesDO.getLeftYingXingVAyx());
				rxjmjcjDO.setStatus("1");
				rxjmjcjService.save(rxjmjcjDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 7) {
				SjxlDO sjxlDO = new SjxlDO();
				sjxlDO.setNewOld(salesDO.getNewOld());
				sjxlDO.setPtometryNumber(salesDO.getPtometryNumber());
				sjxlDO.setCardNumber(salesDO.getMemberNumber());
				sjxlDO.setSjxlDoctor("无");
				sjxlDO.setCreateTime(new Date());
				sjxlDO.setSaleNumber(salesDO.getSaleNumber());
				sjxlDO.setSjxlPrescriptionType(salesDO.getRecipelwlType().toString());
				sjxlDO.setSjxlOptometryName(salesDO.getOptometrywlName());
				sjxlDO.setSjxlSphod(salesDO.getRightQJxl());
				sjxlDO.setSjxlSphos(salesDO.getLeftQJxl());
				if ("".equals(salesDO.getRightZJxl()) || null == salesDO.getRightZJxl()){
					sjxlDO.setSjxlCylod("0.00");
				} else {
					sjxlDO.setSjxlCylod(salesDO.getRightZJxl());
				}
				if ("".equals(salesDO.getLeftZJxl()) || null == salesDO.getLeftZJxl()){
					sjxlDO.setSjxlCylos("0.00");
				} else {
					sjxlDO.setSjxlCylos(salesDO.getLeftZJxl());
				}

				sjxlDO.setSjxlAxialod(salesDO.getRightzhouxiangxl());
				sjxlDO.setSjxlAxialos(salesDO.getLeftzhouxiangxl());
				sjxlDO.setSjxlJdod(salesDO.getRightjidixl());
				sjxlDO.setSjxlJdos(salesDO.getLeftjidixl());
				sjxlDO.setSjxlYytjod(salesDO.getRightSJXLyytj());
				sjxlDO.setSjxlYytjos(salesDO.getLeftSJXLyytj());
				sjxlDO.setSjxlYyvaod(salesDO.getRightSJXLyyva());
				sjxlDO.setSjxlYyvaos(salesDO.getLeftSJXLyyva());
				sjxlDO.setStatus("1");
				sjxlService.save(sjxlDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			}else if (salesDO.getRecipelwlType() == 8){
				VstDO vstDO = new VstDO();
				vstDO.setNewOld(salesDO.getNewOld());
				vstDO.setPtometryNumber(salesDO.getPtometryNumber());
				vstDO.setVstOptometryName(salesDO.getOptometrywlName());
				vstDO.setVstPrescriptionType(salesDO.getRecipelwlType().toString());
				vstDO.setCardNumber(salesDO.getMemberNumber());
				vstDO.setSaleNumber(salesDO.getSaleNumber());
				vstDO.setVstSphod(salesDO.getRightQJvst());
				vstDO.setVstDoctor("无");
				vstDO.setCreateTime(new Date());
				vstDO.setVstSphos(salesDO.getLeftQJvst());
				if ("".equals(salesDO.getRightZJvst()) || null == salesDO.getRightZJvst()){
					vstDO.setVstCylod("0.00");
				} else {
					vstDO.setVstCylod(salesDO.getRightZJvst());
				}
				if ("".equals(salesDO.getLeftZJvst()) || null == salesDO.getLeftZJvst()){
					vstDO.setVstCylos("0.00");
				} else {
					vstDO.setVstCylos(salesDO.getLeftZJvst());
				}
				vstDO.setVstAxialod(salesDO.getRightzhouxiangvst());
				vstDO.setVstAxialos(salesDO.getLeftzhouxiangvst());
				vstDO.setVstSdbhod(salesDO.getRightVstSdjbh());
				vstDO.setVstSdbhos(salesDO.getLeftVstSdjbh());
				vstDO.setVstFkod(salesDO.getRightVstFK());
				vstDO.setVstFkos(salesDO.getLeftVstFK());
				vstDO.setVstQlbjod(salesDO.getRightVstQlbj());
				vstDO.setVstQlbjos(salesDO.getLeftVstQlbj());
				vstDO.setVstAcod(salesDO.getRightVstAC());
				vstDO.setVstAcos(salesDO.getLeftVstAC());
				vstDO.setVstJfod(salesDO.getRightVstJF());
				vstDO.setVstJfos(salesDO.getLeftVstJF());
				vstDO.setVstDiaod(salesDO.getRightVstDIA());
				vstDO.setVstDiaos(salesDO.getLeftVstDIA());
				vstDO.setVstBcod(salesDO.getRightVstBC());
				vstDO.setVstBcos(salesDO.getLeftVstBC());
				vstDO.setVstCpclyod(salesDO.getRightVstCPCLY());
				vstDO.setVstCpclyod(salesDO.getLeftVstCPCLY());
				vstDO.setVstEod(salesDO.getRightVstE());
				vstDO.setVstEos(salesDO.getLeftVstE());
				vstDO.setVstVaod(salesDO.getRightVstVA());
				vstDO.setVstVaos(salesDO.getLeftVstVA());
				vstDO.setStatus("1");
				vstService.save(vstDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 9){
				CrtDO crtDO = new CrtDO();
				crtDO.setNewOld(salesDO.getNewOld());
				crtDO.setPtometryNumber(salesDO.getPtometryNumber());
				crtDO.setCardNumber(salesDO.getMemberNumber());
				crtDO.setCrtOptometryName(salesDO.getOptometrywlName());
				crtDO.setCrtDoctor("无");
				crtDO.setCreateTime(new Date());
				crtDO.setCrtPrescriptionType(salesDO.getRecipelwlType().toString());
				crtDO.setStatus("1");
				crtDO.setCrtSphod(salesDO.getRightQjcrt());
				crtDO.setCrtSphos(salesDO.getLeftQjcrt());
				if ("".equals(crtDO.getCrtCylod()) || null == crtDO.getCrtCylod()){
					crtDO.setCrtCylod("0.00");
				} else {
					crtDO.setCrtCylod(salesDO.getRightZjcrt());
				}
				if ("".equals(crtDO.getCrtCylos()) || null == crtDO.getCrtCylos()){
					crtDO.setCrtCylos("0.00");
				} else {
					crtDO.setCrtCylos(salesDO.getLeftZjcrt());
				}
				crtDO.setCrtAxialod(salesDO.getRightZhouxiangcrt());
				crtDO.setCrtAxialos(salesDO.getLeftZhouxiangcrt());
				crtDO.setCrtSdbhod(salesDO.getRightSdjbhcrt());
				crtDO.setCrtSdbhos(salesDO.getLeftSdjbhcrt());
				crtDO.setCtrBcod(salesDO.getRightBCcrt());
				crtDO.setCrtBcos(salesDO.getLeftBCcrt());
				crtDO.setCrtRzdod(salesDO.getRightRZDcrt());
				crtDO.setCrtRzdos(salesDO.getLeftRZDcrt());
				crtDO.setCrtLzaod(salesDO.getRightLZAcrt());
				crtDO.setCrtLzaos(salesDO.getLeftLZAcrt());
				crtDO.setCrtRzd2od(salesDO.getRightRZD2crt());
				crtDO.setCrtRzd2os(salesDO.getLeftRZD2crt());
				crtDO.setCrtLza2od(salesDO.getRightLZA2crt());
				crtDO.setCrtLza2os(salesDO.getLeftLZA2crt());
				crtDO.setCrtJfod(salesDO.getRightJFcrt());
				crtDO.setCrtJfos(salesDO.getLeftJFcrt());
				crtDO.setCrtDiaod(salesDO.getRightDIAcrt());
				crtDO.setCrtDiaos(salesDO.getLeftDIAcrt());
				crtDO.setCrtVaod(salesDO.getRightVAcrt());
				crtDO.setCrtVaos(salesDO.getLeftVAcrt());
				crtService.save(crtDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 10) {
				RgpDO rgpDO = new RgpDO();
				rgpDO.setNewOld(salesDO.getNewOld());
				rgpDO.setPtometryNumber(salesDO.getPtometryNumber());
				rgpDO.setCardNumber(salesDO.getMemberNumber());
				rgpDO.setRgpDoctor("无");
				rgpDO.setCreateTime(new Date());
				rgpDO.setRgpPrescriptionType(salesDO.getRecipelwlType().toString());
				rgpDO.setRgpOptometryName(salesDO.getOptometrywlName());
				rgpDO.setRgpQgdod(salesDO.getRightRgpgd());
				rgpDO.setRgpQgdos(salesDO.getLeftRgpgd());
				rgpDO.setRgpBcod(salesDO.getRightBC());
				rgpDO.setRgpBcos(salesDO.getLeftBC());
				rgpDO.setRgpDiaod(salesDO.getRightDIA());
				rgpDO.setRgpDiaos(salesDO.getLeftDIA());
				rgpDO.setRgpSgod(salesDO.getRightsg());
				rgpDO.setRgpSgos(salesDO.getLeftsg());
				rgpDO.setRgpJpysod(salesDO.getRightJPColor());
				rgpDO.setRgpJpysos(salesDO.getLeftJPColor());
				rgpDO.setRgpTssjod(salesDO.getRightTssj());
				rgpDO.setRgpTssjos(salesDO.getLeftTssj());
				rgpDO.setRgpSyjpod(salesDO.getRightPinpai());
				rgpDO.setRgpSyjpos(salesDO.getLeftPinpai());
				rgpDO.setStatus("1");
				rgpService.save(rgpDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			} else if (salesDO.getRecipelwlType() == 11) {
				YaopinDO yaopinDO = new YaopinDO();
				yaopinDO.setNewOld(salesDO.getNewOld());
				yaopinDO.setPtometryNumber(salesDO.getPtometryNumber());
				yaopinDO.setCardNumber(salesDO.getMemberNumber());
				yaopinDO.setYpDoctor("无");
				yaopinDO.setCreateTime(new Date());
				yaopinDO.setYpPrescriptionType(salesDO.getRecipelwlType().toString());
				yaopinDO.setYpOptometryName(salesDO.getOptometrywlName());
				yaopinDO.setYpNr(salesDO.getContent());
				yaopinDO.setYpYm(salesDO.getYpName());
				yaopinDO.setStatus("1");
				yaopinService.save(yaopinDO);
				ResultDO resultDO = new ResultDO();
				resultDO.setNewOld(salesDO.getNewOld());
				resultDO.setCardNumber(salesDO.getMemberNumber());
				resultDO.setPtometryNumber(salesDO.getPtometryNumber());
				resultDO.setCreateTime(new Date());
				resultDO.setOptometryName(salesDO.getOptometrywlName());
				resultDO.setStatus("1");
				resultService.save(resultDO);
			}
		} else {
			if ("近用".equals(salesDO.getRecipelType())) {
				KjjyDO kjjyDO = new KjjyDO();
				kjjyDO.setPtometryNumber(salesDO.getPtometryNumber());
				kjjyDO.setKjjyAxialod(salesDO.getRightzhouxiangjy());
				kjjyDO.setKjjyAxialos(salesDO.getLeftzhouxiangjy());
				kjjyDO.setKjjyPrismod(salesDO.getRightsanlingjingjy());
				kjjyDO.setKjjyPrismos(salesDO.getLeftsanlingjingjy());
				kjjyDO.setKjjyJdod(salesDO.getRightjidijy());
				kjjyDO.setKjjyJdos(salesDO.getLeftjidijy());
				kjjyDO.setKjjyYytjod(salesDO.getRightyuanyongtjjy());
				kjjyDO.setKjjyYytjos(salesDO.getLeftyuanyongtjjy());
				kjjyDO.setKjjyTgod(salesDO.getRighttonggaojy());
				kjjyDO.setKjjyTgos(salesDO.getLefttonggaojy());
				kjjyDO.setKjjyVaod(salesDO.getRightyuanyongVAjy());
				kjjyDO.setKjjyVaos(salesDO.getLeftyuanyongVAjy());
				kjjyService.updatekjjy(kjjyDO);
			} else if ("远用".equals(salesDO.getRecipelType())) {
				KjyyDO kjyyDO = new KjyyDO();
				kjyyDO.setPtometryNumber(salesDO.getPtometryNumber());
				kjyyDO.setKjyyPrismod(salesDO.getRightsanlingjingyy());
				kjyyDO.setKjyyPrismos(salesDO.getLeftsanlingjingyy());
				kjyyDO.setKjyyJdod(salesDO.getRightjidiyy());
				kjyyDO.setKjyyJdos(salesDO.getLeftjidiyy());
				kjyyDO.setKjyyYytjod(salesDO.getRightyuanyongtjyy());
				kjyyDO.setKjyyYytjos(salesDO.getLeftyuanyongtjyy());
				kjyyDO.setKjyyTgod(salesDO.getRighttonggaoyy());
				kjyyDO.setKjyyTgos(salesDO.getLefttonggaoyy());
				kjyyDO.setKjyyVaod(salesDO.getRightyuanyongVAyy());
				kjyyDO.setKjyyVaos(salesDO.getLeftyuanyongVAyy());
				kjyyService.updatekjyy(kjyyDO);
			} else if ("渐进/双光".equals(salesDO.getRecipelType())) {
				SgjjDO sgjjDO = new SgjjDO();
				sgjjDO.setPtometryNumber(salesDO.getPtometryNumber());
				sgjjDO.setSgjjYytjod(salesDO.getRightyuanyongtjsg());
				sgjjDO.setSgjjYytjos(salesDO.getLeftyuanyongtjsg());
				sgjjDO.setSgjjJytjod(salesDO.getRightjinyongtjsg());
				sgjjDO.setSgjjJytjos(salesDO.getLeftjinyongtjsg());
				sgjjDO.setSgjjTgod(salesDO.getRighttonggaosg());
				sgjjDO.setSgjjTgos(salesDO.getLefttonggaosg());
				sgjjDO.setSgjjYyvaod(salesDO.getRightyuanyongVAsg());
				sgjjDO.setSgjjYyvaos(salesDO.getLeftyuanyongVAsg());
				sgjjDO.setSgjjJyvaod(salesDO.getRightjinyongVAsg());
				sgjjDO.setSgjjJyvaos(salesDO.getLeftjinyongVAsg());
				sgjjService.updatesgjj(sgjjDO);
			} else if ("中用".equals(salesDO.getRecipelType())) {
				ZyDO zyDO = new ZyDO();
				zyDO.setPtometryNumber(salesDO.getPtometryNumber());
				zyDO.setZyPrismod(salesDO.getRightsanlingjingzy());
				zyDO.setZyPrismos(salesDO.getLeftsanlingjingzy());
				zyDO.setZyJdod(salesDO.getRightjidizy());
				zyDO.setZyJdos(salesDO.getLeftjidizy());
				zyDO.setZyZytjod(salesDO.getRightyuanyongtjzy());
				zyDO.setZyZytjos(salesDO.getLeftyuanyongtjzy());
				zyDO.setZyTgod(salesDO.getRighttonggaozy());
				zyDO.setZyTgos(salesDO.getLefttonggaozy());
				zyDO.setZyVaod(salesDO.getRightyuanyongVAzy());
				zyDO.setZyVaos(salesDO.getLeftyuanyongVAzy());
				zyService.updatezy(zyDO);
			} else if ("隐形".equals(salesDO.getRecipelType())) {
				RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
				rxjmjcjDO.setPtometryNumber(salesDO.getPtometryNumber());
				rxjmjcjDO.setRxZjod(salesDO.getRightzhijingyx());
				rxjmjcjDO.setRxZjos(salesDO.getLeftzhijingyx());
				rxjmjcjDO.setRxVaod(salesDO.getRightYingXingVAyx());
				rxjmjcjDO.setRxVaos(salesDO.getLeftYingXingVAyx());
				rxjmjcjService.updaterxjmjcj(rxjmjcjDO);
			}else if ("角膜塑形镜VST".equals(salesDO.getRecipelType())){
				VstDO vstDO = new VstDO();
				vstDO.setPtometryNumber(salesDO.getPtometryNumber());
				vstDO.setVstSdbhod(salesDO.getRightVstSdjbh());
				vstDO.setVstSdbhos(salesDO.getLeftVstSdjbh());
				vstDO.setVstFkod(salesDO.getRightVstFK());
				vstDO.setVstFkos(salesDO.getLeftVstFK());
				vstDO.setVstQlbjod(salesDO.getRightVstQlbj());
				vstDO.setVstQlbjos(salesDO.getLeftVstQlbj());
				vstDO.setVstAcod(salesDO.getRightVstAC());
				vstDO.setVstAcos(salesDO.getLeftVstAC());
				vstDO.setVstJfod(salesDO.getRightVstJF());
				vstDO.setVstJfos(salesDO.getLeftVstJF());
				vstDO.setVstDiaod(salesDO.getRightVstDIA());
				vstDO.setVstDiaos(salesDO.getLeftVstDIA());
				vstDO.setVstBcod(salesDO.getRightVstBC());
				vstDO.setVstBcos(salesDO.getLeftVstBC());
				vstDO.setVstCpclyod(salesDO.getRightVstCPCLY());
				vstDO.setVstCpclyod(salesDO.getLeftVstCPCLY());
				vstDO.setVstEod(salesDO.getRightVstE());
				vstDO.setVstEos(salesDO.getLeftVstE());
				vstDO.setVstVaod(salesDO.getRightVstVA());
				vstDO.setVstVaos(salesDO.getLeftVstVA());
				vstService.updatevst(vstDO);
			} else if ("角膜塑形镜CRT".equals(salesDO.getRecipelType())){
				CrtDO crtDO = new CrtDO();
				crtDO.setPtometryNumber(salesDO.getPtometryNumber());
				crtDO.setCrtSdbhod(salesDO.getRightSdjbhcrt());
				crtDO.setCrtSdbhos(salesDO.getLeftSdjbhcrt());
				crtDO.setCtrBcod(salesDO.getRightBCcrt());
				crtDO.setCrtBcos(salesDO.getLeftBCcrt());
				crtDO.setCrtRzdod(salesDO.getRightRZDcrt());
				crtDO.setCrtRzdos(salesDO.getLeftRZDcrt());
				crtDO.setCrtLzaod(salesDO.getRightLZAcrt());
				crtDO.setCrtLzaos(salesDO.getLeftLZAcrt());
				crtDO.setCrtRzd2od(salesDO.getRightRZD2crt());
				crtDO.setCrtRzd2os(salesDO.getLeftRZD2crt());
				crtDO.setCrtLza2od(salesDO.getRightLZA2crt());
				crtDO.setCrtLza2os(salesDO.getLeftLZA2crt());
				crtDO.setCrtJfod(salesDO.getRightJFcrt());
				crtDO.setCrtJfos(salesDO.getLeftJFcrt());
				crtDO.setCrtDiaod(salesDO.getRightDIAcrt());
				crtDO.setCrtDiaos(salesDO.getLeftDIAcrt());
				crtDO.setCrtVaod(salesDO.getRightVAcrt());
				crtDO.setCrtVaos(salesDO.getLeftVAcrt());
				crtService.updatecrt(crtDO);
			}
		}
//        CostDO costDO = new CostDO();
//        costDO.setIsSale(0L);
//        costDO.setMemberNumber(salesDO.getMemberNumber());
//        costDO.setSaleNumber(salesDO.getSaleNumber());
//        costDO.setCostType(0L);
//        costDO.setCostMoney(salesDO.getAmountMoney());
//        costDO.setOriginalPrice(salesDO.getPrimeMoney());
//        costDO.setSaleName(salesDO.getSaleName());
//        costDO.setIsSale(0L);
//        costDO.setCreateTime(new Date());
//        costDO.setType("配镜单");
//        costDO.setStoreName(ShiroUtils.getUser().getStore());
//        costDO.setStoreNum(ShiroUtils.getUser().getStore());
//        costService.save(costDO);
		salesDO.setPeijingTime(new Date());
		salesDO.setSaleType("0");
		if ("隐形".equals(salesDO.getEyeType())){
			String[] classType = salesDO.getClasstype().split(",");
			String[] storeSesc = salesDO.getStoreDescribe().split(",");
			for(int w=0;w<storeSesc.length;w++){
				if ("1".equals(classType[w])&& "隐形".equals(storeSesc[w])){
					salesDO.setEyeType("隐形(成品)");
					storeSesc[w] = "隐形成品";
				}
			}
			StringBuilder ss = new StringBuilder();
			for (int d=0;d<storeSesc.length;d++){
				ss.append(storeSesc[d]).append(",");
			}
			ss.deleteCharAt(ss.length() - 1);
			salesDO.setStoreDescribe(ss.toString());
		}
		double jifenNum=0;
		if (null != salesDO.getGoodsNum()){
			String goodsCode = salesDO.getGoodsCode();
			String storeDesc = salesDO.getStoreDescribe();
			String[] goodsStr = goodsCode.split(",");
			String[] goodsDescribe = storeDesc.split(",");
			String[] goodsCount = salesDO.getStoreCount().split(",");
			String[] price = salesDO.getStoreUnit().split(",");
			String[] classType = salesDO.getClasstype().split(",");
			String companyId = "";
			PositionDO positionDO = null;
			if (null != ShiroUtils.getUser().getCompanyId()) {
				companyId = ShiroUtils.getUser().getCompanyId();
				Map<String,Object> map = new HashMap<>();
				map.put("companyId", companyId);
				map.put("departNumber",ShiroUtils.getUser().getStoreNum());
				positionDO = stockService.findPosition(map);
			}
			for (int e=0;e<goodsDescribe.length;e++){
				if (!"镜片".equals(goodsDescribe[e]) && !"隐形".equals(goodsDescribe[e]) && !"自架".equals(goodsDescribe[e])
						&& !"自片".equals(goodsDescribe[e]) && !"赠品".equals(goodsDescribe[e])){
					StockDO stockDOs = new StockDO();
					if (null != positionDO){
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
					} else {
						stockDOs.setPositionId("");
					}
					stockDOs.setGoodsCode(goodsStr[e]);
					StockDO stockDO = stockService.getProduceCode(stockDOs);
					Long countGoods = Long.parseLong(stockDO.getGoodsCount());
					Long count = countGoods - Long.valueOf(goodsCount[e]);
					stockDO.setGoodsCount(String.valueOf(count));
					stockService.updateGoodsCount(stockDO);
				}
				Map<String,Object> jifenmap = new HashMap<>();
//                jifenmap.put("storeNum",salesDO.getStoreNum());
//                jifenmap.put("companyId",ShiroUtils.getUser().getCompanyId());
				List<IntegralDO> integralDOList = integralService.getPoints(jifenmap);
				for (IntegralDO integralDO : integralDOList){
					if("1".equals(classType[e])){
						if ("镜片".equals(goodsDescribe[e]) && "镜片(成品片)".equals(integralDO.getGoodsType())){
							jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
							continue;
						}
						if ("隐形".equals(goodsDescribe[e]) && "隐形(成品片)".equals(integralDO.getGoodsType())){
							jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
							continue;
						}
					} else {
						if ("镜片".equals(goodsDescribe[e]) && "镜片(订做片)".equals(integralDO.getGoodsType())){
							jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
							continue;
						}
						if ("隐形".equals(goodsDescribe[e]) && "隐形(订做片)".equals(integralDO.getGoodsType())){
							jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
							continue;
						}
					}
					if ("镜架".equals(goodsDescribe[e]) && "镜架".equals(integralDO.getGoodsType())){
						jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
						continue;
					}
					if ("护理液".equals(goodsDescribe[e]) && "护理液".equals(integralDO.getGoodsType())){
						jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
						continue;
					}
					if ("太阳镜".equals(goodsDescribe[e]) && "太阳镜".equals(integralDO.getGoodsType())){
						jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
						continue;
					}
					if ("老花镜".equals(goodsDescribe[e]) && "老花镜".equals(integralDO.getGoodsType())){
						jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
						continue;
					}
					if ("视光".equals(goodsDescribe[e]) && "视光".equals(integralDO.getGoodsType())){
						jifenNum = jifenNum +  Double.valueOf(price[e])*Double.valueOf(goodsCount[e])*Double.valueOf(integralDO.getRedeemPoints());
						continue;
					}
				}
			}
		}
//        if(!"1".equals(ShiroUtils.getUser().getCompanyId())){
		if (jifenNum !=0.0){
			MemberDO memberDO = memberService.getCardNumber(salesDO.getMemberNumber());
			if (null != memberDO.getIntegral()){
				int jifen = (int) jifenNum;
				int jifentotal = Integer.parseInt(memberDO.getIntegral()) + jifen;
				memberDO.setIntegral(String.valueOf(jifentotal));
				memberService.updateInteger(memberDO);
			} else {
				int jifen = (int) jifenNum;
				int jifentotal = 0 + jifen;
				memberDO.setIntegral(String.valueOf(jifentotal));
				memberService.updateInteger(memberDO);
			}
		}
//        }

		WorkRecoedDO workRecoedDO = new WorkRecoedDO();
		workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
		workRecoedDO.setType("销售");
		workRecoedDO.setDateTime(new Date());
		logStatusService.saveRecord(workRecoedDO);
		salesDO.setCompanyId(ShiroUtils.getUser().getCompanyId());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String,Object> userMap = new HashMap<>();
		userMap.put("userName",salesDO.getUserName());
		userMap.put("companyId",ShiroUtils.getUser().getCompanyId());
		UserDO userDO =userService.getUserName(userMap);
		salesDO.setSaleName(userDO.getName());
		if (salesService.save(salesDO) > 0) {
			//this.editsetle(salesDO,model);
			if (null != salesDO.getGoodsNum()) {
				String goodsCode = salesDO.getGoodsCode();
				String goodsNum = salesDO.getGoodsNum();
				String storeDesc = salesDO.getStoreDescribe();
				String[] goodsStr = goodsCode.split(",");
				String[] goodNumstr = goodsNum.split(",");
				String[] goodsDescribe = storeDesc.split(",");
				String[] goodsName = salesDO.getStoreName().split(",");
				String[] goodsCount = salesDO.getStoreCount().split(",");
				String[] classType = salesDO.getClasstype().split(",");
				String[] brandName = salesDO.getBrandName().split(",");
				String[] leftRight = salesDO.getLeftRight().split(",");
				String weiwaiNumber = "W" + GuuidUtil.getUUID();
				String danjuNumber = "OUT" + GuuidUtil.getUUID();
				for (int s = 0; s < goodsDescribe.length; s++) {
					if ("镜片".equals(goodsDescribe[s]) && "2".equals(classType[s])) {
						WeiwaishujuDO weiwaishujuDO = new WeiwaishujuDO();
						weiwaishujuDO.setNumber(weiwaiNumber);
						weiwaishujuDO.setDanjuDay(sim.format(new Date()));
						weiwaishujuDO.setDepartname(ShiroUtils.getUser().getStore());
						weiwaishujuDO.setZhidanPeople(salesDO.getSaleName());
						weiwaishujuDO.setTimetime(sim.format(salesDO.getMirrorTime()));
						weiwaishujuDO.setDanjuStyle("1");
						weiwaishujuDO.setSaleNumber(salesDO.getSaleNumber());
						weiwaishujuDO.setWeiwaiStyle("委外订单");
						weiwaishujuDO.setBeizhu("");
						weiwaishujuDO.setGkname(salesDO.getMemberName());
						weiwaishujuDO.setHyknum(salesDO.getMemberNumber());
						weiwaishujuDO.setPhone(salesDO.getMemberTel());
						if ("框镜".equals(salesDO.getEyeType())) {
							weiwaishujuDO.setJcStyle("框镜订做");
							//weiwaishujuDO.setSph();
							if (salesDO.getLeftRight().equals("左")) {
								//处方
								if ("2".equals(salesDO.getOptometrywlName())) {
									if (salesDO.getRecipelwlType() == 1) {
										weiwaishujuDO.setSph(salesDO.getLeftsph());
										weiwaishujuDO.setCyl(salesDO.getLeftcyl());
										weiwaishujuDO.setZx(salesDO.getLeftzx());
										weiwaishujuDO.setSlj(salesDO.getLeftsanlingjingjy());
										weiwaishujuDO.setJd(salesDO.getLeftjidijy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj(salesDO.getLeftyuanyongtjjy());
									} else if (salesDO.getRecipelwlType() == 2) {
										weiwaishujuDO.setSph(salesDO.getLeftsph());
										weiwaishujuDO.setCyl(salesDO.getLeftcyl());
										weiwaishujuDO.setZx(salesDO.getLeftzx());
										weiwaishujuDO.setSlj(salesDO.getLeftsanlingjingyy());
										weiwaishujuDO.setJd(salesDO.getLeftjidiyy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj(salesDO.getLeftyuanyongtjyy());
									} else if (salesDO.getRecipelwlType() == 3) {
										weiwaishujuDO.setSph(salesDO.getLeftsph());
										weiwaishujuDO.setCyl(salesDO.getLeftcyl());
										weiwaishujuDO.setZx(salesDO.getLeftzx());
										weiwaishujuDO.setSlj(salesDO.getLeftsanlingjingsg());
										weiwaishujuDO.setJd(salesDO.getLeftjidisg());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj("");
									} else if (salesDO.getRecipelwlType() == 4) {
										weiwaishujuDO.setSph(salesDO.getLeftsph());
										weiwaishujuDO.setCyl(salesDO.getLeftcyl());
										weiwaishujuDO.setZx(salesDO.getLeftzx());
										weiwaishujuDO.setSlj(salesDO.getLeftsanlingjingzy());
										weiwaishujuDO.setJd(salesDO.getLeftjidizy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj("");
									}
								} else {
									if ("远用".equals(salesDO.getRecipelType())) {
										KjyyDO kjyyDO = kjyyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(kjyyDO.getKjyySphos());
										weiwaishujuDO.setCyl(kjyyDO.getKjyyCylos());
										weiwaishujuDO.setZx(kjyyDO.getKjyyAxialos());
										weiwaishujuDO.setSlj(kjyyDO.getKjyyPrismos());
										weiwaishujuDO.setJd(kjyyDO.getKjyyJdos());
										weiwaishujuDO.setFartj(kjyyDO.getKjyyYytjos());
										weiwaishujuDO.setNeartj("");
									} else if ("近用".equals(salesDO.getRecipelType())) {
										KjjyDO kjjyDO = kjjyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(kjjyDO.getKjjySphos());
										weiwaishujuDO.setCyl(kjjyDO.getKjjyCylos());
										weiwaishujuDO.setZx(kjjyDO.getKjjyAxialos());
										weiwaishujuDO.setSlj(kjjyDO.getKjjyPrismos());
										weiwaishujuDO.setJd(kjjyDO.getKjjyJdos());
										weiwaishujuDO.setNeartj(kjjyDO.getKjjyYytjos());
										weiwaishujuDO.setFartj("");
									} else if ("渐进/双光".equals(salesDO.getRecipelType())) {
										SgjjDO sgjjDO = sgjjService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(sgjjDO.getSgjjSphos());
										weiwaishujuDO.setCyl(sgjjDO.getSgjjCylos());
										weiwaishujuDO.setZx(sgjjDO.getSgjjAxialos());
										weiwaishujuDO.setSlj("");
										weiwaishujuDO.setJd("");
										weiwaishujuDO.setNeartj(sgjjDO.getSgjjJytjos());
										weiwaishujuDO.setFartj(sgjjDO.getSgjjYytjos());
									} else if ("中用".equals(salesDO.getRecipelType())) {
										ZyDO zyDO = zyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(zyDO.getZySphos());
										weiwaishujuDO.setCyl(zyDO.getZyCylos());
										weiwaishujuDO.setZx(zyDO.getZyAxialos());
										weiwaishujuDO.setSlj(zyDO.getZyPrismos());
										weiwaishujuDO.setJd(zyDO.getZyJdos());
										weiwaishujuDO.setNeartj("");
										weiwaishujuDO.setFartj("");
									}
								}
								weiwaishujuDO.setTg(salesDO.getLefttg());
							} else {
								//处方
								if ("2".equals(salesDO.getOptometrywlName())) {
									if (salesDO.getRecipelwlType() == 1) {
										weiwaishujuDO.setSph(salesDO.getRightsph());
										weiwaishujuDO.setCyl(salesDO.getRightcyl());
										weiwaishujuDO.setZx(salesDO.getRightzx());
										weiwaishujuDO.setSlj(salesDO.getRightsanlingjingjy());
										weiwaishujuDO.setJd(salesDO.getRightjidijy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj(salesDO.getRightyuanyongtjjy());
									} else if (salesDO.getRecipelwlType() == 2) {
										weiwaishujuDO.setSph(salesDO.getRightsph());
										weiwaishujuDO.setCyl(salesDO.getRightcyl());
										weiwaishujuDO.setZx(salesDO.getRightzx());
										weiwaishujuDO.setSlj(salesDO.getRightsanlingjingyy());
										weiwaishujuDO.setJd(salesDO.getRightjidiyy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj(salesDO.getRightyuanyongtjyy());
									} else if (salesDO.getRecipelwlType() == 3) {
										weiwaishujuDO.setSph(salesDO.getRightsph());
										weiwaishujuDO.setCyl(salesDO.getRightcyl());
										weiwaishujuDO.setZx(salesDO.getRightzx());
										weiwaishujuDO.setSlj(salesDO.getRightsanlingjingsg());
										weiwaishujuDO.setJd(salesDO.getRightjidisg());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj("");
									} else if (salesDO.getRecipelwlType() == 4) {
										weiwaishujuDO.setSph(salesDO.getRightsph());
										weiwaishujuDO.setCyl(salesDO.getRightcyl());
										weiwaishujuDO.setZx(salesDO.getRightzx());
										weiwaishujuDO.setSlj(salesDO.getRightsanlingjingzy());
										weiwaishujuDO.setJd(salesDO.getRightjidizy());
										weiwaishujuDO.setFartj("");
										weiwaishujuDO.setNeartj("");
									}
								} else {
									if ("远用".equals(salesDO.getRecipelType())) {
										KjyyDO kjyyDO = kjyyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(kjyyDO.getKjyySphod());
										weiwaishujuDO.setCyl(kjyyDO.getKjyyCylod());
										weiwaishujuDO.setZx(kjyyDO.getKjyyAxialod());
										weiwaishujuDO.setSlj(kjyyDO.getKjyyPrismod());
										weiwaishujuDO.setJd(kjyyDO.getKjyyJdod());
										weiwaishujuDO.setFartj(kjyyDO.getKjyyYytjod());
										weiwaishujuDO.setNeartj("");
									} else if ("近用".equals(salesDO.getRecipelType())) {
										KjjyDO kjjyDO = kjjyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(kjjyDO.getKjjySphod());
										weiwaishujuDO.setCyl(kjjyDO.getKjjyCylod());
										weiwaishujuDO.setZx(kjjyDO.getKjjyAxialod());
										weiwaishujuDO.setSlj(kjjyDO.getKjjyPrismod());
										weiwaishujuDO.setJd(kjjyDO.getKjjyJdod());
										weiwaishujuDO.setNeartj(kjjyDO.getKjjyYytjod());
										weiwaishujuDO.setFartj("");
									} else if ("渐进/双光".equals(salesDO.getRecipelType())) {
										SgjjDO sgjjDO = sgjjService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(sgjjDO.getSgjjSphod());
										weiwaishujuDO.setCyl(sgjjDO.getSgjjCylod());
										weiwaishujuDO.setZx(sgjjDO.getSgjjAxialod());
										weiwaishujuDO.setSlj("");
										weiwaishujuDO.setJd("");
										weiwaishujuDO.setNeartj(sgjjDO.getSgjjJytjod());
										weiwaishujuDO.setFartj(sgjjDO.getSgjjYytjod());
									} else if ("中用".equals(salesDO.getRecipelType())) {
										ZyDO zyDO = zyService.chufangall(salesDO.getPtometryNumber(), "1");
										weiwaishujuDO.setSph(zyDO.getZySphod());
										weiwaishujuDO.setCyl(zyDO.getZyCylod());
										weiwaishujuDO.setZx(zyDO.getZyAxialod());
										weiwaishujuDO.setSlj(zyDO.getZyPrismod());
										weiwaishujuDO.setJd(zyDO.getZyJdod());
										weiwaishujuDO.setNeartj("");
										weiwaishujuDO.setFartj("");
									}
								}
								weiwaishujuDO.setTg(salesDO.getRighttg());

							}
							weiwaishujuDO.setNum(goodNumstr[s]);
							weiwaishujuDO.setCode(goodsStr[s]);
							weiwaishujuDO.setName(goodsName[s]);
							weiwaishujuDO.setLeftRight(leftRight[s]);
							weiwaishujuDO.setCount(goodsCount[s]);
							weiwaishujuDO.setYaoqiu(salesDO.getProcessAsk());
						} else if ("隐形".equals(salesDO.getEyeType())) {
							//处方
							//weiwaishujuDO.setSphyx("");
							weiwaishujuDO.setSphyx("");
							weiwaishujuDO.setCylyx("");
							weiwaishujuDO.setZxyx("");
							weiwaishujuDO.setQulv("");
							weiwaishujuDO.setZj("");
							weiwaishujuDO.setNumyx(goodNumstr[s]);
							weiwaishujuDO.setCodeyx(goodsStr[s]);
							weiwaishujuDO.setName(goodsName[s]);
							weiwaishujuDO.setLeftRightYx(leftRight[s]);
							weiwaishujuDO.setCountyx(goodsCount[s]);
							weiwaishujuDO.setYaoqiuyx(salesDO.getProcessAsk());
						}
						weiwaishujuService.save(weiwaishujuDO);
						WeiwaiDO weiwaiDO = new WeiwaiDO();
						weiwaiDO.setSaleNumber(salesDO.getSaleNumber());
						weiwaiDO.setDanjuNumber(danjuNumber);
						weiwaiDO.setDanjuDay(sim.format(new Date()));
						weiwaiDO.setEyeStyle("3");
						weiwaiDO.setZhidanPeople(salesDO.getSaleName());
						JpdzDO jpdzDO = jpdzService.getJpdzInfomation(goodNumstr[s]);
						weiwaiDO.setMfrsid(jpdzDO.getMfrsid());
						weiwaiDO.setMfrsname(jpdzDO.getMfrsname());
						weiwaiDO.setBrandnum(jpdzDO.getBrandnum());
						weiwaiDO.setBrandname(jpdzDO.getBrandname());
						Map<String, Object> posMap = new HashMap<>();
						posMap.put("companyId", ShiroUtils.getUser().getCompanyId());
						if ("3".equals(ShiroUtils.getUser().getCompanyId())) {
							posMap.put("positionId", "7");
						}
						PositionDO positionDO = stockService.findHegePosition(posMap);

						weiwaiDO.setPositionId(positionDO.getPositionId());
						weiwaiDO.setPositionName(positionDO.getPositionName());
						weiwaiDO.setWeiwaisaleNumber(weiwaishujuDO.getNumber());
						weiwaiDO.setMirrorTime(sim.format(salesDO.getMirrorTime()));
						weiwaiDO.setNum(goodNumstr[s]);
						weiwaiDO.setCode(goodsStr[s]);
						weiwaiDO.setName(goodsName[s]);
						weiwaiDO.setStyle("委外订单");
						weiwaiDO.setRl(classType[s]);
						weiwaiDO.setCount(goodsCount[s]);
						weiwaiDO.setSph(weiwaishujuDO.getSph());
						weiwaiDO.setCyl(weiwaishujuDO.getCyl());
						weiwaiDO.setZx(weiwaishujuDO.getZx());
						weiwaiDO.setFartj(weiwaishujuDO.getFartj());
						weiwaiDO.setNeartj(weiwaishujuDO.getNeartj());
						weiwaiDO.setGkname(weiwaishujuDO.getGkname());
						weiwaiDO.setHyknum(weiwaishujuDO.getHyknum());
						weiwaiDO.setPhone(weiwaishujuDO.getPhone());
						weiwaiDO.setUsername("");
						weiwaiDO.setStatus("1");
						weiwaiDO.setShTime("");
						weiwaiDO.setShstatus("");
						weiwaiDO.setPsname("");
						weiwaiDO.setPstime("");
						weiwaiDO.setCompanyName(ShiroUtils.getUser().getCompany());
						weiwaiDO.setDepartname(ShiroUtils.getUser().getStore());
						weiwaiDO.setViewGoodName(jpdzDO.getViewGoodName());
						weiwaiService.save(weiwaiDO);
					}
				}
			}
			return R.ok();
		}
		return R.error();
	}

}
