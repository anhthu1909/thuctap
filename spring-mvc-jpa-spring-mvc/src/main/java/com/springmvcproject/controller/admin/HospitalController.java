package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.HospitalDTO;
import com.springmvcproject.service.IHospitalService;
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

@Controller(value = "hospitalControllerOfAdmin")
public class HospitalController {

    @Autowired
    private IHospitalService hospitalService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/benh-vien/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        HospitalDTO model = new HospitalDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/hospital/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(hospitalService.findAll(pageable));
        model.setTotalItem(hospitalService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/benh-vien/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editHospital(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/hospital/edit");
        HospitalDTO model = new HospitalDTO();
        if (id != null) {
            model = hospitalService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        //mav.addObject("categories", categoryService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
