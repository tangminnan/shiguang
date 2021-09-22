// 选择配镜单
function batchSelect() {
    var check = $("input[name='one']:checked");//选中的复选框
    var objArray = [];
    check.each(function () {
        var obj = {};
        var rowstr = $(this).parent("td").parent("tr");
        var saleNumber = rowstr.find("[name='saleNumber']").html();//注意html()和val()
        var name = rowstr.find("[name='name']").html();
        var memberNumber = rowstr.find("[name='memberNumber']").html();
        var phone1 = rowstr.find("[name='phone1']").html();
        var settleDate = rowstr.find("[name='settleDate']").html();
        var amountMoney = rowstr.find("[name='amountMoney']").html();
        var recipelType = rowstr.find("[name='recipelType']").html();

        var rightsph = rowstr.find("[name='rightsph']").html();
        var rightcyl  = rowstr.find("[name='rightcyl']").html();
        var rightzx = rowstr.find("[name='rightzx']").html();
        var rightAdd = rowstr.find("[name='rightAdd']").html();
        var rightSlj = rowstr.find("[name='rightSlj']").html();
        var rightJd = rowstr.find("[name='rightJd']").html();
        var rightFartj = rowstr.find("[name='rightFartj']").html();
        var rightNeartj = rowstr.find("[name='rightNeartj']").html();

        var leftsph = rowstr.find("[name='leftsph']").html();
        var leftcyl = rowstr.find("[name='leftcyl']").html();
        var leftzx = rowstr.find("[name='leftzx']").html();
        var leftAdd = rowstr.find("[name='leftAdd']").html();
        var leftSlj = rowstr.find("[name='leftSlj']").html();
        var leftJd = rowstr.find("[name='leftJd']").html();
        var leftFartj = rowstr.find("[name='leftFartj']").html();
        var leftNeartj = rowstr.find("[name='leftNeartj']").html();

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

        var goodsNum = rowstr.find("[name='goodsNum']").html();
        obj.goodsNum = goodsNum;
        var jpGoodsName = rowstr.find("[name='jpGoodsName']").html();
        obj.jpGoodsName = jpGoodsName;
        var jpGoodsNum = rowstr.find("[name='jpGoodsNum']").html();
        obj.jpGoodsNum = jpGoodsNum;
        var leftRight = rowstr.find("[name='leftRight']").html();
        obj.leftRight = leftRight;

        objArray.push(obj);
    });

    return objArray;
};

