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
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/")
    BookEntity createBook(@RequestBody CreateBookDto dto) throws Exception {
        return bookService.createBook(dto);
    }

    @GetMapping("/")
    List<BookEntity> getAllBookPaginated() {
        return bookService.getAllBookPaginated();
    }

    @GetMapping("/{id}")
    BookEntity getOneBookById(@PathVariable("id") UUID id) throws Exception {
        return bookService.getOneBookById(id);
    }

    @PatchMapping("/{id}")
    BookEntity updateOneBookById(@PathVariable("id") UUID id, @RequestBody UpdateBookDto dto) throws Exception {
        return bookService.updateOneBookById(id, dto);
    }

    @DeleteMapping("/{id}")
    BookEntity deleteOneBookById(@PathVariable("id") UUID id) throws Exception {
        return bookService.deleteOneBookById(id);
    }

    @PostMapping("/borrow")
    BorrowBookResponse borrowBook(@RequestBody BorrowBookDto dto) throws Exception {
        return bookService.borrowBook(dto);
    }

    @GetMapping("/borrow/{borrowerId}")
    List<BookEntity> getAllBookPaginatedByBorrowerId(@PathVariable("borrowerId") UUID borrowerId) throws Exception {
        return bookService.getAllBookPaginatedByBorrowerId(borrowerId);
    }
}
