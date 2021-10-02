$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        saveCF();
    }
});

function saveCF() {
    var followTime= $('#followTime').val();
    var chufangType = $("#chufangType").val();
    // alert(followTime)
    if (chufangType == ""){
        return layer.alert("请选择处方类型！")
    }
    if (followTime == ""){
        return layer.alert("请选择复诊时间！")
    }
    $.ajax({
        cache: true,
        type: "POST",
        url: "/jiancha/result/save",
        data: $('#jielun').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                var index1 = window.parent.parent.layer.getFrameIndex(window.name); // 获取窗口索引
                // 获取窗口索引
                window.parent.parent.layer.close(index1);



                window.parent.parent.location.reload();
                // window.location.href="/information/optometryNew";
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#jielun").validate({
        rules: {
            name: {
                required: true
            }
        },
        messages: {
            name: {
                required: icon + "请输入姓名"
            }
        }
    })
}