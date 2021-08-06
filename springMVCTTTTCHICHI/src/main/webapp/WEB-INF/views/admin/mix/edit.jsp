
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach-mix"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua-mix"/>
<c:url var="newAPI" value="/api/mix"/>
<html>
<head>
    <title>Chỉnh sửa phân quyền</title>
</head>
<body>
<div class="main-content">

<!--

    <form action="phanquyen" method="post">

        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên tài khoản</label>
            <div class="col-sm-9">

                <select id="taikhoan" name="taikhoan">
                    <c:forEach var="item" items="${users}" >
                        <option value="${item.id}"> ${item.fullname}</option>
                    </c:forEach>
                </select>

            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Phân quyền</label>
            <div class="col-sm-9">

                        <select name="quyen" id="quyen">
                            <c:forEach var="item" items="${roles}" >
                                <option value="${item.id}">${item.code}</option>
                            </c:forEach>
                        </select>

            </div>
        </div>
            <button type="submit"  class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                <i class="ace-icon fa fa-check bigger-110"></i>
                Lưu
            </button>

    </form>

    -->
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
                    <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" action="phanquyen" method="post">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="taikhoan">Tên tài khoản</label>
                            <div class="col-sm-9">

                                <select id="taikhoan" name="taikhoan">
                                    <c:forEach var="item" items="${users}" >
                                        <option value="${item.id}"> ${item.fullname}</option>
                                    </c:forEach>
                                </select>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="quyen">Phân quyền</label>
                            <div class="col-sm-9">

                                <select name="quyen" id="quyen">
                                    <c:forEach var="item" items="${roles}" >
                                        <option value="${item.id}">${item.code}</option>
                                    </c:forEach>
                                </select>

                            </div>
                        </div>


                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Cập nhật kiểu khảo sát
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button type="submit" class="btn btn-info" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                      Lưu
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
</body>
</html>