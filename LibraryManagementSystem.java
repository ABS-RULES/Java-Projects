import java.util.*;

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Library Management System!");
        System.out.println("Type 'help' for available commands.");

        while (true) {
            System.out.print("\nEnter command: ");
            input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "help":
                    printHelp();
                    break;
                case "view":
                    library.displayBooks();
                    break;
                case "borrow":
                    borrowBook(library, scanner);
                    break;
                case "return":
                    returnBook(library, scanner);
                    break;
                case "exit":
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for assistance.");
            }
        }
    }

    private static void printHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help   - Show this help message.");
        System.out.println("  view   - View all books in the library.");
        System.out.println("  borrow - Borrow a book from the library.");
        System.out.println("  return - Return a borrowed book.");
        System.out.println("  exit   - Exit the system.");
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = library.findBook(title);

        if (book == null) {
            System.out.println("The book titled '" + title + "' is not available in the library.");
        } else if (!book.isAvailable()) {
            System.out.println("The book '" + title + "' is already borrowed.");
        } else {
            book.borrowBook();
            System.out.println("You have successfully borrowed '" + title + "'.");
        }
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        Book book = library.findBook(title);

        if (book == null) {
            System.out.println("The book titled '" + title + "' is not recognized.");
        } else if (book.isAvailable()) {
            System.out.println("The book '" + title + "' is not currently borrowed.");
        } else {
            book.returnBook();
            System.out.println("You have successfully returned '" + title + "'.");
        }
    }
}

// Library Class
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        initializeLibrary();
    }

    private void initializeLibrary() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
        books.add(new Book("Moby Dick", "Herman Melville"));
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (!isAvailable) {
            throw new IllegalStateException("The book is already borrowed.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("The book is not borrowed.");
        }
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}

