package ui;

import data.Kunde;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bearbeitenKundeUI {
    private JPanel panel;
    private JTextField tfKundenummer;
    private JTextField tfVorname;
    private JTextField tfNachname;
    private JTextField tfAdresse;
    private JTextField tfTelNummer;
    private JButton btnSpeichern;

    public bearbeitenKundeUI(datenbank db, Kunde kunde) {
        JFrame frame = new JFrame("bearbeitenKunde");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        tfKundenummer.setText(String.valueOf(kunde.getkundennummer()));
        tfVorname.setText(kunde.getVorname());
        tfNachname.setText(kunde.getNachname());
        tfAdresse.setText(kunde.getAdresse());


        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kunde.setkundennummer(Integer.parseInt(tfKundenummer.getText()));
                kunde.setVorname(tfVorname.getText());
                kunde.setNachname(tfNachname.getText());
                kunde.setAdresse(tfAdresse.getText());
                String[] nummern = tfTelNummer.getText().split(",");
                for(String ele : nummern){
                    kunde.addTelefonnummer(ele);
                }
                db.update(kunde);
            }
        });
    }
}

