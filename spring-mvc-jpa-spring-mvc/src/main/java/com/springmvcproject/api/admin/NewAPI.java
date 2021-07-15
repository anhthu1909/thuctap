package com.springmvcproject.api.admin;

import com.springmvcproject.dto.NewDTO;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){
        return newDTO;
    }

    @PutMapping ("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO){
        return newDTO;
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody Long[] ids){
        System.out.print("ok");
    }
}
