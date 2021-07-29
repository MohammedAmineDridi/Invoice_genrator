package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements  EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository ;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional = employeeRepository.findById(id);
		
		Employee employee = null ;
		
		if(optional.isPresent()) {
			
				employee = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " Employee d'id =  " + id + " is not found !! " ) ;
		}
		
		return employee ;
	}

	@Override
	public void deleteEmployeeById(long id) {
		
		
		this.employeeRepository.deleteById(id);
		
	}

	// get employee by first name 
	
	@Override
	public List<Employee> getEmployeeByFirstName(String f_name) {
		
		return this.employeeRepository.getEmployeesByFirstName(f_name) ;
		
	}
	
	@Override
	public List<Employee> getEmployeeByAll(String search){
		return this.employeeRepository.getEmployeeByAll(search) ;
	}
	
	@Override
	public List<Employee> getNonArchivedEmployees(String value_archived){
		return this.employeeRepository.getNonArchivedEmployees(value_archived);
	}
	
	@Override
	public List<String> getVaccation(){
		return this.employeeRepository.getVaccation();
	}
	
	@Override
	public List<String> getVaccation_requests(){
		return this.employeeRepository.getVaccation_requests();
	}
	
	// update functionn employee
	
	@Override
	public Employee update_employee(long id , Employee new_emp) {
		
		Employee old_emp = this.getEmployeeById(id) ;
		
		// delete the old employee
		
		this.employeeRepository.deleteById(id);
		
		old_emp.setFirst_name(new_emp.getFirst_name());
		
		old_emp.setLast_name( new_emp.getLast_name() );
		
		old_emp.setAge( new_emp.getAge() );
		
		old_emp.setEmail( new_emp.getEmail() );
		
		old_emp.setPhone( new_emp.getPhone() );
		
		old_emp.setPost( new_emp.getPost() );
		
		old_emp.setHiring_date( new_emp.getHiring_date() );

		old_emp.setDepartment( new_emp.getDepartment() );
		
		old_emp.setSalary( new_emp.getSalary() );
		
		old_emp.setEnd_date( new_emp.getEnd_date() );
		
		old_emp.setCin( new_emp.getCin() );
		
		old_emp.setType_contrat( new_emp.getType_contrat() );
		
		old_emp.setPassword( new_emp.getPassword() );
		
		old_emp.setArchived( new_emp.getArchived() );
		
		old_emp.setPhoto( new_emp.getPhoto() );
		
		// save the new employee 
		
		this.employeeRepository.save(old_emp) ;
		
		return old_emp ;
		
	}
	
	// get vaccation request by id .
	
	@Override
	 public List<String> getVaccation_requestsById(String id) {
		return this.employeeRepository.getVaccation_requestsById(id);
	}
	
	
}
