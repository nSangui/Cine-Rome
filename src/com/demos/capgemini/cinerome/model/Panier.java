package com.demos.capgemini.cinerome.model;

import java.util.ArrayList;

public class Panier {

	private ArrayList<LignePanier> contenu = new ArrayList<LignePanier>();
	private int nbObjets;
	private double prixTotalHT;

	public Panier() {
	}

	public ArrayList<LignePanier> getContenu() {
		return contenu;
	}

	public void setNbObjets() {
		    nbObjets = 0;
		for (int i = contenu.size()-1; i >= 0; i--)
			nbObjets += contenu.get(i).getQteComm();	
	}

	public int getNbObjets() {
		return nbObjets;
	}

	public void ajouter(Article a, int qteComm) {
		
		for(LignePanier lp : contenu)
			if (lp.getA().getReference().equals(a.getReference())){
				lp.setQteComm(qteComm);
				return;
			}		
	    LignePanier lp = new LignePanier(a, qteComm);
		contenu.add(lp);
		setPrixTotalHT();
		setNbObjets();
	}

	public void eliminerLigne(Article a) {
		for (int i = contenu.size()-1; i >= 0; i--)
			if (contenu.get(i).getA().equals(a)) {
				contenu.remove(contenu.get(i));	
				setPrixTotalHT();
				setNbObjets();
			}
	}

	public void modifierLigne(Article a, int qteComm) {
		for (int i = contenu.size()-1; i >= 0; i--)
			if (contenu.get(i).getA().equals(a)) {
				contenu.get(i).setQteComm(qteComm);
				setPrixTotalHT();
				setNbObjets();
			}
	}

	public void resetPanier() {
		contenu.removeAll(contenu);
		prixTotalHT = 0;
		nbObjets = 0;
	}

	@Override
	public String toString() {
		String description = "";
		for (LignePanier lp : contenu) {
			description += lp.getA().getReference() + " " + lp.getQteComm() + "\n";
		}
		return description;
	}

	public void setPrixTotalHT() {
		prixTotalHT = 0;
		for (int i = contenu.size()-1; i >= 0; i--)
			prixTotalHT += contenu.get(i).getQteComm()*contenu.get(i).getA().getPrixHT();
		Math.rint(prixTotalHT);
	}
	
	public double getPrixTotalHT(){
		return prixTotalHT;
	}

}
