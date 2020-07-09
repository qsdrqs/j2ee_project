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
				<p>${pageContext.getSession().getAttribute("adminInfo").getAdminAccount()}</p>
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
						href="${pageContext.request.contextPath}/admin/update.do?id=${pageContext.getSession().getAttribute("adminInfo").getAdminId()}"> <i
							class="fa fa-circle-o"></i> 我的信息
					</a></li>
					<li class="system-setting"><a
						href="${pageContext.request.contextPath}/admin/manage.do?type=${pageContext.getSession().getAttribute("adminInfo").getType()}"> <i
							class="fa fa-circle-o"></i> 管理员管理
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="system-setting"><a href="../user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li class="system-setting"><a
							href="../agent/findAll1.do">
							<i class="fa fa-circle-o"></i> 经纪人管理
					</a></li>

					<li class="system-setting"><a href="../house/findAllBypagesBack.do">
							<i class="fa fa-circle-o"></i> 房源管理
					</a></li>
					
					<li class="system-setting"><a href="../house/allowcation.do">
							<i class="fa fa-circle-o"></i> 房源分配
					</a></li>

				</ul></li>
			<li id="logout"><a href="../admin/logout.do"><i
					class="fa fa-dashboard"></i> <span>退出</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>