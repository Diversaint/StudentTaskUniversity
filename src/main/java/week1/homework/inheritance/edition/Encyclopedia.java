package week1.homework.inheritance.edition;

/**
 * Created by saint on 23.05.17.
 */
public class Encyclopedia extends Book{
    private int nubmerOfVolume;

    public Encyclopedia(String name, String author, String genre, int numberOfPages, int yearOfIssue, int nubmerOfVolume) {
        super(name, author, genre, numberOfPages, yearOfIssue);
        this.nubmerOfVolume = nubmerOfVolume;
    }

    public int getNubmerOfVolume() {
        return nubmerOfVolume;
    }

    @Override
    public String toString() {
        return super.toString() + "Encyclopedia{" +
                "nubmerOfVolume=" + nubmerOfVolume +
                '}';
    }

    @Override
    public void printDescription() {
        System.out.println("This is directory");
    }
}
