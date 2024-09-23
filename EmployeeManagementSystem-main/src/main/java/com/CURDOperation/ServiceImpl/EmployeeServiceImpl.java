package com.CURDOperation.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CURDOperation.Entity.Employee;
import com.CURDOperation.Repository.EmployeeRepository;
import com.CURDOperation.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> findEmployee() {
		return repository.findAll();
	}


	@Override
	public Employee getEmployeeById(Long id) {
	       Optional<Employee> optional=repository.findById(id);
	       Employee employee=null;
	       if (optional.isPresent()) {
			return optional.get();
		}
	       return employee;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);		
	}

}
