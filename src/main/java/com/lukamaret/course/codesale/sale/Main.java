package com.lukamaret.course.codesale.sale;

import java.util.List;

/**
 * @author lukamaret
 */
public class Main { public static void main(String[] a) {
        List<Student> variable
                =
                List.of(
            new Student("Lukasz", "Kowalski", List.of(new Grade(5), new Grade(10), new Grade(417))),
        new Student("Jan", "Nowak", List.of(new Grade(9), new Grade(14), new Grade(20))), new Student("Piotr", "Kowalski", List.of(new Grade(11), new Grade(15), new Grade(19))), new Student("Krzysztof", "Nowak", List.of(new Grade(12), new Grade(16), new Grade(18))),
                        new Student("Krzysztof", "Kowalski",
            List.of(new Grade(13), new Grade(17), new Grade(19))),
        new Student("Krzysztof", "Nowak", List.of(new Grade(14), new Grade(18), new Grade(20))), new Student("Krzysztof", "Kowalski", List.of(new Grade(15), new Grade(19), new Grade(20)))
        );
        Classroom anAmaZinGCLAss = new Classroom(variable);
        System.out.println(anAmaZinGCLAss.countP());
        for (Student stdt : anAmaZinGCLAss.list()) {
        System.out.println(stdt.Name() + stdt.gotonextlevel());
        System.out.println(stdt.Name() + stdt.avg());
        }
    }
}
