$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
        save();
	}
});
function save() {
    var weiwaiStyle = $("#weiwaiStyle option:selected").val();
	var eyeStyle=$('#eyeStyle').val();
    var number =$('#number').val();
    var mfrsid =$('#mfrsid').val();
    var mfrsname =$('#mfrsname').val();
    var gkname =$('#gkname').val();
    var hyknum =$('#hyknum').val();
    var phone =$('#phone').val();
    var saleNumber =$('#saleNumber').val();
    if (eyeStyle==3){
    	var rightNum =$("#rightNum").val();
    	var leftNum =$("#leftNum").val();
    	var timetime =$("#timetime").val();
		if (rightNum=="" && leftNum=="" ){
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
                        window.localStorage.setItem("number",number);
                        window.localStorage.setItem("eyeStyle",eyeStyle);
                        window.localStorage.setItem("mfrsid",mfrsid);
                        window.localStorage.setItem("mfrsname",mfrsname);
                        window.localStorage.setItem("gkname",gkname);
                        window.localStorage.setItem("hyknum",hyknum);
                        window.localStorage.setItem("phone",phone);
                        window.localStorage.setItem("saleNumber",saleNumber);
                        var index1 = window.parent.layer.getFrameIndex(window.name);
                        window.parent.layer.close(index1);
                        window.parent.location.reload();
                    } else {
                        parent.layer.alert(data.msg)
                    }

                }

            });
		}
        }else if (eyeStyle==4){
        var rightNumyx =$("#rightNumyx").val();
        var leftNumyx =$("#leftNumyx").val();
        var timetime =$("#timetime").val();
        if (rightNumyx=="" && leftNumyx=="" ){
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
                        window.localStorage.setItem("number",number);
                        window.localStorage.setItem("eyeStyle",eyeStyle);
                        window.localStorage.setItem("mfrsid",mfrsid);
                        window.localStorage.setItem("mfrsname",mfrsname);

                        window.localStorage.setItem("gkname",gkname);
                        window.localStorage.setItem("hyknum",hyknum);
                        window.localStorage.setItem("phone",phone);

                        window.localStorage.setItem("saleNumber",saleNumber);
                        var index1 = window.parent.layer.getFrameIndex(window.name);
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