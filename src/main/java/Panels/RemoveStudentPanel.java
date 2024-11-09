package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.example.StudentManager;
/**
 *
 * @author Mashila Marcus
 */
public class RemoveStudentPanel extends javax.swing.JPanel {
    private final JTextField inputField;
    private final JButton removeByIdButton;
    private final JButton removeByNameButton;
    private final StudentManager studentManager;

    public RemoveStudentPanel(StudentManager manager) {
        this.studentManager = manager;

        JLabel instructionLabel = new JLabel("Enter Student ID or Name to delete:");
        inputField = new JTextField(15);

        removeByIdButton = new JButton("Remove by ID");
        removeByNameButton = new JButton("Remove by Name");

        // Remove by ID
        removeByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(inputField.getText());
                if (studentManager.removeStudent(id)) {
                    JOptionPane.showMessageDialog(null, "Student removed by ID successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with this ID.");
                }
            }
        });

        // Remove by Name
        removeByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                if (studentManager.removeStudentByName(name)) {
                    JOptionPane.showMessageDialog(null, "Student removed by Name successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with this name.");
                }
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(instructionLabel);
        add(inputField);
        add(removeByIdButton);
        add(removeByNameButton);
    }
}