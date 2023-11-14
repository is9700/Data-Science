package data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Kunde")
/*
@SqlResultSetMapping(name="MappingZwischensumme",
entities=@EntityResult(entityClass=Kunde.class,
fields = {
		@FieldResult(name="schluessel", column="kundennummer"),
		@FieldResult(name="Telefonnummer", column="Telefonummer"),
		@FieldResult(name="Adresse", column="adresse")
		   }),
       columns = { @ColumnResult(name = "zwischensumme")})

 */
public class Kunde {
	  //Kunde Attribute
	  @Id  
	  @Column(name="kundennummer", nullable=false, updatable=false)  
	  private int kundennummer;

	
	  @Column(name="Adresse") 
	  private String adresse;

	  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	  private List<telefonnummer> telefonnummern = new ArrayList<>();

	  @Column
	  private String vorname;

	  @Column
	  private String nachname;
	  @OneToOne(mappedBy = "kunde",
			  cascade = CascadeType.ALL,
			  orphanRemoval = true,
			  fetch = FetchType.LAZY)
	  private Warenkorb warenkorb ;

	  private int anzNummern = 0;
	public Kunde(int kundennummer, String vorname, String nachname ,String adresse) {
		this.kundennummer = kundennummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		setWarenkorb();
	}
	public Kunde(){

	}

	public int getkundennummer(){
		 return kundennummer;
	  }

	  public void setkundennummer(int kundennummer) {
		  this.kundennummer = kundennummer;
	  }

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public 	Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb() {
        Warenkorb warenkorb = new Warenkorb();
		warenkorb.setKunde(this);
		this.warenkorb = warenkorb;
    }
	public void addTelefonnummer(String nummer){
		telefonnummern.add(new telefonnummer(anzNummern+kundennummer, nummer));
		anzNummern++;
	}

	@Override
	public String toString() {
		String nummern = telefon();
		return
				"kundennummer=" + kundennummer +
				", adresse='" + adresse + '\'' +
				", telefonnummern=" + nummern +
				", vorname='" + vorname + '\'' +
				", nachname='" + nachname + '\'' +
				", warenkorb=" + warenkorb;
	}
	private String telefon(){
		String nummern = "";
		for(telefonnummer ele : telefonnummern){
			nummern += ","+ele.getNummer();
		}

		return nummern;
	}
}
