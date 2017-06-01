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
                    <div class="btn btn-primary" data-toggle="modal" data-target="#addModal">添加用户</div>
                </div>
                <!--弹出删除用户警告窗口-->
                <div class="modal fade" id="deleteUser" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    确定要删除该用户？删除后不可恢复！
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                <button type="button" class="btn btn-green btn-xs">保 存</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Tables</li>
			</ol>
		</div><!--/.row-->
		
  <div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">用户列表</div>
					<div class="panel-body">
						<table id="talbe" data-toggle="table" data-url="${pageContext.request.contextPath}/user/getUsers"  data-show-refresh="true" data-show-toggle="false" data-toolbar="#toolbar" data-show-columns="true" data-search="true" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="id" data-sortable="true">Item ID</th>
						        <th data-field="username"  data-sortable="true">用户名</th>
						        <th data-field="email" data-sortable="true">邮箱</th>
                                <th data-field="password" data-sortable="true">密码</th>
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
                                <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                            </div>
                            <div class="modal-body">
                                <form method="post" role="form" name="addUserForm" action="${pageContext.request.contextPath}/user/addUser">
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
                                        <input type="text" class="form-control" name="birthdate" placeholder="请输入出生日期">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="addRecord" onClick="addUser();">提交</button>
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
                                <h4 class="modal-title" id="myModalLabel">编辑用户</h4>
                            </div>
                            <div class="modal-body">
                                <form method="post" role="form" name="updateUserForm" action="${pageContext.request.contextPath}/user/updateUser">
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
                                    <label>出生日期：</label>
                                        <input type="text" class="form-control" id="edit_birthdate" name="birthdate" placeholder="请输入出生日期">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="addRecord" onClick="updateUser();">保存</button>
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
	function addUser(){
		document.addUserForm.submit();
	}
	function updateUser(){
		document.updateUserForm.submit();
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
            '<a class="remove" title="Remove" data-toggle="modal" data-target="#deleteUser">',
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
			location.href=	"${pageContext.request.contextPath}/user/deleteUser?id="+row.id;
			
        }
    };
</script>
</body>

</html>
