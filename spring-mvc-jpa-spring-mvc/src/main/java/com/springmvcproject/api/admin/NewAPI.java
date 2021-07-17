package com.springmvcproject.api.admin;

import com.springmvcproject.dto.NewDTO;
import com.springmvcproject.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO){

        return newService.save(newDTO);
    }

    @PutMapping ("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO updateNew){

        return newService.save(updateNew);
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody Long[] ids){

    }
}
