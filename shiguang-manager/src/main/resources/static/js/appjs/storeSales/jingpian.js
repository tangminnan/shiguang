
var prefix = "/information/store"
$(function() {
    $('#exampleTable').bootstrapTable('hideColumn', 'sphqj');
    $('#exampleTable').bootstrapTable('hideColumn', 'cylqj');
    $('#exampleTable').bootstrapTable('hideColumn', 'lightbelowqj');
    $('#exampleTable').bootstrapTable('hideColumn', 'refractivity');
    $('#exampleTable').bootstrapTable('hideColumn', 'light');
    $('#exampleTable').bootstrapTable('hideColumn', 'lens');
    $('#exampleTable').bootstrapTable('hideColumn', 'gradual');
    $('#exampleTable').bootstrapTable('hideColumn', 'function');
	load();
});
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/jingpianlist", // 服务器数据的加载地址
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
                                checkbox : true
                            },
								{
									field : 'producNum',
									title : '商品代码',
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
									align : 'center'
								},
								{
									field : 'sph',
									title : '球镜',
									align : 'center'
								},
								{
									field : 'cyl',
									title : '柱镜',
									align : 'center'
								},
								{
									field : 'lightbelow',
									title : '下加光',
									align : 'center'

								},
								{
									field : 'refractivity',
									title : '折射率',
									align : 'center'
								},
								{
									field : 'light',
									title : '光度分类',
									align : 'center'
								},
								{
									field : 'lens',
									title : '材料分类',
									align : 'center'
								},
                            {
                                field : 'sphqj',
                                title : '球镜区间',
                                align : 'center'
                            },
                            {
                                field : 'cylqj',
                                title : '柱镜区间',
                                align : 'center'
                            },
                            // {
                            //     field : '0',
                            //     title : '轴位',
                            //     align : 'center'
                            // },
                            {
                                field : 'lightbelowqj',
                                title : '下加光区间',
                                align : 'center'
                            },
                            {
                                field : 'refractivity',
                                title : '折射率',
                                align : 'center'
                            },
                            {
                                field : 'light',
                                title : '光度分类',
                                align : 'center'
                            },
                            {
                                field : 'lens',
                                title : '材料分类',
                                align : 'center'
                            },
                            {
                                field : 'gradual',
                                title : '渐进片分类',
                                align : 'center'
                            },
                            {
                                field : 'function',
                                title : '镜片功能',
                                align : 'center'
                            }
						]
					});
}
function reLoad() {
    var dzType = $("#dzType").val();
	$('#exampleTable').bootstrapTable('refresh');
    if(dzType == 1){
        $('#exampleTable').bootstrapTable('hideColumn', 'sph');
        $('#exampleTable').bootstrapTable('hideColumn', 'cyl');
        $('#exampleTable').bootstrapTable('hideColumn', 'lightbelow');
        $('#exampleTable').bootstrapTable('hideColumn', 'refractivity');
        $('#exampleTable').bootstrapTable('hideColumn', 'light');
        $('#exampleTable').bootstrapTable('hideColumn', 'lens');
        $('#exampleTable').bootstrapTable('showColumn', 'sphqj');
        $('#exampleTable').bootstrapTable('showColumn', 'cylqj');
        $('#exampleTable').bootstrapTable('showColumn', 'lightbelowqj');
        $('#exampleTable').bootstrapTable('showColumn', 'refractivity');
        $('#exampleTable').bootstrapTable('showColumn', 'light');
        $('#exampleTable').bootstrapTable('showColumn', 'lens');
        $('#exampleTable').bootstrapTable('showColumn', 'gradual');
        $('#exampleTable').bootstrapTable('showColumn', 'function');
    } else {
        $('#exampleTable').bootstrapTable('showColumn', 'sph');
        $('#exampleTable').bootstrapTable('showColumn', 'cyl');
        $('#exampleTable').bootstrapTable('showColumn', 'lightbelow');
        $('#exampleTable').bootstrapTable('showColumn', 'refractivity');
        $('#exampleTable').bootstrapTable('showColumn', 'light');
        $('#exampleTable').bootstrapTable('showColumn', 'lens');
        $('#exampleTable').bootstrapTable('hideColumn', 'sphqj');
        $('#exampleTable').bootstrapTable('hideColumn', 'cylqj');
        $('#exampleTable').bootstrapTable('hideColumn', 'lightbelowqj');
        $('#exampleTable').bootstrapTable('hideColumn', 'refractivity');
        $('#exampleTable').bootstrapTable('hideColumn', 'light');
        $('#exampleTable').bootstrapTable('hideColumn', 'lens');
        $('#exampleTable').bootstrapTable('hideColumn', 'gradual');
        $('#exampleTable').bootstrapTable('hideColumn', 'function');
	}
}

function batchSelect() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    return rows;
	// if (rows.length == 0) {
	// 	layer.msg("请选择要删除的数据");
	// 	return;
	// }
	// layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
	// 	btn : [ '确定', '取消' ]
	// // 按钮
	// }, function() {
	// 	var ids = new Array();
	// 	// 遍历所有选择的行数据，取每条数据对应的ID
	// 	$.each(rows, function(i, row) {
	// 		ids[i] = row['id'];
	// 	});
	// 	$.ajax({
	// 		type : 'POST',
	// 		data : {
	// 			"ids" : ids
	// 		},
	// 		url : prefix + '/batchRemove',
	// 		success : function(r) {
	// 			if (r.code == 0) {
	// 				layer.msg(r.msg);
	// 				reLoad();
	// 			} else {
	// 				layer.msg(r.msg);
	// 			}
	// 		}
	// 	});
	// }, function() {
    //
	// });
}