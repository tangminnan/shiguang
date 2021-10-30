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
				List<String> list = new ArrayList<>();
				while ((lineTxt = br.readLine()) != null) {
					list.add(lineTxt);
					System.out.println(lineTxt);
				}
				br.close();
				Collections.sort(list);
				int count=0;
				goodsCode = list.get(0);
				if ("".equals(goodsCode)){
					goodsCode = list.get(2);
				}
				if (list.get(0) == null || "".equals(list.get(0))){
					for (int i=2;i<list.size();i++){
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
						}
					}
				} else {
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
						}
					}
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
		this.save(inventoryDO);
		return R.ok();
	}
	
}
