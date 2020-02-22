import java.util.ArrayList;

public class CapteurGaz {
	
	ArrayList<GazListener> ecouteursGaz = new ArrayList<GazListener>();
	String nom;
	String lieu;
	
	public CapteurGaz(String nom,String lieu) {
		this.nom=nom;
		this.lieu=lieu;
		this.ecouteursGaz=new ArrayList<GazListener>();
	}
	
	public void addGazListener(GazListener gL) {
		ecouteursGaz.add(gL);
	}
	
	public void generateGazEvent(String loc,String date,String niv, String type) {
		GazEvent e = new GazEvent(this,loc,date,niv,type);
		for(GazListener iL : ecouteursGaz) {
			iL.changeGazEvent(e);
		}
	}
}