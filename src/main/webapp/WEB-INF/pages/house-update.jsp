<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>房源信息修改</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="../../plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../../plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="../../plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="../../plugins/morris/morris.css">
<link rel="stylesheet"
	href="../../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="../../plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="../../plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="../../plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="../../plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="../../plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="../../plugins/select2/select2.css">
<link rel="stylesheet"
	href="../../plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="../../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="../../plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="../../plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="../../css/style.css">
<link rel="stylesheet"
	href="../../plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="../../plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="../../plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="../../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
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
				房源 <small>信息审核</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="../main.do"><i
						class="fa fa-dashboard"></i>首页</a></li>
				<li><a
					href="../house/findAllBypagesBack.do">房源管理</a></li>
				<li class="active">房源表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->
			<!--FIXME!!! -->
			<!-- TODO：modify -->
			<form action="../house/update.do"
				method="post">
				<input type="hidden" name="houseId" value="${house.houseId}">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">房源信息审核</div>
					<div class="row data-type">

						<div class="col-md-2 title">房屋ID</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="houseId"
								   placeholder="" value="${house.houseId}" readonly="readonly">
						</div>
						<div class="col-md-2 title">业  主</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="userId"
								placeholder="" value="${house.userId}" readonly="readonly">
						</div>
						<div class="col-md-2 title">地址</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="address"
								   placeholder="" value="${house.address}" readonly="readonly">
						</div>
						<div class="col-md-2 title">装修情况</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="houseDecoration"
								   placeholder="" value="${house.houseDecoration}" readonly="readonly">
						</div>


						<div class="col-md-2 title">单位价格（每平米）</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="unitPrice"
								placeholder="" value="${house.unitPrice}" readonly="readonly">
						</div>

						<div class="col-md-2 title">面积</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="area"
								   placeholder=""value="${house.area}" readonly="readonly">
						</div>

						<div class="col-md-2 title">审核状态</div>
						<div class="col-md-4 data">
							<input type ="radio" ${(house.status eq 0) ? ' checked=checked ' :'' } name="status" value="0" />审核中
							<input type ="radio" ${(house.status eq 1) ? ' checked=checked ' :'' } name="status" value="1" />审核通过
							<input type ="radio" ${(house.status eq 2) ? ' checked=checked ' :'' } name="status" value="2" />审核不通过
							<input type ="radio" ${(house.status eq 3) ? ' checked=checked ' :'' } name="status" value="3" />已出售
						</div>

						<div class="col-md-2 title">楼  层</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder=""
								   name="agentPassword" value="${house.floor}" readonly="readonly">
						</div>


						<div class="col-md-2 title rowHeight2x">描述</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="描述"
								name="agentProfile" readonly="readonly">${house.description}</textarea>
						</div>


<%--						<div class="col-md-2 title">状  态</div>--%>
<%--						<div class="col-md-4 data">--%>
<%--							<input type ="radio" ${(house.status eq 0) ? ' checked=checked ' :'' } name="status" value="0" />审核中--%>
<%--							<input type ="radio" ${(house.status eq 1) ? ' checked=checked ' :'' } name="status" value="1" />审核通过--%>
<%--						</div>--%>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="window.location.href='../house/findAllBypagesBack.do'">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		

	</div>


	<script
		src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="../../plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="../../plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../../plugins/raphael/raphael-min.js"></script>
	<script
		src="../../plugins/morris/morris.min.js"></script>
	<script
		src="../../plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="../../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="../../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="../../plugins/knob/jquery.knob.js"></script>
	<script
		src="../../plugins/daterangepicker/moment.min.js"></script>
	<script
		src="../../plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="../../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="../../plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="../../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="../../plugins/fastclick/fastclick.js"></script>
	<script
		src="../../plugins/iCheck/icheck.min.js"></script>
	<script
		src="../../plugins/adminLTE/js/app.min.js"></script>
	<script
		src="../../plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="../../plugins/select2/select2.full.min.js"></script>
	<script
		src="../../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="../../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="../../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="../../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="../../plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="../../plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="../../plugins/ckeditor/ckeditor.js"></script>
	<script
		src="../../plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="../../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="../../plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="../../plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="../../plugins/chartjs/Chart.min.js"></script>
	<script
		src="../../plugins/flot/jquery.flot.min.js"></script>
	<script
		src="../../plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="../../plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="../../plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="../../plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="../../plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="../../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

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
