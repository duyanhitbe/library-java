package doba.app.library.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookDto {
    @JsonProperty("address")
    @NotBlank(message = "address is required")
    @NotNull(message = "address is required")
    String address;

    @JsonProperty("book_id")
    @NotBlank(message = "book_id is required")
    @NotNull(message = "book_id is required")
    UUID bookId;

    @JsonProperty("name")
    @NotBlank(message = "name is required")
    @NotNull(message = "name is required")
    String name;

    @JsonProperty("phone")
    @NotBlank(message = "phone is required")
    @NotNull(message = "phone is required")
    String phone;
}
