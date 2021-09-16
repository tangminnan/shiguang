$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    // alert($("#identityType").val());
    // alert($("#identityId").val());
    var idtentype = $("#identityType").val();
    var idetityId = $("#identityId").val();
        if (idtentype == "居民身份证"){
            var date = new Date();
            var nowyear = date.getFullYear();
            var year = idetityId.substring(6, 10);
            var month = idetityId.substring(10, 12);
            var day = idetityId.substring(12, 14);
            if(year>=nowyear){
                alert("出生年份应当小于当前年份！！！");
                return false;
            }
            if(month>=13){
                alert("出生月份应当小于13！！！");
                return false;
            }
            if(day>=32){
                alert("出生天数应当小于32！！！");
                return false;
            }
            if (idetityId.length<18 || idetityId.length>18){
                alert("身份证位数不正确！！！");
                return false;
            }
        }

    $.ajax({
        cache : true,
        type : "POST",
        url : "/information/member/update",
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

// function updates() {
//     $.ajax({
//         cache : true,
//         type : "POST",
//         url : "/information/member/update",
//         data : $('#signupForms').serialize(),// 你的formid
//         async : false,
//         error : function(request) {
//             parent.layer.alert("Connection error");
//         },
//         success : function(data) {
//             if (data.code == 0) {
//                 parent.layer.msg("操作成功");
//                 parent.reLoad();
//                 var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//                 parent.layer.close(index);
//
//             } else {
//                 parent.layer.alert(data.msg)
//             }
//
//         }
//     });
//
// }

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
            identityType : {
                required : true
            },
            identityId : {
                required : true
            }
            },
		messages : {
			name : {
				required : icon + "请输入名字"
			},
            identityType : {
                required : icon + "请选择证件类型"
            },
            identityId : {
                required : icon + "请输入证件号码"
            }
		}
	})
}