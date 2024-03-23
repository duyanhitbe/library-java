package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.validations.NullOrNotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
