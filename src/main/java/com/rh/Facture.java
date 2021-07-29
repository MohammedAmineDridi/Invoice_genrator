package com.rh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
 
    @Column(name = "quantite")
    private String quantite;
 
	@Column(name = "designation")
    private String designation;
 
    @Column(name = "prix_unitaire")
    private String prix_unitaire;
    
    @Column(name = "prix_totale")
    private String prix_totale;
    
    @Column(name = "prix_totale_tva")
    private String prix_totale_tva;
    
    @Column(name = "nom_client")
    private String nom_client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(String prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public String getPrix_totale() {
		return prix_totale;
	}

	public void setPrix_totale(String prix_totale) {
		this.prix_totale = prix_totale;
	}

	public String getPrix_totale_tva() {
		return prix_totale_tva;
	}

	public void setPrix_totale_tva(String prix_totale_tva) {
		this.prix_totale_tva = prix_totale_tva;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
    
    
    
    
    
}
