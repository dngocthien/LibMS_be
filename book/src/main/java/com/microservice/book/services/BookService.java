package com.microservice.book.services;

import com.microservice.book.entities.Book;
import com.microservice.book.iservices.IBookService;
import com.microservice.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepo repository;
//    @Autowired
//    private BorrowService borrowService;

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll();
    }

    @Override
    public List<Book> getNoneBooks() {
        return repository.findByNone();
    }

    @Override
    public Book getBookByID(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getBookByTitle(String text) {
        return repository.findByTitleLike(text);
    }

//    @Override
//    public List<Book> getNotReturnedByUserId(Integer id) {
//        List<Book> bookList = new ArrayList<>();
//        List<Borrow> borrowList = borrowService.getNotReturnedByUserId(id);
//        for(Borrow borrow: borrowList){
//            bookList.add(getBookByID(borrow.getBookId()));
//        }
//        return bookList;
//    }

    @Override
    public void deleteBook(Integer id) {
        repository.deleteById(id);
    }
}
