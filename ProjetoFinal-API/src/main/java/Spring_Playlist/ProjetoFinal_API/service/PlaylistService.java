package Spring_Playlist.ProjetoFinal_API.service;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistResponseDTO;
import Spring_Playlist.ProjetoFinal_API.exception.ResourceNotFoundException;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import Spring_Playlist.ProjetoFinal_API.repository.PlaylistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PlaylistResponseDTO salvar(PlaylistRequestDTO dto) {
        Playlist playlist = modelMapper.map(dto, Playlist.class);
        Playlist playlistSalva = playlistRepository.save(playlist);
        return new PlaylistResponseDTO(playlistSalva.getId(), playlistSalva.getName(), playlistSalva.getDescription());
    }

    public PlaylistResponseDTO buscarPorId(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));
        return new PlaylistResponseDTO(playlist.getId(), playlist.getName(), playlist.getDescription());
    }

    public Page<PlaylistResponseDTO> listarTodas(Pageable pageable) {
        return playlistRepository.findAll(pageable)
                .map(p -> new PlaylistResponseDTO(p.getId(), p.getName(), p.getDescription()));
    }

    public PlaylistResponseDTO atualizar(Long id, PlaylistRequestDTO dto) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));

        playlist.setName(dto.name());
        playlist.setDescription(dto.description());

        Playlist playlistAtualizada = playlistRepository.save(playlist);
        return new PlaylistResponseDTO(playlistAtualizada.getId(), playlistAtualizada.getName(), playlistAtualizada.getDescription());
    }
    public void deletar(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));
        playlistRepository.delete(playlist);
    }
}