
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceAjoutEvenementIncendie extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	CapteurIncendie capteur;
	String date;
	String niveau;
	MainInterface interfaceMain;
	
	public InterfaceAjoutEvenementIncendie(CapteurIncendie capteur, String date, String niveau, MainInterface interfaceMain) {
		super(); 
		this.interfaceMain=interfaceMain;
		this.capteur=capteur;
		this.date=date;
		this.niveau=niveau;
		
		this.setSize(850, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		JPanel mainPhrase = new JPanel();
		JLabel ajouterEvenement = new JLabel("Voulez vous vraiment créer l'évenement de type Incendie qui a lieu à "+capteur.lieu+" le "+date+" ayant un niveau d'importance de "+niveau+" ?");
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
			this.getCapteur().generateIncendieEvent(this.getCapteur().lieu, this.getDate(), this.getNiveau());
			System.out.println(this.getInterfaceMain().getMoniteurA().getListeEventIncendie());
			//this.getInterfaceMain().getMoniteurA().addIncendieEvent(eventIncendie);
			this.dispose();
		}
		if (e.getActionCommand().equals("refuser")) {
			this.dispose();
		}
		
	}

	public CapteurIncendie getCapteur() {
		return capteur;
	}

	public String getDate() {
		return date;
	}

	public String getNiveau() {
		return niveau;
	}

	public MainInterface getInterfaceMain() {
		return interfaceMain;
	}
	
	

}
