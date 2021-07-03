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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>框镜</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>太阳镜</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)
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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}

function getYinxing(){
    var toIndex = layer.open({
        type : 2,
        title : '隐形',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/store/yinxing/",// iframe的url
        cancel: function(index, layero){
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            // var rows = sessionStorage.getItem("row");
            // alert(rows.length)
            for (var i=0;i<rows.length;i++){
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

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
                html += "<td>"+rows[i].producName+"</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>3</td>";
                html += "<td>1</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>1.0000</td>";
                html += "<td>0.000</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>0.00</td>";
                html += "<td>"+rows[i].retailPrice+"</td>";
                html += "<td>耗材</td>";
                html += "<td><em onclick=\"del(this,"+rows[i].retailPrice+")\"></em></td>";
                $("#goods").append(html);
                price = (parseFloat(price)+ parseFloat(rows[i].retailPrice)).toFixed(2);
            }

            $("#ula").empty();
            var lis="";
            lis =  "<li>原价金额："+price+"</li>";
            lis += "<li>折扣金额：0.00</li>";
            lis += "<li>优惠金额：0.00</li>";
            lis += "<li>抹零金额：0.00</li>";
            lis += "<li>应收金额："+price+"</li>";
            lis += "<li>实收金额："+price+"</li>";
            $("#ula").append(lis)
            $("#shishouMoney").val(price)

            //son_msg就是子页面中的msg数据
            //var son_msg = $(layero).find("iframe")[0].contentWindow.batchSelect();
        }
    });
    layer.full(toIndex)
}