document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();
};
var barHtml="";
function findGoods(){
    // alert("批调扫描")
    var outPosition = $("#outPosition").val();
    var goodsCode = $("#goodsCode").val();
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
            parent.layer.close(index);  // 关闭layer
            $(datajson).each(function (key) {  //循环读取后台传来的Json数据
                // b=b+1;
                // alert(datajson[key].goodsNum);
                // alert(datajson[key].goodsName);
                // alert(datajson[key].goodsCode);
                // $(".liebiao").before("<tr class='val'> " +
                //     // "<td><input name='one'  type=\"checkbox\"/></td>\n" +
                //     "<td name='goodsNum'>" + datajson[key].goodsNum + "</td>\n" +
                //     "<input name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'>\n" +
                //     "<td name='goodsName'>" + datajson[key].goodsName + "</td>\n" +
                //     "<input name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'>\n" +
                //     "<td name='factory'>" + datajson[key].factory + "</td>\n" +
                //     "<input name='factory' type='hidden' value='" + datajson[key].factory + "'>\n" +
                //     "<td name='goodsCount'>" + datajson[key].goodsCount + "</td>\n" +
                //     "<input id='goodsCount" + b + "' name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'>\n" +
                //     "<td >" + "<input id='useCount" + b + "' name='useCount' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)'/>" + "</td>" +
                //     "<td name='goodsCode'>" + datajson[key].goodsCode + "</td>\n" +
                //     "<input name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'>\n" +
                //     "<td name='useday'>" + datajson[key].useday + "</td>\n" +
                //     "<input name='useday' type='hidden' value='" + datajson[key].useday + "'>\n" +
                //     "<td name='batch'>" + datajson[key].batch + "</td>\n" +
                //     "<input name='batch' type='hidden' value='" + datajson[key].batch + "'>\n" +
                //     "<td name='zhuceNumber'>" + datajson[key].zhuceNumber + "</td>\n" +
                //     "<input name='zhuceNumber' type='hidden' value='" + datajson[key].zhuceNumber + "'>\n" +
                //     "<td name='produceDay'>" + datajson[key].produceDay + "</td>\n" +
                //     "<input name='produceDay' type='hidden' value='" + datajson[key].produceDay + "'>\n" +
                //
                //
                //     "<td name='classtype' style='display: none'>" + datajson[key].classtype + "</td>\n" +
                //     "<input name='classtype' type='hidden' value='" + datajson[key].classtype + "'>\n" +
                //     "<td name='goodsid' style='display: none'>" + datajson[key].goodsid + "</td>\n" +
                //     "<input name='goods' type='hidden' value='" + datajson[key].goodsid + "'>\n" +
                //
                //     "<td name='mfrsid' style='display: none'>" + datajson[key].mfrsid + "</td>\n" +
                //     "<input name='mfrsid' type='hidden' value='" + datajson[key].mfrsid + "'>\n" +
                //     "<td name='brandname' style='display: none'>" + datajson[key].brandname + "</td>\n" +
                //     "<input name='brandname' type='hidden' value='" + datajson[key].brandname + "'>\n" +
                //     "<td name='unit' style='display: none'>" + datajson[key].unit + "</td>\n" +
                //     "<input name='unit' type='hidden' value='" + datajson[key].unit + "'>\n" +
                //
                //     "<td name='money' style='display: none'>" + datajson[key].retailPrice + "</td>\n" +
                //     "<input name='money' type='hidden' value='" + datajson[key].retailPrice + "'>\n" +
                //
                //     "<td name='goodsxinxiid' style='display: none'>" + datajson[key].goodsxinxiid + "</td>\n" +
                //     "<input name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'>\n" +
                //
                //     "<td name='stockorder' style='display: none'>" + datajson[key].danjuNumber + "</td>\n" +
                //     "<input name='stockorder' type='hidden' value='" + datajson[key].danjuNumber + "'>\n" +
                //
                //     "<td><em  onclick='delertTr(this)'></em></td>\n" +
                //     "</tr>");







                // // // alert(JSON.stringify(datajson))
                // alert(datajson[key].zhuceNumber);
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
                // alert(datajson[key].zhuceNumber);
                barHtml+= "<tr class='val'> " ;
                barHtml+= "<td name='goodsNum'>" + datajson[key].goodsNum + "</td> ";
                barHtml+= "<input name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'> ";
                barHtml+= "<td name='goodsName'>" + datajson[key].goodsName + "</td> ";
                barHtml+= "<input name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'> ";
                barHtml+= "<td name='factory'>" + datajson[key].factory + "</td> ";
                barHtml+= "<input name='factory' type='hidden' value='" + datajson[key].factory + "'> ";
                barHtml+= "<td name='goodsCount'>" + datajson[key].goodsCount + "</td> ";
                barHtml+= "<input id='goodsCount" + b + "' name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'> ";
                barHtml+= "<td >" + "<input id='useCount" + b + "' name='useCount' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)'/>" + "</td>" ;
                barHtml+= "<td name='goodsCode'>" + datajson[key].goodsCode + "</td> ";
                barHtml+= "<input name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'> ";
                barHtml+= "<td name='useday'>" + datajson[key].useday + "</td> ";
                barHtml+= "<input name='useday' type='hidden' value='" + datajson[key].useday + "'> ";
                barHtml+= "<td name='batch'>" + datajson[key].batch + "</td> ";
                barHtml+= "<input name='batch' type='hidden' value='" + datajson[key].batch + "'> ";
                barHtml+= "<td name='zhuceNumber'>" + datajson[key].zhuceNumber + "</td> ";
                barHtml+= "<input name='zhuceNumber' type='hidden' value='" + datajson[key].zhuceNumber + "'> ";
                barHtml+= "<td name='produceDay'>" + datajson[key].produceDay + "</td> ";
                barHtml+= "<input name='produceDay' type='hidden' value='" + datajson[key].produceDay + "'> ";


                barHtml+= "<td name='classtype' style='display: none'>" + datajson[key].classtype + "</td> ";
                barHtml+= "<input name='classtype' type='hidden' value='" + datajson[key].classtype + "'> ";
                barHtml+= "<td name='goodsid' style='display: none'>" + datajson[key].goodsid + "</td> ";
                barHtml+= "<input name='goods' type='hidden' value='" + datajson[key].goodsid + "'> ";

                barHtml+= "<td name='mfrsid' style='display: none'>" + datajson[key].mfrsid + "</td> ";
                barHtml+= "<input name='mfrsid' type='hidden' value='" + datajson[key].mfrsid + "'> ";
                barHtml+= "<td name='brandname' style='display: none'>" + datajson[key].brandname + "</td> ";
                barHtml+= "<input name='brandname' type='hidden' value='" + datajson[key].brandname + "'> ";
                barHtml+= "<td name='unit' style='display: none'>" + datajson[key].unit + "</td> ";
                barHtml+= "<input name='unit' type='hidden' value='" + datajson[key].unit + "'> ";

                barHtml+= "<td name='money' style='display: none'>" + datajson[key].retailPrice + "</td> ";
                barHtml+= "<input name='money' type='hidden' value='" + datajson[key].retailPrice + "'> ";

                barHtml+= "<td name='goodsxinxiid' style='display: none'>" + datajson[key].goodsxinxiid + "</td> ";
                barHtml+= "<input name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'> ";

                barHtml+= "<td name='stockorder' style='display: none'>" + datajson[key].danjuNumber + "</td> ";
                barHtml+= "<input name='stockorder' type='hidden' value='" + datajson[key].danjuNumber + "'> ";

                barHtml+= "<td><em  onclick='delertTr(this)'></em></td> ";
                barHtml+= "</tr>";
                // alert(barHtml);
                parent.$("#inventoryId").append(barHtml);
            });
        }
    });
}