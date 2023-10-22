package Bibliothèque;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Calendar;
import java.util.ConcurrentModificationException;



public  class Gestionnaire  implements Bibliothèque {
	
	// Déclaration des variables
	private String Rech;
	String choix;
	String ChoixQte;
	int Qte;
	String DateSortie,titre,Edition,Catégorie,nomAuteur;
	Date dateEmprunt = new Date();
	int jourEcheant = 12;
	Date dateEcheance  = GestionDateEcheance(dateEmprunt,jourEcheant);
	private ArrayList<Emprunteur> Liste_Emprunteurs = new ArrayList<Emprunteur>();
	private ArrayList<Auteur> Liste_Auteurs = new ArrayList<Auteur>();
	private ArrayList<Livres> bibliotheque = new ArrayList<Livres>();
	
	
	
	// Instanciation des classes
	Scanner sc = new Scanner(System.in);
	Livres livre = new Livres(null, null, null, null, null, 0);
	Auteur auteur = new Auteur(null);
	Emprunteur Ep = new Emprunteur(null,null,null);
	
	
	//LES GETTERS 
	public String getRech() {
		return Rech;
	}
    public ArrayList<Emprunteur> getListe_Emprunteurs() {
    	        Liste_Emprunteurs.add(new Emprunteur("Gomez Ange",dateEmprunt,dateEcheance));
		Liste_Emprunteurs.add(new Emprunteur("Tra Lou Océane",dateEmprunt,dateEcheance));
		Liste_Emprunteurs.add(new Emprunteur("Monsan Josué",dateEmprunt,dateEcheance));
		return Liste_Emprunteurs;
	}

	public ArrayList<Auteur> getListe_Auteurs() {
		Liste_Auteurs.add(new Auteur("Albert Camus"));
		Liste_Auteurs.add(new Auteur("Voltaire"));
		Liste_Auteurs.add(new Auteur("Victor Hugo"));
		return Liste_Auteurs;
	}

	public ArrayList<Livres> getBibliotheque() {
		    bibliotheque.add(new Livres("1984","George Orwell","05/06/2018","GALLIMARD","Littérature",2));
		    bibliotheque.add(new Livres("Ne tirez pas sur l'oiseau moqueur","Harper Lee","07/01/2019","GRASSET","Bande dessinée",2));
		    bibliotheque.add(new Livres("Le meilleur des mondes","Aldous Huxley","11/06/2015","PLACE DES EDITEURS","Littérature",5));
		    bibliotheque.add(new Livres("La voleuse de livres","Markus Zusak","05/06/2005","POCKET","Littérature",7));
		    bibliotheque.add(new Livres("CATCH-22","Joseph Heller","05/04/2011","SIMON & SCHUSTER","Livre anglais",2));
		return bibliotheque;
	}
	
	//Méthode qui affiche le menu
	public void menu() {
			        System.out.println("--------- Bienvenue à la librairie ! --------\n");
				System.out.println("------Quelle opération voulez vous effectuer ? ------\n");
				System.out.println("--------- Tapez 1 pour Ajouter un livre --------\n");
				System.out.println("--------- Tapez 2 pour Rechercher un livre --------\n");
				System.out.println("------Tapez 3 pour Afficher la liste des livres --------\n");
				System.out.println("------Tapez 4 pour Afficher la liste des emprunteurs --------\n");
				System.out.println("------Tapez 5 pour Afficher la liste des Auteurs --------\n");
				System.out.println("--------- Tapez 6 pour Emprunter un livre --------\n");
				System.out.println("--------- Tapez 7 pour Retourner un livre --------\n");
				System.out.println("--------- Tapez 8 pour quitter le gestionnaire --------\n");
				System.out.print("choix :");
				
    }
		
