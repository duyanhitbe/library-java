package doba.app.library.dto.category;

import doba.app.library.validations.NullOrNotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {
    @NullOrNotEmpty(message = "name is required")
    private String name;
}
