<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="surveyObjectURL" value="/quan-tri/doi-tuong-khao-sat/danh-sach"/>
<c:url var="editSurveyObjectURL" value="/quan-tri/doi-tuong-khao-sat/chinh-sua"/>
<c:url var="surveyObjectAPI" value="/api/surveyObject"/>
<html>
<head>
    <title>Chỉnh sửa đối tượng khảo sát</title>
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
                                    <c:url var="createSurveyObjectURl" value="/quan-tri/doi-tuong-khao-sat/chinh-sua" />
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                       data-toggle="tooltip"
                                       title='Thêm đối tượng khảo sát' href='${createSurveyObjectURl}'>
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
                                    <label class="col-sm-3 control-label no-padding-right" for="name"> Tên đối tượng khảo sát </label>
                                    <div class="col-sm-9">
                                        <form:input path="name" cssClass="col-xs-10 col-sm-5"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="name">
                                        Mã đối tượng khảo sát </label>
                                    <div class="col-sm-9">
                                        <form:input path="code" placeholder="VD: noi-tru" cssClass="col-xs-10 col-sm-5"/>
                                    </div>
                                </div>
        <%--                        <div class="form-group">--%>
        <%--                            <label class="col-sm-3 control-label no-padding-right" for="shortDescription"> Mô tả ngắn </label>--%>
        <%--                            <div class="col-sm-9">--%>
        <%--                                <form:textarea path="shortDescription" rows="5" cols="10" cssClass="col-xs-10 col-sm-5" id="shortDescription"/>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                        <div class="form-group">--%>
        <%--                            <label class="col-sm-3 control-label no-padding-right" for="content"> Nội dung </label>--%>
        <%--                            <div class="col-sm-9">--%>
        <%--                                <form:textarea path="content" rows="5" cols="10" cssClass="col-xs-10 col-sm-5" id="content"/>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
                                <form:hidden path="id" id="surveyObjectId"/>
                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <c:if test="${not empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyObject">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Cập nhật đối tượng khảo sát
                                            </button>
                                        </c:if>
                                        <c:if test="${empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyObject">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Thêm đối tượng khảo sát
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
    $('#btnAddOrUpdateSurveyObject').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#surveyObjectId').val();
        if (id == "") {
            addSurveyObject(data);
        } else {
            updateSurveyObject(data);
        }
    });

    function addSurveyObject(data) {
        $.ajax({
            url: '${surveyObjectAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyObjectURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${surveyObjectURL}?page=1&limit=10&message=error_system";
            }
        });
    }

    function updateSurveyObject(data) {
        $.ajax({
            url: '${surveyObjectAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyObjectURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editSurveyObjectURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>
