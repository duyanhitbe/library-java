package doba.app.library.services;

import doba.app.library.dto.book.CreateBookDto;
import doba.app.library.dto.book.UpdateBookDto;
import doba.app.library.entities.BookEntity;
import doba.app.library.entities.BookInfoEntity;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.repositories.BookInfoRepository;
import doba.app.library.repositories.BookRepository;
import doba.app.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookInfoRepository bookInfoRepository;

    @Autowired
    public BookService(
            final BookRepository bookRepository,
            final CategoryRepository categoryRepository,
            final BookInfoRepository bookInfoRepository
    ) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookInfoRepository = bookInfoRepository;
    }

    //Get list of books with pagination
    public List<BookEntity> getAllBookPaginated() {
        return bookRepository.findAll();
    }

    //Get one book by id
    public BookEntity getOneBookById(UUID id) throws Exception {
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new Exception("Book not found");
        }
        return book;
    }

    //Create a new book
    public BookEntity createBook(CreateBookDto dto) throws Exception {
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        if (category == null) {
            throw new Exception("Category not found");
        }
        BookInfoEntity bookInfo = new BookInfoEntity(dto.getName(), dto.getAuthor(), dto.getPublicationDate());
        BookInfoEntity newBookInfo = bookInfoRepository.save(bookInfo);
        BookEntity book = new BookEntity(category.getId(), newBookInfo.getId());
        return bookRepository.save(book);
    }

    //Update one book by id
    public BookEntity updateOneBookById(UUID id, UpdateBookDto dto) throws Exception {
        BookEntity book = this.getOneBookById(id);
        BookInfoEntity bookInfo = book.getBookInfo();

        UUID categoryId = dto.getCategoryId();
        if (categoryId != null) {
            book.setCategoryId(categoryId);
        }
        String name = dto.getName();
        if (name != null) {
            bookInfo.setName(name);
        }
        String author = dto.getAuthor();
        if (author != null) {
            bookInfo.setAuthor(author);
        }
        Date publicationDate = dto.getPublicationDate();
        if (publicationDate != null) {
            bookInfo.setPublicationDate(publicationDate);
        }

        bookInfoRepository.save(bookInfo);
        return bookRepository.save(book);
    }

    //Delete one book by id
    public BookEntity deleteOneBookById(UUID id) throws Exception {
        BookEntity book = this.getOneBookById(id);
        bookRepository.delete(book);
        return book;
    }
}
