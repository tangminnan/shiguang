document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();
};
var barHtml="";
var a = 0;
function findGoods(){
    //alert(parent.sdsd);
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
            //alert(JSON.stringify(datajson));

            //var listMaps = window.localStorage.getItem("listMap");
            var ll = parent.listMap;
            //alert(ll.length);
            if ('' != parent.listMap){
                for (var i=0;i<ll.length;i++){
                    // var tt = JSON.stringify(ll);
                    if (datajson[0].goodsCode  == ll[i][0].goodsCode){
                        ll[i][0].goodsCount = Number(ll[i][0].goodsCount) + Number(1);
                        a=1;
                    }
                }
                if (a==0){
                    parent.listMap.push(datajson);
                }
            } else {
                parent.listMap.push(datajson)
            }

            //alert(JSON.stringify(parent.listMap));
            var list = parent.listMap;
            //alert(list.length);
            parent.$("#inventoryId").empty();
            barHtml = '<tr class="thead"></tr><td><input type="checkbox" /></td>';
            barHtml += '<td>商品代码</td>';
            barHtml += '<td>商品条码</td>';
            barHtml += '<td>商品名称</td>';
            barHtml += '<td>型号</td>';
            barHtml += '<td>数量</td></tr>';
            parent.$("#inventoryId").append(barHtml);
            for (var key = 0;key<list.length;key++){
                // alert(JSON.stringify(list[key]));
                // alert(list[key][0].goodsCode);
                barHtml = "<tr><td><input type='checkbox' /></td>";
                barHtml += "<td>"+list[key][0].goodsNum+"</td>";
                barHtml += "<td><input id='producCode' name='producCode' value='"+list[key][0].goodsCode+"'/></td>";
                barHtml += "<td>"+list[key][0].goodsName+"</td>";
                barHtml += "<td>"+list[key][0].factory+"</td>";
                barHtml += "<td><input id='inventoryCount' name='inventoryCount' value='"+list[key][0].goodsCount+"'/></td></tr>";
                barHtml += "<input id='goodsId' name='goodsId' type='hidden' value='"+list[key][0].id+"'>";
                barHtml += "<input id='goodsNum' name='goodsNum' type='hidden' value='"+list[key][0].goodsNum+"'>";
                barHtml += "<input id='goodsName' name='goodsName' type='hidden' value='"+list[key][0].goodsName+"'>";
                parent.$("#inventoryId").append(barHtml);
            }
            // $(parent.listMap).each(function (key) {  //循环读取后台传来的Json数据
            //     alert(JSON.stringify(parent.parent.listMap[key]));
            //     barHtml = "<tr><td><input type='checkbox' /></td>";
            //     barHtml += "<td>"+parent.parent.listMap[key][key].goodsNum+"</td>";
            //     barHtml += "<td><input id='producCode' name='producCode' value='"+parent.listMap[key][key].goodsCode+"'/></td>";
            //     barHtml += "<td>"+parent.listMap[key][key].goodsName+"</td>";
            //     barHtml += "<td>"+parent.listMap[key][key].factory+"</td>";
            //     barHtml += "<td><input id='inventoryCount' name='inventoryCount' value='"+parent.listMap[key][key].goodsCount+"'/></td></tr>";
            //     barHtml += "<input id='goodsId' name='goodsId' type='hidden' value='"+parent.listMap[key][key].id+"'>";
            //     //$("#inventoryId").append(barHtml);
            //     //var fir = parent.document.getElementById("inventoryId");
            //     parent.$("#inventoryId").append(barHtml);
            // });
        }
    });
}