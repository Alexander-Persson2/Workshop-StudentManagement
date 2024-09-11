package se.lexicon.data_access;

import se.lexicon.models.Student;
import java.util.List;

public interface StudentDao {
    Student find(int id);           // Find a student by ID
    Student save(Student student);  // Save a new student
    List<Student> findAll();        // Get a list of all students
    void delete(int id);            // Delete a student by ID
}
