package doba.app.library.services;

import doba.app.library.dto.book.BorrowBookDto;
import doba.app.library.dto.book.BorrowBookResponse;
import doba.app.library.dto.book.CreateBookDto;
import doba.app.library.dto.book.UpdateBookDto;
import doba.app.library.entities.BookEntity;
import doba.app.library.entities.BookInfoEntity;
import doba.app.library.entities.BorrowerEntity;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.repositories.BookInfoRepository;
import doba.app.library.repositories.BookRepository;
import doba.app.library.repositories.BorrowerRepository;
import doba.app.library.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookInfoRepository bookInfoRepository;
    private final BorrowerRepository borrowerRepository;

    //Get list of books with pagination
    public List<BookEntity> getAllBookPaginated() {
        return bookRepository.findAll();
    }

    //Get one book by id
    public BookEntity getOneBookById(UUID id) throws Exception {
        return bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book not found"));
    }

    //Create a new book
    public BookEntity createBook(CreateBookDto dto) throws Exception {
        CategoryEntity category = categoryRepository
                .findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));
        BookInfoEntity bookInfo = BookInfoEntity
                .builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .publicationDate(dto.getPublicationDate())
                .build();
        BookInfoEntity newBookInfo = bookInfoRepository.save(bookInfo);
        BookEntity book = BookEntity
                .builder()
                .categoryId(category.getId())
                .bookInfoId(newBookInfo.getId())
                .build();
        return bookRepository.save(book);
    }

    //Update one book by id
    public BookEntity updateOneBookById(UUID id, UpdateBookDto dto) throws Exception {
        BookEntity book = this.getOneBookById(id);
        BookInfoEntity bookInfo = book.getBookInfo();

        UUID categoryId = dto.getCategoryId();
        String name = dto.getName();
        String author = dto.getAuthor();
        Date publicationDate = dto.getPublicationDate();

        UUID updatedCategoryId = categoryId != null ? categoryId : book.getCategoryId();
        String updatedName = name != null ? name : bookInfo.getName();
        String updatedAuthor = author != null ? author : bookInfo.getAuthor();
        Date updatedPublicationDate = publicationDate != null ? publicationDate : bookInfo.getPublicationDate();

        book.setCategoryId(updatedCategoryId);
        bookInfo.setName(updatedName);
        bookInfo.setAuthor(updatedAuthor);
        bookInfo.setPublicationDate(updatedPublicationDate);

        bookInfoRepository.save(bookInfo);
        return bookRepository.save(book);
    }

    //Delete one book by id
    public BookEntity deleteOneBookById(UUID id) throws Exception {
        BookEntity book = this.getOneBookById(id);
        bookRepository.delete(book);
        return book;
    }

    //Borrow a book
    public BorrowBookResponse borrowBook(BorrowBookDto dto) throws Exception {
        BookEntity book = this.getOneBookById(dto.getBookId());

        BorrowerEntity borrower = borrowerRepository.findByPhone(dto.getPhone()).orElse(null);
        if (borrower == null) {
            borrower = new BorrowerEntity(dto.getName(), dto.getPhone(), dto.getAddress());
        } else {
            borrower.setName(dto.getName());
            borrower.setPhone(dto.getPhone());
            borrower.setAddress(dto.getAddress());
        }
        borrowerRepository.save(borrower);

        book.getBorrowers().add(borrower);
        bookRepository.save(book);

        return BorrowBookResponse
                .builder()
                .book(book)
                .borrower(borrower)
                .build();
    }

    public List<BookEntity> getAllBookPaginatedByBorrowerId(UUID borrowerId) throws Exception {
        return borrowerRepository
                .findById(borrowerId)
                .orElseThrow(() -> new Exception("Borrower not found"))
                .getBooks();
    }
}
