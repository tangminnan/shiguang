
var prefix = "/stock/weiwai"
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
								// {
								// 	checkbox : true
								// },
								// 								{
								// 	field : 'id',
								// 	title : 'id'
								// },
								{
									field : 'danjuNumber',
									title : '单据编号'
								},
								{
									field : 'gkname',
									title : '会员姓名'
								},
								{
									field : 'hyknum',
									title : '会员卡号'
								},
								{
									field : 'phone',
									title : '电话'
								},
							// {
							// 		field : '',
							// 		title : '销售门店'
							// 	},
							{
								field : 'eyeStyle',
								title : '订做类型',
								align : 'center',
								formatter : function(value, row, index) {
									if(value == 3){
										return '<span class="label">框镜订做</span>';
									}else if(value == 4){
										return '<span class="label">隐形订做</span>';

									}
								}
							},
								{
									field : 'mfrsname',
									title : '制造商'
								},

							{
									field : 'zhidanPeople',
									title : '制单人'
								},
							{
									field : 'danjuDay',
									title : '单据日期'
								},

                            {
                                title: '操作',
                                field: 'danjuNumber',
                                align: 'center',
                                formatter: function (value, row, index) {
                                    if (row.status == "1") {
                                        var a = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                            + row.id + '\')">详情</span> ';
                                        var f = '<span class="btn btn-success btn-sm" href="#" title="确认收货"  mce_href="#" style="width:26%" onclick="userNum(\''
                                            + row.danjuNumber + '\')">确认收货</span> ';
                                        var n = '';
                                        var j = '';
                                    } else if (row.status == "0") {
                                        var a = '<span class="btn btn-primary btn-sm" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                            + row.id + '\')">详情</span> ';
                                        var f = '';
                                        var n = '<span class="btn btn-warning btn-sm"  href="#" title="配送"  mce_href="#" onclick="peisong(\''
                                            + row.goodsType+" ','"+ row.danjuNumber + '\')">配送</span> ';
                                        var j = '<span class="btn btn-warning btn-sm"  href="#" title="退回"  mce_href="#" onclick="peisong(\''
                                            + row.goodsType+" ','"+ row.danjuNumber + '\')">退回</span> ';

                                    }
                                    return a + f + n + j ;
                                }
                            }
								]
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
function detial(id) {
    var toIndex = layer.open({
		type : 2,
		title : '详情',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/detial/' + id // iframe的url
	});
    layer.full(toIndex)
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

function userNum(danjuNumber) {
	var status="0";
	if (status == "0"){
		// alert("输入工号")
		layer.open({
			type : 2,
			title : '输入工号',
			maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content :"/stock/weiwai/userNum/"+ danjuNumber
		});

	}
}
//修改启用状态
function upshTime() {
	var danjuNumber = document.getElementById('danjuNumber').value;
	var username = document.getElementById('username').value;
	var status = "0";
	if (username !=""){
		alert("qqqqqqqq");
		$.ajax({
			url: "/stock/weiwai/updateStatus",
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
	}


}