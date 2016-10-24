package com.demos.capgemini.cinerome.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demos.capgemini.cinerome.model.Livre;

public class LivreMapper implements RowMapper<Livre>{
	
	public Livre mapRow(ResultSet rs, int rowNum) throws SQLException {
		Livre liv = new Livre();
		liv.setReference(rs.getString("reference"));
		liv.setDesignation(rs.getString("designation"));
		liv.setPrixHT(rs.getDouble("prixHT"));
		liv.setQteStock(rs.getInt("qteStock"));
		liv.setIsbn(rs.getString("isbn"));		
		liv.setAuteur(rs.getString("auteur"));
		liv.setEditeur(rs.getString("editeur"));
		liv.setGenre(rs.getString("genre"));	
		liv.setSynopsis(rs.getString("synopsis"));	
		liv.setInfos(rs.getString("infos"));
		return liv;	
	}

}
