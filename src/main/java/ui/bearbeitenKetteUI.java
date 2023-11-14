package ui;

import data.Kette;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import db.*;
import jakarta.persistence.criteria.CriteriaBuilder;

public class bearbeitenKetteUI {
    private JPanel panel;
    private JButton speichernButton;
    private JTextField tfnummer;
    private JTextField tfpreis;
    private JTextField tfmodell;

    public bearbeitenKetteUI(datenbank db, Kette kette) {
        JFrame frame = new JFrame("bearbeitenKetteUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        tfpreis.setText(String.valueOf(kette.getprice()));
        tfnummer.setText(String.valueOf(kette.getproduktNummer()));
        tfmodell.setText(kette.getmodel());

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kette.setproduktNummer(Integer.parseInt(tfnummer.getText()));
                kette.setmodel(tfmodell.getText());
                kette.setprice(Integer.parseInt(tfpreis.getText()));
                db.update(kette);
            }
        });
    }

}
