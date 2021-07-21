package com.springmvcproject.api.admin;

import com.springmvcproject.dto.HospitalDTO;
import com.springmvcproject.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "hospitalAPIOfAdmin")
public class HospitalAPI {

    @Autowired
    private IHospitalService hospitalService;

    @PostMapping("/api/hospital")
    public HospitalDTO createHospital(@RequestBody HospitalDTO hospitalDTO){

        return hospitalService.save(hospitalDTO);
    }

    @PutMapping ("/api/hospital")
    public HospitalDTO updateHospital(@RequestBody HospitalDTO updateHospital){

        return hospitalService.save(updateHospital);
    }

    @DeleteMapping("/api/hospital")
    public void deleteHospital(@RequestBody long[] ids){
        hospitalService.delete(ids);
    }
}
