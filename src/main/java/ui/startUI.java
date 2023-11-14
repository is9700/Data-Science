package ui;
import db.datenbank;
import data.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startUI {

    private JList list;
    private JButton btn_tabAnz;
    private JPanel panel;
    private JTextField tf_tabelle;
    private JButton btn_bearbeiten;
    private JButton btn_loeschen;
    private JButton btnKundeEinfügen;
    private JScrollPane scrollPane;
    private JButton btneinfügenKette;
    private JButton btnRingeinfügen;
    private JButton btnUhreinfügen;
    private JButton artikelZumWarenkorbButton;
    private DefaultListModel dm = new DefaultListModel<>();

    public startUI(datenbank db) {
        JFrame frame = new JFrame("startUI");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Datenbank Testprogramm");
        frame.setLocationRelativeTo(null);
        frame.setSize(800,400);
        frame.pack();
        frame.setVisible(true);
        list.setModel(dm);

        btn_tabAnz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kunde kunde = new Kunde();
                dm.removeAllElements();
                dm.addAll(db.tabelleAbrufen(tf_tabelle.getText()));
            }
        });


        btn_bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object kandidat = list.getSelectedValue();
                if (Kette.class.equals(kandidat.getClass())) {
                    bearbeitenKetteUI bearbeitenKetteUI = new bearbeitenKetteUI(db, (Kette) kandidat);
                } else if (Kunde.class.equals(kandidat.getClass())) {
                    bearbeitenKundeUI bearbeitenKundeUI = new bearbeitenKundeUI(db, (Kunde) kandidat);
                }
                else if(Ring.class.equals(kandidat.getClass())){
                    bearbeitenRingUI bearbeitenRingUI = new bearbeitenRingUI(db,(Ring) kandidat);
                }
                else if(Uhr.class.equals(kandidat.getClass())){
                    bearbeitenUhrUI bearbeitenUhrUI  = new bearbeitenUhrUI(db,(Uhr) kandidat);
                }
            }
        });
        btn_loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.remove(list.getSelectedValue());
            }
        });
        btnKundeEinfügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfügenKundeUI einfügenKundeUI = new einfügenKundeUI(db);
            }
        });
        btneinfügenKette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfügenKetteUI einfügenKetteUI = new einfügenKetteUI(db);
            }
        });
        btnRingeinfügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfügenRingUI einfügenRingUI = new einfügenRingUI(db);
            }
        });
        btnUhreinfügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfügenUhrUI einfügenUhrUI = new einfügenUhrUI(db);
            }
        });
        artikelZumWarenkorbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfügenWarenkorbUI einfügenWarenkorbUI = new einfügenWarenkorbUI(db, (Kunde) list.getSelectedValue());
            }
        });
    }
}
