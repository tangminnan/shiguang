
var prefix = "/information/store"
$(function() {
    load();
});
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/jingjiapjlist", // 服务器数据的加载地址
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
                                producName:$('#producName').val(),
                                producNum:$('#producNum').val()
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
									field : 'producNum',
									title : '商品代码',
									align : 'center'
								},
								{
									field : 'producCode',
									title : '商品条码',
									align : 'center'
								},
								{
									field : 'producName',
									title : '商品名称',
									align : 'center'
								},
								{
									field : 'retailPrice',
									title : '销售价格',
									align : 'center',
								},
								{
									field : 'producFactory',
									title : '型号',
									align : 'center'
								},
								{
									field : 'partsStyle',
									title : '配件型',
									align : 'center'
								}
						]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

// function remove(id) {
// 	layer.confirm('确定要删除选中的记录？', {
// 		btn : [ '确定', '取消' ]
// 	}, function() {
// 		$.ajax({
// 			url : prefix+"/remove",
// 			type : "post",
// 			data : {
// 				'id' : id
// 			},
// 			success : function(r) {
// 				if (r.code==0) {
// 					layer.msg(r.msg);
// 					reLoad();
// 				}else{
// 					layer.msg(r.msg);
// 				}
// 			}
// 		});
// 	})
// }

function resetPwd(id) {
}
function batchSelect() {
	var obj = [];
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    	// $.each(rows, function(i, row) {
         //    obj.push(row);
    	// });
    // alert(rows.length)
    // sessionStorage.setItem("row",rows);
	return rows;
   // window.opener.goodsInfo(rows);
	// if (rows.length == 0) {
	// 	layer.msg("请选择要购买的镜架");
	// 	return;
	// }
	// layer.confirm("确认要购买选中的'" + rows.length + "'镜架吗?", {
	// 	btn : [ '确定', '取消' ]
	// // 按钮
	// }, function() {
	// 	var ids = new Array();
	// 	// 遍历所有选择的行数据，取每条数据对应的ID
	// 	$.each(rows, function(i, row) {
	// 		ids[i] = row['id'];
	// 	});
	// 	alert(JSON.stringify(rows))
     //    sessionStorage.setItem("row",rows);
     //    reLoad();
	// 	// $.ajax({
	// 	// 	type : 'POST',
	// 	// 	data : {
	// 	// 		"ids" : ids
	// 	// 	},
	// 	// 	url : prefix + '/batchRemove',
	// 	// 	success : function(r) {
	// 	// 		if (r.code == 0) {
	// 	// 			layer.msg(r.msg);
	// 	// 			reLoad();
	// 	// 		} else {
	// 	// 			layer.msg(r.msg);
	// 	// 		}
	// 	// 	}
	// 	// });
	// }, function() {
    //
	// });
}