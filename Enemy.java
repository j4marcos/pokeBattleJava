import java.util.ArrayList;

public class Enemy {
    
    final int NUM_INIMIGOS = 3;
    static ArrayList<Pokemon> inimigos = new ArrayList<>();
    static Pokemon inimigoAtual;

    public Enemy() {
        geraInimigos();
        inimigoAtual = getInimigo(0);
    }

    public static Pokemon getInimigo(int i) {
        return inimigos.get(i);
    }

    public void geraInimigos() {

        String[] nomesPokemons = {"MEWTWO", "SNORLAX", "GYARADOS"};

        for (int i = 0; i < NUM_INIMIGOS; i++) {
            Pokemon pokemon = new Pokemon(nomesPokemons[i], 30, "front");

            inimigos.add(pokemon);
        }
    }

    public void atacar() {
        Player.pokemonSelecionado.vida -= 10;
        System.out.println("O pokemon inimigo atacou o " + Player.pokemonSelecionado.nome + " e causou 10 de dano");
    }

    public static void trocarInimigo() {
        if (inimigoAtual.vida <= 0) {
            if (inimigoAtual == getInimigo(0)){
                inimigoAtual = getInimigo(1);
            } else if (inimigoAtual == getInimigo(1)){
                inimigoAtual = getInimigo(2);
            } else {
                System.out.println("Todos os inimigos foram derrotados");
            }
        }

        System.out.println("trocando inimigo");
    }
}