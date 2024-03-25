package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.validations.NullOrNotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookDto {
    @NullOrNotEmpty(message = "category_id is required")
    @JsonProperty("category_id")
    private UUID categoryId;

    @NullOrNotEmpty(message = "name is required")
    @JsonProperty("name")
    private String name;

    @NullOrNotEmpty(message = "author is required")
    @JsonProperty("author")
    private String author;

    @NullOrNotEmpty(message = "publication_date is required")
    @JsonProperty("publication_date")
    private Date publicationDate;
}
