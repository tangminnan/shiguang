// var a=0;
document.onkeydown = function(e){
    if((e||event).keyCode==13)
        findGoods();

};
var barHtml="";
function findGoods(){
    // a=a+1;

    // alert(a);

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
            // parent.layer.close(index);  // 关闭layer
            $(datajson).each(function (key) {  //循环读取后台传来的Json数据
                // // // alert(JSON.stringify(datajson))

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
                // barHtml+= "<tr class='val'> " ;
                // barHtml+= "<td name='goodsNum'>" + datajson[key].goodsNum + "</td> ";
                // barHtml+= "<input id='goodsNum" + a + "' name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'> ";
                // barHtml+= "<td name='goodsName'>" + datajson[key].goodsName + "</td> ";
                // barHtml+= "<input id='goodsName" + a + "' name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'> ";
                // barHtml+= "<td name='factory'>" + datajson[key].factory + "</td> ";
                // barHtml+= "<input id='factory" + a + "' name='factory' type='hidden' value='" + datajson[key].factory + "'> ";
                // barHtml+= "<td name='goodsCount'>" + datajson[key].goodsCount + "</td> ";
                // barHtml+= "<input id='goodsCount" + a + "' name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'> ";
                // barHtml+= "<td >" + "<input id='useCount" + a + "' name='useCount' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)'/>" + "</td>" ;
                // barHtml+= "<td name='goodsCode'>" + datajson[key].goodsCode + "</td> ";
                // barHtml+= "<input id='goodsCode" + a + "' name='goodsCode' type='hidden' value='" + datajson[key].goodsCode + "'> ";
                // barHtml+= "<td name='useday'>" + datajson[key].useday + "</td> ";
                // barHtml+= "<input id='useday" + a + "' name='useday' type='hidden' value='" + datajson[key].useday + "'> ";
                // barHtml+= "<td name='batch'>" + datajson[key].batch + "</td> ";
                // barHtml+= "<input id='batch" + a + "' name='batch' type='hidden' value='" + datajson[key].batch + "'> ";
                // barHtml+= "<td name='zhuceNumber'>" + datajson[key].zhuceNumber + "</td> ";
                // barHtml+= "<input id='zhuceNumber" + a + "' name='zhuceNumber' type='hidden' value='" + datajson[key].zhuceNumber + "'> ";
                // barHtml+= "<td name='produceDay'>" + datajson[key].produceDay + "</td> ";
                // barHtml+= "<input id='produceDay" + a + "' name='produceDay' type='hidden' value='" + datajson[key].produceDay + "'> ";
                //
                //
                // barHtml+= "<td name='classtype' style='display: none'>" + datajson[key].classtype + "</td> ";
                // barHtml+= "<input id='classtype" + a + "' name='classtype' type='hidden' value='" + datajson[key].classtype + "'> ";
                // barHtml+= "<td name='goodsid' style='display: none'>" + datajson[key].goodsid + "</td> ";
                // barHtml+= "<input id='goods" + a + "' name='goods' type='hidden' value='" + datajson[key].goodsid + "'> ";
                //
                // barHtml+= "<td name='mfrsid' style='display: none'>" + datajson[key].mfrsid + "</td> ";
                // barHtml+= "<input id='mfrsid" + a + "' name='mfrsid' type='hidden' value='" + datajson[key].mfrsid + "'> ";
                // barHtml+= "<td name='brandname' style='display: none'>" + datajson[key].brandname + "</td> ";
                // barHtml+= "<input id='brandname" + a + "' name='brandname' type='hidden' value='" + datajson[key].brandname + "'> ";
                // barHtml+= "<td name='unit' style='display: none'>" + datajson[key].unit + "</td> ";
                // barHtml+= "<input id='unit" + a + "' name='unit' type='hidden' value='" + datajson[key].unit + "'> ";
                //
                // barHtml+= "<td name='money' style='display: none'>" + datajson[key].retailPrice + "</td> ";
                // barHtml+= "<input id='money" + a + "' name='money' type='hidden' value='" + datajson[key].retailPrice + "'> ";
                //
                // barHtml+= "<td name='goodsxinxiid' style='display: none'>" + datajson[key].goodsxinxiid + "</td> ";
                // barHtml+= "<input id='goodsxinxiid" + a + "' name='goodsxinxiid' type='hidden' value='" + datajson[key].goodsxinxiid + "'> ";
                //
                // barHtml+= "<td name='stockorder' style='display: none'>" + datajson[key].danjuNumber + "</td> ";
                // barHtml+= "<input id='stockorder" + a + "' name='stockorder' type='hidden' value='" + datajson[key].danjuNumber + "'> ";
                //
                // barHtml+= "<td><em  onclick='delertTr(this)'></em></td> ";
                // barHtml+= "</tr>";
                // // alert(barHtml);
                // parent.$("#inventoryId").append(barHtml);




                barHtml+= "<tr class='val'> " ;
                barHtml+= "<td name='goodsNum'>" + datajson[key].goodsNum + "</td> ";
                barHtml+= "<input  name='goodsNum' type='hidden' value='" + datajson[key].goodsNum + "'> ";
                barHtml+= "<td name='goodsName'>" + datajson[key].goodsName + "</td> ";
                barHtml+= "<input   name='goodsName' type='hidden' value='" + datajson[key].goodsName + "'> ";
                barHtml+= "<td name='factory'>" + datajson[key].factory + "</td> ";
                barHtml+= "<input   name='factory' type='hidden' value='" + datajson[key].factory + "'> ";
                barHtml+= "<td name='goodsCount'>" + datajson[key].goodsCount + "</td> ";
                barHtml+= "<input   name='goodsCount' type='hidden' value='" + datajson[key].goodsCount + "'> ";
                barHtml+= "<td >" + "<input   name='useCount' oninput=\"value=value.replace(/[^\\d]/g,'')\" type='text' onchange='hejiadd(this.value)' />" + "</td>" ;
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
                // alert(barHtml);
                parent.$("#inventoryId").append(barHtml);
                // hejiadd();


            });
        }
    });


}
// function hejiadd(object) {
//     addcount=0;
//     var size=$("input[name='useCount']").length;
//     alert(size+"数量");
//     if (size==0){
//         $("input[name='useCount']").each(
//             function(){
//                 var goodsCount=$(this).val();
//                 alert(goodsCount);
//                 addcount +=Number(goodsCount);
//                 $("input[name='allcount']").val(addcount);
//                 $("input[name='newcount']").val(addcount);
//                 alert(addcount)
//             }
//         )
//     }else if (size==0){
//         $("input[name='allcount']").val(addcount);
//         $("input[name='newcount']").val(addcount);
//     }
//
// }


