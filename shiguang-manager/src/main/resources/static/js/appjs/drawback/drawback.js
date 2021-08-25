
var prefix = "/information/drawback"
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
                                cardNumber:$("#cardNumber").val()
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
									field : 'cardNumber',
									title : '会员卡号',
									align : 'center'
								},
								{
									field : 'name',
									title : '姓名',
									align : 'center'
								},
								{
									field : 'sex',
									title : '性别',
									align : 'center',
									formatter : function(value, row, index) {
										if(value == '0'){
											return '<span class="label">男</span>';
										}else if(value == '1'){
											return '<span class="label">女</span>';

										}
									}
								},
								{
									field : 'age',
									title : '年龄',
									align : 'center'
								},
																{
									title : '操作',
									field : 'cardNumber',
									align : 'center',
									formatter : function(value, row, index) {
                                        var e = '<a class="btn btn-primary btn-xs" href="#" title="退款"  mce_href="#" ' +
												 'onclick="tuikuan(\''+ value+ '\',\''+row.saleNumber+'\')" style="text-decoration: none;">退款</a>';
											   // e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" ' +
												//    'onclick="edit(\''+value+'\',\''+row.saleNumber+'\')"><i class="fa fa-edit"></i></a> ';
										// else if (row.isSale == 1) {
                                         //       e = '<a class="btn btn-primary btn-xs" href="#" title="详情"  mce_href="#" ' +
										// 		   'onclick="detail(\''+value+'\',\''+row.saleNumber+'\',\''+row.costId+'\')" style="text-decoration: none;">详情</a>';
                                         //       t = '<a class="btn btn-primary btn-xs" href="#" title="打印"  mce_href="#" ' +
                                         //        'onclick="dayin(\''+row.type+'\',\''+row.saleNumber+'\')" style="text-decoration: none;">打印</a>';
										// }
										return e;
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
    layer.full(toIndex)
}
function edit(cardNumber,saleNumber) {
    var toIndex = layer.open({
		type : 2,
		title : '退款',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1500px', '520px' ],
		content : prefix + '/edit/'+cardNumber+'/'+ saleNumber // iframe的url
	});
    layer.full(toIndex)
}

function tuikuan(cardNumber,saleNumber) {
    layer.confirm('确定要退款？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/tuikuan",
            type : "post",
            data : {
                'cardNumber' : cardNumber,
				'saleNumber' : saleNumber
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


function detail(cardNumber,saleNumber,costId) {
    var toIndex = layer.open({
        type : 2,
        title : '详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '1500px', '520px' ],
        content : prefix + '/detail/' + cardNumber+'/'+ saleNumber+'/'+costId // iframe的url
    });
    layer.full(toIndex)
}

function dayin(type,saleNumber){
	if (type == "检查单"){
        window.open("/information/settlement/jianchadayin?saleNumber="+saleNumber);
	} else if (type == "配镜单") {
        window.open("/information/settlement/peijingdan?saleNumber="+saleNumber);
	}
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