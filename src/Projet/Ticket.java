package Projet;
/**
 * Permet la création d'un <b> Ticket </b>
 * @author Romain Chuat, Joris Marza
 */
public class Ticket implements Comparable<Ticket>{
	private String nom;
	private String prenom;
	private String place;
	private double tarif;
	private String immatriculation;
	
	/**
	 * Constructeur.
	 * Créer un <code>Ticket</code>.
	 * @param nom le nom du conducteur associé au <code>Ticket</code>
	 * @param prenom le prenom du conducteur associé au <code>Ticket</code>
	 * @param place la pkace attribuée associé au <code>Ticket</code>
	 * @param tarif le tarif du voyage associé au <code>Ticket</code>
	 * @param immatriculation l'immaticulation associé au <code>Ticket</code>
	 */
	public Ticket(String nom, String prenom,String place, double tarif, String immatriculation) {
		this.nom=nom;
		this.prenom=prenom;
		this.place = place;
		this.tarif = tarif;
		this.immatriculation = immatriculation;
	}
	/**
	 * @return le nom du conducteur du <code>Ticket</code>
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * @return le prenom du conducteur du <code>Ticket</code>
	 */
	public String getPrenom() {
		return this.prenom;
	}
	/**
	 * @return l'immatriculation du <code>Ticket</code>
	 */
	public String getImmatriculation() {
		return this.immatriculation;
	}
	
	
	/**
	 * Test si Object o est égal au <code>Ticket</code> courant (<code>this</code>).
	 * @param o un Objet
	 * @return true, si Object o est égal au <code>Ticket</code> courant (<code>this</code>)
	 */
	public boolean equals (Object o) {
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Ticket t = (Ticket)o; ///comparer le reste
		return (this.getNom().equals(t.getNom()) && this.getPrenom().equals(t.getPrenom()));
	}
	/**
	 * Compare un <code>Ticket t</code> au Ticket courant (<code>this</code>).
	 * @param t un Ticket
	 * @return 0 si les nom et prenom du <code>Ticket t</code> et du Ticket courant (<code>this</code>) sont identiques, 
	 * un entier inférieur ou supérieur à 0 sinon
	 */
	public int compareTo(Ticket t) {
		int r= this.getNom().compareTo(t.getNom());
		if (r==0) r= this.getPrenom().compareTo(t.getPrenom());
		return r;
	}
	/**
	 * Construit une représentation chainée d'un <code>Ticket</code>.
	 * La chaine comprend le nom, le prenom, la place et le tarif.
	 */
	public String toString() {
		return "["+this.place+" "+this.nom+" "+this.prenom+" : "+this.immatriculation+" : "+this.tarif+"euros ]";
	}
	public boolean compareImmatriculation(String immatVehicule) {
		return this.getImmatriculation().equals(immatVehicule);
	}
}
