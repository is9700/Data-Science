package ui;

import data.Ring;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bearbeitenRingUI {
    private JPanel panel;
    private JTextField tfNummer;
    private JTextField tfPreis;
    private JTextField tfGröße;
    private JTextField tfMaterial;
    private JButton btnSpeichern;

    public bearbeitenRingUI(datenbank db, Ring kandiat) {
        JFrame frame = new JFrame("bearbeitenRingUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        tfNummer.setText(String.valueOf(kandiat.getproduktNummer()));
        tfPreis.setText(String.valueOf(kandiat.getprice()));
        tfGröße.setText(String.valueOf(kandiat.groesse()));
        tfMaterial.setText(kandiat.material());


        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kandiat.setproduktNummer(Long.parseLong(tfNummer.getText()));
                kandiat.setprice(Integer.parseInt(tfPreis.getText()));
                kandiat.groesse(tfGröße.getText());
                kandiat.material(tfMaterial.getText());

                db.update(kandiat);
            }
        });
    }
}
