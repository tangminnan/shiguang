document.onkeydown = function(e){
    var isclick=true;
    if((e||event).keyCode==13){
        if (isclick){
            // alert(isclick);
            isclick= false;
            findGoods();
            setTimeout(function () {
                isclick =true;
            },5000);
        }
    }
};
var barHtml="";
var flag="";
var flags="";
function findGoods(){
    var positionId = $("#positionId").val();
    var mfrsname = $("#mfrsname").val();
    var goodsCode = $("#goodsCode").val();
    // alert(goodsCode);
    if (goodsCode=="" || goodsCode==null){
        layer.alert("商品条码为空！");
    }else {
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

                    if (null == datajson[key].goodsNum) {
                        datajson[key].goodsNum = "";
                    }
                    if (null == datajson[key].goodsName) {
                        datajson[key].goodsName = "";
                    }
                    if (null == datajson[key].factory) {
                        datajson[key].factory = "";
                    }
                    if (null == datajson[key].unit) {
                        datajson[key].unit = "";
                    }
                    if (null == datajson[key].goodsCount) {
                        datajson[key].goodsCount = "";
                    }

                    if (null == datajson[key].goodsCode) {
                        datajson[key].goodsCode = "";
                    }
                    if (null == datajson[key].goodsxinxiid) {
                        datajson[key].goodsxinxiid = "";
                    }
                    if (null == datajson[key].retailPrice) {
                        datajson[key].retailPrice = "";
                    }

                    barHtml += "<tr class='val'> ";
                    barHtml += "<td name='goodsNum'>" + datajson[key].goodsNum + "</td>";
                    barHtml += "<input name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'>";
                    barHtml += "<td name='goodsName'>" + datajson[key].goodsName + "</td>";
                    barHtml += "<input name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'>";
                    barHtml += "<td name='factory'>" + datajson[key].factory + "</td>";
                    barHtml += "<input name='factory' type='hidden' value='" + datajson[key].factory + "'>";

                    barHtml += "<td name='unit'>" + datajson[key].unit + "</td>";
                    barHtml += "<input name='unit' type='hidden' value='" + datajson[key].unit + "'>";
                    barHtml += "<td name='goodsCount'>" + datajson[key].goodsCount + "</td>";
                    barHtml += "<input name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'>";

                    barHtml += "<td>" + "<input name='count' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)' value='1' />" + "</td>";

                    barHtml += "<td name='goodsCode'>" + datajson[key].goodsCode + "</td>";
                    barHtml += "<input name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'>";
                    barHtml += "<input name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'>";
                    barHtml += "<td style='display: none' name='retailPrice'>" + datajson[key].retailPrice + "</td>";
                    barHtml += "<input name='retailPrice' type='hidden' value='" + datajson[key].retailPrice + "'>";
                    barHtml += "<td><em  onclick='delertTr(this)'></em></td>";
                    barHtml += "</tr>";
                    if (window.parent.$("input[name=goodsCode]").length == 0) {
                        parent.$("#inventoryId").append(barHtml);
                        window.parent.$("input[name=newcount]").val(1);
                    } else if (window.parent.$("input[name=goodsCode]").length != 0) {
                        var arr = new Array();
                        var countarr = new Array();
                        for (var i = 0; i < window.parent.$("input[name=goodsCode]").length; i++) {
                            var goodsCode = window.parent.$("input[name=goodsCode]").eq(i).val();
                            var useCount = window.parent.$("input[name=count]").eq(i).val();
                            arr[i] = goodsCode;
                            countarr[i] = useCount;
                        }

                        for (var index = 0; index < arr.length; index++) {

                            if (arr[index] == datajson[key].goodsCode) {
                                flag = "1";
                                flags = "修改";
                                var count = countarr[index];
                                window.parent.$("input[name=count]").eq(index).val(parseInt(count) + parseInt(1));
                                var shuliang = window.parent.$("input[name=newcount]").val();
                                window.parent.$("input[name=newcount]").val(parseInt(shuliang) + parseInt(1));
                                return;
                            } else if (arr[index] != datajson[key].goodsCode) {
                                flag = "0";
                                flags = "新增";
                            }


                        }
                    }
                });
            }
        });

        if (flags == "新增" && flag == "0") {
            parent.$("#inventoryId").append(barHtml);
            var shuliang = window.parent.$("input[name=newcount]").val();
            window.parent.$("input[name=newcount]").val(parseInt(shuliang) + parseInt(1));
        }
    }
}
