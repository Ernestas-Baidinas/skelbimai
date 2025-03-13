package lt.techin.skelbimai.dto;

public record MessageResponse(String message) {

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}