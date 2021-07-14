function getYizhu() {
    var toIndex = layer.open({
        type: 2,
        title: '医嘱',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: "/information/optometryNew/yizhu/",// iframe的url
        cancel: function (index, layero) {
            var rows = $(layero).find("iframe")[0].contentWindow.batchSelect();
            for (var i = 0; i < rows.length; i++) {
                html = "<tr><td><input name=\"cho\" type=\"checkbox\" /></td>";
                html += "<td>" + rows[i].producName + "</td>";
                html += "<td><em onclick='del(this,0.00,\"" + rows[i].producName + "\")'></em></td>";
                html += "<input id='storeName'name='storeName' type='hidden' />"
                html += "<input id='storeDescribe'name='storeDescribe' value='自片' type='hidden' />"
                $("#goods").append(html);
                arraystore.push(rows[i].producName);
                arrayunit.push(0.00);
                arraycount.push(1)
            }
            $("#storeName").val(arraystore);
            $("#storeUnit").val(arrayunit);
            $("#storeCount").val(arraycount);
        }
    });
    layer.full(toIndex)
}