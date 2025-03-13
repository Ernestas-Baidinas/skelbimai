package lt.techin.skelbimai.dto;

import java.util.Date;

public record RegistrationResponseDTO(long id,
                                      long userId,
                                      String eventName,
                                      Date registrationDate) {
}