$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var jdjSphRight1 = $("#jdjSphRight1").val();
	var jdjCylRight1 = $("#jdjCylRight1").val();
	var jdjZxRight1 = $("#jdjZxRight1").val();
	var jdjSphLeft1 = $("#jdjSphLeft1").val();
	var jdjCylLeft1 = $("#jdjCylLeft1").val();
	var jdjZxLeft1 = $("#jdjZxLeft1").val();
	if ('' == jdjSphRight1 || '' == jdjCylRight1 || '' == jdjZxRight1
		|| '' == jdjSphLeft1 || '' == jdjCylLeft1 || '' ==jdjZxLeft1){
		return layer.alert("请检验是否准确")
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/examine/update",
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
				required : icon + "请输入名字"
			}
		}
	})
}