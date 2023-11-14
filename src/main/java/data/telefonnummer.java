package data;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name="telefonnummer")
public class telefonnummer {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nummer;

    public telefonnummer(int id,String nummer) {
       //this.id = id;
        this.nummer = nummer;
    }

    public telefonnummer() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return nummer;
    }
}
