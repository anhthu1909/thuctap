package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyAnswerDTO;
import com.springmvcproject.service.ISurveyAnswer;
import com.springmvcproject.service.ISurveyForm;
import com.springmvcproject.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value="surveyAnswerControllerOfadmin")

public class SurveyAnswerController {
    @Autowired
    private ISurveyAnswer newService;

    @Autowired
    private ISurveyForm surveyForm;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-answer", method = RequestMethod.GET)
    public ModelAndView showList( HttpServletRequest request) {

        SurveyAnswerDTO model=new SurveyAnswerDTO();
        ModelAndView mav = new ModelAndView("admin/surveyAnswer/list");
        model.setListResult(newService.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-answer", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request ) {
        ModelAndView mav = new ModelAndView("admin/surveyAnswer/edit");
        SurveyAnswerDTO model = new SurveyAnswerDTO();
        if (id != null) {
            model = newService.findById(id);
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
