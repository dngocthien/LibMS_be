package com.microservice.book.controllers;

import com.microservice.book.dto.BookDto;
import com.microservice.book.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookFacade facade;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> findAllBooks(HttpServletResponse response) {
        response.addHeader("*", "http://localhost:3000/");
        return new ResponseEntity<>(facade.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/books/none")
    public List<BookDto> findNoneBooks() {
        return facade.getNoneBooks();
    }

    @GetMapping("/books/{text}")
    public List<BookDto> findBooksByName(@PathVariable String text) {
        return facade.getBookByTitle(text);
    }

    @GetMapping("/books/id/{id}")
    public List<BookDto> findBooksById(@PathVariable Integer id) {
        List<BookDto> list = new ArrayList<>();
        list.add(facade.getBookById(id));
        return list;
    }

    @PostMapping("/books")
    public BookDto saveBook(@RequestBody BookDto dto) {
        return facade.saveBook(dto);
    }

    @PutMapping("/books/{id}")
    public BookDto updateBook(@PathVariable Integer id, @RequestBody BookDto dto) {
        return facade.updateBook(id, dto);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id, HttpServletResponse response) {
        facade.deleteBook(id);
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000/");
        return new ResponseEntity<>("Remove book " + id, HttpStatus.OK);
//        return response;
    }
}
