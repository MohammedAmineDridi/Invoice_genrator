package com.rh;

import java.util.List;

public interface EmployeeService {
	
	List<Employee> getAllEmployees() ;
	
	 void saveEmployee(Employee employee) ;
	 
	 Employee getEmployeeById(long id);
		
	 void deleteEmployeeById(long id) ;

	List<Employee> getEmployeeByFirstName(String first_name);
	
	List<Employee> getEmployeeByAll(String search) ;
	
	List<Employee> getNonArchivedEmployees(String value_archived) ;	
	
	List<String> getVaccation();

	List<String> getVaccation_requests();
	
	Employee update_employee(long id , Employee emp);
	
	List<String> getVaccation_requestsById(String id);
}
