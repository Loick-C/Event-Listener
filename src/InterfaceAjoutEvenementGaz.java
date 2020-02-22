import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceAjoutEvenementGaz extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	CapteurGaz capteur;
	String date;
	String niveau;
	String gazType;
	MainInterface interfaceMain;
	
	public InterfaceAjoutEvenementGaz(CapteurGaz capteur, String date, String niveau, String gazType, MainInterface interfaceMain) {

		super(); 
		this.capteur=capteur;
		this.date=date;
		this.niveau=niveau;
		this.gazType=gazType;
		
		this.setSize(850, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		JPanel mainPhrase = new JPanel();
		JLabel ajouterEvenement = new JLabel("Voulez vous vraiment créer l'évenement de type Gaz "+gazType+" qui a lieu à "+capteur.lieu+" le "+date+" ayant un niveau d'importance de "+niveau+" ?");
		mainPhrase.add(ajouterEvenement);
		mainPhrase.setBounds(0,0,850,25);
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
			GazEvent eventGaz = new GazEvent(this.getCapteur(),this.getCapteur().lieu, this.getDate(), this.getNiveau(),this.getGazType());
			this.getCapteur().generateGazEvent(this.getCapteur().lieu, this.getDate(), this.getNiveau(),this.getGazType());
			this.dispose();
		}
		if (e.getActionCommand().equals("refuser")) {
			this.dispose();
		}
	}

	public CapteurGaz getCapteur() {
		return capteur;
	}

	public String getDate() {
		return date;
	}

	public String getNiveau() {
		return niveau;
	}

	public String getGazType() {
		return gazType;
	}
	

}
