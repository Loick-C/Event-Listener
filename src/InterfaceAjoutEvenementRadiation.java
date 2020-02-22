import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceAjoutEvenementRadiation extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	CapteurRadiation capteur;
	String date;
	String niveau;
	int niveauRadiation;
	MainInterface interfaceMain;
	
	public InterfaceAjoutEvenementRadiation(CapteurRadiation capteur, String date, String niveau, int niveauRadiation, MainInterface interfaceMain) {
		
		super(); 
		this.capteur=capteur;
		this.date=date;
		this.niveau=niveau;
		this.niveauRadiation=niveauRadiation;
		
		this.setSize(900, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		JPanel mainPhrase = new JPanel();
		JLabel ajouterEvenement = new JLabel("Voulez vous vraiment créer l'évenement de type Radiation de "+niveauRadiation+"%  qui a lieu à "+capteur.lieu+" le "+date+" ayant un niveau d'importance de "+niveau+" ?");
		mainPhrase.add(ajouterEvenement);
		mainPhrase.setBounds(5,0,875,25);
		this.add(mainPhrase);
		
		JPanel boutonValider = new JPanel();
		JButton bValider = new JButton("Oui");
		boutonValider.add(bValider);
		boutonValider.setBounds(40,50,100,100);
	    this.add(boutonValider);
	    bValider.addActionListener(this);
	    bValider.setActionCommand("valider");
	    
	    JPanel boutonRefuser = new JPanel();
		JButton bRefuser = new JButton("Non");
		boutonRefuser.add(bRefuser);
		boutonRefuser.setBounds(710,50,100,100);
	    this.add(boutonRefuser);
	    bRefuser.addActionListener(this);
	    bRefuser.setActionCommand("refuser");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("valider")) {
			this.getCapteur().generateRadiationEvent(this.getCapteur().lieu, this.getDate(), this.getNiveau(),this.getNiveauRadiation());
			this.dispose();
		}
		if (e.getActionCommand().equals("refuser")) {
			this.dispose();
		}
	}

	public CapteurRadiation getCapteur() {
		return capteur;
	}

	public String getDate() {
		return date;
	}

	public String getNiveau() {
		return niveau;
	}

	public int getNiveauRadiation() {
		return niveauRadiation;
	}
		
}
	

