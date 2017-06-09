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
		<div id="toolbar">
                    <div class="btn btn-primary" data-toggle="modal" data-target="#addModal">添加管理员</div>
                </div>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/nav/index"><span class="glyphicon glyphicon-home"></span></a></li>
                <li>账号管理</li>
				<li class="active">管理员管理</li>
			</ol>
		</div><!--/.row-->
		
  <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">管理员列表</div>
					<div class="panel-body">
						<table id="talbe" data-toggle="table" data-url="${pageContext.request.contextPath}/manager/getManagers"  data-show-refresh="true" data-show-toggle="false" data-toolbar="#toolbar" data-show-columns="true" data-search="true" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="id" data-sortable="true">ID</th>
						        <th data-field="username"  data-sortable="true">用户名</th>
						        <th data-field="email" data-sortable="true">邮箱</th>
                                <th data-field="password" data-sortable="true">密码</th>
                                <th data-field="phone" data-sortable="true">电话</th>
                                <th data-formatter="operateFormatter" data-events="operateEvents">操作</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
            <div class="col-*-12">
                <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
                   <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
                            </div>
                            <div class="modal-body">
                                <form method="post" role="form" name="addManagerForm" action="${pageContext.request.contextPath}/manager/addManager">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="username"  placeholder="请输入用户名">
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="email"  placeholder="请输入邮箱">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="password"  placeholder="请输入密码">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="phone"  placeholder="请输入电话号码">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="addRecord" onClick="addManager();">提交</button>
                            </div>
                        </div>
                    </div>
                </div>
	</div>
    <div class="col-*-12">
                <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true">
                   <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">编辑管理员</h4>
                            </div>
                            <div class="modal-body">
                                <form method="post" role="form" name="updateManagerForm" action="${pageContext.request.contextPath}/manager/updateManager">
                                     <div class="form-group">
                                        <label>ID：</label><input name="id" id="edit_id" type="text"  readonly  unselectable="on" >
                                    </div>
                                    <div class="form-group">
                                        <label>用户名：</label><input type="text" class="form-control" id="edit_username" name="username" value=""  placeholder="请输入用户名">
                                    </div>
                                    <div class="form-group">
                                    <label>邮箱：</label>
                                        <input type="text" class="form-control" id="edit_email" name="email"   placeholder="请输入邮箱">
                                    </div>
                                    <div class="form-group">
                                    <label>密码：</label>
                                        <input type="text" class="form-control" id="edit_password" name="password"  placeholder="请输入密码">
                                    </div>
                                    <div class="form-group">
                                    <label>电话：</label>
                                        <input type="text" class="form-control" id="edit_phone" name="phone"  placeholder="请输入电话号码">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="addRecord" onClick="updateManager();">保存</button>
                            </div>
                        </div>
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
	function addManager(){
		document.addManagerForm.submit();
	}
	function updateManager(){
		document.updateManagerForm.submit();
	}
</script>
<script language="javascript">
	var $table = $('#table');
	function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

	function operateFormatter(value, row, index) {
            return [
                         '<a class="edit"  title="编辑" data-toggle="modal" data-target="#updateModal">',
            '<i class="glyphicon glyphicon-pencil"></i>',
            '</a>  ',
            '<a class="remove" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
                    ].join('');
        }
		
		
	window.operateEvents = {
        'click .edit': function (e, value, row, index) {
			console.log(value, row, index);
			$('#edit_id').val(row.id);  
    		$('#edit_username').val(row.username);  
			$('#edit_email').val(row.email);
    		$('#edit_password').val(row.password);
			$('#edit_phone').val(row.phone);
            $table.bootstrapTable('updateRow', {
                index:index,
                row:row
            });
        },
        'click .remove': function (e, value, row, index) {
            $table.bootstrapTable('remove', {
                field: 'id',
                values: [row.id]
            });
			console.log(value, row, index);
			location.href=	"${pageContext.request.contextPath}/manager/deleteManager?id="+row.id;
			
        }
    };
</script>
</body>

</html>
