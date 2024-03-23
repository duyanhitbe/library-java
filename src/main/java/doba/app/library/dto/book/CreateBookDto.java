package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
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
public class CreateBookDto {
    @NotBlank(message = "category_id is required")
    @JsonProperty("category_id")
    private UUID categoryId;

    @NotBlank(message = "name is required")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "author is required")
    @JsonProperty("author")
    private String author;

    @NotBlank(message = "publication_date is required")
    @JsonProperty("publication_date")
    private Date publicationDate;
}
