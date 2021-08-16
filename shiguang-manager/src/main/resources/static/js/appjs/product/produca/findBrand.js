var prefix = "/mfrs/brand"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/brandList", // 服务器数据的加载地址
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
                        mfrsids: $('#mfrsids').val(),
                        goodsids: $('#goodsids').val(),
                        goodsid: $('#goodsid').val(),
                        mfrsid: $('#mfrsid').val(),
                        brandnum: $('#brandnum').val(),
                        stateId: $('#stateId').val(),
                        payid: $('#payid').val(),
                        brandname: $('#brandname').val()
                        // name:$('#searchName').val(),
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
                    // 	field : 'brandid',
                    // 	title : '品牌id'
                    // },
                    {
                        field: 'brandnum',
                        title: '品牌代码'
                    },
                    {
                        field: 'brandname',
                        title: '品牌名称'
                    },
                    // {
                    //     field: 'goodsid',
                    //     title: '商品类别id'
                    // },
                    {
                        field: 'goodsname',
                        title: '商品类别'
                    },
                    // {
                    //     field: 'materialid',
                    //     title: '镜架材质名称id'
                    // },
                    // {
                    //     field: 'materialname',
                    //     title: '镜架材质名称'
                    // },
                    // {
                    //     field: 'lensId',
                    //     title: '材料分类id'
                    // },
                    // {
                    //     field: 'lensName',
                    //     title: '材料分类'
                    // },
                    // {
                    //     field: 'lightId',
                    //     title: '光度分类id'
                    // },
                    // {
                    //     field: 'lightName',
                    //     title: '光度分类'
                    // },
                    // {
                    //     field: 'refractivityid',
                    //     title: '折射率值id'
                    // },
                    // {
                    //     field: 'refractivityvalue',
                    //     title: '折射率值'
                    // },
                    // {
                    //     field: 'functionId',
                    //     title: '镜片功能id'
                    // },
                    // {
                    //     field: 'functionName',
                    //     title: '镜片功能'
                    // },
                    // {
                    //     field: 'gradualId',
                    //     title: '渐进片分类id'
                    // },
                    // {
                    //     field: 'gradualName',
                    //     title: '渐进片分类'
                    // },
                    // {
                    //     field: 'usageId',
                    //     title: '使用类型id'
                    // },
                    // {
                    //     field: 'usageName',
                    //     title: '使用类型'
                    // },
                    // {
                    //     field: 'typeId',
                    //     title: '抛弃型分类id'
                    // },
                    // {
                    //     field: 'typeName',
                    //     title: '抛弃型分类'
                    // },
                    // {
                    //     field: 'registration',
                    //     title: '注册证号'
                    // },
                    // {
                    //     field: 'mfrsid',
                    //     title: '制造商id'
                    // },
                    {
                        field: 'mfrsname',
                        title: '制造商简称'
                    },
                    // 								{
                    // 	field : 'unitid',
                    // 	title : '计量单位'
                    // },
                    // 								{
                    // 	field : 'address',
                    // 	title : '产地'
                    // },
                    // 								{
                    // 	field : 'payid',
                    // 	title : '采购结算方式'
                    // },
                    // 								{
                    // 	field : 'batchid',
                    // 	title : '批号管理(1是、2否)'
                    // },
                    // 								{
                    // 	field : 'factory',
                    // 	title : '厂家型号'
                    // },
                    // 								{
                    // 	field : 'money',
                    // 	title : '促销金额'
                    // },
                    // 								{
                    // 	field : 'shorthandcode',
                    // 	title : '速记码'
                    // },
                    // 								{
                    // 	field : 'productionkey',
                    // 	title : '生产企业许可证号'
                    // },
                    // {
                    //     field : 'stateId',
                    //     title : '状态(1:停用2:启用)'
                    // },
                    // {
                    //     field : 'status',
                    //     title : '状态（1：停用2：启用）'
                    // },
                    // {
                    //     field: 'status',
                    //     title: '启用状态',
                    //     align: 'center',
                    //     formatter: function (value, row, index) {
                    //         var str = '';
                    //         str += ' <div class="switch onoffswitch col-sm-1"> ';
                    //         str += ' <div class="onoffswitch"> ';
                    //         str += ' <input name="allowComment" ';
                    //         //启用状态 0：启用；1：禁用
                    //         if (row.status == 0)
                    //             str += ' checked="" ';
                    //
                    //         str += ' type="checkbox" onchange="updateEnable(' + row.brandid + ',this)" value="' + row.brandid + '" class="onoffswitch-checkbox" id="example1' + row.brandid + '">  ';
                    //         str += ' <label class="onoffswitch-label" for="example1' + row.brandid + '">  ';
                    //         str += ' <span class="onoffswitch-inner" ></span> ';
                    //         str += ' <span class="onoffswitch-switch" ></span> ';
                    //         str += ' </label> ';
                    //         str += ' </div>';
                    //         str += ' </div>';
                    //         return str;
                    //     }
                    // },
                    //
                    // {
                    //     title: '操作',
                    //     field: 'id',
                    //     align: 'center',
                    //     formatter: function (value, row, index) {
                    //         var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                    //             + row.brandid
                    //             + '\')"><i class="fa fa-edit"></i></a> ';
                    //         var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    //             + row.brandid
                    //             + '\')"><i class="fa fa-remove"></i></a> ';
                    //         var f = '<a class="btn btn-success btn-sm" href="#" title="详情"  mce_href="#" onclick="resetPwd(\''
                    //             + row.brandid
                    //             + '\')">详情</a> ';
                    //         return e + d + f;
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

//详情
function resetPwd(id) {
    layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/detail/' + id // iframe的url
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
                'brandid': id
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
            ids[i] = row['brandid'];
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

//修改启用状态
function updateEnable(brandid, enable) {
    var isEnable = 1;
    if ($(enable).prop("checked")) {
        isEnable = 0;
    }

    $.ajax({
        url: prefix + "/updateEnable",
        type: "post",
        data: {
            'brandid': brandid,
            'enable': isEnable
        },
        dataType: 'JSON',
        async: false,
        success: function (r) {
            if (r.code == 0) {
                layer.msg(r.msg);
                reLoad();
            } else {
                layer.msg(r.msg);
            }
        }
    });
}

//选择商品品种
function batchSelect() {
    var rows = $("#exampleTable").bootstrapTable("getSelections");
    return rows;
};