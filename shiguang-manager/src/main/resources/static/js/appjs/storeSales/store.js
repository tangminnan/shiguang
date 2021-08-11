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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>框镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='镜架配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>太阳镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+ rows[i].goodsName +"\",)'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='太阳镜' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)
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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='耗材' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#unit").val(unitarray);
           // $("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}
function getLaohuajing() {
    var toIndex = layer.open({
        type : 2,
        title : '耗材',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/laohuajing/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>老花镜</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='老花镜' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>视光</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='视光' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>护理液</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='护理液' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            //$("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>配件</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
               // arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
            //$("#unit").val(unitarray);
           // $("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
    }
    if (rightYuanYongQJ =='' || rightYuanYongZJ == '' || leftYuanYongQJ == '' || leftYuanYongZJ == ''){
        return alert("请选择球镜度数");
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
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>隐形</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
                //arrayunit.push(rows[i].retailPrice);
               // unitarray.push(rows[i].unit);
                //goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>隐形配件</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].goodsName);
               // arrayunit.push(rows[i].retailPrice);
                //unitarray.push(rows[i].unit);
               // goodsNumArray.push(rows[i].goodsNum);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
           // $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
           // $("#unit").val(unitarray);
            //$("#goodsNum").val(goodsNumArray);
            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(price)

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
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='赠品' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
               // arraystore.push(rows[i].goodsName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<td>0.00</td>";
                html += "<td>1</td>";
                html += "<td>1</td>";
                html += "<td>0.00</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>自架</td>";
                html += "<td><em onclick='del(this,0.00,\""+rows[i].producName+"\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].producName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自架' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<td>0.00</td>";
                html += "<td>1</td>";
                html += "<td>1</td>";
                html += "<td>0.00</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>自片</td>";
                html += "<td><em onclick='del(this,0.00,\""+rows[i].producName+"\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].producName+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自片' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                //arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            //$("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
var ypuhuiPrice="";
function getTaocanXz(){
    if (check_val == ''){
        return alert("请选择商品")
    }
    var toIndex = layer.open({
        type : 2,
        title : '套餐',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/taocanxz/"+check_val,// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var zhekouPrice=0.00;
            var youhuiPrice=0.00;
            var yingshouPricce=0.00;
            var yingshouAPrice=0.00;
            var zhekouAPrice=0.00;
            for (var i=0;i<rows.length;i++){
                $("#taocanName").val(rows[i].packageName);
                // alert(rows[i].danyiyh)
                // alert(rows[i].fanxianPrice)
                // alert(rows[i].preferentialPrice)
                if ("" != rows[i].danyiyh){
                    if (rows[i].danyiyh == '返现'){
                        ypuhuiPrice = rows[i].fanxianPrice
                    }
                } else{
                    var preWay = rows[i].preferentialWay
                    var prePrice = rows[i].preferentialPrice;
                    preWay = preWay.split(",");
                    prePrice = prePrice.split(",");
                    for (var t=0;t<preWay.length;t++){
                        if ("返现" == preWay[t]){
                            $("#youhuiMoney"+t+"").append(prePrice[t]);
                            var yingshou = $("#yingshou"+t+"").val();
                            if (undefined != yingshou){
                                yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                document.getElementById("yingshouMoney"+t+"").innerHTML=""
                                $("#yingshouMoney"+t+"").append(yingshou);
                                youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                            }


                        } else if ("折扣" == preWay[t]){
                            $("#zhekou"+t+"").append(prePrice[t]);
                            var yingshou = $("#yingshou"+t+"").val();
                            if (undefined != yingshou){
                                yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                document.getElementById("yingshouMoney"+t+"").innerHTML=""
                                $("#yingshouMoney"+t+"").append(yingshou);
                                $("#zhekouMoney"+t+"").append(yingshou);
                                zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                            }

                        }
                        else if ("特价" == preWay[t]){
                            var yingshou = $("#yingshou"+t+"").val();
                            if (undefined != yingshou){
                                $("#yingshouMoney"+t+"").append(preWay[t]);
                            }
                        }
                    }
                    //ypuhuiPrice = rows[i].preferentialPrice
                }
            }

            document.getElementById("amountMoney").value="";
            $("#ula").empty();
            var lis="";
            var yuanjiaPrice=0.00;
            var yjPrice = $("#storeUnit").val();
            alert(yjPrice)
            yjPrice = yjPrice.split(",");
            for (var s=0;s<yjPrice.length;s++){
                yuanjiaPrice = parseFloat(yuanjiaPrice)+ parseFloat(yjPrice)
            }
            yingshouPricce = parseFloat(yingshouAPrice) + parseFloat(zhekouAPrice);
            lis =  "<li>原价金额："+yuanjiaPrice+"</li>";
            lis += "<li>折扣金额："+zhekouPrice+"</li>";
            lis += "<li>优惠金额："+youhuiPrice+"</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+yingshouPricce+"</li>";
            lis += "<li>实收金额："+yingshouPricce+"</li>";
            $("#ula").append(lis)
            $("#amountMoney").val(ypuhuiPrice);
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
    lis =  "<li>原价金额："+price+"</li>";
    lis += "<li>折扣金额：0.00</li>";
    lis += "<li>优惠金额：0.00</li>";
    lis += "<li>抹零金额：0.00</li>";
    lis += "<li>应收金额："+price+"</li>";
    lis += "<li>实收金额："+price+"</li>";
    $("#ula").append(lis)
    $("#amountMoney").val(price);
}

var check_val = [];
function getGoodsInfoSelect(obj){
    //var obj = document.getElementsByName("producaNum");
    check_val.push(obj);
    // for(k in obj){
    //     if(obj[k].checked)
    //         check_val.push(obj[k].value);
    // }

}

