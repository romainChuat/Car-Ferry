package Projet;

/**
 * Permet la création d'une nouvelle Exception.
 * Cette exception sera utilisé si un Vehicule ne peut pas être embarqué.
 * @author Romain Chuat, Joris Marza
 */
public class EmbarquementException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur défaut.
	 * Créer une <code>LengthException</code>.
	 * @param message une chaine correspondant au message de l'exception.
	 */
	EmbarquementException(String message){
		super(message);
	}
}
