<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<title>添加管理员</title>
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="../plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="../plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="../plugins/morris/morris.css">
<link rel="stylesheet"
	href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="../plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="../plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="../plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="../plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="../plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="../plugins/select2/select2.css">
<link rel="stylesheet"
	href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="../plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="../plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="../css/style.css">
<link rel="stylesheet"
	href="../plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">
		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->
		<!-- 内容区域 -->
		<div class="content-wrapper">
			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				管理员 <small>信息录入</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="../main.do"><i
						class="fa fa-dashboard"></i>首页</a></li>
				<li><a
					href="../admin/findAll">管理员信息管理</a></li>
				<li class="active">管理员信息表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->
			<!--FIXME!!! -->
			<form action="../admin/add"
				method="post">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->
				<div class="panel panel-default">
					<div class="panel-heading">新增管理员信息</div>
					<div class="row data-type">
						<div class="col-md-2 title">账号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder="账号名称"
								   name="adminAccount" value="">
						</div>

						<div class="col-md-2 title">密  码</div>
						<div class="col-md-4 data">
							<input type="password" class="form-control" placeholder="密码"
								   name="adminPassword" value="">
						</div>
						<div class="col-md-2 title">管理员类型</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
									name="type">
								<option value="0" selected="selected">普通管理员</option>
								<option value="1">超级管理员</option>
							</select>
						</div>
					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="window.location.href='/admin/findAll'">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->
	</div>


	<script
		src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="../plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="../plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../plugins/raphael/raphael-min.js"></script>
	<script
		src="../plugins/morris/morris.min.js"></script>
	<script
		src="../plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="../plugins/knob/jquery.knob.js"></script>
	<script
		src="../plugins/daterangepicker/moment.min.js"></script>
	<script
		src="../plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="../plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="../plugins/fastclick/fastclick.js"></script>
	<script
		src="../plugins/iCheck/icheck.min.js"></script>
	<script
		src="../plugins/adminLTE/js/app.min.js"></script>
	<script
		src="../plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="../plugins/select2/select2.full.min.js"></script>
	<script
		src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="../plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="../plugins/ckeditor/ckeditor.js"></script>
	<script
		src="../plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="../plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="../plugins/chartjs/Chart.min.js"></script>
	<script
		src="../plugins/flot/jquery.flot.min.js"></script>
	<script
		src="../plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="../plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="../plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {
			$('#datepicker-a3').datetimepicker({
				format : "yyyy-mm-dd hh:ii",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});

		$(document).ready(function() {
			// 激活导航位置
			setSidebarActive("order-manage");
			$("#datepicker-a3").datetimepicker({
				format : "yyyy-mm-dd hh:ii",

			});

		});
	</script>


</body>

</html>