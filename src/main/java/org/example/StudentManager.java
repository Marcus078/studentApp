package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mashila Marcus
 */
public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student by ID
    public boolean removeStudent(int studentID) {
        return students.removeIf(student -> student.getId() == studentID);
    }

    // Remove a student by Name
    public boolean removeStudentByName(String name) {
        return students.removeIf(student -> student.getName().equalsIgnoreCase(name));
    }

    // View all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Find a student by ID
    public Student findStudentById(int studentID) {
        for (Student student : students) {
            if (student.getId() == studentID) {
                return student;
            }
        }
        return null;
    }

}
