package Spring_Playlist.ProjetoFinal_API.mapper;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistResponseDTO;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "musics", ignore = true)
    Playlist toEntity(PlaylistRequestDTO dto);
    PlaylistResponseDTO toResponse(Playlist playlist);
}