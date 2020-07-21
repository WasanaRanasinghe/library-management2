/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.librarymanagement.model.persistance;

import javax.persistence.*;

/**
 *
 * @author Wasana
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    private String language;
    @ManyToOne
    private Status availabilityStatus;

    public Book() {
    }

    public Book(String bookTitle, String language, Status status) {
        this.bookTitle = bookTitle;
        this.language = language;
        this.availabilityStatus = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[bookID=%d, bookTitle='%s', language='%s']",
                bookId, bookTitle, language);
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getLanguage() {
        return language;
    }

    public Status getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Status availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
