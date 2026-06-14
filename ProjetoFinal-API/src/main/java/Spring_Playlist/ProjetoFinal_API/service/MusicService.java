package Spring_Playlist.ProjetoFinal_API.service;

import Spring_Playlist.ProjetoFinal_API.dtos.MusicRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.MusicResponseDTO;
import Spring_Playlist.ProjetoFinal_API.exception.ResourceNotFoundException;
import Spring_Playlist.ProjetoFinal_API.mapper.MusicMapper;
import Spring_Playlist.ProjetoFinal_API.model.Music;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import Spring_Playlist.ProjetoFinal_API.repository.MusicRepository;
import Spring_Playlist.ProjetoFinal_API.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final PlaylistRepository playlistRepository;
    private final MusicMapper musicMapper;

    public MusicResponseDTO salvar(MusicRequestDTO dto) {
        Playlist playlist = playlistRepository.findById(dto.playlistId())
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + dto.playlistId()));
        Music music = musicMapper.toEntity(dto);
        music.setId(null);
        music.setPlaylist(playlist);
        Music newMusic = musicRepository.save(music);
        return musicMapper.toResponse(newMusic);
    }

    public Page<MusicResponseDTO> listarTodas(Pageable pageable) {
        return musicRepository.findAll(pageable).map(m -> musicMapper.toResponse(m));
    }

    public MusicResponseDTO buscarPorId(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com o ID: " + id));
        return musicMapper.toResponse(music);
    }

    public MusicResponseDTO atualizar(Long id, MusicRequestDTO dto) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com o ID: " + id));

        Playlist playlist = playlistRepository.findById(dto.playlistId())
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + dto.playlistId()));
        music.setTitle(dto.title());
        music.setArtist(dto.artist());
        music.setGenre(dto.genre());
        music.setDuration(dto.duration());
        music.setPlaylist(playlist);

        Music updateMusic = musicRepository.save(music);
        return musicMapper.toResponse(updateMusic);
    }

    public void deletar(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com o ID: " + id));
        musicRepository.delete(music);
    }
}