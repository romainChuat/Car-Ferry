package Projet;

import java.awt.Container;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * Permet la creation d'une <b>FenetreEmbarquement</b> (Fenetre Graphique).
 * La fenetre permettra de saisir un nouveau Vehicule et de l'embarquer.
 * @author Romain Chuat, Joris Marza
 */
public class FenetreEmbarquement extends JFrame {	
	private static final long serialVersionUID = 1L;
	private CarFerry carferry;
	private JButton  valide;
	private  JTextField saisie_immat,saisie_passager,saisie_poids,saisie_long,
	saisie_cargaison, saisie_nom,saisie_prenom, saisie_nopermis;
	private JRadioButton b1,b2;
		
	/**
	 * Constructeur par défaut.
	 * Creer une nouvelle <code>FenetreEmbarquement</code>.
	 * @param carferry
	 */
	public FenetreEmbarquement (CarFerry carferry) {
		this.carferry = carferry;
		setVisible(true);
		setTitle ("CAR FERRY - Embarquement");
		setSize(575,400);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout());
		
		//création du boutton de validation
		valide=new JButton("VALIDER");
		/** creation du TOP Panel**/
		JPanel top =  new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.RIGHT));
		top.setBackground(Color.red);
		c.add(top,BorderLayout.NORTH);
		JLabel labelType = new JLabel("Quel est le type de votre vehicule ?");
		b1 = new JRadioButton("Voiture");
		b1.setSelected(true);
		b2 = new JRadioButton("Camion");
		
		top.add(labelType);
		top.add(b1);
		top.add(b2);
		ButtonGroup grType = new ButtonGroup();
		grType.add(b1);
		grType.add(b2);
		
		
		/*Création du MIDDLE PANEL*/
		JPanel middle =  new JPanel();
		middle.setLayout(new GridLayout(8,1));
		c.add(middle,BorderLayout.CENTER);
		
		// une premiere zone z1 
		JPanel z1= new JPanel();
		
		z1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		z1.setBackground(Color.green);
		z1.add (new JLabel ("Entrez immatriculation du vehicule (20 car maxi)"));
		saisie_immat=new JTextField(20);
		z1.add(saisie_immat); 
		middle.add(z1);
		
		JPanel z2= new JPanel();
		z2.setBackground(Color.green);
		z2.add (new JLabel ("Entrer le nombre de passagers"));
		saisie_passager=new JTextField(3);
		z2.add(saisie_passager); 
		z2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z2);
		
		JPanel z3= new JPanel();
		z3.setBackground(Color.green);
		z3.add (new JLabel ("Entrer le poids du vehicule"));
		saisie_poids=new JTextField(6);
		z3.add(saisie_poids); 
		z3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z3);
		
		JPanel z4= new JPanel();
		z4.setBackground(Color.green);
		z4.add (new JLabel ("Entrer la longeur du vehicule"));
		saisie_long=new JTextField(6);
		z4.add(saisie_long); 
		z4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z4);
		
		JPanel z5= new JPanel();
		z5.setBackground(Color.green);
		//z2.setBackground (Color.green);
		z5.add (new JLabel ("Entrer le poids de la cargaison"));
		saisie_cargaison=new JTextField(6);
		saisie_cargaison.setEditable(false);
		z5.add(saisie_cargaison); 
		// z2 est en dessous de z1 mais on veut aligner z2 et z1 � droite
		z5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z5,BorderLayout.LINE_START);
		
		JPanel z6= new JPanel();
		z6.setBackground(Color.green);
		z6.add (new JLabel ("Entrer le nom"));
		saisie_nom=new JTextField(20);
		z6.add(saisie_nom); 
		// z2 est en dessous de z1 mais on veut aligner z2 et z1 � droite
		z6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z6);
		
		JPanel z7= new JPanel();
		z7.setBackground(Color.green);
		z7.add (new JLabel ("Entrer le prenom"));
		saisie_prenom=new JTextField(20);
		z7.add(saisie_prenom); 
		z7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z7);
		
		JPanel z8= new JPanel();
		z8.setBackground(Color.green);
		z8.add (new JLabel ("Entrer le numro de permis"));
		saisie_nopermis=new JTextField(20);
		z8.add(saisie_nopermis); 
		z8.setLayout(new FlowLayout(FlowLayout.RIGHT));
		middle.add(z8);
		
		JPanel bottom= new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.add(valide,BorderLayout.NORTH); 
		
		c.add("South",bottom);
		
		EcouteurValiderEmbq ecbc=new EcouteurValiderEmbq(this);
		// associer l'ecouteur au bouton valide
		valide.addActionListener(ecbc);
		// associer l'ecouteur 
		//saisie_immat.addActionListener(ecbc);
		b1.addActionListener(ecbc);
		b2.addActionListener(ecbc);
	}

	/**
	 * @return saisie_immat un JTextField permettant la saisie de l'immatriculation.
	 */
	public JTextField getSaisie_immat (){
		return saisie_immat;
	}
	/**
	 * @return saisie_cargaison un JTextField permettant la saisie de la cargaison.
	 */
	public JTextField getSaisieCargaison (){
		return saisie_cargaison;
	}
	/**
	 * @return b2 un JRadioButton permettant de choisir Vehicule comme type de vehicule.
	 */
	public JRadioButton getb1() {
		return b1;
	}
	/**
	 * @return b2 un JRadioButton permettant de choisir Camion comme type de vehicule.
	 */
	public JRadioButton getb2() {
		return b2;
	}
	/**
	 * @return valide un JButton permettant de valide la saisie du vehicule.
	 */
	public JButton getValider() {
		return valide;
	}
	/**
	 * @return saisie_passager un JTextField permettant la saisie du nombre de passager.
	 */
	public JTextField getSaisePassager() {
		return saisie_passager;
	}
	/**
	* @return un tableau de chaine comportant les elements saisie dans chacun des champs de la fenetre.
	*/
	public String[] get_value() {
		String donnee_embarquement [] = new String[8];
		donnee_embarquement[0] = saisie_immat.getText();
		donnee_embarquement[1] = saisie_passager.getText();
		donnee_embarquement[2] = saisie_poids.getText();
		donnee_embarquement[3] = saisie_long.getText();
		donnee_embarquement[4] = saisie_cargaison.getText();
		donnee_embarquement[5] = saisie_nom.getText();
		donnee_embarquement[6] = saisie_prenom.getText();
		donnee_embarquement[7] = saisie_nopermis.getText();
		return donnee_embarquement;
	}
	/**
	 * Permet l'ajout d'un Vehicule dans le carferry.
	 * @param v un Vehicule.
	 * @return true si je vehicule a ete ajoute, false sinon.
	 * @throws EmbarquementException si le Vehicule n'a pas pu être ajoute.
	 */
	public boolean embarque(Vehicule v) throws EmbarquementException {
		return carferry.ajouterVehicule(v);
	}
	
}