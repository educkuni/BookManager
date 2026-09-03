import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, false));
        books.add(new Book("Harry Potter", "J.K. Rowling", 1997, false));

        int choice = 0;

        while(choice != 4) {

            System.out.println(
                    "////////////////////////\n" +
                    "What do you want to do?\n" +
                    "1 - Add a new book\n" +
                    "2 - Choose a book\n" +
                    "3 - See all books\n" +
                    "4 - Exit\n" +
                    "Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1 -> {
                    System.out.print("Book name: ");
                    String name = scanner.nextLine();
                    boolean nameFound = false;

                    System.out.print("Book author: ");
                    String author = scanner.nextLine();

                    System.out.print("Book release year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine();

                    for (Book book : books){
                       if(name.equalsIgnoreCase(book.name)) {
                           nameFound = true;
                       }

                    }
                    if(!nameFound){
                        books.add(new Book(name, author, releaseYear, false));
                    } else {
                        System.out.println("A book with this name already exists.");
                    }
                }


                case 2 -> {
                    System.out.println("What is the book name: ");
                    String bookName = scanner.nextLine();
                    boolean found = false;
                    for (Book book : books) {
                        if (bookName.equalsIgnoreCase(book.name)) {

                            found = true;

                            if(!book.borrowed) {
                                System.out.println(book.name + " Status: Available");

                                System.out.println("1 - Borrow");
                                System.out.println("2 - Back");
                                System.out.print("Choose: ");
                                int borrowChoice = scanner.nextInt();
                                scanner.nextLine();

                                if(borrowChoice == 1){
                                    book.borrowed = true;
                                    System.out.println(book.name + " was borrowed.");
                                }

                            }
                            else{
                                System.out.println(book.name + " Status: Borrowed");
                                System.out.println("1 - Return book");
                                System.out.println("2 - Back");
                                System.out.print("Choose: ");
                                int returnChoice = scanner.nextInt();
                                scanner.nextLine();

                                if(returnChoice == 1){
                                    book.borrowed = false;
                                    System.out.println(book.name + " was returned.");
                                }
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid book");
                    }
                }

                case 3 -> {
                    for (Book book : books) {
                        System.out.println(book.name);
                        System.out.println(book.author);
                        System.out.println(book.releaseYear);
                        if(!book.borrowed) {
                            System.out.println("Status: Available");
                        }
                        else{
                            System.out.println("Status: Borrowed");
                        }
                        }

                }

                case 4 -> System.out.println("Goodbye!");

                default -> System.out.println("Invalid option.");
            }
        }

        }
    }
