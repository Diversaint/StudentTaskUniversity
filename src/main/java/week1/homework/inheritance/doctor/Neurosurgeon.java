package week1.homework.inheritance.doctor;

/**
 * Created by saint on 24.05.17.
 */
public class Neurosurgeon extends Surgeon{
    private String subsections;

    public Neurosurgeon(String name, String secession, int numberOfRoom, String shift, String subsections) {
        super(name, secession, numberOfRoom, shift);
        this.subsections = subsections;
    }

    public String getSubsections() {
        return subsections;
    }


    @Override
    public void treat() {
        System.out.println("Check your tests and then probably do the operation");
    }
}
