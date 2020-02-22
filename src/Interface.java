import java.awt.BorderLayout;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Interface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JComboBox capteursIncendie,capteursGaz,capteursRadiation,niv, gaz;
	JLabel labelCapteursIncendie, labelCapteursGaz,labelCapteursRadiation, labniv;
	JPanel panelCapteursIncendie, panelCapteursGaz, panelCapteursRadiation,selecniv,selecgaz;
	JCheckBox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5;
	JRadioButton br1 , br2, br3;
	String gazType;
	int valeurRadiation;
	MainInterface interfaceMain;
	ArrayList<CapteurIncendie> listeCapteurIncendie;
	ArrayList<CapteurGaz> listeCapteurGaz;
	ArrayList<CapteurRadiation> listeCapteurRadiation;


	public Interface(MainInterface interfaceMain)  {

		super("Interface"); 
		this.interfaceMain=interfaceMain;
		this.setSize(630, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);

		JPanel panelBoutonRetour = new JPanel();
		JButton bRetour = new JButton("Retour");
		bRetour.addActionListener(this);
		bRetour.setActionCommand("retour");
		panelBoutonRetour.setBounds(530,175,100,100);
		panelBoutonRetour.add(bRetour);
		this.add(panelBoutonRetour);

		// création du groupe de radiobutton 
		ButtonGroup bg = new ButtonGroup();
		Box panneauRadio = Box.createVerticalBox();
		br1 = new JRadioButton("Incendie");
		br2 = new JRadioButton("Gaz");
		br3 = new JRadioButton("Radiation");
		bg.add(br1);
		bg.add(br2);
		bg.add(br3);
		br1.addActionListener(this);
		br1.setActionCommand("incendieSet");
		panneauRadio.add(br1);
		panneauRadio.add(br2);
		panneauRadio.add(br3);
		panneauRadio.setBorder(BorderFactory.createLineBorder(Color.RED));
		panneauRadio.setBounds(10,50,100,100);
		this.add(panneauRadio);

		//création de la liste permettant le choix du capteur pour Incendie
		if (interfaceMain.getCapteursIncendie().isEmpty() == false) {
			listeCapteurIncendie = interfaceMain.getCapteursIncendie();  
			ArrayList<String> nomLieuCapteurs = new ArrayList<String>();
			for (CapteurIncendie i : listeCapteurIncendie) {
				nomLieuCapteurs.add(i.nom +" en "+i.lieu);
			}
			String[] lieuCapteurs = nomLieuCapteurs.stream().toArray(String[]::new);
			capteursIncendie = new JComboBox<String>(lieuCapteurs);
			capteursIncendie.setSelectedIndex(0);
			labelCapteursIncendie = new JLabel("Sélectionnez un capteur");
			panelCapteursIncendie = new JPanel();
			panelCapteursIncendie.add(labelCapteursIncendie);
			panelCapteursIncendie.add(capteursIncendie);
			panelCapteursIncendie.setBounds(120,50,300,40);
			panelCapteursIncendie.setVisible(false);
			this.add(panelCapteursIncendie);
		}
		else {
			labelCapteursIncendie = new JLabel("Aucun capteur déclaré, génération impossible");
			panelCapteursIncendie = new JPanel();
			panelCapteursIncendie.add(labelCapteursIncendie);
			panelCapteursIncendie.setBounds(120,50,300,40);
			panelCapteursIncendie.setVisible(false);
			this.add(panelCapteursIncendie);
		}

		//création de la liste permettant le choix du capteur pour Gaz
		if (this.getInterfaceMain().getCapteursGaz().isEmpty() == false) {
			listeCapteurGaz = this.getInterfaceMain().getCapteursGaz();  
			ArrayList<String> nomLieuCapteursGaz = new ArrayList<String>();
			for (CapteurGaz i : listeCapteurGaz) {
				nomLieuCapteursGaz.add(i.nom +" en "+i.lieu);
			}
			String[] lieuCapteursGaz = nomLieuCapteursGaz.stream().toArray(String[]::new);
			capteursGaz = new JComboBox<String>(lieuCapteursGaz);
			capteursGaz.setSelectedIndex(0);
			labelCapteursGaz = new JLabel("Sélectionnez un capteur");
			panelCapteursGaz = new JPanel();
			panelCapteursGaz.add(labelCapteursGaz);
			panelCapteursGaz.add(capteursGaz);
			panelCapteursGaz.setBounds(120,50,300,40);
			panelCapteursGaz.setVisible(false);
			this.add(panelCapteursGaz);
		}
		else {
			labelCapteursGaz = new JLabel("Aucun capteur déclaré, génération impossible");
			panelCapteursGaz = new JPanel();
			panelCapteursGaz.add(labelCapteursGaz);
			panelCapteursGaz.setBounds(120,50,300,40);
			panelCapteursGaz.setVisible(false);
			this.add(panelCapteursGaz);
		}

		//création de la liste permettant le choix du capteur pour Radiation
		if (this.getInterfaceMain().getCapteursRadiation().isEmpty() == false) {
			listeCapteurRadiation = this.getInterfaceMain().getCapteursRadiation();  
			ArrayList<String> nomLieuCapteursRadiation = new ArrayList<String>();
			for (CapteurRadiation i : listeCapteurRadiation) {
				nomLieuCapteursRadiation.add(i.nom+" en "+i.lieu);
			}
			String[] lieuCapteursRadiation = nomLieuCapteursRadiation.stream().toArray(String[]::new);
			capteursRadiation = new JComboBox<String>(lieuCapteursRadiation);
			capteursRadiation.setSelectedIndex(0);
			labelCapteursRadiation = new JLabel("Sélectionnez un capteur");
			panelCapteursRadiation = new JPanel();
			panelCapteursRadiation.add(labelCapteursRadiation);
			panelCapteursRadiation.add(capteursRadiation);
			panelCapteursRadiation.setBounds(120,50,300,40);
			panelCapteursRadiation.setVisible(false);
			this.add(panelCapteursRadiation);
		}
		else {
			labelCapteursRadiation = new JLabel("Aucun capteur déclaré, génération impossible");
			panelCapteursRadiation = new JPanel();
			panelCapteursRadiation.add(labelCapteursRadiation);
			panelCapteursRadiation.setBounds(120,50,300,40);
			panelCapteursRadiation.setVisible(false);
			this.add(panelCapteursRadiation);
		}

		//création du choix du niveau d'importance de l'alarme
		String[] nivimp = {"1","2","3","4"};
		niv = new JComboBox(nivimp);
		niv.setSelectedIndex(0);
		niv.setVisible(true);
		labniv = new JLabel ("Selectionner un niveau d'importance");
		JPanel selecniv = new JPanel();
		selecniv.add(labniv);
		selecniv.add(niv);
		selecniv.setBounds(120,100, 300, 40);
		this.add(selecniv);
		this.setVisible(true);

		// Création du champs permettant la sélection du gaz
		JPanel selecgaz = new JPanel();
		checkbox1 = new JCheckBox("H");
		checkbox2 = new JCheckBox("CO2");      
		checkbox3 = new JCheckBox("He");
		checkbox4 = new JCheckBox("O");
		checkbox5 = new JCheckBox("C0");
		selecgaz.setBorder(BorderFactory.createTitledBorder("Type de gaz"));
		selecgaz.add(checkbox1);
		selecgaz.add(checkbox2);
		selecgaz.add(checkbox3);
		selecgaz.add(checkbox4);
		selecgaz.add(checkbox5);
		selecgaz.setBounds(420, 50, 150, 100);
		this.add(selecgaz);
		selecgaz.setVisible(false);

		//création du slider permettant le choix du niveau de radiation
		JPanel sliderrad = new JPanel(); 
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);    
		Hashtable position = new Hashtable();
		position.put(0, new JLabel("0"));
		position.put(25, new JLabel("25"));
		position.put(50, new JLabel("50"));
		position.put(75, new JLabel("75"));
		position.put(100, new JLabel("100"));
		slider.setLabelTable(position);
		slider.setValue(0);
		sliderrad.add(slider);
		sliderrad.setBounds(420, 50, 200, 100);
		sliderrad.setVisible(false);
		sliderrad.setBorder(BorderFactory.createTitledBorder("Niveau de Radiation"));
		this.add(sliderrad);


		//création du bouton permettant de générer un événement
		JPanel buttonPanel = new JPanel();
		JButton br4 = new JButton("Générer événement");
		buttonPanel.add(br4);
		buttonPanel.setBounds(200,175,200,100);
		buttonPanel.setVisible(true);
		this.add(buttonPanel);

		//Listener sur br2 (bouton radio gaz)
		br2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sliderrad.setVisible(false);
				selecgaz.setVisible(true);
			}
		});

		//Listener sur br1 (bouton radio incendie)
		br1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sliderrad.setVisible(false);
				selecgaz.setVisible(false);
				panelCapteursGaz.setVisible(false);
				panelCapteursRadiation.setVisible(false);
				panelCapteursIncendie.setVisible(true);
			}
		});

		br2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sliderrad.setVisible(false);
				selecgaz.setVisible(false);
				panelCapteursIncendie.setVisible(false);
				panelCapteursRadiation.setVisible(false);
				panelCapteursGaz.setVisible(true);
			}
		});

		//Listener sur br3 (bouton radio radiation)
		br3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sliderrad.setVisible(true);
				selecgaz.setVisible(false);
				panelCapteursIncendie.setVisible(false);
				panelCapteursGaz.setVisible(false);
				panelCapteursRadiation.setVisible(true);
			}
		});

		//Listener sur le slider
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				valeurRadiation= slider.getValue();

			}
		});

		br4.addActionListener(this);
		br4.setActionCommand("generate");


	}
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("generate")) {
			if (br1.isSelected() && labelCapteursIncendie.getText() == "Sélectionnez un capteur") {
				int indexIncendieEvent = capteursIncendie.getSelectedIndex();
				CapteurIncendie selectedCapteur = listeCapteurIncendie.get(indexIncendieEvent);
				if (selectedCapteur.ecouteursIncendies.isEmpty()) {
					selectedCapteur.addIncendieListener(this.getInterfaceMain().getMoniteurA());
				}
				new InterfaceAjoutEvenementIncendie(selectedCapteur,new Date().toString(),niv.getSelectedItem().toString(),this.getInterfaceMain());
			}

			else if ((br2.isSelected() && labelCapteursGaz.getText() == "Sélectionnez un capteur") && (checkbox1.isSelected() || checkbox2.isSelected() || checkbox3.isSelected() || checkbox4.isSelected() || checkbox5.isSelected())) {
				int indexGazEvent = capteursGaz.getSelectedIndex();
				CapteurGaz selectedCapteur = listeCapteurGaz.get(indexGazEvent);
				if (selectedCapteur.ecouteursGaz.isEmpty()) {
					selectedCapteur.addGazListener(this.getInterfaceMain().getMoniteurA());
					selectedCapteur.addGazListener(this.getInterfaceMain().getMoniteurB());
				}

				if (checkbox1.isSelected()) {
					gazType=checkbox1.getText();
				}
				if (checkbox2.isSelected()) {
					gazType=checkbox2.getText();
				}
				if (checkbox3.isSelected()) {
					gazType=checkbox3.getText();
				}
				if (checkbox4.isSelected()) {
					gazType=checkbox4.getText();
				}
				if (checkbox5.isSelected()) {
					gazType=checkbox5.getText();
				}
				
				new InterfaceAjoutEvenementGaz(selectedCapteur,new Date().toString(), niv.getSelectedItem().toString(),gazType,this.getInterfaceMain());

			}
			else if (br3.isSelected() && labelCapteursRadiation.getText() == "Sélectionnez un capteur") {
				int indexRadiationEvent = capteursRadiation.getSelectedIndex();
				CapteurRadiation selectedCapteur = listeCapteurRadiation.get(indexRadiationEvent);
				if (selectedCapteur.ecouteursRadiation.isEmpty()) {
					selectedCapteur.addRadiationListener(this.getInterfaceMain().getMoniteurB());
				}
				new InterfaceAjoutEvenementRadiation(selectedCapteur, new Date().toString(), niv.getSelectedItem().toString(),valeurRadiation,interfaceMain);
			}
			else {
				System.out.println("Impossible, vérifier que tout est sélectionné / existant");
			}
		}

		if (e.getActionCommand().equals("retour")) {
			System.out.println("Retour interface principal");
			interfaceMain.setVisible(true);
			this.dispose(); 
		}
	}

	public MainInterface getInterfaceMain() {
		return interfaceMain;
	}

}
