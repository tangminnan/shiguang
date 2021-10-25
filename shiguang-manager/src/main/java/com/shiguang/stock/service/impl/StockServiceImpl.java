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
import io.swagger.models.auth.In;
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

    //<!--镜架【商】【品】【查】【询】-->
    @Override
    public List<ProducaDO> selectJingjia(Map<String, Object> map) {
        return stockDao.selectJingjia(map);
    }

    @Override
    public int selectJingjiaCount(Map<String, Object> map) {
        return stockDao.selectJingjiaCount(map);
    }

    //<!--配件【商】【品】【查】【询】-->
    @Override
    public List<PartsDO> selectPeijian(Map<String, Object> map) {
        return stockDao.selectPeijian(map);
    }

    @Override
    public int selectPeijianCount(Map<String, Object> map) {
        return stockDao.selectPeijianCount(map);
    }

    //<!--镜片定做【商】【品】【查】【询】-->
    @Override
    public List<JpdzDO> selectJpdz(Map<String, Object> map) {
        return stockDao.selectJpdz(map);
    }

    @Override
    public int selectJpdzCount(Map<String, Object> map) {
        return stockDao.selectJpdzCount(map);
    }

    //<!--镜片成品【商】【品】【查】【询】-->
    @Override
    public List<JpcpDO> selectJpcp(Map<String, Object> map) {
        return stockDao.selectJpcp(map);
    }

    @Override
    public int selectJpcpCount(Map<String, Object> map) {
        return stockDao.selectJpcpCount(map);
    }

    //<!--隐形定做【商】【品】【查】【询】-->
    @Override
    public List<YxdzDO> selectYxdz(Map<String, Object> map) {
        return stockDao.selectYxdz(map);
    }

    @Override
    public int selectYxdzCount(Map<String, Object> map) {
        return stockDao.selectYxdzCount(map);
    }

    //<!--隐形成品【商】【品】【查】【询】-->
    @Override
    public List<YxcpDO> selectYxcp(Map<String, Object> map) {
        return stockDao.selectYxcp(map);
    }

    @Override
    public int selectYxcpCount(Map<String, Object> map) {
        return stockDao.selectYxdzCount(map);
    }

    //<!--护理液【商】【品】【查】【询】-->
    @Override
    public List<HlyDO> selectHly(Map<String, Object> map) {
        return stockDao.selectHly(map);
    }

    @Override
    public int selectHlyCount(Map<String, Object> map) {
        return stockDao.selectHlyCount(map);
    }

    //<!--太阳镜【商】【品】【查】【询】-->
    @Override
    public List<TyjDO> selectTyj(Map<String, Object> map) {
        return stockDao.selectTyj(map);
    }

    @Override
    public int selectTyjCount(Map<String, Object> map) {
        return stockDao.selectTyjCount(map);
    }

    //<!--老花镜【商】【品】【查】【询】-->
    @Override
    public List<OldlensDO> selectLhj(Map<String, Object> map) {
        return stockDao.selectLhj(map);
    }

    @Override
    public int selectLhjCount(Map<String, Object> map) {
        return stockDao.selectLhjCount(map);
    }

    //<!--耗材【商】【品】【查】【询】-->
    @Override
    public List<HcDO> selectHc(Map<String, Object> map) {
        return stockDao.selectHc(map);
    }

    @Override
    public int selectHcCount(Map<String, Object> map) {
        return stockDao.selectHcCount(map);
    }
