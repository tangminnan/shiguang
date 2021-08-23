$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    var ideentityType = $("input[name='ideentityType']:checked").val();
    var identityCard = $("input[name='identityCard']").val();
    if(ideentityType=="身份证"){
        var date = new Date();
        var nowyear = date.getFullYear();
        var year = identityCard.substring(6, 10);
        var month = identityCard.substring(10, 12);
        var day = identityCard.substring(12, 14);
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
        //var birthday = year+"-"+month+"-"+day
        //$("input[name='birthday']").val(birthday);
    }
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/member/save",
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
function saves() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/information/member/update",
        data : $('#signupForms').serialize(),// 你的formid
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
			name : {
				required : true
			},
            cardNumber : {
                required : true
			},
            sex : {
                required : true
			},
            birthdayYear : {
                required : true
            },
            birthdayMonth : {
                required : true
            },
            birthdayDay : {
                required : true
            },
            provinceName : {
                required : true
			},
            cityName : {
                required : true
            },
            areaName : {
                required : true
            },
            phone1 : {
                required : true
            }
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			},
            cardNumber : {
                required : icon + "请输入会员卡号"
            },
            sex : {
                required : icon + "请选择会员性别"
            },
            birthdayYear : {
                required : icon + "请输入会员出生日期"
            },
            birthdayMonth : {
                required : icon + "请输入会员出生日期"
            },
            birthdayDay : {
                required : icon + "请输入会员出生日期"
            },
            phone1 : {
                required : icon + "请输入手机号"
            },
            provinceName : {
                required : icon + "请选择省份"
            },
            cityName : {
                required : icon + "请选择城市"
            },
            areaName : {
                required : icon + "请选择市区(县)"
            },
            phone1 : {
                required : icon + "请输入联系方式"
            }
		}
	})
}