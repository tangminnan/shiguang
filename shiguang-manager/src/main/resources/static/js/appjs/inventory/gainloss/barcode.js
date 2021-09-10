document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();
};
var barHtml="";
function findGoods(){
    var goodsCode = $("#goodsCode").val();
    var goodsType = $("#goodsType").val();
    $.ajax({
        url: "/information/gainLoss/codeList",
        type: "post",
        data: {
            'goodsCode': goodsCode,
            'goodsType':goodsType
        },
        dataType: 'JSON',
        async: false,
        success: function (datajson) {
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);  // 关闭layer
            $(datajson).each(function (key) {  //循环读取后台传来的Json数据
                barHtml = "<tr><td><input type='checkbox' /></td>";
                barHtml += "<td>"+datajson[key].producNum+"</td>";
                barHtml += "<td><input id='producCode' name='producCode' value='"+datajson[key].producCode+"'/></td>";
                barHtml += "<td>"+datajson[key].producName+"</td>";
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