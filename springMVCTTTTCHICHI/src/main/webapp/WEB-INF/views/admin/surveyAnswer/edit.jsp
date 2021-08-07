<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach-answer"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua-answer"/>
<c:url var="newAPI" value="/api/answer"/>
<html>
<head>
    <title>Xem phiếu khảo sát</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"></script>

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

                            <div class="col-sm-9">
                                <tr>
                                    <td>${model.content}</td>
                                </tr>
                            </div>
                        </div>

                        <form:hidden path="id" id="newId"/>
                        <!--<div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                        Xem Câu trả lời
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                       Thêm câu trả
                                    </button>
                                </c:if>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                            </div>
                        </div>-->
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    $(document).ready(function(){
        $('.btnform').remove();
        $('.btnsua').remove();
        $('#thongbaoxoa').remove();
        $('#exampleModalCenter').remove();
        var b="";
        var cauhoi=new Array();
        var cautraloi= new Array();
        var tam="";
        $('#luukq').click(function(){
            var socauhoi=$('#socauhoi').val();
            var final= new Array();
            var t1="";
            var code="";
            for( var i=0;i<socauhoi;i++){
                var a= $('#settxt'+i).text();
                b= $('input[name="cau'+i+'"]').val();
                if(b=="input"){
                    tam=$('input[name="text'+i+'"]').val();
                } else if(b=="textarea"){
                    tam= $('textarea:input[name=text'+i+']').val();
                }else if(b=="radio"){
                    tam=$('input[name="text'+i+'"]:checked').val();
                }
                if(tam==undefined || tam==""){
                    tam="Không có câu trả lời";
                }
                cauhoi.push(a);
                cautraloi.push(tam);
            }
            //end for
            var n=cauhoi.length;
            var code= document.getElementsByTagName("label")[0].innerHTML;
            var code2='<div class="col-md-12 text-center" ><label id="tieude">'+code+'</label></div>';
            for(var t=0;t<n;t++){
                t1='<div class="col-md-8 mt-2" id="row'+t+'"> <label class="nhan">'+cauhoi[t]+'</label><br><label class="cautraloi">'+'Đáp án: '+cautraloi[t]+'</label></div>';
                final.push(t1);
            }
            code=code2+final.join(" ");

            $('#ketqua').val(code);
            // gắn url dưới đây sau khi đánh giá thành công
        });
    });

    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#newId').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });

    function addNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${newURL}?&message=error_system";
            }
        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>