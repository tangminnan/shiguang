$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var amountMoney = $("#amountMoney").val();
	var saleName = $("#saleName").val();
    layer.confirm("确认是否要结算", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
    	if (amountMoney == ""){
    		return layer.alert("请先下单")
		}
		if (saleName == ''){
    		return layer.alert("请选择销售人员")
		}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/storenew/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
            var cardNumber = $("#memberInumber").val();
            layer.open({
                type : 2,
                title : '结款',
                maxmin : true,
                shadeClose : false, // 点击遮罩关闭层
                area : [ '1500px', '520px' ],
                content : '/information/settlement/editMoney/'+cardNumber // iframe的url
            });
			// if (data.code == 0) {
            //     parent.layer.msg("操作成功");
            //     parent.reLoad();
            //     var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
            //     parent.layer.close(index);
			//
			// } else {
			// 	parent.layer.alert(data.msg)
			// }

		}
	});
    }, function() {

    });
}

function jiesuan(){
	alert(fdf)
    var cardNumber = $("#memberInumber").val();
    alert(cardNumber)
    var toIndex = layer.open({
        type : 2,
        title : '结算',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/settlement/editMoney/" + cardNumber // iframe的url
    });
    layer.full(toIndex)
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}