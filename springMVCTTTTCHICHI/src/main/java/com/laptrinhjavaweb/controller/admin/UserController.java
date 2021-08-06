package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUser;
import com.laptrinhjavaweb.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller(value="userControllerOfadmin")

public class UserController {


    @Autowired
    private IUser user;
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-user", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest request) {
        //@ModelAttribute("model") NewDTO model
        UserDTO model = new UserDTO();
        ModelAndView mav = new ModelAndView("admin/user/list");
        model.setListResult(user.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;

    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-user", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/edit");
        UserDTO model = new UserDTO();
        if (id != null) {
            model =user.findById(id);
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
