package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.entities.BookEntity;
import doba.app.library.entities.BorrowerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookResponse {
    @JsonProperty("book")
    BookEntity book;

    @JsonProperty("borrower")
    BorrowerEntity borrower;
}
