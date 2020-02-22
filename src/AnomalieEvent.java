import java.util.EventObject;

@SuppressWarnings("serial")
public class AnomalieEvent extends EventObject {
	String localisation;
	String date;
	String nivImp;
	
	
	public String getLocalisation() {
		return localisation;
	}


	public String getDate() {
		return date;
	}


	public String getNivImp() {
		return nivImp;
	}


	public AnomalieEvent(Object source,String loc,String date,String niv) {
		super(source);
		this.localisation = loc;
		this.date = date;
		this.nivImp=niv;
	}
}
