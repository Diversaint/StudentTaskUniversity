package week1.homework.inheritance.doctor;

/**
 * Created by saint on 24.05.17.
 */
public class TestDoctor {
    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Pavlov", "traumatology", 231, "night shift");
        Neurosurgeon neurosurgeon = new Neurosurgeon("Sikorsky", "traumatology", 201, "day shift", "neurotraumatology");
        surgeon.treat();
        neurosurgeon.treat();
    }
}
