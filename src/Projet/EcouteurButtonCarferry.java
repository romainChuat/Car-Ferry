package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Permet la création d'un <b>EcouteurButtonCarFerry</b>. 
 * Listener du bouton de la <code> FenetreCarFerry</code>.
 * @author Romain Chuat, Joris Marza
 *
 */
public class EcouteurButtonCarferry extends JDialog implements ActionListener {
		private FenetreCarFerry fenetreCF;
		
	
		/**
		 * Constructeur par défaut.
		 * @param f <code>FenetreCarFerry</code>
		 */
		public EcouteurButtonCarferry(FenetreCarFerry f) {
			this.fenetreCF = f;
		}
		/**
		 * Gère les action associees au evenement que la classe ecoute.
		 * @param e ActionEvent.
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == fenetreCF.getEmbarquerButton()) {
				FenetreEmbarquement Femb = new FenetreEmbarquement(fenetreCF.carferry);
			}
			if(e.getSource() == fenetreCF.getDebarquerButton()) {
				if(!fenetreCF.carferry.isEmpyt()) {
					Vehicule v  = fenetreCF.carferry.retirerVehicule();
					String immat = v.getImmatricualtion();
					JOptionPane.showMessageDialog(this,"Débarquement : "+immat,"Embarquement",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this,"La cale est vide","Embarquement",JOptionPane.WARNING_MESSAGE);
				}
			}
			if(e.getSource() == fenetreCF.getCaleMenu()) {
				 FenetreCale fCale = new FenetreCale(fenetreCF.carferry.getCale().getRangeeI(1),fenetreCF.carferry.getCale().getRangeeI(0),fenetreCF.carferry.getCale().getListing());
			}
		}
	

}
