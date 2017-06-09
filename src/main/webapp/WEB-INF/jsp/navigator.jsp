<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 账号管理 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="${pageContext.request.contextPath}/nav/user_list">
							<span class="glyphicon glyphicon-share-alt"></span> 用户管理
						</a>
					</li>
					<li>
						<a class="" href="${pageContext.request.contextPath}/nav/manager_list">
							<span class="glyphicon glyphicon-share-alt"></span> 管理员管理
						</a>
					</li>
				</ul>
			</li>
            <li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 数据管理 <span data-toggle="collapse" href="#sub-item-2" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<a class="" href="${pageContext.request.contextPath}/nav/device_list">
							<span class="glyphicon glyphicon-share-alt"></span> 设备管理
						</a>
					</li>
					<li>
						<a class="" href="${pageContext.request.contextPath}/nav/usagestats_list">
							<span class="glyphicon glyphicon-share-alt"></span> 应用管理
						</a>
					</li>
					<li>
						<a class="" href="${pageContext.request.contextPath}/nav/data_result">
							<span class="glyphicon glyphicon-share-alt"></span> 数据分析
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>
		<div class="attribution">Copyright @<a href="">PhoneStatistics</a></div>
	</div><!--/.sidebar-->
		
	