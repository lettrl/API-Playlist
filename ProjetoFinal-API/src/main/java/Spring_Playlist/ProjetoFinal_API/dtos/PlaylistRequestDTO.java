package Spring_Playlist.ProjetoFinal_API.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlaylistRequestDTO(
        @NotBlank(message = "O nome da playlist é obrigatório.")
        String name,
        String description
) {}