<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="../img/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>xxx</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a href="../main.do"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="/main.do"> <i
					class="fa fa-cogs"></i> <span>系统管理</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li class="system-setting"><a
						href="${pageContext.request.contextPath}/user/add"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li class="system-setting"><a
						href="${pageContext.request.contextPath}/user/add"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li class="system-setting"><a
						href="${pageContext.request.contextPath}/user/add"> <i
							class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li class="system-setting"><a
						href="${pageContext.request.contextPath}/user/add"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li class="system-setting"><a href="../user/findAll"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li class="system-setting"><a
						<%--						href="${pageContext.request.contextPath}/user/findAll1?page=1&pageSize=3"> <i--%>
							href="../agent/findAll1">
							<i class="fa fa-circle-o"></i> 经纪人管理
					</a></li>

					<li class="system-setting"><a href="../house/findAllBypagesBack">
							<i class="fa fa-circle-o"></i> 房源管理
					</a></li>

				</ul></li>
			<li id="logout"><a href="../admin/logout.do"><i
					class="fa fa-dashboard"></i> <span>退出</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>