package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
    @Autowired
    private IUser newService;
    @PostMapping("/api/user")
    public UserDTO createNew(@RequestBody UserDTO createNew) {
        return newService.save(createNew);
    }

    @PutMapping("/api/user")
    public UserDTO updateNew(@RequestBody UserDTO updateNew) {
        return newService.save(updateNew);
    }

    @DeleteMapping("/api/user")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}