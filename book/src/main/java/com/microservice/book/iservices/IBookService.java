package com.microservice.book.iservices;

import com.microservice.book.entities.Book;

import java.util.List;

public interface IBookService {

    public Book saveBook(Book book);
    public List<Book> getAllBooks();
    public Book getBookByID(Integer id);
//    public List<Book> getNotReturnedByUserId(Integer id);
    public List<Book> getBookByTitle(String text);
    public void deleteBook(Integer id);
}
