document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();
};
var barHtml="";
function findGoods(){
    var positionId = $("#positionId").val();
    var mfrsname = $("#mfrsname").val();
    var goodsCode = $("#goodsCode").val();
    // alert(mfrsname);
    $.ajax({
        url: "/stock/tuihuo/codeList",
        type: "post",
        data: {
            'positionId': positionId,
            'mfrsname': mfrsname,
            'goodsCode': goodsCode
        },
        dataType: 'JSON',
        async: false,
        success: function (datajson) {
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            // parent.layer.close(index);  // 关闭layer
            $(datajson).each(function (key) {  //循环读取后台传来的Json数据

                if(null == datajson[key].goodsNum){
                    datajson[key].goodsNum ="";
                }
                if(null == datajson[key].goodsName){
                    datajson[key].goodsName ="";
                }
                if(null == datajson[key].factory){
                    datajson[key].factory ="";
                }
                if(null == datajson[key].unit){
                    datajson[key].unit ="";
                }
                if(null == datajson[key].goodsCount){
                    datajson[key].goodsCount ="";
                }

                if(null == datajson[key].goodsCode){
                    datajson[key].goodsCode ="";
                }
                if(null == datajson[key].goodsxinxiid){
                    datajson[key].goodsxinxiid ="";
                }
                if(null == datajson[key].retailPrice){
                    datajson[key].retailPrice ="";
                }

                // alert(datajson[key].zhuceNumber);
                barHtml+= "<tr class='val'> ";
                barHtml+= "<td name='goodsNum'>" + datajson[key].goodsNum + "</td>";
                barHtml+= "<input name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'>";
                barHtml+= "<td name='goodsName'>" + datajson[key].goodsName + "</td>";
                barHtml+= "<input name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'>";
                barHtml+= "<td name='factory'>" + datajson[key].factory + "</td>";
                barHtml+= "<input name='factory' type='hidden' value='" + datajson[key].factory + "'>";

                barHtml+= "<td name='unit'>" + datajson[key].unit + "</td>";
                barHtml+= "<input name='unit' type='hidden' value='" + datajson[key].unit + "'>";
                barHtml+= "<td name='goodsCount'>" + datajson[key].goodsCount + "</td>";
                barHtml+= "<input name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'>";

                barHtml+= "<td>" + "<input name='count' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)'/>" + "</td>";

                barHtml+= "<td name='goodsCode'>" + datajson[key].goodsCode + "</td>";
                barHtml+= "<input name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'>";
                barHtml+= "<input name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'>";
                barHtml+= "<td style='display: none' name='retailPrice'>" + datajson[key].retailPrice + "</td>";
                barHtml+= "<input name='retailPrice' type='hidden' value='" + datajson[key].retailPrice + "'>";
                barHtml+= "<td><em  onclick='delertTr(this)'></em></td>";
                barHtml+= "</tr>";
                parent.$("#inventoryId").append(barHtml);
            });
        }
    });
}