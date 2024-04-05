import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    private static final String MUSIC_FILE = "Musicas.txt";
    private static final String EVENT_FILE = "Evento.txt";
    private static final String PLAYLIST_FILE = "Playlist.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Digitar e Salvar Música");
            System.out.println("2. Digitar e Salvar Evento");
            System.out.println("3. Digitar e Salvar Playlist");
            System.out.println("4. Carregar Músicas");
            System.out.println("5. Carregar Eventos");
            System.out.println("6. Carregar Playlists");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    salvarMusica(digitarMusica());
                    break;
                case 2:
                    salvarEvento(digitarEvento());
                    break;
                case 3:
                    salvarPlaylist(digitarPlaylist());
                    break;
                case 4:
                    System.out.println(carregarMusicas());
                    break;
                case 5:
                    System.out.println(carregarEventos());
                    break;
                case 6:
                    System.out.println(carregarPlaylists());
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    public static void salvarMusica(Musica musica) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(MUSIC_FILE, true))) {
            writer.println(musica);
            System.out.println("Música salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar música: " + e.getMessage());
        }
    }

    public static void salvarEvento(Evento evento) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EVENT_FILE, true))) {
            writer.println(evento);
            System.out.println("Evento salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar evento: " + e.getMessage());
        }
    }

    public static void salvarPlaylist(Playlist playlist) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PLAYLIST_FILE, true))) {
            writer.println(playlist);
            System.out.println("Playlist salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar playlist: " + e.getMessage());
        }
    }

    public static ArrayList<Musica> carregarMusicas() {
        ArrayList<Musica> musicas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MUSIC_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] detalhes = line.split(", ");
                String artista = detalhes[0];
                String albumOrSingle = detalhes[1];
                String duracao = detalhes[2];
                musicas.add(new Musica(artista, albumOrSingle, duracao));
            }
            System.out.println("Músicas carregadas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar músicas: " + e.getMessage());
        }
        return musicas;
    }

    public static ArrayList<Evento> carregarEventos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EVENT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] detalhes = line.split(", ");
                String artista = detalhes[0];
                String local = detalhes[1];
                String data = detalhes[2];
                eventos.add(new Evento(artista, local, data));
            }
            System.out.println("Eventos carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar eventos: " + e.getMessage());
        }
        return eventos;
    }

    public static ArrayList<Playlist> carregarPlaylists() {
        ArrayList<Playlist> playlists = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PLAYLIST_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] detalhes = line.split(", ");
                String descricao = detalhes[0];
                int numeroDeMusicas = Integer.parseInt(detalhes[1]);
                playlists.add(new Playlist(descricao, numeroDeMusicas));
            }
            System.out.println("Playlists carregadas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar playlists: " + e.getMessage());
        }
        return playlists;
    }

    public static Musica digitarMusica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os detalhes da música:");
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Álbum ou Single: ");
        String albumOrSingle = scanner.nextLine();
        System.out.print("Duração: ");
        String duracao = scanner.nextLine();
        return new Musica(artista, albumOrSingle, duracao);
    }

    public static Evento digitarEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os detalhes do evento:");
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Local: ");
        String local = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        return new Evento(artista, local, data);
    }

    public static Playlist digitarPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os detalhes da playlist:");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Número de músicas: ");
        int numeroDeMusicas = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner
        return new Playlist(descricao, numeroDeMusicas);
    }

    static class Musica {
        private String artista;
        private String albumOrSingle;
        private String duracao;

        public Musica(String artista, String albumOrSingle, String duracao) {
            this.artista = artista;
            this.albumOrSingle = albumOrSingle;
            this.duracao = duracao;
        }

        @Override
        public String toString() {
            return artista + ", " + albumOrSingle + ", " + duracao;
        }
    }

    static class Evento {
        private String artista;
        private String local;
        private String data;

        public Evento(String artista, String local, String data) {
            this.artista = artista;
            this.local = local;
            this.data = data;
        }

        @Override
        public String toString() {
            return artista + ", " + local + ", " + data;
        }
    }

    static class Playlist {
        private String descricao;
        private int numeroDeMusicas;

        public Playlist(String descricao, int numeroDeMusicas) {
            this.descricao = descricao;
            this.numeroDeMusicas = numeroDeMusicas;
        }

        @Override
        public String toString() {
            return descricao + ", " + numeroDeMusicas;
        }
    }
}
