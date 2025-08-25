package def;
import java.util.Scanner;
public class LibraryMain {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryL library = new LibraryL(); 
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Welcome to Our Library Management System ---");
            System.out.println("You can choose one of these Numbers");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Display All Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
			case 0:
				running = false;
				System.out.println("\nSee You Soon, Good Bye ");
				break;
			
			case 1: 
				library.addBook(inputBook(sc));
				break;
			case 2: 
				System.out.println("Enter Book Id to Remove");
				int id1 = sc.nextInt();
				library.removeBook(id1);
				break;
			case 3: 
				library.registerUser(inputUser(sc));
				break;
			case 4: 
				System.out.println("To Borrow A Book You Need UserId and BookId");
				System.out.print("Enter User Id: ");
				int userId1 = sc.nextInt();
				System.out.print("Enter Book Id: ");
				int bookId = sc.nextInt();
				library.borrowBook(userId1, bookId);
				break;
			case 5: 
				System.out.println("To Return A Book You Need UserId and BookId");
				System.out.print("Enter User Id: ");
				int userId2 = sc.nextInt();
				System.out.print("Enter Book Id: ");
				int bookId1 = sc.nextInt();
				library.returnBook(userId2, bookId1);
				break;
			case 6: 
				library.displayAllBooks();
				break;
			case 7: 
				library.displayAllUsers();
				break;
			default:
				System.out.println("Invalid input. Exiting for safety.");
				running = false;
				break;
			}
            
	}
        sc.close();

	}
	
	public static BookL inputBook(Scanner sc) {
	    System.out.println("Enter Book Details");

	    System.out.print("Book Id: ");
	    int id = sc.nextInt();
	    sc.nextLine(); // flush newline

	    System.out.print("Book Title: ");
	    String name = sc.nextLine();

	    System.out.print("Author Name : ");
	    String author = sc.nextLine();

	    System.out.print("Total Copies : ");
	    int totalCopies = sc.nextInt();

	    return new BookL(id, name, author, totalCopies);
	}
	
	public static UsersL inputUser(Scanner sc) {
	    System.out.print("User Id: ");
	    int userId = sc.nextInt();
	    sc.nextLine();

	    System.out.print("User Name: ");
	    String userName = sc.nextLine();

	    return new UsersL(userId, userName);
	}
	
	}
