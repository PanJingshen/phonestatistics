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
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li>数据管理</li>
				<li class="active">设备管理</li>
			</ol>
		</div><!--/.row-->
		
  <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">设备列表</div>
					<div class="panel-body">
						<table id="talbe" data-toggle="table" data-url="${pageContext.request.contextPath}/device/getDevices"  data-show-refresh="true" data-show-toggle="false" data-show-columns="true" data-search="true" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="id" data-sortable="true">ID</th>
						        <th data-field="model"  data-sortable="true">model</th>
						        <th data-field="version" data-sortable="true">version</th>
                                <th data-field="androidVersion" data-sortable="true">androidVersion</th>
                                <th data-field="imei" data-sortable="true">IMEI</th> 
                                <th data-field="androidId" data-sortable="true">androidId</th>
                                <th data-field="cpu" data-sortable="true">CPU</th>
                                <th data-field="totalInternalMemory" data-sortable="true">总内存</th>
                                <th data-field="availExternalMemory" data-sortable="true">可用内存</th>
                                <th data-field="totalExternalMemory" data-sortable="true">总外存</th>
                                <th data-field="displayMetrics" data-sortable="true">显示像素</th>
                                <th data-field="brand" data-sortable="true">品牌</th>
                                <th data-field="manufacture" data-sortable="true">硬件生产商</th>
                                <th data-field="product" data-sortable="true">产品</th>
                                <th data-field="userId" data-sortable="true">用户ID</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
  </div><!--/.main-->

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
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
	function addDevice(){
		document.addDeviceForm.submit();
	}
	function updateDevice(){
		document.updateDeviceForm.submit();
	}
</script>
<script language="javascript">
	var $table = $('#table');
	function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }
</script>
</body>

</html>
