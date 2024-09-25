package library_mangement_system;
public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        if (title.isEmpty() || author.isEmpty()) {
            throw new InvalidBookException("Title or author cannot be empty.");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new InvalidBookException("Title cannot be empty.");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new InvalidBookException("Author cannot be empty.");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", ISBN: \"" + isbn + "\"";
    }
}
