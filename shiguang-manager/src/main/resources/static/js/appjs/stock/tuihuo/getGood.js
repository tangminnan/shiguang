function showCol() {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    $.each(check, function(i, row) {
        // ids[i] = row['id'];
        var obj = {};
        if(null == row['goodsNum']){
            var goodsNum  ="";
        }else {
            var goodsNum =  row['goodsNum'];
        }
        if(null == row['goodsName']){
            var goodsName  ="";
        }else {
            var goodsName =  row['goodsName'];
        }
        if(null == row['factory']){
            var factory  ="";
        }else {
            var factory =  row['factory'];
        }
        if(null == row['unit']){
            var unit  ="";
        }else {
            var unit =  row['unit'];
        }
        if(null == row['goodsCount']){
            var goodsCount  ="";
        }else {
            var goodsCount =  row['goodsCount'];
        }
        if(null == row['goodsCode']){
            var goodsCode  ="";
        }else {
            var goodsCode =  row['goodsCode'];
        }
        if(null == row['goodsxinxiid']){
            var goodsxinxiid  ="";
        }else {
            var goodsxinxiid =  row['goodsxinxiid'];
        }
        if(null == row['retailPrice']){
            var retailPrice  ="";
        }else {
            var retailPrice =  row['retailPrice'];
        }
        obj.goodsNum = goodsNum;
        obj.goodsName = goodsName;
        obj.factory = factory;
        obj.unit = unit;
        obj.goodsCount = goodsCount;
        obj.goodsCode = goodsCode;
        obj.goodsxinxiid = goodsxinxiid;
        obj.retailPrice = retailPrice;
        obj.count = 1;
        objArray.push(obj);
    });
    return objArray;
}
