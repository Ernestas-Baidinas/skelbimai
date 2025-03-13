package lt.techin.skelbimai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record SkelbimaiRequestDTO(
        @NotBlank
        @Size(min = 5, message = "Event name must be at least 5 characters long.")
        String name,

        @NotNull(message = "Calendar date cannot be null.")
        LocalDate calendarDate,

        @NotBlank(message = "Location cannot be blank.")
        String location,

        @NotNull(message = "Max participants cannot be null")
        Integer maxParticipants) {
}