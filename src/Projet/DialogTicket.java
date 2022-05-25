package Projet;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Permet la création d'une Boite de dialogue <b> DialogTicket </b>.
 * La boite de dialogue permet l'affichage d'un ticket.
 * @author Romain Chuat, Joris Marza
 *
 */
public class DialogTicket extends JDialog{
	/**
	 * Constructeur par défaut.
	 * Créer un <code> DialogTicket </code>.
	 * @param ticket le Ticket a afficher.
	 * */
	DialogTicket(Ticket ticket){
		this.setLocation(100,100);
		JOptionPane.showMessageDialog(this,ticket,"TICKET",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