//<!--视光【商】【品】【查】【询】-->

    @Override
    public List<ShiguangDO> selectSg(Map<String, Object> map) {
        return stockDao.selectSg(map);
    }

    @Override
    public int selectSgCount(Map<String, Object> map) {
        return stockDao.selectSgCount(map);
    }

    @Override
    public int updateGoodsCount(StockDO stock) {
        return stockDao.updateGoodsCount(stock);
    }
    //判断是否存在商品信息

    @Override
    public StockDO getProduceCode(StockDO stockDO) {
        return stockDao.getProduceCode(stockDO);
    }

    @Override
    public StockDO haveNum(StockDO stockDO) {
        return stockDao.haveNum(stockDO);
    }

    //    【库存查询】
    @Override
    public List<StockDO> kccxList(Map<String, Object> map) {
        return stockDao.kccxList(map);
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

    /**
     * excel数据导入
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public R importStock(Integer goodsType, String positionId,String checkType, MultipartFile file) {
        System.out.println("==============file================" + file);
        int num = 0;
        InputStream in = null;
        Workbook book = null;
        List<Integer> list = new ArrayList<>();
        try {
            if (file != null) {
                in = file.getInputStream();
                book = ExcelUtils.getBook(file);
                Sheet sheet = book.getSheetAt(0);
                Row row;
                int lastnum = sheet.getLastRowNum();
                //判断导入的Excel中是否有未填项
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
                //———生成单据编号————
                Long uuid = GuuidUtil.getUUID();
                String danjuNumber = "PIN" + uuid.toString();
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String goodsNums = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");    // 代码
                        String counts  = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");    //  数量
                        String usedays= ExcelUtils.getCellFormatValue(row.getCell((short) 2)).replaceAll("[\t\n' ']", "");    //  效期
                        Integer goodstype=goodsType;
                        if (goodstype==1){
                            StockDO stockDO = new StockDO();
                            stockDO.setGoodsNum(goodsNums);
                            StockDO shiguangs=  stockDao.jingjias(stockDO);
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            String goodsNum=peijians.getProducNum();
                            String goodsCode=peijians.getProducCode();
                            String goodsName=peijians.getProducName();
                            String mfrsid=peijians.getMfrsid();
                            String brandname=peijians.getBrandname();
                            String retailPrice=peijians.getRetailPrice();
                            String unitname=peijians.getUnitname();
                            String factory=peijians.getProducFactory();
                            String classtype=peijians.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO jingpians=  stockDao.jingpians(stockDO);
                            String goodsNum=jingpians.getProducNum();
                            String goodsCode=jingpians.getProducCode();
                            String goodsName=jingpians.getProducName();
                            String mfrsid=jingpians.getMfrsid();
                            String brandname=jingpians.getBrandname();
                            String retailPrice=jingpians.getRetailPrice();
                            String unitname=jingpians.getUnitname();
                            String factory=jingpians.getProducFactory();
                            String classtype=jingpians.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO yinxings=  stockDao.yinxings(stockDO);
                            String goodsNum=yinxings.getProducNum();
                            String goodsCode=yinxings.getProducCode();
                            String goodsName=yinxings.getProducName();
                            String mfrsid=yinxings.getMfrsid();
                            String brandname=yinxings.getBrandname();
                            String retailPrice=yinxings.getRetailPrice();
                            String unitname=yinxings.getUnitname();
                            String factory=yinxings.getProducFactory();
                            String classtype=yinxings.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO shiguangs=  stockDao.shiguangs(stockDO);
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO shiguangs=  stockDao.shiguangs(stockDO);
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO shiguangs=  stockDao.shiguangs(stockDO);
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            StockDO shiguangs=  stockDao.shiguangs(stockDO);
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                            String goodsNum=shiguangs.getProducNum();
                            String goodsCode=shiguangs.getProducCode();
                            String goodsName=shiguangs.getProducName();
                            String mfrsid=shiguangs.getMfrsid();
                            String brandname=shiguangs.getBrandname();
                            String retailPrice=shiguangs.getRetailPrice();
                            String unitname=shiguangs.getUnitname();
                            String factory=shiguangs.getProducFactory();
                            String classtype=shiguangs.getClasstype();

                            stockDO.setPositionId(positionId);
                            stockDO.setGoodsType(goodsType);

                            stockDO.setGoodsNum(goodsNum);

                            stockDO.setGoodsName(goodsName);
                            stockDO.setBrandname(brandname);
                            stockDO.setRetailPrice(retailPrice);
                            stockDO.setUnit(unitname);
                            stockDO.setMfrsid(mfrsid);
                            //型号
                            stockDO.setFactory(factory);
                            //类型
                            stockDO.setClasstype(classtype);
                            //数量
                            stockDO.setGoodsCount(counts);
                            //效期
                            Date dd = new Date();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            String xiaoqi="";
                            String code="";
                            if (StringUtils.isNotBlank(usedays)) {
                                if (usedays.contains("-")) {
                                    dd = sdf.parse(usedays);
                                    //student.setLastCheckTime(dd);
                                } else {
                                    Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                    Date d = calendar.getTime();
                                    dd = DateUtils.addDays(d, Integer.parseInt(usedays.substring(0, usedays.indexOf("."))));
                                    String str = sdf.format(dd);
                                    String yeah = str.substring(0, 4); //取年
                                    String yue = str.substring(str.indexOf("年") + 1, str.indexOf("月")); //取月
                                    String ri = str.substring(str.indexOf("月") + 1, str.indexOf("日")); //取日
                                    xiaoqi =yeah + "-" + yue + "-" + ri;
                                    code =yeah + yue + ri;
                                }
                            }

                            stockDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                stockDO.setGoodsCode(goodsCode+code);
                            }else {
                                stockDO.setGoodsCode(goodsCode+"00000000");
                            }
                            //———入库时间—————
                            SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date date = new Date();
                            String createTime = createTimenew.format(date);
                            stockDO.setCreateTime(createTime);
                            stockDO.setDanjuNumber(danjuNumber);
                            //------制单人------
                            String zhidanPeople= ShiroUtils.getUser().getName();
                            stockDO.setZhidanPeople(zhidanPeople);
                            //---单据日期--
                            stockDO.setDanjuDay(createTime);
                            //收货状态
                            stockDO.setStatus("1");
                            stockDO.setUsername("未收货");
                            stockDO.setReturnzt("1");
//                            //判断是否已存在商品
//                            StockDO goodsNumList = stockDao.haveNum(stockDO);
//                            if (null != goodsNumList) {
//                                String gdcount = goodsNumList.getGoodsCount();
//                                String  goodsCountNew = counts;
//                                Integer gdcountNew = Integer.parseInt(gdcount);
//                                Double goodsCountNews = Double.parseDouble(goodsCountNew);
//                                Double newGoodsCount = gdcountNew + goodsCountNews;
//                                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
//
//                                stockDao.updateGoodsCount(stockDO);//修改数量
//                            } else if(null == goodsNumList) {
//                                stockDao.save(stockDO);
//                            }
//                            stockDao.save(stockDO);

//-----------------------------采购订单--------------------
                            OrderDO orderDO = new OrderDO();
                            orderDO.setGoodsNum(goodsNum);
//                            orderDO.setGoodsCode(goodsCode);
                            orderDO.setUseday(xiaoqi);
                            if (usedays !="" && usedays !=null){
                                orderDO.setGoodsCode(goodsCode+code);
                            }else {
                                orderDO.setGoodsCode(goodsCode+"00000000");
                            }
                            orderDO.setGoodsName(goodsName);
                            orderDO.setGoodsCount(counts);
                            orderDO.setGoodsType(goodstype);
                            orderDO.setMfrsid(mfrsid);
                            orderDO.setBrandname(brandname);
                            orderDO.setUnit(unitname);
                            orderDO.setRetailPrice(retailPrice);
                            orderDO.setPositionId(positionId);
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
                if (list.size() > 0) {
                    return R.ok("上传成功,共增加[" + num + "]条,第" + list + "行导入用户失败，原因：姓名或者出生日期可能无效");
                } else {
                    return R.ok("上传成功,共增加[" + num + "]条");
                }
            } else {
                return R.error("请选择导入的文件!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    //判断名字是否都为汉字
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
