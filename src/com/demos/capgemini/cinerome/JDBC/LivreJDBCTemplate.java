package com.demos.capgemini.cinerome.JDBC;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demos.capgemini.cinerome.DAO.LivreDAO;
import com.demos.capgemini.cinerome.mappers.LivreMapper;
import com.demos.capgemini.cinerome.model.Livre;


public class LivreJDBCTemplate implements LivreDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String reference, String designation, double prixHT, int qteStock, String isbn, String auteur,
			String editeur, String genre, String synopsis, String infos) {
		String SQL = "insert into Livre (reference, designation, prixHT, qteStock, isbn, auteur, editeur, genre, synopsis, infos) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update( SQL, reference, designation, prixHT, qteStock, isbn, auteur, editeur, genre, synopsis, infos);
		return;
		}
	
	public List<Livre> livresD(String recherche){
		recherche = ("%"+recherche+"%").toUpperCase();
		String SQL = "select * from Livre where upper(designation) like ? or upper(auteur) like ? or upper(genre) like ?";
		List<Livre> livresD = jdbcTemplateObject.query(SQL, new Object[]{recherche,recherche,recherche}, new LivreMapper());
		return livresD;
	}
	
	public Livre getLivreR(String reference){
		String SQL = "select * from Livre where reference = ?";
		Livre liv = jdbcTemplateObject.queryForObject(SQL, new Object[]{reference}, new LivreMapper());
		return liv;
	}
	
	public List<Livre> listLivres() {
		String SQL = "select * from Livre";
		List <Livre> livres = jdbcTemplateObject.query(SQL, new LivreMapper());
		return livres;
		}
	
	public void delete(String reference){
		String SQL = "delete from Livre where reference = ?";
		jdbcTemplateObject.update(SQL, reference);
		return;
		}
	
	public void update(int qteStock, int prixHT, String infos, String reference){
		String SQL = "update Livre set qteStock = ?, prixHT = ?, infos = ?, where reference = ?";
		jdbcTemplateObject.update(SQL, qteStock, prixHT, infos, reference);
		return;
		}

}
