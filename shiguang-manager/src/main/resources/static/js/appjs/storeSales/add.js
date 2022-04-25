$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
var flag = '1';
function save() {
	var amountMoney = $("#amountMoney").val();
	var saleName = $("#saleName").val();
	var newOld = $("#newOld").val();
    var chufangid = $("[name=chufang]:checked").val();
    layer.confirm("确认是否要结算", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
    	// if (chufangid == '2' && newOld == ""){
    	// 	return layer.alert("请选择院区")
		// }
    	// if (amountMoney == "" || amountMoney == 0){
    	// 	return layer.alert("请先下单")
		// }
		if (saleName == ''){
    		return layer.alert("请选择销售人员")
		}
		if(flag == '1'){
            $.ajax({
                cache : true,
                type : "POST",
                url : "/information/store/save",
                data : $('#signupForm').serialize(),// 你的formid
                async : false,
                error : function(request) {
                    parent.layer.alert("Connection error");
                },
                success : function(data) {
                    if (data.code == 0) {
                    	flag = '2';
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

    }, function() {

    });
}

function jiesuan(){
	alert(fdf)
    var cardNumber = $("#memberInumber").val();
    alert(cardNumber)
    var toIndex = layer.open({
        type : 2,
        title : '结算',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/information/settlement/editMoney/" + cardNumber // iframe的url
    });
    layer.full(toIndex)
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