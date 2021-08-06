package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.NewDTO;
import com.springmvcproject.service.INew;
import com.springmvcproject.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller(value="newControllerOfadmin")

public class NewController {
    @Autowired
  private INew newService;
    @Autowired
    private MessageUtil messageUtil;
    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList( HttpServletRequest request) {
                            //@ModelAttribute("model") NewDTO model
        NewDTO model=new NewDTO();
        ModelAndView mav = new ModelAndView("admin/new/list");
       model.setListResult(newService.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
      mav.addObject("model", model);
        return mav;

    }
   @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
   public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request ) {
       ModelAndView mav = new ModelAndView("admin/new/edit");
       NewDTO model = new NewDTO();
       if (id != null) {
           model = newService.findById(id);
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
