package doba.app.library.dto.category;

import doba.app.library.validations.NullOrNotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCategoryDto {
    @NullOrNotEmpty(message = "name is required")
    private String name;
}
