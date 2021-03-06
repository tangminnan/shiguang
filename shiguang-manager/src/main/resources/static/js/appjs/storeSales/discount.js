$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var saleAccount = $("#saleAccount").val();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/store/saveDiscount",
		data : {"saleAccount":saleAccount},// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
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