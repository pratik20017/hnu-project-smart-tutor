
package de.hnu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import de.hnu.data.Student;

@RestController
public class StudentService {

    @GetMapping("/students/{enrollmentNr}")
    public Student getStudent(@PathVariable(name = "enrollmentNr") long enrollmentNr) {
        Student s = new Student(enrollmentNr, "Max", "Mustermann");
        return s;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> res = new ArrayList<Student>();
        res.add(new Student(1234, "Max", "Mustermann"));
        res.add(new Student(4711, "Susi", "Sunday"));
        return res;
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }
}
