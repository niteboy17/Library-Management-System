package library_mangement_system;
import java.util.*;
import junit.framework.*;

public class LibraryTest extends TestCase { 
	private Library library;
	private Book book1;
	private Book book2;
	
	protected void setUp() throws Exception{
		super.setUp();
		library = new Library();
		book1 = new Book("BOOK1","AUTHOR1","11111");
		book2 = new Book("BOOK2","AUTHOR2","22222");
		library.addBook(book1);
		library.addBook(book2);
	}
	
	protected void tearDown() throws Exception{
		library = null;
		book1= null;
		book2= null;
		super .tearDown();
	}
	public void testAddBook() {
		try {
			Book newBook = new Book("New Book","New Author","New ISBN");
		}
		catch(InvalidBookException e) {
			fail("Exception should not be thrown");
		}
	}
	public void testSearchBook() {
		Book foundBook = library.searchBook("BOOK1");
		assertNotNull("Book should be found",foundBook);
		assertEquals("BOOK1", foundBook.getTitle());
	}
	public void testSearchNonExistentBook() {
		Book foundBook = library.searchBook("NonExistent Book");
		assertNull("Book should not be found", foundBook);
	}
	public void testBorrowBook() {
		try {
			library.checkoutbooks("11111");
			Book foundBook = library.searchBook("BOOK1");
			assertNull("Book should not be found after borrowing ", foundBook);
		}
		catch(BookNotFoundException e) {
			fail("Exception should not be thrown");
		}
	}
	public void testReturnBook() {
		try {
			library.checkoutbooks("11111");
			Book dummyBook = new Book("Dumme title", "Dummy author", "Dummy isbn");
			library.returnbook(dummyBook);
			Book foundBook = library.searchBook("BOOk1");
			assertNotNull("Book should be found after returning",foundBook);
		}
		catch(BookNotFoundException | InvalidBookException e) {
			fail("Exception should not be thrown");
		}
	}
	public void testSortBookByTitle() {
		library.sortbooksTitle();
		List<Book>books= library.getBooks();
		assertEquals("All good",books.get(0).getTitle());
		assertEquals("BOOK1",books.get(1).getTitle());
	}
	public void testSortBookByAuthor() {
		library.sortbooksAuthor();
		List<Book>books = library.getBooks();
		assertEquals("All good",books.get(0).getAuthor());
		assertEquals("BOOk1",books.get(1).getAuthor());
	}
	public void testSortBookByIsbn() {
		library.sorbooksISBN();
		List<Book>books =library.getBooks();
		assertEquals("All good",books.get(0).getIsbn());
		assertEquals("BOOK1", books.get(1).getIsbn());
	}
}

