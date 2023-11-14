package ui;

import data.Ring;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class einfügenRingUI {
    private JPanel panel;
    private JButton btnSpeichern;
    private JTextField tfNummer;
    private JTextField tfPreis;
    private JTextField tfGröße;
    private JTextField tfMaterial;

    public einfügenRingUI(datenbank db) {
        JFrame frame = new JFrame("einfügenRing");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ring neu = new Ring(Integer.parseInt(tfPreis.getText()),Integer.parseInt(tfNummer.getText()),tfGröße.getText(),tfMaterial.getText());
                db.einfügen(neu);
            }
        });
    }
}
