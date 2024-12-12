package com.ECFObjet.vues;

import com.ECFObjet.entites.TypeSociete;
import com.ECFObjet.entites.*;
import com.ECFObjet.entites.GestionnaireClient;
import com.ECFObjet.vues.*;
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
    private JTextField villetxt;
    private JTextField codepostaltxt;
    private JLabel nomrue;
    private JLabel codepostal;
    private JLabel ville;
    private TypeSociete typeSociete;
    private TypeCRUD typeCRUD;
    private MajTable majTable;

    public CreaModif(TypeSociete typeSociete) {
        this.typeSociete = typeSociete;
        initcomponent();
        addListeners();



    }

    public CreaModif(ClasseSociete classeSociete,TypeCRUD typeCRUD, TypeSociete typeSociete, MajTable majTable) {

        this.typeCRUD = typeCRUD;
        this.typeSociete = typeSociete;
        this.majTable = majTable;
        initcomponent();
        addListeners();
        raisonsocialetxt.setText(classeSociete.getRaisonSociale());
        String adresseString = classeSociete.getAdresse();
        String[] adressesPart = adresseString.split(",");

        numeroruetxt.setText(adressesPart[0].trim());
        nomruetxt.setText(adressesPart[1].trim());
        codepostaltxt.setText(adressesPart[2].trim());
        villetxt.setText(adressesPart[3].trim());
        mailtxt.setText(classeSociete.getEmail());
        commentaire.setText(classeSociete.getCommentaire());
        teletxt.setText(classeSociete.getTelephone().toString());

        if (classeSociete instanceof ClasseClient ) {
           ClasseClient classeClient = (ClasseClient) classeSociete;
           affairetxt.setText(String.valueOf(classeClient.getChiffreAffaires()));
           employestxt.setText((String.valueOf(classeClient.getNombreEmployes())));

        }
        if (classeSociete instanceof ClasseProspect ) {
            ClasseProspect classeProspect = (ClasseProspect) classeSociete;
            prospectiontxt.setText(String.valueOf(classeProspect.getDateProspection()));
            interetbox.setSelectedItem(classeProspect.getEstInteresse() ? "Oui" : "Non");
        }
    }

    private void initcomponent() {
        setContentPane(contentPane);
        setSize(500, 500);
        remplirindex(interetbox);
        if (typeSociete == TypeSociete.CLIENT) {
            prospectiontxt.setVisible(false);
            dateprospection.setVisible(false);
            interetbox.setVisible(false);
            interet.setVisible(false);
            typeSociete = TypeSociete.CLIENT;
        } else if (typeSociete == TypeSociete.PROSPECT) {
            affairetxt.setVisible(false);
            employestxt.setVisible(false);
            chiffreaffaire.setVisible(false);
            nbmemployes.setVisible(false);
            typeSociete = TypeSociete.PROSPECT;
        }
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
                int numerorue = Integer.parseInt(numeroruetxt.getText());
                String nomrue = nomruetxt.getText();
                String codepostal = codepostaltxt.getText();
                String ville = villetxt.getText();
                String tel = teletxt.getText();
                String mail = mailtxt.getText();
                String comment = commentaire.getText();
                ClasseAdresse adresse = new ClasseAdresse(numerorue, nomrue, codepostal, ville);
                ClasseClient nouveauClient;
                ClasseProspect nouveauProspect;

                if (raisonsociale.isEmpty() || nomrue.isEmpty() || codepostal.isEmpty() || ville.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "veuillez remplir les champs obligatoires");
                    return;
                }
                if (typeSociete == TypeSociete.CLIENT) {
                    long chiffreAffaire = Long.parseLong(affairetxt.getText().trim());
                    int nmemployes = Integer.parseInt(employestxt.getText());
                    nouveauClient = new ClasseClient(raisonsociale, adresse, tel, mail, chiffreAffaire, nmemployes, comment);
                    GestionnaireClient.ajoutClient(nouveauClient);
                    JOptionPane.showMessageDialog(null, "Client ajouté");

                }

                else if (typeSociete == TypeSociete.PROSPECT) {
                    String datepro = prospectiontxt.getText();
                    boolean interet = getBooleanInteret(interetbox);
                    nouveauProspect = new ClasseProspect(raisonsociale,adresse,tel,mail,datepro,interet,comment);
                    GestionnaireProspect.ajoutProspect(nouveauProspect);
                    JOptionPane.showMessageDialog(null,"Prospect ajouté");

                }
                else { JOptionPane.showMessageDialog(null, "SOciété nulle");
                }

                if (majTable != null) {
                    majTable.majTable();
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

        interetbox.addItem("oui");
        interetbox.addItem("non");
        interetbox.setSelectedIndex(0);
    }

    private boolean getBooleanInteret(JComboBox<String> interetbox) {
        String interet = (String) interetbox.getSelectedItem();
        return "oui".equalsIgnoreCase(interet);
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
