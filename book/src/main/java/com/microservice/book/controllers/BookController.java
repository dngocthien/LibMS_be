package com.microservice.book.controllers;

import com.microservice.book.dto.BookDto;
import com.microservice.book.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookFacade facade;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> findAllBooks(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/books/none")
    public ResponseEntity<List<BookDto>> findNoneBooks(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.getNoneBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{text}")
    public ResponseEntity<List<BookDto>> findBooksByName(@PathVariable String text, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.getBookByTitle(text), HttpStatus.OK);
    }

    @GetMapping("/books/id/{id}")
    public ResponseEntity<List<BookDto>> findBooksById(@PathVariable Integer id, HttpServletResponse response) {
        List<BookDto> list = new ArrayList<>();
        list.add(facade.getBookById(id));
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto book, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.saveBook(book), HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Integer id, @RequestBody BookDto dto, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.updateBook(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id, HttpServletResponse response) {
        facade.deleteBook(id);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>("Removed book " + id, HttpStatus.OK);
    }
}
