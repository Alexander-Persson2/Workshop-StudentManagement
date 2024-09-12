package se.lexicon.data_access;

import se.lexicon.models.Student;
import java.util.List;

public interface StudentManagement {
    Student create();  // Create a new student
    Student save(Student student); // Save a student
    Student find(int id); // Find a student by ID
    List<Student> findAll(); // Find all students
    Student remove(int id); // Remove a student by ID
    Student edit(Student student); // Edit a student's details

}
