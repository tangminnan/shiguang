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
        url: "/product/yxdz/save",
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
            producFactory: {
                required: true
            },
            proid: {
                required: true
            },
            unitid: {
                required: true
            },
            sphUp: {
                required: true
            },
            sphDown: {
                required: true
            },
            sphSpan: {
                required: true
            },
            cylUp: {
                required: true
            },
            cylDown: {
                required: true
            },

            curvatureOne: {
                required: true
            },
            curvatureYi: {
                required: true
            },

            diameterOne: {
                required: true
            },
            diameterYi: {
                required: true
            },
            cylSpan: {
                required: true
            },
            contactLens: {
                required: true
            },
            cycle: {
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
            brandid: {
                required: icon + "请选择商品品种"
            },
            proid: {
                required: icon + "请输入商品编号"
            },
            unitid: {
                required: icon + "请选择计量单位"
            },
            sphUp: {
                required: icon + "请选择球镜上限"
            },
            sphDown: {
                required: icon + "请选择球镜下限"
            },
            sphSpan: {
                required: icon + "请选择跨度"
            },
            cylUp: {
                required: icon + "请选择柱镜上限"
            },
            cylDown: {
                required: icon + "请选择柱镜下限"
            },
            cylSpan: {
                required: icon + "请选择跨度"
            },
            curvatureOne: {
                required: icon + "请输入曲率"
            },
            curvatureYi: {
                required: icon + "请输入曲率1"
            },

            diameterOne: {
                required: icon + "请输入直径"
            },
            diameterYi: {
                required: icon + "请输入直径1"
            },
            contactLens: {
                required: icon + "请选择接触镜类别"
            },
            cycle: {
                required: icon + "请输入定做周期"
            },
        }
    })
}