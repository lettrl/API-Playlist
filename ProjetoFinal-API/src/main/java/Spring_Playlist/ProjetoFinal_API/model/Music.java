package Spring_Playlist.ProjetoFinal_API.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "musics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Music {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 255, nullable = false)
        private String title;

        @Column(length = 255, nullable = false)
        private String artist;

        @Column(length = 255)
        private String genre;

        @Column(nullable = false)
        private Integer duration;

        @ManyToOne
        @JoinColumn(name = "playlist_id")
        private Playlist playlist;

}
