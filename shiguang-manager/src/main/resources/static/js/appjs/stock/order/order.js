var prefix = "/stock/order"
$(function () {
    load();
});

function load() {
    // alert($("#danjuNumber").val())
    // alert("采购订单列表")
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/stock/stock" + "/list", // 服务器数据的加载地址
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
                        danjuNumber :$('#danjuNumber').val().trim(),
                        goodsid :$('#goodsid').val().trim(),
                        classtype :$('#classtype').val().trim()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    // {
                    //     // checkbox: true
                    // },
                    // {
                    //     field: 'id',
                    //     title: '主键'
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
                        title: '商品类别',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (row.classtype == 2) {
                               if (row.gdname=="镜片"){
                                   return "订做镜片"
                               }else if (row.gdname=="隐形"){
                                   return "订做隐形"
                               }
                            } else {
                                return row.gdname
                            }
                        }

                    },

                    {
                        field: 'zhidanPeople',
                        title: '入库人'
                    },
                    {
                        field: 'positionName',
                        title: '入库仓位'
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
                    {
                        title: '操作',
                        field: 'danjuNumber',
                        align: 'center',
                        formatter: function (value, row, index) {
                            // alert(row.danjuNumber)
                            if (row.status == "1") {
                                var b = '<span class="btn btn-info btn-sm '+s_edit_h+'" href="#" title="修改"  mce_href="#" onclick="edit(\''
                                    + row.id + '\')">修改</span> ';
                                var a = '<span class="btn btn-primary btn-sm '+s_detial_h+'" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                    + row.id + '\')">详情</span> ';
                                var f = '<span class="btn btn-success btn-sm" href="#" title="收货"  mce_href="#"  onclick="userNum(\''
                                    + row.danjuNumber + '\')">收货</span> ';
                                var r= '<span class="btn btn-danger btn-sm" href="#" title="删除"  mce_href="#"  onclick="remove(\''
                                    + row.id + '\')">删除</span> ';
                                var n = '';
                            } else if (row.status == "0") {
                                var b ='';
                                var a = '<span class="btn btn-primary btn-sm'+s_detial_h+'" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                    + row.id + '\')">详情</span> ';
                                var f = '';
                                var n = '<span class="btn btn-warning btn-sm"  href="#" title="条码"  mce_href="#" onclick="code(\''
                                    + row.goodsType+" ','"+ row.danjuNumber + '\')">条码</span> ';
                                var r ='';
                            }
                            return b + a + f + n + r ;
                        }
                    }
                ]


            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

document.onkeydown = function(e){
    if((e||event).keyCode==13)
        reLoad();
};




function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : "/stock/stock/remove",
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







//打印条码
function code(goodsType,danjuNumber){
    if (goodsType==1 || goodsType==6){
        window.open("/stock/stock/codeJingjia?danjuNumber="+danjuNumber + "&goodsType=" + goodsType);
    } else {
        window.open("/stock/stock/code?danjuNumber="+danjuNumber);
    }

}

function userNum(danjuNumber) {
    var staus="1";
    if (staus == "1"){
        // alert("输入工号")
        layer.open({
            type : 2,
            title : '输入工号',
            maxmin : true,
            shadeClose : false, // 点击遮罩关闭层
            area : [ '800px', '520px' ],
            content :"/stock/order/userNum/"+ danjuNumber
        });

    }
}
//修改启用状态
function updateEnable() {
    var danjuNumber = document.getElementById('danjuNumber').value;
    var username = document.getElementById('username').value;
    // alert(username)
    var status = "0";
    if (username !=""){
        $.ajax({
            url: "/stock/order/updateStatus",
            type: "post",
            data: {
                'danjuNumber': danjuNumber,
                'status': status,
                'username':username
            },
            dataType: 'JSON',
            async: false,
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
    } else {
        layer.alert("请输入工号！");
        // return this;
    }


}


/**
 * 模板导入商品
 */
function importtemplate(){
    var checkType='PU_TONG';
    var toIndex = layer.open({
        type : 2,
        title : '批调导入',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : '/stock/stock/information/'+checkType // iframe的url
    });
    layer.full(toIndex)
}