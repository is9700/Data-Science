package data;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity(name = "Kette")
public class Kette extends Schmuck {
	
	
 private String model;
 
 public Kette (int price, int produktNummer,String model) {
	
		super(price,produktNummer);
        this.model=model; 
	 
 }

	public Kette() {

	}


	public String getmodel() {
		return model;
	}

 
	public void setmodel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return super.toString() +
				"model='" + model + '\'';
	}
}
