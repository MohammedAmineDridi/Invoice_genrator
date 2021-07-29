package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	//jpa est l'orm hibernate de spring boot .
	
	@Query(value="select * from employee WHERE first_name = ?1",nativeQuery = true)
	List<Employee> getEmployeesByFirstName(String first_name);
	
	
	
	// recherche dynamique de l'employee 
	 
	
	
	@Query(value="SELECT * FROM employee WHERE first_name LIKE %:search% or last_name LIKE %:search% ",nativeQuery = true)
	List<Employee> getEmployeeByAll(@Param("search") String search);
	

	
	// get the employees none archived (archived = no) 
	@Query(value="select * from employee WHERE archived = ?1",nativeQuery = true)
	List<Employee> getNonArchivedEmployees(String value_archived);
	
	
	// get coordinates of employee with vaccation (emp_id)
    
	@Query(value="SELECT e.first_name , e.last_name , e.hiring_date ,"
		+" v.number_days , v.consumed_days , v.remaining_days FROM employee e INNER JOIN vaccation v ON e.id = v.id_emp",nativeQuery = true)
	List<String> getVaccation();
	
	
	// get coordinates + vaccation requests .
	
	@Query(value="SELECT e.first_name , e.last_name , "
			+" v.period , v.reason , v.start_date , v.end_date FROM employee e INNER JOIN vaccation_request v ON e.id = v.id_emp",nativeQuery = true)
		List<String> getVaccation_requests();
	
	
	// get vacation request by id 
	
	// SELECT e.first_name , e.last_name , v.period , v.reason , v.start_date , v.end_date FROM employee e INNER JOIN vaccation_request v ON e.id = v.id_emp WHERE v.id_emp = 3 ;
	
	
	@Query(value="SELECT e.first_name , e.last_name , "
			+" v.period , v.reason , v.start_date , v.end_date FROM employee e INNER JOIN vaccation_request v ON e.id = v.id_emp where v.id_emp = ?1",nativeQuery = true)
		List<String> getVaccation_requestsById(String id);
	
	
}
