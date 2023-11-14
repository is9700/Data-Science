package data;

import jakarta.persistence.Entity;

@Entity(name = "Uhr")
public class Uhr extends Schmuck {
	
	
	private String uhrModel;
	
	 public Uhr( int price,int produktNummer, String uhrModel) {
		 
		 super( price, produktNummer);
		 this.setUhrModel(uhrModel);
		 
	    }

	public Uhr() {

	}

	public String getUhrModel() {
		return uhrModel;
	}

	public void setUhrModel(String uhrModel) {
		this.uhrModel = uhrModel;
	}

	@Override
	public String toString() {
		return super.toString()+
				"uhrModel='" + uhrModel + '\'';
	}
}
