function getYizhu() {
    layer.open({
        type: 2,
        title: '医嘱',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/information/optometryNew/yizhu/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var yizhuyizhu = ""
            for (var i = 0; i < rows.length; i++) {
                yizhuyizhu += rows[i].yizhu;
            }
            // alert(yizhuyizhu);
            $("#yizhus").val(yizhuyizhu);
        }
    });
}