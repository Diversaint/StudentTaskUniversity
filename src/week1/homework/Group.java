package week1.homework;

/**
 * Created by saint on 17.05.17.
 */
public class Group {
    private int groupNumber;
    private Student[] students;
    private int size;

    private int countStudents(Student[] students) {
        int count = 0;
        for (Student student : students) {
            if(student != null) count++;
        }
        return count;
    }
    // fixed! when in students will be null between students, size will be fixed and null will be delete
    public Group(int groupNumber, Student[] students) {
        this.groupNumber = groupNumber;
        size = countStudents(students);
        this.students = students;
        for (int i = 0; i < students.length; i++)
            if (this.students[i] == null && i != students.length - 1)
                deleteStudent(i);
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
        if (!noRepetitionInGroup(student))
        return false;
        students[size++] = student;
        return true;
    }
    // fixed check priority. no check for null because added check in fixed method noRepetitionInGroup. delete chek for size
    public boolean addStudent (Student student, int position) {
        if (position > size){
            students[size++] = student;
            return true;
        }
        if (student == null)
            return false;
        if (!noRepetitionInGroup(student))
            return false;
        System.arraycopy(students, position, students, position + 1, size - position);
        students[position] = student;
        size++;

        return true;
    }
    // fixed added check for null
    public boolean addStudents(Student[] students) {
        if (students == null)
            return false;
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

    //fixed add check if student null, equals will be fixed in next commit, change name of method
    public boolean noRepetitionInGroup(Student student){
        if (student == null)
            return false;
        for (int i = 0; i < size; i++) {
            if (student.equals(students[i])){
                System.out.println("This student in group already");
                return false;
            }

        }
        return true;
    }

    public boolean updateStudent (Student student, int position) {
        if (!noRepetitionInGroup(student))
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
        if (position >= size || position < 0)
            return false;
        System.arraycopy(students, position + 1, students, position, size - position - 1);
        students[size - 1] = null;
        size--;
        return true;
    }
    //delete by student
    //fixed simplified code. equals will be override in next task
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

    @Override
    public boolean equals(Object var1) {
        if (var1 == null || this == null)
            return false;
        if (!(var1 instanceof Group)) // need '&& this instanceof Student' or no?
            return false;
        Group group1 = (Group) var1;
        Group group2 = this;
        if (group1.groupNumber == group2.groupNumber)
            return true;
        return false;
    }


}

