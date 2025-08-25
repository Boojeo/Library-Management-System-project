package src;

public class BookL {
	private int book_id;
	private String book_name;
	private String author;
	private int total_copies;
	private int available_copies;
	
	BookL(int id, String name, String author, int copies) {
		this.book_id = id;
		this.book_name = name;
		this.author = author;
		this.available_copies+=copies;
		this.total_copies+=copies;		
	}
	// Getters
	int get_id() {
		return book_id;
	}
	String get_name() {
		return book_name;
	}
	String get_author() {
		return author;
	}
	int get_total_copies() {
		return total_copies;
	}
	int get_available_copies() {
		return available_copies;
	}
	
	// Setters
	
	void set_name(String name) {
		this.book_name = name;
	}
	void set_author(String author) {
		this.author = author;
	}
	
	void set_total(int total) {
		this.total_copies = total;
	}
	void set_available(int available) {
		this.available_copies = available;
	}
	
	public boolean borrow_book() {
		if(available_copies >0) {
			available_copies--;
			return true;
		}else {
			return false;
			
		}
		
	}
	public boolean return_book() {
		if(available_copies < total_copies) {
			available_copies++;
			return true;
		}else {
			return false;

		}
	}
	
	public void display() {
		System.out.println("*".repeat(40) );
		System.out.println("Book Id: " + this.book_id);
		System.out.println("Book Name: " + this.book_name);
		System.out.println("Book Author: " + this.author);
		System.out.println("No of Copies: " + this.available_copies);
		System.out.println("No of Available Copies: " + this.available_copies);
		System.out.println("*".repeat(40) );
	}
	
	}

