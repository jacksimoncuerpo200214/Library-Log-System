package utils;

public class BorrowRecord {
    private String borrowerName;
    private String email;
    private String phone;
    private String address;
    private String bookTitle;
    private String author;
    private String isbn;
    private String borrowDate;
    private String returnDate;
    private String status;

    public BorrowRecord(String borrowerName, String email, String phone, String address,
                        String bookTitle, String author, String isbn,
                        String borrowDate, String returnDate, String status) {
        this.borrowerName = borrowerName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bookTitle = bookTitle;
        this.author = author;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }
}
