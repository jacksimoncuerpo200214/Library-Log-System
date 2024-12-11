package library.log.system;

import java.util.Scanner;

public class Book {
    
    public void addBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int copies, year;

        System.out.print("Book Title: ");
        String title = sc.nextLine();
        
        System.out.print("Book Author: ");
        String author = sc.nextLine();
        
        System.out.print("Book Genre: ");
        String genre = sc.nextLine();
       
        while (true) {
            System.out.print("Number of Copies: ");
            if (sc.hasNextInt()) {
                copies = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
        
        sc.nextLine();
        while (true) {
            System.out.print("Book Publication Year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
        sc.nextLine();
        
        String sql = "INSERT INTO books (title, author, genre, copies, year) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, title, author, genre, copies, year);
    }

    public void viewBooks() {
        String query = "SELECT * FROM books";
        String[] headers = {"Book ID", "Title", "Author", "Genre", "Copies Available", "Publication Year"};
        String[] columns = {"book_id", "title", "author", "genre", "copies", "year"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }

    public void updateBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int bookId;
        
        while (true) {
            System.out.print("\nEnter Book ID to Update: ");
            if (sc.hasNextInt()) {
                bookId = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
        }
       
         while ((conf.getSingleValue("SELECT book_id FROM books WHERE book_id = ?", bookId)) == 0){
            System.out.println("Selected Book ID doesn't exist!");
            while (true) {
            System.out.print("Enter Book ID again: ");
            if (sc.hasNextInt()) {
                bookId = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
            }
       }
         
        System.out.print("New Number of Copies: ");
        int copies = sc.nextInt();

        String sql = "UPDATE books SET copies = ? WHERE book_id = ?";
        conf.updateRecord(sql, copies, bookId);
    }

    public void deleteBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int bookId;
        
        while (true) {
            System.out.print("\nEnter Book ID to Delete: ");
            if (sc.hasNextInt()) {
                bookId = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
        }
       
         while ((conf.getSingleValue("SELECT book_id FROM books WHERE book_id = ?", bookId)) == 0){
            System.out.println("Selected Book ID doesn't exist!");
            while (true) {
            System.out.print("Enter Book ID again: ");
            if (sc.hasNextInt()) {
                bookId = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
            }
       }

        String sql = "DELETE FROM books WHERE book_id = ?";
        conf.deleteRecord(sql, bookId);
    }

    public void libraryMenu() {
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        
        int choice;
        boolean exit = true;

        do {
            System.out.println("\n------------ LIBRARY BOOKS -------------");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------");
            while (true) {
            System.out.print("Enter Choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

            switch (choice) {
                case 1:
                    book.addBook();
                    break;
                case 2:
                    System.out.println("\n---- BOOK INFORMATION ----");
                    book.viewBooks();
                    break;
                case 3:
                    System.out.println("\n---- BOOK INFORMATION ----");
                    book.viewBooks();
                    book.updateBook();
                    System.out.println("\n---- BOOK INFORMATION ----");
                    book.viewBooks();
                    break;
                case 4:
                    System.out.println("\n---- BOOK INFORMATION ----");
                    book.viewBooks();
                    book.deleteBook();
                    System.out.println("\n---- BOOK INFORMATION ----");
                    book.viewBooks();
                    break;
                case 5:
                    System.out.print("Exit selected...type yes to continue: ");
                    String resp = sc.next();
                    if (resp.equalsIgnoreCase("yes")) {
                        exit = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");
            }
        } while (exit);
    }
}
