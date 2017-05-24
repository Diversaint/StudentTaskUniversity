package week1.homework.inheritance.edition;

/**
 * Created by saint on 23.05.17.
 */
public class Directory extends Book {
    private String classification;

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    public Directory(String name, String author, String genre, int numberOfPages, int yearOfIssue, String classification) {
        super(name, author, genre, numberOfPages, yearOfIssue);
        this.classification = classification;
    }

    public void printClassification(){
        System.out.println(classification);
    }

    @Override
    public void printDescription() {
        System.out.println("This is directory");
    }

    @Override
    public String toString() {
        return super.toString() + "Directory{" +
                "classification='" + classification + '\'' +
                '}';
    }
}
