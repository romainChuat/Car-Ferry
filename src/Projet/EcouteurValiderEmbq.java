package Projet;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class EcouteurValiderEmbq extends JDialog implements ActionListener{
	private FenetreEmbarquement FenetreEmbq;
	
	/**
	 * Constructeur par défaut.
	 * Creer un nouveau <code>EcouteurValiderEmbq</code>.
	 * @param f une <code>FenetreEmbarquement</code>.
	 */
	public EcouteurValiderEmbq(FenetreEmbarquement f) {
		FenetreEmbq=f;
	}
	
	/**
	 * Gère les action associer au diFenetreEmbqérent evenement des diFenetreEmbqerent elements.
	 * que la classe <code>EcouteurValiderEmbq</code> ecoute.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == FenetreEmbq.getb1()) {
			FenetreEmbq.getSaisieCargaison().setEditable(false);
			FenetreEmbq.getSaisePassager().setEditable(true);
		}
		if(e.getSource() == FenetreEmbq.getb2()) {
			FenetreEmbq.getSaisieCargaison().setEditable(true);
			FenetreEmbq.getSaisePassager().setEditable(false);
		}
		
		if(e.getSource() == FenetreEmbq.getValider()) {
			String donnees [] = FenetreEmbq.get_value();
			String immat=FenetreEmbq.getSaisie_immat().getText();
			Vehicule v = null;
			
			if(e.getSource()==FenetreEmbq.getValider() && verifChamps(donnees)) {
				Personne conducteur = new Personne(donnees[5],donnees[6],donnees[7]);
				if(FenetreEmbq.getb1().isSelected()) {
					if(donnees[1].length()==0) {
						JOptionPane.showMessageDialog(this,"Embarquement impossible : saisir un nombre de passager (si 0, saisir 0)","Embarquement",JOptionPane.WARNING_MESSAGE);
					}else {
						v = new Voiture(donnees[0], Double.parseDouble(donnees[2]),Double.parseDouble(donnees[3]), conducteur, Integer.parseInt(donnees[1]));
					}
				}else {
					if(donnees[4].length()==0) {
						JOptionPane.showMessageDialog(this,"Embarquement impossible : saisir une cargaison (si 0, saisir 0)","Embarquement",JOptionPane.WARNING_MESSAGE);
					}else {
						v = new Camion(donnees[0], Double.parseDouble(donnees[2]),Double.parseDouble(donnees[3]), conducteur, Double.parseDouble(donnees[4]));
					}
				}
				try {
					boolean emb = true;
					if(v != null) {
						emb = FenetreEmbq.embarque(v);
					}
					if(!emb) {
						JOptionPane.showMessageDialog(this,"Embarquement impossible","Embarquement",JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(this,"Embarquement reussi","Embarquement",JOptionPane.WARNING_MESSAGE);
						FenetreEmbq.getSaisie_immat().setText("");
					}
				} catch (EmbarquementException e1) {
					System.out.print("Message "+ e1.getMessage());
				}
			}
		}
	
	}
	/**
	 * Test si les donnes du tableau <code>donneeSaisie</code> sont valides.
	 * @param donneeSaisie un tableau de donnee saisie.
	 * @return true si aucune des valeur de <code>donneeSaisie</code> n'est erronee, false sinon.
	 */
	public boolean verifChamps(String [] donneeSaisie) {
		if(donneeSaisie[0].length()!=9) {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : l'immatriculation doit contenir 9 car.","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(donneeSaisie[2].length()==0 || donneeSaisie[2]=="0") {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : Le poids du vehicule ne peut pas valoir 0 ","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(donneeSaisie[3].length()==0 || donneeSaisie[3]=="0") {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : La longueur du vehicule ne peut pas valoir 0 ","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(donneeSaisie[5].length()<2) {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : Le nom du conducteur doit contenir au moins 2 car.","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(donneeSaisie[6].length()<2) {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : Le prenom du conducteur doit contenir au moins 2 car.","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(donneeSaisie[7].length()<4) {
			JOptionPane.showMessageDialog(this,"Embarquement impossible : Le numero de permis doit contenir au moins 4 car.","Embarquement",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}