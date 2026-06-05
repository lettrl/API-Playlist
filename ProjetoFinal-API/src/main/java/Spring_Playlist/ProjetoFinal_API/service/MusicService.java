package Spring_Playlist.ProjetoFinal_API.service;

import Spring_Playlist.ProjetoFinal_API.dtos.MusicRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.MusicResponseDTO;
import Spring_Playlist.ProjetoFinal_API.exception.ResourceNotFoundException;
import Spring_Playlist.ProjetoFinal_API.model.Music;
import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import Spring_Playlist.ProjetoFinal_API.repository.MusicRepository;
import Spring_Playlist.ProjetoFinal_API.repository.PlaylistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MusicResponseDTO salvar(MusicRequestDTO dto) {
        Playlist playlist = playlistRepository.findById(dto.playlistId())
                .orElseThrow(() -> new ResourceNotFoundException("Playlist não encontrada com o ID: " + dto.playlistId()));
        Music music = modelMapper.map(dto, Music.class);
        music.setId(null);
        music.setPlaylist(playlist);
        Music musicSalva = musicRepository.save(music);
        return new MusicResponseDTO(musicSalva.getId(), musicSalva.getTitle(), musicSalva.getArtist(), musicSalva.getGenre(), musicSalva.getDuration(), playlist.getId());
    }
    public Page<MusicResponseDTO> listarTodas(Pageable pageable) {
        return musicRepository.findAll(pageable)
                .map(m -> new MusicResponseDTO(m.getId(), m.getTitle(), m.getArtist(), m.getGenre(), m.getDuration(), m.getPlaylist().getId()));
    }
    public MusicResponseDTO buscarPorId(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com o ID: " + id));
        return new MusicResponseDTO(music.getId(), music.getTitle(), music.getArtist(), music.getGenre(), music.getDuration(), music.getPlaylist().getId());
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

        Music musicAtualizada = musicRepository.save(music);
        return new MusicResponseDTO(musicAtualizada.getId(), musicAtualizada.getTitle(), musicAtualizada.getArtist(), musicAtualizada.getGenre(), musicAtualizada.getDuration(), playlist.getId());
    }
    public void deletar(Long id) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com o ID: " + id));
        musicRepository.delete(music);
    }
}