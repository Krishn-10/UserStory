import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        book[] bookbank = new book[100];
        Random rand = new Random();
        String[] titles = {
                "Java Basics", "Data Structures", "Algorithms Unlocked",
                "Operating Systems", "Database Systems", "Computer Networks",
                "Machine Learning", "Artificial Intelligence", "Cyber Security",
                "Software Engineering"
        };
        Arrays.sort(titles);

        // Create 10 random book entries
        for (int i = 0; i < 10; i++) {
            book b = new book();
            b.title = titles[i];
            b.setTotalQuantity(rand.nextInt(50) + 10);  // total between 10–59
            b.setAvailQuantity(rand.nextInt(b.getTotalQuantity() + 1)); // avail ≤ total
            bookbank[i] = b;
        }


        while(true) {
            System.out.println("Enter operation, View all books, borrow, return, exit");
            String op = sc.nextLine();
            boolean condition = false;
            switch (op.toLowerCase()) {
                case "view all books":
                    for (int i = 0; i < titles.length; i++) {
                        System.out.println(titles[i]);
                    }
                    break;
                case "borrow":
                    System.out.println("Select book");
                    String b1 = sc.nextLine();
                    boolean f = false;
                    for (book book : bookbank) {
                        if (Objects.equals(book.getTitle(), b1)) {
                            if (book.getAvailQuantity() > 0) {
                                System.out.println("Transaction successful : ");
                                book.availQuantity--;
                                System.out.println("Available quantity : " + book.getAvailQuantity());
                                f = true;
                                break;
                            } else
                                System.out.println("Currently not available");
                        }
                    }
                    if (!f)
                        System.out.println("Book not found");
                    break;
                case "return":
                    System.out.println("Select book");
                    String r1 = sc.nextLine();
                    boolean f2 = false;
                    for (book book : bookbank) {
                        if (Objects.equals(book.getTitle(), r1)) {
                            System.out.println("Transaction successful");
                            book.availQuantity++;
                            System.out.println("Available quantity: " + book.getAvailQuantity());
                            f = true;
                            break;
                        }
                    }
                    if (!f2)
                        System.out.println("Book not found");
                    break;

                case "exit":
                    condition = true;
                    break;

            }
            if(condition)
                break;
        }

    }


}

class book {
    public int availQuantity;
    public int totalQuantity;
    public String title;

    public int getAvailQuantity() {
        return availQuantity;
    }

    public void setAvailQuantity(int availQuantity) {
        this.availQuantity = availQuantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getTitle() {
        return title;
    }
}