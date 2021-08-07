package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.service.ISurveyObject;
import com.springmvcproject.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value="surveyObjectControllerOfdmin")

public class SurveyObjectController {

    @Autowired
    private ISurveyObject surveyObject;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/ds-doi-tuong", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest request) {
        //@ModelAttribute("model") NewDTO model
        SurveyObjectDTO model = new SurveyObjectDTO();
        ModelAndView mav = new ModelAndView("admin/surveyObject/list");
        model.setListResult(surveyObject.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/bai-viet/cs-doi-tuong", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/surveyObject/edit");
        SurveyObjectDTO model = new SurveyObjectDTO();
        if (id != null) {
            model =surveyObject.findById(id);
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
