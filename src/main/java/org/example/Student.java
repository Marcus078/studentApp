package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Mashila Marcus
 */
public class Student {
    private int id;
    private String name;
    private String email;
    Date enrollmentDate;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enrollmentDate = new Date(); // set date to current date when student object is created
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;

    }
    public String getDate(){
        // Date format SUN 21-OCT-2024 10:51:01 Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd-MMM-yyyy HH:mm:ss", Locale.getDefault());
        return dateFormat.format(enrollmentDate);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email+ " Date "+ enrollmentDate;
    }
}
