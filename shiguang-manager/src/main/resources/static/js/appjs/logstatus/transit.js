
var prefix = "/information/transit"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/transitlist", // 服务器数据的加载地址
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
                                saleNumber: $("#saleNumber").val(),
                                name:$("#name").val(),
                                phone1:$("#phone1").val()
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
									field : 'saleNumber', 
									title : '配镜单号'
								},
								{
									field : 'eyeType',
									title : '配镜类型'
								},
								{
									field : 'mirorAddress',
									title : '销售门店'
								},
								{
									field : 'mirorAddress',
									title : '取镜地点'
								},
																{
									field : 'memberName',
									title : '顾客姓名'
								},

								{
									field : 'peijingDate',
									title : '配镜日期'
								},
								{
									field : 'mirrorDate',
									title : '取镜日期'
								},
								{
									field : 'logStatus',
									title : '在途状态'
								},
								{
									field : 'processAsk',
									title : '加工要求'
								},
								{
									field : 'urgentStatus',
									title : '加急状态'
								},
							{
                                title : '操作',
                                field : 'saleNumber',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    var t = '<a class="btn btn-primary btn-xs" href="#" title="更改状态"  mce_href="#" ' +
                                            'onclick="edit(\''+value+'\')" style="text-decoration: none;">更改状态</a>';
                                    return t;
                                }
							}
						]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function peijingdan(saleNumber){
    window.open("/information/settlement/peijingdan?saleNumber="+saleNumber);
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
function edit(saleNumber) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + saleNumber // iframe的url
	});
}
function editFaliao(saleNumber) {
	layer.confirm('确定要发料？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/editFaliao",
			type : "post",
			data : {
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