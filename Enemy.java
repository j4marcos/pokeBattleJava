import java.util.ArrayList;

public class Enemy {
    private final int NUM_INIMIGOS = 3;
    public static ArrayList<Pokemon> inimigos = new ArrayList<>();
    public static Pokemon inimigoAtual;

    public Enemy() {
        geraInimigos();
        inimigoAtual = getInimigo(0);
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

    public void atacar() {
        Player.pokemonSelecionado.setVida(Player.pokemonSelecionado.getVida() - 10);
        System.out.println("O pokemon inimigo atacou o " + Player.pokemonSelecionado.getNome() + " e causou 10 de dano");
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