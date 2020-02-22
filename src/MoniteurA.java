import java.util.ArrayList;

public class MoniteurA implements IncendieListener,GazListener {

	ArrayList<IncendieEvent> listeEventIncendie = new ArrayList<IncendieEvent>();
	ArrayList<GazEvent> listeEventGaz = new ArrayList<GazEvent>();
	
	@Override
	public void changeGazEvent(GazEvent e) {
		System.out.println("Anomalie de type gaz "+e.getTypeGaz()+" le "+e.getDate()+" à "+e.getLocalisation()+" avec une importance de "+e.getNivImp());
		this.addGazEvent(e);
	}

	@Override
	public void changeIncendieEvent(IncendieEvent e) {
		System.out.println("Anomalie de type incendie le "+e.getDate()+" à "+e.getLocalisation()+" avec une importance de "+e.getNivImp());
		this.addIncendieEvent(e);
		
	}

	public ArrayList<IncendieEvent> getListeEventIncendie() {
		return listeEventIncendie;
	}

	public ArrayList<GazEvent> getListeEventGaz() {
		return listeEventGaz;
	}
	
	public void addIncendieEvent(IncendieEvent event) {
		listeEventIncendie.add(event);
	}
	
	public void addGazEvent(GazEvent event) {
		listeEventGaz.add(event);
	}
}
