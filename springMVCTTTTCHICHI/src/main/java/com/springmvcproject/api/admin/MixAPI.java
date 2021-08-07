
package com.springmvcproject.api.admin;

import com.springmvcproject.dto.MixDTO;
import com.springmvcproject.service.IMix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "mixAPIOfAdmin")
public class MixAPI {

    @Autowired
    private IMix mix;

    @PostMapping("/api/mix")
    public MixDTO createNew(@RequestBody MixDTO newDTO) {
        return mix.save(newDTO);
    }

    @PutMapping("/api/mix")
    public MixDTO updateNew(@RequestBody MixDTO updateNew) {
        return mix.save(updateNew);
    }

    @DeleteMapping("/api/mix")
    public void deleteNew(@RequestBody long[] ids) {
        mix.delete(ids);
    }
}