import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfaceIncendieEventDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public InterfaceIncendieEventDetails(IncendieEvent event) {
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
	
		
		JPanel infoIncendieEvent = new JPanel();
		JTextArea labelArea = new JTextArea("Détails de l'événement de type Incendie\nDate : "+event.date+"\nLieu : "+event.localisation+"\nNiveau d'importance : "+event.nivImp);
		labelArea.setEditable(false);
		labelArea.setOpaque(false);
		infoIncendieEvent.add(labelArea);
		infoIncendieEvent.setBounds(0,0,300,300);
		this.add(infoIncendieEvent);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
