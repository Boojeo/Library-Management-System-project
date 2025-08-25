package src;
import java.util.ArrayList;
public class LibraryL {
	
	private ArrayList<BookL> allBooks = new ArrayList<>();
	private ArrayList<UsersL> allUsers= new ArrayList<>();
	/**
	 * @return the allBooks
	 */
	public ArrayList<BookL> getAllBooks() {
		return allBooks;
	}
	/**
	 * @param allBooks the allBooks to set
	 */
	public void setAllBooks(ArrayList<BookL> allBooks) {
		this.allBooks = allBooks;
	}
	/**
	 * @return the allUsers
	 */
	public ArrayList<UsersL> getAllUsers() {
		return allUsers;
	}
	/**
	 * @param allUsers the allUsers to set
	 */
	public void setAllUsers(ArrayList<UsersL> allUsers) {
		this.allUsers = allUsers;
	}
	// Book Class Methods
	
	void addBook(BookL book) {
		allBooks.add(book);
		System.out.println("Book Added to Library");
	}
	
	void removeBook(int bookId) {
		BookL book = null;
		for(BookL b : allBooks) {
			if(b.get_id() == bookId) {
				book = b;
				break;
			}
		}
		
		if(book != null) {
	        allBooks.remove(book);
	        System.out.println("Book removed from Library");
		}else {
			System.out.println("Sorry, We don't have this Book Id");
		}
		
	}
	
	BookL findBookById(int bookId) {
		for(BookL b : allBooks) {
			if(b.get_id() == bookId) {
				return b;
			}
		}
		
		System.out.println("Sorry, We don't have this Book Id");
		return null;
	}
	
	// Users Class Methods
	
	void registerUser(UsersL user) {
		allUsers.add(user);
	}
	
	UsersL findUserByID(int userId) {
		for(UsersL U : allUsers) {
			if(U.get_id() == userId) {
				return U;
			}
		}
			System.out.println("Sorry, We don't have this User Id");
			return null;
		}
	
	// Connecting Books Class With Users Class
	
	void borrowBook(int userId, int bookId) {
		BookL neededBook = findBookById(bookId);
		UsersL user = this.findUserByID(userId);
		
		if (user != null && neededBook != null) {
		    if (user.Borrow(neededBook)) {
		        System.out.println("Enjoy Your Book");
		    } else {
		        System.out.println("Sorry, you may have reached your book limit or the book is unavailable.");
		    }
		}
		
		
	}
	
	void returnBook(int userId, int bookId) {
		BookL neededBook = this.findBookById(bookId);
		UsersL user = this.findUserByID(userId);
		
		if(user.ReturnBook(neededBook)) {
			System.out.println("Thank You For Returning The Book");

		}else {
			System.out.println("We Have All copies in Our Library");

		}
		
	}
	// Library Unique Methods
	
	void displayAllBooks() {
		if(allBooks.size() > 0) {
			int count = 1;
			for (BookL book : allBooks) {
			    System.out.println("*".repeat(50));
			    System.out.println("Book NO " + count++);
			    book.display();
			    System.out.println("*".repeat(50));
			}
		}else {
			System.out.println("Sorry, We Don't have any Books Now");
		}
		
	}
	
	void displayAllUsers() {
		if(allUsers.size() > 0) {
			for (int i = 1; i <= allUsers.size() ; i++) {
				System.out.println("*".repeat(50));
				System.out.println(allUsers.get(i-1).get_id());
				System.out.println(allUsers.get(i-1).get_name());
				System.out.println("*".repeat(50));
			}
		}else {
			System.out.println("Sorry, We Don't have any Users Now");
		}
	}

}

