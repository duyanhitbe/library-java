package doba.app.library.controllers;

import doba.app.library.dto.book.CreateBookDto;
import doba.app.library.dto.book.UpdateBookDto;
import doba.app.library.entities.BookEntity;
import doba.app.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/v1/book")
    BookEntity createBook(@RequestBody CreateBookDto dto) throws Exception {
        return bookService.createBook(dto);
    }

    @GetMapping("/v1/book")
    List<BookEntity> getAllBookPaginated() {
        return bookService.getAllBookPaginated();
    }

    @GetMapping("/v1/book/{id}")
    BookEntity getOneBookById(@PathVariable("id") UUID id) throws Exception {
        return bookService.getOneBookById(id);
    }

    @PatchMapping("/v1/book/{id}")
    BookEntity updateOneBookById(@PathVariable("id") UUID id, @RequestBody UpdateBookDto dto) throws Exception {
        return bookService.updateOneBookById(id, dto);
    }

    @DeleteMapping("/v1/book/{id}")
    BookEntity deleteOneBookById(@PathVariable("id") UUID id) throws Exception {
        return bookService.deleteOneBookById(id);
    }
}
