package week1.homework;

/**
 * Created by saint on 18.05.17.
 */
public class University {
    private String name;
    private Group[] groups;
    private int size;
    // fixed! when in groups will be null between group, size will be fixed and null will be delete

    public University(String name, Group[] groups){
        this.name = name;
        this.groups = groups;
        size = countGroups(groups);
        for (int i = 0; i < groups.length; i++)
            if (this.groups[i] == null)
                deleteGroup(i);
    }

    private int countGroups(Group[] groups) {
        int count = 0;
        for (Group group : groups) {
            if(group != null) count++;
        }
        return count;
    }
    // fixed! when in students will be null between students, size will be fixed and null will be delete

    public University(String name, int size){
        this.name = name;
        this.groups = new Group[size];
    }
    public String asString(){
        StringBuffer info = new StringBuffer();
        info.append(name).append("\n");
        int numberOfGroup = 1;
        for (Group group : groups) {
            if (group != null)
                info.append(numberOfGroup).append(") ").append(group.asString()).append("\n");
        }
        return info.toString();
    }
    public boolean addGroup(Group group){
        if (group == null)
            return false;
        if (size == groups.length)
            return false;
        for (int i = 0; i < size; i++) {
            if (group.equals(groups[i]))
                return false;
        }
        groups[size++] = group;
        return true;
    }

    public boolean deleteGroup(int position){
        if (position > size || position < 0)
            return false;
        System.arraycopy(groups, position + 1, groups, position, size - position - 1);
        groups[size - 1] = null;
        size--;
        return true;

    }

}
