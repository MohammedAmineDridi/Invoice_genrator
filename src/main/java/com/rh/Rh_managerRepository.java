package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rh_managerRepository extends JpaRepository<Rh_manager,Long> {

	
	
		//login rh_manager 
	
		@Query(value="select * from rh_manager WHERE email = ?1 and password = ?2 ",nativeQuery = true)
		List<Rh_manager> loginRHmanager(String email,String password);
		
		
		// insert rh manager (sign in)
		
		// INSERT INTO table VALUES ('valeur 1', 'valeur 2', ...)
		
		@Query(value="INSERT INTO rh_manager VALUES (?1 , ?2 , ?3 , ?4 , ?5) ",nativeQuery = true)
		List<Rh_manager> RegisterRHmanager(String firstname , String lastname ,  String email , String phone ,  String password);
		
		
		// get all meetings 
		
		
		@Query(value="select * from meeting ",nativeQuery = true)
		List<Object> getAllMeetings();
		
		
		
}
