
var prefix = "/information/saleGoods"
$(function() {
	//load();
});

function reLoad() {
	// $('#exampleTable').bootstrapTable('refresh');
   //var saleNum = $("#saleNum").val();
     var settleDateStart = $("#settleDateStart").val();
     var settleDateEnd = $("#settleDateEnd").val();
     var goodsType = $("#goodsType").val();
    window.open("/information/saleGoods/salegoodsList?settleDateStart="+settleDateStart+"&settleDateEnd="+settleDateEnd+"&goodsType="+goodsType);
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