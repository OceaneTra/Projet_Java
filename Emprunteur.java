package Bibliothèque;
import java.util.Date;


public class Emprunteur {
	
	private String nomEmprunteur;
	private Date DateEmprunt,DateEchéance;
	
	public Emprunteur(String nomEm,Date DateEm,Date DateEch ) {
		this.nomEmprunteur = nomEm;
		this.DateEmprunt = DateEm;
		this.DateEchéance = DateEch;
		
	}
	public String getNomEmprunteur() {
		return nomEmprunteur;
	}

	public Date getDateEmprunt() {
		return DateEmprunt;
	}

	public Date getDateEchéance() {
		return DateEchéance;
	}
}
