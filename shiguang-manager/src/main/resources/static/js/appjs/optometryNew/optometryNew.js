var prefix = "/information/optometryNew"
// $(function () {
//     load();
// });

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
                        cardNumber: $('#cardNumber').val(),
                        saleNumber: $('#saleNumber').val(),
                        name: $('#name').val(),
                        phone1: $('#phone1').val(),
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
                        field: 'cardNumber',
                        title: '会员卡号',
                        align: 'center'
                    },
                    // {
                    //     field: 'saleNumber',
                    //     title: '缴费单号',
                    //     align: 'center'
                    // },
                    {
                        field: 'name',
                        title: '姓名',
                        align: 'center'
                    },
                    {
                        field: 'sex',
                        title: '性别',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (value == '0') {
                                return '<span class="label">男</span>';
                            } else if (value == '1') {
                                return '<span class="label">女</span>';

                            }
                        }
                    },
                    {
                        field: 'age',
                        title: '年龄',
                        align: 'center'
                    },
                    {
                        title: '操作',
                        field: 'cardNumber',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<span class="btn btn-success btn-sm " href="#" title="综合验光"  mce_href="#" onclick="edit(\''
                                + value
                                + '\')">综合验光</span> ';
                            // var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                            // 		+ row.id
                            // 		+ '\')"><i class="fa fa-remove"></i></a> ';
                            // var f = '<span class="btn btn-primary btn-sm" href="#" title="验光数据"  mce_href="#" onclick="resetPwd(\''
                            //     + value
                            //     + '\')">验光数据</span> ';
                            var d =  "<a href='javascript:' class='detail-icon btn btn-warning btn-sm' >更多</a> ";
                            return e  + d;
                        }
                    }],
                onExpandRow: function (index, row, $detail) {
                    var last = JSON.stringify(row);
                    // alert(row)
                    // alert(last)
                    onclick = row.cardNumber;
                    var cardNumber = row.cardNumber;
                    var prjLogBookProblemTable = $detail.html('<table></table>').find('table');
                    $(prjLogBookProblemTable).bootstrapTable({
                        columns: [
                            {
                                field : 'ptometryNumber',
                                title : '验光号'
                            },

                            {
                                field : 'optometryName',
                                title : '验光师'
                            },

                            {
                                field:'createTime',
                                title:'验光时间'
                            },
                            {
                                field:'followTime',
                                title:'复诊时间'
                            },
                            {
                                title: '操作',
                                field: 'ptometryNumber',
                                align: 'center',
                                formatter: function (value, row, index) {
                                    // alert(row.haveid);
                                    if (row.haveid == "1"){ //是否结算
                                        if (row.status=="1"){
                                            var f = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="selectShuju(\''
                                                + value
                                                + '\')">详情</span> ';

                                            // var a = '<span class="btn btn-primary btn-sm" href="#" title="修改"  mce_href="#" onclick="updateShuju(\''
                                            //     + value
                                            //     + '\')">修改</span> ';

                                            var h = '<span class="btn btn-danger btn-sm" href="#" title="删除"  mce_href="#" onclick="upremove(\''
                                                + value
                                                + '\')">删除</span> ';


                                            // var d= '<span class="btn btn-success btn-sm " href="#" title="修改"  mce_href="#" onclick="updateShuju(\''
                                            //     + value
                                            //     + '\')">修改</span> ';

                                        }else if (row.status =="0") {
                                            var f = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="selectShuju(\''
                                                + value
                                                + '\')">详情</span> ';
                                            // var a = '';
                                            var h = '';
                                            // var d = '';
                                        }
                                    } else if (row.haveid == "0") { //是否结算
                                    var f = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="selectShuju(\''
                                        + value
                                        + '\')">详情</span> ';
                                    var h='';
                                    // var a='';
                                    //     var d='';

                                }
                                    return f + h   ;
                                }
                            }

                        ],
                        url: "/jiancha/result/shujulist",
                        method: 'get',
                        queryParams:{cardNumber:cardNumber},
                        ajaxOptions:{cardNumber:cardNumber},
                        /*queryParams : function(params) {
                            return {
                                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对

                                id: parentId

                            };
                        },*/
                        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                        onLoadError: function () {  //加载失败时执行
                            Layer.alert("失败");
                        },
                    })
                }

            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
    load();
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

function edit(cardNumber) {
    var toIndex = layer.open({
        type: 2,
        title: '检查',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['1000px', '520px'],
        content: prefix + '/edit/' + cardNumber  // iframe的url
    });
    layer.full(toIndex);

}

//详情
function resetPwd(cardNumber) {
    // alert("详情")
    var toIndex = layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/detail/' + cardNumber // iframe的url
    });
    layer.full(toIndex);
}
//详情
function selectShuju(ptometryNumber) {
    // alert("详情")
    var toIndex = layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/jiancha/result/chufangall/' + ptometryNumber // iframe的url

    });
    layer.full(toIndex);
}
//修改
function updateShuju(ptometryNumber) {
    // alert("详情")
    var toIndex = layer.open({
        type: 2,
        title: '修改',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/jiancha/result/updateShuju/' + ptometryNumber // iframe的url

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
function upremove(ptometryNumber) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: '/jiancha/result/upremove' ,
            type: "post",
            data: {
                'ptometryNumber': ptometryNumber
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