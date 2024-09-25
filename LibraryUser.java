package library_mangement_system;
public abstract class LibraryUser {
    private String name;
    private String id;
    private String userType;

    public LibraryUser(String name, String id, String userType) {
        this.name = name;
        this.id = id;
        this.userType = userType;
    }

    //getter methods
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }
    
    //setter methods
    public void setName(String name) {
    	this.name=name;
    }
    public void setId(String id) {
    	this.id=id;
    }
    public void setUserType(String userType) {
    	this.userType=userType;
    }
    
    public abstract void borrowbook(Book book);
    public abstract void returnbook(Book book);
    
    
    public abstract void printUserInfo();
}
