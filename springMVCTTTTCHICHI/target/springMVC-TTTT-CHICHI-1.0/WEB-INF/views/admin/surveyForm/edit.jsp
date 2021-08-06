<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="surveyFormURL" value="/quan-tri/bai-viet/danh-sach-pks"/>
<c:url var="editSurveyFormURL" value="/quan-tri/bai-viet/chinh-sua-pks"/>
<c:url var="surveyFormAPI" value="/api/phieuks"/>
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
    <div class="container mt-3">

        <div class="container mt-3">

            <!--đổ code html của pks trong csdl ra thẻ div có id showcode-->
            <div id="showcode">

                <!-- <div class="col-md-8 mt-2" id="cot0"><label id="settxt0">Câu 1: Chọn phương án đúng nhất trong các phương án sau</label><input type="hidden" id="custId0" name="custId" value="0"><div id="setctl0"><input type="radio" class="mr-3" id="danhsach00" name="text0" value="1">1<br> <input type="radio" class="mr-3" id="danhsach01" name="text0" value="2">2<br> <input type="radio" class="mr-3" id="danhsach02" name="text0" value="3">3<br> <input type="radio" class="mr-3" id="danhsach03" name="text0" value="4">4<br> <input type="hidden" name="countD_radio0" value="4"><input type="hidden" name="cau0" value="radio"></div> <button type="button" id="0" value="0" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="0" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot1"><label id="settxt1">Câu 2: "1+1 có phải bằng 2 không". Các bạn hãy chọn phương án đúng nhất?</label><input type="hidden" id="custId1" name="custId" value="1"><div id="setctl1"><input type="radio" class="mr-3" id="danhsach10" name="text1" value="Có">Có<br> <input type="radio" class="mr-3" id="danhsach11" name="text1" value="Không">Không<br> <input type="hidden" name="countD_radio1" value="2"><input type="hidden" name="cau1" value="radio"></div> <button type="button" id="1" value="1" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="1" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot2"><label id="settxt2">Câu 3: Nguyễn Huệ sinh năm bao nhiêu?</label><input type="hidden" id="custId2" name="custId" value="2"><div id="setctl2"><input type="text" class="form-control" name="text2"> <input type="hidden" name="cau2" value="input"></div> <button type="button" id="2" value="2" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="2" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot3"><label id="settxt3">Câu 4: Hãy nêu ý kiến của em về việc ... ?</label><input type="hidden" id="custId3" name="custId" value="3"><div id="setctl3"><textarea name="text3" class="form-control" rows="4" cols="50"></textarea> <input type="hidden" name="cau3" value="textarea"></div> <button type="button" id="3" value="3" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="3" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div><input type="hidden" id="socauhoi" name="socauhoi" value="4">
             -->

                <tr>
                    <td>${model.content}</td>
                </tr>

            </div>
            <!--end -->
            <!--Form dùng để lưu kết quả lên server-->
            <form action="insert" method='POST'>
                <textarea id="ketqua" name="ketqua" rows="5" cols="50" style="opacity: 0;"></textarea>

                <input type="hidden" name="mapks" value="${model.id}" >
                 <c:forEach var="item" items="${user}">
                     <input type="hidden" name="user" value="${item.id}">
                 </c:forEach>
                <input type="submit" id="luukq" name="luukq" class="btn btn-primary" data-toggle="modal" data-target="#thongbao" value="Lưu phiếu khảo sát">
            </form>
            <!--popup thông báo -->
            <div class="modal fade" id="thongbao" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
                                    Hoàn thành đánh giá
                                </label>
                            </div>

                        </div>
                        <div class="modal-footer" style="border: none;">
                            <button type="button" class="btn btn-secondary" id="dong_form" data-dismiss="modal">Đóng</button>

                        </div>
                    </div>
                </div>
            </div>
            <!--end popup-->
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

    </script>
</body>
</html>