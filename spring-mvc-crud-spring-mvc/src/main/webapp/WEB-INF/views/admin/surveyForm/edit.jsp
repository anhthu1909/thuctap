<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="surveyFormURL" value="/quan-tri/phieu-khao-sat/danh-sach"/>
<c:url var="editSurveyFormURL" value="/quan-tri/phieu-khao-sat/chinh-sua"/>
<c:url var="surveyFormAPI" value="/api/surveyForm"/>
<html>
<head>
    <title>Chỉnh sửa phiếu khảo sát</title>
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
                                    <c:url var="createSurveyFormURl" value="/quan-tri/phieu-khao-sat/chinh-sua" />
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                       data-toggle="tooltip"
                                       title='Thêm phiếu khảo sát' href='${createSurveyFormURl}'>
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
                                    <div class="row mt-3 pt-3 pb-3">
                                        <div class="col-md-5 float-right " id="getcode">
                                            <div class="col-md-12 pb-3 pt-3 text-center" style="border: 1px solid #717171;font-size: 18px; font-weight: 600; border-radius: 05px;" >
                                                <label for="surveyObjectCode">Đối tượng khảo sát</label>
                                                <form:select path="surveyObjectCode" id="surveyObjectCode" name="surveyObjectCode">
                                                    <form:option value="" label="--Chọn đối tượng khảo sát--"/>
                                                    <form:options items="${surveyObjects}"/>
                                                </form:select>
                                            </div>

                                            <div class="col-md-12 pb-3 pt-3 text-center" style="border: 1px solid #717171;font-size: 18px; font-weight: 600; border-radius: 05px;" >
                                                <label for="surveyTypeCode">Kiểu khảo sát</label>
                                                <form:select path="surveyTypeCode" id="surveyTypeCode" name="surveyTypeCode">
                                                    <form:option value="" label="--Chọn kiểu khảo sát--"/>
                                                    <form:options items="${surveyTypes}"/>
                                                </form:select>
                                            </div>

                                            <div class="col-md-12 mt-3" style="border: 1px solid #717171;border-radius: 10px;">
                                                <label class="mt-3" style="font-weight: 500; font-size: 28px;">
                                                    Nhập câu hỏi
                                                </label>
                                                <input type="text" id="test" class="form-control" name="txtcauhoi">
                                                <div class="check1 mt-3 mb-3">
                                                    <label>Chọn loại trả lời</label><br>
                                                    <input type="radio" id="check_radio" name="fav_language" value="01" >
                                                             <label for="check_radio">Check</label>
                                                      <input type="radio" id="tln" name="fav_language" value="02" >
                                                             <label for="tln">Trả lời ngắn</label>
                                                      <input type="radio" id="doan" name="fav_language" value="03" >
                                                    <label for="doan">Đoạn</label>
                                                </div>

                                                <div id="forcheck">
                                                    <button id="btnthem" class="btn btn-primary" >Thêm câu trả lời</button>
                                                </div>

                                                <input type="button" class="btn btn-primary mb-3 mt-3" id="check01" value="Lưu câu hỏi">
                                                <input type="reset" id="lammoi" class="btn btn-primary mb-3 mt-3" value="Làm mới">
                                                <!--thử xong xóa-->
                                            </div>
                                        </div>

                                        <div class="col-md-6 float-right ml-3 pb-3" id="formchinh" style="border:1px solid #717171;border-radius: 10px;">
                                            <!--Form này dùng để lưu tạm code ĐỪNG CODE TRÊN FORM NÀYl-->
                                            <form class="col-md-12 text-center">
                                                <label class=" mt-2 mb-2" id="tit1" style="font-size:32px; font-weight: 500; ">
                                                    Phiếu khảo sát
                                                </label>
                                            </form>
                                            <form action="#" id="pks" >

                                            </form>
                                            <!--xử lý lưu dữ liệu bàng form dưới đây-->
                                            <form method="post" >
                                                <div class="form-group">
                                                    <div class="col-sm-9">
                                                        <form:textarea path="content" id="final" name="final" rows="2" cols="60" style="opacity: 1;" cssClass="col-xs-10 col-sm-5"/>
                                                        <input type="submit" class="btn btn-primary" value="Lưu phiếu khảo sát" id="savecode">
                                                    </div>
                                                </div>
