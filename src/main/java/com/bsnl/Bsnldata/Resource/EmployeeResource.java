package com.bsnl.Bsnldata.Resource;


import com.bsnl.Bsnldata.Repository.EmployeeRepository;
import com.bsnl.Bsnldata.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bsnl/employee")
@CrossOrigin(origins = "*")
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello   world";
    }

    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Hi " + employee.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/findEmployee/{name}")
    public List<Employee> findUser(@PathVariable String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public List<Employee> cancelRegistration(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return employeeRepository.findAll();
    }

}
