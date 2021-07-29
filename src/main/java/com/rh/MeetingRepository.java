package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository  extends JpaRepository<Meeting,Long> {

	// get meeting by title in 'search'
	
	@Query(value="SELECT * FROM meeting WHERE title LIKE %:title% ",nativeQuery = true)
	List<Meeting> getMeetingByTitle(@Param("title") String title);
	
	
}
