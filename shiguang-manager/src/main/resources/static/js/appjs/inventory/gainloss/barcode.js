document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();
};
var barHtml="";
function findGoods(){
    var goodsCode = $("#goodsCode").val();
    var goodsType = $("#goodsType").val();
    var positionId = $("#positionId").val();
    // layer.open({
    //     type : 2,
    //     title : '商品添加',
    //     maxmin : true,
    //     shadeClose : false, // 点击遮罩关闭层
    //     area : [ '500px', '220px' ],
    //     content : "/information/gainLoss/barcode/" +goodsType+'/'+positionId, // iframe的url
    // });
    //window.open("/information/gainLoss/barcode?goodsType="+goodsType+'&positionId='+positionId);
    $.ajax({
        url: "/information/gainLoss/codeList",
        type: "post",
        data: {
            'goodsCode': goodsCode,
            'goodsType':goodsType,
            'positionId':positionId
        },
        dataType: 'JSON',
        async: false,
        success: function (datajson) {
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            //parent.layer.close(index);  // 关闭layer
            $(datajson).each(function (key) {  //循环读取后台传来的Json数据
                barHtml = "<tr><td><input type='checkbox' /></td>";
                barHtml += "<td>"+datajson[key].goodsNum+"</td>";
                barHtml += "<td><input id='producCode' name='producCode' value='"+datajson[key].goodsCode+"'/></td>";
                barHtml += "<td>"+datajson[key].goodsName+"</td>";
                barHtml += "<td>"+datajson[key].factory+"</td>";
                barHtml += "<td><input id='inventoryCount' name='inventoryCount'/></td></tr>";
                barHtml += "<input id='goodsId' name='goodsId' type='hidden' value='"+datajson[key].id+"'>";
                //$("#inventoryId").append(barHtml);
                //var fir = parent.document.getElementById("inventoryId");
                parent.$("#inventoryId").append(barHtml);
            });
        }
    });
}