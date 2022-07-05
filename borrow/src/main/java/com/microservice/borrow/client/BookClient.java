package com.microservice.borrow.client;

import com.microservice.borrow.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TransactionClient", url = "${client.post.book}")
public interface BookClient {

    @GetMapping("/books")
    ResponseEntity<List<BookDto>> findAllBooks();

    @GetMapping("/books/none")
    ResponseEntity<List<BookDto>> findNoneBooks();

    @GetMapping("/books/{text}")
    ResponseEntity<List<BookDto>> findBooksByName(@PathVariable String text);

    @GetMapping("/books/id/{id}")
    ResponseEntity<List<BookDto>> findBooksById(@PathVariable Integer id);

    @PostMapping("/books")
    ResponseEntity<BookDto> saveBook(@RequestBody BookDto book);

    @PutMapping("/books/{id}")
    ResponseEntity<BookDto> updateBook(@PathVariable Integer id, @RequestBody BookDto dto);

    @PutMapping("/books/quantity/{id}")
    public ResponseEntity<BookDto> updateBookQuantity(@PathVariable Integer id, @RequestBody int q);

    @DeleteMapping("/books/{id}")
    ResponseEntity<String> deleteBook(@PathVariable Integer id);
}
