import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Enemy {
    private final int NUM_INIMIGOS = 4;
    public static ArrayList<Pokemon> inimigos = new ArrayList<>();
    public static Pokemon inimigoAtual;
    public static InterfaceCaixa painel;
    public static Game frame;

    public Enemy() {
        geraInimigos();
        inimigoAtual = getInimigo(0);
    }

    public static void setInterfaceCaixa(InterfaceCaixa painel) {
        Enemy.painel = painel; // Adicione este método
    }

    public static void setGameFrame(Game frame) {
        Enemy.frame = frame; 
    }

    public static Pokemon getInimigo(int i) {
        return inimigos.get(i);
    }

    private void geraInimigos() {
        String[] nomesPokemons = {"Pidgey", "Rattata", "Caterpie", "Pikachu", "Spearow", "Weedle", "Nidoran_f", "Nidoran_m"};

        Random random = new Random();


        for (int i = 0; i < NUM_INIMIGOS; i++) {
            int randomIndex = random.nextInt(nomesPokemons.length);
            String randomPokemon = nomesPokemons[randomIndex];
            Pokemon pokemon = new Pokemon(randomPokemon, "front");
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
                
                try {
                    PokemonsBatle.instance.atualizarVidaPlayer();
                    Player.resultado = false;
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } 

                Final finalPanel = new Final();
                frame.mudarTela(finalPanel);
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
        } else if (inimigoAtual == getInimigo(2)){
            inimigoAtual = getInimigo(3);   
        } else {
            System.out.println("Todos os inimigos foram derrotados");

            Player.resultado = true;
            Final finalPanel = new Final();
            frame.mudarTela(finalPanel);
        }

        System.out.println("trocando inimigo");
    }
}