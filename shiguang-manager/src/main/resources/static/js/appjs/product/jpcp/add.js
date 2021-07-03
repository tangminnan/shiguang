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
        url: "/product/jpcp/save",
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
            producName: {
                required: true
            },
            mfrsid: {
                required: true
            },
            factory: {
                required: true
            },

            proid: {
                required: true
            },
            unitid: {
                required: true
            },
            sphId: {
                required: true
            },
            cylId: {
                required: true
            },
            lightbelowId: {
                required: true
            },
            lensId: {
                required: true
            },
            batchid: {
                required: true
            },
            tax: {
                required: true
            },
            taxPrice: {
                required: true
            },
            tradePrice: {
                required: true
            },
            transferPrice: {
                required: true
            },
            retailPrice: {
                required: true
            }
        },
        messages: {
            producName: {
                required: icon + "请输入商品名称"
            },
            mfrsid: {
                required: icon + "请选择制造商"
            },

            proid: {
                required: icon + "请输入商品编号"
            },
            unitid: {
                required: icon + "请选择计量单位"
            },
            sphId: {
                required: icon + "请选择球镜"
            },
            cylId: {
                required: icon + "请选择柱镜"
            },
            lightbelowId: {
                required: icon + "请选择下加光"
            },
            lensId: {
                required: icon + "请选择材料分类"
            },
            batchid: {
                required: icon + "请选择批号管理"
            }

        }
    })
}