package Spring_Playlist.ProjetoFinal_API.exception;

import java.time.Instant;

public record CustomError(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
) {}