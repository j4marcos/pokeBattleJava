import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Enemy {
    public static ArrayList<Pokemon> inimigos = new ArrayList<>();
    public static Pokemon inimigoAtual;
    public static InterfaceCaixa painel;
    public static Game frame;
    private static int numeroDeInimigo;

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
        ArrayList<String> tempArray = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pokemonhp.csv"))) {
            String line = "";
            
            // Ignorando o inicio do arquivo CSV
            for(int i = 0; i < 10; i++) {
                br.readLine();
            }

            while ((line = br.readLine()) != null) {
                String[] pokemonInfo = line.split(",");
                String nomePokemon = pokemonInfo[0];
                tempArray.add(nomePokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] nomesPokemons = tempArray.toArray(new String[0]);
        numeroDeInimigo = nomesPokemons.length;

        // System.out.println("array original");
        // for (String string : nomesPokemons) {
        //     System.out.println(string);
        // }

        // embaralha os nomes dos inimigos garantinto que sejam sempre diferentes
        for(int i = 0; i < nomesPokemons.length; i++) {
            int randomIndex = (int) (Math.random() * nomesPokemons.length);

            String temp = nomesPokemons[i];
            nomesPokemons[i] = nomesPokemons[randomIndex];
            nomesPokemons[randomIndex] = temp;
        }

        // System.out.println("\narray embaralhado");
        // for (String string : nomesPokemons) {
        //     System.out.println(string);
        // }

        for (int i = 0; i < nomesPokemons.length; i++) {
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
            Timer timer = new Timer(1000, e -> {
                
                try {
                    PokemonsBatle.instance.atualizarVidaPlayer();
                    Player.resultado = false;
                    Thread.sleep(1000);
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
        for(int i = 0; i < numeroDeInimigo - 1; i++) {
            if(inimigoAtual == getInimigo(i)) {
                inimigoAtual = getInimigo(i + 1);
                System.out.println("inimigo trocado");
                break;
            }
        }

        System.out.println("Todos os inimigos foram derrotados");
    }
}