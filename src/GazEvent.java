@SuppressWarnings("serial")
public class GazEvent extends AnomalieEvent {
		String typeGaz;
	
	public String getTypeGaz() {
		return typeGaz;
	}

	
	public GazEvent(CapteurGaz source,String loc,String date,String niv, String type) {
		super (source,loc,date,niv);
		this.typeGaz=type;		
	}
}