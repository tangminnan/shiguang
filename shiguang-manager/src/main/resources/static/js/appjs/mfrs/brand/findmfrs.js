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
                // alert(rows[i].mfrsid + "-----制造商id");
                // alert(rows[i].mfrsname + "------制造商名称");
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                a1.value = a1.value.substring(0, 2) + rows[i].mfrsid + a1.value.substring(4, 22)
                a1_val = a1.value.substring(0, 7) + a1_val.substring(7, 22)
                a2.value = a1.value.replace(".", "").replace(".", "").replace(".", "").replace(".", "")
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
            // alert(rows + "配件");
            for (var i = 0; i < rows.length; i++) {
                // alert(rows[i].mfrsid + "-----制造商id");
                // alert(rows[i].mfrsname + "------制造商名称");
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

function getMfrsYxcp() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/yxcp/findmfrs/",// iframe的url
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

function getMfrsYxdz() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/yxdz/findmfrs/",// iframe的url
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

function getMfrsHly() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/hly/findmfrs/",// iframe的url
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

function getMfrsTyj() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/tyj/findmfrs/",// iframe的url
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

function getMfrsOldlens() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/oldlens/findmfrs/",// iframe的url
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

function getMfrsHc() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/hc/findmfrs/",// iframe的url
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

function getMfrsShiguang() {
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/product/shiguang/findmfrs/",// iframe的url
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
