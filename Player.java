import javax.swing.*;
import java.io.*;
import java.io.*;

public class Player implements Serializable  {
    public static String pokemonNome;
    public static Pokemon pokemonSelecionado;
    public static String nome;
    public static String tipoPersonagem = "boy";
    public static InterfaceCaixa painel;
    

    public Player(String pokemon) {
        this.pokemonNome = pokemon; 
        pokemonSelecionado = new Pokemon(pokemon,  "back");
    public Player(String pokemon) {
        this.pokemonNome = pokemon; 
        pokemonSelecionado = new Pokemon(pokemon,  "back");
    }

    public String getPokemonNome(){
        return pokemonNome;
    }
    public void setPokemonNome(String pokemonNome){
        this.pokemonNome = pokemonNome;
    }
    public String getPokemonNome(){
        return pokemonNome;
    }
    public void setPokemonNome(String pokemonNome){
        this.pokemonNome = pokemonNome;
    }
    public static void setInterfaceCaixa(InterfaceCaixa painel) {
        Player.painel = painel; // Adicione este método
    }

    public static void atacar() {
        Enemy.inimigoAtual.setVida(Enemy.inimigoAtual.getVida() - 10);
        Enemy.inimigoAtual.setVida(Enemy.inimigoAtual.getVida() - 10);
        System.out.println("O pokemon do player atacou o pokemon inimigo e causou 10 de dano");
        if (Enemy.inimigoAtual.getVida() <= 0) {
        if (Enemy.inimigoAtual.getVida() <= 0) {
            System.out.println("O pokemon inimigo foi derrotado");
            painel.mostrarDerrotaInimigo();
            Timer timer = new Timer(3000, e -> {
                Enemy.trocarInimigo();
                PokemonsBatle.instance.atualizarInimigo();
                PokemonsBatle.instance.atualizarVidaInimigo(); 
            Timer timer = new Timer(3000, e -> {
                Enemy.trocarInimigo();
                PokemonsBatle.instance.atualizarInimigo();
                PokemonsBatle.instance.atualizarVidaInimigo(); 
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

        System.out.println("O pokemon do player foi curado e recuperou 10 de vida");
        PokemonsBatle.instance.atualizarVidaPlayer();
    }

    public static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player_data.dat"))) {
            oos.writeObject(pokemonNome);
            oos.writeObject(pokemonSelecionado);
            oos.writeObject(nome);
            oos.writeObject(tipoPersonagem);
            oos.writeObject(painel);
            // Salvar outros atributos conforme necessário
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static boolean carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("player_data.dat"))) {
            pokemonNome = (String) ois.readObject();
            pokemonSelecionado = (Pokemon) ois.readObject();
            nome = (String) ois.readObject();
            tipoPersonagem = (String) ois.readObject();
            painel = (InterfaceCaixa) ois.readObject();
            // Carregar outros atributos conforme necessário
            System.out.println("Dados carregados com sucesso.");
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
            case "Squirtle":
                return 252;
            case "Charmander":
                return 232;
            default:
                return 256;
        }
        PokemonsBatle.instance.atualizarVidaPlayer();
    }

    public static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("player_data.dat"))) {
            oos.writeObject(pokemonNome);
            oos.writeObject(pokemonSelecionado);
            oos.writeObject(nome);
            oos.writeObject(tipoPersonagem);
            oos.writeObject(painel);
            // Salvar outros atributos conforme necessário
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static boolean carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("player_data.dat"))) {
            pokemonNome = (String) ois.readObject();
            pokemonSelecionado = (Pokemon) ois.readObject();
            nome = (String) ois.readObject();
            tipoPersonagem = (String) ois.readObject();
            painel = (InterfaceCaixa) ois.readObject();
            // Carregar outros atributos conforme necessário
            System.out.println("Dados carregados com sucesso.");
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
            case "Squirtle":
                return 252;
            case "Charmander":
                return 232;
            default:
                return 256;
        }
    }
}