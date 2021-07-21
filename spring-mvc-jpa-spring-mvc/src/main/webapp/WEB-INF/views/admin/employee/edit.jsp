<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="employeeURL" value="/quan-tri/nhan-vien/danh-sach"/>
<c:url var="editEmployeeURL" value="/quan-tri/nhan-vien/chinh-sua"/>
<c:url var="employeeAPI" value="/api/employee"/>
<html>
<head>
    <title>Chỉnh sửa nhân viên</title>
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
                                    <c:url var="createEmployeeURl" value="/quan-tri/nhan-vien/chinh-sua" />
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                       data-toggle="tooltip"
                                       title='Thêm nhân viên' href='${createEmployeeURl}'>
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
                            <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="hospitalName"> Bệnh viện </label>
                                    <div class="col-sm-9">
                                    <form:select path="hospitalName" id="hospitalName">
                                        <form:option value="" label="--Chọn bệnh viện--"/>
                                        <form:options items="${hospitals}"/>
                                    </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="name"> Tên nhân viên </label>
                                    <div class="col-sm-9">
                                        <form:input path="name" cssClass="col-xs-10 col-sm-5"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="phone"> Số điện thoại </label>
                                    <div class="col-sm-9">
                                        <form:input path="phone" cssClass="col-xs-10 col-sm-5"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="thumbnail"> Ảnh đại diện </label>
                                    <div class="col-sm-9">
                                        <input type="file" class="col-xs-10 col-sm-5" id="thumbnail" name="thumbnail"/>
                                    </div>
                                </div>
                                <form:hidden path="id" id="employeeId"/>
                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <c:if test="${not empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateEmployee">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Cập nhật nhân viên
                                            </button>
                                        </c:if>
                                        <c:if test="${empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateEmployee">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Thêm nhân viên
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
    $('#btnAddOrUpdateEmployee').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#employeeId').val();
        if (id == "") {
            addEmployee(data);
        } else {
            updateEmployee(data);
        }
    });

    function addEmployee(data) {
        $.ajax({
            url: '${employeeAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editEmployeeURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${employeeURL}?page=1&limit=2&message=error_system";
            }
        });
    }

    function updateEmployee(data) {
        $.ajax({
            url: '${employeeAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editEmployeeURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editEmployeeURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>
