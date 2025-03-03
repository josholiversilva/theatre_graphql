package josh.personal.theatre.models;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Movie(
        UUID id,
        String name,
        String genre,
        String director,
        String timestamp,
        String user) {
}
