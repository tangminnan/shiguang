function getKjpeijian() {
    var toIndex = layer.open({
        type : 2,
        title : '镜架配件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/jingjiapj/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "框镜";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekoujjpj"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyjjpj"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyjjpj"+a+"'>0.00</td>";
                html += "<td id='molingMoneyjjpj"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyjjpj"+a+"'>0.00</td>";
                html += "<td>框镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空' />"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='yingshoujjpj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='镜架配件' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneyjjpj"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                arraycount.push(1)
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getTaiyangjing(){
    var toIndex = layer.open({
        type : 2,
        title : '太阳镜',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/taiyangjing/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "太阳镜";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekoutyj"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneytyj"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneytyj"+a+"'>0.00</td>";
                html += "<td id='molingMoneytyj"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneytyj"+a+"'>0.00</td>";
                html += "<td>太阳镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+ rows[i].goodsName +"\",)'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空' />"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshoutyj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='太阳镜' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneytyj"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getHaocai() {
    var toIndex = layer.open({
        type : 2,
        title : '耗材',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/haocai/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "耗材";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhc"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyhc"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyhc"+a+"'>0.00</td>";
                html += "<td id='molingMoneyhc"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyhc"+a+"'>0.00</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空' />"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshouhc"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='耗材' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneyhc"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#unit").val(unitarray);
           // $("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getLaohuajing() {
    var toIndex = layer.open({
        type : 2,
        title : '老花镜',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/laohuajing/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "老花镜";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekoulhj"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneylhj"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneylhj"+a+"'>0.00</td>";
                html += "<td id='molingMoneylhj"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneylhj"+a+"'>0.00</td>";
                html += "<td>老花镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshoulhj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='老花镜' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneylhj"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getShiguang(){
    var toIndex = layer.open({
        type : 2,
        title : '视光',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/shiguang/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "视光";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekousg"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneysg"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneysg"+a+"'>0.00</td>";
                html += "<td id='molingMoneysg"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneysg"+a+"'>0.00</td>";
                html += "<td>视光</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                //html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshousg"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='视光' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneysg"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getHuliye(){
    var toIndex = layer.open({
        type : 2,
        title : '护理液',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/huliye/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var dsc = '护理液';
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+dsc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhly"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyhly"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyhly"+a+"'>0.00</td>";
                html += "<td id='molingMoneyhly"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyhly"+a+"'>0.00</td>";
                html += "<td>护理液</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshouhly"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='护理液' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneyhly"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

// function getSummoneyhly() {
//     var sdf = $("#storeCount"+a+"").val()
//     alert(sdf);
//     var ss = $("#yingshouMoneyhly"+a+"").text();
//     alert(ss)
//     var dd = (parseFloat(ss)*parseFloat(sdf)).toFixed(2)
//     alert(dd);
//     price = parseFloat(price) - parseFloat(ss) + parseFloat(dd);
//     $("#yingshouMoneyhly"+a+"").text(dd);
//     $("#ula").empty();
//     var lis="";
//     lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
//     lis += "<li>折扣金额：0.00</li>";
//     lis += "<li>优惠金额：0.00</li>";
//     lis += "<li>抹零金额："+molingPrice+"</li>";
//     lis += "<li>应收金额："+price+"</li>";
//     lis += "<li>实收金额："+price+"</li>";
//     $("#ula").append(lis)
//     $("#amountMoney").val(price)
//     $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
// }

function getPeijian(){
    var toIndex = layer.open({
        type : 2,
        title : '配件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/peijian/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "配件";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhpj"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneypj"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneypj"+a+"'>0.00</td>";
                html += "<td id='molingMoneypj"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneypj"+a+"'>0.00</td>";
                html += "<td>配件</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshoupj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='配件' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneypj"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
               // arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //$("#unit").val(unitarray);
           // $("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getYinxing(){
    var  rightYuanYongQJ = '';
    var rightYuanYongZJ = '';
    var leftYuanYongQJ = '';
    var leftYuanYongZJ = '';
    if (cfType == 1){
        rightYuanYongQJ = $("#rightFuLiaoQJ").val();
        rightYuanYongZJ = $("#rightFuLiaoZJ").val();
        leftYuanYongQJ = $("#leftFuLiaoQJ").val();
        leftYuanYongZJ = $("#leftFuLiaoZJ").val();
    } else if (cfType == 2){
        rightYuanYongQJ = $("#rightYuanYongQJ").val();
        rightYuanYongZJ = $("#rightYuanYongZJ").val();
        leftYuanYongQJ = $("#leftYuanYongQJ").val();
        leftYuanYongZJ = $("#leftYuanYongZJ").val();
    } else if (cfType == 3){
        rightYuanYongQJ = $("#rightJianJinsgQJ").val();
        rightYuanYongZJ = $("#rightJianJinsgZJ").val();
        leftYuanYongQJ = $("#leftJianJinsgQJ").val();
        leftYuanYongZJ = $("#leftJianJinsgZJ").val();
    } else if (cfType == 4){
        rightYuanYongQJ = $("#rightZhongYongQJ").val();
        rightYuanYongZJ = $("#rightZhongYongZJ").val();
        leftYuanYongQJ = $("#leftZhongYongQJ").val();
        leftYuanYongZJ = $("#leftZhongYongZJ").val();
    } else if (cfType == 5){
        rightYuanYongQJ = $("#rightYinxingQJ").val();
        rightYuanYongZJ = $("#rightYinxingZJ").val();
        leftYuanYongQJ = $("#leftYinxingQJ").val();
        leftYuanYongZJ = $("#leftYinxingZJ").val();
    } else if (cfType == 7){
        rightYuanYongQJ = $("#rightShiJuexlQJ").val();
        rightYuanYongZJ = $("#rightShiJuexlZJ").val();
        leftYuanYongQJ = $("#leftShiJuexlQJ").val();
        leftYuanYongZJ = $("#leftShiJuexlZJ").val();
    } else if (cfType == 8){
        rightYuanYongQJ = $("#rightVstQJ").val();
        rightYuanYongZJ = $("#rightVstZJ").val();
        leftYuanYongQJ = $("#leftVstQJ").val();
        leftYuanYongZJ = $("#leftVstZJ").val();
    }
    if (cfType == '' && shoutian == 2){
        if (shoutianCFType == 1){
            rightYuanYongQJ = $("#rightFuLiaoQJ").val();
            rightYuanYongZJ = $("#rightFuLiaoZJ").val();
            leftYuanYongQJ = $("#leftFuLiaoQJ").val();
            leftYuanYongZJ = $("#leftFuLiaoZJ").val();
        } else if (shoutianCFType == 2){
            rightYuanYongQJ = $("#rightYuanYongQJ").val();
            rightYuanYongZJ = $("#rightYuanYongZJ").val();
            leftYuanYongQJ = $("#leftYuanYongQJ").val();
            leftYuanYongZJ = $("#leftYuanYongZJ").val();
        } else if (shoutianCFType == 3){
            rightYuanYongQJ = $("#rightJianJinsgQJ").val();
            rightYuanYongZJ = $("#rightJianJinsgZJ").val();
            leftYuanYongQJ = $("#leftJianJinsgQJ").val();
            leftYuanYongZJ = $("#leftJianJinsgZJ").val();
        } else if (shoutianCFType == 4){
            rightYuanYongQJ = $("#rightZhongYongQJ").val();
            rightYuanYongZJ = $("#rightZhongYongZJ").val();
            leftYuanYongQJ = $("#leftZhongYongQJ").val();
            leftYuanYongZJ = $("#leftZhongYongZJ").val();
        } else if (shoutianCFType == 5){
            rightYuanYongQJ = $("#rightYinxingQJ").val();
            rightYuanYongZJ = $("#rightYinxingZJ").val();
            leftYuanYongQJ = $("#leftYinxingQJ").val();
            leftYuanYongZJ = $("#leftYinxingZJ").val();
        } else if (shoutianCFType == 7){
            rightYuanYongQJ = $("#rightShiJuexlQJ").val();
            rightYuanYongZJ = $("#rightShiJuexlZJ").val();
            leftYuanYongQJ = $("#leftShiJuexlQJ").val();
            leftYuanYongZJ = $("#leftShiJuexlZJ").val();
        } else if (shoutianCFType == 8){
            rightYuanYongQJ = $("#rightVstQJ").val();
            rightYuanYongZJ = $("#rightVstZJ").val();
            leftYuanYongQJ = $("#leftVstQJ").val();
            leftYuanYongZJ = $("#leftVstZJ").val();
        }
    }
    if (rightYuanYongQJ =='' || rightYuanYongZJ == '' || leftYuanYongQJ == '' || leftYuanYongZJ == ''){
        return layer.alert("请选择球镜度数");
    }
    var str = 0;
    var toIndex = layer.open({
        type : 2,
        title : '隐形',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/yinxing/"+rightYuanYongZJ+"/"+rightYuanYongQJ+"/"+leftYuanYongQJ+"/"+leftYuanYongZJ+"/"+str,// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.sure();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            var dataArray = new Array();
            var rowsRight = window.localStorage.getItem("rowsRight");
            var rowsLeft = window.localStorage.getItem("rowsLeft");
            if (null != JSON.parse(rowsRight) || null != JSON.parse(rowsLeft)){
                dataArray.push(JSON.parse(rowsRight));
            }
            if (null != JSON.parse(rowsLeft)){
                dataArray.push(JSON.parse(rowsLeft));
            }
            localStorage.clear();
            rows = dataArray;
            for (var i=0;i<rows.length;i++){
                a=a+1;
                alert(rows[i][0].goodsNum)
                var goodsNumStr = rows[i][0].goodsNum;
                var retailPrice = rows[i][0].retailPrice;
                var desc = "隐形";
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i][0].goodsName+"</td>";
                html += "<td>"+rows[i][0].leftRight+"</td>";
                html += "<td>"+rows[i][0].retailPrice+"</td>";
                html += "<td>"+rows[i][0].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i][0].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhyx"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyyx"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyyx"+a+"'>0.00</td>";
                html += "<td id='molingMoneyyx"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyyx"+a+"'>0.00</td>";
                html += "<td>隐形</td>";
                html += "<td><em onclick='del(this,\"" + rows[i][0].retailPrice + "\",\""+rows[i][0].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i][0].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i][0].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i][0].goodsNum+"'/>"
                html += "<input id='jpGoodsName'name='jpGoodsName' type='hidden' value='"+rows[i][0].goodsName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i][0].retailPrice+"'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='"+rows[i][0].leftRight+"'/>"
                //html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='"+rows[i][0].classtype+"'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i][0].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i][0].batch+"' type='hidden' />"
                html += "<input id='yingshouyx"+a+"' value='"+rows[i][0].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneyyx"+a+"").text(rows[i][0].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i][0].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                //classArray.push(rows[i].classtype);
                //arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val((parseFloat(price)+parseFloat(molingPrice)).toFixed(2))
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getYinxingpj(){
    var toIndex = layer.open({
        type : 2,
        title : '隐形配件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/yinxingpj/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            // if (rows.length > 0){
            //     a=a+1;
            // }
            for (var i=0;i<rows.length;i++){
                a=a+1;
                var goodsNumStr = rows[i].goodsNum;
                var retailPrice = rows[i].retailPrice;
                var desc = "隐形配件"
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" onclick='getGoodsInfoSelect(\""+goodsNumStr+"\",\""+retailPrice+"\")'/></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input id='storeCount"+a+"' name='storeCount' value='1' style='width:15px;' onchange='getSummoney(this,\""+desc+"\")'/></td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhyxpj"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyyxpj"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyyxpj"+a+"'>0.00</td>";
                html += "<td id='molingMoneyyxpj"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyyxpj"+a+"'>0.00</td>";
                html += "<td>隐形配件</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].goodsCode+"'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='yingshouyxpj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形配件' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                $("#yingshouMoneyyxpj"+a+"").text(rows[i].retailPrice)
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
               // arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
               // goodsNumArray.push(rows[i].goodsNum);
                //arraycount.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额："+molingPrice+"</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
            $("#primeMoney").val(price)
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getZengpin(){
    var toIndex = layer.open({
        type : 2,
        title : '赠品',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/zengpin/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td></td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td><input name='storeCount' value='1' style='width:15px;'/></td>";
                html += "<td>0.00</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>赠品</td>";
                html += "<td><em onclick='del(this,0.00,\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='0.00'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='batch' name='batch' value='"+rows[i].batch+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='赠品' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
               // arraystore.push(rows[i].goodsName);
                arrayunit.push(0.00);
                //arraycount.push(1)
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getZijia(){
    var toIndex = layer.open({
        type : 2,
        title : '自架',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/zijia/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td></td>";
                html += "<td>0.00</td>";
                html += "<td>1</td>";
                html += "<td><input name='storeCount' value='1' style='width:15px;'/></td>";
                html += "<td>0.00</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>自架</td>";
                html += "<td><em onclick='del(this,0.00,\""+rows[i].producName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='副'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].producName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='0.00'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].producNum+"'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].producCode+"'/>"
                html += "<input id='isJj' name='isJj' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自架' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                //arraycount.push(1)
                //classArray.push(1);
                $("#isJj").val("有")
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getZipian(){
    var toIndex = layer.open({
        type : 2,
        title : '自片',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/zipian/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td></td>";
                html += "<td>0.00</td>";
                html += "<td>1</td>";
                html += "<td><input name='storeCount' value='1' style='width:15px;'/></td>";
                html += "<td>0.00</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>自片</td>";
                html += "<td><em onclick='del(this,0.00,\""+rows[i].producName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='片'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].producName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='0.00'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].producNum+"'/>"
                html += "<input id='goodsCode' name='goodsCode' type='hidden' value='"+rows[i].producCode+"'/>"
                // html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='isJp'name='isJp' type='hidden' />"
                html += "<input id='classtype' name='classtype' type='hidden' value='1'/>"
                html += "<input id='leftRight' name='leftRight' type='hidden' value='空'/>"
                html += "<input id='storeDescribe'name='storeDescribe' value='自片' type='hidden' />"
                html += "</tr>";
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                //arraycount.push(1)
                arrayjp.push(1);
                //classArray.push(1);
            }
            //$("#storeName").val(arraystore);
            $("#isJp").val(arrayjp.length);
            //$("#storeUnit").val(arrayunit);
            //$("#storeCount").val(arraycount);
            //$("#classtype").val(classArray);
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getTaocanDetail(){
    var toIndex = layer.open({
        type : 2,
        title : '套餐查看',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/taocan/"// iframe的url
        // cancel: function(index, layero){
        //     var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
        // }
    });
    layer.full(toIndex)
}
function getYouji(){
    var cardNumber = $("#memberNumber").val();
    var toIndex = layer.open({
        type : 2,
        title : '邮寄信息',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/youji/"+cardNumber,// iframe的url
    });
    layer.full(toIndex)
}
var zhekouPrice=0.00;
var youhuiPrice=0.00;
var dazhePrice=0.00;
var zhekouYHPrice = 0.00;
var shishouqj=0.00;
function getTaocanXz(){
    var checkDate="";
    if (check_val == '' && check_val != undefined){
        return layer.alert("请选择商品")
    } else {
        $("#checkValue").val(check_val);
        checkDate = $("#checkValue").val();
    }
    var amount = $("#amountMoney").val();
    var amountYj = $("#amountMoney").val();
    var shihsouPrice = 0.00;
    //var check_val = "232";
    var toIndex = layer.open({
        type : 2,
        title : '套餐',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/taocanxz/"+checkDate+"/"+retailCountPrice +"/"+check_val,// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var yingshouPricce=0.00;
            var yingshouAPrice=0.00;
            var zhekouAPrice=0.00;
            if (rows.length > 0){
                for (var i=0;i<rows.length;i++){
                    $("#taocanName").val(rows[i].packageName);
                    // alert(rows[i].danyiyh)
                    // alert(rows[i].fanxianPrice)
                    // alert(rows[i].preferentialPrice)
                    if ("" != rows[i].danyiyh){
                        if (rows[i].danyiyh == '返现'){
                            youhuiPrice = rows[i].fanxianPrice
                            //var ys = $("#amountMoney").val();
                            //alert(ys);
                            //amount = (parseFloat(amount) - parseFloat(youhuiPrice)).toFixed(2);
                            shihsouPrice = (parseFloat(amount) - parseFloat(youhuiPrice)).toFixed(2);
                            //alert(yingshouPricce);
                        } else if (rows[i].danyiyh == '打折'){
                            dazhePrice = (parseFloat(amount) - (parseFloat(amount) * parseFloat(rows[i].dazhePrice))).toFixed(2);
                            zhekouYHPrice = (parseFloat(amount) * parseFloat(rows[i].dazhePrice)).toFixed(2);
                            shihsouPrice = zhekouYHPrice;
                        } else if (rows[i].danyiyh == '特价'){
                            shihsouPrice = rows[i].tejiaPrice;
                        }
                    } else{
                        var goosNum = rows[i].goodsCode;
                        var goosType = rows[i].goodsType;
                        var preWay = rows[i].preferentialWay
                        var prePrice = rows[i].preferentialPrice;
                        var rebat = rows[i].preferentialRebate;
                        var tjPrice = rows[i].specialPrice;
                        preWay = preWay.split(",");
                        prePrice = prePrice.split(",");
                        goosNum = goosNum.split(",");
                        goosType = goosType.split(",");
                        rebat = rebat.split(",");
                        for (var t=0;t<goosType.length;t++){

                            if ("镜架" == goosType[t]){
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyjj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        document.getElementById("yingshouMoneyjj"+t+"").innerHTML=""
                                        //$("#yingshouMoneyjj"+t+"").text();
                                        $("#yingshouMoneyjj"+t+"").append(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                    // $("#youhuiMoneyjj").text(prePrice[t]);
                                    // var yingshou = $("#yingshoujj").val();
                                    // if (undefined != yingshou){
                                    //     yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                    //     document.getElementById("yingshouMoneyjj").innerHTML=""
                                    //     $("#yingshouMoneyjj").append(yingshou);
                                    //     youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                    //     yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    // }

                                } else if ("打折" == preWay[t]){
                                    $("#zhekoujj"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyjj"+t+"").innerHTML=""
                                        $("#yingshouMoneyjj"+t+"").text();
                                        $("#yingshouMoneyjj"+t+"").text(yingshou);
                                        $("#zhekouMoneyjj"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(dazhePrice)).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyjj"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("订做片" == goosType[t]){
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyjp"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        //$("#yingshouMoneyjp"+t+"").text();
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        // yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                    // $("#youhuiMoneyjp").text(prePrice[t]);
                                    // var yingshou = $("#yingshoujp").val();
                                    // alert(yingshou)
                                    // if (undefined != yingshou){
                                    //     yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                    //     document.getElementById("yingshouMoneyjp").innerHTML=""
                                    //     alert(yingshou)
                                    //     $("#yingshouMoneyjp").text(yingshou);
                                    //     youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                    //     alert(youhuiPrice)
                                    //     yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    //     alert(yingshouAPrice)
                                    // }

                                }
                                else if ("打折" == preWay[t]){
                                    $("#zhekoujp"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        $("#yingshouMoneyjp"+t+"").text();
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        $("#zhekouMoneyjp"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(dazhePrice)).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyjp"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("成品片" == goosType[t]){
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyjp"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        //$("#yingshouMoneyjp"+t+"").text();
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        // yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                    // $("#youhuiMoneyjp").text(prePrice[t]);
                                    // var yingshou = $("#yingshoujp").val();
                                    // alert(yingshou)
                                    // if (undefined != yingshou){
                                    //     yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                    //     document.getElementById("yingshouMoneyjp").innerHTML=""
                                    //     alert(yingshou)
                                    //     $("#yingshouMoneyjp").text(yingshou);
                                    //     youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                    //     alert(youhuiPrice)
                                    //     yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    //     alert(yingshouAPrice)
                                    // }

                                }
                                else if ("打折" == preWay[t]){
                                    $("#zhekoujp"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        $("#yingshouMoneyjp"+t+"").text();
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        $("#zhekouMoneyjp"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(dazhePrice)).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyjp"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            }

                            else if ("配件" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneypj"+t+"").text(prePrice[t]);
                                    $("#youhuiMoneyjjpj"+t+"").text(prePrice[t]);
                                    $("#youhuiMoneyyxpj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    yingshou = $("#yingshoujjpj"+t+"").val();
                                    yingshou = $("#yingshouyxpj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        $("#yingshouMoneypj"+t+"").text();
                                        $("#yingshouMoneyjjpj"+t+"").text();
                                        $("#yingshouMoneyyxpj"+t+"").text();
                                        //document.getElementById("yingshouMoneypj"+t+"").innerHTML=""
                                        //document.getElementById("yingshouMoneyjjpj"+t+"").innerHTML=""
                                        $("#yingshouMoneypj"+t+"").text(yingshou);
                                        $("#yingshouMoneyjjpj"+t+"").text(yingshou);
                                        $("#yingshouMoneyyxpj"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekoupj"+t+"").text(rebat[t]);
                                    $("#zhekoujjpj"+t+"").text(rebat[t]);
                                    $("#zhekouyxpj"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    yingshou = $("#yingshoujjpj"+t+"").val();
                                    yingshou = $("#yingshouyxpj"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        $("#yingshouMoneypj"+t+"").text();
                                        $("#yingshouMoneyjjpj"+t+"").text();
                                        $("#yingshouMoneyyxpj"+t+"").text();
                                        //document.getElementById("yingshouMoneypj"+t+"").innerHTML=""
                                        //document.getElementById("yingshouMoneyjjpj"+t+"").innerHTML=""
                                        $("#yingshouMoneypj"+t+"").text(yingshou);
                                        $("#yingshouMoneyjjpj"+t+"").text(yingshou);
                                        $("#yingshouMoneyyxpj"+t+"").text(yingshou);
                                        $("#zhekouMoneypj"+t+"").text(zhekouPrice);
                                        $("#zhekouMoneyjjpj"+t+"").text(zhekouPrice);
                                        $("#zhekouMoneyyxpj"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    yingshou = $("#yingshoujjpj"+t+"").val();
                                    yingshou = $("#yingshouyxpj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneypj"+t+"").text(tjPrice[t]);
                                        $("#yingshouMoneyjjpj"+t+"").text(tjPrice[t]);
                                        $("#yingshouMoneyyxpj"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("太阳镜" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneytyj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneytyj"+t+"").innerHTML=""
                                        $("#yingshouMoneytyj"+t+"").text();
                                        $("#yingshouMoneytyj"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekoutyj"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneytyj"+t+"").innerHTML=""
                                        $("#yingshouMoneytyj"+t+"").text();
                                        $("#yingshouMoneytyj"+t+"").text(yingshou);
                                        $("#zhekouMoneytyj"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneytyj"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("老花镜" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneylhj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneylhj"+t+"").innerHTML=""
                                        $("#yingshouMoneylhj"+t+"").text();
                                        $("#yingshouMoneylhj"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekoulhj"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneylhj"+t+"").innerHTML=""
                                        $("#yingshouMoneylhj"+t+"").text();
                                        $("#yingshouMoneylhj"+t+"").text(yingshou);
                                        $("#zhekouMoneylhj"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneylhj"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("耗材" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyhc"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyhc"+t+"").innerHTML=""
                                        $("#yingshouMoneyhc"+t+"").text();
                                        $("#yingshouMoneyhc"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekouhc"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyhc"+t+"").innerHTML=""
                                        $("#yingshouMoneyhc"+t+"").text();
                                        $("#yingshouMoneyhc"+t+"").text(yingshou);
                                        $("#zhekouMoneyhc"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyhc"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("视光" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneysg"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneysg"+t+"").innerHTML=""
                                        $("#yingshouMoneysg"+t+"").text();
                                        $("#yingshouMoneysg"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekousg"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneysg"+t+"").innerHTML=""
                                        $("#yingshouMoneysg"+t+"").text();
                                        $("#yingshouMoneysg"+t+"").text(yingshou);
                                        $("#zhekouMoneysg"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) + parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneysg"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            } else if ("隐形护理液" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyhly"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = (parseFloat(yingshou)-parseFloat(prePrice[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyhly"+t+"").innerHTML=""
                                        $("#yingshouMoneyhly"+t+"").text();
                                        $("#yingshouMoneyhly"+t+"").text(yingshou);
                                        youhuiPrice = (parseFloat(youhuiPrice) + parseFloat(prePrice[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(prePrice[t]));
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("打折" == preWay[t]){
                                    $("#zhekouhly"+t+"").text(rebat[t]);
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        zhekouPrice = (parseFloat(yingshou) * (parseFloat(1)-parseFloat(rebat[t]))).toFixed(2);
                                        yingshou = (parseFloat(yingshou) * parseFloat(rebat[t])).toFixed(2);
                                        //document.getElementById("yingshouMoneyhly"+t+"").innerHTML=""
                                        $("#yingshouMoneyhly"+t+"").text();
                                        $("#yingshouMoneyhly"+t+"").text(yingshou);
                                        $("#zhekouMoneyhly"+t+"").text(zhekouPrice);
                                        dazhePrice = parseFloat(dazhePrice) +  parseFloat(zhekouPrice)
                                        //zhekouPrice = (parseFloat(zhekouPrice) + parseFloat(rebat[t])).toFixed(2);
                                        amount = (parseFloat(amount) - parseFloat(rebat[t])).toFixed(2);
                                        shihsouPrice = (parseFloat(shihsouPrice) + parseFloat(yingshou)).toFixed(2);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyhly"+t+"").text(tjPrice[t]);
                                        shihsouPrice = tjPrice[t];
                                    }
                                }
                            }

                        }
                        //ypuhuiPrice = rows[i].preferentialPrice
                    }
                }

                document.getElementById("amountMoney").value="";
                $("#ula").empty();
                var lis="";
                // var yuanjiaPrice=0.00;
                // var yjPrice = $("#storeUnit").val();
                // alert(yjPrice)
                // yjPrice = yjPrice.split(",");
                // for (var s=0;s<yjPrice.length;s++){
                //     yuanjiaPrice = parseFloat(yuanjiaPrice)+ parseFloat(yjPrice)
                // }
                // if (yingshouAPrice != 0.00 || zhekouAPrice != 0.00){
                //     yingshouPricce = parseFloat(yingshouAPrice) + parseFloat(zhekouAPrice);
                // }
                shishouqj = shihsouPrice;
                lis =  "<li>原价金额："+(parseFloat(amountYj)+parseFloat(molingPrice)).toFixed(2)+"</li>";
                lis += "<li>折扣金额："+dazhePrice+"</li>";
                lis += "<li>优惠金额："+youhuiPrice+"</li>";
                lis += "<li>抹零金额："+molingPrice+"</li>";
                lis += "<li>应收金额："+shihsouPrice+"</li>";
                lis += "<li>实收金额："+shihsouPrice+"</li>";
                $("#ula").append(lis)
                $("#amountMoney").val(shihsouPrice);
                $("#primeMoney").val(amountYj)
            }

            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getHYTc(){
    document.getElementById("taocanName").value = "";
    $("#ula").empty();
    var lis="";
    lis =  "<li>原价金额："+(parseFloat(price)+parseFloat(molingPrice)).toFixed(2)+"</li>";
    lis += "<li>折扣金额：0.00</li>";
    lis += "<li>优惠金额：0.00</li>";
    lis += "<li>抹零金额："+molingPrice+"</li>";
    lis += "<li>应收金额："+price+"</li>";
    lis += "<li>实收金额："+price+"</li>";
    $("#ula").append(lis)
    $("#amountMoney").val(price);
    $("#primeMoney").val(price)
}

var check_val = [];
var retailCountPrice=0.00;
function getGoodsInfoSelect(obj,countPrice){
    // if (check_val.indexOf(obj) > -1){
    //     check_val.remove(obj);
    // } else {
    //
    // }
    check_val.push(obj);
    retailCountPrice = (parseFloat(retailCountPrice) + parseFloat(countPrice)).toFixed(2);
    // for(k in obj){
    //     if(obj[k].checked)
    //         check_val.push(obj[k].value);
    // }

}

