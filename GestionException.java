package Bibliothèque;


public class GestionException extends Exception{

	private static final long serialVersionUID = 1L;
	
    
    
	public void ChoixInvalide (int choix) {
		if(choix != 1 || choix != 2 || choix != 3 || choix != 4 || choix != 5 || choix != 6 || choix != 7 || choix != 8 ) {
			 System.out.println("\n Choix invalide ! Veuillez réessayer \n");
			 
		}
	}
	public void choixinvalide(String choix) {
		if(! (choix.equals("oui")) || ! (choix.equals("non"))){
			System.out.println("\n Veuillez saisir \"oui\" ou \"non\" \n");
		
		}
	}
	
	
	
	

	
	
}
