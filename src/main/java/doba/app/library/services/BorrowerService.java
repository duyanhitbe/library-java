package doba.app.library.services;

import doba.app.library.entities.BorrowerEntity;
import doba.app.library.repositories.BookRepository;
import doba.app.library.repositories.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BorrowerService {
    final BorrowerRepository borrowerRepository;
    final BookRepository bookRepository;

    public List<BorrowerEntity> getAllBorrowerPaginatedByBookId(UUID bookId) throws Exception {
        return bookRepository
                .findById(bookId)
                .orElseThrow(() -> new Exception("Book not found"))
                .getBorrowers();
    }
}
