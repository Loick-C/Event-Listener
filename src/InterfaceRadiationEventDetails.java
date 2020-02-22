import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfaceRadiationEventDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public InterfaceRadiationEventDetails(RadiationEvent event) {
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
	
		
		JPanel infoRadiationEvent = new JPanel();
		JTextArea labelArea = new JTextArea("Détails de l'événement de type Radiation\nDate : "+event.date+"\nLieu : "+event.localisation+"\nTaux de radiation : "+event.niveauRadiation+"%\nNiveau d'importance : "+event.nivImp);
		labelArea.setEditable(false);
		labelArea.setOpaque(false);
		infoRadiationEvent.add(labelArea);
		infoRadiationEvent.setBounds(0,0,300,300);
		this.add(infoRadiationEvent);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}