package Spring_Playlist.ProjetoFinal_API.dtos;
import jakarta.validation.constraints.NotBlank;

public class PlaylistDTO {

    private Long id;

    @NotBlank(message="Nome obrigatorio")
    String name;

    String description;

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description; }
}
