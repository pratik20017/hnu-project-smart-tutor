package de.hnu.data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String courseCode;

    private String studyProgramme;

    private float courseCredits;

    @ManyToMany
    @JoinTable(
            name = "COURSE_LECTURERS",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id")
    )
    private List<Lecturer> lecturers;

    public Course() {
    }

    public Course(String name, String courseCode, String studyProgramme, float courseCredits, List<Lecturer> lecturers) {
        this.name = name;
        this.courseCode = courseCode;
        this.studyProgramme = studyProgramme;
        this.courseCredits = courseCredits;
        this.lecturers = lecturers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public float getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(float courseCredits) {
        this.courseCredits = courseCredits;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
}

