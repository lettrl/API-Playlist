package Spring_Playlist.ProjetoFinal_API.model;
import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String artist;

        private String genre;

        private Integer duration;

        @ManyToOne
        @JoinColumn(name = "playlist_id")
        private Playlist playlist;

        public Long getId(){return id;}
        public void setId(Long id) {this.id = id;}

        public String getTitle(){return title;}
        public void setTitle(String title) {this.title = title;}

        public String getArtist(){return artist;}
        public void setArtist(String artist) {this.artist = artist;}

        public String getGenre(){return genre;}
        public void setGenre(String genre){this.genre = genre;}

        public Integer getDuration(){return duration;}
        public void setDuration(Integer duration) {this.duration = duration; }

        public Playlist getPlaylist(){return playlist;}
        public void setPlaylist(Playlist playlist){this.playlist = playlist; }
}
