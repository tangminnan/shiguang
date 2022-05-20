
var prefix = "/mfrs/company"
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
                        name: $('#name').val().trim(),
                        provinceName: $('#province').val().trim(),
                        // cityName: $('#ecityName').val().trim(),
                        type: $('#type').val().trim(),
                        telephone :$('#telephone').val().trim()
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
                columns : [
                    {
                        checkbox : true
                    },
                    // {
                    //     field : 'id',
                    //     title : '公司id'
                    // },
                    {
                        field : 'name',
                        title : '公司名称'
                    },
                    // {
                    //     field : 'province',
                    //     title : '所属区域'
                    // },
                    {
                        title: '所属区域',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (row.provinceName != null && row.cityName != null) {
                                return row.provinceName + "" + row.cityName
                            } else {
                                return ""
                            }
                        }

                    },
                    {
                        field : 'type',
                        title : '具体地址'
                    },
                    {
                        field : 'telephone',
                        title : '公司电话'
                    },
                    {
                        field : 'legalperson',
                        title : '法人'
                    },
                    {
                        field : 'phone',
                        title : '手机号'
                    },
                    // {
                    //     field : 'purchaseaddress',
                    //     title : '默认采购收货地址'
                    // },
                    // {
                    //     field : 'purchasepeople',
                    //     title : '默认采购收货人'
                    // },
                    // {
                    //     field : 'purchasephone',
                    //     title : '默认采购收货电话'
                    // },
                    // {
                    //     field : 'purchasefax',
                    //     title : '默认采购收货传真'
                    // },
                    // {
                    //     field : 'headername',
                    //     title : '报表表头显示名称'
                    // },
                    // {
                    //     field : 'approvedamount',
                    //     title : '批调金额'
                    // },
                    // {
                    //     field : 'proportion',
                    //     title : '批发价比例'
                    // },
                    // {
                    //     field : 'logo',
                    //     title : '系统logo',
                    //     formatter : function(value, row, index) {
                    //         if(value!=null){
                    //             var e = '<div class="image"><img width="90" height="100" alt="image" class="img-responsive" src="' + value + '"></div>'
                    //             return e;
                    //         }else
                    //             return "";
                    //     }
                    // },
                    // {
                    //     field : 'backgroundimage',
                    //     title : '背景图',
                    //     formatter : function(value, row, index) {
                    //         if(value!=null){
                    //             var e = '<div class="image"><img width="90" height="100" alt="image" class="img-responsive" src="' + value + '"></div>'
                    //             return e;
                    //         }else
                    //             return "";
                    //     }
                    // },
                    // {
                    //     field : 'departmentimage',
                    //     title : '部门选择背景图',
                    //     formatter : function(value, row, index) {
                    //         if(value!=null){
                    //             var e = '<div class="image"><img width="90" height="100" alt="image" class="img-responsive" src="' + value + '"></div>'
                    //             return e;
                    //         }else
                    //             return "";
                    //     }
                    // },
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
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d ;
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

('德州市人民医院眼科中心','19963870003','山东省德州市新湖大街1751号（德州市人民医院新门诊楼五楼）',0,1),
('山东施尔明医学视光中心（临沂）','13589085623','临沂市兰山区沂蒙路92号（羲之宾馆对过）（山东施尔明医学视光中心）',0,1),
('邹城市青少年视力低下防治中心','18363001152','济宁市邹城市人民医院千泉路59号',0,1),
('无棣县青少年视力低下防治中心','17862958334','滨州市无棣县人民医院',0,1),
('高密市青少年视力低下防治中心','13553181983','山东省潍坊市高密市立医院南楼一楼视光中心',0,1),
('安丘市青少年视力低下防治中心','18763668835','山东省潍坊市安丘市兴安街道双丰大道中段安丘市妇幼保健院东裙楼1楼',0,1),
('沂水县青少年视力低下防治中心','17615800282','临沂市沂水县视康医院',0,1),
('桓台县青少年视力低下防治中心','18765803658','山东省淄博市桓台县妇幼保健院新院门诊二楼眼科（渔洋街5066号）',0,1),
('莒县青少年视力低下防治中心','17862972337','日照市莒县人民医院沭东院区眼科门诊四楼视光中心',0,1),
('临朐县青少年视力低下防治中心','18353156551','山东省潍坊市临朐县基督教爱德医院二楼',0,1),
('微山县青少年视力低下防治中心','17861302500','济宁市微山县人民医院',0,1),
('宁阳县青少年视力低下防治中心','0538-2092899','泰安市宁阳县兴隆街169号宁阳县妇幼保健院',0,1),
('山东省青少年视力低下防治中心技术协作基地（枣庄）','15589256213','枣庄市北京中医药大学枣庄医院',0,1),
('鱼台县青少年视力低下防治中心','17562007120','山东省济宁市鱼台县人民医院门诊楼四楼眼科',0,1),
('莱州市青少年视力低下防治中心','15898877923','烟台市莱州市妇幼保健院门诊楼三楼眼科',0,1),
('商河县青少年视力低下防治中心','18364167797','济南市商河县中医医院门诊楼',0,1),
('青岛西海岸新区青少年视力低下防治中心','17615321297','青岛西海岸新区珠山路与中原街交叉口东50米',0,1),
('周村区青少年视力低下防治中心','13165106761','淄博市周村区人民医院新院',0,1),
('武城县青少年视力低下防治中心','17862986005','山东省德州市武城县历亭路79号武城县中医院七楼视光中心',0,1),
('鲁青眼科医院视光中心','0531-58859689','山东省济南市市中区英雄山路48号',0,1)

