package week1.homework;

/**
 * Created by saint on 17.05.17.
 */
public class Group {
    private int groupNumber;
    private Student[] students;
    private int size;

    public Group(int groupNumber, Student[] students) {
        this.groupNumber = groupNumber;
        this.students = students;
        size = students.length;
    }

    public Group(int groupNumber, int groupSize) {
        this.groupNumber = groupNumber;
        this.students = new Student[groupSize];
    }

    public String asString() {
        StringBuffer info = new StringBuffer();
        info.append("Group number # ").append(groupNumber).append("\n");

        /*for (int i = 0; i < students.length; i++) {
            info += students[i] == null ? null : students[i].asString();
            info += "/n";
        }*/

        /*for (Student student : students){
            info += student == null ? null : student.asString();
            info += "\n";
        }*/
        int numberOfStudent = 1;

        for (Student student : students) {
            if (student != null)
                info.append(numberOfStudent++).append(". ").append(student.asString()).append("\n");
        }
        return info.toString();
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            //System.out.println("Student is invalid");
            return false;
        }
        if (size == students.length) {
            System.out.println("The group is full");
            return false;
        }
        if (!isAlreadyInGroup(student))
        return false;
        students[size++] = student;
        return true;
    }
    public boolean addStudent (Student student, int position) {
        if (!isAlreadyInGroup(student))
            return false;
        if (size == students.length)
            return false;
        if (student == null)
            return false;
        if (position > size){
            students[size++] = student;
            return true;
        }
        System.arraycopy(students, position, students, position + 1, size - position);
        students[position] = student;
        size++;

        return true;
    }
    public boolean addStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (this.students.length > size) {
                addStudent(students[i]);
                }
            else {
                System.out.println("Not enough space in group for " + (students.length - i) + " studenst");
                return false;
            }
        }
        return true;
    }

    public boolean isAlreadyInGroup(Student student){
        for (int i = 0; i < size; i++) {
            if (student.equals(students[i])){
                System.out.println("This student in group already");
                return false;
            }

        }
        return true;
    }

    public boolean updateStudent (Student student, int position) {
        if (!isAlreadyInGroup(student))
            return false;
        if (size == students.length)
            return false;
        if (student == null)
            return false;
        students[position] = student;

        return true;
    }

    //delete student in position
    public boolean deleteStudent(int position) {
        if (position > size || position < 0)
            return false;
        System.arraycopy(students, position + 1, students, position, size - position - 1);
        students[size - 1] = null;
        size--;
        return true;
    }
    //delete by student
    public boolean deleteStudent(Student student) {
        if (student == null)
            return false;
        for (int i = 0; i < size; i++) {
            if (student.equals(students[i]))
            {deleteStudent(i);
            return true;}
        }
        return false;
    }
    //sort
    public boolean sortStudent(){

        Student temp = new Student();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (students[i].getName().compareTo(students[j].getName()) > 0) {
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        return true;
    }
}

