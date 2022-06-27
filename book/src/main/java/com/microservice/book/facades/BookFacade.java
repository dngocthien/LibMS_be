package com.microservice.book.facades;

import com.microservice.book.dto.BookDto;
import com.microservice.book.entities.Author;
import com.microservice.book.entities.Book;
import com.microservice.book.entities.Own;
import com.microservice.book.iservices.IAuthorService;
import com.microservice.book.iservices.IBookService;
import com.microservice.book.iservices.IOwnService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookFacade {
    @Autowired
    private IBookService service;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private IOwnService ownService;

    public BookDto saveBook(@NotNull BookDto dto) {
        // Save book and get book ID

        Book model = service.saveBook(dto2Model(dto));

        // Save author, get author ID and save Own info include authorID and bookID
        for (String name : dto.getAuthors()) {
            Author author = new Author();
            author.setName(name);
            Integer authorId = authorService.saveAuthor(author);

            Own own = new Own();
            own.setAuthorId(authorId);
            own.setBookId(model.getId());
            ownService.saveOwn(own);
        }
        return model2Dto(model);
    }

    public List<BookDto> getAllBooks() {
        List<Book> modelList = service.getAllBooks();
        return addDtoList(modelList);
    }

    public List<BookDto> getNoneBooks() {
        List<Book> modelList = service.getNoneBooks();
        return addDtoList(modelList);
    }

    public BookDto getBookById(Integer id) {
        Book model = service.getBookByID(id);
        return model2Dto(model);
    }

    public List<BookDto> getBookByTitle(@NotNull String text) {
        List<Book> modelList = service.getBookByTitle(text);
        return addDtoList(modelList);
    }

//    public List<BookDto> getUserBorrowsById(Integer id){
//        List<Book> bookList = service.getNotReturnedByUserId(id);
//        return addDtoList(bookList);
//    }

    @Transactional
    public BookDto updateBook(@NotNull Integer id, @NotNull BookDto dto) {
        // Save book and get book ID

        Book model = service.getBookByID(id);
        model.setTitle(dto.getTitle());
        model.setEdition(dto.getEdition());
        model.setPrice(dto.getPrice());
        model.setQuantity(dto.getQuantity());
        model.setCategoryId((dto.getCategoryId()));
        model = service.saveBook(model);

        // Remove old own, Save author, get author ID and save Own info include authorID and bookID
        ownService.deleteOwnByBookId(model.getId());
        for (String name : dto.getAuthors()) {
            Author author = new Author();
            author.setName(name);
            Integer authorId = authorService.saveAuthor(author);

            Own own = new Own();
            own.setAuthorId(authorId);
            own.setBookId(model.getId());
            ownService.saveOwn(own);
            ownService.saveOwn(own);
        }
        return model2Dto(model);
    }

    @Transactional
    public void deleteBook(Integer id) {
        ownService.deleteOwnByBookId(id);
        service.deleteBook(id);
    }

    private Book dto2Model(BookDto dto) {
        Book model = new Book();
        model.setTitle(dto.getTitle());
        model.setEdition(dto.getEdition());
        model.setPrice(dto.getPrice());
        model.setQuantity(dto.getQuantity());
        model.setCategoryId((dto.getCategoryId()));
        return model;
    }

    private BookDto model2Dto(Book model) {
        if(model == null) return null;
        BookDto dto = new BookDto();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setEdition(model.getEdition());
        dto.setPrice(model.getPrice());
        dto.setQuantity(model.getQuantity());
        dto.setCategoryId((model.getCategoryId()));

        List<String> authors = new ArrayList<>();
        List<Own> ownList = ownService.getOwnByBookId(model.getId());
        for (Own own : ownList) {
            authors.add(authorService.getAuthorById(own.getAuthorId()).getName());
        }
        dto.setAuthors(authors);
        return dto;
    }

    private List<Book> addModelList(List<BookDto> dtoList) {
        List<Book> modelList = new ArrayList<>();
        for (BookDto m : dtoList) {
            modelList.add(dto2Model(m));
        }
        return modelList;
    }

    private List<BookDto> addDtoList(List<Book> modelList) {
        List<BookDto> dtoList = new ArrayList<>();
        for (Book m : modelList) {
            dtoList.add(model2Dto(m));
        }
        return dtoList;
    }

}
