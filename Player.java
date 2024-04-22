import javax.swing.*;

public class Player {
    private String pokemonNome;
    public static Pokemon pokemonSelecionado;
    public static String nome;
    public static String tipoPersonagem = "boy";
    public static InterfaceCaixa painel;

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
    public static void setInterfaceCaixa(InterfaceCaixa painel) {
        Player.painel = painel; // Adicione este método
    }

    public static void atacar() {
        Enemy.inimigoAtual.setVida(Enemy.inimigoAtual.getVida() - 10);
        System.out.println("O pokemon do player atacou o pokemon inimigo e causou 10 de dano");
        if (Enemy.inimigoAtual.getVida() <= 0) {
            System.out.println("O pokemon inimigo foi derrotado");
            painel.mostrarDerrotaInimigo();
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

    public void curar() {
        pokemonSelecionado.setVida(pokemonSelecionado.getVida() + 10);
        System.out.println("O pokemon do player foi curado e recuperou 10 de vida");
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