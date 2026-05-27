package Spring_Playlist.ProjetoFinal_API.repository;

import Spring_Playlist.ProjetoFinal_API.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
}
