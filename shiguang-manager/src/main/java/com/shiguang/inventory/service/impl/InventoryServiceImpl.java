package com.shiguang.inventory.service.impl;

import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.inventory.dao.BillDao;
import com.shiguang.inventory.dao.GainLossDao;
import com.shiguang.inventory.dao.InventoryDao;
import com.shiguang.inventory.domain.BillDO;
import com.shiguang.inventory.domain.GainLossDO;
import com.shiguang.inventory.domain.InventoryDO;
import com.shiguang.inventory.service.InventoryService;
import com.shiguang.product.dao.*;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.ProducaService;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.stock.dao.StockDao;
import com.shiguang.stock.domain.StockDO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private BillDao billDao;
	@Autowired
	private GainLossDao gainLossDao;
	@Autowired
	private ProducaDao producaDao;
	@Autowired
	private JpcpDao jpcpDao;
	@Autowired
	private PartsDao partsDao;
	@Autowired
	private YxcpDao yxcpDao;
	@Autowired
	private HlyDao hlyDao;
	@Autowired
	private OldlensDao oldlensDao;
	@Autowired
	private TyjDao tyjDao;
	@Autowired
	private HcDao hcDao;
	@Autowired
	private ShiguangDao shiguangDao;
	
	@Override
	public InventoryDO get(Long id){
		return inventoryDao.get(id);
	}

	@Override
	public InventoryDO getInventory(Long id){
		return inventoryDao.getInventory(id);
	}

	@Override
	public List<InventoryDO> list(Map<String, Object> map){
		return inventoryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return inventoryDao.count(map);
	}
	
	@Override
	public int save(InventoryDO inventory){
		return inventoryDao.save(inventory);
	}
	
	@Override
	public int update(InventoryDO inventory){
		return inventoryDao.update(inventory);
	}
	
	@Override
	public int remove(Long id){
		return inventoryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return inventoryDao.batchRemove(ids);
	}

	@ResponseBody
	@Transactional
	public R importInventory(String documentNo, String inventoryName, String inventoryPosition, String inventoryType, List<MultipartFile> multipartFiles){
		System.out.println("==============file================" + multipartFiles);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String,Object> maps = new HashMap<>();
		if ("镜架".equals(inventoryType)){
			maps.put("goodsType",1);
		} else if ("配件".equals(inventoryType)){
			maps.put("goodsType",2);
		} else if ("镜片".equals(inventoryType)){
			maps.put("goodsType",3);
		} else if ("护理液".equals(inventoryType)){
			maps.put("goodsType",5);
		} else if ("太阳镜".equals(inventoryType)){
			maps.put("goodsType",6);
		} else if ("老花镜".equals(inventoryType)){
			maps.put("goodsType",7);
		} else if ("耗材".equals(inventoryType)){
			maps.put("goodsType",8);
		} else if ("视光".equals(inventoryType)){
			maps.put("goodsType",9);
		}
		maps.put("positionId",inventoryPosition);
		List<StockDO> stockDOList = stockDao.list(maps);
		List<BillDO> billDOList = new ArrayList<>();
		Long inventoryId = GuuidUtil.getUUID();
		String gain = "";
		String loss="";
		String procode = "";
		for (MultipartFile file: multipartFiles){
			if (file.isEmpty()){
				return R.error("盘点文件为空");
			}
			try {
				InputStream inputStream = file.getInputStream();
				InputStreamReader isr = new InputStreamReader(inputStream,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				String goodsCode="";
				List<String> lists = new ArrayList<>();
				List<String> list = new ArrayList<>();
				while ((lineTxt = br.readLine()) != null) {
					lists.add(lineTxt);
					System.out.println(lineTxt);
				}
				br.close();
				Collections.sort(lists);
				int count=0;
				if (null != lists && lists.size()>0){
					for (String s : lists){
						if (!"".equals(s)){
							list.add(s);
						}
					}
				}
				List<StockDO> stockDOS = new ArrayList<>();
				List<String> listGode = new ArrayList<>();
				for (StockDO s:stockDOList){
					listGode.add(s.getGoodsCode());
				}
//				if (stockDOList.size() >= list.size()){
//					for (int i=0;i<stockDOList.size();i++){
//						if (i < list.size()){
//							if(!listGode.contains(list.get(i))){
//								stockDOS.add(list.get(i));
//							}
//						}
//					}
//				} else if (stockDOList.size() < list.size()){
					int num =0;
					for (int i=0;i<list.size();i++){
						if(!listGode.contains(list.get(i))){
							if (num ==0){
								procode=list.get(i);
							} else if(num == 100000){
								num =0;
								num =num +1;
								//procode=list.get(i);
							}
							Map<String,Object> mapInfo = new HashMap<>();
							StockDO stockDOfg = new StockDO();
							stockDOfg.setGoodsCode(list.get(i));
							stockDOfg.setPositionId(inventoryPosition);
							StockDO stockDO = stockDao.getProduceCode(stockDOfg);
							if (null != stockDO){
								stockDO.setGoodsCount(String.valueOf(Integer.parseInt(stockDO.getGoodsCount())+1));
								stockDao.updateStockCCount(stockDO);
							} else {
								if (i==list.size()-1){
									num = 1;
									mapInfo.put("producCode",procode.substring(0,18));
									stockDO = stockSave(mapInfo,num,inventoryType,procode,inventoryPosition);
									stockDOS.add(stockDO);
									if (!procode.equals(list.get(i))){
										mapInfo.put("producCode",list.get(i).substring(0,18));
										stockDO = stockSave(mapInfo,num,inventoryType,list.get(i),inventoryPosition);
										stockDOS.add(stockDO);
									}
									break;
								}
								if (procode.equals(list.get(i))){
									num = num +1;
								} else {
									mapInfo.put("producCode",procode.substring(0,18));
									stockDO = stockSave(mapInfo,num,inventoryType,procode,inventoryPosition);
									stockDOS.add(stockDO);
									procode = list.get(i);
									//mapInfo.put("producCode",list.get(i).substring(0,18));
									//stockDO = stockSave(mapInfo,num,inventoryType,procode,inventoryPosition);
									//stockDOS.add(stockDO);
									num = 100000;
								}

							}
						}
					}
//				}
				goodsCode = list.get(0);
					for (int i=0;i<list.size();i++){
						Map<String,Object> map = new HashMap<>();
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(inventoryPosition);
						stockDOs.setGoodsCode(goodsCode);
						StockDO stockDO =stockDao.getProduceCode(stockDOs);
						if (null != stockDO){
							if (goodsCode.equals(list.get(i))){
								count = count + 1;
							} else {
								BillDO billDO = new BillDO();
								billDO.setGoodsNum(stockDO.getGoodsNum());
								billDO.setGoodsCode(stockDO.getGoodsCode());
								billDO.setGoodsId(String.valueOf(stockDO.getGoodsxinxiid()));
								billDO.setGoodsName(stockDO.getGoodsName());
								if (null != stockDO.getUseday()){
									billDO.setGoodsTime(stockDO.getUseday());
								} else {
									billDO.setGoodsTime("");
								}
								if (null != stockDO.getBatch()){
									billDO.setGoodsBatch(stockDO.getBatch());
								} else {
									billDO.setGoodsBatch("");
								}
								billDO.setUnitname(stockDO.getUnit());
								billDO.setFactory(stockDO.getFactory());
								billDO.setBookNum(stockDO.getGoodsCount());
								billDO.setActualNum(String.valueOf(count));
								billDO.setInventoryId(inventoryId);
								if (count == 0){
									count=1;
								}
								if (count == Integer.parseInt(stockDO.getGoodsCount())){
									billDO.setSurplus("0");
									gain = "无盘盈";
									loss = "无盘亏";
								} else {
									int surplus = count - Integer.parseInt(stockDO.getGoodsCount());
									if (surplus > 0){
										billDO.setSurplus(String.valueOf(surplus));
										billDO.setInventoryType("0");
										gain = "0";
									} else if (surplus < 0){
										surplus = Integer.parseInt(stockDO.getGoodsCount()) - count;
										billDO.setSurplus("-"+surplus);
										billDO.setInventoryType("1");
										loss = "0";
									}
								}
								billDao.save(billDO);
								billDOList.add(billDO);
								count = 1;
							}
							goodsCode = list.get(i);
							if (i == list.size() - 1){
								StockDO stockDOss = new StockDO();
								stockDOss.setPositionId(inventoryPosition);
								stockDOss.setGoodsCode(list.get(i));
								StockDO stockDOstr =stockDao.getProduceCode(stockDOss);
								BillDO billDO = new BillDO();
								billDO.setGoodsNum(stockDOstr.getGoodsNum());
								billDO.setGoodsCode(stockDOstr.getGoodsCode());
								billDO.setGoodsName(stockDOstr.getGoodsName());
								billDO.setGoodsId(String.valueOf(stockDOstr.getGoodsxinxiid()));
								if (null != stockDOstr.getUseday()){
									billDO.setGoodsTime(stockDOstr.getUseday());
								} else {
									billDO.setGoodsTime("");
								}
								if (null != stockDOstr.getBatch()){
									billDO.setGoodsBatch(stockDOstr.getBatch());
								} else {
									billDO.setGoodsBatch("");
								}
								billDO.setUnitname(stockDOstr.getUnit());
								billDO.setFactory(stockDOstr.getFactory());
								billDO.setBookNum(stockDOstr.getGoodsCount());
								billDO.setActualNum(String.valueOf(count));
								billDO.setInventoryId(inventoryId);
								if (count == Integer.parseInt(stockDOstr.getGoodsCount())){
									billDO.setSurplus("0");
									gain = "无盘盈";
									loss = "无盘亏";
								} else {
									int surplus = count - Integer.parseInt(stockDOstr.getGoodsCount());
									if (surplus > 0){
										billDO.setSurplus(String.valueOf(surplus));
										billDO.setInventoryType("0");
										gain = "0";
									} else if (surplus < 0){
										surplus = Integer.parseInt(stockDOstr.getGoodsCount()) - count;
										billDO.setSurplus("-"+surplus);
										billDO.setInventoryType("1");
										loss = "0";
									}
								}
								billDao.save(billDO);
								billDOList.add(billDO);
							}
						} else {
							goodsCode = list.get(i);
						}
					}
//					for (StockDO stockDO : stockDOS){
//						BillDO billDO = new BillDO();
//						billDO.setGoodsNum(stockDO.getGoodsNum());
//						billDO.setGoodsCode(stockDO.getGoodsCode());
//						billDO.setGoodsId(String.valueOf(stockDO.getGoodsxinxiid()));
//						billDO.setGoodsName(stockDO.getGoodsName());
//						if (null != stockDO.getUseday()){
//							billDO.setGoodsTime(stockDO.getUseday());
//						} else {
//							billDO.setGoodsTime("");
//						}
//						if (null != stockDO.getBatch()){
//							billDO.setGoodsBatch(stockDO.getBatch());
//						} else {
//							billDO.setGoodsBatch("");
//						}
//						billDO.setUnitname(stockDO.getUnit());
//						billDO.setFactory(stockDO.getFactory());
//						billDO.setBookNum("0");
//						billDO.setActualNum(stockDO.getGoodsCount());
//						billDO.setInventoryId(inventoryId);
//						//surplus = Integer.parseInt(stockDO.getGoodsCount()) - count;
//						billDO.setSurplus(stockDO.getGoodsCount());
//						billDO.setInventoryType("0");
//						loss = "0";
//						billDao.save(billDO);
//						stockDao.save(stockDO);
//						billDOList.add(billDO);
//					}

			} catch (Exception e) {
				System.out.println("文件读取错误!");
			}
		}
		InventoryDO inventoryDO = new InventoryDO();
		inventoryDO.setDocumentNo(documentNo);
		inventoryDO.setDocumentDate(new Date());
		if (null != ShiroUtils.getUser().getStore()){
			inventoryDO.setDepartmentNumber(ShiroUtils.getUser().getStore());
			inventoryDO.setDepartmentNumber(ShiroUtils.getUser().getStoreNum());
		}
//		if (!"".equals(gain)){
//			inventoryDO.setGain(gain);
//		} else {
//			inventoryDO.setGain("无盘盈");
//		}
//		if (!"".equals(loss)){
//			inventoryDO.setLoss(loss);
//		} else {
//			inventoryDO.setLoss("无盘亏");
//		}
		inventoryDO.setInventoryDate(new Date());
		inventoryDO.setInventoryName(inventoryName);
		inventoryDO.setInventoryNumber("MAI"+GuuidUtil.getUUID());
		inventoryDO.setInventoryPosition(inventoryPosition);
		inventoryDO.setInventoryType(inventoryType);
		inventoryDO.setInventoryUser(ShiroUtils.getUser().getName());
		inventoryDO.setInventoryId(inventoryId);
		//List<BillDO> billDO = billDao.getInventoryId(inventoryId);
		for (BillDO billDO1 : billDOList){
			if ("1".equals(billDO1.getInventoryType())){
				inventoryDO.setLoss("0");
			} else if ("0".equals(billDO1.getInventoryType())){
				inventoryDO.setGain("0");
			}
		}
		if (null == inventoryDO.getGain() || "".equals(inventoryDO.getGain())){
			inventoryDO.setGain("无盘盈");
		}
		if (null == inventoryDO.getLoss() | "".equals(inventoryDO.getLoss())){
			inventoryDO.setLoss("无盘亏");
		}
		this.save(inventoryDO);
		return R.ok();
	}

	@Override
	@Transactional
	public R removePandian(Long id){
		InventoryDO inventoryDO = this.get(id);
		this.remove(id);
		if (null != inventoryDO){
			Long inventoryId = inventoryDO.getInventoryId();
			List<BillDO> billDOList = billDao.getInventoryId(inventoryId);
			if (null != billDOList && billDOList.size() > 0){
				for (BillDO billDO : billDOList){
					billDao.removeInventoryId(billDO.getInventoryId());
				}
			}
			String inventoryNumber = inventoryDO.getInventoryNumber();
			GainLossDO gainLossDO = gainLossDao.getInventoryNumber(inventoryNumber);
			if (null != gainLossDO){
				gainLossDao.removeInventoryNumber(gainLossDO.getInventoryNumber());
			}
			return R.ok();
		}
//		if(inventoryService.remove(id)>0){
//		return R.ok();
//		}
		return R.error();
	}

	public StockDO stockSave(Map<String,Object> mapInfo,int num,String inventoryType,String goodsCode,String inventoryPosition){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StockDO stockDO = new StockDO();
		if ("镜架".equals(inventoryType)){
			List<ProducaDO> producaDO2 = producaDao.list(mapInfo);
			for (ProducaDO producaDO1 : producaDO2){
				ProducaDO producaDO = producaDao.getJJInfomation(producaDO1.getProducNum());
				stockDO.setGoodsNum(producaDO.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(producaDO.getProducName());
				stockDO.setGoodsType(1);
				stockDO.setMfrsid(producaDO.getMfrsid());
				stockDO.setBrandname(producaDO.getBrandname());
				stockDO.setUnit(producaDO.getUnitname());
				stockDO.setRetailPrice(producaDO.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != producaDO.getProducFactory() && !"".equals(producaDO.getProducFactory())){
					stockDO.setFactory(producaDO.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}

		} else if ("配件".equals(inventoryType)){
			List<PartsDO> partsDOS = partsDao.list(mapInfo);
			for (PartsDO partsDO : partsDOS){
				PartsDO partsDO1 = partsDao.getPartInfomation(partsDO.getProducNum());
				stockDO.setGoodsNum(partsDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(partsDO1.getProducName());
				stockDO.setGoodsType(2);
				stockDO.setMfrsid(partsDO1.getMfrsid());
				stockDO.setBrandname(partsDO1.getBrandname());
				stockDO.setUnit(partsDO1.getUnitname());
				stockDO.setRetailPrice(partsDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != partsDO1.getProducFactory() && !"".equals(partsDO1.getProducFactory())){
					stockDO.setFactory(partsDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		} else if ("镜片".equals(inventoryType)){
			List<JpcpDO> jpcpDOS = jpcpDao.list(mapInfo);
			for (JpcpDO jpcpDO : jpcpDOS){
				JpcpDO jpcpDO1 = jpcpDao.getJpcpInfomation(jpcpDO.getProducNum());
				stockDO.setGoodsNum(jpcpDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(jpcpDO1.getProducName());
				stockDO.setGoodsType(3);
				stockDO.setMfrsid(jpcpDO1.getMfrsid());
				stockDO.setBrandname(jpcpDO1.getBrandname());
				stockDO.setUnit(jpcpDO1.getUnitname());
				stockDO.setRetailPrice(jpcpDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != jpcpDO1.getProducFactory() && !"".equals(jpcpDO1.getProducFactory())){
					stockDO.setFactory(jpcpDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		}  else if ("隐形".equals(inventoryType)){
			List<YxcpDO> yxcpDOList = yxcpDao.list(mapInfo);
			for (YxcpDO yxcpDO : yxcpDOList){
				YxcpDO yxcpDO1 = yxcpDao.getYxcpInfomation(yxcpDO.getProducNum());
				stockDO.setGoodsNum(yxcpDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(yxcpDO1.getProducName());
				stockDO.setGoodsType(4);
				stockDO.setMfrsid(yxcpDO1.getMfrsid());
				stockDO.setBrandname(yxcpDO1.getBrandname());
				stockDO.setUnit(yxcpDO1.getUnitname());
				stockDO.setRetailPrice(yxcpDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != yxcpDO1.getFactory() && !"".equals(yxcpDO1.getFactory())){
					stockDO.setFactory(yxcpDO1.getFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		} else if ("护理液".equals(inventoryType)){
			List<HlyDO> hlyDOList = hlyDao.list(mapInfo);
			for (HlyDO hlyDO : hlyDOList){
				HlyDO hlyDO1 = hlyDao.getHlyInfomation(hlyDO.getProducNum());
				stockDO.setGoodsNum(hlyDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(hlyDO1.getProducName());
				stockDO.setGoodsType(5);
				stockDO.setMfrsid(hlyDO1.getMfrsid());
				stockDO.setBrandname(hlyDO1.getBrandname());
				stockDO.setUnit(hlyDO1.getUnitname());
				stockDO.setRetailPrice(hlyDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != hlyDO1.getProducFactory() && !"".equals(hlyDO1.getProducFactory())){
					stockDO.setFactory(hlyDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		} else if ("太阳镜".equals(inventoryType)){
			List<TyjDO> tyjDOList = tyjDao.list(mapInfo);
			for (TyjDO tyjDO : tyjDOList){
				TyjDO tyjDO1 = tyjDao.getTyjInfomation(tyjDO.getProducNum());
				stockDO.setGoodsNum(tyjDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(tyjDO1.getProducName());
				stockDO.setGoodsType(6);
				stockDO.setMfrsid(tyjDO1.getMfrsid());
				stockDO.setBrandname(tyjDO1.getBrandname());
				stockDO.setUnit(tyjDO1.getUnitname());
				stockDO.setRetailPrice(tyjDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != tyjDO1.getProducFactory() && !"".equals(tyjDO1.getProducFactory())){
					stockDO.setFactory(tyjDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		} else if ("老花镜".equals(inventoryType)){
			List<OldlensDO> oldlensDOList = oldlensDao.list(mapInfo);
			for (OldlensDO oldlensDO : oldlensDOList){
				OldlensDO oldlensDO1 = oldlensDao.getOldlenInfomation(oldlensDO.getProducNum());
				stockDO.setGoodsNum(oldlensDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(oldlensDO1.getProducName());
				stockDO.setGoodsType(7);
				stockDO.setMfrsid(oldlensDO1.getMfrsid());
				stockDO.setBrandname(oldlensDO1.getBrandname());
				stockDO.setUnit(oldlensDO1.getUnitname());
				stockDO.setRetailPrice(oldlensDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != oldlensDO1.getProducFactory() && !"".equals(oldlensDO1.getProducFactory())){
					stockDO.setFactory(oldlensDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				stockDao.save(stockDO);
			}
		} else if ("耗材".equals(inventoryType)){
			List<HcDO> hcDOList = hcDao.list(mapInfo);
			for (HcDO hcDO : hcDOList){
				HcDO hcDO1 = hcDao.getHcInfomation(hcDO.getProducNum());
				stockDO.setGoodsNum(hcDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(hcDO1.getProducName());
				stockDO.setGoodsType(8);
				stockDO.setMfrsid(hcDO1.getMfrsid());
				stockDO.setBrandname(hcDO1.getBrandname());
				stockDO.setUnit(hcDO1.getUnitname());
				stockDO.setRetailPrice(hcDO1.getRetailPrice());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != hcDO1.getProducFactory() && !"".equals(hcDO1.getProducFactory())){
					stockDO.setFactory(hcDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				//stockDao.save(stockDO);
			}
		} else if ("视光".equals(inventoryType)){
			List<ShiguangDO> shiguangDOList = shiguangDao.list(mapInfo);
			for (ShiguangDO shiguangDO : shiguangDOList){
				ShiguangDO shiguangDO1 = shiguangDao.getShiguangInfomation(shiguangDO.getProducNum());
				stockDO.setGoodsNum(shiguangDO1.getProducNum());
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsCount(num+"");
				stockDO.setGoodsName(shiguangDO1.getProducName());
				stockDO.setGoodsType(9);
				stockDO.setMfrsid(shiguangDO1.getMfrsid());
				stockDO.setBrandname(shiguangDO1.getBrandname());
				stockDO.setUnit(shiguangDO1.getUnitname());
				stockDO.setPositionId(inventoryPosition);
				stockDO.setRetailPrice(shiguangDO1.getRetailPrice());
				stockDO.setCreateTime(simpleDateFormat.format(new Date()));
				stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
				if (null != shiguangDO1.getProducFactory() && !"".equals(shiguangDO1.getProducFactory())){
					stockDO.setFactory(shiguangDO1.getProducFactory());
				}
				stockDO.setClasstype("1");
				stockDO.setUsername(ShiroUtils.getUser().getUsername());
				stockDO.setStatus("0");
				//stockDao.save(stockDO);
			}
		}
		return stockDO;
	}

}
