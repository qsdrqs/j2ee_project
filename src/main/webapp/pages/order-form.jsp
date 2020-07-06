<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户订单</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>



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
					数据管理 <small>数据列表</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">数据管理</a></li>
					<li class="active">数据列表</li>
				</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content">
				<!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">列表</h3>
					</div>
					<div class="box-body">
						<!-- 数据表格 -->
						<div class="table-box">
							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<button type="button" class="btn btn-default" id="user_delete"
											title="删除">
											<i class="fa fa-trash-o"></i> 删除
										</button>
										<button type="button" class="btn btn-default" title="刷新"
											onclick="location.href='../user/findAll'">
											<i class="fa fa-refresh"></i> 刷新
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input type="text" class="form-control input-sm"
										placeholder="搜索"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</div>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px;"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">房屋ID</th>
										<th class="sorting_asc sorting_asc_disabled">房屋地址</th>
										<th class="sorting_desc sorting_desc_disabled">房屋单价</th>
										<th class="sorting_desc sorting_desc_disabled">房屋面积</th>
										<th class="sorting_desc sorting_desc_disabled">房屋楼层</th>
										<th class="sorting_desc sorting_desc_disabled">出售类型</th>
										<th class="sorting_desc sorting_desc_disabled">订单状态</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.pi.list }" var="house">
										<tr>
											<td><input name="ids" type="checkbox" value="isCheck"></td>
											<td>${house.houseId }</td>
											<td>${house.address }</td>
											<td>${house.unitPrice }</td>
											<td>${house.area }</td>
											<td>${house.floor }</td>
											<td>${house.typeStr }</td>
											<td>${house.statusStr }</td>
											<td class="text-center">
											<c:if test="${house.status == 1 }">
											<button type="button" class="btn bg-olive btn-xs" disabled ="disabled">通过</button>
											</c:if>
												<button type="button" class="btn bg-olive btn-xs"
													onclick="window.location.href='/house/delete?id=${house.houseId }'">删除</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!--数据列表/-->
							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<button type="button" class="btn btn-default" id="user_delete"
											title="删除">
											<i class="fa fa-trash-o"></i> 删除
										</button>
										<button type="button" class="btn btn-default" title="刷新"
											onclick="location.href='../user/order?id=${param.id}'">
											<i class="fa fa-refresh"></i> 刷新
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input type="text" class="form-control input-sm"
										placeholder="搜索"> <span
										class="glyphicon glyphicon-search form-control-feedback" id="search"></span>
								</div>
							</div>
							<!--工具栏/-->
						</div>
						<!-- 数据表格 /-->
					</div>
					<!-- /.box-body -->
					<!-- .box-footer-->
					<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline">当前 ${pi.pageNum }页,总${pi.pages }
								页,总 ${pi.total } 条记录</div>
						</div>
						<div class="box-tools pull-right">
							<ul class="pagination">
								<li><a href="${APP_PATH }?id=${param.id }&p=1">首页</a></li>
								<c:if test="${pi.hasPreviousPage }">
									<li><a href="${APP_PATH }?id=${param.id }&p=${pi.pageNum-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:if>
								<c:forEach items="${pi.navigatepageNums }" var="page_Num">
									<c:if test="${page_Num == pi.pageNum }">
										<li class="active"><a href="#">${page_Num }</a></li>
									</c:if>
									<c:if test="${page_Num != pi.pageNum }">
										<li><a href="${APP_PATH }?id=${param.id }&p=${page_Num }">${page_Num }</a></li>
									</c:if>

								</c:forEach>
								<c:if test="${pi.hasNextPage }">
									<li><a href="${APP_PATH }?id=${param.id }&p=${pi.pageNum+1 }"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:if>
								<li><a href="${APP_PATH }?id=${param.id }&p=${pi.pages}">末页</a></li>
							</ul>
						</div>
					</div>
					<!-- /.box-footer-->

					<div class="box-tools text-center">
						<button type="submit" class="btn bg-maroon">保存</button>
						<button type="button" class="btn bg-default"
							onclick="window.location.href='/user/findAll'">返回</button>
					</div>
				</div>
			</section>
			<!-- 正文区域 /-->
		</div>
		<!-- @@close -->
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
		src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	<script
		src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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

			// 激活导航位置
			setSidebarActive("admin-datalist");

			// 列表按钮 
			$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
			// 全选操作 
			$("#selall").click(function() {
				var clicks = $(this).is(':checked');
				if (!clicks) {
					$("#dataList td input[type='checkbox']").iCheck("uncheck");
				} else {
					$("#dataList td input[type='checkbox']").iCheck("check");
				}
				$(this).data("clicks", !clicks);
			});
		});

		function deliver() {
			var check_val = [];
			var check = $("input[name=isCheck]:checked");
			check.each(function() {
				var row = $(this).parent("td").parent("tr");
				var id = row.find("[name='${user.userId}']").val();
				check_val.push({
					id : id
				});
			})
			console.log(check_val);
		};
	</script>
</body>

</html>