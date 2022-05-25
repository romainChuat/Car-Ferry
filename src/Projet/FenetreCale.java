
package Projet;

import java.awt.*;
import java.util.Queue;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

/**
 * Permet la creation d'une <b>FenetreCale</b> (Fenetre Graphique).
 * @author Romain Chuat, Joris Marza
 */
public class FenetreCale extends JFrame implements ListSelectionListener{
	DialogTicket FenetreTicket;
	JPanel mainPanel,leftPanel,rightPanel;
	JList<String> rangeeDroite, rangeeGauche;
	List<Ticket> listing;
	
	/**
	 * Constructeur par défaut.
	 * Creer une nouvelle <code>FenetreCale</code> à partir des rangee.
	 * @param rangeeD une <code>Rangee</code>
 	 * @param rangeeG une <code>Rangee</code>
	 * @param listing une liste de <code>Ticket</code>
	 */
	FenetreCale(Rangee rangeeD,Rangee rangeeG,List<Ticket> listing){
		this.listing = listing;
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setSize(500,200);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBackground(Color.green);
		Container c = this.getContentPane();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.green);
		mainPanel.setLayout(new GridLayout(1,2));
		
		
		Queue<Vehicule> listGauche = rangeeG.getRangee();
		String list1 [] =  new String [rangeeG.size()];
		int i =0;
		for(Vehicule v : listGauche) {
			list1[i] = v.convertToString();
			i++;
		}
		rangeeGauche= new JList<String>(list1);
		rangeeGauche.setFixedCellWidth(220);
		rangeeGauche.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rangeeGauche.addListSelectionListener(this);
		
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.green);
		Border borderLeft = BorderFactory.createTitledBorder("Rangee de Gauche");
		leftPanel.setBorder(borderLeft);
		leftPanel.add(rangeeGauche);
		
		
		Queue<Vehicule> listDroite = rangeeD.getRangee();
		String list2 [] =  new String [rangeeD.size()];
		i =0;
		for(Vehicule v : listDroite) {
			list2[i] = v.convertToString();
			i++;
		}
		rangeeDroite= new JList<String>(list2);
		rangeeDroite.setFixedCellWidth(220);
		rangeeDroite.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rangeeDroite.addListSelectionListener(this);
		
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.green);
		Border borderRight = BorderFactory.createTitledBorder("Rangee de Droite");
		rightPanel.setBorder(borderRight);
		
		rightPanel.add(rangeeDroite);
		
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		
		c.add(mainPanel);
	}

	/**
	 * Permet la gestion des evenement associees aux listes de Vehicules dans la fenetre.
	 * @param evt un ListSelectionEvent
	 */
	public void valueChanged(ListSelectionEvent evt)  { 
		if(!rangeeDroite.isSelectionEmpty()) {
			String immatriculation = getImmatriculation(rangeeDroite.getSelectedValue());
			FenetreTicket = new DialogTicket(searchTicket(immatriculation));
		}else if(!rangeeGauche.isSelectionEmpty()) {
			String immatriculation = getImmatriculation(rangeeGauche.getSelectedValue());
			FenetreTicket = new DialogTicket(searchTicket(immatriculation));
		}
		rangeeDroite.clearSelection();
		rangeeGauche.clearSelection();
		
	}
	/**
	 * Permet de recuperer l'immaticulation d'un vehicule passer en parametre sous forme de chaine
	 * telle qu'elles le sont affichees dans les listes.
	 * On considere que c'est le dernier element de la chaine et qu'il a une longeur de 9 caractere.
	 * @param vehicule.
	 * @return l'immatriculation d'un vehicule passer sous forme de chaine.
	 */
	public String getImmatriculation(String vehicule) {
		return vehicule.substring(vehicule.length()-9);
	}
	/**
	 * Permet la recherche d'un ticket, sous forme d'immatriculation.
	 * @param immatVehicule un <code>Vehicule</code>.
	 * @return le <code>Ticket</code> recherche.
	 */
	public Ticket searchTicket(String immatVehicule) {
		for(Ticket t : listing) {
			if(t.compareImmatriculation(immatVehicule)) {
				return t;
			}
		}
		return null;
	}
}
