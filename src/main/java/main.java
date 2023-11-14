import data.*;
import db.datenbank;
import ui.*;

public class main {
    private static datenbank db = new datenbank();
    public static void main(String[] args) {
        startUI startUI = new startUI(db);
        muster();
    }
    public static void muster(){
        Kette kette = new Kette(50,254,"Rund");
        db.einfügen(kette);

        Ring ring = new Ring(75,643,"10","Gold");
        db.einfügen(ring);

        Uhr uhr = new Uhr(365,864,"PR100");
        db.einfügen(uhr);

        Kunde testKunde = new Kunde(1,"Peter","Müller","Hauptstarße 1");
        testKunde.addTelefonnummer("02319252140");
        testKunde.addTelefonnummer("54646546546");
        db.einfügen(testKunde);


    }
}
