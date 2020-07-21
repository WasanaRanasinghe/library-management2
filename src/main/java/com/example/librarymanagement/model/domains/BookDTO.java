package com.example.librarymanagement.model.domains;

import com.example.librarymanagement.model.persistance.Status;

public class BookDTO {

    private Long bookId;
    private String bookTitle;
    private String language;
    private Status availabilityStatus;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Status getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Status availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
