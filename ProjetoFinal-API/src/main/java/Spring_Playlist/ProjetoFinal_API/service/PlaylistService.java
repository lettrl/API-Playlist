package Spring_Playlist.ProjetoFinal_API.service;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistDTO;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import Spring_Playlist.ProjetoFinal_API.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public PlaylistDTO buscarPorId(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));
        return new PlaylistDTO(playlist.getId(), playlist.getName(), playlist.getDescription());
    }

    public PlaylistDTO salvar(PlaylistDTO dto) {
        Playlist playlist = new Playlist();
        playlist.setName(dto.name());
        playlist.setDescription(dto.description());

        Playlist playlistSalva = playlistRepository.save(playlist);
        return new PlaylistDTO(playlistSalva.getId(), playlistSalva.getName(), playlistSalva.getDescription());
    }
    public void deletar(Long id) {
        playlistRepository.deleteById(id);
    }
}