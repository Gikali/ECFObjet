package com.ECFObjet.vues;

import com.ECFObjet.entites.TypeSociete;
import com.ECFObjet.entites.*;

import javax.swing.*;
import java.awt.event.*;

public class CreaModif extends JFrame {
    private JPanel contentPane;
    private JTextField raisonsocialetxt;
    private JTextField numeroruetxt;
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
    private JLabel numerorue;
    private JLabel tel;
    private JLabel mail;
    private JLabel chiffreaffaire;
    private JLabel nbmemployes;
    private JLabel dateprospection;
    private JLabel interet;
    private JComboBox interetbox;
    private JTextField nomruetxt;
    private JTextField codepostaltxt;
    private JTextField villetxt;
    private JLabel nomrue;
    private JLabel codepostal;
    private JLabel ville;
    private TypeSociete typeSociete;

    public CreaModif(TypeSociete typeSociete) {
        initcomponent();
        addListeners();
        if (typeSociete == TypeSociete.CLIENT) {
            prospectiontxt.setVisible(false);
            dateprospection.setVisible(false);
            interetbox.setVisible(false);
            interet.setVisible(false);
        } else if (typeSociete == TypeSociete.PROSPECT) {
            affairetxt.setVisible(false);
            employestxt.setVisible(false);
            chiffreaffaire.setVisible(false);
            nbmemployes.setVisible(false);
        }


    }

    private void initcomponent() {
        setContentPane(contentPane);
        setSize(500, 500);
        remplirindex(interetbox);
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

        validerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String raisonsociale = raisonsocialetxt.getText();
                ClasseAdresse adresse =  numeroruetxt.getText();
                String tel = teletxt.getText();
                String mail = mailtxt.getText();
                String comment = commentaire.getText();
                long chiffreAffaire = Long.parseLong(chiffreaffaire.getText());
                int nmemployes = Integer.parseInt(nbmemployes.getText());
                String datepro = dateprospection.getText();
                boolean interettrue = interetbox.getSelectedItem() == "oui";
                boolean interetfalse = interetbox.getSelectedItem() == "non";
                ClasseSociete nouvelSociete
                if (raisonsociale.isEmpty() || adresse.isEmpty() || tel.isEmpty() || mail.isEmpty() || comment.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "veuillez remplir les champs obligatoires");
                    return;
                }
                if (typeSociete == TypeSociete.CLIENT) {
                nouvelSociete = new ClasseClient(raisonsociale,adresse,tel,mail,chiffreAffaire,nmemployes,comment);
                }



            }
        });

        accueilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        quitterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int reponse = JOptionPane.showConfirmDialog(
                        null,
                        "Voulez-vous vraiment quitter l'application ?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (reponse == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void remplirindex(JComboBox interetbox) {
        String oui;
        String non;
        non = "non";
        oui = "oui";
       interetbox.addItem(oui);
       interetbox.addItem(non);

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
