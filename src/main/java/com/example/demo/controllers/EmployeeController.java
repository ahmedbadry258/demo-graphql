package com.example.demo.controllers;

import com.example.demo.data.Employee;
import com.example.demo.data.EmployeeInput;
import com.example.demo.data.EmployeeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
@QueryMapping
    public Iterable<Employee> employees(){
        return  this.employeeRepository.findAll();
    }

    @QueryMapping
    public Employee employeeById(@Argument Long id){
        return  this.employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Not Employee Found"));
    }
    @QueryMapping
    public Employee employeeByEmail(@Argument String email){
        return  this.employeeRepository.findByEmail(email);
    }

    @MutationMapping
    public Employee addEmployee(@Argument(name = "input") EmployeeInput employeeInput){
       Employee employee= employeeInput.getEmployee();
       employee.setId(1000l);
//        return this.employeeRepository.save(employeeInput.getEmployee());
        return  employee;
    }
//
//    @MutationMapping
//    pubic  Object createEmployee(@Argument String firstName,
//                                                                 @Argument String lastName,
//                                                                 @Argument String email,
//                                                                 @Argument String phoneNumber,
//                                                                 @Argument String job){
//       Employee e=new Employee();
//       e.setId(1000l);
//       e.setFirstName(firstName);
//       e.setLastName(lastName);
//       e.setEmail(email);
//       e.setPhoneNumber(phoneNumber);
//       e.setJob(job);
//            return e;
//    }
}
