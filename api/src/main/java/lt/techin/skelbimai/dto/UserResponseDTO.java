package lt.techin.skelbimai.dto;

import lt.techin.skelbimai.model.Role;
import java.util.Set;

public record UserResponseDTO(Long id,
                              String username,
                              Set<Role> roles) {
}