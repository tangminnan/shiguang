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
    alert(eyeStyle)

    if (eyeStyle==3){//镜片
    	var rightNum =$("#rightNum").val();
    	var leftNum =$("#leftNum").val();
    	var timetime =$("#timetime").val();
		if (rightNum=="" || leftNum=="" ){
			layer.alert("请添加商品！")
		}else if (timetime==""){
		    layer.alert("请选择取镜时间！")
        } else {
            $.ajax({
                cache : true,
                type : "POST",
                url : "/stock/weiwaishuju/save",
                data : $('#signupForm').serialize(),// 你的formid
                async : false,
                error: function (request) {
                    parent.layer.alert("Connection error");
                },
                success: function (data) {
                    if (data.code == 0) {
                        parent.layer.msg("操作成功");
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
        }else if (eyeStyle==4){//隐形
        var rightNumyx =$("#rightNumyx").val();
        var leftNumyx =$("#leftNumyx").val();
        var timetime =$("#timetime").val();
        if (rightNumyx=="" || leftNumyx=="" ){
            layer.alert("请添加商品！")
        }else if (timetime==""){
            layer.alert("请选择取镜时间！")
        }else {
            $.ajax({
                cache : true,
                type : "POST",
                url : "/stock/weiwaishuju/save",
                data : $('#signupForm').serialize(),// 你的formid
                async : false,
                error: function (request) {
                    parent.layer.alert("Connection error");
                },
                success: function (data) {
                    if (data.code == 0) {
                        parent.layer.msg("操作成功");
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
    }

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