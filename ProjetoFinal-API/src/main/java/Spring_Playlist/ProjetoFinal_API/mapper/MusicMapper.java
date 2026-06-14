package Spring_Playlist.ProjetoFinal_API.mapper;

import Spring_Playlist.ProjetoFinal_API.dtos.MusicRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.MusicResponseDTO;
import Spring_Playlist.ProjetoFinal_API.model.Music;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MusicMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "playlist", ignore = true)
    Music toEntity(MusicRequestDTO dto);
    @Mapping(target = "playlistId", source = "playlist.id")
    MusicResponseDTO toResponse(Music music);
}