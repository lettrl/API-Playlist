package Spring_Playlist.ProjetoFinal_API.repository;

import Spring_Playlist.ProjetoFinal_API.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
