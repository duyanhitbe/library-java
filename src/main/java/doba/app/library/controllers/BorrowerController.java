package doba.app.library.controllers;

import doba.app.library.entities.BorrowerEntity;
import doba.app.library.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/borrower")
public class BorrowerController {
    final BorrowerService borrowerService;

    @GetMapping("/book/{bookId}")
    List<BorrowerEntity> getAllBookPaginatedByBorrowerId(@PathVariable("bookId") UUID bookId) throws Exception {
        return borrowerService.getAllBorrowerPaginatedByBookId(bookId);
    }
}
