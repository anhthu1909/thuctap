
        package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.MixDTO;
import com.laptrinhjavaweb.service.IMix;
import com.laptrinhjavaweb.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController(value = "mixAPIOfAdmin")
public class MixAPI {

    @Autowired
    private IMix newService;

    @PostMapping("/api/mix")
    public MixDTO createNew(@RequestBody MixDTO newDTO) {
        return newService.save(newDTO);
    }

    @PutMapping("/api/mix")
    public MixDTO updateNew(@RequestBody MixDTO updateNew) {
        return newService.save(updateNew);
    }

    @DeleteMapping("/api/mix")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}