package com.ECFObjet.vues;

import com.ECFObjet.entites.*;
import com.ECFObjet.entites.GestionnaireClient;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private ClasseSociete classeSociete;

    public CreaModif(TypeSociete typeSociete) {
        this.typeSociete = typeSociete;
        initcomponent();
        addListeners();
    }

    public CreaModif(ClasseSociete classeSociete, TypeCRUD typeCRUD, TypeSociete typeSociete, MajTable majTable) {
        this.typeCRUD = typeCRUD;
        this.typeSociete = typeSociete;
        this.majTable = majTable;
        this.classeSociete = classeSociete;
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
        teletxt.setText(classeSociete.getTelephone());

        if (classeSociete instanceof ClasseClient) {
            ClasseClient classeClient = (ClasseClient) classeSociete;
            affairetxt.setText(String.valueOf(classeClient.getChiffreAffaires()));
            employestxt.setText(String.valueOf(classeClient.getNombreEmployes()));
        }
        if (classeSociete instanceof ClasseProspect) {
            ClasseProspect classeProspect = (ClasseProspect) classeSociete;
            prospectiontxt.setText(classeProspect.getDateProspection());
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
        } else if (typeSociete == TypeSociete.PROSPECT) {
            affairetxt.setVisible(false);
            employestxt.setVisible(false);
            chiffreaffaire.setVisible(false);
            nbmemployes.setVisible(false);
        }
    }

    private void addListeners() {
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

                if (raisonsociale.isEmpty() || nomrue.isEmpty() || codepostal.isEmpty() || ville.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Veuillez remplir les champs obligatoires");
                    return;
                }


                if (typeCRUD == TypeCRUD.CREATE) {
                    switch (typeSociete) {
                        case CLIENT -> {
                            long chiffreAffaire = Long.parseLong(affairetxt.getText().trim());
                            int nmemployes = Integer.parseInt(employestxt.getText());
                            ClasseClient nouveauClient = new ClasseClient(raisonsociale, adresse, tel, mail, chiffreAffaire, nmemployes, comment);
                            GestionnaireClient.ajoutClient(nouveauClient);
                            JOptionPane.showMessageDialog(null, "Client ajouté");
                        }
                        case PROSPECT -> {
                            String datepro = prospectiontxt.getText();
                            boolean interet = getBooleanInteret(interetbox);
                            ClasseProspect nouveauProspect = new ClasseProspect(raisonsociale, adresse, tel, mail, datepro, interet, comment);
                            GestionnaireProspect.ajoutProspect(nouveauProspect);
                            JOptionPane.showMessageDialog(null, "Prospect ajouté");
                        }
                        default -> JOptionPane.showMessageDialog(null, "Type de société inconnu !");
                    }
                }
                else if (typeCRUD == TypeCRUD.UPDATE) {
                    switch (typeSociete) {
                        case CLIENT -> {
                            ClasseClient client = (ClasseClient) classeSociete;
                            client.setRaisonSociale(raisonsociale);
                            client.setAdresse(adresse);
                            client.setTelephone(tel);
                            client.setEmail(mail);
                            client.setCommentaire(comment);
                            client.setChiffreAffaires(Long.parseLong(affairetxt.getText().trim()));
                            client.setNombreEmployes(Integer.parseInt(employestxt.getText()));
                        }
                        case PROSPECT -> {
                            ClasseProspect prospect = (ClasseProspect) classeSociete;
                            prospect.setRaisonSociale(raisonsociale);
                            prospect.setAdresse(adresse);
                            prospect.setTelephone(tel);
                            prospect.setEmail(mail);
                            prospect.setCommentaire(comment);
                            prospect.setDateProspection(prospectiontxt.getText());
                            prospect.setEstInteresse(interetbox.getSelectedItem().equals("Oui"));
                        }
                    }

                }

                if (majTable != null) {
                    majTable.majTable();
                }
                dispose();
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

    private void onCancel() {
        dispose();
    }
}
