import java.util.ArrayList;
import javax.swing.*;

public class Enemy {
    private final int NUM_INIMIGOS = 3;
    public static ArrayList<Pokemon> inimigos = new ArrayList<>();
    public static Pokemon inimigoAtual;
    public static InterfaceCaixa painel;

    public Enemy() {
        geraInimigos();
        inimigoAtual = getInimigo(0);
    }

    public static void setInterfaceCaixa(InterfaceCaixa painel) {
        Player.painel = painel; // Adicione este método
    }

    public static Pokemon getInimigo(int i) {
        return inimigos.get(i);
    }

    private void geraInimigos() {
        String[] nomesPokemons = {"Pidgey", "Rattata", "Caterpie"};

        for (int i = 0; i < NUM_INIMIGOS; i++) {
            Pokemon pokemon = new Pokemon(nomesPokemons[i], "front");
            inimigos.add(pokemon);
        }
    }

    public static void atacar() {
        Player.pokemonSelecionado.setVida(Player.pokemonSelecionado.getVida() - 10);
        System.out.println("O pokemon inimigo atacou o " + Player.pokemonSelecionado.getNome() + " e causou 10 de dano");
        if(Player.pokemonSelecionado.getVida() <= 0) {
            System.out.println("O pokemon do player foi derrotado");
            painel.mostrarDerrotaPlayer();
            Timer timer = new Timer(3000, e -> {
                PokemonsBatle.instance.atualizarVidaPlayer();
            });
            timer.setRepeats(false);
            timer.start();
        }
        PokemonsBatle.instance.atualizarVidaPlayer();
    }

    public static void trocarInimigo() {
        
        if (inimigoAtual == getInimigo(0)){
            inimigoAtual = getInimigo(1);
        } else if (inimigoAtual == getInimigo(1)){
            inimigoAtual = getInimigo(2);
        } else {
            System.out.println("Todos os inimigos foram derrotados");
        }

        System.out.println("trocando inimigo");
    }
}