package Spring_Playlist.ProjetoFinal_API.controller;

import Spring_Playlist.ProjetoFinal_API.dtos.MusicRequestDTO;
import Spring_Playlist.ProjetoFinal_API.dtos.MusicResponseDTO;
import Spring_Playlist.ProjetoFinal_API.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/musics")
public class MusicController {
    @Autowired
    private MusicService musicService;
    @PostMapping
    public ResponseEntity<MusicResponseDTO> salvar(@RequestBody @Valid MusicRequestDTO dto) {
        return ResponseEntity.status(201).body(musicService.salvar(dto));
    }
    @GetMapping
    public ResponseEntity<Page<MusicResponseDTO>> listarTodas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(musicService.listarTodas(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MusicResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(musicService.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MusicResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MusicRequestDTO dto) {
        return ResponseEntity.ok(musicService.atualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        musicService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}