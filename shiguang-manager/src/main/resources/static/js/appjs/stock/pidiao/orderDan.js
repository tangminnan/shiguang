$(function () {
    load();
});

function load() {

    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/stock/pidiao" + "/orderDanList", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 50, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                pageList: [50,100,200,300,500,1200],
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        danjuNumber :$('#danjuNumber').val().trim(),
                        goodsid :$('#goodsid').val().trim(),
                        classtype :$('#classtype').val().trim(),
                        mfrsname :$('#mfrsname').val().trim(),
                        day1 :$('#day1').val().trim(),
                        day2 :$('#day2').val().trim(),
                        outPosition :$('#outPosition').val().trim(),
                        status :$('#status').val().trim(),
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    // {
                    //     field: 'id',
                    //     title: '主键'
                    // },
                    {
                        field: 'danjuNumber',
                        title: '单据编号'
                    },
                    {
                        field: 'mfrsname',
                        title: '制造商'
                    },
                    {
                        title: '商品类别',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (row.classtype == 2) {
                               if (row.gdname=="镜片"){
                                   return "订做镜片"
                               }else if (row.gdname=="隐形"){
                                   return "订做隐形"
                               }
                            } else {
                                return row.gdname
                            }
                        }

                    },

                    {
                        field: 'zhidanPeople',
                        title: '入库人'
                    },
                    {
                        field: 'positionName',
                        title: '入库仓位'
                    },
                    {
                        field: 'danjuDay',
                        title: '制单日期'
                    },
                    {
                        field: 'beizhu',
                        title: '备注'
                    },

                    // {
                    //     field: '',
                    //     title: '审核人'
                    // }, {
                    //     field: '',
                    //     title: '审核日期'
                    // },
                    {
                        title: '操作',
                        field: 'danjuNumber',
                        align: 'center',
                        formatter: function (value, row, index) {
                                var a = '<span class="btn btn-primary btn-sm'+s_detial_h+'" href="#" title="详情"  mce_href="#" onclick="detial(\''
                                    + row.id + '\')">详情</span> ';
                            return a ;
                        }
                    }
                ]


            });

}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

document.onkeydown = function(e){
    if((e||event).keyCode==13)
        reLoad();
};



function detial(id) {
    var prefix = "/stock/stock";
    var toIndex = layer.open({
        type: 2,
        title: '详情',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/detial/' + id // iframe的url
    });
    layer.full(toIndex);
}




