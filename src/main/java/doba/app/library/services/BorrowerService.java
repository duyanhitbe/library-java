package doba.app.library.services;

import doba.app.library.entities.BookEntity;
import doba.app.library.entities.BorrowerEntity;
import doba.app.library.repositories.BookRepository;
import doba.app.library.repositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BorrowerService {
    final BorrowerRepository borrowerRepository;
    final BookRepository bookRepository;

    @Autowired
    public BorrowerService(
            final BorrowerRepository borrowerRepository,
            final BookRepository bookRepository
    ) {
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
    }

    public List<BorrowerEntity> getAllBorrowerPaginatedByBookId(UUID bookId) throws Exception {
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            throw new Exception("Book not found");
        }
        return book.getBorrowers();
    }
}
