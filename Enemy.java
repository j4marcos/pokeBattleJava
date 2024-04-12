import java.util.ArrayList;

public class Enemy {
    
    ArrayList<Pokemon> inimigos = new ArrayList<>();
    final int NUM_INIMIGOS = 10;

    public Enemy() {
        geraInimigos();
    }

    public Pokemon getInimigo(int i) {
        return inimigos.get(i);
    }

    public void geraInimigos() {
        for (int index = 0; index < NUM_INIMIGOS; index++) {
            Pokemon pokemon = new Pokemon("Pokemon " + (index + 1), 100);
            pokemon.imagemLabel.setLocation(550, 20);
            inimigos.add(pokemon);
        }
    }
}