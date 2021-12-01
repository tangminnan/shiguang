package com.shiguang.inventory.service.impl;

import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.inventory.dao.BillDao;
import com.shiguang.inventory.dao.InventoryDao;
import com.shiguang.inventory.domain.BillDO;
import com.shiguang.inventory.domain.InventoryDO;
import com.shiguang.inventory.service.InventoryService;
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
import java.util.*;


@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private BillDao billDao;
	
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
	@Transactional(propagation = Propagation.REQUIRED)
	public R importInventory(String documentNo, String inventoryName, String inventoryPosition, String inventoryType, List<MultipartFile> multipartFiles){
		System.out.println("==============file================" + multipartFiles);
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
		Long inventoryId = GuuidUtil.getUUID();
		String gain = "";
		String loss="";
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
				if (stockDOList.size() >= list.size()){
					for (int i=0;i<stockDOList.size();i++){
						if(!listGode.contains(list.get(i))){
							stockDOS.add(stockDOList.get(i));
						}
					}
				} else if (stockDOList.size() < list.size()){
					for (int i=0;i<list.size();i++){
						if(!listGode.contains(list.get(i))){
							stockDOS.add(stockDOList.get(i));
						}
					}
				}
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
							}
						} else {

						}
					}
					for (StockDO stockDO : stockDOS){
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
						billDO.setActualNum("0");
						billDO.setInventoryId(inventoryId);
						//surplus = Integer.parseInt(stockDO.getGoodsCount()) - count;
						billDO.setSurplus("-"+stockDO.getGoodsCount());
						billDO.setInventoryType("1");
						loss = "0";
						billDao.save(billDO);
					}

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
		List<BillDO> billDO = billDao.getInventoryId(inventoryId);
		for (BillDO billDO1 : billDO){
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
	
}
