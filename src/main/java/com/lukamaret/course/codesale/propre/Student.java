package com.lukamaret.course.codesale.propre;

import java.util.List;

/**
 * @author lukamaret
 */
public class Student {

    private final String name;
    private String email;
    private final List<Grade> grades;

    public Student(String name, String email, List<Grade> grades) {
        this.name = name;
        this.email = email;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        double sum = 0;

        for (Grade grade : grades) {
            sum += grade.getValue();
        }

        return sum / grades.size();
    }

    public boolean hasPassed() {
        return getAverageGrade() >= 10;
    }

    public int countPassed() {
        int count = 0;
        for (Grade grade : grades) {
            if (grade.getValue() >= 10) {
                count++;
            }
        }
        return count;
    }

}
