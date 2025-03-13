package lt.techin.skelbimai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lt.techin.skelbimai.model.Role;
import java.util.Set;

public record UserRequestDTO(
        @NotBlank
        @Size(min = 2, message = "Username must be at least 4 characters long and contain only lowercase letters and numbers.")
        String username,

        @NotBlank
        @Size(min = 2, message = "Password must be at least 6 characters long.")
        String password,

        @NotBlank
        Set<Role> roles) {
}