package ui;

import data.Kunde;
import data.Warenkorb;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class einfügenKundeUI {
    private JTextField tfKundenummer;
    private JTextField tfVorname;
    private JTextField tfNachname;
    private JTextField tfAdresse;
    private JTextField tfTelNummer;
    private JButton btnSpeichern;
    private JPanel panel;

    public einfügenKundeUI(datenbank db) {
        JFrame frame = new JFrame("einfügenKunde");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kunde neu = new Kunde(Integer.parseInt(tfKundenummer.getText()),tfVorname.getText(),tfNachname.getText(),tfAdresse.getText());
                neu.setWarenkorb();
                String[] nummern = tfTelNummer.getText().split(",");
                for(String ele : nummern){
                    neu.addTelefonnummer(ele);
                }
                db.einfügen(neu);
            }
        });
    }
}

