function getZhizaoshang() {
    var goodsids = $("#goodsids").val();
    // alert(goodsids)
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/mfrs/brand/findmfrs/" + goodsids,// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsnum);
                $("#msname").val(rows[i].mfrsname);
                // caidan(rows[i].mfrsid);
                // alert(rows[i].mfrsname)
            }
        }
    });
    layer.full(toIndex)
}
