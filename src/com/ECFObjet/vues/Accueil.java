package com.ECFObjet.vues;

import com.ECFObjet.entites.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import static com.ECFObjet.entites.GestionnaireClient.getGestClient;
import static com.ECFObjet.entites.GestionnaireProspect.getGestProspect;

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
    private TypeSociete typeSociete;
    private TypeCRUD typeCRUD;
    private MajTable majTable;
    private ClasseSociete selecSociete;

    public Accueil() {
        initComponents();
        addListeners();


    }

    private void initComponents() {
        setContentPane(contentPane);
        setSize(500, 500);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void addListeners() {
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              selecSociete = (ClasseSociete) comboBox1.getSelectedItem();
            }


    });
        Création.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (typeSociete == null) {
                    JOptionPane.showMessageDialog(null, "veuillez choisir client ou prospect");
                    return;
                }
                if (typeSociete == TypeSociete.CLIENT) {
                    CreaModif creamodif = new CreaModif(TypeSociete.CLIENT);
                    creamodif.setVisible(true);
                } else if (typeSociete == TypeSociete.PROSPECT) {
                    CreaModif creamodif = new CreaModif(TypeSociete.PROSPECT);
                    creamodif.setVisible(true);
                }
            }
        });
        Modification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeCRUD = TypeCRUD.UPDATE;
                if (selecSociete == null) {
                    JOptionPane.showMessageDialog(null, "veuillez choisir une société");
                    return;
                }
                CreaModif creamodif = new CreaModif(selecSociete,typeCRUD,typeSociete,majTable);
                creamodif.setVisible(true);

            }
        });
        Suppression.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeCRUD = TypeCRUD.DELETE;

            }
        });
        Affichage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (typeSociete == null) {
                    JOptionPane.showMessageDialog(null, "veuillez choisir client ou prospect");
                    return;
                }
                if (typeSociete == TypeSociete.CLIENT) {
                    Liste liste = new Liste(TypeSociete.CLIENT);
                    liste.setVisible(true);
                } else if (typeSociete == TypeSociete.PROSPECT) {
                    Liste liste = new Liste(TypeSociete.PROSPECT);
                    liste.setVisible(true);

                }

            }
        });
        Client.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeSociete = TypeSociete.CLIENT;
                remplirComboBoxClient(comboBox1);
            }

        });
        Prospect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeSociete = TypeSociete.PROSPECT;
                remplirComboBoxProspect(comboBox1);
            }
        });


        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void remplirComboBoxClient(JComboBox<ClasseClient> comboBox1) {
        comboBox1.removeAllItems();
        for (ClasseClient client : getGestClient()) {

            comboBox1.addItem(client);
        }
    }

    public void remplirComboBoxProspect(JComboBox<ClasseProspect> comboBox1){
        comboBox1.removeAllItems();
        for (ClasseProspect prospect : getGestProspect()) {
            comboBox1.addItem(prospect);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
