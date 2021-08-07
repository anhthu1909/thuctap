package com.springmvcproject.api.admin;

import com.springmvcproject.dto.RoleDTO;
import com.springmvcproject.service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {

    @Autowired
    private IRole role;

    @PostMapping("/api/role")
    public RoleDTO createNew(@RequestBody RoleDTO createNew) {
        return role.save(createNew);
    }

    @PutMapping("/api/role")
    public RoleDTO updateNew(@RequestBody RoleDTO updateNew) {
        return role.save(updateNew);
    }

    @DeleteMapping("/api/role")
    public void deleteNew(@RequestBody long[] ids) {
        role.delete(ids);
    }
}