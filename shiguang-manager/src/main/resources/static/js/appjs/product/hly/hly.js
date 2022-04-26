var prefix = "/product/hly"
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
                pageSize: 50, // 如果设置了分页，每页数据条数
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
                        producNum:$('#producNum').val().trim(),
                        producName:$('#producName').val().trim(),
                        mfrsname: $('#mfrsname').val().trim(),
                        brandname: $('#brandname').val().trim(),
                        retailPrice:$('#retailPrice').val().trim(),
                        retailPrice2:$('#retailPrice2').val().trim(),
                        taxPrice:$('#taxPrice').val().trim(),
                        taxPrice2:$('#taxPrice2').val().trim(),
                        xsstate:$('#xsstate').val().trim()
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
                    // 	field : 'id',
                    // 	title : '隐形护理液id'
                    // },
                    {
                        field: 'producNum',
                        title: '商品代码'
                    },
                    // {
                    //     field: 'producCode',
                    //     title: '商品条码'
                    // },
                    {
                        title: '商品名称',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (row.viewGoodName != null) {
                                return row.viewGoodName+"-型号:"+row.factory+"-标价:"+row.retailPrice

                            } else {
                                return ""
                            }
                        }
                    },
                    // 								{
                    // 	field : 'mfrsid',
                    // 	title : '制造商id'
                    // },
                    {
                        field: 'mfrsname',
                        title: '制造商简称'
                    },
                    // 								{
                    // 	field : 'brandid',
                    // 	title : '商品品种'
                    // },
                    {
                        field: 'brandname',
                        title: '商品品种'
                    },
                    // 								{
                    // 	field : 'factory',
                    // 	title : '厂家型号'
                    // },
                    // {
                    //     field: 'producFactory',
                    //     title: '型号'
                    // },
                    // 								{
                    // 	field : 'proid',
                    // 	title : '商品编号'
                    // },
                    // 								{
                    // 	field : 'unitid',
                    // 	title : '计量单位'
                    // },
                    {
                        field: 'unitname',
                        title: '单位'
                    },
                    // {
                    //     field: 'productType',
                    //     title: '产品类型'
                    // },
                    // {
                    //     field: 'mainCapacity',
                    //     title: '主容量'
                    // },
                    // {
                    //     field: 'secondCapacity',
                    //     title: '次容量'
                    // },
                    // 								{
                    // 	field : 'upday',
                    // 	title : '效期提醒上限（有效期前【】天提醒进入滞销状态）'
                    // },
                    // 								{
                    // 	field : 'downday',
                    // 	title : '效期提醒下限（有效期前【】天提醒进入即将失效状态）'
                    // },
                    // 								{
                    // 	field : 'tax',
                    // 	title : '税率(%)'
                    // },
                    {
                        field: 'retailPrice',
                        title: '标准零售价格'
                    },
                    // {
                    //     field: 'taxPrice',
                    //     title: '含税单价'
                    // },
                    // {
                    //     field: 'tradePrice',
                    //     title: '批发价格'
                    // },
                    // 								{
                    // 	field : 'transferPrice',
                    // 	title : '调货成本'
                    // },
                    {
                        field: 'xsstate',
                        title: '销售状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var str = '';
                            str += ' <div class="switch onoffswitch col-sm-1"> ';
                            str += ' <div class="onoffswitch"> ';
                            str += ' <input name="allowComment" ';
                            //启用状态 0：启用；1：禁用
                            if (row.xsstate == 0)
                                str += ' checked="" ';

                            str += ' type="checkbox" onchange="updateEnable(' + row.id + ',this)" value="' + row.id + '" class="onoffswitch-checkbox" id="example1' + row.id + '">  ';
                            str += ' <label class="onoffswitch-label" for="example1' + row.id + '">  ';
                            str += ' <span class="onoffswitch-inner" ></span> ';
                            str += ' <span class="onoffswitch-switch" ></span> ';
                            str += ' </label> ';
                            str += ' </div>';
                            str += ' </div>';
                            return str;
                        }
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="详情"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')">详情</a> ';
                            return e + d + f;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
document.onkeydown = function(e){
    if((e||event).keyCode==13)
        reLoad();
};
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

//修改启用状态
function updateEnable(id, enable) {
    var isEnable = 1;
    if ($(enable).prop("checked")) {
        isEnable = 0;
    }

    $.ajax({
        url: prefix + "/updateEnable",
        type: "post",
        data: {
            'id': id,
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
