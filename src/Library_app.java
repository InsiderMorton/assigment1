import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Library_app {
ArrayList<Book> books = new ArrayList<>();
Scanner scanner = new Scanner(System.in);

private boolean active = true;

public void run() {
    while(active){
        System.out.println("Welcome to Library App!\n" +
                "1. Print all books\n" +
                "2. Add new book\n" +
                "3. Search books by title\n" +
                "4. Borrow a book\n" +
                "5. Return a book\n" +
                "6. Delete a book by id\n" +
                "7. Quit\n");
        int choice=scanner.nextInt();

        switch (choice) {
            case 1:printAllBooks();
            break;
            case 2:addNewBook();
            break;
            case 3:searchBooksByTitle();
            break;
            case 4:borrowABook();
            break;
            case 5:returnABook();
            break;
            case 6:deleteABook();
            break;

        }
    }
}
public void printAllBooks() {
    if(!books.isEmpty()) {
        System.out.println(books);
    }
    else {
        System.out.println("No books in the library");
    }
}

public void addNewBook() {
    Book newBook=new Book();
    System.out.println("Write the title");
    newBook.setTitle(scanner.nextLine());
    System.out.println("Write the Author");
    newBook.setAuthor(scanner.nextLine());
    System.out.println("Write the Year");
    newBook.setYear(scanner.nextInt());

    books.add(newBook);

}

public void searchBooksByTitle() {
    System.out.println("Write a part of the title");
    String partTitle=scanner.nextLine().toLowerCase();
    boolean found=false;
    for(Book book:books) {
        if(book.getTitle().toLowerCase().contains(partTitle)) {
            System.out.println(book);
            found=true;
        }

    }
    if(found==false) {
        System.out.println("Books are not found");
    }



}
public void borrowABook() {
    System.out.println("write the id of book");
    int id=scanner.nextInt();
    boolean found=false;
    for(Book book:books) {
        if(id==book.getID()) {
            found=true;
            if(book.getAvailable()==true) {
                book.markAsBorrowed();
            }
            else{System.out.println("Book is not available");
            }
        }
    }
    if (found==false) {
        System.out.println("Book is not found");
    }


    }
public void returnABook() {
    System.out.println("Write the id of the book");
    int id=scanner.nextInt();
    boolean found=false;
    for(Book book:books) {
        if(id==book.getID()) {
            found=true;
            if(book.getAvailable()==false) {
                book.markAsReturned();
            }
            else{System.out.println("Book is not borrowed");
            }
        }
    }
    if (found==false) {
        System.out.println("Book is not found");
    }
}

public void deleteABook() {
    System.out.println("write the id of book");
    int id=scanner.nextInt();
    boolean found=false;
    for(int i=0; i<books.size();i++) {
        if(id==books.get(i).getID()) {
            found=true;
            books.remove(i);
            break;
        }
    }
    if (found==false) {
        System.out.println("Book is not found");
    }
}

public void quit() {
    active=false;
}

}
