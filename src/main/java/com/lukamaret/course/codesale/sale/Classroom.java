package com.lukamaret.course.codesale.sale;

import java.util.List;

/**
 * @author lukamaret
 */
public class Classroom {

    private final List<Student> st; public Classroom(List<Student> std) {
        this.st = std;
    }

    public List<Student> list() {
        return st;
    }

    public int countP() {
        int c = 0;
        for (Student st : st) {
            int s = 0;
            for (Grade g : st.grades())
        s += g.val();
            s /= st.grades().size();
            if (s >= 10)
            c++;
        }
        return c;
    }

}
