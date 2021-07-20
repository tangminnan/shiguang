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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='镜架配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='太阳镜' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='耗材' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='老花镜' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='视光' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='护理液' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='隐形配件' type='hidden' />"
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(rows[i].retailPrice);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='赠品' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].goodsName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自架' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
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
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeUnit'name='storeUnit' type='hidden' />"
                html += "<input id='storeCount'name='storeCount' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自片' type='hidden' />"
                $("#goods").append(html);
                //price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
                //array.push({"producName":rows[i].producName,"retailPrice":rows[i].retailPrice,"storeCount":1});
                arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
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