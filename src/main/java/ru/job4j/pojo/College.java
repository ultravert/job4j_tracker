package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Fedor Oberyukhtin");
        student.setGroup("Java");
        student.setStartDate(new Date(122, 06, 01));

        System.out.println(student.getName() + " - студент группы "
                + student.getGroup() + ", дата поступления: " + student.getStartDate());
    }
}
