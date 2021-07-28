package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.AdminDTO;
import com.springmvcproject.service.IAdminService;
import com.springmvcproject.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "adminControllerOfAdmin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/quan-tri-vien/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        AdminDTO model = new AdminDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/admin/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(adminService.findAll(pageable));
        model.setTotalItem(adminService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/quan-tri-vien/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editAdmin(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/admin/edit");
        AdminDTO model = new AdminDTO();
        if (id != null) {
            model = adminService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
