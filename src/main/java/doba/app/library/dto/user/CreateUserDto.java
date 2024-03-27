package doba.app.library.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotNull(message = "username is required")
    @NotBlank(message = "username is required")
    @JsonProperty("username")
    String username;

    @NotNull(message = "password is required")
    @NotBlank(message = "password is required")
    @JsonProperty("password")
    String password;

    @NotNull(message = "role is required")
    @NotBlank(message = "role is required")
    @JsonProperty("role")
    UserRole role;
}
