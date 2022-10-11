package com.shiguang.stock.service.impl;

import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.*;
import com.shiguang.stock.dao.OrderDao;
import com.shiguang.stock.dao.StockDao;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.system.config.ExcelUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public StockDO get(Long id) {
        return stockDao.get(id);
    }

    @Override
    public List<StockDO> list(Map<String, Object> map) {
        return stockDao.list(map);
    }


    @Override
    public int count(Map<String, Object> map) {
        return stockDao.count(map);
    }

    @Override
    public int save(StockDO stock) {
        return stockDao.save(stock);
    }

    @Override
    public int update(StockDO stock) {
        return stockDao.update(stock);
    }

    @Override
    public int remove(Long id) {
        return stockDao.remove(id);
    }

    @Override
    public int updateStockCCount(StockDO stockDO) {
        return stockDao.updateStockCCount(stockDO);
    }

    @Override
    public int updateStockCountNum(StockDO stockDO) {
        return stockDao.updateStockCountNum(stockDO);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return stockDao.batchRemove(ids);
    }

    @Override
    public List<StockDO> listJiajia(Map<String, Object> map) {
        return stockDao.listJiajia(map);
    }

    @Override
    public int countJiajia(Map<String, Object> map) {
        return stockDao.countJiajia(map);
    }

    @Override
    public List<StockDO> listJpcp(Map<String, Object> map) {
        return stockDao.listJpcp(map);
    }

    @Override
    public int countJpcp(Map<String, Object> map) {
        return stockDao.countJpcp(map);
    }

    @Override
    public List<StockDO> listJpdz(Map<String, Object> map) {
        return stockDao.listJpdz(map);
    }

    @Override
    public int countJpdz(Map<String, Object> map) {
        return stockDao.countJpdz(map);
    }

    @Override
    public List<StockDO> listJiajiapj(Map<String, Object> map) {
        return stockDao.listJiajiapj(map);
    }

    @Override
    public int countJiajiapj(Map<String, Object> map) {
        return stockDao.countJiajiapj(map);
    }

    @Override
    public List<StockDO> listTaiyj(Map<String, Object> map) {
        return stockDao.listTaiyj(map);
    }

    @Override
    public int countTaiyj(Map<String, Object> map) {
        return stockDao.countTaiyj(map);
    }

    @Override
    public List<StockDO> listHaocai(Map<String, Object> map) {
        return stockDao.listHaocai(map);
    }

    @Override
    public int countHaocai(Map<String, Object> map) {
        return stockDao.countHaocai(map);
    }

    @Override
    public List<StockDO> listLaohj(Map<String, Object> map) {
        return stockDao.listLaohj(map);
    }

    @Override
    public int countLaohj(Map<String, Object> map) {
        return stockDao.countLaohj(map);
    }

    @Override
    public List<StockDO> listShiguang(Map<String, Object> map) {
        return stockDao.listShiguang(map);
    }

    @Override
    public int countShiguang(Map<String, Object> map) {
        return stockDao.countShiguang(map);
    }

    @Override
    public List<StockDO> listShiguangdz(Map<String, Object> map) {
        return stockDao.listShiguangdz(map);
    }

    @Override
    public int countShiguangdz(Map<String, Object> map) {
        return stockDao.countShiguangdz(map);
    }

    @Override
    public List<StockDO> listHuly(Map<String, Object> map) {
        return stockDao.listHuly(map);
    }

    @Override
    public int countHuly(Map<String, Object> map) {
        return stockDao.countHuly(map);
    }

    @Override
    public List<StockDO> listZengpin(Map<String, Object> map) {
        return stockDao.listZengpin(map);
    }

    @Override
    public int countZengpin(Map<String, Object> map) {
        return stockDao.countZengpin(map);
    }

    @Override
    public List<StockDO> listYxcp(Map<String, Object> map) {
        return stockDao.listYxcp(map);
    }

    @Override
    public int countYxcp(Map<String, Object> map) {
        return stockDao.countYxcp(map);
    }

    @Override
    public List<StockDO> listYxdz(Map<String, Object> map) {
        return stockDao.listYxdz(map);
    }

    @Override
    public int countYxdz(Map<String, Object> map) {
        return stockDao.countYxdz(map);
    }

    @Override
    public PositionDO findPosition(Map<String, Object> map) {
        return stockDao.findPosition(map);
    }

    @Override
    public PositionDO findHegePosition(Map<String, Object> map) {
        return stockDao.findHegePosition(map);
    }

    @Override
    public PositionDO findBuHegePosition(Map<String, Object> map) {
        return stockDao.findBuHegePosition(map);
    }

    @Override
    public StockDO getGoodsNum(String goodsNum) {
        return stockDao.getGoodsNum(goodsNum);
    }

    @Override
    public List<ProducaDO> selectJingjia(Map<String, Object> map) {
        return stockDao.selectJingjia(map);
    }

    @Override
    public int selectJingjiaCount(Map<String, Object> map) {
        return stockDao.selectJingjiaCount(map);
    }

    @Override
    public List<PartsDO> selectPeijian(Map<String, Object> map) {
        return stockDao.selectPeijian(map);
    }

    @Override
    public int selectPeijianCount(Map<String, Object> map) {
        return stockDao.selectPeijianCount(map);
    }
    @Override
    public List<JpdzDO> selectJpdz(Map<String, Object> map) {
        return stockDao.selectJpdz(map);
    }

    @Override
    public int selectJpdzCount(Map<String, Object> map) {
        return stockDao.selectJpdzCount(map);
    }
    @Override
    public List<JpcpDO> selectJpcp(Map<String, Object> map) {
        return stockDao.selectJpcp(map);
    }

    @Override
    public int selectJpcpCount(Map<String, Object> map) {
        return stockDao.selectJpcpCount(map);
    }
    @Override
    public List<YxdzDO> selectYxdz(Map<String, Object> map) {
        return stockDao.selectYxdz(map);
    }

    @Override
    public int selectYxdzCount(Map<String, Object> map) {
        return stockDao.selectYxdzCount(map);
    }
    @Override
    public List<YxcpDO> selectYxcp(Map<String, Object> map) {
        return stockDao.selectYxcp(map);
    }

    @Override
    public int selectYxcpCount(Map<String, Object> map) {
        return stockDao.selectYxcpCount(map);
    }
    @Override
    public List<HlyDO> selectHly(Map<String, Object> map) {
        return stockDao.selectHly(map);
    }

    @Override
    public int selectHlyCount(Map<String, Object> map) {
        return stockDao.selectHlyCount(map);
    }

    @Override
    public List<TyjDO> selectTyj(Map<String, Object> map) {
        return stockDao.selectTyj(map);
    }

    @Override
    public int selectTyjCount(Map<String, Object> map) {
        return stockDao.selectTyjCount(map);
    }
    @Override
    public List<OldlensDO> selectLhj(Map<String, Object> map) {
        return stockDao.selectLhj(map);
    }

    @Override
    public int selectLhjCount(Map<String, Object> map) {
        return stockDao.selectLhjCount(map);
    }
    @Override
    public List<HcDO> selectHc(Map<String, Object> map) {
        return stockDao.selectHc(map);
    }

    @Override
    public int selectHcCount(Map<String, Object> map) {
        return stockDao.selectHcCount(map);
    }

    @Override
    public List<ShiguangDO> selectSg(Map<String, Object> map) {
        return stockDao.selectSg(map);
    }

    @Override
    public int selectSgCount(Map<String, Object> map) {
        return stockDao.selectSgCount(map);
    }

    @Override
    public List<ShiguangdzDO> selectSgdz(Map<String, Object> map) {
        return stockDao.selectSgdz(map);
    }

    @Override
    public int selectSgdzCount(Map<String, Object> map) {
        return stockDao.selectSgdzCount(map);
    }

    @Override
    public int updateGoodsCount(StockDO stock) {
        return stockDao.updateGoodsCount(stock);
    }

    @Override
    public StockDO getProduceCode(StockDO stockDO) {
        return stockDao.getProduceCode(stockDO);
    }

    @Override
    public StockDO getProduceCodeCount(StockDO stockDO) {
        return stockDao.getProduceCodeCount(stockDO);
    }

    @Override
    public StockDO getProduceNum(StockDO stockDO) {
        return stockDao.getProduceNum(stockDO);
    }

    @Override
    public StockDO haveNum(StockDO stockDO) {
        return stockDao.haveNum(stockDO);
    }

    @Override
    public List<StockDO> kccxList(Map<String, Object> map) {
        return stockDao.kccxList(map);
    }

    @Override
    public int countall(Map<String, Object> map) {
        return stockDao.countall(map);
    }

    @Override
    public int kccxListCount(Map<String, Object> map) {
        return stockDao.kccxListCount(map);
    }

    @Override
    public int updateStatus(StockDO stock) {
        return stockDao.updateStatus(stock);
    }

    @Override
    public int outPosionJ(StockDO stockDO) {
        return stockDao.outPosionJ(stockDO);
    }

    @Override
    public OrderDO getOeder(String danjuNumber) {
        return stockDao.getOeder(danjuNumber);
    }

    @Override
    public List<OrderDO> getOederList(Map<String, Object> map) {
        return stockDao.getOederList(map);
    }

    @Override
    public OrderDO getShouhuo(String danjuNumber) {
        return stockDao.getShouhuo(danjuNumber);
    }

    @Override
    public List<OrderDO> getShouhuoList(Map<String, Object> map) {
        return stockDao.getShouhuoList(map);
    }


    @Override
    public StockDO jingjias(StockDO stockDO) {
        return stockDao.jingjias(stockDO);
    }

    @Override
    public StockDO peijians(StockDO stockDO) {
        return stockDao.peijians(stockDO);
    }

    @Override
    public StockDO jingpians(StockDO stockDO) {
        return stockDao.jingpians(stockDO);
    }

    @Override
    public StockDO jingpiandzs(StockDO stockDO) {
        return stockDao.jingpiandzs(stockDO);
    }

    @Override
    public StockDO yinxings(StockDO stockDO) {
        return stockDao.yinxings(stockDO);
    }

    @Override
    public StockDO yinxingdzs(StockDO stockDO) {
        return stockDao.yinxingdzs(stockDO);
    }

    @Override
    public StockDO huliyes(StockDO stockDO) {
        return stockDao.huliyes(stockDO);
    }

    @Override
    public StockDO taiyangjings(StockDO stockDO) {
        return stockDao.taiyangjings(stockDO);
    }

    @Override
    public StockDO laohuajings(StockDO stockDO) {
        return stockDao.laohuajings(stockDO);
    }

    @Override
    public StockDO haocais(StockDO stockDO) {
        return stockDao.haocais(stockDO);
    }

    @Override
    public StockDO shiguangs(StockDO stockDO) {
        return stockDao.shiguangs(stockDO);
    }




    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public R importStock(Integer goodsType, String positionId, String beizhu,String checkType,String dzlx, MultipartFile file) {
        int num = 0;
        String sl = "";
        InputStream in = null;
        Workbook book = null;
        List<Integer> list = new ArrayList<>();
        List<Integer> listSize = new ArrayList<>();
        try {
            if (file != null) {
                in = file.getInputStream();
                book = ExcelUtils.getBook(file);
                Sheet sheet = book.getSheetAt(0);
                Row row;
                int lastnum = sheet.getLastRowNum();
                for (int a = 2; a <= sheet.getLastRowNum(); a++) {
                    row = sheet.getRow(a);
                    if (ExcelUtils.getCellFormatValue(row.getCell((short) 0)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 0)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 1)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 1)) != null
                    ) ;
                    else
                        return R.error("Excel中有部分基本信息数据为空，请检查好重新导入");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                Long uuid = GuuidUtil.getUUID();
                String danjuNumber = "PIN" + uuid.toString();
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String goodsNums = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");
                        String counts  = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");
                        String usedays= ExcelUtils.getCellFormatValue(row.getCell((short) 2)).replaceAll("[\t\n' ']", "");
                        String batchs= ExcelUtils.getCellFormatValue(row.getCell((short) 3)).replaceAll("[\t\n' ']", "");
                        Integer goodstype=goodsType;
                        String styles=dzlx;
                        if (goodstype==1){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO jingjias=  stockDao.jingjias(stockDO);
                            if(jingjias==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=jingjias.getProducNum();
                            String goodsCode=jingjias.getProducCode();
                            String goodsName=jingjias.getViewGoodName()+"-型号:"+jingjias.getProducFactory()+"-色号:"+jingjias.getProducFactorycolor()+"-标价:"+jingjias.getRetailPrice();
                            String mfrsid=jingjias.getMfrsid();
                            String brandname=jingjias.getBrandname();
                            String retailPrice=jingjias.getRetailPrice();
                            String unitname=jingjias.getUnitname();
                            String factory=jingjias.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=jingjias.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==2){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO peijians=  stockDao.peijians(stockDO);
                            if(peijians==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=peijians.getProducNum();
                            String goodsCode=peijians.getProducCode();
                            String goodsName=peijians.getViewGoodName()+"-型号:"+peijians.getProducFactory()+"-标价:"+peijians.getRetailPrice();
                            String mfrsid=peijians.getMfrsid();
                            String brandname=peijians.getBrandname();
                            String retailPrice=peijians.getRetailPrice();
                            String unitname=peijians.getUnitname();
                            String factory=peijians.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=peijians.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==3){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO jingpians=null;
                            String goodsName = null;
                            if("1".equals(styles)){
                                jingpians =  stockDao.jingpians(stockDO);
                                if(jingpians==null){
                                    sl = sl + "," + String.valueOf(rowNum - 1);
                                }
                                goodsName =jingpians.getViewGoodName()+"-球镜:"+jingpians.getSph()+"-柱镜:"+jingpians.getCyl()+"-标价:"+jingpians.getRetailPrice();
                            }else if ("2".equals(styles)){
                                jingpians=  stockDao.jingpiandzs(stockDO);
                                if(jingpians==null){
                                    sl = sl + "," + String.valueOf(rowNum - 1);
                                }
                                goodsName=jingpians.getViewGoodName()+"-球镜:"+jingpians.getSphUp()+"/"+jingpians.getSphDown()+"-柱镜:"+jingpians.getCylUp()+"/"+jingpians.getCylDown()+"-标价:"+jingpians.getRetailPrice();
                            }
                            String goodsNum=jingpians.getProducNum();
                            String goodsCode=jingpians.getProducCode();
                            String mfrsid=jingpians.getMfrsid();
                            String brandname=jingpians.getBrandname();
                            String retailPrice=jingpians.getRetailPrice();
                            String unitname=jingpians.getUnitname();
                            String factory=jingpians.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=jingpians.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;

                        }else if (goodstype==4){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO yinxings=null;
                            String goodsName=null;
                            if("1".equals(styles)){
                                yinxings =  stockDao.yinxings(stockDO);
                                if(yinxings==null){
                                    sl = sl + "," + String.valueOf(rowNum - 1);
                                }
                                  goodsName=yinxings.getViewGoodName()+"-球镜:"+yinxings.getSph()+"-柱镜:"+yinxings.getCyl()+"-标价:"+yinxings.getRetailPrice();
                            }else if ("2".equals(styles)){
                                yinxings=  stockDao.yinxingdzs(stockDO);
                                if(yinxings==null){
                                    sl = sl + "," + String.valueOf(rowNum - 1);
                                }
                                  goodsName=yinxings.getViewGoodName()+"-球镜:"+yinxings.getSphUp()+"/"+yinxings.getSphDown()+"-柱镜:"+yinxings.getCylUp()+"/"+yinxings.getCylDown()+"-标价:"+yinxings.getRetailPrice();
                            }
                            String goodsNum=yinxings.getProducNum();
                            String goodsCode=yinxings.getProducCode();
                            String mfrsid=yinxings.getMfrsid();
                            String brandname=yinxings.getBrandname();
                            String retailPrice=yinxings.getRetailPrice();
                            String unitname=yinxings.getUnitname();
                            String factory=yinxings.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=yinxings.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchs);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;

                        }else if (goodstype==5){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO huliyes=  stockDao.huliyes(stockDO);
                            if(huliyes==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=huliyes.getProducNum();
                            String goodsCode=huliyes.getProducCode();
                            String goodsName=huliyes.getViewGoodName()+"-型号:"+huliyes.getProducFactory()+"-标价:"+huliyes.getRetailPrice();
                            String mfrsid=huliyes.getMfrsid();
                            String brandname=huliyes.getBrandname();
                            String retailPrice=huliyes.getRetailPrice();
                            String unitname=huliyes.getUnitname();
                            String factory=huliyes.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=huliyes.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==6){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO taiyangjings=  stockDao.taiyangjings(stockDO);
                            if(taiyangjings==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=taiyangjings.getProducNum();
                            String goodsCode=taiyangjings.getProducCode();
                            String goodsName=taiyangjings.getViewGoodName()+"-型号:"+taiyangjings.getProducFactory()+"-颜色:"+taiyangjings.getProducFactorycolor()+"-标价:"+taiyangjings.getRetailPrice();
                            String mfrsid=taiyangjings.getMfrsid();
                            String brandname=taiyangjings.getBrandname();
                            String retailPrice=taiyangjings.getRetailPrice();
                            String unitname=taiyangjings.getUnitname();
                            String factory=taiyangjings.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=taiyangjings.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==7){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO laohuajings=  stockDao.laohuajings(stockDO);
                            if(laohuajings==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=laohuajings.getProducNum();
                            String goodsCode=laohuajings.getProducCode();
                            String goodsName=laohuajings.getViewGoodName()+"-球镜:"+laohuajings.getSph()+"-型号:"+laohuajings.getProducFactory()+"-标价:"+laohuajings.getRetailPrice();
                            String mfrsid=laohuajings.getMfrsid();
                            String brandname=laohuajings.getBrandname();
                            String retailPrice=laohuajings.getRetailPrice();
                            String unitname=laohuajings.getUnitname();
                            String factory=laohuajings.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=laohuajings.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                           SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==8){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO haocais=  stockDao.haocais(stockDO);
                            if(haocais==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=haocais.getProducNum();
                            String goodsCode=haocais.getProducCode();
                            String goodsName=haocais.getViewGoodName()+"-型号:"+haocais.getProducFactory()+"-标价:"+haocais.getRetailPrice();
                            String mfrsid=haocais.getMfrsid();
                            String brandname=haocais.getBrandname();
                            String retailPrice=haocais.getRetailPrice();
                            String unitname=haocais.getUnitname();
                            String factory=haocais.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=haocais.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setFactory(factory);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;
                        }else if (goodstype==9){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO shiguangs=  stockDao.shiguangs(stockDO);
                            if(shiguangs==null){
                                sl = sl + "," + String.valueOf(rowNum - 1);
                            }
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getViewGoodName()+"-型号:"+shiguangs.getProducFactory()+"-标价:"+shiguangs.getRetailPrice();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            if (factory==null){
                                factory="";
                            }
                            String classtype=shiguangs.getClasstype();
                            stockDO.setPositionId(positionId);
                            stockDO.setBeizhu(beizhu);
                            stockDO.setGoodsType(goodsType);
                            stockDO.setGoodsNum(goodsNum);
                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            stockDO.setClasstype(classtype);
                            stockDO.setGoodsCount(counts);
                            stockDO.setBatch(batchs);
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeahs = str.substring(0, 4);
                                    String yeah=yeahs.substring(yeahs.length()-2,yeahs.length());
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月"));
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日"));
                                    xiaoqi =yeahs + "-" + yue + "-" + ri;
                                }
                            }
                            stockDO.setUseday(xiaoqi);
                            String batchsNew="";
                            if (batchs !="" && batchs !=null){
                                Integer bacthLength=batchs.length();
                                String  ph="";
                                if (bacthLength<8){
                                    Integer phscd=8-bacthLength;
                                    for (int  i=0;i<phscd;i++){
                                        ph+="0";
                                    }
                                    batchsNew=ph+batchs;
                                }else {
                                    batchs=batchs.substring(bacthLength-8, bacthLength);
                                    batchsNew=ph+batchs;
                                }
                                stockDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            stockDO.setDanjuDay(createTime);
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
                            orderDO.setUseday(xiaoqi);
                            if (batchs !="" && batchs !=null){
                                orderDO.setGoodsCode(goodsCode+batchsNew);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setBatch(batchs);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
                            orderDO.setBeizhu(beizhu);
                            orderDO.setCreateTime(createTime);
                            orderDO.setDanjuNumber(danjuNumber);
                            orderDO.setZhidanPeople(zhidanPeople);
                            orderDO.setDanjuDay(createTime);
                            orderDO.setClasstype(classtype);
                            orderDO.setFactory(factory);
                            orderDO.setStatus("1");
                            orderDO.setUsername("未收货");
                            orderDO.setReturnzt("1");
                            if (orderDao.save(orderDO) < 0) {
                                return R.error();
                            }
                            num++;

                        }

                    } catch (Exception e) {
                        System.out.println("导入失败======第" + (rowNum + 1) + "条==================");
                        e.printStackTrace();
                    }

                }
                if (listSize.size() > 0) {
                    return R.ok("上传成功,共增加[" + num + "]条,第" + sl + "行导入失败，原因：商品代码不存在");
                } else {
                    if (sl != "") {
                        return R.ok("上传成功,共增加[" + num + "]条,第" + sl + "行导入失败，原因：商品代码不存在");
                    } else {
                        return R.ok("上传成功,共增加[" + num + "]条");
                    }

                }
            } else {
                return R.error("请选择导入的文件!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (book != null)
                    book.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.error();
    }







    private boolean checkRealName(String realName) {
        if (StringUtils.isEmpty(realName)) {
            return false;
        }

        char[] ch = realName.toCharArray();
        for (char c : ch) {
            if (c < 0x4E00 || c > 0x9FA5) {
                return false;
            }
        }
        return true;
    }
}
