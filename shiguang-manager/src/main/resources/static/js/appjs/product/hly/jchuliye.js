function gethlys() {
    var toIndex = layer.open({
        type: 2,
        title: '护理液',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/information/optometryNew/hly/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            var hlyhly = ""
            for (var i = 0; i < rows.length; i++) {
                hlyhly += rows[i].producName;
            }
            // alert(yizhuyizhu);
            $("#hlys").val(hlyhly);
        }
    });
    layer.full(toIndex)
}