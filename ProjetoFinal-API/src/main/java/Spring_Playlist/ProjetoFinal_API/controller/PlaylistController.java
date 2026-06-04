package Spring_Playlist.ProjetoFinal_API.controller;

import Spring_Playlist.ProjetoFinal_API.dtos.PlaylistDTO;
import Spring_Playlist.ProjetoFinal_API.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

   @GetMapping("/{id}")
    public ResponseEntity<PlaylistDTO> buscarPorId(@PathVariable Long id){
       PlaylistDTO dto = playlistService.buscarPorId(id);
       return ResponseEntity.ok(dto);
   }
   @PostMapping
    public ResponseEntity<PlaylistDTO> salvar(@RequestBody PlaylistDTO dto){
       PlaylistDTO playlistSalva = playlistService.salvar(dto);
       return ResponseEntity.status(201).body(playlistSalva);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
       playlistService.deletar(id);
       return ResponseEntity.noContent().build();
   }
}