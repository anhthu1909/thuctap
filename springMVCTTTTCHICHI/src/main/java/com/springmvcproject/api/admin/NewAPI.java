package com.springmvcproject.api.admin;

import com.springmvcproject.dto.NewDTO;
import com.springmvcproject.service.INew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {

    @Autowired
    private INew newService;

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO createNew) {
        return newService.save(createNew);
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO updateNew) {
        return newService.save(updateNew);
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}