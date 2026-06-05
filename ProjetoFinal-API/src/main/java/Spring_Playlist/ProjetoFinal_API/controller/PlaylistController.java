package Spring_Playlist.ProjetoFinal_API.controller;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistResponseDTO;
import Spring_Playlist.ProjetoFinal_API.service.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Page<PlaylistResponseDTO>> listarTodas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(playlistService.listarTodas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlaylistResponseDTO> salvar(@RequestBody @Valid PlaylistRequestDTO dto) {
        return ResponseEntity.status(201).body(playlistService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PlaylistRequestDTO dto) {
        return ResponseEntity.ok(playlistService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        playlistService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}