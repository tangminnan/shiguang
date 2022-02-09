package com.shiguang.product.service.impl;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.common.config.BootdoConfig;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.ProducaDao;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.impl.WeiwaiServiceImpl;
import com.shiguang.system.config.ExcelUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ProducaServiceImpl implements ProducaService {
    @Autowired
    private ProducaDao producaDao;
    @Autowired
    private BootdoConfig bootdoConfig;

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
    public R importStock(String goodsType, String mfrsid, String brandnum, String brandname, Integer unitid, String year, String tax, String taxPrice,
                         String tradePrice, String transferPrice, String classtype, Long xsstate, Long state,
                         MultipartFile file) {
        System.out.println("==============file================" + file);
        int num = 0;
        String sl = "";
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
                            ExcelUtils.getCellFormatValue(row.getCell((short) 1)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != null
                    ) ;
                    else
                        return R.error("Excel中有部分基本信息数据为空，请检查好重新导入");
                }

                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String producFactory = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");    // 型号
                        String producFactorycolor = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");    //  色号
                        String retailPrice = ExcelUtils.getCellFormatValue(row.getCell((short) 2)).replaceAll("[\t\n' ']", "");    //  零售价
                        String factoryAdd = "";
                        String factorycolorAdd = "";
                        if (producFactory.length() < 9) {
                            int factoryLength = 9 - producFactory.length();
                            for (int a = 0; a < factoryLength; a++) {
                                factoryAdd = factoryAdd + "0";
                            }
                        }
                        if (producFactorycolor.length() < 4) {
                            int factorycolorLength = 4 - producFactorycolor.length();
                            for (int a = 0; a < factorycolorLength; a++) {
                                factorycolorAdd = factorycolorAdd + "0";
                            }
                        }
                        producFactory = factoryAdd + producFactory;
                        producFactorycolor = factorycolorAdd + producFactorycolor;


                        ProducaDO producaDO = new ProducaDO();
                        String producNum = goodsType + "." + mfrsid + "." + brandnum + "." + producFactory + "." + producFactorycolor;
                        String producCode = goodsType + mfrsid + brandnum + producFactory + producFactorycolor;

                        producaDO.setProducNum(producNum);
                        producaDO.setProducCode(producCode);
                        producaDO.setProducName(brandname + "-型号:" + producFactory + "-色号:" + producFactorycolor + "-标价:" + retailPrice);
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
                        map.put("producNum", producNum);
                        List<ProducaDO> haveNum = producaDao.haveNum(map);
                        if (haveNum.size() > 0) {
                            sl = sl + "," + String.valueOf(rowNum - 1);
                        } else {
                            producaDao.save(producaDO);
                            num++;
                        }
                    } catch (Exception e) {
                        System.out.println("导入失败======第" + (rowNum + 1) + "条==================");
                        e.printStackTrace();
                    }

                }
                if (listSize.size() > 0) {
                    return R.ok("上传成功,共增加[" + num + "]条,第" + sl + "行导入失败，原因：商品代码已存在");
                } else {
                    if (sl != "") {
                        return R.ok("上传成功,共增加[" + num + "]条,第" + sl + "行导入失败，原因：商品代码已存在");
                    } else {
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










//    导出查询
    public Map<String, Object>  jjlist(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        List<ProducaDO> producaDOList = list(map);

        List<Map<String, Object>> arry = new ArrayList<>();
        for (int i=0;i<producaDOList.size();i++){
            String producNum=producaDOList.get(i).getProducNum();
            String viewGoodName=producaDOList.get(i).getViewGoodName();
            String count="0";
            String chengben="";
            String factory=producaDOList.get(i).getFactory();
            String producColor=producaDOList.get(i).getProducColor();
            String retailPrice=producaDOList.get(i).getRetailPrice();
            Map<String,Object> jjmap=new HashMap<>();
            jjmap.put("producNum",producNum);
            jjmap.put("viewGoodName",viewGoodName);
            jjmap.put("count",count);
            jjmap.put("chengben",chengben);
            jjmap.put("factory",factory);
            jjmap.put("producColor",producColor);
            jjmap.put("retailPrice",retailPrice);
            arry.add(i,jjmap);
        }
        Map<String, Object> outList = new HashMap();
        outList.put("arry",arry);
        return outList;
    }




    public void createDoc(HttpServletResponse response, Map<String, Object>  dataMap, String fileName, String template) {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(WeiwaiServiceImpl.class, "/");
        Template t = null;
        try {
            //word.xml是要生成Word文件的模板文件
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
    public void jjOut(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, Object>  outList = jjlist(request, response);
//            createDoc(response,outList, "镜架信息"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), "jjOut.ftl");
            createDoc(response,outList, "镜架信息", "jjOut.ftl");
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
