package data;

import jakarta.persistence.Entity;

@Entity(name = "Ring")
public class Ring extends Schmuck {


private String groesse;
private String material; 


public Ring(int price, int produktNummer, String groesse,String material ) {
	super(price,produktNummer);
    this.groesse = groesse;
    this.material= material;
}

	public Ring() {

	}

	public String groesse() {
	return groesse;
}

public void groesse(String groesse) {
	this.groesse = groesse;
}

public String material() {
	return material;
}

public void material(String material) {
	this.material = material;
}

	@Override
	public String toString() {
		return super.toString()+
				"groesse='" + groesse + '\'' +
				", material='" + material + '\'';
	}
}
