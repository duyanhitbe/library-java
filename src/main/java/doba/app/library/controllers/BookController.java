package doba.app.library.controllers;

import doba.app.library.dto.book.BorrowBookDto;
import doba.app.library.dto.book.BorrowBookResponse;
import doba.app.library.dto.book.CreateBookDto;
import doba.app.library.dto.book.UpdateBookDto;
import doba.app.library.entities.BookEntity;
import doba.app.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

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

    @PostMapping("/v1/book/borrow")
    BorrowBookResponse borrowBook(@RequestBody BorrowBookDto dto) throws Exception {
        return bookService.borrowBook(dto);
    }

    @GetMapping("/v1/book/borrow/{borrowerId}")
    List<BookEntity> getAllBookPaginatedByBorrowerId(@PathVariable("borrowerId") UUID borrowerId) throws Exception {
        return bookService.getAllBookPaginatedByBorrowerId(borrowerId);
    }
}
