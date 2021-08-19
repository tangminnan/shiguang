var prefix = "/mfrs/mfrs"
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
                        mfrsnum: $('#mfrsnum').val(),
                        mfrsname: $('#mfrsname').val(),
                        goodsid: $('#goodsid').val(),
                        xsstate: $('#xsstate').val(),
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
                    {
                        field: 'mfrsphone',
                        title: '联系人电话'
                    },
                    {
                        field: 'mfrsfax',
                        title: '制造商传真'
                    },
                    {
                        field: 'mfrsaddress',
                        title: '制造商地址'
                    },
                    {
                        field: 'xsstate',
                        title: '启用状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var str = '';
                            str += ' <div class="switch onoffswitch col-sm-1"> ';
                            str += ' <div class="onoffswitch"> ';
                            str += ' <input name="allowComment" ';
                            //启用状态 0：启用；1：禁用
                            if (row.xsstate == 0)
                                str += ' checked="" ';

                            str += ' type="checkbox" onchange="updateEnable(' + row.mfrsid + ',this)" value="' + row.mfrsid + '" class="onoffswitch-checkbox" id="example1' + row.mfrsid + '">  ';
                            str += ' <label class="onoffswitch-label" for="example1' + row.mfrsid + '">  ';
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
                                + row.mfrsid
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.mfrsid
                                + '\')"><i class="fa fa-remove"></i></a> ';

                            var f = '<a class="btn btn-success btn-sm" href="#" title="详情"  mce_href="#" onclick="resetPwd(\''
                                + row.mfrsid
                                + '\')">详情</a> ';
                            return e + d + f;
                        }
                    }]
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

//详情
function resetPwd(id) {
    // alert(id);
    layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/detail/' + id // iframe的url
    });
}

//保存
function save() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/mfrs/mfrs/save",
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

//选择制造商
function batchSelect() {
    var rows = $("#exampleTable").bootstrapTable("getSelections");
    return rows;
};

//修改启用状态
function updateEnable(mfrsid, enable) {
    // alert(mfrsid);
    // alert(enable)
    var isEnable = 1;
    if ($(enable).prop("checked")) {
        isEnable = 0;
    }

    $.ajax({
        url: prefix + "/updateEnable",
        type: "post",
        data: {
            'mfrsid': mfrsid,
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