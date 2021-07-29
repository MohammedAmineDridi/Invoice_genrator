package com.rh;

import java.util.List;

public interface VaccationService {


	List<Vaccation> getAllVacations() ;
	
	 void saveVaccation(Vaccation vaccation) ;
	 
	 Vaccation getVaccationById(long id);
		
	 void deleteVaccationById(long id) ;

	 List<String> getVaccation_join();
}
