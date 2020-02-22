import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	MoniteurA moniteurA;
	MoniteurB moniteurB;
	ArrayList<CapteurIncendie> capteursIncendie;
	ArrayList<CapteurGaz> capteursGaz;
	ArrayList<CapteurRadiation> capteursRadiation;

	public MainInterface() {

		super("Main Window");

		this.moniteurA=new MoniteurA();
		this.moniteurB=new MoniteurB();
		this.capteursIncendie=new ArrayList<CapteurIncendie>();
		this.capteursGaz=new ArrayList<CapteurGaz>();
		this.capteursRadiation=new ArrayList<CapteurRadiation>();

		this.setTitle("Interface Main");
		this.setSize(400, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		JPanel fond = new JPanel();
		this.setContentPane(fond);

		JPanel boutonCapteur = new JPanel();
		JButton bc = new JButton("Ajouter un capteur");
		boutonCapteur.add(bc);
		this.add(boutonCapteur);

		JPanel boutonEvent = new JPanel();
		JButton be = new JButton("Générer un événement");
		boutonEvent.add(be);
		this.add(boutonEvent);

		bc.addActionListener(this);
		bc.setActionCommand("capteur");

		be.addActionListener(this);
		be.setActionCommand("event");

		JPanel boutonTest= new JPanel();
		JButton bt = new JButton("Moniteurs");
		boutonTest.add(bt);
		this.add(boutonTest);
		bt.addActionListener(this);
		bt.setActionCommand("Moniteurs");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("capteur")) {
			System.out.println("Switch vers interface capteur");
			this.setVisible(false);
			new InterfaceCapteur(this);
		}
		if (e.getActionCommand().equals("event")) {
			System.out.println("Switch vers interface event");
			this.setVisible(false);
			new Interface(this);
		}
		if (e.getActionCommand().equals("Moniteurs")) {
			this.setVisible(false);
			new InterfaceMoniteur(this);
		}
	}
	public MoniteurA getMoniteurA() {
		return moniteurA;
	}
	public MoniteurB getMoniteurB() {
		return moniteurB;
	}
	public ArrayList<CapteurIncendie> getCapteursIncendie() {
		return capteursIncendie;
	}
	public ArrayList<CapteurGaz> getCapteursGaz() {
		return capteursGaz;
	}
	public ArrayList<CapteurRadiation> getCapteursRadiation() {
		return capteursRadiation;
	}

}
