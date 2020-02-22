import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InterfaceCapteur extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JRadioButton br1, br2, br3;
	JTextField nomCapteur;
	JComboBox lieuCapteur;
	MainInterface interfaceMain;
	
	public InterfaceCapteur(MainInterface interfaceMain) {
		
		this.interfaceMain=interfaceMain;
		
		this.setTitle("Interface Capteur");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);

		JPanel titre = new JPanel();
		JLabel ajoutCapteur = new JLabel("Vous pouvez ajouter un capteur ici");
		titre.add(ajoutCapteur);
		titre.setBounds(10,0,200,20);
		
		String[] lieucap = {"C214","C215","C216","C217"};
		lieuCapteur = new JComboBox(lieucap);
		lieuCapteur.setSelectedIndex(0);
		lieuCapteur.setVisible(true);
		JLabel lieulab = new JLabel ("Selectionner le lieu du capteur");
		JPanel seleclieu = new JPanel();
		seleclieu.add(lieulab);
		seleclieu.add(lieuCapteur);
		seleclieu.setBounds(0,50, 250, 40);
		this.add(seleclieu);
		this.setVisible(true);
		
		
		JPanel questionLieu = new JPanel();
		JLabel demandeLieu = new JLabel("Entrez le nom du capteur");
		nomCapteur = new JTextField(8);
		questionLieu.add(demandeLieu);
		questionLieu.add(nomCapteur);
		questionLieu.setBounds(-20,20,300,27);
		
		ButtonGroup bg = new ButtonGroup();
		JLabel demandeType = new JLabel("Choisissez le type du capteur");
		Box panneauRadio = Box.createVerticalBox();
		br1 = new JRadioButton("Incendie");
		br2 = new JRadioButton("Gaz");
		br3 = new JRadioButton("Radiation");
		bg.add(br1);
		bg.add(br2);
		bg.add(br3);
		panneauRadio.add(demandeType);
		panneauRadio.add(br1);
		panneauRadio.add(br2);
		panneauRadio.add(br3);
		panneauRadio.setBorder(BorderFactory.createLineBorder(Color.RED));
		panneauRadio.setBounds(10,90,170,90);
		
		JPanel panelBoutonRetour = new JPanel();
		JButton bRetour = new JButton("Retour");
	    bRetour.addActionListener(this);
	    bRetour.setActionCommand("retour");
	    panelBoutonRetour.setBounds(250,200,150,100);
	    panelBoutonRetour.add(bRetour);
	    
	    JPanel panelBoutonCreer = new JPanel();
	    JButton bCapteur = new JButton("Créer capteur");
	    bCapteur.addActionListener(this);
	    bCapteur.setActionCommand("creer");
	    panelBoutonCreer.setBounds(7,200,120,120);
	    panelBoutonCreer.add(bCapteur);
	    
	    
	    
	    this.add(panneauRadio);
	    this.add(titre);
	    this.add(questionLieu);
	    this.add(panelBoutonCreer);
	    this.add(panelBoutonRetour);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("retour")) {
			System.out.println("Retour interface principal");
			interfaceMain.setVisible(true);
			this.dispose(); 
		}
		if (e.getActionCommand().equals("creer") && br1.isSelected() && nomCapteur.getText().isEmpty() == false) {
			interfaceMain.getCapteursIncendie().add(new CapteurIncendie(nomCapteur.getText(),lieuCapteur.getSelectedItem().toString()));
			System.out.println("Capteur ajouté");
		}
		if (e.getActionCommand().equals("creer") && br2.isSelected() && nomCapteur.getText().isEmpty() == false) {
			this.getInterfaceMain().getCapteursGaz().add(new CapteurGaz(nomCapteur.getText(),lieuCapteur.getSelectedItem().toString()));
			System.out.println("Capteur ajouté");
		}
		if (e.getActionCommand().equals("creer") && br3.isSelected() && nomCapteur.getText().isEmpty() == false) {
			this.getInterfaceMain().getCapteursRadiation().add(new CapteurRadiation(nomCapteur.getText(),lieuCapteur.getSelectedItem().toString()));
			System.out.println("Capteur ajouté");
		}
		
	}

	public MainInterface getInterfaceMain() {
		return interfaceMain;
	}
	

}
