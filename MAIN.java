package Bibliothèque;
import java.util.Scanner;
import java.util.InputMismatchException;


public class MAIN {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		int choix = 0;
		 Gestionnaire bibliothèque = new Gestionnaire();
		
		 try {
		      do {
			
			bibliothèque.menu();
		    choix = sc.nextInt();
			
		switch(choix){
			case 1 : 
				bibliothèque.AjouterLivre();
			break;
			case 2 :
				bibliothèque.RechercherLivre();
			break;
			case 3 :
				bibliothèque.AfficherListeLivres();
			break;
			case 4 :
				bibliothèque.AfficherListeEmprunteur();
			break;
			case 5 :
				bibliothèque.AfficherListeAuteur();
			break;
			case 6 :
				bibliothèque.EmprunterLivre();
			break;
			case 7 : 
				bibliothèque.RetournerLivre();
			break;
			case 8 :
				bibliothèque.Quitter();	
			break;
		}
		
		
		}while(choix == 1 || choix == 2 || choix == 3 || choix == 4 || choix == 5 || choix == 6 || choix == 7 || choix == 8 );
		      
		 throw new GestionException();
		 
		 }catch(InputMismatchException e) {
				System.out.println("\nEntrée invalide. Veuillez saisir un entier !");
		 }catch(GestionException except) {
			 except.ChoixInvalide(choix);
		 }
		 
		sc.close();
	
	}
 
}
