function getGoodsInfo(){
    var goodsType = $("#goodType").val();
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
            alert(JSON.stringify(rows));
            for (var i=0;i<rows.length;i++){
                $("#goodsName").val(rows[i].producName);
                $("#goodsid").val(rows[i].producNum);
                $("#goodsYJStart").val(rows[i].retailPrice);
                $("#goodsYJEnd").val(rows[i].retailPrice)
            }
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    // layer.full(toIndex)
}
var pricestart=0;
var priceEnd=0;
function getPrice() {
    var taocanStart = $("#taocanStart").val();
    var taocanEnd = $("#taocanEnd").val();
    taocanStart = parseFloat(pricestart)+parseFloat(taocanStart);
    taocanEnd = parseFloat(priceEnd) + parseFloat(taocanEnd);
    $("#startPrice").val(taocanStart);
    $("#endPrice").val(taocanEnd)
}
var htmldy="";
// $("#addDanyiGoods").click(function () {
//     if ($("#packageType").val() == ''){
//         return alert("请先选择套餐分类");
//     }
//     htmldy = "<tr>";
//     htmldy += "<td><input type=\"checkbox\" id=\"allChecks\" /></td>";
//     htmldy +="<td>";
//     htmldy += " <select name='goodType' id='goodType' onchange='selectChange()'> <option value=''>--请选择--</option><option value='镜架'>镜架</option><option value='配件'>配件</option>" +
//         "<option value='成品片'>成品片</option><option value='订做片'>订做片</option><option value='太阳镜'>太阳镜</option>" +
//         "<option value='老花镜'>老花镜</option><option value='耗材'>耗材</option><option value='视光'>视光</option><option value='隐形护理液'>隐形护理液</option></select>";
//     htmldy += "<select name='caizhi' id='caizhi' onchange='getCaizhi()' style='display: none'></select>";
//     htmldy += "<select name='fenlei' id='fenlei' style='display: none'></select>";
//     htmldy += "<input name='qoujingStart' type='text' id='qoujingStart' style='display: none;'/><input type='text' name='qoujingEnd' id='qoujingEnd' style='display: none;'/>";
//     htmldy += "<input name='zhuingStart' type='text' id='zhujingStart' style='display: none;'/><input name='zhujingEnd' type='text' id='zhujingEnd' style='display: none;'/>";
//     htmldy += "<input type='text' style='width: 20%;' name='goodsName' id='goodsName'/><input type='hidden' style='width: 20%;' name='goodsid' id='goodsid'/><input type='button' onclick='getGoodsInfo()' value='选择'/>";
//     htmldy += "</td>";
//     htmldy += "<td><input class=\"short\" type=\"text\" id='goodsYJStart' name='goodsYJStart' /> 至 <input class=\"short\" type=\"text\" id='goodsYJEnd' name='goodsYJEnd'></td>";
//     htmldy += "<td><input class=\"short\" type=\"text\" id='taocanStart' name='taocanStart' onchange='getPrice()' /> 至 <input class=\"short\" type=\"text\" id='taocanEnd' name='taocanEnd' onchange='getPrice()'></td>";
//     htmldy += "<td><input type=\"text\" id='goodsNums' name='goodsNums'/></td>";
//     htmldy += "<td><input class=\"short\" type=\"text\" id='xiaofeiStart' name='xiaofeiStart'/> 至 <input class=\"short\" type=\"text\" id='xiaofeiEnd' name='xiaofeiEnd'></td>";
//     htmldy += "</tr>";
//     $("#trdy1").append(htmldy);
// })
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