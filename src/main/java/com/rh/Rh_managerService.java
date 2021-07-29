package com.rh;

import java.util.List;


public interface Rh_managerService {

	List<Rh_manager> getAllRHManager() ;
	
	 void saveRHmanager(Rh_manager rh_manager) ;
	 
	 Rh_manager getManagerById(long id);
		
	 void deleteManagerById(long id) ;


	 // function for : login rh manager 
	 
	 List<Rh_manager> loginRHmanager(String email,String password);
	 
	 
	 // function : sign in rh manager .
	 
	 List<Rh_manager> RegisterRHmanager(Rh_manager manger ) ;
	 
	 //get all meetings 
	 
	 List<Object> getAllMeetings();
	 
	 
	
}
