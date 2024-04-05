public class playlist extends Spotify {
    protected String descricao;
    protected int numeroDeMusicas;

    // Constructor
    public playlist(String artista, String albumOrSingle, String duracao, String genero, int numeroDeMusicas, String local, String data, int artistaMerchSpotify, String descricao, int numeroDeMusicasPlaylist) {
        super(artista, albumOrSingle, duracao, data, artistaMerchSpotify, descricao);
        this.descricao = descricao;
        this.numeroDeMusicas = numeroDeMusicasPlaylist;
    }

    /* Getters and Setters */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroDeMusicasPlaylist() {
        return numeroDeMusicas;
    }

    public void setNumeroDeMusicasPlaylist(int numeroDeMusicasPlaylist) {
        this.numeroDeMusicas = numeroDeMusicasPlaylist;
    }
}
