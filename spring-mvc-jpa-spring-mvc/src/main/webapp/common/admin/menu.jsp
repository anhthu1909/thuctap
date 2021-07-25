<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
                Loại bài viết
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/loai-bai-viet/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách loại bài viết
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
                Bài viết
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bài viết
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class=""></i>
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
                Bệnh viện
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/benh-vien/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bệnh viện
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class=""></i>
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
                Nhân viên bệnh viện
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/nhan-vien/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách nhân viên
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class=""></i>
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
               Đối tượng khảo sát
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/doi-tuong-khao-sat/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách đối tượng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class=""></i>
<%--                <i class="menu-icon fa fa-list-alt"></i>--%>
                <span class="menu-text"></span>
                Kiểu khảo sát
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/kieu-khao-sat/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách kiểu khảo sát
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

<%--    <ul class="nav nav-list">--%>
<%--        <li >--%>
<%--            <a href="#" class="dropdown-toggle">--%>
<%--&lt;%&ndash;                <i class="menu-icon fa fa-list-alt"></i>&ndash;%&gt;--%>
<%--                <span class="menu-text"></span>--%>
<%--                Phiếu khảo sát--%>
<%--                <b class="arrow fa fa-angle-down"></b>--%>
<%--            </a>--%>
<%--            <b class="arrow"></b>--%>
<%--            <ul class="submenu">--%>
<%--                <li>--%>
<%--                    <a href="<c:url value='/quan-tri/phieu-khao-sat/danh-sach?page=1&limit=2'/>">--%>
<%--                        <i class="menu-icon fa fa-caret-right"></i>--%>
<%--                        Danh sách phiếu khảo sát--%>
<%--                    </a>--%>
<%--                    <b class="arrow"></b>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--    </ul>--%>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <span class="menu-text"></span>
                Quyền người dùng
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/quyen/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách quyền
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <span class="menu-text"></span>
                Tài khoản người dùng
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/nguoi-dung/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách người dùng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>

    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>