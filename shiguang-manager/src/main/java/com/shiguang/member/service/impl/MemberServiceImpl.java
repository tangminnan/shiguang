package com.shiguang.member.service.impl;

import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.common.utils.isIDCardUtil;
import com.shiguang.member.dao.MemberDao;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.JieKuanMoneyDO;
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
    public List<JieKuanMoneyDO> payList(Map<String, Object> map){
        return memberDao.payList(map);
    }

    @Override
    public List<JieKuanMoneyDO> payCountList(Map<String, Object> map){
        return memberDao.payCountList(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return memberDao.count(map);
    }

    @Override
    public List<MemberDO> heightlist(Map<String, Object> map){
        return memberDao.heightlist(map);
    }

    @Override
    public int heightcount(Map<String, Object> map){
        return memberDao.heightcount(map);
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
    public int updateInteger(MemberDO member){
        return memberDao.updateInteger(member);
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
     * excel????????????
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
                //???????????????Excel?????????????????????
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
                        return R.error("Excel???????????????????????????????????????????????????????????????");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy???MM???dd???");
                for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String name = ExcelUtils.getCellFormatValue(row.getCell((short) 0)).replaceAll("[\t\n' ']", "");    // ??????
                        String memberCard = ExcelUtils.getCellFormatValue(row.getCell((short) 1)).replaceAll("[\t\n' ']", "");    // ??????
                        //row.getCell((short) 2))
                        Cell cell = row.getCell((short) 2);
                        cell.setCellType(CellType.NUMERIC);
                        Double sex = Double.parseDouble(ExcelUtils.getCellFormatValue(cell).replaceAll("[\t\n' ']", ""));//??????
                        String birthday = ExcelUtils.getCellFormatValue(row.getCell((short) 3)).replaceAll("[\t\n' ']", "");        //????????????
                        cell = row.getCell((short) 4);
                        cell.setCellType(CellType.STRING);
                        String phone = ExcelUtils.getCellFormatValue(cell).replaceAll("[^0-9]", "");        //?????????
                        String memberPoints = ExcelUtils.getCellFormatValue(row.getCell((short) 5)).replaceAll("[\t\n' ']", "");        //????????????
                        String remark = ExcelUtils.getCellFormatValue(row.getCell((short) 6)).replaceAll("[\t\n' ']", "");        //??????
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
                        member.setStatus(0L);
                        member.setDepartNumber(departNumber);
                        member.setRegisterTime(new Date());
                        member.setMemberOption(0L);
                        member.setState(1L);

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
                                String yeah = str.substring(0,4); //??????
                                String yue = str.substring(str.indexOf("???")+1,str.indexOf("???")); //??????
                                String ri = str.substring(str.indexOf("???")+1,str.indexOf("???")); //??????
                                member.setBirthdayYear(Long.valueOf(yeah));
                                member.setBirthdayMonth(Long.valueOf(yue));
                                member.setBirthdayDay(Long.valueOf(ri));
                                Calendar cal = Calendar.getInstance();
                                int yearNow = cal.get(Calendar.YEAR);  //????????????
                                int yearBirth = Integer.parseInt(yeah);
                                int age = yearNow - yearBirth;   //???????????????
                                member.setAge((long)age);
                                //student.setLastCheckTime(dd);
                            }
//                             dd = format.parse(birthday);
//                             String str = sdf.format(dd);
//                            String yeah = str.substring(0,4); //??????
//                            String yue = str.substring(str.indexOf("???")+1,str.indexOf("???")); //??????
//                            String ri = str.substring(str.indexOf("???")+1,str.indexOf("???")); //??????
//                            member.setBirthdayYear(Long.valueOf(yeah));
//                            member.setBirthdayMonth(Long.valueOf(yue));
//                            member.setBirthdayDay(Long.valueOf(ri));
                        }

                        memberDao.save(member);

                        num++;


                    } catch (Exception e) {
                        System.out.println("????????????======???" + (rowNum + 1) + "???==================");
                        e.printStackTrace();
                    }

                }
                if (list.size() > 0) {
                    return R.ok("????????????,?????????[" + num + "]???,???" + list + "?????????????????????????????????????????????????????????????????????");
                } else {
                    return R.ok("????????????,?????????[" + num + "]???");
                }
            } else {
                return R.error("????????????????????????!");
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

    //??????????????????????????????
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


    @Override
    public List<MemberDO> yanguangList(Map<String, Object> map) {
        return memberDao.yanguangList(map);
    }

    @Override
    public int yanguangCount(Map<String, Object> map) {
        return memberDao.yanguangCount(map);
    }
}
