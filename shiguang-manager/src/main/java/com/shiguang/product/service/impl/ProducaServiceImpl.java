package com.shiguang.product.service.impl;

import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.ProducaDao;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.system.config.ExcelUtils;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
public class ProducaServiceImpl implements ProducaService {
    @Autowired
    private ProducaDao producaDao;

    @Override
    public ProducaDO get(Long id) {
        return producaDao.get(id);
    }
    //判断是否存在制造商代码

    @Override
    public List<ProducaDO> haveNum(Map<String, Object> map) {
        return producaDao.haveNum(map);
    }

    //修改时显示制造商和商品品种名称
    @Override
    public List<ProducaDO> list(Map<String, Object> map) {
        return producaDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return producaDao.count(map);
    }

    @Override
    public int save(ProducaDO produca) {
        return producaDao.save(produca);
    }

    //修改停用启用
    @Override
    public int update(ProducaDO produca) {
        return producaDao.update(produca);
    }

    @Override
    public int remove(Long id) {
        return producaDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return producaDao.batchRemove(ids);
    }

    @Override
    public ProducaDO getJjBygoodNums(String goodNum) {
        return producaDao.getJjBygoodNums(goodNum);
    }

    //菜单联动显示
    @Override
    public List<BrandDO> choice(Map<String, Object> map) {
        return producaDao.choice(map);
    }

    //删除修改状态
    @Override
    public int updateState(ProducaDO produca) {
        return producaDao.updateState(produca);
    }

    @Override
    public ProducaDO getJJInfomation(String goodNum) {
        return producaDao.getJJInfomation(goodNum);
    }

    /**
     * excel数据导入
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public R importStock(String goodsType, String mfrsid, String brandnum, String brandname, Integer unitid, String year,String tax, String taxPrice,
                         String tradePrice, String transferPrice, String classtype, Long xsstate, Long state,
                         MultipartFile file) {
        System.out.println("==============file================" + file);
        int num = 0;
        String sl="" ;
        InputStream in = null;
        Workbook book = null;
        List<Integer> listSize = new ArrayList<>();
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
                            ExcelUtils.getCellFormatValue(row.getCell((short) 1)) != null&&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != null
                    ) ;
                    else
                        return R.error("Excel中有部分基本信息数据为空，请检查好重新导入");
                }

                for ( int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String producFactory = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");    // 型号
                        String producFactorycolor  = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");    //  色号
                        String retailPrice= ExcelUtils.getCellFormatValue(row.getCell((short) 2)).replaceAll("[\t\n' ']", "");    //  零售价
                        String factoryAdd="";
                        String factorycolorAdd="";
                        if (producFactory.length()<9){
                            int factoryLength=9-producFactory.length();
                            for ( int a=0;a<factoryLength;a++){
                                factoryAdd=factoryAdd + "0";
                            }
                        }
                        if (producFactorycolor.length()<4){
                            int factorycolorLength=4-producFactorycolor.length();
                            for ( int a=0;a<factorycolorLength;a++){
                                factorycolorAdd=factorycolorAdd + "0";
                            }
                        }
                        producFactory=factoryAdd+producFactory;
                        producFactorycolor=factorycolorAdd+producFactorycolor;


                        ProducaDO  producaDO=new ProducaDO();
                        String producNum=goodsType+"."+mfrsid+"."+brandnum+"."+producFactory+"."+producFactorycolor;
                        String producCode=goodsType+mfrsid+brandnum+producFactory+producFactorycolor;

                        producaDO.setProducNum(producNum);
                        producaDO.setProducCode(producCode);
                        producaDO.setProducName(brandname+"-型号:"+producFactory+"-色号:"+producFactorycolor+"-标价:"+retailPrice);
                        producaDO.setMfrsid(mfrsid);
                        producaDO.setBrandnum(brandnum);
                        producaDO.setFactory(producFactory);
                        producaDO.setProducFactory(producFactory);
                        producaDO.setProducFactorycolor(producFactorycolor);
                        producaDO.setProducColor(producFactorycolor);
                        producaDO.setUnitid(unitid);
                        producaDO.setYear(year);
                        producaDO.setTax(tax);
                        producaDO.setTaxPrice(taxPrice);
                        producaDO.setTradePrice(tradePrice);
                        producaDO.setTransferPrice(transferPrice);
                        producaDO.setRetailPrice(retailPrice);
                        producaDO.setXsstate(xsstate);
                        producaDO.setState(state);
                        producaDO.setClasstype(classtype);
                        producaDO.setViewGoodName(brandname);
                        //判断是否已存在商品代码
                        Map<String, Object> map = new HashMap<>();
                        map.put("producNum",producNum);
                        List<ProducaDO> haveNum=producaDao.haveNum(map);
                        if (haveNum.size() > 0) {
                            sl=sl+","+String.valueOf(rowNum-1);
                        }else {
                            producaDao.save(producaDO);
                            num++;
                        }
                    } catch (Exception e) {
                        System.out.println("导入失败======第" + (rowNum + 1) + "条==================");
                        e.printStackTrace();
                    }

                }
                if ( listSize.size()> 0) {
                    return R.ok("上传成功,共增加[" + num + "]条,第" + sl + "行导入失败，原因：商品代码已存在");
                } else {
                    if (sl!=""){
                        return R.ok("上传成功,共增加[" + num + "]条,第" +  sl + "行导入失败，原因：商品代码已存在");
                    }else {
                        return R.ok("上传成功,共增加[" + num + "]条");
                    }

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


}
