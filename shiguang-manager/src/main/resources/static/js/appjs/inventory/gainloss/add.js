$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var positionId = $("#positionId").val();
	var documentType = $("#documentType").val();
	var inventoryCount = $("#inventoryCount").val();
	alert(inventoryCount)
	if (positionId == ''){
		return alert("请选择盘点仓位")
	}
	if (documentType == ''){
		return alert("请选择盘盈或者盘亏")
	}
	if (inventoryCount == ''){
		return alert("请填写商品数量")
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/gainLoss/save",
		data : $('#signupForm').serialize(),// 你的formid
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