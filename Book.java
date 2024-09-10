import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isLent;
    private LocalDate dueDate;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isLent = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getInfo() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Lent: " + isLent;
    }
}