	// Méthode qui permet à l'utilisateur d'ajouter des livres dans la bibliothèque
    public void AjouterLivre() throws GestionException {
    	    System.out.println("------- Ajout de livre --------\n");
			System.out.println("Veuillez saisir les informations du livre :\n");
			System.out.print("Titre : ");
    	 try {
    	    
			titre =  sc.nextLine();
		
		for(Livres  livre : getBibliotheque()) {
		
				 if((livre.getTitre()).equals(titre)) {
					    System.out.println(" Ce livre existe déjà voulez vous en augmenter la quantité ? \n" );
					    ChoixQte = sc.nextLine();
					
					   if((ChoixQte.toLowerCase()).equals("oui")) {
					       System.out.println("\n Veuillez saisir la quantité souhaitée \n");
					       Qte = sc.nextInt();
					       livre.setNb(Qte);
					       System.out.println("La quantité à bien été mis à jour ! \n");
					      return ;
					      }
				       else if((ChoixQte.toLowerCase()).equals("non")) {
							AjouterLivre();
							return;
				          }
				        }
				 else if(! titre.equals(livre.getTitre())) {
					 continue;
				 }
			
			    else {
					      System.out.println("Auteur: ");
					      nomAuteur = sc.nextLine();
					      System.out.print("Date de sortie (jj/mm/aa) : ");
					      DateSortie = sc.nextLine();
					      System.out.print("Edition : ");
					      Edition = sc.nextLine();
					      System.out.print("Catégorie du livre : ");
					      Catégorie = sc.nextLine();
					      System.out.print("Nombre d'exemplaire du livre : ");
					      Qte = sc.nextInt();
					
					bibliotheque.add(new Livres(titre,nomAuteur,DateSortie,Edition,Catégorie,Qte));
					
					System.out.println("Livre ajouter avec succés !\n");
					System.lineSeparator();
				}
			
    	 
		}
			    throw new GestionException();
			    
		             }catch(GestionException e) {
						e.choixinvalide(ChoixQte);
					 }catch(InputMismatchException except) {
						 System.out.println("Entrée invalide. Le nombre d'exemplaire est un entier !");
					 }catch(ConcurrentModificationException ex) {
						 
					 }
			
			 
		}
		
		
	//Méthode qui afficher la liste des livres (elle parcourt la bibliothèque)
	public void AfficherListeLivres() {
			System.out.println("-------- La liste des livres stockés -------\n");
			for(Livres Livres : getBibliotheque()){
				System.out.println("Titre : "+Livres.getTitre());
				System.out.println("Auteur : "+Livres.getAuteur());
				System.out.println("Date de sortie : "+Livres.getDateSortie());
				System.out.println("Edition : "+Livres.getEdition());
				System.out.println("Catégorie : "+Livres.getCatégorie());
				System.out.println("Nombre d'exemplaire : "+Livres.getNB()+"\n");
				
			}
			System.lineSeparator();
			return;
			}
			
		
		
	//Méthode qui recherche un livre présent dans la bibliothèque et l'affiche
	public void RechercherLivre()  {
			System.out.println("------- Recherche de livre --------\n");
			System.out.println("Veuillez saisir le titre, le nom de l'auteur ou la catégorie du livre :\n");
		
			Rech = sc.nextLine();
			
			for(Livres  Livres : getBibliotheque()) {
				
			    if(getRech().equals(Livres.getTitre())||getRech().equals(Livres.getAuteur())||getRech().equals(Livres.getCatégorie())) {
				    System.out.println("Nous avons trouvons le livre ! \n");
					System.out.println("Titre : "+Livres.getTitre());
					System.out.println("Auteur : "+Livres.getAuteur());
					System.out.println("Date de sortie : "+Livres.getDateSortie());
					System.out.println("Edition : "+Livres.getEdition());
					System.out.println("Catégorie : "+Livres.getCatégorie());
					System.out.println("Nombre d'exemplaire : "+Livres.getNB());
					break;
			   }
			    else if(! getRech().equals(Livres.getTitre())||getRech().equals(Livres.getAuteur())||getRech().equals(Livres.getCatégorie())) {
			    	continue;
			    }
			else  {
				System.out.println("Désolé, nous n'avons pas ce livre en stock \n");
				break;
			}
	    }	
			System.lineSeparator();
	}
		
