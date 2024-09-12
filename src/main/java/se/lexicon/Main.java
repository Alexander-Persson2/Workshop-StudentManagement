package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentManagement;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context and configuration
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // Get the StudentManagement bean
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        // Create a new student using user input
        Student newStudent = studentManagement.create();
        studentManagement.save(newStudent);

        // Find and display the saved student
        Student foundStudent = studentManagement.find(newStudent.getId());
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent.getName());
        }
        List<Student> students = new ArrayList<>();
        students = studentManagement.findAll();
        students.forEach(System.out::println);
        // Remove the student and display the removed student's info
        System.out.println("Removing student with ID" + newStudent.getId());
        Student removedStudent = studentManagement.remove(newStudent.getId());
                if (removedStudent != null) {
                    System.out.println("Removed student: " + removedStudent.getName());
                } else {
                    System.out.println("Student not found.");
                }

        // Close the context
        context.close();
    }
}

