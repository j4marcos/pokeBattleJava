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
        for (int index = 0; index < NUM_INIMIGOS; index++) {
            Pokemon pokemon = new Pokemon("Pokemon " + (index + 1), 100,"images/charizard frente.png");
            pokemon.imagemLabel.setLocation(550, 20);
            inimigos.add(pokemon);
        }
    }

    public void atacar() {
        Player.pokemonSelecionado.vida -= 10;
        System.out.println("O pokemon inimigo atacou o " + Player.pokemonSelecionado.nome + " e causou 10 de dano");
    }

    public void trocarInimigo() {
        if (inimigoAtual.vida <= 0) {
            if (inimigoAtual == getInimigo(0)){
                inimigoAtual = getInimigo(1);
            } else if (inimigoAtual == getInimigo(1)){
                inimigoAtual = getInimigo(2);
            } else {
                System.out.println("Todos os inimigos foram derrotados");
            }
        }
    }
}