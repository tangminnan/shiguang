$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/card/save",
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
            cardMoney : {
				required : true
			},
            memberName : {
                required : true
            },
            password : {
                required : true
            }
		},
		messages : {
            cardMoney : {
				required : icon + "请输入储值金额"
			},
            memberName : {
                required : icon + "请选择会员姓名"
            },
            password : {
                required : icon + "请输入密码"
            }
		}
	})
}