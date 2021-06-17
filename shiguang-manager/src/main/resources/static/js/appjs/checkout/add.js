$().ready(function() {
    cardNumber = $("#cardNumber").val();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function ObjData(key,value){
    this.Key=key;
    this.Value=value;
}
var cardNumber= "";
var codeall = [];
// var nameall = [];
// var moneyall = [];
var postData="";
function getClick(obj) {
	console.log($(obj).val())
    var code =  $(obj).parent().siblings("[name='shorthandCode']").text();
    var costname = $(obj).parent().siblings("[name='costName']").text();
    var costMoney = $(obj).parent().siblings("[name='costMoney']").text();

    var s1=new ObjData("code",code);
    var s2=new ObjData("costname",costname);
    var s3=new ObjData("costMoney",costMoney);
    var jsonData = JSON.stringify(codeall);
    if (obj.checked == true){
            codeall.push(s1);
            codeall.push(s2);
            codeall.push(s3);

	} else if (obj.checked == false){
        var num;
        var ss;
		for (var i=0;i<codeall.length;i++){
        	if (s1.Value == codeall[i].Value){
        		 num = i;
        		break;
			}
		}
        codeall.splice(num,3);
	}

    // codeall.push(s2);
    // codeall.push(s3);
    // codeall.push(code);
    // codeall.push(costname);
    // codeall.push(costMoney);
     postData =  JSON.stringify(codeall);
}

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/cost/save",
		//data : $('#signupForm').serialize(),// 你的formid
		data: {"cardNumber":cardNumber,"codeall":postData},
        dataType:"json",
        traditional:true,//防止深度序列化
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
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}