<%--                                                <textarea id="final" name="final" rows="2" cols="60" style="opacity: 1;"></textarea>--%>
<%--                                                <input type="submit" class="btn btn-primary btn-lg" value="Lưu phiếu khảo sát" id="savecode">--%>
                                            </form>
                                        </div>
                                    </div>

                                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLongTitle">Sửa câu hỏi</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <div id="sua1">
                                                        <input type="hidden" id="cs_mang">
                                                        <input type="text" id="suatxt" class="form-control">
                                                    </div>
                                                    <div class="sua2 mt-3 pb-3" style="border-bottom: 1px solid #eeeF;">
                                                        <label>Chọn loại trả lời</label><br>
                                                        <input type="radio" id="check_radio1" name="fav_fix1" value="01">
                                                                <label for="check_radio1">Check</label>
                                                             <input type="radio" id="tln" name="fav_fix2" value="02" >
                                                                <label for="tln">Trả lời ngắn</label>
                                                            <input type="radio" id="doan" name="fav_fix3" value="03" >
                                                        <label for="doan">Đoạn</label>
                                                    </div>
                                                    <label class="mt-3 pb-3" style="font-size: 28px; font-weight:500;">Kiểu câu trả lời</label>
                                                    <div id="sua3" class="mt-3">
                                                    </div>
                                                    <div id="sua4">
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" id="dong_form" data-dismiss="modal">Đóng</button>
                                                    <button type="button" class="btn btn-primary" id="savechange">Lưu thay đổi</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--popup thong bao-->
                                    <div class="modal fade" id="thongbaoxoa" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header" style="border: none;">

                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body" style="border:none;">
                                                    <div class="container text-center mt-3 mb-3">
                                                        <label style="font-size: 32px;font-weight: 500; color: green;">
                                                            Xóa thành công
                                                        </label>
                                                    </div>

                                                </div>
                                                <div class="modal-footer" style="border: none;">
                                                    <button type="button" class="btn btn-secondary" id="dong_form" data-dismiss="modal">Đóng</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <form:hidden path="id" id="surveyFormId"/>
                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <c:if test="${not empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyForm">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Cập nhật phiếu khảo sát
                                            </button>
                                        </c:if>
                                        <c:if test="${empty model.id}">
                                            <button class="btn btn-info" type="button" id="btnAddOrUpdateSurveyForm">
                                                <i class="ace-icon fa fa-check bigger-110"></i>
                                                Thêm phiếu khảo sát
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
    $(document).ready(function(){
        // mảng chứa dữ liệu
        var label= new Array();
        var code = new Array();
        var i=1;
        var z="";
        var l=1;
        // function xử lý code html
        // QUAN TRỌNG
        function showform(data1, data2){
            var c=data1.length;
            var mang2= new Array();
            for( var s=0; s<c ; s++){
                var html1='<div class="col-md-8 mt-2" id="cot'+s+'">';
                var html2='<label id="settxt'+s+'">';
                var html3='</label>'+'<input type="hidden" id="custId'+s+'" name="custId" value="'+s+'">';
                var html4='<div id="setctl'+s+'">';
                var html5='</div> <button type="button" id="'+s+'" value="'+s+'" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="'+s+'" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button>';
                var html6='</div>';
                var sum=html1+html2+data1[s]+html3+html4+data2[s]+html5+html6;
                mang2.push(sum);
            }
            var b=mang2.join(' ')+'<input type="hidden" id="socauhoi" name="socauhoi" value="'+c+'">';
            $('#pks').html(b);
        }
        $('#forcheck').hide();
        $('#check_radio').click(function(){
            $('#forcheck').show();
        });
        //Thêm ô nhập liệu
        $('#btnthem').click(function(){
            i++;
            $('#forcheck').append('<div class="row mt-3 ml-3" id="row'+i+'"> <input type="text" name="txtcheck'+i+'"> <button id="'+i+'" class="btn btn-danger ml-3 btnxoa">Xóa</button> </div>');
            return z=i;
        });
        // Xóa ô nhập liệu
        $(document).on('click', '.btnxoa', function(){
            var button_id = $(this).attr("id");
            $('#row'+button_id+'').remove();
            i--;
        });
        // QUAN TRỌNG
        // Xóa câu trả lời bên form
        $(document).on('click', '.btnform', function(){
            var button_id = $(this).attr("id");
            $('#cot'+button_id+'').remove();
            label.splice(button_id,1);
            code.splice(button_id,1);
            showform(label,code);
        });
        // sửa câu hỏi

        $(document).on('click', '.btnsua', function(){
            var btn_id = $(this).attr("id");
            $('#suatxt').val(label[btn_id]);
            $('#cs_mang').val(btn_id);
            var z=$(this).val();
            var x=$('#custId'+z).val();
            var a=  $('input[name="cau'+btn_id+'"]').val();
            if(a=="radio"){
                $('input[name="fav_fix1"]').prop( "checked", true );
            } else if(a=="input"){
                $('input[name="fav_fix2"]').prop( "checked", true );

            } else if(a=="textarea"){
                $('input[name="fav_fix3"]').prop( "checked", true );

            }
            if(a=="radio"){
                $('#sua3').html(code[btn_id]+'<br><button class="btn btn-primary" id="fixctl">Sửa câu trả lời</button>');
            } else {
                $('#sua3').html(code[btn_id]);
            }
            $('#sua4').html('<input type="hidden" id="custVAL" name="custVAL" value="'+i+'"> <input type="hidden" id="cust_vt" name="cust_vt" value="'+btn_id+'">');
        });
        // thay đổi check trong popup
        $(document).on('change','#check_radio1', function(){
            $('input[name="fav_fix2"]').prop( "checked", false );
            $('input[name="fav_fix3"]').prop( "checked", false );
        });
        $(document).on('change','#tln', function(){
            $('input[name="fav_fix1"]').prop( "checked", false );
            $('input[name="fav_fix3"]').prop( "checked", false );
        });
        $(document).on('change','#doan', function(){
            $('input[name="fav_fix2"]').prop( "checked", false );
            $('input[name="fav_fix1"]').prop( "checked", false );
        });

        $(document).on('click', '#fixctl', function(){
            var array=new Array();
            var mang2= new Array();
            var input1=' <input type="text" class="form-control" id="radio_name" name="radio_name" value="';
            var input2='"><br>';
            var c="";
            var d="";
            //dem so radio bỏ dô đây
            var x1=  $('input[name="cust_vt"]').val();
            var n=$('input[name="countD_radio'+x1+'"]').val();
            // alert(n);
            for( var x=0; x<n; x++){
                c=$('#danhsach'+x1+x).val();
                //d=' <input type="text" class="form-control" id="radio_name'+x+'" name="radio_name" value="'+c+input2;
                array.push(c);
            }
            var n1=array.length;
            for( var t=0; t<n1;t++){
                d=' <div class="row" id="hang'+t+'"> <div class="col-md-8 float-right"> <input type="text" class="form-control" id="radio_name'+t+'" name="radio_name'+t+'" value="'+array[t]+input2 +'</div>' +'<div class="col-md-3 float-right"><button id="'+t+'" class="btn btn-danger ml-3 btnxoa2">Xóa</button></div></div>';
                mang2.push(d);
            }
            //x1 là vị trí câu hỏi trong mảng, n1 là tổng số checkbox
            var total='<input type="hidden" id="lenghtpopup'+x1+'" name="lenghtpopup'+x1+'" value="'+n1+'"><button class="btn btn-primary mb-3 themtxt" id="'+x1+n1+'">Thêm câu trả lời</button><br>'+mang2.join(' ');
            $('#sua3').html(total);
        });
        $(document).on('click','.btnxoa2',function(){
            var id = $(this).attr("id");
            $('#hang'+id+'').remove();
        });
        //Thêm text cho popup
        $(document).on('click','.themtxt',function(){
        });
        $('#savechange').click(function(){
            var a =  $('#cs_mang').val();
            var b= $('#suatxt').val();
            var fix="";
            var tmp="";
            var mangtam1=new Array();
            if($('input[name="fav_fix1"]:checked').val()!=undefined){
                tmp=$('input[name="fav_fix1"]:checked').val();
            } else if($('input[name="fav_fix2"]:checked').val()!=undefined){
                tmp=$('input[name="fav_fix2"]:checked').val();
            } else if($('input[name="fav_fix3"]:checked').val()!=undefined){
                tmp=$('input[name="fav_fix3"]:checked').val();
            }
            var m1 = new Array();
            if(tmp==01){
                var d1='<input type="radio" class="mr-3" name="radio_x" value="';
                var d2='">';
                var m2=new Array();
                //dem so radio bo do day
                var d= (label.length)-1;
                var tong="";
                for(c=0;c<=z;c++){
                    var tam2=$('#radio_name'+c).val();
                    if(tam2 !=undefined){
                        // var tong='<input type="radio" class="mr-3" id="danhsach'+d+c+'" name="text'+d+'" value="'+tam2+'">'+tam2+'<br>';
                        // m1.push(tong);
                        mangtam1.push(tam2);
                    }
                }
                var e=mangtam1.length;
                for( var m=0;m<e;m++){
                    tong='<input type="radio" class="mr-3" id="danhsach'+d+m+'" name="text'+d+'" value="'+mangtam1[m]+'">'+mangtam1[m]+'<br>';
                    m1.push(tong);
                }
                var n=m1.length;
                fix = m1.join(" ")+'<input type="hidden" name="countD_radio'+d+'" value="'+n+'"><input type="hidden" name="cau'+d+'" value="radio">';
            } else if(tmp==02){
                fix='<input type="text" class="form-control" name="textctl"/>';
            } else if(tmp==03){
                fix= '<textarea name="textctl" class="form-control" rows="4" cols="50"></textarea>';
            }
            var t=parseInt(a, 10)+1;
            label.fill(b,a,t);// câu hỏi
            code.fill(fix,a,t);// câu tl
        });
        //end QUAN TRỌNG
        // xử lý tiêu đề
        $('#savetieude').click(function(){
            var a = $('input[name="tieude"]').val();
            $('#tit1').html(a);
        });
        // reset
        $('#lammoi').click(function(){
            $('#test').val('');
            $('input[name="fav_language"]:checked').prop( "checked", false );
            for(a=1;a<=z;a++){
                $('#row'+a+'').remove();
            }
            return i=1;
            //alert(z);
        });
        $('#dong_form').click(function(){
            $('input[name="fav_fix2"]').prop( "checked", false );
            $('input[name="fav_fix1"]').prop( "checked", false );
            $('input[name="fav_fix3"]').prop( "checked", false );
            showform(label,code);
        });

        //Xử lý đưa dữ liệu sang form
        $('#check01').click(function(){
            var a=$('input[name="fav_language"]:checked').val();
            var b=$('input[name="txtcauhoi"]').val();
            var a1="";
            var c1=new Array();
            var p=label.length;
            if(a==02){
                a1='<input type="text" class="form-control" name="text'+p+'"/> <input type="hidden" name="cau'+p+'" value="input">';
            }
            if(a==03){
                a1='<textarea name="text'+p+'" class="form-control" rows="4" cols="50"></textarea> <input type="hidden" name="cau'+p+'" value="textarea">';
            } else if(a==01){
                var mang_txt = new Array();
                var d1='<input type="radio" class="mr-3" name="radio_x" value="';
                var d2='">';
                var tmp_x=new Array();
                for(c=2;c<=z;c++){
                    var cz='txtcheck'+c;
                    var tam2=$('input[name=txtcheck'+c+']').val();
                    if(tam2 != undefined){
                        c1.push(tam2);
                    }
                }
                var q=c1.length;
                var m=label.length;
                for( var e=0;e<q;e++){
                    var data=c1[e];
                    var tong='<input type="radio" class="mr-3" id="danhsach'+m+e+'" name="text'+p+'" value="'+data+d2+data+'<br>';
                    mang_txt.push(tong);
                }
                var x=label.length;
                mang_txt.push('<input type="hidden" name="countD_radio'+x+'" value="'+q+'"><input type="hidden" name="cau'+p+'" value="radio">');
                var a1 = mang_txt.join(" ");
            }

            label.push(b);
            code.push(a1);
            showform(label,code);
            $('#test').val('');
            $('input[name="fav_language"]:checked').prop( "checked", false );
            for(var x=1;x<=z;x++){
                $('#row'+x+'').remove();
            }
        })

        $('#savecode').click(function(){
            var code1=document.getElementsByTagName("form")[1].innerHTML;
            var code2=document.getElementsByTagName("form")[0].innerHTML;
            var total=code2+code1;
            $('#final').val(total);
        })
    });

    $('#btnAddOrUpdateSurveyForm').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#surveyFormId').val();
        if (id == "") {
            addSurveyForm(data);
        } else {
            updateSurveyForm(data);
        }
    });

    function addSurveyForm(data) {
        $.ajax({
            url: '${surveyFormAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyFormURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${surveyFormURL}?page=1&limit=10&message=error_system";
            }
        });
    }

    function updateSurveyForm(data) {
        $.ajax({
            url: '${surveyFormAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editSurveyFormURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editSurveyFormURL}?id="+result.id+"&message=error_system";
            }
        });
    }
</script>
</body>
</html>
