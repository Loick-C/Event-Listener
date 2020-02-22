import java.util.ArrayList;

public class CapteurRadiation {
	ArrayList<RadiationListener> ecouteursRadiation = new ArrayList<RadiationListener>();
	String nom;
	String lieu;
	
	public CapteurRadiation(String nom,String lieu) {
		this.nom=nom;
		this.lieu=lieu;
		this.ecouteursRadiation=new ArrayList<RadiationListener>();
	}
	
	public void addRadiationListener(RadiationListener rL) {
		ecouteursRadiation.add(rL);
	}
	
	public void generateRadiationEvent(String loc,String date,String niv ,int nivR) {
		RadiationEvent e = new RadiationEvent(this,loc,date,niv,nivR);
		for(RadiationListener rL : ecouteursRadiation) {
			rL.changeRadiationEvent(e);
		}
	}
}
