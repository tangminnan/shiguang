
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
                                salenumbery:$('#salenumbery').val().trim(),
                                gkname:$('#gkname').val().trim(),
                                phone:$('#phone').val().trim(),
                                mfrsname:$('#mfrsname').val().trim(),
                                departname:$('#departname').val().trim(),
                                eyeStyle:$('#eyeStyle').val().trim(),

                                day1:$('#day1').val().trim(),
                                day2:$('#day2').val().trim(),
                                status:$('#status').val().trim(),
                                shstatus:$('#shstatus').val().trim(),
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
								// 								{
								// 	field : 'id',
								// 	title : 'id'
								// },
								// {
								// 	field : 'danjuNumber',
								// 	title : '单据编号'
								// },
								{
									field : 'saleNumber',
									title : '销售单号'
								},
								{
									field : 'gkname',
									title : '会员姓名'
								},
								// {
								// 	field : 'hyknum',
								// 	title : '会员卡号'
								// },
								{
									field : 'phone',
									title : '电话'
								},
							{
									field : 'departname',
									title : '销售门店'
								},
							{
								field : 'eyeStyle',
								title : '订做类型',
								align : 'center',
								formatter : function(value, row, index) {
									if(value == 3){
										return '<span class="label">框镜订做</span>';
									}else if(value == 4){
										return '<span class="label">隐形订做</span>';
									}else if(value == 5){
                                        return '<span class="label">视光订做</span>';
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
							// {
							// 		field : 'danjuDay',
							// 		title : '单据日期'
							// 	},
							{
									field : 'shTime',
									title : '收货时间'
								},{
									field : 'pstime',
									title : '配送时间'
								},
							{
								field : 'shstatus',
								title : '操作状态',
								align : 'center',
								formatter : function(value, row, index) {
									// alert(value)
									if(value == '1'){
										// alert(row.returnzt);
										return '<span class="label">已退回</span>';

									}if (value == '0') {
										return '<span class="label">已配送</span>';
									}
								}
							},

                            {
                                title: '操作',
                                field: 'danjuNumber',
                                align: 'center',
                                formatter: function (value, row, index) {
                                    if (row.status == "1") {
                                        var a = '<span class="btn btn-primary btn-sm' + s_detial_h + '"  href="#" title="详情"  mce_href="#" onclick="detial(\''
                                            + row.saleNumber+" ','"+  row.danjuNumber+ '\')">详情</span> ';
                                        var f = '<span class="btn btn-success btn-sm' +s_userNum_h+ '" href="#" title="收货"  mce_href="#"   onclick="userNum(\''
                                            + row.saleNumber+" ','"+  row.danjuNumber + '\')">收货</span> ';
                                        var b = '<span class="btn btn-danger btn-sm' +s_remove_h+ '" href="#" title="删除"  mce_href="#"   onclick="remove(\''
                                            + row.saleNumber+" ','"+  row.danjuNumber + '\')">删除</span> ';
                                        var n = '';
                                        var c = '';
                                    } else if (row.status == "0") {
                                        var a = '<span class="btn btn-primary btn-sm' + s_detial_h + '"  href="#" title="详情"  mce_href="#" onclick="detial(\''
                                            + row.saleNumber+" ','"+  row.danjuNumber+ '\')">详情</span> ';
                                        var f = '';
                                        var b = '';
                                        if (row.shstatus==""){
											var n = '<span class="btn btn-info btn-sm' + s_psNum_h + '"   href="#" title="配送"  mce_href="#" onclick="psNum(\''
                                                + row.saleNumber+" ','"+  row.danjuNumber + '\')">配送</span> ';
											// var j = '<span class="btn btn-warning btn-sm"  href="#" title="退回"  mce_href="#" onclick="thNum(\''
											// 	+ row.saleNumber+" ','"+  row.danjuNumber +" ','"+  row.eyeStyle + '\')">退回</span> ';
                                            var c = '';
										}else {
											var n = '';
                                            var c = '<span class="btn btn-warning btn-sm' + s_code_h + '"    href="#" title="条码"  mce_href="#" onclick="code(\''
                                                + row.saleNumber+" ','"+  row.danjuNumber + '\')">条码</span> ';
										}


                                    }
                                    return a + f + n  +c +b;
                                }
                            }
								]
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
function detial(saleNumber,danjuNumber) {
    var toIndex = layer.open({
		type : 2,
		title : '详情',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/detial/' + saleNumber+"/"+danjuNumber // iframe的url
	});
    layer.full(toIndex)
}

function remove(saleNumber,danjuNumber) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'saleNumber' : saleNumber,
				'danjuNumber' : danjuNumber
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

function userNum(saleNumber,danjuNumber) {
	var status="0";
	if (status == "0"){
        var toIndex = layer.open({
			type : 2,
			title : '输入工号',
			maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content :"/stock/weiwai/userNum/"+saleNumber+"/"+ danjuNumber
		});
        layer.full(toIndex);

	}
}
//修改收货状态添加库存
function upshTime() {
	var danjuNumber = document.getElementById('danjuNumber').value;
	var saleNumber = document.getElementById('saleNumber').value;
	var username = document.getElementById('username').value;
	var status = "0";
	if (username !=""){

		$.ajax({
			url: "/stock/weiwai/updateStatus",
			type: "post",
			data: {
				'danjuNumber': danjuNumber,
				'status': status,
				'username':username,
				'saleNumber':saleNumber
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

//配送
function psNum(saleNumber,danjuNumber ) {
	var shstatus="0";
	if (shstatus == "0"){
		// alert("输入工号")
		layer.open({
			type : 2,
			title : '输入工号',
			maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content :"/stock/weiwai/psNum/"+saleNumber+"/"+danjuNumber
		});

	}
}
function peisong() {
	var danjuNumber = document.getElementById('danjuNumber').value;
	var saleNumber = document.getElementById('saleNumber').value;
	var psname = document.getElementById('username').value;
	var shstatus = "0";
	if (username != "") {
		// alert(eyeStyle);
		$.ajax({
			url: "/stock/weiwai/editShouhuo",
			type: "post",
			data: {
				'danjuNumber': danjuNumber,
				'shstatus': shstatus,
				'psname': psname,
				'saleNumber': saleNumber
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

//退货
function thNum(salenumbery,danjuNumber) {
	var shstatus="0";
	if (shstatus == "0"){
		// alert("输入工号")
		layer.open({
			type : 2,
			title : '输入工号',
			maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content :"/stock/weiwai/userNumth/"+ salenumbery+'/'+danjuNumber
		});

	}
}
function tuihuo() {
	var danjuNumber = document.getElementById('danjuNumber').value;
	var salenumbery = document.getElementById('salenumbery').value;
	var psname = document.getElementById('username').value;
	var shstatus = "1";
	if (username != "") {
		// alert("退货");
		$.ajax({
			url: "/stock/weiwai/editTuihuo",
			type: "post",
			data: {
				'danjuNumber': danjuNumber,
				'shstatus': shstatus,
				'psname': psname,
				'salenumbery': salenumbery
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

//批量打印
function dayinList() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	var mfrsids="";
	var mfrsnames="";
    if (rows.length == 0) {
        layer.msg("请选择要批量打印的数据！");
        return;
    }else {
        var ids = new Array();
        var mfrsid = new Array();
        var danjuNumbers = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
            danjuNumbers[i] = row['danjuNumber'];
             mfrsid[i]=row['mfrsid'];
             mfrsids=mfrsid[0];
            mfrsnames=row['mfrsname'];
        });
        for (var i=0;i<mfrsid.length;i++){
            // alert(mfrsids);
            // alert(mfrsid[i]);
            if (mfrsids!=mfrsid[i]){
                return layer.alert("请选择同一个制造商！");
            }
		}
        window.open("/stock/weiwai/dayinList?ids="+ids+"&danjuNumbers="+danjuNumbers+"&mfrsid="+mfrsid+"&mfrsnames="+mfrsnames);
	}
}


//打印条码
function code(saleNumber,danjuNumber) {
    window.open("/stock/weiwai/code?saleNumber=" + saleNumber+"&danjuNumber="+danjuNumber);
}

function out(){
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("选择要导出的数据");
        return;
    }


    var ids = new Array();
    var mfrsid = new Array();
    var danjuNumbers = new Array();
    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(rows, function(i, row) {
        ids[i] = row['id'];
        danjuNumbers[i] = row['danjuNumber'];
        mfrsid[i]=row['mfrsid'];
        mfrsids=mfrsid[0];
        mfrsnames=row['mfrsname'];
    });
    for (var i=0;i<mfrsid.length;i++){
        // alert(mfrsids);
        // alert(mfrsid[i]);
        if (mfrsids!=mfrsid[i]){
            return layer.alert("请选择同一个制造商！");
        }
    }


    // var danjuNumbers=[];
    // var saleNumbers=[];
	var arrys=[];
    $.each(rows, function(i, row) {
        // danjuNumbers[i] = row['danjuNumber'];
        // saleNumbers[i] = row['saleNumber'];
		arrys[i]=row['danjuNumber']+row['saleNumber'];

    });
    window.location.href="/stock/weiwai/out?arrys="+arrys;
}

function outShiguangdz(){
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("选择要导出的数据");
        return;
    }


    var ids = new Array();
    var mfrsid = new Array();
    var danjuNumbers = new Array();
    // 遍历所有选择的行数据，取每条数据对应的ID
    $.each(rows, function(i, row) {
        ids[i] = row['id'];
        danjuNumbers[i] = row['danjuNumber'];
        mfrsid[i]=row['mfrsid'];
        mfrsids=mfrsid[0];
        mfrsnames=row['mfrsname'];
    });
    for (var i=0;i<mfrsid.length;i++){
        // alert(mfrsids);
        // alert(mfrsid[i]);
        if (mfrsids!=mfrsid[i]){
            return layer.alert("请选择同一个制造商！");
        }
    }


    // var danjuNumbers=[];
    // var saleNumbers=[];
    var arrys=[];
    $.each(rows, function(i, row) {
        // danjuNumbers[i] = row['danjuNumber'];
        // saleNumbers[i] = row['saleNumber'];
        arrys[i]=row['danjuNumber']+row['saleNumber'];

    });
    window.location.href="/stock/weiwai/outdz?arrys="+arrys;
}



























































































































// function dayinList() {
//     var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
//     if (rows.length == 0) {
//         layer.msg("请选择要批量打印的数据");
//         return;
//     }
//     layer.confirm("确认要打印选中的'" + rows.length + "'条数据吗?",
// 		{
//         btn : [ '确定', '取消' ]
//         // 按钮
// 		}
//     , function() {
//         var ids = new Array();
//         // 遍历所有选择的行数据，取每条数据对应的ID
//         $.each(rows, function(i, row) {
//             ids[i] = row['id'];
//         });
//             window.open("/stock/weiwai/dayinList");
//         })
//     //     var toIndex = layer.open({
//     //         type : 2,
//     //         title : '批量打印',
//     //         maxmin : true,
//     //         shadeClose : false, // 点击遮罩关闭层
//     //         area : [ '800px', '520px' ],
//     //         // content : prefix + '/dayinList' // iframe的url
//     //         content : window.open("/stock/weiwai/dayinList") // iframe的url
//     //     });
//     //     layer.full(toIndex)
//     // });
// }
