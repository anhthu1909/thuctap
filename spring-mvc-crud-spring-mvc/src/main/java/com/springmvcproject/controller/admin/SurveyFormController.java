package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyFormDTO;
import com.springmvcproject.service.ISurveyFormService;
import com.springmvcproject.service.ISurveyObjectService;
import com.springmvcproject.service.ISurveyTypeService;
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

@Controller(value = "surveyFormControllerOfAdmin")
public class SurveyFormController {

    @Autowired
    private ISurveyFormService surveyFormService;

    @Autowired
    private ISurveyObjectService surveyObjectService;

    @Autowired
    private ISurveyTypeService surveyTypeService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/phieu-khao-sat/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        SurveyFormDTO model = new SurveyFormDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/surveyForm/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(surveyFormService.findAll(pageable));
        model.setTotalItem(surveyFormService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/phieu-khao-sat/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editSurveyForm(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/surveyForm/edit");
        SurveyFormDTO model = new SurveyFormDTO();
        if (id != null) {
            model = surveyFormService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("surveyObjects", surveyObjectService.findAll());
        mav.addObject("surveyTypes", surveyTypeService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
