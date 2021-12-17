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
		url : "/information/settlement/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				//parent.reLoad();
                //$('#exampleTable').bootstrapTable('refresh');
				//var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                var index1 = window.parent.parent.layer.getFrameIndex(window.name); // 获取窗口索引
				// parent.layer.close(index);
                // 获取窗口索引
                window.parent.parent.layer.close(index1);
                window.parent.parent.location.reload();
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
            payModel : {
                required : true
            },
            modelMoney :{
                required : true
			},
            payMoney : {
                required : true
            },
            payWay : {
                required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			},
            payModel : {
                required : icon + "请选择支付方式"
            },
            modelMoney :{
                required : icon + "请输入缴费金额"
            },
            payMoney : {
                required : icon + "请输入缴费金额"
            },
            payWay : {
                required : icon + "请选择付款方式"
            }
		}
	})
}