function showCol() {
    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    // alert(JSON.stringify(check));
    $.each(check, function(i, row) {
        // ids[i] = row['id'];

        var obj = {};
        //———获取当前系统时间—————
        var timeNow = new Date();
        var year = timeNow.getFullYear();
        var month = timeNow.getMonth() + 1 > 10 ? timeNow.getMonth() + 1 : '0' + (timeNow.getMonth() + 1);
        var date = timeNow.getDate() > 10 ? timeNow.getDate() : "0" + timeNow.getDate();
        obj.createTime = year + "-" + month + "-" + date;

        // if(null == row['goodsNum']){
        //     var goodsNum ="";
        // }else {
        //     var goodsNum = row['goodsNum'];
        // }
        //
        // if(null == row['goodsCode']){
        //     var goodsCode  ="";
        // }else {
        //     var goodsCode = row['goodsCode'] ;
        // }
        //
        // if(null == row['goodsName']){
        //     var goodsName  ="";
        // }else {
        //     var goodsName = row['goodsName'] ;
        //
        // }
        // if(null == row['goodsCount']){
        //     var goodsCount  ="";
        // }else {
        //     var goodsCount = row['goodsCount'];
        // }
        //
        // if(null == row['gdname']){
        //     var gdname  ="";
        // }else {
        //     var gdname = row['gdname'] ;
        // }
        // if(null == row['goods']){
        //     var goods  ="";
        // }else {
        //     var goods = row['goods'] ;
        // }
        //
        // if(null == row['mfrsname']){
        //     var mfrsname  ="";
        // }else {
        //     var mfrsname = row['mfrsname'] ;
        // }
        //
        // if(null == row['factory']){
        //     var factory  ="";
        // }else {
        //     var factory = row['factory'] ;
        // }
        //
        // if(null == row['retailPrice']){
        //     var retailPrice  ="";
        // }else {
        //     var retailPrice = row['retailPrice'] ;
        // }
        //
        // if(null == row['priceSum']){
        //     var priceSum  ="";
        // }else {
        //     var priceSum = row['priceSum'] ;
        // }
        //
        // if(null == row['costPrice']){
        //     var costPrice  ="";
        // }else {
        //     var costPrice = row['costPrice'] ;
        // }
        //
        // if(null == row['costSum']){
        //     var costSum  ="";
        // }else {
        //     var costSum = row['costSum'] ;
        // }
        //
        // if(null == row['wholePrice']){
        //     var wholePrice  ="";
        // }else {
        //     var wholePrice = row['wholePrice'] ;
        // }
        //
        // if(null == row['wholeSum']){
        //     var wholeSum  ="";
        // }else {
        //     var wholeSum = row['wholeSum'] ;
        // }
        //
        // if(null == row['positionName']){
        //     var positionName  ="";
        // }else {
        //     var positionName = row['positionName'] ;
        // }
        //
        // if(null == row['batch']){
        //     var batch  ="";
        // }else {
        //     var batch = row['batch'];
        // }
        //
        // if(null == row['zhuceNumber']){
        //     var zhuceNumber  ="";
        // }else {
        //     var zhuceNumber = row['zhuceNumber'] ;
        // }
        //
        // if(null == row['produceDay']){
        //     var produceDay  ="";
        // }else {
        //     var produceDay = row['produceDay'] ;
        // }
        //
        // if(null == row['useday']){
        //     var useday  ="";
        // }else {
        //     var useday = row['useday'] ;
        // }
        //
        // if(null == row['classtype']){
        //     var classtype  ="";
        // }else {
        //     var classtype = row['classtype'] ;
        // }
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        // obj.goodsNum = goodsNum;
        // obj.goodsCode = goodsCode;
        // obj.goodsName = goodsName;
        // obj.goodsCount = goodsCount;
        // obj.gdname = gdname;
        // obj.goods = goods;
        // obj.factory = factory;
        // obj.mfrsname = mfrsname;
        //
        // obj.retailPrice = retailPrice;
        // obj.priceSum = priceSum;
        // obj.costPrice = costPrice;
        // obj.costSum = costSum;
        // obj.wholePrice = wholePrice;
        // obj.wholeSum = wholeSum;
        //
        // obj.positionName = positionName;
        // obj.batch = batch;
        // obj.zhuceNumber = zhuceNumber;
        // obj.produceDay = produceDay;
        // obj.useday = useday;
        // obj.classtype = classtype;
        //
        // if(null == row['mfrsid']){
        //     var mfrsid  ="";
        // }else {
        //     var mfrsid = row['mfrsid'] ;
        // }
        //
        // obj.mfrsid = mfrsid;
        //
        // if(null == row['brandname']){
        //     var brandname  ="";
        // }else {
        //     var brandname = row['brandname'] ;
        // }
        //
        // obj.brandname = brandname;
        //
        //
        // if(null == row['unit']){
        //     var unit  ="";
        // }else {
        //     var unit = row['unit'] ;
        // }
        // obj.unit = unit;
        //
        // if(null == row['goodsid']){
        //     var goodsid  ="";
        // }else {
        //     var goodsid = row['goodsid'] ;
        // }
        // obj.goodsid = goodsid;
        //
        // if(null == row['goodsxinxiid']){
        //     var goodsxinxiid  ="";
        // }else {
        //     var goodsxinxiid = row['goodsxinxiid'] ;
        // }
        // obj.goodsxinxiid = goodsxinxiid;
        //
        if(null == row['danjuNumber']){
            var danjuNumber  ="";
        }else {
            var danjuNumber = row['danjuNumber'] ;
        }
        obj.danjuNumber = danjuNumber;
        //
        // obj.useCount = 1;


        objArray.push(obj);
    });
    return objArray;
}