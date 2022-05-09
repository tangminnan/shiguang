
var prefix = "/stock/pidiao"
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
                                pidiaoNumber:$('#pidiaoNumber').val().trim(),
                                inPositionid:$('#inPositionid').val().trim(),
                                outPositionid:$('#outPositionid').val().trim(),
                                day1:$('#day1').val().trim(),
                                day2:$('#day2').val().trim(),
                                status:$('#status').val().trim()
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
								// 	title : '批调id'
								// },
																{
									field : 'pidiaoNumber',
									title : '批调单号'
								},
								// 								{
								// 	field : 'guanlianNumber',
								// 	title : '关联单号'
								// },
																{
									field : 'outcw',
									title : '发出仓位'
								},
								// 								{
								// 	field : 'outPosition',
								// 	title : '发出仓位'
								// },
								// 								{
								// 	field : 'inPosition',
								// 	title : '接收仓位'
								// },
								// 								{
								// 	field : 'inCompany',
								// 	title : '接收公司'
								// },
																{
									field : 'incw',
									title : '接收仓位'
								},
																{
									field : 'zhidanPeople', 
									title : '制单人' 
								},
																{
									field : 'danjuDay', 
									title : '单据日期' 
								},
								// 								{
								// 	field : 'outsourcingNumber',
								// 	title : '委外收货单'
								// },

								// 								{
								// 	field : 'goodsNum',
								// 	title : '商品代码'
								// },
								// 								{
								// 	field : 'goodsName',
								// 	title : '商品名称'
								// },
								// 								{
								// 	field : 'producFactory',
								// 	title : '型号'
								// },
								// 								{
								// 	field : 'needCount',
								// 	title : '需求数量'
								// },
								// 								{
								// 	field : 'goodsCount',
								// 	title : '可调用数量'
								// },
								// 								{
								// 	field : 'useCount',
								// 	title : '批调数量'
								// },
								// 								{
								// 	field : 'goodsCode',
								// 	title : '商品条码'
								// },
								// 								{
								// 	field : 'batch',
								// 	title : '批号'
								// },
								// 								{
								// 	field : 'zhuceNumber',
								// 	title : '注册证号'
								// },
								// 								{
								// 	field : 'produceDay',
								// 	title : '生产日期'
								// },
								// 								{
								// 	field : 'useday',
								// 	title : '效期'
								// },
								// 								{
								// 	field : 'allCount',
								// 	title : '合计'
								// },
                            {
                                field : 'status',
                                title : '收货状态',
                                align : 'center',
                                formatter : function(value, row, index) {
                                    if(value == '1' && row.returnzt == "0"){
                                        // alert(row.returnzt);
                                        return '<span class="label">已退回</span>';

                                    }else if(value == '1'){
                                        return '<span class="label">未收货</span>';

                                    } if (value == '0') {
                                        return '<span class="label">已收货</span>';
                                    }
                                }
                            },

															{
									field : 'shTime',
									title : '收货时间'
								},

                            								{
                            	field : 'beizhu',
                            	title : '备注'
                            },
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
                                        // alert(row.status+"status");
                                        // alert(row.returnzt+"returnzt");
                                        // alert(row.flags+"flags");
                                        if(row.status =="0" || row.returnzt=="0" ){
                                            var e = '<span class="btn btn-primary btn-sm '+'" href="#" mce_href="#" title="详情" onclick="detials(\''
                                                + row.id
                                                + '\')">详情</span> ';
                                            var a='';
                                            var d ='';
                                            // var s ='';
                                            // alert("详情")
                                        }else if (row.status == "1" || row.returnzt=="1") {
                                            if (row.flags == "1") {
                                                var e = '<span class="btn btn-primary btn-sm ' + '" href="#" mce_href="#" title="详情" onclick="detials(\''
                                                    + row.id
                                                    + '\')">详情</span> ';
                                                var a = '';
                                                var d = '';
                                                // var s = '';
                                                // alert("flages==1+详情")
                                            } else if (row.flags == "0") {
                                                // var s = '<span class="btn btn-warning btn-sm '+s_edit_h+ '" href="#" mce_href="#" title="修改" onclick="edit(\''
                                                //     + row.id
                                                //     + '\')">修改</span> ';
                                                var e = '<span class="btn btn-primary btn-sm '+ '" href="#" mce_href="#" title="详情" onclick="detials(\''
                                                    + row.id
                                                    + '\')">详情</span> ';
                                                var a = '<span class="btn btn-success btn-sm" href="#" title="确认收货"  mce_href="#" onclick="userNum(\''
                                                    + row.pidiaoNumber + '\')">确认收货</span> ';
                                                var d = '<span class="btn btn-danger btn-sm '     + '" href="#" title="退回"  mce_href="#" onclick="remove(\''
                                                    + row.pidiaoNumber
                                                    + '\')">退回</span> ';
                                                // alert("flages==0+详情+收货")
                                            }

                                        }else if (row.returnzt == "0"){
                                            // alert("空")
                                        }

										return e + a + d;
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
    var toIndex = layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
    layer.full(toIndex);
}
function edit(id) {
    // alert("修改")
    var toIndex = layer.open({
		type : 2,
		title : '修改',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
    layer.full(toIndex);
}
function detials(id) {
    // alert("详情")
    var toIndex = layer.open({
        type : 2,
        title : '详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/detials/' + id // iframe的url
    });
    layer.full(toIndex);
}
function userNum(pidiaoNumber) {
    var status="0";
    if (status == "0"){
        // alert("输入工号")
        layer.open({
            type : 2,
            title : '输入工号',
            maxmin : true,
            shadeClose : false, // 点击遮罩关闭层
            area : [ '800px', '520px' ],
            content :"/stock/pidiao/userNum/"+ pidiaoNumber
        });

    }
}
//修改启用状态
function upshTime() {
	// alert("修改启用状态")
    var pidiaoNumber = document.getElementById('pidiaoNumber').value;
    var username = document.getElementById('username').value;
    // alert(username);
    var status = "0";
    if (username !=""){
        $.ajax({
            url: "/stock/pidiao/updateStatus",
            type: "post",
            data: {
                'pidiaoNumber': pidiaoNumber,
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
        // return this;
    }


}

function remove(pidiaoNumber,useCount) {
	layer.confirm('确定要退回选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {

		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'pidiaoNumber' : pidiaoNumber,
                'useCount' : useCount
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




function showCol() {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    // alert(JSON.stringify(check));
    $.each(check, function(i, row) {
        // ids[i] = row['id'];

        var obj = {};
        // var rowstr = $(this).parent("td").parent("tr");
		//———获取当前系统时间—————
        var timeNow = new Date();
        var year = timeNow.getFullYear();
        var month = timeNow.getMonth() + 1 > 10 ? timeNow.getMonth() + 1 : '0' + (timeNow.getMonth() + 1);
        var date = timeNow.getDate() > 10 ? timeNow.getDate() : "0" + timeNow.getDate();
        obj.createTime = year + "-" + month + "-" + date;

        if(null == row['goodsNum']){
            var goodsNum ="";
        }else {
            var goodsNum = row['goodsNum'];
        }

        if(null == row['goodsCode']){
            var goodsCode  ="";
        }else {
            var goodsCode = row['goodsCode'] ;
        }

        if(null == row['goodsName']){
            var goodsName  ="";
        }else {
            var goodsName = row['goodsName'] ;

        }
        if(null == row['goodsCount']){
            var goodsCount  ="";
        }else {
            var goodsCount = row['goodsCount'];
        }

        if(null == row['gdname']){
            var gdname  ="";
        }else {
            var gdname = row['gdname'] ;
        }
        if(null == row['goods']){
            var goods  ="";
        }else {
            var goods = row['goods'] ;
        }

        if(null == row['mfrsname']){
            var mfrsname  ="";
        }else {
            var mfrsname = row['mfrsname'] ;
        }

        if(null == row['factory']){
            var factory  ="";
        }else {
            var factory = row['factory'] ;
        }

        if(null == row['retailPrice']){
            var retailPrice  ="";
        }else {
            var retailPrice = row['retailPrice'] ;
        }

        if(null == row['priceSum']){
            var priceSum  ="";
        }else {
            var priceSum = row['priceSum'] ;
        }

        if(null == row['costPrice']){
            var costPrice  ="";
        }else {
            var costPrice = row['costPrice'] ;
        }

        if(null == row['costSum']){
            var costSum  ="";
        }else {
            var costSum = row['costSum'] ;
        }

        if(null == row['wholePrice']){
            var wholePrice  ="";
        }else {
            var wholePrice = row['wholePrice'] ;
        }

        if(null == row['wholeSum']){
            var wholeSum  ="";
        }else {
            var wholeSum = row['wholeSum'] ;
        }

        if(null == row['positionName']){
            var positionName  ="";
        }else {
            var positionName = row['positionName'] ;
        }

        if(null == row['batch']){
            var batch  ="";
        }else {
            var batch = row['batch'];
        }

        if(null == row['zhuceNumber']){
            var zhuceNumber  ="";
        }else {
            var zhuceNumber = row['zhuceNumber'] ;
        }

        if(null == row['produceDay']){
            var produceDay  ="";
        }else {
            var produceDay = row['produceDay'] ;
        }

        if(null == row['useday']){
            var useday  ="";
        }else {
            var useday = row['useday'] ;
        }

        if(null == row['classtype']){
            var classtype  ="";
        }else {
            var classtype = row['classtype'] ;
        }













        obj.goodsNum = goodsNum;
        obj.goodsCode = goodsCode;
        obj.goodsName = goodsName;
        obj.goodsCount = goodsCount;
        obj.gdname = gdname;
        obj.goods = goods;
        obj.factory = factory;
        obj.mfrsname = mfrsname;

        obj.retailPrice = retailPrice;
        obj.priceSum = priceSum;
        obj.costPrice = costPrice;
        obj.costSum = costSum;
        obj.wholePrice = wholePrice;
        obj.wholeSum = wholeSum;

        obj.positionName = positionName;
        obj.batch = batch;
        obj.zhuceNumber = zhuceNumber;
        obj.produceDay = produceDay;
        obj.useday = useday;
        obj.classtype = classtype;

        if(null == row['mfrsid']){
            var mfrsid  ="";
        }else {
            var mfrsid = row['mfrsid'] ;
        }

        obj.mfrsid = mfrsid;

        if(null == row['brandname']){
            var brandname  ="";
        }else {
            var brandname = row['brandname'] ;
        }

        obj.brandname = brandname;


        if(null == row['unit']){
            var unit  ="";
        }else {
            var unit = row['unit'] ;
        }
        obj.unit = unit;

        if(null == row['goodsid']){
            var goodsid  ="";
        }else {
            var goodsid = row['goodsid'] ;
        }
        obj.goodsid = goodsid;

        if(null == row['goodsxinxiid']){
            var goodsxinxiid  ="";
        }else {
            var goodsxinxiid = row['goodsxinxiid'] ;
        }
        obj.goodsxinxiid = goodsxinxiid;

        if(null == row['danjuNumber']){
            var danjuNumber  ="";
        }else {
            var danjuNumber = row['danjuNumber'] ;
        }
        obj.danjuNumber = danjuNumber;

        obj.useCount = 1;


        objArray.push(obj);
    });
    return objArray;
}


function save() {
    var outDepartment = $("#outDepartment option:selected").text();
    var outPosition = $("#outPosition option:selected").text();
    var inCompany = $("#inCompany option:selected").text();
    var inDepartment = $("#inDepartment option:selected").text();
    if (outDepartment == "") {
        layer.alert("请选择发出部门！");
    } else if (outPosition == "") {
        layer.alert("请选择发出仓位！");
    }else if (inCompany == ""){
        layer.alert("请选择接收公司！");
    } else if (inDepartment == ""){
        layer.alert("请选择接收部门！");
    }
    else if (outDepartment != "" && outPosition != "" && inCompany != "" && inDepartment != "") {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/stock/pidiao/save",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            error: function (request) {
                parent.layer.alert("Connection error");
            },
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
    }
}
