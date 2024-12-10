package com.ECFObjet.vues;

import javax.swing.*;
import java.awt.event.*;

public class Liste extends JFrame {
    private JPanel contentPane;
    private JTable table1;
    private JButton Quitter;
    private JButton Accueil;
    private JButton buttonCancel;

    public Liste() {

        initComponents();
        addListeners();


    }

    private void initComponents() {
        setContentPane(contentPane);
        setSize(500, 500);

    }

    private void addListeners() {
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
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
