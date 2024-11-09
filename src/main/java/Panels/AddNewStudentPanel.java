package Panels;

import org.example.StudentManager;
import  org.example.Student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mashila Marcus
 */
public class AddNewStudentPanel extends javax.swing.JPanel {
    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JButton addButton;
    /*
    This field holds a reference to the StudentManager instance.
    It allows the panel to interact with the StudentManager (which is responsible for managing the list of students).
    */
    private StudentManager studentManager;

    /**
     * Creates new form AddNewStudentPanel
     */
     /*This is the constructor of AddNewStudentPanel, which accepts a StudentManager instance
     By storing this manager reference, the panel can now add new students to the existing StudentManager instance
     */
    public AddNewStudentPanel(StudentManager manager) {
        this.studentManager = manager;

        JLabel idLabel = new JLabel("Student ID:");
        idField = new JTextField(15);
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(15);
        addButton = new JButton("Add Student");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    String email = emailField.getText();
                    studentManager.addStudent(new Student(id, name, email));
                    JOptionPane.showMessageDialog(null, "Student Added Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(addButton);
    }
}
