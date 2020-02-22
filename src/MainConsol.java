
public class MainConsol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoniteurA moniteur1 = new MoniteurA();
		MoniteurB moniteur2 = new MoniteurB();
		
		CapteurIncendie capteurincendie = new CapteurIncendie("1","Annecy");
		CapteurGaz capteurgaz = new CapteurGaz("2","grenoble");
		CapteurRadiation capteurradiation = new CapteurRadiation("2","paris");
		capteurgaz.addGazListener(moniteur1);
		capteurradiation.addRadiationListener(moniteur2);
		capteurincendie.addIncendieListener(moniteur1);
		
		//Frame myframe = new Frame();
		//myframe.setSize(500, 500);
		//myframe.setVisible(true);
		
		capteurgaz.generateGazEvent("polytech", "aujd", "1", "etzpezp");
		capteurgaz.generateGazEvent("polytech", "aujd", "1", "etzpezp");
		capteurgaz.generateGazEvent("polytech", "aujd", "1", "etzpezp");
		capteurradiation.generateRadiationEvent("c209", "hier", "4", 70);
		capteurincendie.generateIncendieEvent(capteurincendie.lieu, "44", "high");
		//new Interface();
	}

}
