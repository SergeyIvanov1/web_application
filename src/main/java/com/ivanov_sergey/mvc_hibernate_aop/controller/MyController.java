package com.ivanov_sergey.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ivanov_sergey.mvc_hibernate_aop.entity.Employee;
import com.ivanov_sergey.mvc_hibernate_aop.service.EmployeeService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String toStartPage(){
        return "startPage";
    }

    @RequestMapping("/cryptanalyzer")
    public String toCryptanalyzerPage(){
        return "cryptanalyzer";
    }

    @RequestMapping("/allEmployee")
    public String allEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
//        return "all-employees";
        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee")
    public String DeleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);
//        return "all-employees";
        return "redirect:/";
    }
}
