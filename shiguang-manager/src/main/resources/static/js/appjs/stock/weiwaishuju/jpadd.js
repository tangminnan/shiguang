$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
        save();
	}
});
function save() {
    var eyeStyle=$('#eyeStyle').val();
    var number =$('#number').val();
    var mfrsid =$('#mfrsid').val();
    var mfrsname =$('#mfrsname').val();
    var number =$('#number').val();
    $.ajax({
        cache : true,
        type : "POST",
        url: "/stock/weiwaishuju/save",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                window.localStorage.setItem("number",number);
                window.localStorage.setItem("eyeStyle",eyeStyle);
                window.localStorage.setItem("mfrsid",mfrsid);
                window.localStorage.setItem("mfrsname",mfrsname);
                window.localStorage.setItem("number",number);
                var index1 = window.parent.layer.getFrameIndex(window.name); // 获取窗口索引
                // 获取窗口索引
                window.parent.layer.close(index1);
                window.parent.location.reload();
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