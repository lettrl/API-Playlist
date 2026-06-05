package Spring_Playlist.ProjetoFinal_API.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MusicRequestDTO(
        @NotBlank(message = "O título da música é obrigatório.")
        String title,
        @NotBlank(message = "O artista ou banda é obrigatório.")
        String artist,
        String genre,
        @NotNull(message = "A duração é obrigatória.")
        @Positive(message = "A duração deve ser em segundos e maior que zero.")
        Integer duration,
        @NotNull(message = "O ID da playlist associada é obrigatório.")
        Long playlistId
) {}