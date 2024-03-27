package doba.app.library.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {
    @NotBlank(message = "name is required")
    private String name;
}
