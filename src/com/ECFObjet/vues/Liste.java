package com.ECFObjet.vues;
import com.ECFObjet.entites.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import static com.ECFObjet.entites.GestionnaireClient.getGestClient;
import static com.ECFObjet.entites.GestionnaireProspect.getGestProspect;


public class Liste extends JFrame {
    private JPanel contentPane;
    private JTable  table1;
    private JButton Quitter;
    private JButton Accueil;


    public Liste(TypeSociete typeSociete) {

        initComponents();
        addListeners();
        if (typeSociete == TypeSociete.CLIENT) {
            List<ClasseClient> gestClient = getGestClient();
            remplissageClient(new ArrayList<>(gestClient));
        }
        if (typeSociete == TypeSociete.PROSPECT) {
            List<ClasseProspect> gestProspect = getGestProspect();
            remplissageProspect(new ArrayList<>(gestProspect));
        }
    }

    private void initComponents() {
        setContentPane(contentPane);
        setSize(500, 500);

    }

    private void addListeners() {
        Accueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Quitter.addActionListener(new ActionListener() {
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

    private void remplissageClient(ArrayList<ClasseClient> gestClient) {
        DefaultTableModel modelTable;
        String[] entete = {"Raison Sociale", "Adresse", "Téléphone", "email", "Chiffre d'affaires", "Nombre d'employés", "Commentaire"};

        modelTable = new DefaultTableModel(new Object[][]{}, entete);

        for (ClasseClient client : gestClient) {
            modelTable.addRow(new Object[]{
               client.getRaisonSociale(),
                client.getAdresse(),
                    client.getTelephone(),
                    client.getEmail(),
                    client.getChiffreAffaires(),
                    client.getNombreEmployes(),
                    client.getCommentaire()

            });
            table1.setModel(modelTable);
        }
    }

    private void remplissageProspect(ArrayList<ClasseProspect> gestProspect) {
        DefaultTableModel modelTable;
        String[] entete = {"Raison Sociale", "Adresse", "Téléphone", "email", "Date de prospection", "Intêret", "Commentaire"};

        modelTable = new DefaultTableModel(new Object[][]{}, entete);

        for (ClasseProspect prospect : gestProspect) {
            modelTable.addRow(new Object[]{
                    prospect.getRaisonSociale(),
                    prospect.getAdresse(),
                    prospect.getTelephone(),
                    prospect.getEmail(),
                    prospect.getDateProspection(),
                    prospect.getEstInteresse(),
                    prospect.getCommentaire()
            });

        }
        table1.setModel(modelTable);
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
