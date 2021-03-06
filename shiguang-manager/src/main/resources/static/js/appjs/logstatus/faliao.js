
var prefix = "/information/logstatus"
$(function() {
	load();
});

function load() {
	$('#exampleTable1')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/faliaolist", // 服务器数据的加载地址
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
                                classtype:$("#classtype").val(),
                                memberName:$('#memberName').val(),
                                phone:$('#phone').val()
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
									field : 'saleNumber', 
									title : '配镜单号'
								},
																{
									field : 'memberName',
									title : '顾客姓名'
								},
								{
									field : 'mirorAddress',
									title : '销售门店'
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
									field : 'processAsk',
									title : '加工要求'
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										// var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
										// 		+ row.id
										// 		+ '\')"><i class="fa fa-edit"></i></a> ';
                                        var d;
										if (row.classTypeFL == '2'){
                                            d = '<a class="btn btn-primary btn-xs" href="#" title="详情"  mce_href="#" onclick="detail(\''
                                                + row.saleNumber
                                                + '\')"  style="text-decoration: none;">详情</a> ';
										} else {
                                            d = '<a class="btn btn-primary btn-xs" href="#" title="发料"  mce_href="#" onclick="editFaliao(\''
                                                + row.saleNumber
                                                + '\')"  style="text-decoration: none;">发料</a> ';
										}
										return  d ;
									}
								} ]
					});
    $('#exampleTable2')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/yifaliaolist", // 服务器数据的加载地址
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
                        classtype:$("#classtype").val(),
                        memberName:$('#memberName').val(),
                        phone:$('#phone').val()
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
                        field : 'saleNumber',
                        title : '配镜单号'
                    },
                    {
                        field : 'memberName',
                        title : '顾客姓名'
                    },
                    {
                        field : 'mirorAddress',
                        title : '销售门店'
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
                        field : 'processAsk',
                        title : '加工要求'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            // var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                            // 		+ row.id
                            // 		+ '\')"><i class="fa fa-edit"></i></a> ';
                            var d;
                            if (row.classTypeFL == '2'){
                                d = '<a class="btn btn-primary btn-xs" href="#" title="详情"  mce_href="#" onclick="detail(\''
                                    + row.saleNumber
                                    + '\')"  style="text-decoration: none;">详情</a> ';
                            }
                            return  d ;
                        }
                    } ]
            });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
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

function detail(saleNumber){
	window.open("/information/settlement/peijingdan?saleNumber="+saleNumber);
}

function editFaliao(saleNumber) {
	var toIndex = layer.open({
		type : 2,
		title : '发料',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + saleNumber // iframe的url
	});
	layer.full(toIndex);
}
// function editFaliao(saleNumber) {
//     layer.open({
//         type : 2,
//         title : '发料',
//         maxmin : true,
//         shadeClose : false, // 点击遮罩关闭层
//         area : [ '800px', '520px' ],
//         content : prefix + '/editFaliao/' + saleNumber // iframe的url
//     });
	// layer.confirm('确定要发料？', {
	// 	btn : [ '确定', '取消' ]
	// }, function() {
	// 	$.ajax({
	// 		url : prefix+"/editFaliao",
	// 		type : "post",
	// 		data : {
	// 			'saleNumber' : saleNumber
	// 		},
	// 		success : function(r) {
	// 			if (r.code==0) {
	// 				layer.msg(r.msg);
	// 				reLoad();
	// 			}else{
	// 				layer.msg(r.msg);
	// 			}
	// 		}
	// 	});
	// })
// }

function resetPwd(id) {
}
function batchFaliao() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要发料的数据");
		return;
	}
	layer.confirm("确认要发料选中的'" + rows.length + "'条数据吗?", {
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
			url : prefix + '/batchFaliao',
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