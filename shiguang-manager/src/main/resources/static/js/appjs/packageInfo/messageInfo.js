function getGoodsInfo(obj){
    var str = obj.id;
    var str = str.split("")
    var targetStr = str[str.length-1]
    var goodsType = $("#goodType"+targetStr+"").val();
    // var fenlei = $("#fenlei").val();
    // var caizhi = $("#caizhi").val();
     layer.open({
        type : 2,
        title : '商品信息',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '1300px', '800px' ],
        content : "/information/package/goodsInfo/"+goodsType, // iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i=0;i<rows.length;i++){
                $("#goodsName"+targetStr+"").val(rows[i].producName);
                $("#goodsid"+targetStr+"").val(rows[i].producNum);
                $("#goodsYJStart"+targetStr+"").val(rows[i].retailPrice);
                $("#goodsYJEnd"+targetStr+"").val(rows[i].retailPrice)
            }
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    // layer.full(toIndex)
}
var pricestart=0;
var priceEnd=0;
function getStartPrice(obj) {
    pricestart = $("#startPrice").val();
    if (pricestart == ''){
        pricestart=0;
    }
    var str = obj.id;
    var str = str.split("")
    var targetStr = str[str.length-1]
    var taocanStart = $("#taocanStart"+targetStr+"").val();
    taocanStart = parseFloat(pricestart)+parseFloat(taocanStart);
    $("#startPrice").val(taocanStart);

}
function getEndPrice(obj){
    priceEnd = $("#endPrice").val();
    if (priceEnd == ''){
        priceEnd=0;
    }
    var str = obj.id;
    var str = str.split("")
    var targetStr = str[str.length-1];
    var taocanEnd = $("#taocanEnd"+targetStr+"").val();
    taocanEnd = parseFloat(priceEnd) + parseFloat(taocanEnd);
    $("#endPrice").val(taocanEnd)
}
var htmldy="";
var b = 0;
$("#addDanyiGoods").click(function () {
    if ($("#packageType").val() == ''){
        return alert("请先选择套餐分类");
    }
    htmldy = "<tr>";
    htmldy += "<td><input type=\"checkbox\" id=\"allChecks\" name='allChecks' class='cb'/></td>";
    htmldy +="<td>";
    if ($("#packageType").val() == "辅料销售"){
        html += "<select name='goodsType' id='goodType"+a+"' onchange='selectChange(this)'> <option value=''>--请选择--</option><option value='配件'>配件</option>" +
            "<option value='太阳镜'>太阳镜</option><option value='老花镜'>老花镜</option><option value='耗材'>耗材</option><option value='视光'>视光</option><option value='隐形护理液'>隐形护理液</option></select>";
    } else if ($("#packageType").val() == "隐形销售"){
        html += "<select name='goodsType' id='goodType"+a+"' onchange='selectChange(this)'> <option value=''>--请选择--</option><option value='隐形成品片'>隐形成品片</option><option value='隐形订做片'>隐形订做片</option><option value='配件'>配件</option>" +
            "<option value='太阳镜'>太阳镜</option><option value='老花镜'>老花镜</option><option value='耗材'>耗材</option><option value='视光'>视光</option><option value='隐形护理液'>隐形护理液</option></select>";
    } else if ($("#packageType").val() == "框镜销售"){
        html += "<select name='goodsType' id='goodType"+a+"' onchange='selectChange(this)'> <option value=''>--请选择--</option><option value='镜架'>镜架</option><option value='配件'>配件</option>" +
            "<option value='成品片'>成品片</option><option value='订做片'>订做片</option><option value='太阳镜'>太阳镜</option>" +
            "<option value='老花镜'>老花镜</option><option value='耗材'>耗材</option><option value='视光'>视光</option><option value='隐形护理液'>隐形护理液</option></select>";
    }
    // htmldy += " <select name='goodsType' id='goodType"+b+"' onchange='selectChange(this)'> <option value=''>--请选择--</option><option value='镜架'>镜架</option><option value='配件'>配件</option>" +
    //     "<option value='成品片'>成品片</option><option value='订做片'>订做片</option><option value='太阳镜'>太阳镜</option>" +
    //     "<option value='老花镜'>老花镜</option><option value='耗材'>耗材</option><option value='视光'>视光</option><option value='隐形护理液'>隐形护理液</option></select>";
    htmldy += "<select name='caizhi' id='caizhi"+b+"' onchange='getCaizhi(this)' style='display: none'></select>";
    htmldy += "<select name='fenlei' id='fenlei"+b+"' style='display: none'></select>";
    htmldy += "<input name='qoujingStart' type='text' id='qoujingStart"+b+"' style='display: none;'/><input type='text' name='qoujingEnd' id='qoujingEnd"+b+"' style='display: none;'/>";
    htmldy += "<input name='zhuingStart' type='text' id='zhujingStart"+b+"' style='display: none;'/><input name='zhujingEnd' type='text' id='zhujingEnd"+b+"' style='display: none;'/>";
    htmldy += "<input type='text' style='width: 20%;' name='goodsName' id='goodsName"+b+"'/><input type='hidden' style='width: 20%;' name='goodsid' id='goodsid"+b+"'/><input type='button' id='xuanze"+b+"' onclick='getGoodsInfo(this)' value='选择'/>";
    htmldy += "</td>";
    htmldy += "<td><input class=\"short\" type=\"text\" id='goodsYJStart"+b+"' name='originalStartPrice' /> 至 <input class=\"short\" type=\"text\" id='goodsYJEnd"+b+"' name='originalEndPrice'></td>";
    htmldy += "<td><input class=\"short\" type=\"text\" id='taocanStart"+b+"' name='packageStartPrice' onchange='getStartPrice(this)' /> 至 <input class=\"short\" type=\"text\" id='taocanEnd"+b+"' name='packageEndPrice' onchange='getEndPrice(this)'></td>";
    htmldy += "<td><input type=\"text\" id='goodsNums"+b+"' name='goodsNums'/></td>";
    htmldy += "<td><input class=\"short\" type=\"text\" id='xiaofeiStart"+b+"' name='fullStartPrice'/> 至 <input class=\"short\" type=\"text\" id='xiaofeiEnd"+b+"' name='fullEndPrice'></td>";
    htmldy += "</tr>";
    $("#trdy1").append(htmldy);
})
function deleteTr(obj){
    obj.parentNode.parentNode.remove();	//删除上上一级的元素
}
function shanchu(){
    var cn = document.getElementsByName("allChecks");
    for (var i = 0; i < cn.length;i++) {
        if (cn[i].checked){
            deleteTr(cn[i]);
            i = -1;
        }
    }
}