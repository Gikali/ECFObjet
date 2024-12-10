package com.ECFObjet.vues;

import javax.swing.*;
import java.awt.event.*;

public class CreaModif extends JFrame {
    private JPanel contentPane;
    private JTextField raisonsocialetxt;
    private JTextField numeroruetxt;
    private JTextField nomruetxt;
    private JTextField codepostaltxt;
    private JTextField villetxt;
    private JTextField teletxt;
    private JTextField mailtxt;
    private JTextField affairetxt;
    private JTextField employestxt;
    private JTextField prospectiontxt;
    private JButton accueilButton;
    private JButton validerButton;
    private JButton quitterButton;
    private JTextField commentaire;
    private JLabel raisonsociale;
    private JLabel numérorue;
    private JLabel nomrue;
    private JLabel codepostal;
    private JLabel ville;
    private JLabel tel;
    private JLabel mail;
    private JLabel chiffreaffaire;
    private JLabel nbmemployes;
    private JLabel dateprospection;
    private JLabel interet;
    private JComboBox interetbox;

    public CreaModif() {
       initcomponent();
       addListeners();


    }

    private void initcomponent() {
        setContentPane(contentPane);
        setSize(500,500);

    }

    private void addListeners() {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
