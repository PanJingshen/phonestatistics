<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>BootStrap Table使用</title>
    <!--@*1、Jquery组件引用* -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

    <!--@*2、bootstrap组件引用*@ -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
    
    <!-- @*3、bootstrap table组件以及中文包的引用*@-->
    <script src="${pageContext.request.contextPath}/tables/bootstrap-table.js"></script>
    <link href="${pageContext.request.contextPath}/tables/bootstrap-table.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/tables/locale/bootstrap-table-zh-CN.js"></script>
</script>
</head>
<body>
    <div class="panel-body" style="padding-bottom:0px;">  

        <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="tb_departments"></table>
    </div>
</body>

<script language="javascript">
$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '${pageContext.request.contextPath}/user/getUsers',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
			
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: 'id'
            },{
                field: 'username',
                title: 'username'
            }, {
                field: 'email',
                title: 'email'
            }, {
                field: 'password',
                title: 'password'
            }, {
                field: 'birthdate',
                title: 'birthdate'
            },{
                field: 'operate',
                title: 'operate',
				formatter:operateFormatter,
				events:operateEvents
            }, ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            departmentname: $("#txt_search_departmentname").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};


function operateFormatter(value, row, index) {
            return [
                         '<a class="glyphicon glyphicon-pencil" style="margin-left:10px" href="javascript:void(0)" title="编辑">',
                                '</a>',
                                '<a class="glyphicon glyphicon-remove" style="margin-left:10px" href="javascript:void(0)" title="移除">',                                '</a>'
                    ].join('');
        }
		
		
window.operateEvents = {
            'click .like': function (e, value, row, index) {
                alert('You click like icon, row: ' + JSON.stringify(row));
                console.log(value, row, index);
            },
            'click .edit': function (e, value, row, index) {
                var url = '@Url.Content("~/UserInfo/UpdateRecord/")' + row.Id + '?rnd=' + Math.random();
                art.dialog.open(url, { title: "修改用户信息", id: 'detail', width: 500, height: 420, lock: true, opacity: 0.3, close: function () { $table.bootstrapTable('refresh'); } });
            },
            'click .remove': function (e, value, row, index) {
                mif.showQueryMessageBox("将删除本条记录，是否确认删除？", function () {
                    var url = '@Url.Content("~/UserInfo/DeleteRecord/")' + row.Id + '?rnd=' + Math.random();
                    mif.ajax(url, null, afterDelete);
                });
            }
        };
        
</script>
</html>