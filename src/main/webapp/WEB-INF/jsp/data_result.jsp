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
<link href="${pageContext.request.contextPath}/css/select2.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navigator.jsp" /><!--/.sidebar--><!--弹出删除用户警告窗口-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/nav/index"><span class="glyphicon glyphicon-home"></span></a></li>
                <li>数据管理</li>
				<li class="active">数据分析</li>
			</ol>
		</div><!--/.row-->
        <div class="row">
        	<div class="col-lg-12">
            	<div class="panel panel-default">
                	<div class="panel-heading">数据分析</div>
                    <div class="panel-body">
                        <div class="col-md-6">
                        <label>请选择用户</label>
                            <select class="js-example-basic-single js-states form-control" id="sel_user"  >
 							</select>
                            <label>请选择设备</label>
                             <select class="js-example-basic-single js-states form-control" id="sel_device"  >
                         </select>
                          <button type="button" class="btn btn-primary" id="getDataResult" onClick="getDataResult();">查询</button>
 							<div id="img_container">
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/.main-->

	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/js/select2.js"></script>
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
	function getDataResult(){
		$.getJSON("${pageContext.request.contextPath}/data_result/getDataResult",{deviceId:deviceId.val()},function(data){  
//此处返回的data已经是json对象 
	console.log(data.figureOrigin);
 	var blob1 = new Blob([data.figureOrigin],{type:"image/png"});
	//
	var eleAppend = document.getElementById("img_container");
		var img = document.createElement("img");
		var bytes_img1 = data.figureOrigin;
		img.src = "data:image/png;base64,<?=base64_encode($bytes_img1)?>";
		eleAppend.appendChild(img); 
    
});
	}
</script>
    <script language="javascript">
   var userId = $("#sel_user").select2({
			placeholder: "Select an option",
  			allowClear: true,
			ajax: {
				url: "${pageContext.request.contextPath}/user/getUsersByUsername",
				cache: true,
				delay: 250,
				dataType: 'json',
				data: function (params) {
					return {
						username: params.term, // 查询参数
					};
				},
				processResults: function (data) {
      				return {
        				results: data
      				};
    			}
			 },
			templateResult: function (repo){  //返回结果回调
					return  repo.username;
			}, 
 			templateSelection:  function (repos){ //选中项回调
					return repos.username;
			},  
		});
		
		
		var deviceId = $("#sel_device").select2({
			placeholder: "Select an device",
  			allowClear: true,
			ajax: {
				url: "${pageContext.request.contextPath}/device/getDevicesByUserId",
				cache: true,
				delay: 250,
				dataType: 'json',
				data: function (params) {
					return {
						userId: userId.val(), // 查询参数
					};
				},
				processResults: function (data) {
      				return {
        				results: data
      				};
    			}
			 },
			templateResult: function (repo){  //返回结果回调
					return  repo.id;
			}, 
 			templateSelection:  function (repos){ //选中项回调
					return repos.id;
			},  
		});					   
	</script>
</body>

</html>
