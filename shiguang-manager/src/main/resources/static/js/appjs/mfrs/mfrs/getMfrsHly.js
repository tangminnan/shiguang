var prefix = "/mfrs/mfrs"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/HlyList", // 服务器数据的加载地址
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
                        //mfrsnum:$("#mfrsnum").val()
                        mfrsnum: $('#mfrsnum').val(),
                        mfrsname: $('#mfrsname').val(),
                        goodsid: $('#goodsid').val(),
                        invoiceid: $('#invoiceid').val()
                        // username:$('#searchName').val()
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
                        checkbox: true
                    },
                    // 								{
                    // 	field : 'mfrsid',
                    // 	title : '制造商id'
                    // },
                    {
                        field: 'mfrsnum',
                        title: '制造商代码'
                    },
                    {
                        field: 'mfrsname',
                        title: '制造商简称'
                    },
                    {
                        field: 'mfrscontacts',
                        title: '制造商联系人'
                    },
                    // 								{
                    // 	field : 'mfrsrealname',
                    // 	title : '制造商全称'
                    // },
                    // 								{
                    // 	field : 'mfrstelephone',
                    // 	title : '制造商电话'
                    // },
                    {
                        field: 'mfrsphone',
                        title: '联系人电话'
                    },
                    // 								{
                    // 	field : 'goodsid',
                    // 	title : '商品类别'
                    // },
                    {
                        field: 'mfrsfax',
                        title: '制造商传真'
                    },
                    {
                        field: 'mfrsaddress',
                        title: '制造商地址'
                    },
                    // 								{
                    // 	field : 'payid',
                    // 	title : '采购结算方式'
                    // },
                    // 								{
                    // 	field : 'invoiceid',
                    // 	title : '开票状态(1开票、2不开票)'
                    // },
                    // 								{
                    // 	field : 'creditcode',
                    // 	title : '统一社会信用代码'
                    // },
                    // 								{
                    // 	field : 'creditcodeday',
                    // 	title : '统一社会信用代码效期'
                    // },
                    // {
                    //     field: 'medicinecode',
                    //     title: '医疗器械经营许可证号'
                    // },
                    // 								{
                    // 	field : 'medicinecodeday',
                    // 	title : '医疗器械经营许可证有效期'
                    // },
                    // 								{
                    // 	field : 'productscode',
                    // 	title : '全国工业品生产许可证号'
                    // },
                    // 								{
                    // 	field : 'productscodeday',
                    // 	title : '全国工业品生产许可证有效期'
                    // },
                    // 	{
                    // 		field : 'remarks',
                    // 		title : '备注'
                    // 	},
                    // 	{
                    // {
                    //     field : 'status',
                    //     title : '状态',
                    //     formatter : function(value, row, index) {
                    //         var str = '';
                    //
                    //         str +=' <div class="switch onoffswitch col-sm-1"> ';
                    //         str +=' <div class="onoffswitch"> ';
                    //         str +=' <input name="allowComment" ';
                    //         //启用状态 0：是；1：否
                    //         if(row.status == 1)
                    //             str += ' checked="" ';
                    //
                    //         str +=' type="checkbox" onchange="updateEnable(' +row.id+ ',this)" value="' +row.id+ '" class="onoffswitch-checkbox" id="example1' +row.id+ '">  ';
                    //         str +=' <label class="onoffswitch-label" for="example1' +row.id+ '">  ';
                    //         str +=' <span class="onoffswitch-inner" ></span> ';
                    //         str +=' <span class="onoffswitch-switch" ></span> ';
                    //         str +=' </label> ';
                    //         str +=' </div>';
                    //         str +=' </div>';
                    //         return str;
                    //     }
                    // },
                    // {
                    //     title: '操作',
                    //     field: 'id',
                    //     align: 'center',
                    //     formatter: function (value, row, index) {
                    //         var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                    //             + row.mfrsid
                    //             + '\')"><i class="fa fa-edit"></i></a> ';
                    //         var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    //             + row.mfrsid
                    //             + '\')"><i class="fa fa-remove"></i></a> ';
                    //         // var a = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="详情" onclick="detail(\''
                    //         //     + row.mfrsid
                    //         //     + '\')">详情</a> ';
                    //         var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                    //             + row.mfrsid
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
    var toIndex = layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
    layer.full(toIndex);
}

// function detail(id) {
//     var toIndex =layer.open({
//         type: 2,
//         title: '详情',
//         maxmin: true,
//         shadeClose: false, // 点击遮罩关闭层
//         area: ['800px', '520px'],
//         content: prefix + '/detial/' + id // iframe的url
//     });
//
// }

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'mfrsid': id
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
            ids[i] = row['mfrsid'];
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

//停用启动
function stop(status) {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择数据");
        return;
    }
    var msg;
    if (status == 0) {
        msg = "确认要停用选中的"
    } else if (status == 1) {
        msg = "确认要启用选中的"
    }
    layer.confirm(msg + "'" + rows.length + "'条数据吗?", {
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
                "ids": ids,
                "status": status
            },
            url: prefix + '/stop',
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

//选择制造商
function batchSelect() {
    var rows = $("#exampleTable").bootstrapTable("getSelections");
    return rows;
};