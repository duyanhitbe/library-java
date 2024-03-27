package doba.app.library.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.enums.UserRole;
import doba.app.library.validations.NullOrNotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    @NullOrNotEmpty(message = "username is required")
    @JsonProperty("username")
    String username;

    @NullOrNotEmpty(message = "role is required")
    @JsonProperty("role")
    UserRole role;
}
