package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.service.ISurveyObjectService;
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

@Controller(value = "surveyObjectControllerOfAdmin")
public class SurveyObjectController {

    @Autowired
    private ISurveyObjectService surveyObjectService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/doi-tuong-khao-sat/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        SurveyObjectDTO model = new SurveyObjectDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/surveyObject/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(surveyObjectService.findAll(pageable));
        model.setTotalItem(surveyObjectService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/doi-tuong-khao-sat/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editSurveyObject(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/surveyObject/edit");
        SurveyObjectDTO model = new SurveyObjectDTO();
        if (id != null) {
            model = surveyObjectService.findById(id);
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