 // Méthode qui affiche la liste des emprunteurs 
		public void AfficherListeEmprunteur() {
			
			System.out.println("-------- La liste des emprunteurs -------\n");
	
			for(Emprunteur Ep : getListe_Emprunteurs() ){
				System.out.println("Emprunteur : "+Ep.getNomEmprunteur());
				System.out.println("Date de l'emprunt : "+Ep.getDateEmprunt());
				System.out.println("Date d'écheance: "+Ep.getDateEchéance()+"\n");
		
			}
			System.lineSeparator();
		}
		
// Méthode qui affiche la liste des auteurs
		public void AfficherListeAuteur() {
			System.out.println("-------- La liste des Auteurs -------\n");
			
			for(Auteur  ListeA : getListe_Auteurs()){
				System.out.println("Nom : "+ListeA.getNomAuteur());
			}
			
	}
		
// Méthode qui permet d'emprunter un livre dans la bibliothèque
		public void EmprunterLivre() throws GestionException {
			try {
			System.out.println("-------Emprunt de livre --------\n");
			System.out.println("Veuillez saisir votre nom : ");
			String nom = sc.nextLine();
			System.out.println("Quel livre souhaitez vous empruntez ?");
			System.out.println("Titre :");
			String titre = sc.nextLine();
			System.out.println("Combien d'exemplaire souhaitez vous empruntez ?\n");
			int Qte = sc.nextInt();
			
			for(Livres Livres :getBibliotheque() ) {
				if(titre.equals(Livres.getTitre())){
					
					if(Qte > Livres.getNB()) {
						System.out.println("Le nombre d'exemplaire du livre est insuffisant !\n");
						break;
					}
					else if(Qte <= Livres.getNB()) {
					Livres.setNB(Qte);
					Liste_Emprunteurs.add(new Emprunteur(nom,dateEmprunt,dateEcheance));
					System.out.println("Nombre d'exemplaire restant : "+Livres.getNB());
					System.out.println("Emprunt de livre effectuer, Bonne lecture !");
					System.out.println("Vous devez retourner le livre avant le "+dateEcheance);
					break;
				
					
				}
			}
				else if( ! titre.equals(Livres.getTitre())) {
					continue;
				}
				else {
					System.out.println("Désolé, ce livre n'existe pas ou a été emprunté chez nous !\n");
					break;
				}
		}
		}catch(InputMismatchException e) {
			System.out.println("Entrée invalide, veuillez saisir un entier !");
		}
			System.lineSeparator();	
	}
		// Méthode qui permet de retourner un livre
		public void RetournerLivre() {
		   try {
			System.out.println("-------Retour de livre --------\n");
			System.out.println("Veuillez saisir votre nom : \n");
			String nom = sc.nextLine();
			
			      for(Emprunteur Ep : getListe_Emprunteurs() ) {
			    	  
			    	  if( !(nom.equals(Ep.getNomEmprunteur()))) {
			    		  continue;
			    	  }
			    	  else if(nom.equals(Ep.getNomEmprunteur())) {
					      System.out.println("Quel livre voulez vous retournez ?\n");
					      System.out.print("Titre :");
					      titre = sc.nextLine();
					      
				       }
			      }
				         for(Livres Livres : getBibliotheque() ) {
					          if(titre.equals(Livres.getTitre())){
						          Livres.setNb(1);
							      System.out.println("\nLe livre à bien été retourner, merci de votre loyauté \n");
							      break;
					              }
				              else {
						          System.out.println("Ce livre n'existe pas dans la bibliothèque veuillez l'ajouter !");
						          break;
					              }
				       }
				         System.lineSeparator();  
			       }catch(NullPointerException e){
			    	   System.out.println("La liste des emprunteurs est vide !");
			       }
		}
			 
			      
		
		
		
		
		//Méthode qui permet la gestion des dates d'emprunt et de retour
			public  Date GestionDateEcheance(Date dateEmprunt,int jourEcheant){
				Calendar C = Calendar.getInstance();
				C.setTime(dateEmprunt);
				C.add(Calendar.DAY_OF_YEAR,jourEcheant);
				return C.getTime();
			}
			
		// Méthode qui permet à l'utilisateur d'interrompre le programme	
			public void Quitter() throws GestionException {
				try {
				    System.out.println("\nVoulez vous vraiment quitter le gestionnaire ?");
				    choix = sc.nextLine();
				
				     if((choix.toLowerCase()).equals("oui")) {
					      System.exit(1);
				     }
				     else if((choix.toLowerCase()).equals("non")) {
					      return;
				     }
				throw new GestionException();
				
				}catch(GestionException e){
					e.choixinvalide(choix.toLowerCase());
				}
				
				System.lineSeparator();
			
		}
			
			
			}
			
		
		
		
	
		
