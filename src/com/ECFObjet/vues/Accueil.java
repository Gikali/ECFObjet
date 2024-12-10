package com.ECFObjet.vues;

import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame {
    private JPanel contentPane;
    private JButton Client;
    private JButton Prospect;
    private JButton Création;
    private JButton Affichage;
    private JButton Suppression;
    private JButton Modification;
    private JComboBox comboBox1;
    private JButton Valider;

    public Accueil() {
       initComponents();
       addListeners();


    }

    private void initComponents() {
        setContentPane(contentPane);
        setSize(500,500);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void addListeners() {

        Création.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        Modification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        Suppression.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        Affichage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        Client.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        Prospect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
