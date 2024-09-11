package se.lexicon.data_access;

import se.lexicon.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component  // Marks this class as a Spring-managed component
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student find(int id) {
        return students.stream()
                .filter(student -> student.getId() == id) // Filters the list to find a student with the given ID
                .findFirst()  // Returns the first match
                .orElse(null); // If no match is found, return null
    }

    @Override
    public Student save(Student student) {
        students.add(student);  // Adds the student to the list
        return student;  // Returns the added student
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
