$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var formData = new FormData(document.getElementById("signupForm"));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/mfrs/company/save",
		//data : $('#signupForm').serialize(),// 你的formid
        data : formData,// 你的formid
		async : false,
        processData:false,
        contentType:false,
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
			},
            province : {
                required : true
            },
            telephone : {
                required : true
            }
		},
		messages : {
			name : {
				required : icon + "请输入公司名称"
			},
            province : {
                required : icon + "请选择所属区域"
            },
            telephone : {
                required : icon + "请输入公司电话"
            }
		}
	})
}