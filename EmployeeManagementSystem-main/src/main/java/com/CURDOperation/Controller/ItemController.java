package com.CURDOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CURDOperation.Entity.Employee;
import com.CURDOperation.Service.EmployeeService;

@Controller
public class ItemController {
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/submit/emp/data")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/item";
	}
	
	@GetMapping("/saveEmployeeForm")
	public String employeeform(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "saveEmployee";
	}
	
	
	
	@GetMapping("/item")
	public String itemDisplay(Model model) {
		model.addAttribute("emp", service.findEmployee());
		return "item";
	}
	
	
	@GetMapping("/dataUpdate/{id}")
	public String updateData(@PathVariable("id")Long id,Model model) {
		Employee employee=service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "updateForm";
	}
	
	@PostMapping("/updateSaveData")
	public String UpdateDataSave(@ModelAttribute("employee") Employee employee) {
	   service.saveEmployee(employee);
	   return "redirect:/item";
	}
	
	
	@GetMapping("/deleteDataById/{id}")
	public String deleteData(@PathVariable("id")Long id) {
		service.deleteById(id);
		return "redirect:/item";
	}
}
