package Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Permet la creation d'une <b>FenetreCarFerry</b> (Fenetre Graphique).
 * Permet l'affichage du car-ferry sous forme graphique.
 * @author Romain Chuat, Joris Marza
 */
public class FenetreCarFerry extends JFrame{
	JButton embarque, debarque;
	JMenuItem caleMenu; 
	JMenuBar menuBar;
	FenetreCale fCale;
	CarFerry carferry;
	JMenu caleBar;
	EcouteurButtonCarferry ebcf;
	/**
	 * Constructeur par defaut
	 * creer une FenetreCarFerry
	 * @param carferry un <code>CarFerry</code>
	 */
	public FenetreCarFerry(CarFerry carferry) {
		this.carferry = carferry;
		
		this.setTitle("CAR-FERRY");
		ebcf =  new EcouteurButtonCarferry(this);
		
		embarque = new JButton("Embarquer");
		debarque = new JButton("Debarquer");
		embarque.addActionListener(ebcf);
		debarque.addActionListener(ebcf);
		
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		JPanel panelTitre = new JPanel();
		
		JLabel titre = new JLabel("Nouvelle croisiere");
		
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.green);
		panel.add(embarque);
		panel.add(debarque);
		
		panelTitre.setBackground(Color.green);
		panelTitre.add(titre);
		
		c.add(panelTitre, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		
	
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		caleBar = new JMenu("Cale du ferry");
		menuBar.add(caleBar);
		caleMenu = new JMenuItem("Afficher la cale");
		caleMenu.addActionListener(ebcf);
		caleBar.add(caleMenu);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,300);
		this.setVisible(true);
		this.setLocation(550,350);
	}
	
	/**
	 * @return embarque un JButton. 
	 */
	public JButton getEmbarquerButton() {
		return embarque;
	}
	/**
	 * @return debarque un JButton. 
	 */
	public JButton getDebarquerButton() {
		return debarque;
	}
	/**
	 * @return caleMenu un JMenuItem.
	 */
	public JMenuItem getCaleMenu() {
		return caleMenu;
	}
}
