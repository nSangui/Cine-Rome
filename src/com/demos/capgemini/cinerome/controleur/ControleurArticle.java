package com.demos.capgemini.cinerome.controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.demos.capgemini.cinerome.JDBC.LivreJDBCTemplate;
import com.demos.capgemini.cinerome.model.Panier;

@Controller
public class ControleurArticle{
	
	@Autowired
	private LivreJDBCTemplate livrejdbctemplate;
	
	
	
		@RequestMapping(value="/pagePrincipale.htm",method=RequestMethod.GET)
			private String afficherCatalogue(ModelMap model, HttpSession session){	
			
			Panier p1 = (Panier)session.getAttribute("panier");
	    	   if(p1==null){
	    		   p1 = new Panier();
	    		   session.setAttribute("panier", p1);}
		
			model.put("livresModel", livrejdbctemplate.listLivres());
			return "pagePrincipale";
			
		}
		
			
       @RequestMapping(value="/rechercherLivre.htm",method=RequestMethod.POST)
		public String chercherLivre(ModelMap model, HttpServletRequest request, @RequestParam("recherche") String recherche){
		   model.put("livresModel", livrejdbctemplate.livresD(recherche));
		   return "pagePrincipale";
		}
      
		
		@RequestMapping(value="/ajouterObjet.htm", method=RequestMethod.POST)
		public String ajouterPanier(ModelMap model, HttpSession session, HttpServletRequest request, @RequestParam("reference") String reference, @RequestParam("qtesaisie")int qte){	   
	    	 
			Panier p1 = (Panier) session.getAttribute("panier");
			
		   p1.ajouter(livrejdbctemplate.getLivreR(reference), qte);
	    	   
	    	   model.put("livresPanier", p1.getContenu());
	    	   return "panier";
			
		}
		
		@RequestMapping(value="/allerpanier.htm",method=RequestMethod.GET)
		private String afficherCataloguePanier(HttpSession session, ModelMap model){
			
			Panier p1 = (Panier) session.getAttribute("panier");
   	        
			model.put("livresPanier", p1.getContenu());
			return "panier";
		
	}
		
		@RequestMapping(value="/modifierObjet.htm", method=RequestMethod.POST)
		public String modifierPanier(ModelMap model, HttpSession session, HttpServletRequest request, @RequestParam("reference") String reference, @RequestParam("qtesaisiemodif")int qte){

	    	
	    	   Panier p1 = (Panier)session.getAttribute("panier");
	    	   
	    	   for (int i = p1.getContenu().size()-1; i >= 0; i--)
					if (p1.getContenu().get(i).getA().getReference().equals(reference)) {
						p1.modifierLigne(p1.getContenu().get(i).getA(), qte);
						if (qte == 0){
		    	        	p1.eliminerLigne(p1.getContenu().get(i).getA());
		    	        }
					}
	    	        
	    	   model.put("livresPanier", p1.getContenu());
	    	   return "panier";
			
		}
		
		@RequestMapping(value="/eliminerObjet.htm", method=RequestMethod.GET)
		public String eliminerObjet(ModelMap model, HttpSession session, HttpServletRequest request, @RequestParam("reference") String reference){

	    	
	    	   Panier p1 = (Panier)session.getAttribute("panier");
	    	   
	    	   for (int i = p1.getContenu().size()-1; i >= 0; i--)
					if (p1.getContenu().get(i).getA().getReference().equals(reference)) {
						
		    	        	p1.eliminerLigne(p1.getContenu().get(i).getA());
		    	        
					}
	    	        
	    	   model.put("livresPanier", p1.getContenu());
	    	   return "panier";
			
		}
		
		@RequestMapping(value="/retourprincipal.htm",method=RequestMethod.GET)
		private String retourPrincipal(HttpSession session, ModelMap model){
	    	   
	    	   Panier p1 = (Panier)session.getAttribute("panier");		
    	   
			model.put("livresModel", livrejdbctemplate.listLivres());
			return "pagePrincipale";
		
	}
		
		@RequestMapping(value="/reset.htm",method=RequestMethod.GET)
		private String resetPanier(HttpSession session, ModelMap model){
			
			Panier p1 = (Panier) session.getAttribute("panier");
			
			p1.resetPanier();
		
    	   
			model.put("livresPanier", p1.getContenu());
			return "panier";
		
	}
		
}