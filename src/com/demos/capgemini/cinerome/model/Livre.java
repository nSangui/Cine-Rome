package com.demos.capgemini.cinerome.model;

public class Livre extends Article{
	
	private String isbn;
	private String auteur;
	private String editeur;
	private String genre;
	private String synopsis;
	private String infos;

	public Livre() {
		super();
	}

	public Livre(String reference, String designation, double prixHT, int qteStock, String isbn, String auteur,
			String editeur, String genre, String synopsis, String infos) {
		super(reference, designation, prixHT, qteStock);
		this.isbn = isbn;
		this.auteur = auteur;
		this.editeur = editeur;
		this.genre = genre;
		this.synopsis = synopsis;
		this.infos = infos;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public String getGenre() {
		return genre;
	}

	public String getInfos() {
		return infos;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	

}
