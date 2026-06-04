package Spring_Playlist.ProjetoFinal_API.dtos;
import jakarta.validation.constraints.NotBlank;

public record PlaylistDTO (
        Long id,

    @NotBlank(message="Nome obrigatorio")
    String name,

    String description
){}
