<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>房源分配表</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
<link rel="stylesheet" href="../plugins/morris/morris.css">
<link rel="stylesheet"
	href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="../plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="../plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="../plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet" href="../plugins/select2/select2.css">
<link rel="stylesheet"
	href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="../plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
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
				房源分配 <small>信息修改</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="../main.do"><i class="fa fa-dashboard"></i>首页</a></li>
				<li><a href="../house/allocation.do">房源分配表</a></li>
				<li class="active">房源分配表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->
			<!--FIXME!!! -->
			<!-- TODO：modify -->
			<form action="../house/allow.do" method="post"
				onsubmit="return checkFormart()">
				<input type="hidden" name="houseId" value="${house.houseId}">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->
				<div class="panel panel-default">
					<div class="panel-heading">房源信息表</div>
					<div class="row data-type">
						<div class="col-md-2 title">房屋ID</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="houseId"
								placeholder="" value="${house.houseId}" readonly="readonly">
						</div>
						<div class="col-md-2 title">业 主</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="userId"
								placeholder="" value="${house.userId}" readonly="readonly">
						</div>
						<div class="col-md-2 title">地址</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="address"
								placeholder="" value="${house.address}" readonly="readonly">
						</div>
						<div class="col-md-2 title">单位价格（每平米）</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="unitPrice"
								placeholder="" value="${house.unitPrice}" readonly="readonly">
						</div>
						<div class="col-md-2 title">面积</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="area"
								placeholder="" value="${house.area}" readonly="readonly">
						</div>
						<div class="col-md-2 title">审核状态</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="area"
								placeholder="" value="审核通过" readonly="readonly">
						</div>
						<div class="col-md-2 title">楼 层</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder=""
								name="floor" value="${house.floor}" readonly="readonly">
						</div>
						<div class="col-md-2 title">描述</div>
						<div class="col-md-4 data">
							<textarea class="form-control" rows="3" placeholder="描述"
								name="description" readonly="readonly">${house.description}</textarea>
						</div>
					</div>
					<table id="dataList"
						class="table table-bordered table-striped table-hover dataTable">
						<thead>
							<tr>
								<th class="sorting_asc">经纪人ID</th>
								<th class="sorting_desc">姓名</th>
								<th class="sorting_asc sorting_asc_disabled">性别</th>
								<th class="sorting_desc sorting_desc_disabled">联系电话</th>
								<th class="sorting">个人简述</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.pi.list }" var="agent">
								<tr>
								<td><input type="radio" name="agentId" value="${agent.agentId}" /> ${agent.agentId}</td>
									<td>${agent.agentName}</td>
									<td>${agent.agentSexStr }</td>
									<td>${agent.agentTel }</td>
									<td>${agent.agentProfile}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline">当前 ${pi.pageNum }页,总${pi.pages }
								页,总 ${pi.total } 条记录</div>
						</div>
						<div class="box-tools pull-right">
							<ul class="pagination">
								<li><a href="../house/allow.do?id=${house.houseId}&p=1">首页</a></li>
								<c:if test="${pi.hasPreviousPage }">
									<li><a href="../house/allow.do?id=${house.houseId}&p=${pi.pageNum-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach items="${pi.navigatepageNums }" var="page_Num">
									<c:if test="${page_Num == pi.pageNum }">
										<li class="active"><a href="#">${page_Num }</a></li>
									</c:if>
									<c:if test="${page_Num != pi.pageNum }">
										<li><a href="../house/allow.do?id=${house.houseId}&p=${page_Num }">${page_Num }</a></li>
									</c:if>

								</c:forEach>
								<c:if test="${pi.hasNextPage }">
									<li><a href="../house/allow.do?id=${house.houseId}&p=${pi.pageNum+1 }"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
								<li><a href="../house/allow.do?id=${house.houseId}&p=${pi.pages}">末页</a></li>
							</ul>
						</div>
					</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="window.location.href='../house/allowcation.do'">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->



	</div>


	<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="../plugins/raphael/raphael-min.js"></script>
	<script src="../plugins/morris/morris.min.js"></script>
	<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="../plugins/knob/jquery.knob.js"></script>
	<script src="../plugins/daterangepicker/moment.min.js"></script>
	<script src="../plugins/daterangepicker/daterangepicker.js"></script>
	<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="../plugins/fastclick/fastclick.js"></script>
	<script src="../plugins/iCheck/icheck.min.js"></script>
	<script src="../plugins/adminLTE/js/app.min.js"></script>
	<script src="../plugins/treeTable/jquery.treetable.js"></script>
	<script src="../plugins/select2/select2.full.min.js"></script>
	<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
	<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script src="../plugins/ckeditor/ckeditor.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="../plugins/chartjs/Chart.min.js"></script>
	<script src="../plugins/flot/jquery.flot.min.js"></script>
	<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
	<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
	<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
	<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
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