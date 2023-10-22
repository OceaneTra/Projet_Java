package Bibliothèque;
import java.util.Date;


public interface Bibliothèque {
	
	public  void RechercherLivre();
	public  void EmprunterLivre() throws GestionException;
	public  void RetournerLivre();
	public  void AfficherListeLivres();
	public  void AfficherListeEmprunteur();
	public  void AjouterLivre() throws GestionException;
	public  void Quitter() throws GestionException;
	public  void AfficherListeAuteur();
	public  Date GestionDateEcheance(Date DateEmprunt,int JourEcheant);
}
