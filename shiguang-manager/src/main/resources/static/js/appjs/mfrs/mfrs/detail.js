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
        url: "/mfrs/mfrs/save",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
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
        rules: {
            mfrsnum: {
                required: true
            },
            mfrsname: {
                required: true
            },
            mfrscontacts: {
                required: true
            },
            mfrsrealname: {
                required: true
            },
            mfrstelephone: {
                required: true
            },
            mfrsphone: {
                required: true
            },
            interest: {
                required: true
            },
            mfrsfax: {
                required: true
            }
        },
        messages: {
            mfrsnum: {
                required: icon + "请输入制造商代码"
            },
            mfrsname: {
                required: icon + "请输入制造商简称"
            },
            mfrscontacts: {
                required: icon + "请输入制造商联系人"
            },
            mfrsrealname: {
                required: icon + "请输入制造商全称"
            },
            mfrstelephone: {
                required: icon + "请输入制造商电话"
            },
            mfrsphone: {
                required: icon + "请输入联系人电话"
            },
            interest: {
                required: icon + "请选择商品类别"
            },
            mfrsfax: {
                required: icon + "请输入制造商传真"
            }
        }
    })
}