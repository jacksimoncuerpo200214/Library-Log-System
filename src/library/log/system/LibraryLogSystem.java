package library.log.system;

import java.util.Scanner;

public class LibraryLogSystem {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int chose, act;
        boolean exit = true;
do{ 
        System.out.println("\n------ Library Log System ------");
        System.out.println("| 1. BOOKS                     |");
        System.out.println("| 2. PATRONS                   |");
        System.out.println("| 3. LIBRARY                   |");
        System.out.println("| 4. EXIT                      |");
        System.out.println("-------------------------------");
        while (true) {
            System.out.print("Enter Choice: ");
            if (sc.hasNextInt()) {
                chose = sc.nextInt();
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
            
            switch(chose){
            case 1:
                Book bk = new Book();
                bk.libraryMenu();
            break;
              
            case 2:
                Patrons ps = new Patrons();
                ps.patronMenu();
                break;

            case 3:
                Library lbr = new Library();
                lbr.libraryMenu();
                break;
                
            case 4:
                System.out.print("Do you want to exit? (yes/no): ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                    exit = false;
                    }
                break;
                
                default:
                    System.out.println("Error Choice!");
            }
        } while(exit);
        System.out.println("Thank you for using the System");
    }
    
}
