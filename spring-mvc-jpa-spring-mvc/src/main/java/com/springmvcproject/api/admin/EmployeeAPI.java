package com.springmvcproject.api.admin;

import com.springmvcproject.dto.EmployeeDTO;
import com.springmvcproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "employeeAPIOfAdmin")
public class EmployeeAPI {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/api/employee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){

        return employeeService.save(employeeDTO);
    }

    @PutMapping ("/api/employee")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO updateEmployee){

        return employeeService.save(updateEmployee);
    }

    @DeleteMapping("/api/employee")
    public void deleteEmployee(@RequestBody long[] ids){
        employeeService.delete(ids);
    }
}
