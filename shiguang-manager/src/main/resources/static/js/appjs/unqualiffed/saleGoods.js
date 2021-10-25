var dataArray=new Array();
function getData(objNum,objName,objCode,saleNumber){
    // dataArray["goodsNum"] = objNum;
    // dataArray["goodsName"] = objCode;
    // alert(dataArray)
    var map1={
        goodsNum:objNum,
        goodsName:objName,
        goodsCode:objCode,
        saleNumber:saleNumber
};
    if (null != map1){
        dataArray.push(map1);
    }
    return dataArray;
}
var goodsHtml="";
var c=0;
function addGoods (){
    var toIndex = layer.open({
        type : 2,
        title : '商品',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/unqualiffed/salegoods/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.getData();
            for (var i=0;i<(rows.length)-1;i++){
                c=c+1;
                goodsHtml = "<tr><td><input type=\"checkbox\" /></td>";
                goodsHtml += "<td>"+rows[i].goodsNum+"</td>";
                goodsHtml += "<input type='hidden' id='goodsNum' name='goodsNum' value='"+rows[i].goodsNum+"'>";
                goodsHtml += "<input type='hidden' id='saleNumber' name='saleNumber' value='"+rows[i].saleNumber+"'>";
                goodsHtml += "<td>"+rows[i].goodsName+"</td>";
                goodsHtml += "<input type='hidden' id='goodsName' name='goodsName' value='"+rows[i].goodsName+"'>";
                goodsHtml += "<td style='width: 25%;'>";
                goodsHtml += "<select id='cause"+c+"' name='cause' onchange='getCause(this)'>";
                goodsHtml += "<option value=''>请选择所属原因</option>";
                goodsHtml += "<option value='供货商'>供货商</option>";
                goodsHtml += "<option value='库房'>库房</option>";
                goodsHtml += "<option value='销售'>销售</option>";
                goodsHtml += "<option value='验光'>验光</option>";
                goodsHtml += "<option value='加工'>加工</option>";
                goodsHtml += "<option value='质检'>质检</option>";
                goodsHtml += "<option value='维修、调试'>维修、调试</option>";
                goodsHtml += "<option value='配送'>配送</option>";
                goodsHtml += "<option value='顾客环节'>顾客环节</option>";
                goodsHtml += "</select>";
                goodsHtml += "<select id='phenomenon"+c+"' name='phenomenon' >";
                goodsHtml += "</select>";
                goodsHtml += "</td>";
                goodsHtml += "<td><input type='text' id='remark' name='remark'></td>";
                goodsHtml += "<td><input type='text' id='count' name='count' value='1' readonly></td>";
                goodsHtml += "<td><input type='text' id='goodsCode' name='goodsCode'value='"+rows[i].goodsCode+"'></td>";
                goodsHtml += "<td>";
                goodsHtml += "<select id='handle' name='handle'>";
                goodsHtml += "<option value='报残'>报残</option>";
                goodsHtml += "<option value='退回'>退回</option>";
                goodsHtml += "</select>";
                goodsHtml += "</td>";
                goodsHtml += "</tr>";
                $("#unqualId").append(goodsHtml);
            }
            //var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // for (var i=0;i<rows.length;i++){
            // }
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getCause(obj){
    var cause = obj.value;
    var str = obj.id;
    var str = str.split("")
    var targetStr = str[str.length-1]
    if (cause == "供货商"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='镜片脱模'>镜片脱模</option>" +
            "<option value='镜片度数不符'>镜片度数不符</option><option value='镜架掉色、脱漆'>镜架掉色、脱漆</option>" +
            "<option value='镜架断裂、脱焊'>镜架断裂、脱焊</option><option value='商品有瑕疵'>商品有瑕疵</option>" +
            "<option value='镜片破损'>镜片破损</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "库房"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='商品损坏'>商品损坏</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "销售"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='错票'>错票</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "验光"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='验光失误'>验光失误</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "加工"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='机损'>机损</option><option value='人损'>人损</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "质检"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='漏检'>漏检</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "维修、调试"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='维修、调试损坏'>维修、调试损坏</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "配送"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='商品损坏'>商品损坏</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    } else if (cause == "顾客环节"){
        var xianxiang="";
        xianxiang = "<option value=''>--请选择所属现象--</option><option value='三包期内损坏'>三包期内损坏</option>" +
            "<option value='三包期外损坏'>三包期外损坏</option><option value='顾客自觉戴镜不舒适'>顾客自觉戴镜不舒适</option>";
        $("#phenomenon"+targetStr+"").append(xianxiang);
    }
}