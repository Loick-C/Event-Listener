import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfaceGazEventDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public InterfaceGazEventDetails(GazEvent event) {
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
	
		
		JPanel infoGazEvent = new JPanel();
		JTextArea labelArea = new JTextArea("Détails de l'événement de type Gaz\nDate : "+event.date+"\nLieu : "+event.localisation+"\nType de Gaz : "+event.typeGaz+"\nNiveau d'importance : "+event.nivImp);
		labelArea.setEditable(false);
		labelArea.setOpaque(false);
		infoGazEvent.add(labelArea);
		infoGazEvent.setBounds(0,0,300,300);
		this.add(infoGazEvent);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}