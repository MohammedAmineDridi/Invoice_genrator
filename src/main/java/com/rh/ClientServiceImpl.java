package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements  ClientService {

	
	@Autowired
	private ClientRepository c_rep ; 
	
	
	@Override
	public List<Client> getAllClients() {
		
		return c_rep.findAll() ;
	}

	@Override
	public void saveClient(Client client) {
		
		this.c_rep.save(client) ;
		
	}

	@Override
	public Client getClientById(long id) {
		
	Optional<Client> optional = c_rep.findById(id);
		
		Client client = null ;
		
		if(optional.isPresent()) {
			
			client = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " client d'id =  " + id + " is not found !! " ) ;
		}
		
		return client ;
		
	}

	@Override
	public void deleteClientById(long id) {
	
		this.c_rep.deleteById(id);
		
	}

	@Override
	public List<Client> searchClient(String search) {
		
		return this.c_rep.SearchClient(search) ;
		
	}
	
	// modifier un client . 
	@Override
	public Client modifier_client(long id , Client client) {
		
		Client old_client = getClientById(id);
		
		long id_old = old_client.getId() ;
		
		this.deleteClientById(id_old);
		
		old_client.setId( id_old );
		
		old_client.setNom( client.getNom() );
		
		old_client.setAddresse( client.getAddresse() );
		
		old_client.setEmail( client.getEmail() );
		
		this.saveClient(old_client);
		
		return old_client ;
		
	}

	@Override
	public List<Client> SearchClientbyNom(String nom) {
		return this.c_rep.SearchClientbyNom(nom);
	}

	
	
	
}
