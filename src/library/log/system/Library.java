package library.log.system;

import java.util.Scanner;

public class Library {

    public void borrowBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int bookId, pid;
        
        while (true) {
            System.out.print("Enter Book ID to Borrow: ");
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
         
        sc.nextLine();
        while (true) {
            System.out.print("\nEnter Patron ID: ");
            if (sc.hasNextInt()) {
                pid = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
        }
       
         while ((conf.getSingleValue("SELECT patron_id FROM patrons WHERE patron_id = ?", pid)) == 0){
            System.out.println("Selected Patron ID doesn't exist!");
            while (true) {
            System.out.print("Enter Patron ID again: ");
            if (sc.hasNextInt()) {
                pid = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
            }
       }
         
        System.out.print("Date Borrow (mm/dd/yy): ");
        String db = sc.next();
        
        String sql = "INSERT INTO borrowed_books (book_id, patron_id, date_borrowed) VALUES (?, ?, ?)";
        conf.addRecord(sql, bookId, pid, db);
        
        sql = "UPDATE books SET copies = copies - 1 WHERE book_id = ?";
        conf.updateRecord2(sql, bookId);
    }

    public void returnBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int bookId, pid;

         while (true) {
            System.out.print("Enter Book ID to Return: ");
            if (sc.hasNextInt()) {
                bookId = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
        }
       
         while ((conf.getSingleValue("SELECT book_id FROM borrowed_books WHERE book_id = ?", bookId)) == 0){
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
        
        while (true) {
            System.out.print("Enter Patron ID: ");
            if (sc.hasNextInt()) {
                pid = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
        }
       
         while ((conf.getSingleValue("SELECT patron_id FROM patrons WHERE patron_id = ?", pid)) == 0){
            System.out.println("Selected Patron ID doesn't exist!");
            while (true) {
            System.out.print("Enter Patron ID again: ");
            if (sc.hasNextInt()) {
                pid = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid ID.");
                sc.next();
            }
            }
       }
        System.out.print("Date Return (mm/dd/yy): ");
        String rb = sc.next();
        
        String sql = "INSERT INTO returned_books (book_id, patron_id, date_returned) VALUES (?, ?, ?)";
        conf.addRecord(sql, bookId, pid, rb);
        
        sql = "UPDATE books SET copies = copies + 1 WHERE book_id = ?";
        conf.updateRecord2(sql, bookId);
    }

    public void viewBRbooks() {
        String query = "SELECT books.book_id, books.title, patrons.patron_id, patrons.last_name, borrowed_books.date_borrowed "
                + "FROM borrowed_books INNER JOIN books ON books.book_id = borrowed_books.book_id INNER JOIN patrons ON patrons.patron_id = borrowed_books.patron_id";
        String[] headers = {"Book ID", "Title", "Patron Name", "Date Borrowed"};
        String[] columns = {"book_id", "title", "last_name", "date_borrowed"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
    
public void viewRBbooks() {
        String query = "SELECT books.book_id, books.title, patrons.patron_id, patrons.last_name, returned_books.date_returned "
                     + "FROM returned_books "
                     + "INNER JOIN books ON books.book_id = returned_books.book_id "
                     + "INNER JOIN patrons ON patrons.patron_id = returned_books.patron_id";

        String[] headers = {"Book ID", "Title", "Patron Name", "Date Returned"};
        String[] columns = {"book_id", "title",  "last_name", "date_returned"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
        
    public void deleteBRbook() {
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
       
         while ((conf.getSingleValue("SELECT book_id FROM borrowed_books WHERE book_id = ?", bookId)) == 0){
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

        String sql = "DELETE FROM borrowed_books WHERE book_id = ?";
        conf.deleteRecord(sql, bookId);
    }
    
    public void deleteRBbook() {
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
       
         while ((conf.getSingleValue("SELECT book_id FROM returned_books WHERE book_id = ?", bookId)) == 0){
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

        String sql = "DELETE FROM returned_books WHERE book_id = ?";
        conf.deleteRecord(sql, bookId);
    }

    public void libraryMenu() {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        Book bk = new Book();
        Patrons pt = new Patrons();

        int choice;
        boolean exit = true;

        do {
            System.out.println("\n------------ LIBRARY -------------");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Borrowed and Returned Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.println("---------------------------------");
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
                    System.out.println("\n---- BOOK INFORMATION ----");
                    bk.viewBooks();
                    System.out.println("\n---- PATRON INFORMATION ----");
                    pt.viewPatrons();
                    library.borrowBook();
                    break;
                case 2:
                    System.out.println("----- BOOK BORROWED -----");
                    library.viewBRbooks();
                    System.out.println("\n---- PATRON INFORMATION ----");
                    pt.viewPatrons();
                    library.returnBook();
                    break;
                case 3:
                    System.out.println("----- BOOK BORROWED -----");
                    library.viewBRbooks();
                    System.out.println("\n---- BOOK RETURNED ----");
                    library.viewRBbooks();
                    break;
                case 4:
                    System.out.print("Delete Borrowed Books? (yes/no): ");
                    String bbres = sc.next();
                     if (bbres.equalsIgnoreCase("yes")) {
                        library.deleteBRbook();
                    };
                    
                    System.out.print("Delete Returned Books? (yes/no): ");
                    String brres = sc.next();
                     if (brres.equalsIgnoreCase("yes")) {
                        library.deleteRBbook();
                    };
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