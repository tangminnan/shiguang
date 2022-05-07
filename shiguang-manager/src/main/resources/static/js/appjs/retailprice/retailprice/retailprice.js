
var prefix = "/retailprice/retailprice"
$(function() {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 50, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                pageList: [50,100,200,300,500,1200],
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        people:$('#people').val().trim(),
                        day1:$('#day1').val().trim(),
                        day2:$('#day2').val().trim(),
                        number:$('#number').val().trim()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns : [
                    {
                        checkbox : true
                    },
                    // {
                    //     field : 'id',
                    //     title : 'id'
                    // },
                    {
                        field : 'number',
                        title : '单据编号'
                    },
                    {
                        field : 'people',
                        title : '制单人'
                    },
                    {
                        field : 'day',
                        title : '制单日期'
                    },
                    {
                        field : 'people',
                        title : '审核人'
                    },
                    {
                        field : 'day',
                        title : '生效日期'
                    },
                    {
                        field : 'remarks',
                        title : '备注'
                    },
                    // {
                    //     field : 'goodsid',
                    //     title : '商品类别'
                    // },
                    // {
                    //     field : 'classtype',
                    //     title : '成品定制（1成品，2订做）'
                    // },
                    // {
                    //     field : 'num',
                    //     title : '品种商品代码'
                    // },
                    // {
                    //     field : 'name',
                    //     title : '品种商品名称'
                    // },
                    // {
                    //     field : 'goodsNum',
                    //     title : '商品代码'
                    // },
                    // {
                    //     field : 'goodsName',
                    //     title : '商品名称'
                    // },
                    // {
                    //     field : 'mfrsnum',
                    //     title : '制造商代码'
                    // },
                    // {
                    //     field : 'mfrsname',
                    //     title : '制造商名称'
                    // },
                    // {
                    //     field : 'brandnum',
                    //     title : '品种代码'
                    // },
                    // {
                    //     field : 'brandname',
                    //     title : '品种名称'
                    // },
                    // {
                    //     field : 'factory',
                    //     title : '型号'
                    // },
                    // {
                    //     field : 'oldPrice',
                    //     title : '原销售价格'
                    // },
                    // {
                    //     field : 'newPrice',
                    //     title : '调整价格'
                    // },
                    // {
                    //     field : 'flag',
                    //     title : '类型'
                    // },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var a = '<span class="btn btn-primary btn-sm'+s_detial_h+'" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                + row.id + '\')">详情</span> ';
                            return a;
                        }
                    } ]
            });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function add() {
    var toIndex = layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add' // iframe的url
    });
    layer.full(toIndex);
}
function addGoods() {
    var toIndex = layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/addGoods' // iframe的url
    });
    layer.full(toIndex);
}
function edit(id) {
    var toIndex = layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
    layer.full(toIndex);
}
function detial(id) {
    var toIndex = layer.open({
        type : 2,
        title : '详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/detial/' + id // iframe的url
    });
    layer.full(toIndex);
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
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
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {

    });
}