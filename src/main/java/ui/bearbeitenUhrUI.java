package ui;

import data.Uhr;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bearbeitenUhrUI {
    private JTextField tfNummer;
    private JTextField tfPreis;
    private JTextField tfModell;
    private JButton btnSpeichern;
    private JPanel panel;

    public bearbeitenUhrUI(datenbank db, Uhr kandidat) {
        JFrame frame = new JFrame("bearbeitenUhrUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        tfNummer.setText(String.valueOf(kandidat.getproduktNummer()));
        tfPreis.setText(String.valueOf(kandidat.getprice()));
        tfModell.setText(kandidat.getUhrModel());

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kandidat.setproduktNummer(Long.parseLong(tfNummer.getText()));
                kandidat.setprice(Integer.parseInt(tfPreis.getText()));
                kandidat.setUhrModel(tfModell.getText());

                db.update(kandidat);
            }
        });
    }
}
