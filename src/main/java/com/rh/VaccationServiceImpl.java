package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccationServiceImpl implements  VaccationService {

	
	@Autowired
	private VaccationRepository vacc_rep ;
	
	@Override
	public List<Vaccation> getAllVacations() {
		return this.vacc_rep.findAll() ;
	}

	@Override
	public void saveVaccation(Vaccation vaccation) {
		this.vacc_rep.save(vaccation);
	}

	@Override
	public Vaccation getVaccationById(long id) {

		Optional<Vaccation> optional = this.vacc_rep.findById(id);
		
		Vaccation vacation = null ;
		
		if(optional.isPresent()) {
			
			vacation = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " vacation d'id =  " + id + " is not found !! " ) ;
		}
		
		return vacation ;
	}

	@Override
	public void deleteVaccationById(long id) {
		
		this.deleteVaccationById(id);
		
	}

	@Override
	public List<String> getVaccation_join() {
		
		return this.vacc_rep.getVaccation_join();
	}
	
	

}
