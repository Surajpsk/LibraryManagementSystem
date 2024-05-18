package Projects;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Book Management
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Member Management
    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public Member searchMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    // Lending System
    public void issueBook(String isbn, int memberId) {
        Book book = searchBookByISBN(isbn);
        Member member = searchMemberById(memberId);

        if (book != null && member != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            member.getBorrowedBooks().add(book);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Cannot issue book.");
        }
    }

    public void returnBook(String isbn, int memberId) {
        Book book = searchBookByISBN(isbn);
        Member member = searchMemberById(memberId);

        if (book != null && member != null && book.isBorrowed()) {
            book.setBorrowed(false);
            member.getBorrowedBooks().remove(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Cannot return book.");
        }
    }

    // Reports
    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listAllMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void listBorrowedBooks() {
        for (Book book : books) {
            if (book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
}

