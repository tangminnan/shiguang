package com.shiguang.product.service;

import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.product.domain.ProducaDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 镜架新增表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
public interface ProducaService {
    ProducaDO get(Long id);


    //判断是否存在商品代码
    List<ProducaDO> haveNum(Map<String, Object> map);


    //修改时显示制造商和商品品种名称
    List<ProducaDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ProducaDO produca);

    //修改停用启用
    int update(ProducaDO produca);

    int remove(Long id);

    int batchRemove(Long[] ids);

    ProducaDO getJjBygoodNums(String goodNum);

    //菜单联动显示
    List<BrandDO> choice(Map<String, Object> map);

    //删除修改状态
    int updateState(ProducaDO produca);

    ProducaDO getJJInfomation(String goodNum);

    //采购批量导入
    R importStock( String goodsType,String mfrsid,String brandnum,String brandname,Integer unitid,String year,String tax,String taxPrice,
                   String tradePrice,String transferPrice,String classtype,
                   Long xsstate,Long state,MultipartFile file);

    void jjOut( HttpServletRequest request, HttpServletResponse response);
}
