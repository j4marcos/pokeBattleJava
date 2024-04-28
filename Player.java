import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable  {
    private static final long serialVersionUID = 1L;
    public static String pokemonNome;
    public static Pokemon pokemonSelecionado;
    public static String nome;
    public static String tipoPersonagem = "boy";
    public static InterfaceCaixa painel;
    public static Game frame;
    public static boolean resultado;
    public static int ataqueValue = 15;

    public Player(String pokemon, Game frame) {
        Player.pokemonNome = pokemon; 
        Player.frame = frame;
        pokemonSelecionado = new Pokemon(pokemon,  "back");
    }

    public String getPokemonNome(){
        return pokemonNome;
    }
    public void setPokemonNome(String pokemonNome){
        Player.pokemonNome = pokemonNome;
    }
    public static void setInterfaceCaixa(InterfaceCaixa painel) {
        Player.painel = painel; // Adicione este método
    }

    public static void atacar() {
        Enemy.inimigoAtual.setVida(Enemy.inimigoAtual.getVida() - ataqueValue);
        System.out.println("O pokemon do player atacou o pokemon inimigo e causou " + ataqueValue + " de dano");
        if (Enemy.inimigoAtual.getVida() <= 0) {
            System.out.println("O pokemon inimigo foi derrotado");
            painel.mostrarDerrotaInimigo();
            Timer timer = new Timer(1000, e -> { 
                
                Enemy.trocarInimigo();
                PokemonsBatle.instance.atualizarInimigo();
                PokemonsBatle.instance.atualizarVidaInimigo(); 
             pokemonSelecionado.evoluir(PokemonsBatle.playerLv, frame);
            });
            timer.setRepeats(false);
            timer.start();
        }
        PokemonsBatle.instance.atualizarVidaInimigo(); 
    }

    public static void curar(String curaValor) {
        pokemonSelecionado.setVida(pokemonSelecionado.getVida() + Integer.parseInt(curaValor));

        if (pokemonSelecionado.getVida() > pokemonSelecionado.getVidaMaxima()) {
            pokemonSelecionado.setVida(pokemonSelecionado.getVidaMaxima());
        }

        System.out.println("O pokemon do player foi curado e recuperou " + curaValor + " de vida");
        PokemonsBatle.instance.atualizarVidaPlayer();
    }

    public static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player_data.dat"))) {
            oos.writeObject(pokemonNome);
            oos.writeObject(pokemonSelecionado);
            oos.writeObject(nome);
            oos.writeObject(tipoPersonagem);
            oos.writeObject(frame);
            oos.writeObject(ataqueValue);
            oos.writeObject(Enemy.inimigoAtual);
            oos.writeObject(Enemy.inimigos);
            oos.writeObject(PokemonsBatle.inimigoLv);
            oos.writeObject(PokemonsBatle.playerLv);
            
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean carregarDados() {
        File file = new File("player_data.dat");
        if (!file.exists()) {
            System.out.println("Nenhum save do jogo encontrado.");
            return false;
        }
    
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            pokemonNome = (String) ois.readObject();
            pokemonSelecionado = (Pokemon) ois.readObject();
            nome = (String) ois.readObject();
            tipoPersonagem = (String) ois.readObject();
            frame = (Game) ois.readObject();
            ataqueValue = (int) ois.readObject();
            Enemy.inimigoAtual = (Pokemon) ois.readObject();
            Enemy.inimigos = (ArrayList<Pokemon>) ois.readObject();
            PokemonsBatle.inimigoLv = (int) ois.readObject();
            PokemonsBatle.playerLv = (int) ois.readObject();
    
            System.out.println("Dados carregados com sucesso!");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return false;
        }
    }
    
    public static int getAlturaPokemon() {
        switch (pokemonSelecionado.getNome()) {
            case "Bulbasaur":
                return 256; 
            case "Ivysaur":
                return 232; 
            case "Venusaur": 
                return 232; 
            case "Squirtle":
                return 252; 
            case "Wartortle":
                return 232;
            case "Blastoise":
                return 232; 
            case "Charmander":
                return 232; 
            case "Charmeleon":
                return 220; 
            case "Charizard":
                return 208; 
            default:
                return 256;
        }
    }
}