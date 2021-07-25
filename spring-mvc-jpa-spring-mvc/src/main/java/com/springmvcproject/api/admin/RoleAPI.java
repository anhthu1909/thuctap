package com.springmvcproject.api.admin;

import com.springmvcproject.dto.RoleDTO;
import com.springmvcproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "roleAPIOfAdmin")
public class RoleAPI {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/api/role")
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO){

        return roleService.save(roleDTO);
    }

    @PutMapping ("/api/role")
    public RoleDTO updateRole(@RequestBody RoleDTO updateRole){

        return roleService.save(updateRole);
    }

    @DeleteMapping("/api/role")
    public void deleteRole(@RequestBody long[] ids){
        roleService.delete(ids);
    }
}
