package Spring_Playlist.ProjetoFinal_API.dtos;

public record MusicResponseDTO(
        Long id,
        String title,
        String artist,
        String genre,
        Integer duration,
        Long playlistId
) {}