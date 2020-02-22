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

public class InterfaceMoniteur extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;
	JRadioButton inc , ga, rad;
	JLabel labelEventIncendie, labelEventGaz, labelEventRadiation;
	JPanel panelEventIncendie, panelEventGaz, panelEventRadiation, boutonDetails,boutonTraiter;
	JComboBox listeIncendie,listeGaz,listeRadiation;
	MainInterface interfaceMain;
	ArrayList<IncendieEvent> listeIncendieEvent;
	ArrayList<IncendieEvent> checkedIncendieEvent;
	ArrayList<GazEvent> listeGazEvent;
	ArrayList<GazEvent> checkedGazEvent;
	ArrayList<RadiationEvent> listeRadiationEvent;
	ArrayList<RadiationEvent> checkedRadiationEvent;
	InterfaceIncendieEventDetails interfaceIncendie;
	InterfaceGazEventDetails interfaceGaz;
	InterfaceRadiationEventDetails interfaceRadiation;
	
	public InterfaceMoniteur(MainInterface interfaceMain) {
		super("Interface"); 
		this.interfaceMain=interfaceMain;
		this.setSize(630, 280);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		checkedIncendieEvent = new ArrayList<IncendieEvent>();
		checkedGazEvent = new ArrayList<GazEvent>();
		checkedRadiationEvent = new ArrayList<RadiationEvent>();
		
		// création du groupe de radiobutton 
		ButtonGroup bg = new ButtonGroup();
		Box boite = Box.createVerticalBox();
		inc = new JRadioButton("Incendie");
		ga = new JRadioButton("Gaz");
		rad = new JRadioButton("Radiation");
		inc.addActionListener(this);
		ga.addActionListener(this);
		rad.addActionListener(this);
		bg.add(inc);
		bg.add(ga);
		bg.add(rad);
		boite.add(inc);
		boite.add(ga);
		boite.add(rad);
		boite.setBorder(BorderFactory.createLineBorder(Color.RED));
		boite.setBounds(10,10,200,75);
		this.add(boite);
		this.setVisible(true);
		
		JPanel panelBoutonRetour = new JPanel();
		JButton bRetour = new JButton("Retour");
	    bRetour.addActionListener(this);
	    bRetour.setActionCommand("retour");
	    panelBoutonRetour.setBounds(10,200,150,100);
	    panelBoutonRetour.add(bRetour);
	    this.add(panelBoutonRetour);
	    
		
		
		
		boutonDetails = new JPanel();
		JButton det = new JButton("Détails");
		boutonDetails.setBounds(500, 110, 100, 50);
		boutonDetails.add(det);
		boutonDetails.setVisible(false);
		det.addActionListener(this);
		det.setActionCommand("details");
	    this.add(boutonDetails);
	    
	    boutonTraiter = new JPanel();
		JButton traiter = new JButton("Traiter l'événement");
		boutonTraiter.setBounds(440, 170, 150, 100);
		boutonTraiter.add(traiter);
		boutonTraiter.setVisible(false);
		traiter.addActionListener(this);
		traiter.setActionCommand("traiter");
	    this.add(boutonTraiter);
		
		this.afficheListeIncendieEvent();
		this.afficheListeGazEvent();
		this.afficheListeRadiationEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("retour")) {
			System.out.println("Retour interface principal");
			interfaceMain.setVisible(true);
			this.dispose(); 
			}
	
		if (checkedIncendieEvent.isEmpty()==false && listeIncendieEvent.isEmpty()==false) {
			if (checkedIncendieEvent.contains(listeIncendieEvent.get(listeIncendie.getSelectedIndex()))) {
		    	boutonTraiter.setVisible(true);
		    }
			else {
				boutonTraiter.setVisible(false);
			}
		}
		
		if (checkedGazEvent.isEmpty()==false && listeGazEvent.isEmpty()==false) {
			if (checkedGazEvent.contains(listeGazEvent.get(listeGaz.getSelectedIndex()))) {
		    	boutonTraiter.setVisible(true);
		    }
			else {
				boutonTraiter.setVisible(false);
			}
		}
		
		if (checkedRadiationEvent.isEmpty()==false && listeRadiationEvent.isEmpty()==false) {
			if (checkedRadiationEvent.contains(listeRadiationEvent.get(listeRadiation.getSelectedIndex()))) {
		    	boutonTraiter.setVisible(true);
		    }
			else {
				boutonTraiter.setVisible(false);
			}
		}
		
		if(e.getActionCommand().equals("details") && inc.isSelected()) {
			boutonTraiter.setVisible(true);
			int selectedEventIndex = listeIncendie.getSelectedIndex();
			IncendieEvent selectedEvent = listeIncendieEvent.get(selectedEventIndex);
			checkedIncendieEvent.add(selectedEvent);
			interfaceIncendie = new InterfaceIncendieEventDetails(selectedEvent);
		}
		
		if(e.getActionCommand().equals("details") && ga.isSelected()) {
			boutonTraiter.setVisible(true);
			int selectedEventIndex = listeGaz.getSelectedIndex();
			GazEvent selectedEvent = listeGazEvent.get(selectedEventIndex);
			checkedGazEvent.add(selectedEvent);
			interfaceGaz = new InterfaceGazEventDetails(selectedEvent);
		}
		
		if(e.getActionCommand().equals("details") && rad.isSelected()) {
			boutonTraiter.setVisible(true);
			int selectedEventIndex = listeRadiation.getSelectedIndex();
			RadiationEvent selectedEvent = listeRadiationEvent.get(selectedEventIndex);
			checkedRadiationEvent.add(selectedEvent);
			interfaceRadiation = new InterfaceRadiationEventDetails(selectedEvent);
		}
		
		if(e.getActionCommand().equals("traiter") && inc.isSelected()) {
			int selectedEventIndex = listeIncendie.getSelectedIndex();
			IncendieEvent selectedEvent = listeIncendieEvent.get(selectedEventIndex);
			this.getInterfaceMain().getMoniteurA().getListeEventIncendie().remove(selectedEvent);
			panelEventIncendie.removeAll();
			this.remove(panelEventIncendie);
			System.out.println("Evénement traité");
			this.afficheListeIncendieEvent();
			if(interfaceIncendie.isVisible()) {
				interfaceIncendie.setVisible(false);
				interfaceIncendie.dispose();
			}
		}
		
		if(e.getActionCommand().equals("traiter") && ga.isSelected()) {
			int selectedEventIndex = listeGaz.getSelectedIndex();
			GazEvent selectedEvent = listeGazEvent.get(selectedEventIndex);
			this.getInterfaceMain().getMoniteurA().getListeEventGaz().remove(selectedEvent);
			this.getInterfaceMain().getMoniteurB().getListeEventGaz().remove(selectedEvent);
			panelEventGaz.removeAll();
			this.remove(panelEventGaz);
			System.out.println("Evénement traité");
			this.afficheListeGazEvent();
			if(interfaceGaz.isVisible()) {
				interfaceGaz.setVisible(false);
				interfaceGaz.dispose();
			}
		}
		
		if(e.getActionCommand().equals("traiter") && rad.isSelected()) {
			int selectedEventIndex = listeRadiation.getSelectedIndex();
			RadiationEvent selectedEvent = listeRadiationEvent.get(selectedEventIndex);
			this.getInterfaceMain().getMoniteurB().getListeEventRadiation().remove(selectedEvent);
			panelEventRadiation.removeAll();
			this.remove(panelEventRadiation);
			System.out.println("Evénement traité");
			this.afficheListeRadiationEvent();
			if(interfaceRadiation.isVisible()) {
				interfaceRadiation.setVisible(false);
				interfaceRadiation.dispose();
			}
		}
		
		if(inc.isSelected()) {
			panelEventIncendie.setVisible(true);
			panelEventGaz.setVisible(false);
			panelEventRadiation.setVisible(false);
			if(labelEventIncendie.getText() == "Sélectionnez un événement") {
				boutonDetails.setVisible(true);
			}
			else {
				boutonDetails.setVisible(false);
				boutonTraiter.setVisible(false);
			}
		}
		
		if(ga.isSelected()) {
			panelEventIncendie.setVisible(false);
			panelEventGaz.setVisible(true);
			panelEventRadiation.setVisible(false);
			if(labelEventGaz.getText() == "Sélectionnez un événement") {
				boutonDetails.setVisible(true);
			}
			else {
				boutonDetails.setVisible(false);
				boutonTraiter.setVisible(false);
			}
		}
		 
		if(rad.isSelected()) {
			panelEventIncendie.setVisible(false);
			panelEventGaz.setVisible(false);
			panelEventRadiation.setVisible(true);
			if(labelEventRadiation.getText() == "Sélectionnez un événement") {
				boutonDetails.setVisible(true);
			}
			else {
				boutonDetails.setVisible(false);
				boutonTraiter.setVisible(false);
			}
		}
	}
	
	public MainInterface getInterfaceMain() {
		return interfaceMain;
	}
	
	public void afficheListeIncendieEvent() {
		if (this.getInterfaceMain().getMoniteurA().getListeEventIncendie().isEmpty() == false) {
			
	    	listeIncendieEvent = this.getInterfaceMain().getMoniteurA().getListeEventIncendie();
	    	ArrayList<String> nomDateListe = new ArrayList<String>();
	    	for (IncendieEvent i : listeIncendieEvent) {
	    		nomDateListe.add("Incendie du "+i.date);
	    	}
	    	System.out.println(listeIncendieEvent);
	    	String[] incendieEvent = nomDateListe.stream().toArray(String[]::new);
	    	listeIncendie = new JComboBox<String>(incendieEvent);
	    	listeIncendie.setSelectedIndex(0);
	    	listeIncendie.addActionListener(this);
	    	labelEventIncendie = new JLabel("Sélectionnez un événement");
	    	panelEventIncendie = new JPanel();
	    	panelEventIncendie.add(labelEventIncendie);
	    	panelEventIncendie.add(listeIncendie);
	    	panelEventIncendie.setBounds(0,110,450,50);
	    	panelEventIncendie.setVisible(false);
	    	this.add(panelEventIncendie);

	    }
		 else {
			 System.out.println("ça passe");
			labelEventIncendie = new JLabel("Aucun événement existant");
			panelEventIncendie = new JPanel();
			panelEventIncendie.add(labelEventIncendie);
			panelEventIncendie.setBounds(0,110,200,20);
			panelEventIncendie.setVisible(false);
			this.add(panelEventIncendie);
		 }
	}
	
	public void afficheListeGazEvent() {
		if (this.getInterfaceMain().getMoniteurA().getListeEventGaz().isEmpty() == false) {
			
	    	listeGazEvent = this.getInterfaceMain().getMoniteurA().getListeEventGaz();
	    	ArrayList<String> nomDateListe = new ArrayList<String>();
	    	for (GazEvent i : listeGazEvent) {
	    		nomDateListe.add("Fuite de gaz du "+i.date);
	    	}
	    	System.out.println(listeGazEvent);
	    	String[] gazEvent = nomDateListe.stream().toArray(String[]::new);
	    	listeGaz = new JComboBox<String>(gazEvent);
	    	listeGaz.setSelectedIndex(0);
	    	listeGaz.addActionListener(this);
	    	labelEventGaz = new JLabel("Sélectionnez un événement");
	    	panelEventGaz = new JPanel();
	    	panelEventGaz.add(labelEventGaz);
	    	panelEventGaz.add(listeGaz);
	    	panelEventGaz.setBounds(0,110,450,50);
	    	panelEventGaz.setVisible(false);
	    	this.add(panelEventGaz);

	    }
		 else {
			 System.out.println("ça passe");
			labelEventGaz = new JLabel("Aucun événement existant");
			panelEventGaz = new JPanel();
			panelEventGaz.add(labelEventGaz);
			panelEventGaz.setBounds(0,110,200,20);
			panelEventGaz.setVisible(false);
			this.add(panelEventGaz);
		 }
	}
	
	public void afficheListeRadiationEvent() {
		if (this.getInterfaceMain().getMoniteurB().getListeEventRadiation().isEmpty() == false) {
			
	    	listeRadiationEvent = this.getInterfaceMain().getMoniteurB().getListeEventRadiation();
	    	ArrayList<String> nomDateListe = new ArrayList<String>();
	    	for (RadiationEvent i : listeRadiationEvent) {
	    		nomDateListe.add("Radiation du "+i.date);
	    	}
	    	System.out.println(listeRadiationEvent);
	    	String[] radiationEvent = nomDateListe.stream().toArray(String[]::new);
	    	listeRadiation = new JComboBox<String>(radiationEvent);
	    	listeRadiation.setSelectedIndex(0);
	    	listeRadiation.addActionListener(this);
	    	labelEventRadiation = new JLabel("Sélectionnez un événement");
	    	panelEventRadiation = new JPanel();
	    	panelEventRadiation.add(labelEventRadiation);
	    	panelEventRadiation.add(listeRadiation);
	    	panelEventRadiation.setBounds(0,110,450,50);
	    	panelEventRadiation.setVisible(false);
	    	this.add(panelEventRadiation);

	    }
		 else {
			 System.out.println("ça passe");
			labelEventRadiation = new JLabel("Aucun événement existant");
			panelEventRadiation = new JPanel();
			panelEventRadiation.add(labelEventRadiation);
			panelEventRadiation.setBounds(0,110,200,20);
			panelEventRadiation.setVisible(false);
			this.add(panelEventRadiation);
		 }
	}

}
