package week1.homework.inheritance.edition;

/**
 * Created by saint on 23.05.17.
 */
public class TestEdition {
    public static void main(String[] args) {

    Book directoryForCoding = new Directory("Coding for noobs", "Master", "Hard reading", 521, 2017,"Beginner");
    Book encyclopediaOfDiving = new Encyclopedia("CMAS", "Diver Saint", "Teaching", 1234, 2005, 5);
    Book book = new Book("Cadets life", "Captain", "Erotik", 1001, 2007) {
        @Override
        public void printDescription() {
            System.out.println("This is book");
        }
    };

    directoryForCoding.printDescription();
    directoryForCoding.printInfo();
    encyclopediaOfDiving.printDescription();
    encyclopediaOfDiving.printInfo();
    book.printDescription();
    book.printInfo();
        Directory temp = (Directory)directoryForCoding;
        temp.printClassification();

    }
}
