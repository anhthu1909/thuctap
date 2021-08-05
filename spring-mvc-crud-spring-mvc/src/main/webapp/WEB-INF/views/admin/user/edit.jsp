<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="userURL" value="/quan-tri/nguoi-dung/danh-sach"/>
<c:url var="editUserURL" value="/quan-tri/nguoi-dung/chinh-sua"/>
<c:url var="userAPI" value="/api/user"/>
<html>
<head>
	<title>Chỉnh sửa người dùng</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">Home</a>
				</li>

				<li>
					<a href="#">Forms</a>
				</li>
				<li class="active">Form Elements</li>
			</ul><!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
								${message}
						</div>
					</c:if>
					<div class="widget-box table-filter">
						<div class="table-btn-controls">
							<div class="pull-right tableTools-container">
								<div class="dt-buttons btn-overlap btn-group">
									<c:url var="createUserURl" value="/quan-tri/nguoi-dung/chinh-sua" />
									<a flag="info"
									   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									   data-toggle="tooltip"
									   title='Thêm người dùng' href='${createUserURl}'>
										<span>
											<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<form:form class="form-horizontal" user="form" id="formSubmit" modelAttribute="model">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="userName"> Tên người dùng </label>
									<div class="col-sm-9">
										<form:input path="userName" id="userName" cssClass="col-xs-10 col-sm-5"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="password"> Mật khẩu </label>
									<div class="col-sm-9">
										<form:input path="password" id="password" type="password" cssClass="col-xs-10 col-sm-5"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="fullName"> Tên đầy đủ </label>
									<div class="col-sm-9">
										<form:input path="fullName" id="fullName" cssClass="col-xs-10 col-sm-5"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status"> Trạng thái </label>
									<div class="col-sm-9">
										<form:input path="status" id="status" placeholder="1 or 2" cssClass="col-xs-10 col-sm-5"/>
									</div>
								</div>
								<form:hidden path="id" id="userId"/>
								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<c:if test="${not empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrUpdateUser">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Cập nhật người dùng
											</button>
										</c:if>
										<c:if test="${empty model.id}">
											<button class="btn btn-info" type="button" id="btnAddOrUpdateUser">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Thêm người dùng
											</button>
										</c:if>

										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i>
											Hủy
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$('#btnAddOrUpdateUser').click(function (e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function (i, v) {
			data[""+v.name+""] = v.value;
		});
		var id = $('#userId').val();
		if (id == "") {
			addUser(data);
		} else {
			updateUser(data);
		}
	});

	function addUser(data) {
		$.ajax({
			url: '${userAPI}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href = "${editUserURL}?id="+result.id+"&message=insert_success";
			},
			error: function (error) {
				window.location.href = "${userURL}?page=1&limit=10&message=error_system";
			}
		});
	}

	function updateUser(data) {
		$.ajax({
			url: '${userAPI}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href = "${editUserURL}?id="+result.id+"&message=update_success";
			},
			error: function (error) {
				window.location.href = "${editUserURL}?id="+result.id+"&message=error_system";
			}
		});
	}
</script>
</body>
</html>
