package library_mangement_system;
public class Student extends LibraryUser {
	private String major;
    public Student(String name, String id, String major) {
        super(name, id, "Faculty");
        this.major=major;
    } 
    public String getMajor() {
    	return major;
    }
    public void setMajor(String major) {
    	this.major=major;
    }
    public void borrowbook(Book book) {
    	System.out.println(getName()+" Student of "+getMajor()+"has borrowed the book: "+book.getTitle());
    }
    public void returnbook(Book book) {
    	System.out.println(getName()+" Studednt of "+getMajor()+" has returned the book '"+book.getTitle()+"'");
    }
    @Override
    public void printUserInfo() {
        System.out.println("Student Name: " + getName() + ", ID: " + getId()+", Department: "+ getMajor());
    }
}