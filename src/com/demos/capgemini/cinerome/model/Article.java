package com.demos.capgemini.cinerome.model;

public class Article {
	
	private String reference;
	private String designation;
	private double prixHT;
	private int qteStock;
	private String type;
	private boolean dematerialise;
	private String categorieTVA;
	private String nomImage;


	
	public Article() {
		super();
	}

	
	
	public Article(String reference, String designation, double prixHT, int qteStock) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prixHT = prixHT;
		this.qteStock = qteStock;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

// objet dématérialisé
	public Article(String reference, String designation, double prixHT) {
	
		this.reference = reference;
		this.designation = designation;
		this.prixHT = prixHT;
		this.qteStock = 0;
		this.dematerialise = true;
	}

	public boolean isDematerialise() {
		return dematerialise;
	}

	public void setDematerialise(boolean dematerialise) {
		this.dematerialise = dematerialise;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public String getReference() {
		return reference;
	}

	public String getDesignation() {
		return designation;
	}

	public int getQteStock() {
		return qteStock;
	}
	
	public void incrementStock(int qte){
		qteStock += qte;
	}
	
	public void decrementStock(int qte){
		qteStock -= qte;	
	}
	

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}



	@Override
	public String toString() {
		String description="";
		if(!isDematerialise()){
		
		description= "reference=" + reference + 
			   ", designation=" + designation + 
			   ", prixHT=" + prixHT + 
			   ", qteStock=" + qteStock;
		}
		else {
			description= "reference=" + reference + 
					   ", designation=" + designation + 
					   ", prixHT=" + prixHT + 
					   ", objet dématérialisé";
		}
		return description;
	}

	public String getCategorieTVA() {
		return categorieTVA;
	}

	public String getNomImage() {
		return nomImage;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
