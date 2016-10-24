package com.demos.capgemini.cinerome.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demos.capgemini.cinerome.JDBC.LivreJDBCTemplate;
import com.demos.capgemini.cinerome.model.Panier;


public class MainTestClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext ("dispatcher-servlet.xml");
		LivreJDBCTemplate livreJDBCTemplate = (LivreJDBCTemplate)context.getBean("livreJDBCTemplate");
		
		String reference;
		int qte;
		
		qte = 2;
		
		Panier p1 = new Panier();
		 
		reference = "l1";
		System.out.println(livreJDBCTemplate.listLivres());
		p1.ajouter(livreJDBCTemplate.getLivreR("l1"), qte);
		System.out.println(p1.getContenu());
	}

}
