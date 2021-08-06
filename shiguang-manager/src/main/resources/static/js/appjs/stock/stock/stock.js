var prefix = "/stock/stock"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                        producNum: $('#producNum').val(),
                        producCode: $('#producCode').val(),
                        producName: $('#producName').val(),
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        // checkbox: true
                    },
                    // 								{
                    // 	field : 'id',
                    // 	title : '主键'
                    // },
                    {
                        field: 'danjuNumber',
                        title: '单据编号'
                    },
                    {
                        field: 'mfrsname',
                        title: '制造商'
                    },
                    {
                        field: 'zhidanPeople',
                        title: '入库人'
                    },
                    {
                        field: 'danjuDay',
                        title: '制单日期'
                    },
                    // {
                    //     field: '',
                    //     title: '审核人'
                    // }, {
                    //     field: '',
                    //     title: '审核日期'
                    // },
                    // {
                    //     title: '操作',
                    //     field: 'id',
                    //     align: 'center',
                    //     formatter: function (value, row, index) {
                    //         var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                    //             + row.id
                    //             + '\')"><i class="fa fa-edit"></i></a> ';
                    //         var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    //             + row.id
                    //             + '\')"><i class="fa fa-remove"></i></a> ';
                    //         var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                    //             + row.id
                    //             + '\')"><i class="fa fa-key"></i></a> ';
                    //         return e + d;
                    //     }
                    // }
                ]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

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
        //护理液
        var mainCapacity = rowstr.find("[name='mainCapacity']").html();
        obj.mainCapacity = mainCapacity;
        var secondCapacity = rowstr.find("[name='secondCapacity']").html();
        obj.secondCapacity = secondCapacity;
        //太阳镜
        //老花镜
        var degrees = rowstr.find("[name='degrees']").html();
        obj.degrees = degrees;
        objArray.push(obj);
    });
    return objArray;
}


function save() {
    var goodsid = document.getElementById('goodsType').value;
    var mfrsid = document.getElementById('mfrsid').value;
    // var heji = document.getElementsByName("heji").value;
    if (goodsid == "") {
        alert("请选择采购类型！");
    } else if (goodsid != "" && mfrsid == "") {
        alert("请选择所属制造商！");
    }
    // else if (goodsid != "" && mfrsid == "" && heji == "") {
    //     alert("请添加单品商品!");
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


