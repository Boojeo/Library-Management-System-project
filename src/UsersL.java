package src;
import java.util.ArrayList;

public class UsersL {
	
	private int user_id;
	private String name;
	private ArrayList<BookL> user_borrowed_books;
	
	UsersL(int id , String name ) {
		this.user_id = id;
		this.name = name;
		this.user_borrowed_books = new ArrayList<>();
	}
	
	// getters 
	
	public int get_id() {
		return this.user_id;
	}
	
	public String get_name() {
		return this.name;
	}
	public ArrayList<BookL> get_borrowed_books() {
		return user_borrowed_books;
	}
	
	// Setter
	
	public void set_name(String name) {
		this.name = name;
	}
	
	
	// Borrow Book
	public boolean Borrow(BookL book) {
		if(user_borrowed_books.size() < 3) {
			if(book.get_available_copies() > 0) {
				book.set_available(book.get_available_copies()-1);
				user_borrowed_books.add(book);	
				return true;
				
			}else {
				return false;
			}
			
 		}else {
			System.out.println("Sorry Library Policy to take only 3 Books per Person");
			return false;
		}
	}
	
	// Return Book
	public boolean ReturnBook(BookL book) {
		if(user_borrowed_books.contains(book)) {
			book.return_book();
			user_borrowed_books.remove(book);
			return true;
		}else {
			return false;
		}
	}
	
	

}

