package Spring_Playlist.ProjetoFinal_API.service;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistResponseDTO;
import Spring_Playlist.ProjetoFinal_API.exception.ResourceNotFoundException;
import Spring_Playlist.ProjetoFinal_API.mapper.PlaylistMapper;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import Spring_Playlist.ProjetoFinal_API.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;

    public PlaylistResponseDTO salvar(PlaylistRequestDTO dto) {
        Playlist playlist = playlistMapper.toEntity(dto);
        Playlist playlistSalva = playlistRepository.save(playlist);
        return playlistMapper.toResponse(playlistSalva);
    }

    public PlaylistResponseDTO buscarPorId(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));
        return playlistMapper.toResponse(playlist);
    }

    public Page<PlaylistResponseDTO> listarTodas(Pageable pageable) {
        return playlistRepository.findAll(pageable).map(p -> playlistMapper.toResponse(p));
    }

    public PlaylistResponseDTO atualizar(Long id, PlaylistRequestDTO dto) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));

        playlist.setName(dto.name());
        playlist.setDescription(dto.description());

        Playlist playlistAtualizada = playlistRepository.save(playlist);
        return playlistMapper.toResponse(playlistAtualizada);
    }

    public void deletar(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + id));
        playlistRepository.delete(playlist);
    }
}