package com.rh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {

	@Query(value="select * from facture WHERE nom_client = :nom_client",nativeQuery = true)
	List<Facture> getFactureByNomClient(@Param("nom_client") String nom_client);
	
	// SELECT SUM(prix_totale_tva) FROM facture WHERE nom_client = "amine_dridi";
	
	
	@Query(value="SELECT SUM(prix_totale_tva) FROM facture WHERE nom_client = :nom_client",nativeQuery = true)
	List<String> getSumFactureByNomClient(@Param("nom_client") String nom_client);
	
}
