
var prefix = "/jiancha/tryresults"
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
								{
									checkbox : true
								},
																{
									field : 'id', 
									title : '试戴镜结果id' 
								},
																{
									field : 'cardNumber', 
									title : '卡号' 
								},
																{
									field : 'ptometryNumber', 
									title : '验光号' 
								},
																{
									field : 'optometryName', 
									title : '验光师' 
								},
																{
									field : 'createTime', 
									title : '创建时间' 
								},
																{
									field : 'referralDoctor', 
									title : '转诊医生' 
								},
																{
									field : 'referral', 
									title : '转诊' 
								},
																{
									field : 'chiefComplaint', 
									title : '主诉' 
								},
																{
									field : 'sphereRighttry', 
									title : '球镜(右眼OD)' 
								},
																{
									field : 'sphereLefttry', 
									title : '球镜(左眼OS)' 
								},
																{
									field : 'cylinderRighttry', 
									title : '柱镜(右眼OD)' 
								},
																{
									field : 'cylinderLefttry', 
									title : '柱镜(左眼OS)' 
								},
																{
									field : 'axialRighttry', 
									title : '轴向(右眼-OD)' 
								},
																{
									field : 'axialLefttry', 
									title : '轴向(左眼OS)' 
								},
																{
									field : 'dvaRighttry', 
									title : 'DVA(右眼OD)' 
								},
																{
									field : 'dvaLefttry', 
									title : 'DVA(左眼OS)' 
								},
																{
									field : 'nvaRighttry', 
									title : 'NVA(OD)' 
								},
																{
									field : 'nvaLefttry', 
									title : 'NVA(OS)' 
								},
																{
									field : 'prismRighttry', 
									title : '三棱镜(OD)' 
								},
																{
									field : 'prismLefttry', 
									title : '三棱镜(OS)' 
								},
																{
									field : 'jdrTry', 
									title : '基底(OD)' 
								},
																{
									field : 'jdlTry', 
									title : '基底(OS)' 
								},
																{
									field : 'heightRighttry', 
									title : '瞳高(mm)(OD)' 
								},
																{
									field : 'heightLefttry', 
									title : '瞳高(mm)(OS)' 
								},
																{
									field : 'addRighttry', 
									title : 'Add(OD)' 
								},
																{
									field : 'addLefttry', 
									title : 'Add(OS)' 
								},
																{
									field : 'yuanRrty', 
									title : '远用瞳孔距(mm)(OD)' 
								},
																{
									field : 'yuanLrty', 
									title : '远用瞳孔距(mm)(OS)' 
								},
																{
									field : 'nearRighttry', 
									title : '近用瞳孔距(mm)(OD)' 
								},
																{
									field : 'nearLefttry', 
									title : '近用瞳孔距(mm)(OS)' 
								},
																{
									field : 'remarks', 
									title : '备注' 
								},
																{
									field : 'farLyou', 
									title : '裸眼视力远OU' 
								},
																{
									field : 'farLyod', 
									title : '裸眼视力远OD' 
								},
																{
									field : 'farLyos', 
									title : '裸眼视力远OS' 
								},
																{
									field : 'nearLyou', 
									title : '裸眼视力近OU' 
								},
																{
									field : 'nearLyod', 
									title : '裸眼视力近OD' 
								},
																{
									field : 'nearLyos', 
									title : '裸眼视力近OS' 
								},
																{
									field : 'farYjou', 
									title : '原镜视力远OU' 
								},
																{
									field : 'farYjod', 
									title : '原镜视力远OD' 
								},
																{
									field : 'farYjos', 
									title : '原镜视力远OS' 
								},
																{
									field : 'nearYjou', 
									title : '原镜视力近OU' 
								},
																{
									field : 'nearYjod', 
									title : '原镜视力近OD' 
								},
																{
									field : 'nearYjos', 
									title : '原镜视力近OS' 
								},
																{
									field : 'farXkou', 
									title : '小孔视力远OU' 
								},
																{
									field : 'farXkod', 
									title : '小孔视力远OD' 
								},
																{
									field : 'farXkos', 
									title : '小孔视力远OS' 
								},
																{
									field : 'nearXkou', 
									title : '小孔视力近OU' 
								},
																{
									field : 'nearXkod', 
									title : '小孔视力近OD' 
								},
																{
									field : 'nearXkos', 
									title : '小孔视力近OS' 
								},
																{
									field : 'dominantEye', 
									title : '主导眼' 
								},
																{
									field : 'axis', 
									title : '眼轴' 
								},
																{
									field : 'axisLeft', 
									title : '眼轴(OS)' 
								},
																{
									field : 'cornealFirstK1Right', 
									title : '角膜K1值(右眼)' 
								},
																{
									field : 'cornealLastK1Right', 
									title : '角膜K1值@A(右眼)' 
								},
																{
									field : 'cornealFirstK1Left', 
									title : '角膜K1值(左眼)' 
								},
																{
									field : 'cornealLastK1Left', 
									title : '角膜K1值@A(左眼)' 
								},
																{
									field : 'cornealFirstK2Right', 
									title : '角膜K2值(右眼)' 
								},
																{
									field : 'cornealLastK2Right', 
									title : '角膜K2值@A(右眼)' 
								},
																{
									field : 'cornealFirstK2Left', 
									title : '角膜K2值(左眼)' 
								},
																{
									field : 'cornealLastK2Left', 
									title : '角膜K2值@A(左眼)' 
								},
																{
									field : 'pjkOd2', 
									title : '平均k2OD' 
								},
																{
									field : 'pjkOs2', 
									title : '平均k2OS' 
								},
																{
									field : 'intraocularOd', 
									title : '眼压(OD)' 
								},
																{
									field : 'intraocularOs', 
									title : '眼压(OS)' 
								},
																{
									field : 'mydriasis', 
									title : '是否散瞳(0:散瞳前1:散瞳后)' 
								},
																{
									field : 'pharmacyId', 
									title : '散瞳用药id' 
								},
																{
									field : 'pharmacy', 
									title : '散瞳用药' 
								},
																{
									field : 'sphereRight', 
									title : '球镜(右眼OD)' 
								},
																{
									field : 'sphereLeft', 
									title : '球镜(左眼OS)' 
								},
																{
									field : 'cylinderRight', 
									title : '柱镜(右眼OD)' 
								},
																{
									field : 'cylinderLeft', 
									title : '柱镜(左眼OS)' 
								},
																{
									field : 'axialRight', 
									title : '轴向(右眼-OD)' 
								},
																{
									field : 'axialLeft', 
									title : '轴向(左眼OS)' 
								},
																{
									field : 'cornealAstigmatismOd', 
									title : '角膜散光(OD)' 
								},
																{
									field : 'cornealAstigmatismOs', 
									title : '角膜散光(OS)' 
								},
																{
									field : 'sphJyod', 
									title : '检影球镜(OD)' 
								},
																{
									field : 'sphJyos', 
									title : '检影球镜(OS)' 
								},
																{
									field : 'cylJyod', 
									title : '检影柱镜(OD)' 
								},
																{
									field : 'cylJyos', 
									title : '检影柱镜(OS)' 
								},
																{
									field : 'axialJyod', 
									title : '检影轴向(OD)' 
								},
																{
									field : 'axialJyos', 
									title : '检影轴向(OS)' 
								},
																{
									field : 'vaJyod', 
									title : '检影VA(OD)' 
								},
																{
									field : 'vaJyos', 
									title : '检影VA(OS)' 
								},
																{
									field : 'pdJyod', 
									title : '检影瞳距(mm)(OD)' 
								},
																{
									field : 'pdJyos', 
									title : '检影瞳距(mm)(OS)' 
								},
																{
									field : 'sphCpod', 
									title : '插片球镜(OD)' 
								},
																{
									field : 'sphCpos', 
									title : '插片球镜(OS)' 
								},
																{
									field : 'cylCpod', 
									title : '插片柱镜(OD)' 
								},
																{
									field : 'cylCpos', 
									title : '插片柱镜(OS)' 
								},
																{
									field : 'axialCpod', 
									title : '插片轴向(OD)' 
								},
																{
									field : 'axialCpos', 
									title : '插片轴向(OS)' 
								},
																{
									field : 'dvaCpod', 
									title : '插片DVA(OD)' 
								},
																{
									field : 'dvaCpos', 
									title : '插片DVA(OS)' 
								},
																{
									field : 'nvaCpod', 
									title : '插片NVA(OD)' 
								},
																{
									field : 'nvaCpos', 
									title : '插片NVA(OS)' 
								},
																{
									field : 'addCpod', 
									title : '插片add(OD)' 
								},
																{
									field : 'addCpos', 
									title : '插片add(OS)' 
								},
																{
									field : 'distanceOd', 
									title : '插片测量距离(OD)' 
								},
																{
									field : 'distanceOs', 
									title : '插片测量距离(OS)' 
								},
																{
									field : 'sphereRightz', 
									title : '球镜(右眼OD)' 
								},
																{
									field : 'sphereLeftz', 
									title : '球镜(左眼OS)' 
								},
																{
									field : 'cylinderRightz', 
									title : '柱镜(右眼OD)' 
								},
																{
									field : 'cylinderLeftz', 
									title : '柱镜(左眼OS)' 
								},
																{
									field : 'axialRightz', 
									title : '轴向(右眼-OD)' 
								},
																{
									field : 'axialLeftz', 
									title : '轴向(左眼OS)' 
								},
																{
									field : 'dvaRightz', 
									title : 'DVA(右眼OD)' 
								},
																{
									field : 'dvaLeftz', 
									title : 'DVA(左眼OS)' 
								},
																{
									field : 'nvaRightz', 
									title : 'NVA(OD)' 
								},
																{
									field : 'nvaLeftz', 
									title : 'NVA(OS)' 
								},
																{
									field : 'prismRightz', 
									title : '三棱镜(OD)' 
								},
																{
									field : 'prismLeftz', 
									title : '三棱镜(OS)' 
								},
																{
									field : 'jdrZ', 
									title : '基底(OD)' 
								},
																{
									field : 'jdlZ', 
									title : '基底(OS)' 
								},
																{
									field : 'addRightz', 
									title : 'Add(OD)' 
								},
																{
									field : 'addLeftz', 
									title : 'Add(OS)' 
								},
																{
									field : 'yuanRz', 
									title : '远用瞳孔距(mm)(OD)' 
								},
																{
									field : 'yuanLz', 
									title : '远用瞳孔距(mm)(OS)' 
								},
																{
									field : 'nearRightz', 
									title : '近用瞳孔距(mm)(OD)' 
								},
																{
									field : 'nearLeftz', 
									title : '近用瞳孔距(mm)(OS)' 
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