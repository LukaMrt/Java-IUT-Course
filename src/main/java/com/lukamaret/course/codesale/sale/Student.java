package com.lukamaret.course.codesale.sale;

import java.util.List;

/**
 * @author lukamaret
 */
public class Student {

    private final String n;
    private String m;
    private final List<Grade> grds;

    public Student(String n, String email, List<Grade> grds) {
        this.n = n;
        this.m = email;
        this.grds = grds;
    }

    public String Name() {
    return n;
    }

    public String getEmail() {
    return m;
    }

    public void setEmail(String email) {
    this.m = email;
    }

    public List<Grade> grades() {
        return grds;
    }public double avg() {double s = 0;
        for (Grade grade : grds)
                    s = s + grade.val();
            return s / grds.size();
    }

    public boolean gotonextlevel() {
                return avg() >= 10;
    }

    /**
     * This function will return the number of function which the student has with a grade greater than 10. In other words
     * we will have a count and when a grade is greater than 10 we will increment the count so that we can have the final result
     * At the end we will return the count. For example if the student has 3 grades with value 10, 11 and 8, we will return
     * 2 because 10 and 11 are greater than 10 but 8 is not so that there are only 2 functions with a grade greater than 10.
     * @return a number
     */
    public int countPassed() { int count = 0;
    for (Grade grade : grds) {
                    if (grade.val() >= 10) {
    count++;
                }
    }
        return count;
    }

}
