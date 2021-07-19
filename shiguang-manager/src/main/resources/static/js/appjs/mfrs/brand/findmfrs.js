function getZhizaoshang() {
    alert("2342")
    var toIndex = layer.open({
        type: 2,
        title: '制造商',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/mfrs/brand/findmfrs/",// iframe的url
        cancel: function (index, layero) {
            alert("232")
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                $("#mfrsName").val(rows[i].mfrsname);
                $("#mfrsid").val(rows[i].mfrsid);
                // html = "<td><input type=\"text\" id=\"zzss\" name=\"mfrsid\" />" + rows[i].mfrsname + "</td>";
                // html += "<input type=\"hidden\" id=\"zzss\" name=\"mfrsid\" value=" + rows[i].mfrsid + "/>"
                // alert("id" + rows[i].mfrsid + "名字" + rows[i].mfrsname);
                alert("22");
                caidan(rows[i].mfrsid);
            }


        }
    });
    layer.full(toIndex)
}