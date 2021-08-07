package com.springmvcproject.api.admin;

import com.springmvcproject.dto.UserDTO;
import com.springmvcproject.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

    @Autowired
    private IUser user;

    @PostMapping("/api/user")
    public UserDTO createNew(@RequestBody UserDTO createNew) {
        return user.save(createNew);
    }

    @PutMapping("/api/user")
    public UserDTO updateNew(@RequestBody UserDTO updateNew) {
        return user.save(updateNew);
    }

    @DeleteMapping("/api/user")
    public void deleteNew(@RequestBody long[] ids) {
        user.delete(ids);
    }
}