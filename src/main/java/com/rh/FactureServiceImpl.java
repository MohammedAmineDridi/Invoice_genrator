package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServiceImpl implements  FactureService  {

	
	@Autowired
	private FactureRepository facture_rep ;
	
	@Override
	public List<Facture> getAllFactures() {
		return facture_rep.findAll() ;
	}

	@Override
	public void saveFacture(Facture facture) {
		
		facture_rep.save(facture) ;
		
	}

	@Override
	public Facture getFctureById(long id) {
Optional<Facture> optional = facture_rep.findById(id);
		
		Facture facture = null ;
		
		if(optional.isPresent()) {
			
			facture = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " facture d'id =  " + id + " is not found !! " ) ;
		}
		
		return facture ;
	}

	@Override
	public void deleteFactureById(long id) {
		
		this.facture_rep.deleteById(id);
		
	}

	@Override
	public void deleteAllFactureTable() {
		
		this.facture_rep.deleteAll();
	}

	@Override
	public List<Facture> getFactureByNomClient(String nom_client) {
		
		return this.facture_rep.getFactureByNomClient(nom_client) ;
	}
	
	@Override
	public List<String> getSumFactureByNomClient(String nom_client){
		return this.facture_rep.getSumFactureByNomClient(nom_client);
				
	}

	
	
}
