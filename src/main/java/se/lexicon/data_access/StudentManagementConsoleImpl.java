package se.lexicon.data_access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.models.Student;
import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    private final UserInputService userInputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
       this.userInputService = userInputService;
       this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter student name");
        String name = userInputService.getString();
        System.out.println("Enter student ID:");
        int id = userInputService.getInt();

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = studentDao.find(id); // Find the student to remove
        if (studentToRemove != null) {
            studentDao.delete(id); // Delete the student from the list
        }
        return studentToRemove; // Return the removed student (or null if not found)
    }

    @Override
    public Student edit(Student student) {
        return save(student); // Overwriting the current student details
    }

}
