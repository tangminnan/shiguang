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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshoujjpj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='镜架配件' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneyjjpj"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshoutyj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='太阳镜' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneytyj"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshouhc"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='耗材' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneyhc"+a+"").text(rows[i].retailPrice)
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
        title : '老花镜',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/laohuajing/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshoulhj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='老花镜' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneylhj"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshousg"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='视光' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneysg"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshouhly"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='护理液' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneyhly"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshoupj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='配件' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneypj"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td id='zhekoulv"+a+"'>0.00</td>";
                html += "<td id='zhekouhyx"+a+"'>0.00</td>";
                html += "<td id='zhekouMoneyyx"+a+"'>0.00</td>";
                html += "<td id='youhuiMoneyyx"+a+"'>0.00</td>";
                html += "<td id='molingMoneyyx"+a+"'>0.00</td>";
                html += "<td id='yingshouMoneyyx"+a+"'>0.00</td>";
                html += "<td>隐形</td>";
                html += "<td><em onclick='del(this,\"" + rows[i].retailPrice + "\",\""+rows[i].goodsName+"\")'></em></td>";
                html += "<input id='unit' name='unit' type='hidden' value='"+rows[i].unit+"'/>"
                html += "<input id='storeName'name='storeName' type='hidden' value='"+rows[i].goodsName+"'/>"
                html += "<input id='goodsNum'name='goodsNum' type='hidden' value='"+rows[i].goodsNum+"'/>"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' value='"+rows[i].retailPrice+"'/>"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshouyx"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneyyx"+a+"").text(rows[i].retailPrice)
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
            if (rows.length > 0){
                a=a+1;
            }
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].goodsName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>"+rows[i].goodsCount+"</td>";
                html += "<td>1</td>";
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
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='yingshouyxpj"+a+"' value='"+rows[i].retailPrice+"' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形配件' type='hidden' />"
                $("#goods").append(html);
                $("#yingshouMoneyyxpj"+a+"").text(rows[i].retailPrice)
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
var zhekouPrice=0.00;
var youhuiPrice=0.00;
function getTaocanXz(){
    var checkDate="";
    if (check_val == '' && check_val != undefined){
        return alert("请选择商品")
    } else {
        $("#checkValue").val(check_val);
        checkDate = $("#checkValue").val();
    }
    var amount = $("#amountMoney").val();
    var amountYj = $("#amountMoney").val();
    //var check_val = "232";
    var toIndex = layer.open({
        type : 2,
        title : '套餐',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/taocanxz/"+checkDate+"/"+check_val,// iframe的url
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
                            amount = parseFloat(amount) - parseFloat(youhuiPrice);
                            //alert(yingshouPricce);
                        }
                    } else{
                        var goosNum = rows[i].goodsCode;
                        var goosType = rows[i].goodsType;
                        var preWay = rows[i].preferentialWay
                        var prePrice = rows[i].preferentialPrice;
                        preWay = preWay.split(",");
                        prePrice = prePrice.split(",");
                        goosNum = goosNum.split(",");
                        goosType = goosType.split(",");
                        for (var t=0;t<goosType.length;t++){

                            if ("镜架" == goosType[t]){
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyjj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyjj"+t+"").innerHTML=""
                                        $("#yingshouMoneyjj"+t+"").append(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
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

                                } else if ("折扣" == preWay[t]){
                                    $("#zhekoujj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyjj"+t+"").innerHTML=""
                                        $("#yingshouMoneyjj"+t+"").text(yingshou);
                                        $("#zhekouMoneyjj"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoujj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyjj"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("订做片" == goosType[t]){
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyjp"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
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

                                } else if ("折扣" == preWay[t]){
                                    $("#zhekoujp"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyjp"+t+"").innerHTML=""
                                        $("#yingshouMoneyjp"+t+"").text(yingshou);
                                        $("#zhekouMoneyjp"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoujp"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyjp"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("配件" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneypj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneypj"+t+"").innerHTML=""
                                        $("#yingshouMoneypj"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekoupj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneypj"+t+"").innerHTML=""
                                        $("#yingshouMoneypj"+t+"").text(yingshou);
                                        $("#zhekouMoneypj"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoupj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneypj"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("太阳镜" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneytyj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneytyj"+t+"").innerHTML=""
                                        $("#yingshouMoneytyj"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekoutyj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneytyj"+t+"").innerHTML=""
                                        $("#yingshouMoneytyj"+t+"").text(yingshou);
                                        $("#zhekouMoneytyj"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoutyj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneytyj"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("老花镜" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneylhj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneylhj"+t+"").innerHTML=""
                                        $("#yingshouMoneylhj"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekoulhj"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneylhj"+t+"").innerHTML=""
                                        $("#yingshouMoneylhj"+t+"").text(yingshou);
                                        $("#zhekouMoneylhj"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshoulhj"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneylhj"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("耗材" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyhc"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyhc"+t+"").innerHTML=""
                                        $("#yingshouMoneyhc"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekouhc"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyhc"+t+"").innerHTML=""
                                        $("#yingshouMoneyhc"+t+"").text(yingshou);
                                        $("#zhekouMoneyhc"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshouhc"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyhc"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("视光" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneysg"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneysg"+t+"").innerHTML=""
                                        $("#yingshouMoneysg"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekousg"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneysg"+t+"").innerHTML=""
                                        $("#yingshouMoneysg"+t+"").text(yingshou);
                                        $("#zhekouMoneysg"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshousg"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneysg"+t+"").text(preWay[t]);
                                    }
                                }
                            } else if ("隐形护理液" == goosType[t]) {
                                if ("返现" == preWay[t]){
                                    $("#youhuiMoneyhly"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou)-parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyhly"+t+"").innerHTML=""
                                        $("#yingshouMoneyhly"+t+"").text(yingshou);
                                        youhuiPrice = parseFloat(youhuiPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //yingshouAPrice = parseFloat(yingshouAPrice) + parseFloat(yingshou);
                                    }
                                } else if ("折扣" == preWay[t]){
                                    $("#zhekouhly"+t+"").text(prePrice[t]);
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        yingshou = parseFloat(yingshou) * parseFloat(prePrice[t]);
                                        document.getElementById("yingshouMoneyhly"+t+"").innerHTML=""
                                        $("#yingshouMoneyhly"+t+"").text(yingshou);
                                        $("#zhekouMoneyhly"+t+"").text(yingshou);
                                        zhekouPrice = parseFloat(zhekouPrice) + parseFloat(prePrice[t]);
                                        amount = parseFloat(amount) - parseFloat(prePrice[t]);
                                        //zhekouAPrice = parseFloat(zhekouAPrice) + parseFloat(yingshou);
                                    }

                                }
                                else if ("特价" == preWay[t]){
                                    var yingshou = $("#yingshouhly"+t+"").val();
                                    if (undefined != yingshou){
                                        $("#yingshouMoneyhly"+t+"").text(preWay[t]);
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
                lis =  "<li>原价金额："+amountYj+"</li>";
                lis += "<li>折扣金额："+zhekouPrice+"</li>";
                lis += "<li>优惠金额："+youhuiPrice+"</li>";
                lis += "<li>抹零金额：0.00</li>";
                lis += "<li>应收金额："+amount+"</li>";
                lis += "<li>实收金额："+amount+"</li>";
                $("#ula").append(lis)
                $("#amountMoney").val(amount);
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

