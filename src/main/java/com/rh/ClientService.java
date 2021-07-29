package com.rh;

import java.util.List;

public interface ClientService {

	List<Client> getAllClients() ;
	
	 void saveClient(Client client) ;
	 
	 Client modifier_client(long id , Client client);
	 
	 Client getClientById(long id);
		
	 void deleteClientById(long id) ;
	 
	 List<Client> searchClient(String search);
	 
	 List<Client> SearchClientbyNom(String nom);

}
