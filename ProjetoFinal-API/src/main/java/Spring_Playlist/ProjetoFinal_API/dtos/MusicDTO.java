package Spring_Playlist.ProjetoFinal_API.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MusicDTO(
        Long id,

        @NotBlank(message = "Título é obrigatório")
        String title,

        @NotBlank(message = "Artista é obrigatório")
        String artist,

        String genre,

        @NotNull(message = "Duração é obrigatória")
        @Positive(message = "Duração deve ser maior que 0")
        Integer duration,

        @NotNull(message = "ID da playlist é obrigatório")
        Long playlistId
) { }