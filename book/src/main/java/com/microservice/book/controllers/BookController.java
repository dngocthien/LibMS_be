package com.microservice.book.controllers;

import com.microservice.book.dto.BookDto;
import com.microservice.book.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookFacade facade;

    @GetMapping("/books")
    public List<BookDto> findAllBooks() {
        return facade.getAllBooks();
    }

    @GetMapping("/books/none")
    public List<BookDto> findNoneBooks() {
        return facade.getNoneBooks();
    }

    @GetMapping("/books/{text}")
    public List<BookDto> findBooksByName(@PathVariable String text) {
        return facade.getBookByTitle(text);
    }

//    @GetMapping("books/users/{id}")
//    public List<BookDto> findUserBorrowsById(@PathVariable Integer id){
//        return facade.getUserBorrowsById(id);
//    }

    @PostMapping("/books")
    public BookDto saveBook(@RequestBody BookDto dto){
        return facade.saveBook(dto);
    }

    @PutMapping("/books/{id}")
    public BookDto updateBook(@PathVariable Integer id, @RequestBody BookDto dto){
        return facade.updateBook(id, dto);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id){
        facade.deleteBook(id);
    }
}
