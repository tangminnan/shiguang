$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var positionOrder=document.getElementById('positionOrder').value;
	if (positionOrder==""){
		layer.alert("请选择仓位类型！")
	}else if (positionOrder != ""){
        $.ajax({
            cache : true,
            type : "POST",
            url : "/mfrs/position/save",
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

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            positionNum : {
				required : true
			},
            departNumber : {
                required : true
            },
            positionName : {
                required : true
            }
		},
		messages : {
            positionNum : {
				required : icon + "请输入仓位代码"
			},
            departNumber : {
				required : icon + "所属部门不能为空"
			},
            positionName : {
				required : icon + "请输入仓位名称"
			}
		}
	})
}