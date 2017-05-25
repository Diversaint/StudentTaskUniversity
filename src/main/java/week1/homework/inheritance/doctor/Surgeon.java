package week1.homework.inheritance.doctor;

/**
 * Created by saint on 24.05.17.
 */
public class Surgeon implements Doctor{
    private String name;
    private String secession;
    private int numberOfRoom;
    private String shift;

    public Surgeon(String name, String secession, int numberOfRoom, String shift) {
        this.name = name;
        this.secession = secession;
        this.numberOfRoom = numberOfRoom;
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public String getSecession() {
        return secession;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public String getShift() {
        return shift;
    }

    @Override
    public void treat() {
        System.out.println("Im Surgeon! Lie down! We will conduct the operation!");
    }
}
