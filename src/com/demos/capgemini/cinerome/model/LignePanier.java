package com.demos.capgemini.cinerome.model;

public class LignePanier {
	
	private Article a;
	private int qteComm;
	
	public LignePanier(Article a, int qteComm) {	
		this.a = a;
		this.qteComm = qteComm;
	}

	public Article getA() {
		return a;
	}

	public int getQteComm() {
		return qteComm;
	}

	public void setQteComm(int qteComm) {
	     this.qteComm = qteComm;
	}


}
