package lt.techin.skelbimai.dto;

import java.time.LocalDate;

public record SkelbimaiResponseDTO(Long id,
                                   String name,
                                   LocalDate calendarDate,
                                   String location,
                                   Integer maxParticipants) {
}