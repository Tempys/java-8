package lesson1;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

/**
 * Let's assume there is class Student exists. Each student has a name and a grade for exam in computer science.

   You need to understand in what order the list will be sorted by the code below.

   List<Student> students = ...

   students.sort(
  comparing(Student::getCsGrade, reverseOrder())
   .thenComparing(Student::getName));

    Note. The method getName() returns name of the student, getCsGrade() returns a grade for exam.
 */
public class Task13 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student("Antonio",85),new Student("Mary",82),new Student("Alisa",100),new Student("John",100));

        students.sort(
                comparing(Student::getCsGrade, reverseOrder())//);
                        .thenComparing(Student::getName));

        System.out.println(students);
    }
}



class Student {

    private String name;
    private int csGrade;

    public Student(String name, int csGrade) {
        this.name = name;
        this.csGrade = csGrade;
    }

    public String getName() {
        return name;
    }

    public int getCsGrade() {
        return csGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", csGrade=" + csGrade +
                '}';
    }
}