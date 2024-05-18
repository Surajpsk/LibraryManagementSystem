package Projects;

import java.util.Scanner;

public class LibraryManagementSystem {
    private Library library;

    public LibraryManagementSystem(Library library) {
        this.library = library;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. List All Books");
            System.out.println("8. List All Members");
            System.out.println("9. List Borrowed Books");
            System.out.println("10. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    isbn = scanner.nextLine();
                    Book book = library.searchBookByISBN(isbn);
                    if (book != null) {
                        library.removeBook(book);
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addMember(new Member(name, memberId));
                    break;
                case 4:
                    System.out.print("Enter member ID to remove: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Member member = library.searchMemberById(memberId);
                    if (member != null) {
                        library.removeMember(member);
                        System.out.println("Member removed.");
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter book ISBN to issue: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.issueBook(isbn, memberId);
                    break;
                case 6:
                    System.out.print("Enter book ISBN to return: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.returnBook(isbn, memberId);
                    break;
                case 7:
                    library.listAllBooks();
                    break;
                case 8:
                    library.listAllMembers();
                    break;
                case 9:
                    library.listBorrowedBooks();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
