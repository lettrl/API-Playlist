package Spring_Playlist.ProjetoFinal_API.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MusicDTO {

    private Long id;

    @NotBlank(message = "Título é obrigatorio")
    private String title;

    @NotBlank(message = "Artista é obrigatório")
    private String artist;

    private String genre;

    @NotNull(message = "Duração é obrigatória")
    @Positive(message = "Duração deve ser maior que 0")
    private Integer duration;

    @NotNull(message = "ID é obrigatório")
    private Long playlistId;

    public Long getId() { return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title){this.title = title;}

    public String getArtist(){return artist;}
    public void setArtist(String artist){this.artist = artist;}

    public String getGenre(){return genre;}
    public void setGenre(String genre){this.genre = genre;}

    public Integer getDuration(){return duration;}
    public void setDuration(Integer duration){this.duration = duration; }

    public Long getPlaylistId(){return playlistId;}
    public void setPlaylistId(Long playlistId){this.playlistId = playlistId; }

}
