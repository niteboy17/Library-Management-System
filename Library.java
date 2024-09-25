package library_mangement_system;
import java.util.*;

public class Library implements Searchable {
	public List<Book>books;
	
	public Library() {
		books =new ArrayList<>();
		
		try {
			books.add(new Book("Java Thre Complete Reference","Herbert Schildt","OOP124"));
			books.add(new Book("Programming With C","Gottfried","SPL114"));
			books.add(new Book("Object Oriented Programming Using Java","Xiaoping Jia","OOP123"));
		}
		catch(InvalidBookException e){
			System.out.println("Error adding book: "+e);
		}
	}
	public void addBook(Book book) throws InvalidBookException{
		if(book.getTitle()==null|| book.getAuthor()==null||book.getIsbn()==null) {
			throw new InvalidBookException("Invalid detail");
		}
		books.add(book);
	}
	public Book searchBook(String keyword) {
		for(Book book: books) {
			if(book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) || book.getIsbn().contains(keyword)) {
				return book;
			}
		}
		return null;
	}
	
	public void checkoutbooks(String isbn) throws BookNotFoundException{
		Book booktoborrow = searchBook(isbn);
		if(booktoborrow == null) {
			throw new BookNotFoundException("The book of "+isbn+" ISBN is not found");			
		}
		books.remove(booktoborrow);
	}
	public void returnbook(Book book) throws InvalidBookException{
		if(book == null || book.getIsbn() == null) {
			throw new InvalidBookException("Invalid book details");
		}
		books.add(book);
	}
	public void sortbooksTitle() {
		books.sort((b1,b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));	
	}
	public void sortbooksAuthor() {
		books.sort((b1,b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
	}
	public void sorbooksISBN() {
		books.sort((b1,b2) -> b1.getIsbn().compareToIgnoreCase(b2.getIsbn()));
	}
	public List<Book>getBooks(){
		return books;
	}
}
