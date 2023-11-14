package ui;

import data.Kette;
import db.datenbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class einfügenKetteUI {
    private JTextField tfNummer;
    private JTextField tfPreis;
    private JTextField tfModell;
    private JButton btnSpeichern;
    private JPanel panel;

    public einfügenKetteUI(datenbank db) {
        JFrame frame = new JFrame("einfügenKette");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kette neu = new Kette(Integer.parseInt(tfPreis.getText()),Integer.parseInt(tfNummer.getText()),tfModell.getText());
                db.einfügen(neu);
            }
        });
    }

}
