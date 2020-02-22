import java.util.ArrayList;

public class CapteurIncendie {
	
	ArrayList<IncendieListener> ecouteursIncendies;
	String nom;
	String lieu;
	
	public CapteurIncendie(String nom, String lieu) {
		this.nom=nom;
		this.lieu=lieu;
		this.ecouteursIncendies=new ArrayList<IncendieListener>();
	}
	
	public void addIncendieListener(IncendieListener iL) {
		ecouteursIncendies.add(iL);
	}
	
	public void generateIncendieEvent(String loc,String date,String niv) {
		IncendieEvent e = new IncendieEvent(this,loc,date,niv);
		for(IncendieListener iL : ecouteursIncendies) {
			iL.changeIncendieEvent(e);
		}
	}
}

