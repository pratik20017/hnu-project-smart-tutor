package de.hnu.data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LECTURERS")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "lecturers", fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    public Lecturer() {
    }

    public Lecturer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

