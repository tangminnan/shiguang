var prefix = "/stock/weiwaishuju"
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
								offset:params.offset
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
																{
									field : 'id', 
									title : '委外数据id' 
								},
																{
									field : 'danjunum', 
									title : '销售单号' 
								},
																{
									field : 'danjuDay', 
									title : '单据日期' 
								},
																{
									field : 'departname', 
									title : '所属部门' 
								},
																{
									field : 'zhidanPeople', 
									title : '制单人' 
								},
																{
									field : 'jcStyle', 
									title : '镜片类型' 
								},
																{
									field : 'timetime', 
									title : '取镜时间' 
								},
																{
									field : 'danjuStyle', 
									title : '单据类型' 
								},
																{
									field : 'saleNumber', 
									title : '原配镜单' 
								},
																{
									field : 'weiwaiStyle', 
									title : '委外类型' 
								},
																{
									field : 'beizhu', 
									title : '备注' 
								},
																{
									field : 'rightsph', 
									title : '球镜OD' 
								},
																{
									field : 'leftsph', 
									title : '球镜OS' 
								},
																{
									field : 'rightcyl', 
									title : '柱镜OD' 
								},
																{
									field : 'leftcyl', 
									title : '柱镜OS' 
								},
																{
									field : 'rightzx', 
									title : '轴向OD' 
								},
																{
									field : 'leftzx', 
									title : '轴向OS' 
								},
																{
									field : 'rightAdd', 
									title : 'AddOD' 
								},
																{
									field : 'leftAdd', 
									title : 'AddOS' 
								},
																{
									field : 'rightSlj', 
									title : '三棱镜OD' 
								},
																{
									field : 'leftSlj', 
									title : '三棱镜OS' 
								},
																{
									field : 'rightJd', 
									title : '基底OD' 
								},
																{
									field : 'leftJd', 
									title : '基底OS' 
								},
																{
									field : 'rightFartj', 
									title : '远瞳距OD' 
								},
																{
									field : 'leftFartj', 
									title : '远瞳距OS' 
								},
																{
									field : 'rightNeartj', 
									title : '近瞳距OD' 
								},
																{
									field : 'leftNeartj', 
									title : '近瞳距OS' 
								},
																{
									field : 'rightqulv', 
									title : '曲率OD' 
								},
																{
									field : 'leftqulv', 
									title : '曲率OS' 
								},
																{
									field : 'rightzj', 
									title : '直径OD' 
								},
																{
									field : 'leftzj', 
									title : '直径OS' 
								},
																{
									field : 'rightNum', 
									title : '商品代码OD' 
								},
																{
									field : 'leftNum', 
									title : '商品代码OS' 
								},
																{
									field : 'rightName', 
									title : '商品名称OD' 
								},
																{
									field : 'leftName', 
									title : '商品名称OS' 
								},
																{
									field : 'rightR', 
									title : '镜片型OD' 
								},
																{
									field : 'leftL', 
									title : '镜片型OS' 
								},
																{
									field : 'countr', 
									title : '数量OD' 
								},
																{
									field : 'countl', 
									title : '数量OS' 
								},
																{
									field : 'yaoqiur', 
									title : '要求OD' 
								},
																{
									field : 'yaoqiul', 
									title : '要求OS' 
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
document.onkeydown = function(e){
    if((e||event).keyCode==13)
        reLoad();
};
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