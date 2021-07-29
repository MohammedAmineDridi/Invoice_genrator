package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccationRepository extends JpaRepository<Vaccation,Long> {


	// get coordinates of employee with vaccation (emp_id)
    
	@Query(value="SELECT e.first_name , e.last_name , e.hiring_date ,"
		+" v.number_days , v.consumed_days , v.remaining_days FROM employee e INNER JOIN vaccation v ON e.id = v.id_emp",nativeQuery = true)
	List<String> getVaccation_join();
	
}
