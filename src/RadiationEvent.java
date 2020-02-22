@SuppressWarnings("serial")
public class RadiationEvent extends AnomalieEvent {
	int niveauRadiation;
	
	
	
	public int getNiveauRadiation() {
		return niveauRadiation;
	}


	public RadiationEvent(Object source,String loc,String date,String niv ,int nivR) {
		super(source,loc,date,niv);
		this.niveauRadiation=nivR;
	}

}
