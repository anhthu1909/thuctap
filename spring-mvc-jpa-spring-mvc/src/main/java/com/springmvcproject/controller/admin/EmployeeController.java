package com.springmvcproject.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.springmvcproject.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcproject.dto.EmployeeDTO;
import com.springmvcproject.service.IEmployeeService;
import com.springmvcproject.util.MessageUtil;

@Controller(value = "employeeControllerOfAdmin")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IHospitalService hospitalService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/nhan-vien/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        EmployeeDTO model = new EmployeeDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/employee/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(employeeService.findAll(pageable));
        model.setTotalItem(employeeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/nhan-vien/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/employee/edit");
        EmployeeDTO model = new EmployeeDTO();
        if (id != null) {
            model = employeeService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("hospitals", hospitalService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
