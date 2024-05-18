package Projects;

public class Runner {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(library);
        libraryManagementSystem.run();
    }
}
