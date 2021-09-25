function getZhizaoshang() {
    var goodsids = $("#goodsids").val();
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
                caidan(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}

function getMfrs() {
    var goodsids = $("#goodsids").val();
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
                // alert(rows[i].mfrsid + "-----制造商id");
                // alert(rows[i].mfrsname + "------制造商名称");
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                $("#mfrsnum").val(rows[i].mfrsnum);
                a1.value = a1.value.substring(0, 2) + rows[i].mfrsnum + a1.value.substring(4, 22)
                a1_val = a1.value.substring(0, 7) + a1_val.substring(7, 22)
                a2.value = a1.value.replace(".", "").replace(".", "").replace(".", "").replace(".", "")
                choice(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}