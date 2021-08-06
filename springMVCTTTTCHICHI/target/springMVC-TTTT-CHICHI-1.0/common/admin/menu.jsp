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
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý hệ thống
                <b class="arrow fa fa-angle-down"></b>
            </a>


            <b class="arrow"></b>
            <ul class="submenu">
                <!--<li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        DS bài viết
                    </a>
                    <b class="arrow"></b>
                </li>-->
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach-pks'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý phiếu khảo sát
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach-answer'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý câu trả lời
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/ds-doi-tuong'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                       Quản lý đối tượng
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach-kieu'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý kiểu khảo sát
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach-user'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý thành viên
                    </a>
                    <b class="arrow"></b>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/danh-sach-role'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý quyền
                    </a>
                    <buser class="arrow"></buser>
                </li>
                <li>
                    <a href="<c:url value='/quan-tri/bai-viet/chinh-sua-mix'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Quản lý phân quyền
                    </a>
                    <buser class="arrow"></buser>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>