package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyFormDTO;
import com.springmvcproject.service.ISurveyForm;
import com.springmvcproject.service.IUser;
import com.springmvcproject.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value="surveyFormControllerOfadmin")
public class SurveyFormController {

    @Autowired
    private ISurveyForm surveyForm;

    @Autowired
    private IUser user;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-pks", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest request) {
        //@ModelAttribute("model") NewDTO model
       SurveyFormDTO model=new SurveyFormDTO();
        ModelAndView mav = new ModelAndView("admin/surveyForm/list");
        model.setListResult(surveyForm.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-pksmoi", method = RequestMethod.GET)
    public ModelAndView addList(HttpServletRequest request) {
        //@ModelAttribute("model") NewDTO model
        SurveyFormDTO model=new SurveyFormDTO();
        ModelAndView mav = new ModelAndView("admin/surveyForm/add");
        model.setListResult(surveyForm.findAll());
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/meo", method = RequestMethod.POST)
    public ModelAndView add() {
        SurveyFormDTO model=new SurveyFormDTO();
        ModelAndView mav = new ModelAndView("admin/new/meo");
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/insert", method = RequestMethod.POST)
    public ModelAndView insert() {
        SurveyFormDTO model=new SurveyFormDTO();
        ModelAndView mav = new ModelAndView("admin/surveyForm/insert");
        mav.addObject("model", model);
        return mav;
    }
    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-pks", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request ) {
        ModelAndView mav = new ModelAndView("admin/surveyForm/edit");
        SurveyFormDTO model = new SurveyFormDTO();
        if (id != null) {
            model = surveyForm.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("user", user.findAll());
        mav.addObject("model", model);
        return mav;
    }
}

