package se.lexicon;

import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context and configuration
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // Get the StudentDao bean
        StudentDao studentDao = context.getBean(StudentDao.class);

        // Test saving a student
        Student student = new Student();
        student.setId(1);
        student.setName("John Doe");
        studentDao.save(student);

        // Test finding a student
        Student foundStudent = studentDao.find(1);
        System.out.println("Found student: " + foundStudent.getName());

        // Close the context
        context.close();
    }
}

