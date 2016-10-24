package com.demos.capgemini.cinerome.DAO;

import java.util.List; import javax.sql.DataSource;

import com.demos.capgemini.cinerome.model.Livre;

public interface LivreDAO {
	
	public void setDataSource(DataSource ds); 
	public void create(String reference, String designation, double prixHT, int qteStock, String isbn, String auteur,
			String editeur, String genre, String synopsis, String infos); 
	public List<Livre> livresD(String designation); 
	public Livre getLivreR(String reference);
	public List<Livre> listLivres(); 
	public void delete(String reference); 
	public void update(int qteStock, int prixHT, String infos, String reference); 

}
