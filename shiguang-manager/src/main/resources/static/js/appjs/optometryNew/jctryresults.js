var prefix = "/information/optometryNew";
$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        saveTry();
    }
});

function saveTry() {
    var companyId=$("#companyId").val();
    var newOld=$("#newOld").val();
    // alert(newOld);
    if (companyId==1){
        if (newOld==null || newOld==""){
            layer.alert("请选择新老院区！");
        }else {
            $.ajax({
                cache: true,
                type: "POST",
                url: "/jiancha/tryresults/save",
                data: $('#signupForm').serialize(),// 你的formid
                async: false,
                error: function (request) {
                    parent.layer.alert("Connection error");
                },
                success: function (data) {
                    var cardNumber = document.getElementById('cardNumber').value;
                    var ptometryNumber = document.getElementById('ptometryNumber').value;
                    // alert(cardNumber);
                    // alert(ptometryNumber);
                    var toIndex = layer.open({
                        type: 2,
                        title: '检查结论',
                        maxmin: true,
                        shadeClose: false, // 点击遮罩关闭层
                        area: ['1000px', '520px'],
                        content: prefix + '/jianchajielun/' + cardNumber+'/'+ptometryNumber  // iframe的url
                    });
                    layer.full(toIndex);

                }
            });

        }
    } else {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/jiancha/tryresults/save",
            data: $('#signupForm').serialize(),// 你的formid
            async: false,
            error: function (request) {
                parent.layer.alert("Connection error");
            },
            success: function (data) {
                // if (data.code == 0) {
                //     parent.layer.msg("操作成功");
                //     parent.reLoad();
                //     var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                //     parent.layer.close(index);
                //
                // } else {
                //     parent.layer.alert(data.msg)
                // }
                var cardNumber = document.getElementById('cardNumber').value;
                var ptometryNumber = document.getElementById('ptometryNumber').value;
                // alert(cardNumber);
                // alert(ptometryNumber);
                var toIndex = layer.open({
                    type: 2,
                    title: '检查结论',
                    maxmin: true,
                    shadeClose: false, // 点击遮罩关闭层
                    area: ['1000px', '520px'],
                    content: prefix + '/jianchajielun/' + cardNumber+'/'+ptometryNumber  // iframe的url
                });
                layer.full(toIndex);

            }
        });

    }




    // $('.click_light').on('', function () {
    //     var type = $(this).attr("data_type");
    //     window.location.hash = '#' + type;
    //     // window.location.href = '#' + type;
    // });

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


function updateTry() {
    $.ajax({
        cache : true,
        type : "POST",
        url: "/jiancha/tryresults/updateTry",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            // if (data.code == 0) {
            //     parent.layer.msg("操作成功");
            //     parent.reLoad();
            //     var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
            //     parent.layer.close(index);
            //
            // } else {
            //     parent.layer.alert(data.msg)
            // }
            var cardNumber = document.getElementById('cardNumber').value;
            var ptometryNumber = document.getElementById('ptometryNumber').value;
            // alert(cardNumber);
            // alert(ptometryNumber);
            var toIndex = layer.open({
                type: 2,
                title: '检查结论',
                maxmin: true,
                shadeClose: false, // 点击遮罩关闭层
                area: ['1000px', '520px'],
                content: prefix + '/jianchajielun/' + cardNumber+'/'+ptometryNumber  // iframe的url
            });
            layer.full(toIndex);

        }
    });

}