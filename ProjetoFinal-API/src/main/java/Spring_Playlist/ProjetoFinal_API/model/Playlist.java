package Spring_Playlist.ProjetoFinal_API.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Music> musics = new ArrayList<>();

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name){this.name=name;}

    public String getDescription(){return description;}

    public void setDescription(String description) {this.description = description;}

    public List<Music> getMusics() {return musics;}

    public void setMusics(List<Music> musics) {this.musics = musics;}
}

