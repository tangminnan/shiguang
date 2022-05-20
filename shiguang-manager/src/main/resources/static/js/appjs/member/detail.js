
var prefix = "/information/member"
$(function() {
	load();
});

function load() {
	var cardNumber = $("#cardNumbers").val();
	$('#exampleTable2')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/binglilist" , // 服务器数据的加载地址
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
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                cardNumber:cardNumber
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
									field : 'ptometryNumber',
									title : '验光号',
                                    align : 'center'
								},
																{
									field : 'createTime',
									title : '初验时间',
                                    align : 'center'
								},
								{
									field : 'followTime',
									title : '复验时间',
                                    align : 'center'
								},
																{
									field : 'sex', 
									title : '是否复验',
									align : 'center',
									formatter : function(value, row, index) {
										return '复验'
									}
								},
                            {
                                title: '操作',
                                field: 'ptometryNumber',
                                align: 'center',
                                formatter: function (value, row, index) {
									var f = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="selectShuju(\''
										+ value
										+ '\')">详情</span> ';
                                    return f;
                                }
                            }
						]
					});
    $('#exampleTable3')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/salelist" , // 服务器数据的加载地址
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
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        cardNumber:cardNumber
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
                        field : 'saleNumber',
                        title : '销售单号',
                        align : 'center'
                    },
                    {
                        field : 'mirorAddress',
                        title : '销售门店',
                        align : 'center'
                    },
                    {
                        field : 'ptometryNumber',
                        title : '验光单号',
                        align : 'center'
                    },
                    {
                        field : 'eyeType',
                        title : '销售类型'
                    },
                    {
                        field : 'recipelType',
                        title : '处方类型'
                    },
                    {
                        field : 'saleName',
                        title : '销售人员'
                    },
                    {
                        field : 'primeMoney',
                        title : '原价合计'
                    },
                    {
                        field : 'amountMoney',
                        title : '应收金额'
                    },
                    {
                        field : 'settleTime',
                        title : '收款日期'
                    },
                    {
                        field : 'logStatus',
                        title : '在途状态'
                    },
                    {
                        title: '操作',
                        field: 'saleNumber',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var f = '';
                            if (row.saleType == '3'){
                                f = '<span class="btn btn-primary btn-sm" href="#" title="退款"  mce_href="#" onclick="selectTkSale(\''
                                    + value
                                    + '\')">退款</span> ';
                            } else {
                                f = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="selectSale(\''
                                    + value
                                    + '\')">详情</span> ';
                            }
                            return f;
                        }
                    }
                ]
            });
}
function reLoad() {
    var opt = {
        query : {
            type : $('.chosen-select').val(),
        }
    }
	$('#exampleTable').bootstrapTable('refresh');
}

//病历详情
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

//销售详情
function selectSale(saleNumber) {
    // alert("详情")
    var toIndex = layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/editSale/' + saleNumber // iframe的url

    });
    layer.full(toIndex);
}

function selectTkSale(saleNumber) {
    var toIndex = layer.open({
        type: 2,
        title: '退款',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/editTkSale/' + saleNumber // iframe的url

    });
    layer.full(toIndex);
}

function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}

function updateEnable(id,enable){
    var isEnable = 1;
    if($(enable).prop("checked")){
        isEnable = 0;
    }

    $.ajax({
        url : prefix + "/updateEnable",
        type : "post",
        data : {
            'id' : id,
            'enable' : isEnable
        },
        dataType: 'JSON',
        async : false,
        success : function(r) {
            if (r.code == 0) {
                layer.msg(r.msg);
                reLoad();
            } else {
                layer.msg(r.msg);
            }
        }
    });
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function detail(id) {
    layer.open({
        type : 2,
        title : '详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '1000px', '620px' ],
        content : prefix + '/detail/' + id // iframe的url
    });
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
function batchRemove(status) {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择数据");
		return;
	}
	var msg;
	if (status == 0){
		msg = "确认要停用选中的"
	} else if (status == 1){
        msg = "确认要启用选中的"
	}
	layer.confirm(msg+"'" + rows.length + "'条数据吗?", {
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
				"ids" : ids,
				"status" : status
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