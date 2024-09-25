package library_mangement_system;
public class Faculty extends LibraryUser {
	private String dep;
    public Faculty(String name, String id, String dep) {
        super(name, id, "Faculty");
        this.dep=dep;
    }
    public String getDep() {
    	return dep; 
    }
    public void setDep(String dep) {
    	this.dep=dep; 
    }
    public void borrowbook(Book book) {
    	System.out.println(getName()+" Faculty of "+getDep()+"has borrowed the book: "+book.getTitle());
    }
    public void returnbook(Book book) {
    	System.out.println(getName()+" Faculty of "+getDep()+" has returned the book '"+book.getTitle()+"'");
    }
    @Override
    public void printUserInfo() {
        System.out.println("Faculty Name: " + getName() + ", ID: " + getId()+"Department: "+ getDep());
    }
}