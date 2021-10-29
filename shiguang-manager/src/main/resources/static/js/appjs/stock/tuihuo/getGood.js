//携带商品分页
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
        objArray.push(obj);
    });
    return objArray;
}
//携带商品不分页
// function showCol() {
//     var check = $("input[name='one']:checked");//选中的复选框
//     var objArray = [];
//     check.each(function () {
//         var obj = {};
//         var rowstr = $(this).parent("td").parent("tr");
//         var goodsNum = rowstr.find("[name='goodsNum']").html();//注意html()和val()
//         var goodsName = rowstr.find("[name='goodsName']").html();//注意html()和val()
//         var factory = rowstr.find("[name='factory']").html();//注意html()和val()
//         var unit = rowstr.find("[name='unit']").html();//注意html()和val()
//         var goodsCount = rowstr.find("[name='goodsCount']").html();//注意html()和val()
//         var goodsCode = rowstr.find("[name='goodsCode']").html();//注意html()和val()
//         var goodsxinxiid = rowstr.find("[name='goodsxinxiid']").html();//注意html()和val()
//         var retailPrice = rowstr.find("[name='retailPrice']").html();//注意html()和val()
//         obj.goodsNum = goodsNum;
//         obj.goodsName = goodsName;
//         obj.factory = factory;
//         obj.unit = unit;
//         obj.goodsCount = goodsCount;
//         obj.goodsCode = goodsCode;
//         obj.goodsxinxiid = goodsxinxiid;
//         obj.retailPrice = retailPrice;
//         objArray.push(obj);
//     });
//     return objArray;
// }
