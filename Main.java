package library_mangement_system;
import java.util.*;
import java.lang.*;
public class Main {    public static void main(String[] args) {
    Library library = new Library();
    Scanner sc = new Scanner(System.in);


    boolean exit = false; 
    while (!exit) {
        System.out.println("Welcome to the library management system.");
        System.out.println("Please select the type of the user: ");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.println("3. Exit");


        int type = sc.nextInt();
        sc.nextLine();


        switch (type) {
            case 1:
                student(library, sc);
                break;
            case 2:
                faculty(library, sc);
                break;  // <-- Missing break statement added here
            case 3:
                exit = true;
                System.out.println("Thank you for using the Library Management System");
                break;
            default:
                System.out.println("Invalid choice, please select a valid option");
        }
    }
    sc.close();
} 


private static void faculty(Library library, Scanner sc) {
    LibraryUser faculty = new Faculty("Tanvir Azhar", "TAZ124", "CSE");
    boolean fe = false;
    while (!fe) {
        faculty.printUserInfo();
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Sort books");
        System.out.println("5. Exit");


        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                borrowbook(library, sc, faculty);
                break;
            case 2:
                returnbook(library, sc, faculty);
                break;
            case 3:
                searchBook(library, sc);
                break;
            case 4:
                sortBooks(library, sc);
                break;
            case 5:
                fe = true;
                break;
            default:
                System.out.println("Invalid choice, please select a valid option");
        }
    }
}


private static void student(Library library, Scanner sc) {
    LibraryUser student = new Student("Tausif Akbar", "232010012", "CSE");
    boolean se = false;
    while (!se) {
        student.printUserInfo();
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Sort books");
        System.out.println("5. Exit");


        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                borrowbook(library, sc, student);
                break;
            case 2:
                returnbook(library, sc, student);
                break;
            case 3:
                searchBook(library, sc);
                break;
            case 4:
                sortBooks(library, sc);
                break;
            case 5:
                se = true;
                System.out.println("Thank you for using the Library Management System\n\n");
                break;
            default:
                System.out.println("Invalid choice, please select a valid option");
        	}
        }
    }



	private static void returnbook(Library library, Scanner sc, LibraryUser faculty) {
		// TODO Auto-generated method stub
		System.out.print("Enter the ISBN of the book: ");
    	String returnisbn=sc.nextLine();
    	try {
    		library.returnbook(new Book("Dummy Title","Dummy Author",returnisbn));
    	}
    	catch(InvalidBookException e) {
    		System.out.println(e.getMessage());
    	}
	}

	private static void borrowbook(Library library, Scanner sc, LibraryUser user) {
		// TODO Auto-generated method stub
		System.out.print("Enter the book title: ");
    	String title=sc.nextLine();
    	System.out.println("Enter book Author: ");
    	String author=sc.nextLine();
    	System.out.println("Enter the book ISBN: ");
    	String isbn=sc.nextLine();
    	
    	try {
    		Book book =new Book(title,author,isbn);
    		library.checkoutbooks(isbn);
    		user.borrowbook(book);
    	}
    	catch(BookNotFoundException | InvalidBookException e) {
    		System.out.println(e.getMessage());
    	}
	}

	private static void searchBook(Library library, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Etner keyword");
    	String keyword= sc.nextLine();
    	Book foundBook= library.searchBook(keyword);
    	if(foundBook !=null) {
    		System.out.println("Book found "+ foundBook);
    	}
    	else {
    		System.out.println("No results");
    	}
    	
	}
	private static void addBook(Library library, Scanner sc) {
		System.out.print("Enter book title to add:");
		String addtitle=sc.nextLine();
		System.out.print("Enter book auhtor:");
		String addauthor=sc.nextLine();
		System.out.print("Enter book ISBN");
		String addisbn= sc.nextLine();
		try {
			library.addBook(new Book(addtitle, addauthor, addisbn));
		}
		catch(InvalidBookException e) {
			System.out.println(e.getMessage());
		}
	}

	

	private static void sortBooks(Library library, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Choose sorting option:");
		System.out.println("1. Sort by Title");
		System.out.println("2. Sort by Author");
		System.out.println("3. Sort by ISBN");
		
		int sortchoice = sc.nextInt();
		sc.nextLine();
		
		switch(sortchoice) {
		case 1:
			library.sortbooksTitle();
			break;
		case 2:
			library.sortbooksAuthor();
			break;
		case 3:
			library.sorbooksISBN();
		default:
			System.out.println("Invalid sorting option");
		}
		
		List<Book>sortBooks = library.getBooks();
		for(Book book : sortBooks) {
			System.out.println(book);
		}
	}
}
