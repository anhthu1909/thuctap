package com.springmvcproject.api.admin;

import com.springmvcproject.dto.UserDTO;
import com.springmvcproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping("/api/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO){

        return userService.save(userDTO);
    }

    @PutMapping ("/api/user")
    public UserDTO updateUser(@RequestBody UserDTO updateUser){

        return userService.save(updateUser);
    }

    @DeleteMapping("/api/user")
    public void deleteUser(@RequestBody long[] ids){
        userService.delete(ids);
    }
}