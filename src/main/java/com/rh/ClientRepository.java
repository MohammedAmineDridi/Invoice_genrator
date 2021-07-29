package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

	// recherche dynamique
	
	@Query(value="SELECT * FROM client WHERE nom LIKE %:search% or addresse LIKE %:search% or email LIKE %:search%  ",nativeQuery = true)
	List<Client> SearchClient(@Param("search") String search);
	

	// get client by nom 
	
	@Query(value="SELECT * FROM client WHERE nom LIKE :client_nom",nativeQuery = true)
	List<Client> SearchClientbyNom(@Param("client_nom") String client_nom);
	
}
