













// 选择配镜单
function batchSelect() {
    // var check = $("input[name='one']:checked");//选中的复选框
    // var objArray = [];
    // check.each(function () {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    $.each(check, function(i, row) {
        var obj = {};
        // var rowstr = $(this).parent("td").parent("tr");
        //注意html()和val()
        if(null == row['saleNumber']){
            var saleNumber  ="";
        }else {
            var saleNumber =  row['saleNumber'];
        }

        if(null == row['name']){
            var name  ="";
        }else {
            var name =  row['name'];
        }

        if(null == row['memberNumber']){
            var memberNumber  ="";
        }else {
            var memberNumber =  row['memberNumber'];
        }
        if(null == row['phone1']){
            var phone1  ="";
        }else {
            var phone1 =  row['phone1'];
        }
        if(null == row['settleDate']){
            var settleDate  ="";
        }else {
            var settleDate =  row['settleDate'];
        }
        if(null == row['amountMoney']){
            var amountMoney  ="";
        }else {
            var amountMoney =  row['amountMoney'];
        }
        if(null == row['recipelType']){
            var recipelType  ="";
        }else {
            var recipelType =  row['recipelType'];
        }



        if(null == row['rightsph']){
            var rightsph  ="";
        }else {
            var rightsph =  row['rightsph'];
        }

        if(null == row['rightcyl']){
            var rightcyl  ="";
        }else {
            var rightcyl =  row['rightcyl'];
        }

        if(null == row['rightzx']){
            var rightzx  ="";
        }else {
            var rightzx =  row['rightzx'];
        }

        if(null == row['rightAdd']){
            var rightAdd  ="";
        }else {
            var rightAdd =  row['rightAdd'];
        }

        if(null == row['rightSlj']){
            var rightSlj  ="";
        }else {
            var rightSlj =  row['rightSlj'];
        }

        if(null == row['rightJd']){
            var rightJd  ="";
        }else {
            var rightJd =  row['rightJd'];
        }

        if(null == row['rightFartj']){
            var rightFartj  ="";
        }else {
            var rightFartj =  row['rightFartj'];
        }

       if(null == row['rightNeartj']){
            var rightNeartj  ="";
        }else {
            var rightNeartj =  row['rightNeartj'];
        }

       if(null == row['leftsph']){
            var leftsph  ="";
        }else {
            var leftsph =  row['leftsph'];
        }

       if(null == row['leftcyl']){
            var leftcyl  ="";
        }else {
            var leftcyl =  row['leftcyl'];
        }

       if(null == row['leftzx']){
            var leftzx  ="";
        }else {
            var leftzx =  row['leftzx'];
        }

       if(null == row['leftAdd']){
            var leftAdd  ="";
        }else {
            var leftAdd =  row['leftAdd'];
        }

       if(null == row['leftSlj']){
            var leftSlj  ="";
        }else {
            var leftSlj =  row['leftSlj'];
        }

       if(null == row['leftJd']){
            var leftJd  ="";
        }else {
            var leftJd =  row['leftJd'];
        }

       if(null == row['leftFartj']){
            var leftFartj  ="";
        }else {
            var leftFartj =  row['leftFartj'];
        }

       if(null == row['leftNeartj']){
            var leftNeartj  ="";
        }else {
            var leftNeartj =  row['leftNeartj'];
        }

        obj.saleNumber = saleNumber;
        obj.name = name;
        obj.memberNumber = memberNumber;
        obj.phone1 = phone1;
        obj.settleDate = settleDate;
        obj.amountMoney = amountMoney;
        obj.recipelType = recipelType;
        obj.rightsph = rightsph;
        obj.rightcyl = rightcyl;
        obj.rightzx = rightzx;
        obj.rightAdd = rightAdd;
        obj.rightSlj = rightSlj;
        obj.rightJd = rightJd;
        obj.rightFartj = rightFartj;
        obj.rightNeartj = rightNeartj;

        obj.leftsph = leftsph;
        obj.leftcyl = leftcyl;
        obj.leftzx = leftzx;
        obj.leftAdd = leftAdd;
        obj.leftSlj = leftSlj;
        obj.leftJd = leftJd;
        obj.leftFartj = leftFartj;
        obj.leftNeartj = leftNeartj;

        if(null == row['goodsNum']){
            var goodsNum  ="";
        }else {
            var goodsNum =  row['goodsNum'];
        }

        if(null == row['jpGoodsName']){
            var jpGoodsName  ="";
        }else {
            var jpGoodsName =  row['jpGoodsName'];
        }

        if(null == row['jpGoodsNum']){
            var jpGoodsNum  ="";
        }else {
            var jpGoodsNum =  row['jpGoodsNum'];
        }

        if(null == row['leftRight']){
            var leftRight  ="";
        }else {
            var leftRight =  row['leftRight'];
        }

        obj.goodsNum = goodsNum;

        obj.jpGoodsName = jpGoodsName;
        obj.jpGoodsNum = jpGoodsNum;
        obj.leftRight = leftRight;

        objArray.push(obj);
    });

    return objArray;
};

