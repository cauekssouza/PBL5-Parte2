public class Spotify {
    protected String artista;
    protected String albumOrsingle;
    protected String duracao;
    protected String playlist;
    protected int artistaMerch;
    protected String evento;

    // Constructor
    public Spotify(String artista, String albumOrsingle, String duracao, String playlist, int artistaMerch, String evento){
        this.artista = artista;
        this.albumOrsingle = albumOrsingle;
        this.duracao = duracao;
        this.playlist = playlist;
        this.artistaMerch = artistaMerch;
        this.evento = evento;
    }

    /* Getters and Setters */
    public String getArtista(){
        return artista;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }
    public String getAlbumOrSingle(){
        return albumOrsingle;
    }
    public void setAlbumOrSingle(String albumOrsingle){
        this.albumOrsingle = albumOrsingle;
    }
    public String getDuracao(){
        return duracao;
    }
    public void setDuracao(String duracao){
        this.duracao = duracao;
    }
    public String getPlaylist(){
        return playlist;
    }
    public void setPlaylist(String playlist){
        this.playlist = playlist;
    }
    public int getArtistaMerch(){
        return artistaMerch;
    }
    public void setArtistaMerch(int artistaMerch){
        this.artistaMerch = artistaMerch;
    }
    public String getEvento(){
        return evento;
    }
    public void setEvento(String evento){
        this.evento = evento;
    }
}

