package com.springmvcproject.api.admin;

import com.springmvcproject.dto.RoleDTO;
import com.springmvcproject.service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {
    @Autowired
    private IRole newService;
    @PostMapping("/api/role")
    public RoleDTO createNew(@RequestBody RoleDTO createNew) {
        return newService.save(createNew);
    }

    @PutMapping("/api/role")
    public RoleDTO updateNew(@RequestBody RoleDTO updateNew) {
        return newService.save(updateNew);
    }

    @DeleteMapping("/api/role")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}