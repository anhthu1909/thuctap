<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="employeeURL" value="/quan-tri/nhan-vien/danh-sach"/>
<c:url var="editEmployeeURL" value="/quan-tri/nhan-vien/chinh-sua"/>
<c:url var="employeeAPI" value="/api/employee"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo test</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-12 mt-3">
        <h3>Thêm câu hỏi mới</h3>
        <div class="row mt-3 pt-3 pb-3">

            <!--Thêm câu hỏi-->

            <div class="col-md-5 float-right pt-3" id="getcode" style="border:1px solid #000">
                <div class="col-md-12 pb-3 pt-3 text-center">
                    <label>Tên phiếu khảo sát</label>
                    <input type="text" id="tieude" name="tieude" class="form-control">
                    <button id="savetieude" class="btn btn-primary mt-3">Lưu tiêu đề</button>
                </div>
                <label class="mt-3">
                    Nhập câu hỏi
                </label>
                <input type="text" id="test" class="form-control" name="txtcauhoi">
                <div class="check1">
                    <label>Chọn loại trả lời</label><br>
                    <input type="radio" id="check_radio" name="fav_language" value="01">
                      <label for="check_radio">Check</label>
                      <input type="radio" id="tln" name="fav_language" value="02">
                      <label for="tln">Trả lời ngắn</label>
                      <input type="radio" id="doan" name="fav_language" value="03">
                    <label for="doan">Đoạn</label>
                </div>

                <div id="forcheck">
                    <button id="btnthem" class="btn btn-primary">Thêm câu trả lời</button>
                </div>

                <input type="button" class="btn btn-primary mb-3 mt-3" id="check01" value="Lưu câu hỏi">
                <input type="reset" id="lammoi" class="btn btn-primary mb-3 mt-3" value="Tạo câu hỏi mới">

            </div>

            <!--Danh sách câu hỏi-->
            <div class="col-md-6 float-right ml-3" id="formchinh" style="border:1px solid #000">

                <!--Form này dùng để lưu tạm code ĐỪNG CODE TRÊN FORM NÀYl-->
                <form action="#" id="pks">
                    <label class="text-center mt-2 mb-2" id="tit1" style="font-size:32px ">
                        Phiếu khảo sát
                    </label>
                </form>
                <!--xử lý lưu dữ liệu bàng form dưới đây-->
                <form action="meommeo.php" method="post">
                    <input type="button" class="btn btn-primary float-right" value="Lưu phiếu khảo sát" id="savecode">
                    <input type="text" name="final" id="final" style="opacity:1;">
                </form>
            </div>
        </div>

    </div>
</div>
<div>

</div>
<script>
    $(document).ready(function () {
        var i = 1;
        var z = "";
        $('#forcheck').hide();
        $('#check_radio').click(function () {
            $('#forcheck').show();
        });
        //Thêm ô nhập liệu
        $('#btnthem').click(function () {
            i++;
            $('#forcheck').append('<div class="row mt-3 ml-3" id="row' + i + '"> <input type="text" name="txtcheck' + i + '"> <button id="' + i + '" class="btn btn-primary ml-3 btnxoa">Xóa</button> </div>');
            return z = i;
        });
        // Xóa ô nhập liệu
        $(document).on('click', '.btnxoa', function () {
            var button_id = $(this).attr("id");
            $('#row' + button_id + '').remove();

        });
        // xử lý tiêu đề
        $('#savetieude').click(function () {
            var a = $('input[name="tieude"]').val();
            $('#tit1').html(a);
        });
        // reset
        $('#lammoi').click(function () {
            $('#test').val('');
            $('#forcheck').hide();

        });

        //Xử lý đưa dữ liệu sang form
        $('#check01').click(function () {
            var a = $('input[name="fav_language"]:checked').val();
            var b = $('input[name="txtcauhoi"]').val();
            var a1 = "";
            if (a == 0o2) {
                a1 = '<input type="text" class="form-control" name="textctl[]"/>';
            }
            if (a == 0o3) {
                a1 = '<textarea name="cautraloidai" class="form-control" rows="4" cols="50"></textarea>';

            } else if (a == 0o1) {
                var mang_txt = new Array();
                var d1 = '<input type="radio" class="mr-3" name="radio_x" value="';
                var d2 = '">';
                var tmp_x = new Array();
                for (c = 2; c <= z; c++) {
                    var cz = 'txtcheck' + c;
                    var tam2 = $('input[name=txtcheck' + c + ']').val();
                    var tong = d1 + tam2 + d2 + tam2 + '<br>';
                    mang_txt.push(tong);
                }
                var a1 = mang_txt.join(" ");
                // <input type="radio" name="radio_x" value="">
            }
            var html1 = '<div class="col-md-8 mt-2">';
            var html2 = '<label id="settxt">';
            var html3 = '</label>';
            var html4 = '<div id=setctl>';
            var html5 = '</div>';
            var html6 = '</div>';
            var data = html1 + html2 + b + html3 + html4 + a1 + html5 + html6;
            $('#pks').append(data);

        })
        $('#savecode').click(function () {
            var code1 = document.getElementsByTagName("form")[0].innerHTML;
            //alert(code1);
            $('#final').val(code1);
        })
    });
</script>
</body>
</html>