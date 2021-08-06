package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.IRole;
import com.laptrinhjavaweb.until.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller(value="roleControllerOfadmin")

public class RoleController {
    @Autowired
    private IRole newService;
    @Autowired
    private MessageUtil messageUtil;
    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach-role", method = RequestMethod.GET)
    public ModelAndView showList( HttpServletRequest request) {

        RoleDTO model=new RoleDTO();
        ModelAndView mav = new ModelAndView("admin/role/list");
        model.setListResult(newService.findAll());
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;

    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-role", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request ) {
        ModelAndView mav = new ModelAndView("admin/role/edit");
       RoleDTO model = new RoleDTO();
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
