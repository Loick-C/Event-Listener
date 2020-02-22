import java.util.ArrayList;

public class MoniteurB implements RadiationListener,GazListener {
	
	ArrayList<RadiationEvent> listeEventRadiation = new ArrayList<RadiationEvent>();
	ArrayList<GazEvent> listeEventGaz = new ArrayList<GazEvent>();
	
	@Override
	public void changeGazEvent(GazEvent e) {
		System.out.println("Anomalie de type gaz "+e.getTypeGaz()+" le "+e.getDate()+" à "+e.getLocalisation()+" avec une importance de "+e.getNivImp());
		this.addGazEvent(e);
	}
	
	@Override
	public void changeRadiationEvent(RadiationEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Anomalie de type radiation de niveau "+e.getNiveauRadiation()+" le "+e.getDate()+" à "+e.getLocalisation()+" avec une importance de "+e.getNivImp());
		this.addRadiationEvent(e);
		
	}

	public ArrayList<RadiationEvent> getListeEventRadiation() {
		return listeEventRadiation;
	}
	
	public void addRadiationEvent(RadiationEvent event) {
		listeEventRadiation.add(event);
	}
	
	public ArrayList<GazEvent> getListeEventGaz() {
		return listeEventGaz;
	}
	
	public void addGazEvent(GazEvent event) {
		listeEventGaz.add(event);
	}
}
