import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }
}

public void addBook(Book book) {
    books.add(book);
    System.out.println("Book added: " + book.getTitle());
}

public void removeBook(int bookId) {
    books.removeIf(book -> book.getId() == bookId);
    System.out.println("Book removed with ID: " + bookId);
}

public void registerMember(Member member) {
    members.add(member);
    System.out.println("Member registered: " + member.getName());
}

public void removeMember(int memberId) {
    members.removeIf(member -> member.getId() == memberId);
    System.out.println("Member removed with ID: " + memberId);
}

public Book searchBook(int bookId) {
    return books.stream().filter(book -> book.getId() == bookId).findFirst().orElse(null);
}

public Member searchMember(int memberId) {
    return members.stream().filter(member -> member.getId() == memberId).findFirst().orElse(null);
}

public void lendBook(int bookId, int memberId) {
    Book book = searchBook(bookId);
    Member member = searchMember(memberId);

    if (book != null && member != null && !book.isLent()) {
        book.setLent(true);
        member.borrowBook(book);
        System.out.println("Book lent: " + book.getTitle() + " to " + member.getName());
    } else {
        System.out.println("Cannot lend book.");
    }
}

public void returnBook(int bookId, int memberId) {
    Book book = searchBook(bookId);
    Member member = searchMember(memberId);

    if (book != null && member != null && book.isLent()) {
        book.setLent(false);
        member.returnBook(book);
        System.out.println("Book returned: " + book.getTitle() + " from " + member.getName());
    } else {
        System.out.println("Cannot return book.");
    }
}

public void displayBooks() {
    System.out.println("Books in Library:");
    for (Book book : books) {
        System.out.println(book.getInfo());
    }
}

public void displayMembers() {
    System.out.println("Registered Members:");
    for (Member member : members) {
        System.out.println(member.getInfo());
    }
}

public void viewLendingInfo() {
    for (Member member : members) {
        System.out.println(member.getInfo() + " borrowed: " + member.getBorrowedBooks());
    }
}

public void displayOverdueBooks() {
}

public double calculateFine(int daysOverdue) {
    if (daysOverdue <= 7) {
        return daysOverdue * 50;
    } else {
        return (7 * 50) + ((daysOverdue - 7) * 100);
    }
}