package com.lukamaret.course.codesale.propre;

import java.util.List;

/**
 * @author lukamaret
 */
public class Classroom {

    private final List<Student> students;

    public Classroom(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int countPassed() {
        int count = 0;
        for (Student student : students) {
            int sum = 0;
            for (Grade grade : student.getGrades()) {
                sum += grade.getValue();
            }
            sum /= student.getGrades().size();
            if (sum >= 10) {
                count++;
            }
        }
        return count;
    }

}
