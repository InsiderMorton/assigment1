public class Book {
    private int id;
    private static int idGen;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        id = idGen++;
        available = true;
    }

    public Book(String title, String author, int year) {
        this();


    }

    public void setTitle(String title) {
        if (title != null) {
            if (!title.isEmpty()) {
                this.title = title;
            } else {
                throw new IllegalArgumentException("You cant put to title nothing");
            }
        } else {
            throw new IllegalArgumentException("You cant put to title nothing");
        }
    }

    public void setAuthor(String author) {
        if (author != null) {
            if (!author.isEmpty()) {
                this.author = author;
            } else {
                throw new IllegalArgumentException("You cant put to Author nothing");
            }
        } else {
            throw new IllegalArgumentException("You cant put to Author nothing");
        }
    }

    public void setYear(int year) {
        if (year >= 1500 && year <= 2025) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Write reasonable year");
        }


    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void markAsBorrowed() {
        available = false;
    }

    public void  markAsReturned() {
        available = true;
    }

    public int getID() {
        return id;
    }
    public boolean getAvailable() {
        return available;
    }
    @Override
    public String toString () {
        return "Rectangle id=" +id +", Title=" +title + ", Author=" +author +", Year+" +year;
    }






}

