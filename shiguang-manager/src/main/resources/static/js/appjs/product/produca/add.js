$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/product/produca/save",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                //parent.reLoad();
                // var toIndex = layer.open({
                //     type: 2,
                //     title: '增加',
                //     maxmin: true,
                //     shadeClose: false, // 点击遮罩关闭层
                //     area: ['800px', '520px'],
                //     content:  '/product/produca/add' // iframe的url
                // });
                // layer.full(toIndex);
                 var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                // parent.layer.close(index);
                // adds();
                //$('div input').val('');
                //window.location.reload();
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
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