package week1.homework;

/**
 * Created by saint on 18.05.17.
 */
public class RunTest {
    public static void main(String[] args) {
        Tests tests = new Tests();
        tests.testAddStudent1();
        tests.testAddStudent2();
        tests.testAddStudent3();
        //test AddStudent in position
        tests.testAddStudent5();
        tests.testAddStudent6();

        // test 4 false, because use casual method equals
        tests.testAddStudent4();
        //test for AddStudents
        tests.testAddStudents1();
        tests.testAddStudents2();
        tests.testAddStudents3();
        tests.testAddStudents4();
        //test for delete
        tests.testDeleteStudent1();
        tests.testDeleteStudent2();
        tests.testDeleteStudent3();
        //test university add group
        tests.testAddGroup1();
        tests.testAddGroup2();
        tests.testAddGroup3();
        tests.testAddGroup4();
        //test delete group
        tests.testDeleteGroup1();
        tests.testDeleteGroup2();



    }
}
