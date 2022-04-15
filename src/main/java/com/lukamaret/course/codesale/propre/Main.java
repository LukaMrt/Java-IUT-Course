package com.lukamaret.course.codesale.propre;

import java.util.List;

/**
 * @author lukamaret
 */
public class Main {

    public static void main(String[] args) {

        List<Student> students = List.of(
            new Student("Lukasz", "Kowalski", List.of(new Grade(5), new Grade(10), new Grade(417))),
            new Student("Jan", "Nowak", List.of(new Grade(9), new Grade(14), new Grade(20))),
            new Student("Piotr", "Kowalski", List.of(new Grade(11), new Grade(15), new Grade(19))),
            new Student("Krzysztof", "Nowak", List.of(new Grade(12), new Grade(16), new Grade(18))),
            new Student("Krzysztof", "Kowalski", List.of(new Grade(13), new Grade(17), new Grade(19))),
            new Student("Krzysztof", "Nowak", List.of(new Grade(14), new Grade(18), new Grade(20))),
            new Student("Krzysztof", "Kowalski", List.of(new Grade(15), new Grade(19), new Grade(20)))
        );

        Classroom classroom = new Classroom(students);

        System.out.println(classroom.countPassed());

        for (Student student : classroom.getStudents()) {
            System.out.println(student.getName() + student.hasPassed());
            System.out.println(student.getName() + student.getAverageGrade());
        }

    }

}
