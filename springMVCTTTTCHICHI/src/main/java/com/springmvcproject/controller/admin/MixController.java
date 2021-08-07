package com.springmvcproject.controller.admin;

import com.springmvcproject.dto.MixDTO;
import com.springmvcproject.service.IMix;
import com.springmvcproject.service.IRole;
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

@Controller(value="mixControllerOfadmin")

public class MixController {

    @Autowired
    private IMix mixService;

    @Autowired
    private IRole roleService;

    @Autowired
    private IUser userService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-mix", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest request) {
        //@ModelAttribute("model") NewDTO model
        MixDTO model = new MixDTO();
        ModelAndView mav = new ModelAndView("admin/mix/list");
        model.setListResult(mixService.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;

    }
    @RequestMapping(value = "/quan-tri/bai-viet/phanquyen", method = RequestMethod.POST)
    public ModelAndView roleList(HttpServletRequest request) {

        MixDTO model = new MixDTO();
        ModelAndView mav = new ModelAndView("admin/mix/permission");
        mav.addObject("model", model);
        return mav;

    }
    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-mix", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/mix/edit");
        MixDTO model = new MixDTO();
        if (id != null) {
            model =mixService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("roles", roleService.findAll());
        mav.addObject("users", userService.findAll());
        mav.addObject("model", model);
        return mav;
    }


}
