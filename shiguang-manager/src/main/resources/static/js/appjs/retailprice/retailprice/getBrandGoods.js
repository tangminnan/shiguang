// 品种选择
function showCol() {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    $.each(check, function(i, row) {
        // alert(JSON.stringify(row));
        if (null != row['goodsid']) {
            var obj = {};
            if (null == row['goodsid']) {
                var goodsid = "";
            } else {
                var goodsid = row['goodsid'];
            }
            if (null == row['classtype']) {
                var classtype = "";
            } else {
                var classtype = row['classtype'];
            }

            if (null == row['mfrsid']) {
                var mfrsid = "";
            } else {
                var mfrsid = row['mfrsid'];
            }
            if (null == row['brandnum']) {
                var brandnum = "";
            } else {
                var brandnum = row['brandnum'];
            }
            if (null == row['brandname']) {
                var brandname = "";
            } else {
                var brandname = row['brandname'];
            }

            if (null == row['mfrsname']) {
                var mfrsname = "";
            } else {
                var mfrsname = row['mfrsname'];
            }
            if (null == row['retailPrice']) {
                var retailPrice = "";
            } else {
                var retailPrice = row['retailPrice'];
            }
            obj.goodsid = goodsid;
            obj.classtype = classtype;
            obj.mfrsid = mfrsid;
            obj.brandnum = brandnum;
            obj.brandname = brandname;
            obj.mfrsname = mfrsname;
            obj.retailPrice = retailPrice;
            objArray.push(obj);
        }
    });

    return objArray;
}
