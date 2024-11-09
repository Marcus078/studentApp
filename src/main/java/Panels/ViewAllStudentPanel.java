package Panels;

import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.example.StudentManager;
import org.example.Student;
import javax.swing.*;
import java.util.List;


/**
 *
 * @author Mashila Marcus
 */
public class ViewAllStudentPanel extends javax.swing.JPanel {
    private JTextArea studentListArea;
    private JButton sortByIdButton;
    private JButton sortByNameButton;
    private JButton sortByDate;
    private StudentManager studentManager;

    public ViewAllStudentPanel(StudentManager manager) {
        this.studentManager = manager;

        JLabel label = new JLabel("All Students:");
        studentListArea = new JTextArea(10, 30);
        studentListArea.setEditable(false);

        sortByIdButton = new JButton("Sort by ID");
        sortByNameButton = new JButton("Sort by Name");
        sortByDate = new JButton("Sort by date");

        sortByIdButton.addActionListener(e -> displaySortedStudentsById());
        sortByNameButton.addActionListener(e -> displaySortedStudentsByName());
        sortByDate.addActionListener(e -> displaySortedStudentsByDate());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(label);
        add(new JScrollPane(studentListArea));
        add(sortByIdButton);
        add(sortByNameButton);
        add(sortByDate);

        displayStudents();
    }

    // Display all students
    private void displayStudents() {
        List<Student> students = studentManager.getAllStudents();
        studentListArea.setText("");
        for (Student student : students) {
            studentListArea.append(student + "\n");
        }
    }

    // Sort and display by ID
    private void displaySortedStudentsById() {
        List<Student> students = studentManager.getAllStudents();
        students.sort(Comparator.comparingInt(Student::getId));
        studentListArea.setText("");
        for (Student student : students) {
            studentListArea.append(student + "\n");
        }
    }

    // Sort and display by Name
    private void displaySortedStudentsByName() {
        List<Student> students = studentManager.getAllStudents();
        students.sort(Comparator.comparing(Student::getName));
        studentListArea.setText("");
        for (Student student : students) {
            studentListArea.append(student + "\n");
        }
    }

    private void displaySortedStudentsByDate() {
        List<Student> students = studentManager.getAllStudents();
        students.sort(Comparator.comparing(Student::getDate).reversed());
        studentListArea.setText("");
        for (Student student : students) {
            studentListArea.append(student + "\n");
        }
    }
}
