package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateBookDto {
    @NotBlank(message = "category_id is required")
    @NotNull(message = "category_id is required")
    @JsonProperty("category_id")
    private UUID categoryId;

    @NotBlank(message = "name is required")
    @NotNull(message = "name is required")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "author is required")
    @NotNull(message = "author is required")
    @JsonProperty("author")
    private String author;

    @NotBlank(message = "publication_date is required")
    @NotNull(message = "publication_date is required")
    @JsonProperty("publication_date")
    private Date publicationDate;
}
