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
var arr = new Array();
var countarr = new Array();
function findGoods(){
    var outPosition = $("#outPosition").val();
    var goodsCode = $("#goodsCode").val();
    if (goodsCode=="" || goodsCode==null){
        layer.alert("商品条码为空！");
    }else {
        $.ajax({
            url: "/stock/pidiao/codeList",
            type: "post",
            data: {
                'outPosition': outPosition,
                'goodsCode': goodsCode
            },
            dataType: 'JSON',
            async: false,
            success: function (datajson) {
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                $(datajson).each(function (key) {  //循环读取后台传来的Json数据
                    if(null == datajson[key].goodsNum){
                        datajson[key].goodsNum ="";
                    }
                    if(null == datajson[key].goodsName){
                        datajson[key].goodsName  ="";
                    }
                    if(null == datajson[key].factory){
                        datajson[key].factory ="";
                    }
                    if(null == datajson[key].goodsCount){
                        datajson[key].goodsCount  ="";
                    }
                    if(null == datajson[key].goodsCode){
                        datajson[key].goodsCode ="";
                    }
                    if(null == datajson[key].useday){
                        datajson[key].useday  ="";
                    }

                    if(null == datajson[key].batch){
                        datajson[key].batch  ="";
                    }

                    if(null == datajson[key].zhuceNumber){
                        datajson[key].zhuceNumber ="";
                    }
                    if(null == datajson[key].produceDay){
                        datajson[key].produceDay  ="";
                    }
                    if(null == datajson[key].classtype){
                        datajson[key].classtype  ="";
                    }
                    if(null == datajson[key].goodsid){
                        datajson[key].goodsid  ="";
                    }
                    if(null == datajson[key].mfrsid){
                        datajson[key].mfrsid ="";
                    }
                    if(null == datajson[key].brandname){
                        datajson[key].brandname  ="";
                    }

                    if(null == datajson[key].unit){
                        datajson[key].unit ="";
                    }

                    if(null == datajson[key].retailPrice ){
                        datajson[key].retailPrice   ="";
                    }

                    if(null ==  datajson[key].goodsxinxiid){
                        datajson[key].goodsxinxiid ="";
                    }

                    if(null == datajson[key].danjuNumber){
                        datajson[key].danjuNumber  ="";
                    }


                    barHtml+= "<tr class='val'> " ;
                    barHtml+= "<td name='goodsNum'>" + datajson[key].goodsNum + "</td> ";
                    barHtml+= "<input  name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'> ";
                    barHtml+= "<td name='goodsName'>" + datajson[key].goodsName + "</td> ";
                    barHtml+= "<input   name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'> ";
                    barHtml+= "<td name='factory'>" + datajson[key].factory + "</td> ";
                    barHtml+= "<input   name='factory' type='hidden' value='" + datajson[key].factory + "'> ";
                    barHtml+= "<td name='goodsCount'>" + datajson[key].goodsCount + "</td> ";
                    barHtml+= "<input   name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'> ";
                    barHtml+= "<td >" + "<input   name='useCount' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)' value='1'/>" + "</td>" ;
                    barHtml+= "<td name='goodsCode'>" + datajson[key].goodsCode + "</td> ";
                    barHtml+= "<input   name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'> ";
                    barHtml+= "<td name='useday'>" + datajson[key].useday + "</td> ";
                    barHtml+= "<input   name='useday' type='hidden' value='" + datajson[key].useday + "'> ";
                    barHtml+= "<td name='batch'>" + datajson[key].batch + "</td> ";
                    barHtml+= "<input   name='batch' type='hidden' value='" + datajson[key].batch + "'> ";
                    barHtml+= "<td name='zhuceNumber'>" + datajson[key].zhuceNumber + "</td> ";
                    barHtml+= "<input   name='zhuceNumber' type='hidden' value='" + datajson[key].zhuceNumber + "'> ";
                    barHtml+= "<td name='produceDay'>" + datajson[key].produceDay + "</td> ";
                    barHtml+= "<input   name='produceDay' type='hidden' value='" + datajson[key].produceDay + "'> ";
                    barHtml+= "<td name='classtype' style='display: none'>" + datajson[key].classtype + "</td> ";
                    barHtml+= "<input   name='classtype' type='hidden' value='" + datajson[key].classtype + "'> ";
                    barHtml+= "<td name='goodsid' style='display: none'>" + datajson[key].goodsid + "</td> ";
                    barHtml+= "<input   name='goods' type='hidden' value='" + datajson[key].goodsid + "'> ";
                    barHtml+= "<td name='mfrsid' style='display: none'>" + datajson[key].mfrsid + "</td> ";
                    barHtml+= "<input   name='mfrsid' type='hidden' value='" + datajson[key].mfrsid + "'> ";
                    barHtml+= "<td name='brandname' style='display: none'>" + datajson[key].brandname + "</td> ";
                    barHtml+= "<input   name='brandname' type='hidden' value='" + datajson[key].brandname + "'> ";
                    barHtml+= "<td name='unit' style='display: none'>" + datajson[key].unit + "</td> ";
                    barHtml+= "<input  name='unit' type='hidden' value='" + datajson[key].unit + "'> ";
                    barHtml+= "<td name='money' style='display: none'>" + datajson[key].retailPrice + "</td> ";
                    barHtml+= "<input   name='money' type='hidden' value='" + datajson[key].retailPrice + "'> ";
                    barHtml+= "<td name='goodsxinxiid' style='display: none'>" + datajson[key].goodsxinxiid + "</td> ";
                    barHtml+= "<input   name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'> ";
                    barHtml+= "<td name='stockorder' style='display: none'>" + datajson[key].danjuNumber + "</td> ";
                    barHtml+= "<input  name='stockorder' type='hidden' value='" + datajson[key].danjuNumber + "'> ";
                    barHtml+= "<td><em  onclick='delertTr(this)'></em></td> ";
                    barHtml+= "</tr>";
                    if (window.parent.$("input[name=goodsCode]").length==0){
                        parent.$("#inventoryId").append(barHtml);
                        window.parent.$("input[name=newcount]").val(1);
                    }else if (window.parent.$("input[name=goodsCode]").length!=0){
                        for (var i = 0; i < window.parent.$("input[name=goodsCode]").length; i++) {
                            var goodsCode = window.parent.$("input[name=goodsCode]").eq(i).val();
                            var useCount = window.parent.$("input[name=useCount]").eq(i).val();
                            arr[i] = goodsCode;
                            countarr[i] = useCount;
                        }
                        for ( var index = 0; index < arr.length; index++) {
                            if (arr[index] == datajson[key].goodsCode) {
                                flag="1";
                                flags="修改";
                                var count=countarr[index];
                                window.parent.$("input[name=useCount]").eq(index).val(parseInt(count) + parseInt(1));
                                var shuliang=window.parent.$("input[name=newcount]").val();
                                window.parent.$("input[name=newcount]").val(parseInt(shuliang) + parseInt(1));
                                return;
                            }else if (arr[index]!=datajson[key].goodsCode) {
                                flag="0";
                                flags="新增";
                            }
                        }

                    }
                });
            }
        });
        if (flags=="新增" && flag=="0"){
            // alert("条码没有过新增");
            parent.$("#inventoryId").append(barHtml);
            var shuliang=window.parent.$("input[name=newcount]").val();
            window.parent.$("input[name=newcount]").val(parseInt(shuliang) + parseInt(1));
        }
    }

}


