<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Tables</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/datepicker3.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navigator.jsp" /><!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/nav/index"><span class="glyphicon glyphicon-home"></span></a></li>
				<li>数据管理</li>
                <li class="active">应用管理</li>
			</ol>
		</div><!--/.row-->
		
  <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Android应用使用状态列表</div>
					<div class="panel-body">
						<table id="table" data-toggle="table" data-url="${pageContext.request.contextPath}/usage_stats/getUsageStats"  data-show-export="true" data-click-to-select="true" data-show-refresh="true" data-show-toggle="false" sdata-show-columns="true" data-search="true" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="id" data-sortable="true">Item ID</th>
						        <th data-field="packageName"  data-sortable="true">包名</th>
						        <th data-field="count" data-sortable="true">点击次数</th>
                                <th data-field="totalTimeInForeground" data-sortable="true">前台总运行时间</th>
                                <th data-field="deviceId" data-sortable="true">设备ID</th>
                                <th data-field="type" >类型</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
  </div><!--/.main-->

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js">
    </script>
    <script src="${pageContext.request.contextPath}/tables/extensions/export/bootstrap-table-export.js"></script>
    <script src="//rawgit.com/hhurz/tableExport.jquery.plugin/master/tableExport.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		});
		
	</script>	
<script language="javascript">
	function addUsageStat(){
		document.addUsageStatForm.submit();
	}
	function updateUsageStat(){
		document.updateUsageStatForm.submit();
	}
</script>
<script>
    var $table = $('#table');
    $(function () {
        $('#toolbar').find('select').change(function () {
            $table.bootstrapTable('destroy').bootstrapTable({
                exportDataType: $(this).val()
            });
        });
    })
</script>
<script language="javascript">
	$('#talbe123').bootstrapTable({
            url: '${pageContext.request.contextPath}/usage_stats/getUsageStats',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            //queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            clickToSelect:true,
            showExport: true,                     //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
		columns: [{
			field: 'id',
			title: 'ID'
		}, {
			field: 'packageName',
			title: '包名'
		}, {
			field: 'count',
			title: '点击次数'
		},{
			field: 'totalTimeInForeground',
			title: '前台总运行时间'
		},{
			field: 'deviceId',
			title: '设备ID'
		},{
			field: 'hasWakeLock',
			title: '是否有唤醒锁'
		},{
			field: 'type',
			title: '类型'
		}, ]
	});
</script>
</body>

</html>
