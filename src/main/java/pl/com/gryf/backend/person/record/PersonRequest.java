package pl.com.gryf.backend.person.record;

public record PersonRequest(String login, String firstName, String lastName, String email) {
}
