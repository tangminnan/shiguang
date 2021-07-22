function getZhizaoshang() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/mfrs/brand/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                caidan(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}

function getMfrsProduca() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/produca/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                choice(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}

function getMfrsParts() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/parts/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                choice(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}

function getMfrsJpcp() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/jpcp/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                choice(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}

function getMfrsJpdz() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/jpdz/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                choice(rows[i].mfrsid);
            }
        }
    });
    layer.full(toIndex)
}
