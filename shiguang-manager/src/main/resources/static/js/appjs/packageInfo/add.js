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
		url : "/information/package/save",
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
            packageName : {
				required : true
			},
            packageTime : {
                required : true
			},
            effectiveDate : {
                required : true
			},
            expiryDate : {
                required : true
			},
            store : {
                required : true
			}
		},
		messages : {
            packageName : {
				required : icon + "请输入套餐标题"
			},
            packageTime : {
                required : icon + "请输入套餐日期"
            },
            effectiveDate : {
                required : icon + "请输入生效日期"
            },
            expiryDate : {
                required : icon + "请输入截至日期"
            },
            store : {
                required : icon + "请选择活动门店"
            }
		}
	})
}