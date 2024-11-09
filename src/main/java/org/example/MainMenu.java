package org.example;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import Panels.AddNewStudentPanel;
import Panels.RemoveStudentPanel;
import Panels.ViewAllStudentPanel;
import javax.swing.SwingUtilities;


    /**
     * @author Mashila Marcus
     */
    public class MainMenu extends javax.swing.JFrame {
        private JPanel centerPanel;
        private JList<String> activityList;
        private StudentManager studentManager;

        public MainMenu() {
            this.studentManager = new StudentManager();

            setTitle("Student Manager");// set  window title
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            String[] activities = {"Add new student", "Remove student", "View all students"};
            activityList = new JList<>(activities);
   //add selection Listener to the Activity list
           activityList.addListSelectionListener(new ListSelectionListener() {
                                                     @Override
                                                     public void valueChanged(ListSelectionEvent e) {
                                                         if(!e.getValueIsAdjusting()){
                                                             //get selected activity from list
                                                             String selectedValue = activityList.getSelectedValue();
                                                             //call performAction method
                                                             performAction(selectedValue);
                                                         }
                                                     }
                                                 });

            activityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            activityList.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int index = activityList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        activityList.setSelectedIndex(index);
                        activityList.repaint();
                    }
                }
            });

            JScrollPane scrollPane = new JScrollPane(activityList);
            add(scrollPane, BorderLayout.WEST);

            centerPanel = new JPanel(new CardLayout());
            add(centerPanel, BorderLayout.CENTER);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void showPanel(JPanel panel, String name) {
            centerPanel.add(panel, name);
            CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
            cardLayout.show(centerPanel, name);
        }

        private void performAction(String activity) {
            switch (activity) {
                case "Add new student":
                    // Pass StudentManager
                    showPanel(new AddNewStudentPanel(studentManager), "Add new student");
                    break;
                case "Remove student":
                    showPanel(new RemoveStudentPanel(studentManager), "Remove student");
                    break;
                case "View all students":
                    showPanel(new ViewAllStudentPanel(studentManager), "View all students");
                    break;
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainMenu().setVisible(true);
                }
            });
        }
    }

