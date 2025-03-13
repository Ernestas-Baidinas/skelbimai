package lt.techin.skelbimai.dto;

import jakarta.validation.constraints.NotNull;

@NotNull(message = "User cannot be null.")
public record RegistrationRequestDTO(UserDTO user) {
}