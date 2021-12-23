
var prefix = "/information/department"
$(function() {
	load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/departmentlist", // 服务器数据的加载地址
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
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        departNumber: $("#departNumber").val(),
                        companyId: $("#companyId").val()
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
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
                    {
                        field: 'departNumber',
                        title: '部门编码',
                        align: 'center'
                    },
                    {
                        field: 'departName',
                        title: '部门名称',
                        align: 'center'
                    },
                    {
                        field: 'departType',
                        title: '部门类型',
                        align: 'center'
                    },
                    {
                        field: 'fanuc',
                        title: '加工中心',
                        align: 'center'
                    },
                    {
                        field: 'name',
                        title: '所属公司',
                        align: 'center'
                    },
                    // 								{
                    // 	field : 'sameSell',
                    // 	title : '隐形和护理液同单销售',
                    //    align : 'center',
                    // 	formatter : function(value, row, index) {
                    // 		if(value == '0'){
                    // 			return '<span class="label">可以同单销售</span>';
                    // 		}else if(value == '1'){
                    //            return '<span class="label">不可以同单销售</span>';
                    //
                    //        }else if(value == '2'){
                    //            return '<span class="label">未设置</span>';
                    //
                    //        }
                    // 	}
                    // },
                    {
                        field: 'status',
                        title: '部门状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var str = '';

                            str += ' <div class="switch onoffswitch col-sm-1"> ';
                            str += ' <div class="onoffswitch"> ';
                            str += ' <input name="allowComment" ';
                            //启用状态 0：启用；1：禁用
                            if (row.status == 0)
                                str += ' checked="" ';

                            str += ' type="checkbox" onchange="updateEnable(' + row.id + ',this)" value="' + row.id + '" class="onoffswitch-checkbox" id="example1' + row.id + '">  ';
                            str += ' <label class="onoffswitch-label" for="example1' + row.id + '">  ';
                            str += ' <span class="onoffswitch-inner" ></span> ';
                            str += ' <span class="onoffswitch-switch" ></span> ';
                            str += ' </label> ';
                            str += ' </div>';
                            str += ' </div>';
                            return str;
                        }
                    },
				]
            });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function batchSelect() {

    var check = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    var objArray = [];
    $.each(check, function(i, row) {
        var obj = {};

        if(null == row['id']){
            var id  ="";
        }else {
            var id =  row['id'] ;
        }
        obj.id = id;
        if(null == row['departName']){
            var departName  ="";
        }else {
            var departName =  row['departName'] ;
        }
        obj.departName = departName;
        objArray.push(obj);
    });
    return objArray;
};