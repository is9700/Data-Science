package ui;

import data.Kunde;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class einfügenWarenkorbUI {
    private JPanel panel;
    private JButton btnSpeichern;
    private JTextField tfProdukt;
    private JTextField tfArt;

    public einfügenWarenkorbUI(datenbank db, Kunde kunde) {

        JFrame frame = new JFrame("einfügenWarenkorbUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kunde.getWarenkorb().addArtikel(db.schmuckAbrufen(Integer.parseInt(tfProdukt.getText()),tfArt.getText()));
            }
        });
    }
}
