package josh.personal.theatre.models;

import lombok.Builder;

@Builder
public record Movie(
        String id,
        String userId,
        String name,
        String genre,
        String director,
        String timestamp) {
}
