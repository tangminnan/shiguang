package com.shiguang.member.service.impl;

import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.common.utils.isIDCardUtil;
import com.shiguang.member.dao.MemberDao;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberDO get(Long id){
        return memberDao.get(id);
    }

    @Override
    public MemberDO getCardNumber(String cardNumber){
        return memberDao.getCardNumber(cardNumber);
    }

    @Override
    public List<MemberDO> list(Map<String, Object> map){
        return memberDao.list(map);
    }

    @Override
    public List<MemberDO> payList(Map<String, Object> map){
        return memberDao.payList(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return memberDao.count(map);
    }

    @Override
    public int payCount(Map<String, Object> map){
        return memberDao.payCount(map);
    }

    @Override
    public int save(MemberDO member){
        return memberDao.save(member);
    }

    @Override
    public int update(MemberDO member){
        return memberDao.update(member);
    }

    @Override
    public int remove(Long id){
        return memberDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids,Long status){
        return memberDao.batchRemove(ids,status);
    }

    @Override
    public int updateStatus(MemberDO memberDO){
        return memberDao.update(memberDO);
    }

    /**
     * excel数据导入
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public R importMember(String departNumber, String checkType, MultipartFile file) {
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
                            ExcelUtils.getCellFormatValue(row.getCell((short) 1)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 2)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 3)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 3)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 4)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 4)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 5)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 5)) != null &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 6)) != "" &&
                            ExcelUtils.getCellFormatValue(row.getCell((short) 6)) != null) ;
                    else
                        return R.error("Excel中有部分基本信息数据为空，请检查好重新导入");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String name = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");    // 姓名
                        String memberCard = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");    // 卡号
                        //row.getCell((short) 2))
                        Cell cell = row.getCell((short) 2);
                        cell.setCellType(CellType.NUMERIC);
                        Double sex = Double.parseDouble(ExcelUtils.getCellFormatValue(cell).replaceAll("[\t\n' ']", ""));//性别
                        String birthday = ExcelUtils.getCellFormatValue(row.getCell((short) 3)).replaceAll("[\t\n' ']", "");        //出生日期
                        cell = row.getCell((short) 4);
                        cell.setCellType(CellType.STRING);
                        String phone = ExcelUtils.getCellFormatValue(cell).replaceAll("[^0-9]", "");        //手机号
                        String memberPoints = ExcelUtils.getCellFormatValue(row.getCell((short) 5)).replaceAll("[\t\n' ']", "");        //会员积分
                        String remark = ExcelUtils.getCellFormatValue(row.getCell((short) 6)).replaceAll("[\t\n' ']", "");        //备注
                        if (!checkRealName(name)) {
                            list.add(rowNum + 1);
                            continue;
                        }
                        MemberDO member = new MemberDO();
                        member.setName(name);
                        if (sex != null) {
                            member.setSex(sex.longValue());
                        }
                        member.setCardNumber(memberCard);
                        member.setPhone1(phone);
                        member.setRemark(remark);
                        member.setStatus(1L);
                        member.setDepartNumber(departNumber);

                        Date dd = new Date();
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        if (StringUtils.isNotBlank(birthday)) {
                            if (birthday.contains("-")) {
                                dd = sdf.parse(birthday);
                                //student.setLastCheckTime(dd);
                            } else {
                                Calendar calendar = new GregorianCalendar(1900, 0, -1);
                                Date d = calendar.getTime();
                                dd = DateUtils.addDays(d, Integer.parseInt(birthday.substring(0, birthday.indexOf("."))));
                                String str = sdf.format(dd);
                                String yeah = str.substring(0,4); //取年
                                String yue = str.substring(str.indexOf("年")+1,str.indexOf("月")); //取月
                                String ri = str.substring(str.indexOf("月")+1,str.indexOf("日")); //取日
                                member.setBirthdayYear(Long.valueOf(yeah));
                                member.setBirthdayMonth(Long.valueOf(yue));
                                member.setBirthdayDay(Long.valueOf(ri));
                                Calendar cal = Calendar.getInstance();
                                int yearNow = cal.get(Calendar.YEAR);  //当前年份
                                int yearBirth = Integer.parseInt(yeah);
                                int age = yearNow - yearBirth;   //计算整岁数
                                member.setAge((long)age);
                                //student.setLastCheckTime(dd);
                            }
//                             dd = format.parse(birthday);
//                             String str = sdf.format(dd);
//                            String yeah = str.substring(0,4); //取年
//                            String yue = str.substring(str.indexOf("年")+1,str.indexOf("月")); //取月
//                            String ri = str.substring(str.indexOf("月")+1,str.indexOf("日")); //取日
//                            member.setBirthdayYear(Long.valueOf(yeah));
//                            member.setBirthdayMonth(Long.valueOf(yue));
//                            member.setBirthdayDay(Long.valueOf(ri));
                        }

                        memberDao.save(member);

                        num++;


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
