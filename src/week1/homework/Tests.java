package week1.homework;

/**
 * Created by saint on 17.05.17.
 */
public class Tests {
    /*
    private Student student1 = new Student("Ivan1", "Ivanov1" , 21);
    private Student student2 = new Student("Ivan2", "Ivanov2" , 22);
    private Student student3 = new Student("Ivan3", "Ivanov3" , 23);
    private Student student4 = new Student("Ivan4", "Ivanov4" , 24);
    private Student student5 = new Student("Ivan5", "Ivanov5" , 25);
    Student[] students = {student1, student2, student3, student4, student5};

    Group group1 = new Group(1, 10);
    Group group2 = new Group(1, 3);
    Group group3 = new Group(1, new Student[5]);
    Group group4 = new Group(1, students);
    */

    public void testAddStudent1(){
        Group group1 = new Group(1, 10);
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        boolean expected = true;
        boolean actual = group1.addStudent(student1);
        System.out.format("testAddStudent1 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudent2(){
        Group group1 = new Group(1, 10);
        boolean expected = false;
        boolean actual = group1.addStudent(null);
        System.out.format("testAddStudent2 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudent3(){
        Group group1 = new Group(1, 0);
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        boolean expected = false;
        boolean actual = group1.addStudent(student1);
        System.out.format("testAddStudent3 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudent4(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan2", "Ivanov2" , 22);
        Group group1 = new Group(1, 3);
        group1.addStudent(student1);
        group1.addStudent(student2);
        boolean expected = false;
        boolean actual = group1.addStudent(student3);
        System.out.format("testAddStudent4 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudent5(){
        Group group1 = new Group(1, 10);
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        boolean expected = true;
        boolean actual = group1.addStudent(student1, 5);
        System.out.format("testAddStudent5 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudent6(){
        Group group1 = new Group(1, 10);
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        group1.addStudents(new Student[]{student1, student2});
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        boolean expected = true;
        boolean actual = group1.addStudent(student3, 1);
        System.out.format("testAddStudent6 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    // test AddStudents
    public void testAddStudents1(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student student5 = new Student("Ivan5", "Ivanov5" , 25);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, 5);
        boolean expected = true;
        boolean actual = group1.addStudents(students);
        System.out.format("testAddStudents1 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudents2(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student student5 = new Student("Ivan5", "Ivanov5" , 25);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, 3);
        boolean expected = false;
        boolean actual = group1.addStudents(students);
        System.out.format("testAddStudents2 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudents3(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student student5 = new Student("Ivan5", "Ivanov5" , 25);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, 10);
        group1.addStudent(student1);
        boolean expected = true;
        boolean actual = group1.addStudents(students);
        System.out.format("testAddStudents3 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddStudents4(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student student5 = new Student("Ivan5", "Ivanov5" , 25);
        Student[] students = {student1, student2, student3, student4, null};
        Group group1 = new Group(1, 10);
        boolean expected = true;
        boolean actual = group1.addStudents(students);
        System.out.format("testAddStudents4 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }

    public void testDeleteStudent1(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, students);
        boolean expected = true;
        boolean actual = group1.deleteStudent(1);
        System.out.format("testDeleteStudent1 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testDeleteStudent2(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, students);
        boolean expected = false;
        boolean actual = group1.deleteStudent(6);
        System.out.format("testDeleteStudent2 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testDeleteStudent3(){
        Student student1 = new Student("Ivan1", "Ivanov1" , 21);
        Student student2 = new Student("Ivan2", "Ivanov2" , 22);
        Student student3 = new Student("Ivan3", "Ivanov3" , 23);
        Student student4 = new Student("Ivan4", "Ivanov4" , 24);
        Student[] students = {student1, student2, student3, student4};
        Group group1 = new Group(1, 5);
        boolean expected = false;
        boolean actual = group1.deleteStudent(-5);
        System.out.format("testDeleteStudent3 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }

    //tests for university

    public void testAddGroup1(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3});
        boolean expected = false;
        boolean actual = university1.addGroup(null);
        System.out.format("testAddGroup1 \t\tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddGroup2(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3});
        boolean expected = true;
        boolean actual = university1.addGroup(group1);
        System.out.format("testAddGroup2 \t\tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddGroup3(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3});
        boolean expected = false;
        boolean actual = university2.addGroup(group3);
        System.out.format("testAddGroup3 \t\tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testAddGroup4(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3, null});
        boolean expected = false;
        boolean actual = university2.addGroup(group3);
        System.out.format("testAddGroup4 \t\tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testDeleteGroup1(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3, null});
        boolean expected = true;
        boolean actual = university2.deleteGroup(2);
        System.out.format("testDeleteGroup1 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }
    public void testDeleteGroup2(){
        Student student1 = new Student("Vasya", "Puppkin", 30);
        Student student2 = new Student("Petya", "Ivanov", 35);
        Student student3 = new Student("Vasilii", "Zalupkin", 23);
        Student student4 = new Student("Vanya", "Typoi", 56);
        Student student5 = new Student("Andrew", "Sasun", 27);
        Group group2 = new Group(2, 10);
        Group group1 = new Group(1, new Student[]{student1, student2, student4});
        Group group3 = new Group(3, new Student[]{student4, student3, student1, student5});
        Group group4 = new Group(4, new Student[]{student4, student3, student1, student5});
        University university1 = new University("1", 5);
        University university2 = new University("2", new Group[]{group1, group2, group3, null});
        boolean expected = false;
        boolean actual = university2.deleteGroup(10);
        System.out.format("testDeleteGroup2 \tresult - %b, actual - %b, expected - %b\n", actual == expected, actual, expected);
    }

}
