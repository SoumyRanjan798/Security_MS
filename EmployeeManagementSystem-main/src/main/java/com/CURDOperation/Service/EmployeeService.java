package com.CURDOperation.Service;

import java.util.List;

import com.CURDOperation.Entity.Employee;

public interface EmployeeService {

    public Employee getEmployeeById(Long id);

	public Employee saveEmployee(Employee employee);

	public List<Employee> findEmployee();

	public void deleteById(Long id);

}
