package com.rh;

import java.util.List;

public interface FactureService {
	

	List<Facture> getAllFactures() ;
	
	 void saveFacture(Facture facture) ;
	 
	 Facture getFctureById(long id);
		
	 void deleteFactureById(long id) ;
	 
	 void deleteAllFactureTable();
	 
	 List<Facture> getFactureByNomClient(String nom_client) ;
	 
	 List<String> getSumFactureByNomClient(String nom_client);

}
