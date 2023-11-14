package ui;

import data.Uhr;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class einfügenUhrUI {
    private JPanel panel;
    private JButton btnSpeichern;
    private JTextField tfNummer;
    private JTextField tfPreis;
    private JTextField tfModell;

    public einfügenUhrUI(datenbank db) {
        JFrame frame = new JFrame("einfügenUhr");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uhr neu = new Uhr(Integer.parseInt(tfPreis.getText()),Integer.parseInt(tfNummer.getText()),tfModell.getText());
                db.einfügen(neu);
            }
        });
    }
}
