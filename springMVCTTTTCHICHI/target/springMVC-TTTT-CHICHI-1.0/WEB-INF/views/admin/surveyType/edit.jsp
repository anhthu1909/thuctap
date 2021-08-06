
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="surveyTypeURL" value="/quan-tri/bai-viet/danh-sach-kieu"/>
<c:url var="editSurveyTypeURL" value="/quan-tri/bai-viet/danh-sach-kieu"/>
<c:url var="surveyTypeAPI" value="/api/kieu"/>
<html>
<head>
    <title>Chỉnh sửa kiểu khảo sát</title>
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
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
                </li>

                <li><a href="#">Forms</a></li>
                <li class="active">Form Elements</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên kiểu khảo sát</label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="col-xs-10 col-sm-5"/>
                            </div>
                        </div>



                        <form:hidden path="id" id="surveyTypeId"/>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyType">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật kiểu khảo sát
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyType">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Thêm kiểu khảo sát
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

<script>
    $('#btnAddOrUpdateSurveyType').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#surveyTypeId').val();
        if (id == "") {
            addSurveyType(data);
        } else {
            updateSurveyType(data);
        }
    });

    function addSurveyType(data) {
        $.ajax({
            url: '${surveyTypeAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyTypeURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${surveyTypeURL}?&message=error_system";
            }
        });
    }

    function updateSurveyType(data) {
        $.ajax({
            url: '${surveyTypeAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyTypeURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editSurveyTypeURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>