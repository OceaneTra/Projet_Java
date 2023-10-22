package Bibliothèque;


public class Livres {
	
	private String Titre,Auteur,Edition,Catégorie;
	private int Nb;
	private String DateSortie;

	public Livres(String Titre,String Auteur,String DateSortie,String Edition,String Genre,int Nb) {
			this.Titre = Titre;
			this.Auteur = Auteur;
			this.DateSortie = DateSortie;
			this.Edition = Edition;
			this.Catégorie = Genre;
			this.Nb = Nb;
		}
	
	
// les getters 
	public String getTitre() {
		return Titre;
	}

	public  String getAuteur() {
		return Auteur;
	}

	public String getDateSortie() {
		return DateSortie;
	}

	public String getEdition() {
		return Edition;
	}

	public String getCatégorie() {
		return Catégorie;
	}
	
	public int getNB() {
		return Nb;
	}
	
	// setter pour ajouter un exemplaire du livre
    public void setNb(int n) {
		this.Nb = Nb + n;
	}
    
    // setter pour retirer un exemplaire du livre
    public void setNB(int n) {
    	this.Nb = Nb - n;
    }
}