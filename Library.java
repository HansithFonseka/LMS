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

public static void main(String[] args) {
    LibraryManagementSystem library = new LibraryManagementSystem();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Library Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Register Member");
        System.out.println("3. Remove Book");
        System.out.println("4. Remove Member");
        System.out.println("5. Search Book Information");
        System.out.println("6. Search Member Information");
        System.out.println("7. Display Book Names");
        System.out.println("8. Display Member Names");
        System.out.println("9. Lend Book");
        System.out.println("10. Return Book");
        System.out.println("11. View Lending Information");
        System.out.println("12. Display Overdue Books");
        System.out.println("13. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter book ID: ");
                int bookId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(bookId, title, author));
                break;
            case 2:
                System.out.print("Enter member ID: ");
                int memberId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter member name: ");
                String memberName = scanner.nextLine();
                library.registerMember(new Member(memberId, memberName));
                break;
            case 3:
                System.out.print("Enter book ID to remove: ");
                int removeBookId = scanner.nextInt();
                library.removeBook(removeBookId);
                break;
            case 4:
                System.out.print("Enter member ID to remove: ");
                int removeMemberId = scanner.nextInt();
                library.removeMember(removeMemberId);
                break;
            case 5:
                System.out.print("Enter book ID to search: ");
                int searchBookId = scanner.nextInt();
                Book foundBook = library.searchBook(searchBookId);
                System.out.println(foundBook != null ? foundBook.getInfo() : "Book not found.");
                break;
            case 6:
                System.out.print("Enter member ID to search: ");
                int searchMemberId = scanner.nextInt();
                Member foundMember = library.searchMember(searchMemberId);
                System.out.println(foundMember != null ? foundMember.getInfo() : "Member not found.");
                break;
            case 7:
                library.displayBooks();
                break;
            case 8:
                library.displayMembers();
                break;
            case 9:
                System.out.print("Enter book ID to lend: ");
                int lendBookId = scanner.nextInt();
                System.out.print("Enter member ID to lend to: ");
                int lendMemberId = scanner.nextInt();
                library.lendBook(lendBookId, lendMemberId);
                break;
            case 10:
                System.out.print("Enter book ID to return: ");
                int returnBookId = scanner.nextInt();
                System.out.print("Enter member ID returning the book: ");
                int returnMemberId = scanner.nextInt();
                library.returnBook(returnBookId, returnMemberId);
                break;
            case 11:
                library.viewLendingInfo();
                break;
            case 12:
                library.displayOverdueBooks();
                break;
            case 13:
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}