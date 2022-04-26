
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

        if(null == row['departname']){
            var departname  ="";
        }else {
            var departname =  row['departname'];
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

        if(null == row['rightSlja']){
            var rightSlja  ="";
        }else {
            var rightSlja =  row['rightSlja'];
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

       if(null == row['leftSlja']){
            var leftSlja  ="";
        }else {
            var leftSlja =  row['leftSlja'];
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
        obj.departname = departname;
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
        obj.rightSlja= rightSlja;
        obj.rightJd = rightJd;
        obj.rightFartj = rightFartj;
        obj.rightNeartj = rightNeartj;

        obj.leftsph = leftsph;
        obj.leftcyl = leftcyl;
        obj.leftzx = leftzx;
        obj.leftAdd = leftAdd;
        obj.leftSlja = leftSlja;
        obj.leftJd = leftJd;
        obj.leftFartj = leftFartj;
        obj.leftNeartj = leftNeartj;

        if(null == row['goodsNum']){
            var goodsNum  ="";
        }else {
            var goodsNum =  row['goodsNum'];
        }

        if(null == row['storeName']){
            var storeName  ="";
        }else {
            var storeName =  row['storeName'];
        }
        if(null == row['goodsCode']){
            var goodsCode  ="";
        }else {
            var goodsCode =  row['goodsCode'];
        }

        if(null == row['leftRight']){
            var leftRight  ="";
        }else {
            var leftRight =  row['leftRight'];
        }
        if(null == row['mirorAddress']){
            var mirorAddress  ="";
        }else {
            var mirorAddress =  row['mirorAddress'];
        }

        obj.goodsNum = goodsNum;

        // obj.jpGoodsName = jpGoodsName;
        // obj.jpGoodsNum = jpGoodsNum;
        obj.storeName = storeName;
        obj.goodsCode = goodsCode;
        obj.leftRight = leftRight;
        obj.mirorAddress = mirorAddress;
        //加工要求
        if(null == row['processAsk']){
            var processAsk  ="";
        }else {
            var processAsk =  row['processAsk'];
        }
        obj.processAsk = processAsk;
        //瞳高
        if(null == row['righttg']){
            var righttg  ="";
        }else {
            var righttg =  row['righttg'];
        }
        obj.righttg = righttg;

        if(null == row['lefttg']){
            var lefttg  ="";
        }else {
            var lefttg =  row['lefttg'];
        }
        obj.lefttg = lefttg;




        //描述
        if (null == row['storeDescribe']){
            var storeDescribe = "";
        }else {
            var storeDescribe= row['storeDescribe'];
        }
        obj.storeDescribe=storeDescribe;
        //数量
        if (null == row['storeCount']){
            var storeCount = "";
        }else {
            var storeCount= row['storeCount'];
        }
        obj.storeCount=storeCount;
        //classtype类型定做成品
        if (null == row['classtype']){
            var classtype = "";
        }else {
            var classtype= row['classtype'];
        }
        obj.classtype=classtype;




// alert(row['rightqulv'])
        //rightqulv
        if (null == row['rightqulv']){
            var rightqulv = "";
        }else {
            var rightqulv= row['rightqulv'];
        }
        obj.rightqulv=rightqulv;


        //leftqulv
        if (null == row['leftqulv']){
            var leftqulv = "";
        }else {
            var leftqulv= row['leftqulv'];
        }
        obj.leftqulv=leftqulv;


        //rightzj
        if (null == row['rightzj']){
            var rightzj = "";
        }else {
            var rightzj= row['rightzj'];
        }
        obj.rightzj=rightzj;
        //leftzj
        if (null == row['leftzj']){
            var leftzj = "";
        }else {
            var leftzj= row['leftzj'];
        }
        obj.leftzj=leftzj;






        objArray.push(obj);
    });

    return objArray;
};

