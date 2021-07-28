package com.springmvcproject.api.admin;

import com.springmvcproject.dto.AdminDTO;
import com.springmvcproject.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "adminAPIOfAdmin")
public class AdminAPI {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/api/admin")
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO){

        return adminService.save(adminDTO);
    }

    @PutMapping ("/api/admin")
    public AdminDTO updateAdmin(@RequestBody AdminDTO updateAdmin){

        return adminService.save(updateAdmin);
    }

    @DeleteMapping("/api/admin")
    public void deleteAdmin(@RequestBody long[] ids){
        adminService.delete(ids);
    }
}
