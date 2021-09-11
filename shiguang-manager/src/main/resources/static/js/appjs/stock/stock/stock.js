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
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
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
    var check = $("input[name='one']:checked");//选中的复选框
    var objArray = [];
    check.each(function () {
        var obj = {};
        var rowstr = $(this).parent("td").parent("tr");
        var producNum = rowstr.find("[name='producNum']").html();//注意html()和val()
        var producName = rowstr.find("[name='producName']").html();
        var producFactory = rowstr.find("[name='producFactory']").html();
        var unitname = rowstr.find("[name='unitname']").html();
        var factory = rowstr.find("[name='factory']").html();
        var retailPrice = rowstr.find("[name='retailPrice']").html();
        var taxPrice = rowstr.find("[name='taxPrice']").html();
        var producFactorycolor = rowstr.find("[name='producFactorycolor']").html();
        var materialName = rowstr.find("[name='materialName']").html();
        var size = rowstr.find("[name='size']").html();
        var producCode = rowstr.find("[name='producCode']").html();
        var brandname = rowstr.find("[name='brandname']").html();
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
        obj.producCode = producCode;
        obj.brandname = brandname;
        //———获取当前系统时间—————
        var timeNow = new Date();
        var year = timeNow.getFullYear();
        var month = timeNow.getMonth() + 1 > 10 ? timeNow.getMonth() + 1 : '0' + (timeNow.getMonth() + 1);
        var date = timeNow.getDate() > 10 ? timeNow.getDate() : "0" + timeNow.getDate();
        obj.createTime = year + "-" + month + "-" + date;
        var tradePrice = rowstr.find("[name='tradePrice']").html();
        obj.tradePrice = tradePrice;
        var transferPrice = rowstr.find("[name='transferPrice']").html();
        obj.transferPrice = transferPrice;

        //配件
        var partsStyle = rowstr.find("[name='partsStyle']").html();
        obj.partsStyle = partsStyle;
        //镜片
        var sph = rowstr.find("[name='sph']").html();
        obj.sph = sph;
        var cyl = rowstr.find("[name='cyl']").html();
        obj.cyl = cyl;
        var lightbelow = rowstr.find("[name='lightbelow']").html();
        obj.lightbelow = lightbelow;
        var refractivityvalue = rowstr.find("[name='refractivityvalue']").html();
        obj.refractivityvalue = refractivityvalue;
        var lightName = rowstr.find("[name='lightName']").html();
        obj.lightName = lightName;
        var lensName = rowstr.find("[name='lensName']").html();
        obj.lensName = lensName;
        var gradualName = rowstr.find("[name='gradualName']").html();
        obj.gradualName = gradualName;
        var functionName = rowstr.find("[name='functionName']").html();
        obj.functionName = functionName;

        //隐形
        var curvature = rowstr.find("[name='curvature']").html();
        obj.curvature = curvature;
        var diameter = rowstr.find("[name='diameter']").html();
        obj.diameter = diameter;
        var usageName = rowstr.find("[name='usageName']").html();
        obj.usageName = usageName;
        var typeName = rowstr.find("[name='typeName']").html();
        obj.typeName = typeName;




        //护理液
        var mainCapacity = rowstr.find("[name='mainCapacity']").html();
        obj.mainCapacity = mainCapacity;
        var secondCapacity = rowstr.find("[name='secondCapacity']").html();
        obj.secondCapacity = secondCapacity;
        //太阳镜
        //老花镜
        var degrees = rowstr.find("[name='degrees']").html();
        obj.degrees = degrees;

        var classtype = rowstr.find("[name='classtype']").html();
        obj.classtype = classtype;

        var producFactory = rowstr.find("[name='producFactory']").html();
        obj.producFactory = producFactory;

        var medicinecode = rowstr.find("[name='medicinecode']").html();
        obj.medicinecode = medicinecode;
        var factory = rowstr.find("[name='factory']").html();
        obj.factory = factory;
        var classtype = rowstr.find("[name='classtype']").html();
        obj.classtype = classtype;
        var gdname = rowstr.find("[name='gdname']").html();
        obj.gdname = gdname;

        var goodsxinxiid = rowstr.find("[name='goodsxinxiid']").html();
        obj.goodsxinxiid = goodsxinxiid;


        objArray.push(obj);
    });
    return objArray;
}


function save() {
    var goodsid = document.getElementById('goodsType').value;
    var mfrsid = document.getElementById('mfrsid').value;
    // var heji = document.getElementById('heji').value;
    // layer.alert(heji);
    if (goodsid == "") {
        layer.alert("请选择采购类型！");
    } else if (goodsid != "" && mfrsid == "") {
        layer.alert("请选择所属制造商！");
    }
    // else if (goodsid != "" && mfrsid != "" && heji == 0) {
    //     layer.alert("请添加单品商品!");
    // }
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


