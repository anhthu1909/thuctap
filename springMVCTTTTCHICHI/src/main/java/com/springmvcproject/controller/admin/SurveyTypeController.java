package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.service.ISurveyType;
import com.springmvcproject.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller(value="surveyTypeControllerOfadmin")

public class SurveyTypeController {
    @Autowired
  private ISurveyType surveyType;
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-kieu", method = RequestMethod.GET)
    public ModelAndView showList( HttpServletRequest request) {
                            //@ModelAttribute("model") NewDTO model
        SurveyTypeDTO model=new SurveyTypeDTO();
        ModelAndView mav = new ModelAndView("admin/surveyType/list");
       model.setListResult(surveyType.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
      mav.addObject("model", model);
        return mav;

    }
   @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-kieu", method = RequestMethod.GET)
   public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
       ModelAndView mav = new ModelAndView("admin/surveyType/edit");
       SurveyTypeDTO model = new SurveyTypeDTO();
       if (id != null) {
           model = surveyType.findById(id);
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
