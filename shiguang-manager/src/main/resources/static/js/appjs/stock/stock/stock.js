var prefix = "/stock/stock"
function add() {
    var toIndex = layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
    layer.full(toIndex);
}

function edit(id) {
    var toIndex = layer.open({
        type: 2,
        title: '修改',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
    layer.full(toIndex);
}
function detial(id) {
    var toIndex = layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/detial/' + id // iframe的url
    });
    layer.full(toIndex);
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function resetPwd(id) {
}

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}

// 选择制造商
function batchSelect() {
    var rows = $("#exampleTable").bootstrapTable("getSelections");
    return rows;
};

// 选择单品
function showCol() {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    $.each(check, function(i, row) {
        // ids[i] = row['id'];
        var obj = {};
        if(null == row['producNum']){
            var producNum  ="";
        }else {
            var producNum =  row['producNum'];
        }
        if(null == row['producName']){
            var producName  ="";
        }else {
            var producName =  row['producName'] ;
        }
        if(null == row['producFactory']){
            var producFactory  ="";
        }else {
            var producFactory =  row['producFactory'] ;
        }
        if(null == row['unitname']){
            var unitname  ="";
        }else {
            var unitname =  row['unitname'] ;
        }

        if(null == row['factory']){
            var factory  ="";
        }else {
            var factory =  row['factory'] ;
        }
        if(null == row['retailPrice']){
            var retailPrice  ="";
        }else {
            var retailPrice =  row['retailPrice'] ;
        }
        if(null == row['taxPrice']){
            var taxPrice  ="";
        }else {
            var taxPrice =  row['taxPrice'] ;
        }
        if(null == row['producFactorycolor']){
            var producFactorycolor  ="";
        }else {
            var producFactorycolor =  row['producFactorycolor'] ;
        }
        if(null == row['materialName']){
            var materialName  ="";
        }else {
            var materialName =  row['materialName'] ;
        }
        if(null == row['size']){
            var size  ="";
        }else {
            var size =  row['size'] ;
        }
        if(null == row['producCode']){
            var producCode  ="";
        }else {
            var producCode =  row['producCode'] ;
        }
        if(null == row['brandname']){
            var brandname  ="";
        }else {
            var brandname =  row['brandname'] ;
        }
        obj.producNum = producNum;
        obj.producName = producName;
        obj.producFactory = producFactory;
        obj.unitname = unitname;
        obj.factory = factory;
        obj.retailPrice = retailPrice;
        obj.taxPrice = taxPrice;
        obj.producFactorycolor = producFactorycolor;
        obj.materialName = materialName;
        obj.size = size;
        obj.producCode = producCode +"00000000";
        obj.brandname = brandname;
        // //———获取当前系统时间—————
        // var timeNow = new Date();
        // var year = timeNow.getFullYear();
        // var month = timeNow.getMonth() + 1 > 10 ? timeNow.getMonth() + 1 : '0' + (timeNow.getMonth() + 1);
        // var date = timeNow.getDate() > 10 ? timeNow.getDate() : "0" + timeNow.getDate();
        // obj.createTime = year + "-" + month + "-" + date;
        var createTime=new Date( +new Date() + 8 * 3600 * 1000 ).toJSON().substr(0,19).replace("T"," ");
        obj.createTime=createTime;

        if(null == row['tradePrice']){
            var tradePrice  ="";
        }else {
            var tradePrice =  row['tradePrice'] ;
        }
        obj.tradePrice = tradePrice;

        if(null == row['transferPrice']){
            var transferPrice  ="";
        }else {
            var transferPrice =  row['transferPrice'] ;
        }
        obj.transferPrice = transferPrice;

        //配件
        if(null == row['partsStyle']){
            var partsStyle  ="";
        }else {
            var partsStyle =  row['partsStyle'] ;
        }
        obj.partsStyle = partsStyle;
        //镜片
        if(null == row['sph']){
            var sph  ="";
        }else {
            var sph =  row['sph'] ;
        }
        obj.sph = sph;
        if(null == row['cyl']){
            var cyl  ="";
        }else {
            var cyl =  row['cyl'] ;
        }
        obj.cyl = cyl;
        if(null == row['lightbelow']){
            var lightbelow  ="";
        }else {
            var lightbelow =  row['lightbelow'] ;
        }
        obj.lightbelow = lightbelow;
        if(null == row['refractivityvalue']){
            var refractivityvalue  ="";
        }else {
            var refractivityvalue =  row['refractivityvalue'] ;
        }
        obj.refractivityvalue = refractivityvalue;
        if(null == row['lightName']){
            var lightName  ="";
        }else {
            var lightName =  row['lightName'] ;
        }
        obj.lightName = lightName;
        if(null == row['lensName']){
            var lensName  ="";
        }else {
            var lensName =  row['lensName'] ;
        }

        obj.lensName = lensName;
        if(null == row['gradualName']){
            var gradualName  ="";
        }else {
            var gradualName =  row['gradualName'] ;
        }

        obj.gradualName = gradualName;
        if(null == row['functionName']){
            var functionName  ="";
        }else {
            var functionName =  row['functionName'] ;
        }

        obj.functionName = functionName;

        //隐形
        if(null == row['curvature']){
            var curvature  ="";
        }else {
            var curvature =  row['curvature'] ;
        }

        obj.curvature = curvature;
        if(null == row['diameter']){
            var diameter  ="";
        }else {
            var diameter =  row['diameter'] ;
        }

        obj.diameter = diameter;
        if(null == row['usageName']){
            var usageName  ="";
        }else {
            var usageName =  row['usageName'] ;
        }

        obj.usageName = usageName;
        if(null == row['typeName']){
            var typeName  ="";
        }else {
            var typeName =  row['typeName'] ;
        }

        obj.typeName = typeName;




        //护理液
        if(null == row['mainCapacity']){
            var mainCapacity  ="";
        }else {
            var mainCapacity =  row['mainCapacity'] ;
        }

        obj.mainCapacity = mainCapacity;
        if(null == row['secondCapacity']){
            var secondCapacity  ="";
        }else {
            var secondCapacity =  row['secondCapacity'] ;
        }

        obj.secondCapacity = secondCapacity;
        //太阳镜
        //老花镜
        if(null == row['degrees']){
            var degrees  ="";
        }else {
            var degrees =  row['degrees'] ;
        }

        obj.degrees = degrees;
        if(null == row['classtype']){
            var classtype  ="";
        }else {
            var classtype =  row['classtype'] ;
        }

        obj.classtype = classtype;
        if(null == row['producFactory']){
            var producFactory  ="";
        }else {
            var producFactory =  row['producFactory'] ;
        }

        obj.producFactory = producFactory;
        if(null == row['medicinecode']){
            var medicinecode  ="";
        }else {
            var medicinecode =  row['medicinecode'] ;
        }

        obj.medicinecode = medicinecode;
        if(null == row['factory']){
            var factory  ="";
        }else {
            var factory =  row['factory'] ;
        }

        obj.factory = factory;
        if(null == row['classtype']){
            var classtype  ="";
        }else {
            var classtype =  row['classtype'] ;
        }

        obj.classtype = classtype;
        if(null == row['gdname']){
            var gdname  ="";
        }else {
            var gdname =  row['gdname'] ;
        }

        obj.gdname = gdname;
        if(null == row['goodsxinxiid']){
            var goodsxinxiid  ="";
        }else {
            var goodsxinxiid =  row['goodsxinxiid'] ;
        }

        obj.goodsxinxiid = goodsxinxiid;


        objArray.push(obj);
    });
    return objArray;
}


function save() {
    var goodsid = document.getElementById('goodsType').value;
    var mfrsid = document.getElementById('mfrsid').value;
    if (goodsid == "") {
        layer.alert("请选择采购类型！");
    } else if (goodsid != "" && mfrsid == "") {
        layer.alert("请选择所属制造商！");
    }
    else if (goodsid != "" && mfrsid != "") {//&& heji != ""
        $.ajax({
            cache: true,
            type: "POST",
            url: "/stock/stock/save",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            error: function (request) {
                parent.layer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("操作成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);

                } else {
                    parent.layer.alert(data.msg)
                }

            }
        });
    }
}

function editSave() {
    alert("先删除")
        $.ajax({
            cache: true,
            type: "POST",
            url: "/stock/stock/editSave",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            error: function (request) {
                parent.layer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("操作成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);

                } else {
                    parent.layer.alert(data.msg)
                }

            }
        });
}


