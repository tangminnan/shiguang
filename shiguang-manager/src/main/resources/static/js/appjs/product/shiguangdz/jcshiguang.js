function getjtxlsg() {
    var toIndex = layer.open({
        type: 2,
        title: '视觉训练',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/information/optometryNew/shiguangdz/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var shiguangshiguang = ""
            for (var i = 0; i < rows.length; i++) {
                shiguangshiguang += rows[i].producName;
            }
            // alert(yizhuyizhu);
            $("#jtxlsg").val(shiguangshiguang);
        }
    });
    layer.full(toIndex)
}

function getxlsxlsg() {
    var toIndex = layer.open({
        type: 2,
        title: '视觉训练',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/information/optometryNew/shiguangdz/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var shiguangshiguang = ""
            for (var i = 0; i < rows.length; i++) {
                shiguangshiguang += rows[i].producName;
            }
            // alert(yizhuyizhu);
            $("#xlsxlsg").val(shiguangshiguang);
        }
    });
    layer.full(toIndex)
}