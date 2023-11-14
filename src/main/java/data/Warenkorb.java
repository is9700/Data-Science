
package data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity(name="Warenkorb")

public class Warenkorb implements Serializable{

	private static final long serialVersionUID = -5539273614141L;
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Schmuck> inhalt = new ArrayList<>();

    public Warenkorb() {

    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Schmuck> getArtikel() {
        return inhalt;
    }

    public void addArtikel(Schmuck artikel) {
        inhalt.add(artikel);
    }

    public double gessamtPreis(){
        double gesamt = 0.0;
        for(Schmuck ele : inhalt){
            gesamt += ele.getprice();
        }
        return gesamt;
    }

    @Override
    public String toString() {
        String schmuck = gibArtikel();
        return "Warenkorb{" +
                "id=" + id +
                ", kunde=" + kunde.getkundennummer() +
                ", artikel='" + schmuck + '\'' +
                '}';
    }
    private String gibArtikel(){
        String artikel = "";

        for(Schmuck ele : inhalt){
            artikel += ele.toString()+",";
        }
        return artikel;
    }
}
