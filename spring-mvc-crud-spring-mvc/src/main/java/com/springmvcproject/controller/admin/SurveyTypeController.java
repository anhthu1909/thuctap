package com.springmvcproject.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.service.ISurveyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcproject.util.MessageUtil;

@Controller(value = "surveyTypeControllerOfAdmin")
public class SurveyTypeController {

    @Autowired
    private ISurveyTypeService surveyTypeService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/kieu-khao-sat/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        SurveyTypeDTO model = new SurveyTypeDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/surveyType/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(surveyTypeService.findAll(pageable));
        model.setTotalItem(surveyTypeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/kieu-khao-sat/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editSurveyType(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/surveyType/edit");
        SurveyTypeDTO model = new SurveyTypeDTO();
        if (id != null) {
            model = surveyTypeService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
//        mav.addType("categories", surveyTypeService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
