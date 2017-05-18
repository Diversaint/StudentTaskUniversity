package week1.homework;

/**
 * Created by saint on 16.05.17.
 */
public class TestingAllClasses {
    public static void main(String[] args) {

        //testing how works Student and Group

        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Student student = new Student ();


        Student[] students = {student1, student2, student3, student4};
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, students);


        Student student6 = new Student();
        System.out.println("___________________________________________________________________");
        System.out.println("Check condition in setter");


        student6.setName("12sd");
        student6.setSurName("Petrovich");
        student6.setAge(-5);

        System.out.println(student6.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("Check add student");

        group1.addStudent(student2);

        group2.addStudent(student2);

        System.out.println("___________________________________________________________________");
        System.out.println("check add studentS");
        group2.addStudents(students);
        System.out.println(group2.asString());


        System.out.println("___________________________________________________________________");
        System.out.println("delete student in position");

        group2.deleteStudent(2);
        System.out.println(group2.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("delete this student");
        System.out.println(group2.asString());
        group2.deleteStudent(student1);
        System.out.println(group2.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("add student in position");
        group2.addStudent(student1,1);
        System.out.println(group2.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("update student in position");
        group2.updateStudent(student5, 1);
        System.out.println(group2.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("sort group");
        group2.sortStudent();
        System.out.println(group2.asString());
        group1.sortStudent();
        System.out.println(group1.asString());


        //testing how works University
        Group group3 = new Group(5, new Student[]{student1, student2, student3, student4, student5});

        University universityKPI = new University("KPI", 5);
        University universityNAU = new University("NAU", new Group[]{group1, group2});

        System.out.println(universityKPI.asString());
        System.out.println(universityNAU.asString());
        System.out.println("___________________________________________________________________");
        System.out.println("add group");
        universityKPI.addGroup(group1);
        universityKPI.addGroup(group2);
        universityKPI.addGroup(group3);
        universityKPI.addGroup(group2);
        universityNAU.addGroup(group3);
        System.out.println(universityNAU.asString());
        System.out.println(universityKPI.asString());

        System.out.println("___________________________________________________________________");
        System.out.println("delete group");
        universityKPI.deleteGroup(1);
        System.out.println(universityKPI.asString());

















    }
}
