INSERT INTO "ROLES"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "CODE", "NAME") VALUES ('1', NULL, NULL, NULL, NULL, 'ADMIN', 'Quản trị');
INSERT INTO "ROLES"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "CODE", "NAME") VALUES ('2', NULL, NULL, NULL, NULL, 'USER', 'Người dùng');
INSERT INTO "SURVEYANSWER"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "CONTENT", "SURVEYFORM_ID", "USERS_ID") VALUES ('1', NULL, NULL, NULL, NULL, '<div class="col-md-12 text-center" ><label id="tieude">Phiếu khảo sát người bệnh nội trú</label></div><div class="col-md-8 mt-2" id="row0"> <label class="nhan">A. THÔNG TIN BỆNH NHÂN</label><br><label class="cautraloi">Đáp án: Không có câu trả lời</label></div> <div class="col-md-8 mt-2" id="row1"> <label class="nhan">A1. Giới tính</label><br><label class="cautraloi">Đáp án: Nữ</label></div> <div class="col-md-8 mt-2" id="row2"> <label class="nhan">A2. Trình độ học vấn</label><br><label class="cautraloi">Đáp án: Đại học</label></div> <div class="col-md-8 mt-2" id="row3"> <label class="nhan">B. MỨC ĐỘ HÀI LÒNG KI SỬ DỤNG DỊCH VỤ Y TẾ</label><br><label class="cautraloi">Đáp án: Đại học</label></div> <div class="col-md-8 mt-2" id="row4"> <label class="nhan">B1. Các biển báo chỉ dẫn đến BV dễ nhìn</label><br><label class="cautraloi">Đáp án: Hài lòng</label></div> <div class="col-md-8 mt-2" id="row5"> <label class="nhan">B2. Nhân viên y tế hướng dẫn sử dụng thuốc rõ ràng</label><br><label class="cautraloi">Đáp án: Bình thường</label></div> <div class="col-md-8 mt-2" id="row6"> <label class="nhan">Ông/ Bà đánh giá mức độ hài lòng về giá cả dịch vụ y tế</label><br><label class="cautraloi">Đáp án: Hài lòng</label></div>', '4', '1');
INSERT INTO "SURVEYFORM"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "CONTENT") VALUES ('4', NULL, NULL, NULL, NULL, '
                        <label class=" mt-2 mb-2" id="tit1" style="font-size:32px; font-weight: 500; ">Phiếu khảo sát người bệnh nội trú</label>
                    <div class="col-md-8 mt-2" id="cot0"><label id="settxt0">A. THÔNG TIN BỆNH NHÂN</label><input type="hidden" id="custId0" name="custId" value="0"><div id="setctl0"><input type="hidden" name="countD_radio0" value="0"><input type="hidden" name="cau0" value="radio"></div> <button type="button" id="0" value="0" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="0" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot1"><label id="settxt1">A1. Giới tính</label><input type="hidden" id="custId1" name="custId" value="1"><div id="setctl1"><input type="radio" class="mr-3" id="danhsach10" name="text1" value="Nam">Nam<br> <input type="radio" class="mr-3" id="danhsach11" name="text1" value="Nữ">Nữ<br> <input type="hidden" name="countD_radio1" value="2"><input type="hidden" name="cau1" value="radio"></div> <button type="button" id="1" value="1" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="1" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot2"><label id="settxt2">A2. Trình độ học vấn</label><input type="hidden" id="custId2" name="custId" value="2"><div id="setctl2"><input type="radio" class="mr-3" id="danhsach20" name="text2" value="Tiểu học">Tiểu học<br> <input type="radio" class="mr-3" id="danhsach21" name="text2" value="THCS">THCS<br> <input type="radio" class="mr-3" id="danhsach22" name="text2" value="THPT">THPT<br> <input type="radio" class="mr-3" id="danhsach23" name="text2" value="Trung cấp/Cao đẳng">Trung cấp/Cao đẳng<br> <input type="radio" class="mr-3" id="danhsach24" name="text2" value="Đại học">Đại học<br> <input type="radio" class="mr-3" id="danhsach25" name="text2" value="Trên đại học">Trên đại học<br> <input type="hidden" name="countD_radio2" value="6"><input type="hidden" name="cau2" value="radio"></div> <button type="button" id="2" value="2" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="2" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot3"><label id="settxt3">B. MỨC ĐỘ HÀI LÒNG KI SỬ DỤNG DỊCH VỤ Y TẾ</label><input type="hidden" id="custId3" name="custId" value="3"><div id="setctl3"></div> <button type="button" id="3" value="3" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="3" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot4"><label id="settxt4">B1. Các biển báo chỉ dẫn đến BV dễ nhìn</label><input type="hidden" id="custId4" name="custId" value="4"><div id="setctl4"><input type="radio" class="mr-3" id="danhsach40" name="text4" value="Rất không hài lòng">Rất không hài lòng<br> <input type="radio" class="mr-3" id="danhsach41" name="text4" value="Không hài lòng">Không hài lòng<br> <input type="radio" class="mr-3" id="danhsach42" name="text4" value="Bình thường">Bình thường<br> <input type="radio" class="mr-3" id="danhsach43" name="text4" value="Hài lòng">Hài lòng<br> <input type="radio" class="mr-3" id="danhsach44" name="text4" value="Rất hài lòng">Rất hài lòng<br> <input type="hidden" name="countD_radio4" value="5"><input type="hidden" name="cau4" value="radio"></div> <button type="button" id="4" value="4" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="4" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot5"><label id="settxt5">B2. Nhân viên y tế hướng dẫn sử dụng thuốc rõ ràng</label><input type="hidden" id="custId5" name="custId" value="5"><div id="setctl5"><input type="radio" class="mr-3" id="danhsach50" name="text5" value="Rất không hài lòng">Rất không hài lòng<br> <input type="radio" class="mr-3" id="danhsach51" name="text5" value="Không hài lòng">Không hài lòng<br> <input type="radio" class="mr-3" id="danhsach52" name="text5" value="Bình thường">Bình thường<br> <input type="radio" class="mr-3" id="danhsach53" name="text5" value="Hài lòng">Hài lòng<br> <input type="radio" class="mr-3" id="danhsach54" name="text5" value="Rất hài lòng">Rất hài lòng<br> <input type="hidden" name="countD_radio5" value="5"><input type="hidden" name="cau5" value="radio"></div> <button type="button" id="5" value="5" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="5" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div> <div class="col-md-8 mt-2" id="cot6"><label id="settxt6">Ông/ Bà đánh giá mức độ hài lòng về giá cả dịch vụ y tế</label><input type="hidden" id="custId6" name="custId" value="6"><div id="setctl6"><input type="radio" class="mr-3" id="danhsach60" name="text6" value="Rất không hài lòng">Rất không hài lòng<br> <input type="radio" class="mr-3" id="danhsach61" name="text6" value="Không hài lòng">Không hài lòng<br> <input type="radio" class="mr-3" id="danhsach62" name="text6" value="Bình thường">Bình thường<br> <input type="radio" class="mr-3" id="danhsach63" name="text6" value="Hài lòng">Hài lòng<br> <input type="radio" class="mr-3" id="danhsach64" name="text6" value="Rất hài lòng">Rất hài lòng<br> <input type="hidden" name="countD_radio6" value="5"><input type="hidden" name="cau6" value="radio"></div> <button type="button" id="6" value="6" class="btn btn-primary mt-2 btnsua" data-toggle="modal" data-target="#exampleModalCenter">   Sửa câu hỏi </button> <button id="6" class="btn btn-danger mt-2 btnform" data-toggle="modal" data-target="#thongbaoxoa">Xóa</button></div><input type="hidden" id="socauhoi" name="socauhoi" value="7">');
INSERT INTO "SURVEYOBJECT"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('1', 'admin', TO_DATE('2021-08-06 23:06:34', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:06:34', 'SYYYY-MM-DD HH24:MI:SS'), 'Người bệnh nội trú');
INSERT INTO "SURVEYOBJECT"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('2', 'admin', TO_DATE('2021-08-06 23:30:58', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:31:10', 'SYYYY-MM-DD HH24:MI:SS'), 'Người bệnh ngoại trú');
INSERT INTO "SURVEYOBJECT"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('3', 'admin', TO_DATE('2021-08-06 23:32:23', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:32:23', 'SYYYY-MM-DD HH24:MI:SS'), 'Nhân viên y tế');
INSERT INTO "SURVEYOBJECT"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('4', 'admin', TO_DATE('2021-08-06 23:32:37', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:32:37', 'SYYYY-MM-DD HH24:MI:SS'), 'Người mẹ nuôi con bằng sữa');
INSERT INTO "SURVEYOBJECT"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('5', 'admin', TO_DATE('2021-08-06 23:35:45', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:35:45', 'SYYYY-MM-DD HH24:MI:SS'), 'Người mẹ sinh con tại bệnh viện');
INSERT INTO "SURVEYTYPE"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('1', 'admin', TO_DATE('2021-08-06 23:39:44', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:39:44', 'SYYYY-MM-DD HH24:MI:SS'), 'Khảo sát thường quy trong năm');
INSERT INTO "SURVEYTYPE"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('2', 'admin', TO_DATE('2021-08-06 23:39:52', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:39:52', 'SYYYY-MM-DD HH24:MI:SS'), 'Do đoàn Bộ Y tế/Sở y tế thực hiện');
INSERT INTO "SURVEYTYPE"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('3', 'admin', TO_DATE('2021-08-06 23:39:58', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:39:58', 'SYYYY-MM-DD HH24:MI:SS'), 'Do đoàn kiểm tra chéo');
INSERT INTO "SURVEYTYPE"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('4', 'admin', TO_DATE('2021-08-06 23:40:04', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:40:04', 'SYYYY-MM-DD HH24:MI:SS'), 'Do đoàn kiểm tra nội bộ thực hiện');
INSERT INTO "SURVEYTYPE"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "NAME") VALUES ('5', 'admin', TO_DATE('2021-08-06 23:40:11', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2021-08-06 23:40:11', 'SYYYY-MM-DD HH24:MI:SS'), 'Do đoàn phúc tra của BYT thực hiện');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('1', NULL, NULL, NULL, NULL, 'Nguyễn Thị A', 'admin', '123456', '1');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('2', NULL, NULL, NULL, NULL, 'Bệnh Viện Bạch Mai', 'bvbachmai', '123456', '1');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('3', NULL, NULL, NULL, NULL, 'Bệnh viện Việt Đức', 'bvvietduc', '123456', '1');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('4', NULL, NULL, NULL, NULL, 'Bệnh viện Trung ương Huế', 'bvtuhue', '123456', '1');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('5', NULL, NULL, NULL, NULL, 'Bệnh viện Chợ Rẫy TP Hồ Chí Minh', 'bvchoraytphcm', '123456', '1');
INSERT INTO "USERS"("ID", "CREATEDBY", "CREATEDDATE", "MODIFIEDBY", "MODIFIEDDATE", "FULLNAME", "NAME", "PASSWORD", "STATUS") VALUES ('6', NULL, NULL, NULL, NULL, 'Bệnh Viện Đa khoa Cần Thơ', 'bvdakhoacantho', '123456', '1');
INSERT INTO "USERS_ROLES"("USERSID", "ROLESID") VALUES ('1', '1');
INSERT INTO "USERS_ROLES"("USERSID", "ROLESID") VALUES ('2', '2');
INSERT INTO "USERS_ROLES"("USERSID", "ROLESID") VALUES ('3', '2');
INSERT INTO "USERS_ROLES"("USERSID", "ROLESID") VALUES ('4', '2');
INSERT INTO "USERS_ROLES"("USERSID", "ROLESID") VALUES ('5', '2');
