package Projet;
/**
 * @author Romain Chuat, Joris Marza
 */
public class Main {
	/**
	 * Création des véhicules, 
	 * création du car-ferry,
	 * embarquement des véhicules dans le car-ferry,
	 * affichage du car-ferry,
	 * débarquement des véhicules,
	 * affichage du car-ferry après débarquement
	 * @param args
	 * @throws Exception si un véhicule n'a pas pu être ajouter
	 */
	public static void main(String[] args) throws Exception{
		/*Vehicule v1 = new Voiture("RM 1054 FF",1.2,4.2,new Personne("Martin","Jeanne","22FF"),2);
		Vehicule v2 = new Voiture("PO 377 AA",1.4,4.5,new Personne("Dupont","Vincent","A55"),1);
		Vehicule v3 = new Voiture("WX 456 RT",1.2,5.3,new Personne("Durand","Marie","B34"),0);
		Vehicule c1 = new Camion("AZ 678 DF",4,12,new Personne("Grant","Philip","20FF"),15);
		Vehicule c2 = new Camion("QS 543 HJ",5.2,13.5,new Personne("Scott","Simon","B55JG"),22.5);
		Vehicule c3 = new Camion("BN 321 WC",4.5,15,new Personne("Lambert","Alain","C44DJK"),18);*/
		CarFerry ferry = new CarFerry(25,75);
		//System.out.print(ferry);
	
	}

}
